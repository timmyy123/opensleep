import Foundation
import Combine
import SwiftUI

enum ModelVariant: String, CaseIterable, Identifiable {
    case e2b = "gemma-4-E2B-it.litertlm"
    case e4b = "gemma-4-E4B-it.litertlm"

    var id: String { rawValue }

    var displayName: String {
        switch self {
        case .e2b: return "Gemma 4 E2B (~1.35 GB)"
        case .e4b: return "Gemma 4 E4B (~2.61 GB)"
        }
    }

    var sizeGB: Double { self == .e2b ? 1.35 : 2.61 }

    var downloadURL: URL {
        switch self {
        case .e2b:
            return URL(string: "https://huggingface.co/litert-community/gemma-4-E2B-it-litert-lm/resolve/a4a831c060880f3733135ad22f10e0e9f758f45d/gemma-4-E2B-it.litertlm")!
        case .e4b:
            return URL(string: "https://huggingface.co/litert-community/gemma-4-E4B-it-litert-lm/resolve/65ce5ba80d8790d66ef11d82d7d079a06f3fef97/gemma-4-E4B-it.litertlm")!
        }
    }
}

enum DownloadState: Equatable {
    case idle
    case downloading(progress: Double, speed: Double, downloadedBytes: Int64, totalBytes: Int64)
    case paused(progress: Double, downloadedBytes: Int64, totalBytes: Int64)
    case done
    case failed(String)
}

class ModelDownloadManager: NSObject, ObservableObject, URLSessionDownloadDelegate, @unchecked Sendable {

    @MainActor @Published var downloadStates: [ModelVariant: DownloadState] = [:]

    @AppStorage("active_model_variant") private var activeVariantId: String = ""
    var activeVariant: ModelVariant? {
        get { ModelVariant(rawValue: activeVariantId) }
        set { activeVariantId = newValue?.rawValue ?? "" }
    }

    @Published var contextWindowSizes: [ModelVariant: Int] = [:]

    private lazy var session: URLSession = {
        let config = URLSessionConfiguration.background(withIdentifier: "app.opensleep.modeldownload")
        return URLSession(configuration: config, delegate: self, delegateQueue: nil)
    }()

    private var activeTasks: [ModelVariant: URLSessionDownloadTask] = [:]
    private var variantForTask: [URLSessionTask: ModelVariant] = [:]
    private var resumeData: [ModelVariant: Data] = [:]

    private var currentProgressBytes: [ModelVariant: (downloaded: Int64, total: Int64)] = [:]
    private var previousDownloadedBytes: [ModelVariant: Int64] = [:]
    private var speedTimer: Timer?

    override init() {
        super.init()
        var states: [ModelVariant: DownloadState] = [:]
        var sizes: [ModelVariant: Int] = [:]
        for variant in ModelVariant.allCases {
            states[variant] = isDownloaded(variant) ? .done : .idle
            let size = UserDefaults.standard.integer(forKey: "context_window_size_\(variant.rawValue)")
            sizes[variant] = size == 0 ? 4096 : size
        }
        let finalStates = states
        let finalSizes = sizes
        Task { @MainActor [weak self] in
            self?.downloadStates = finalStates
            self?.contextWindowSizes = finalSizes
        }
    }

    func isDownloaded(_ variant: ModelVariant) -> Bool {
        FileManager.default.fileExists(atPath: modelPath(variant))
    }

    func modelPath(_ variant: ModelVariant) -> String {
        let dir = FileManager.default.urls(for: .documentDirectory, in: .userDomainMask)[0]
        return dir.appendingPathComponent(variant.rawValue).path
    }

    @MainActor
    func setContextWindowSize(_ size: Int, for variant: ModelVariant) {
        UserDefaults.standard.set(size, forKey: "context_window_size_\(variant.rawValue)")
        self.contextWindowSizes[variant] = size
    }

    @MainActor
    func downloadModel(_ variant: ModelVariant) {
        guard !isDownloaded(variant) else { return }
        
        let state = downloadStates[variant] ?? .idle
        if case .downloading = state { return }

        let task: URLSessionDownloadTask
        if let data = resumeData[variant] {
            task = session.downloadTask(withResumeData: data)
            resumeData.removeValue(forKey: variant)
        } else {
            task = session.downloadTask(with: variant.downloadURL)
        }

        activeTasks[variant] = task
        variantForTask[task] = variant
        task.resume()

        let progress = currentProgressBytes[variant]?.downloaded ?? 0
        let total = currentProgressBytes[variant]?.total ?? Int64(variant.sizeGB * 1024 * 1024 * 1024)
        downloadStates[variant] = .downloading(
            progress: Double(progress) / Double(total),
            speed: 0.0,
            downloadedBytes: progress,
            totalBytes: total
        )

        startSpeedTimer()
    }

    @MainActor
    func pauseModelDownload(_ variant: ModelVariant) {
        guard let task = activeTasks[variant] else { return }
        task.cancel(byProducingResumeData: { [weak self] data in
            guard let self = self, let data = data else { return }
            Task { @MainActor in
                self.resumeData[variant] = data
                let progress = self.currentProgressBytes[variant]?.downloaded ?? 0
                let total = self.currentProgressBytes[variant]?.total ?? 0
                let fraction = total > 0 ? Double(progress) / Double(total) : 0.0
                self.downloadStates[variant] = .paused(progress: fraction, downloadedBytes: progress, totalBytes: total)
            }
        })
        activeTasks.removeValue(forKey: variant)
        
        checkStopSpeedTimer()
    }

    @MainActor
    func cancelModelDownload(_ variant: ModelVariant) {
        activeTasks[variant]?.cancel()
        activeTasks.removeValue(forKey: variant)
        resumeData.removeValue(forKey: variant)
        currentProgressBytes.removeValue(forKey: variant)
        previousDownloadedBytes.removeValue(forKey: variant)
        
        downloadStates[variant] = .idle
        
        checkStopSpeedTimer()
    }

    @MainActor
    func deleteModel(_ variant: ModelVariant) {
        cancelModelDownload(variant)
        try? FileManager.default.removeItem(atPath: modelPath(variant))
        downloadStates[variant] = .idle
        if activeVariant == variant {
            activeVariant = nil
        }
    }

    // MARK: - Speed Calculations

    @MainActor
    private func startSpeedTimer() {
        guard speedTimer == nil else { return }
        speedTimer = Timer.scheduledTimer(withTimeInterval: 1.0, repeats: true) { [weak self] _ in
            Task { @MainActor [weak self] in
                self?.updateSpeeds()
            }
        }
    }

    @MainActor
    private func checkStopSpeedTimer() {
        let isAnyDownloading = downloadStates.values.contains { state in
            if case .downloading = state { return true }
            return false
        }
        if !isAnyDownloading {
            speedTimer?.invalidate()
            speedTimer = nil
        }
    }

    @MainActor
    private func updateSpeeds() {
        for variant in ModelVariant.allCases {
            guard let progress = currentProgressBytes[variant] else { continue }
            if case .downloading(let currentProgress, _, _, _) = downloadStates[variant] {
                let previous = previousDownloadedBytes[variant] ?? 0
                let speed = Double(max(0, progress.downloaded - previous))
                previousDownloadedBytes[variant] = progress.downloaded
                
                downloadStates[variant] = .downloading(
                    progress: currentProgress,
                    speed: speed,
                    downloadedBytes: progress.downloaded,
                    totalBytes: progress.total
                )
            }
        }
    }

    // MARK: - URLSessionDownloadDelegate

    nonisolated func urlSession(
        _ session: URLSession,
        downloadTask: URLSessionDownloadTask,
        didWriteData bytesWritten: Int64,
        totalBytesWritten: Int64,
        totalBytesExpectedToWrite: Int64
    ) {
        guard let variant = variantForTask[downloadTask], totalBytesExpectedToWrite > 0 else { return }
        Task { @MainActor in
            self.currentProgressBytes[variant] = (totalBytesWritten, totalBytesExpectedToWrite)
            let fraction = Double(totalBytesWritten) / Double(totalBytesExpectedToWrite)
            
            // Retain the current speed while updating progress
            var currentSpeed: Double = 0.0
            if case .downloading(_, let speed, _, _) = self.downloadStates[variant] {
                currentSpeed = speed
            }
            
            self.downloadStates[variant] = .downloading(
                progress: fraction,
                speed: currentSpeed,
                downloadedBytes: totalBytesWritten,
                totalBytes: totalBytesExpectedToWrite
            )
        }
    }

    nonisolated func urlSession(
        _ session: URLSession,
        downloadTask: URLSessionDownloadTask,
        didFinishDownloadingTo location: URL
    ) {
        guard let variant = variantForTask[downloadTask] else { return }
        let dest = URL(fileURLWithPath: modelPath(variant))
        try? FileManager.default.moveItem(at: location, to: dest)
        Task { @MainActor in
            self.activeTasks.removeValue(forKey: variant)
            self.downloadStates[variant] = .done
            self.checkStopSpeedTimer()
        }
    }

    nonisolated func urlSession(_ session: URLSession, task: URLSessionTask, didCompleteWithError error: Error?) {
        guard let variant = variantForTask[task] else { return }
        Task { @MainActor in
            self.activeTasks.removeValue(forKey: variant)
            if let error = error {
                let nsError = error as NSError
                // Do not mark as failed if it was explicitly cancelled by the user
                if nsError.domain != NSURLErrorDomain || nsError.code != NSURLErrorCancelled {
                    self.downloadStates[variant] = .failed(error.localizedDescription)
                }
            }
            self.checkStopSpeedTimer()
        }
    }
}
