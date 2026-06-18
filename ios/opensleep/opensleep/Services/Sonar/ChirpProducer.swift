import Foundation
import AVFoundation

class ChirpProducer {
    let sampleRate: Double
    private var engine: AVAudioEngine?
    private var sourceNode: AVAudioSourceNode?
    private var isPlaying = false
    private let lock = NSLock()
    private var chirpData = [Float](repeating: 0.0, count: 8192)
    private var chirpIndex = 0

    init(sampleRate: Int) {
        self.sampleRate = Double(sampleRate)
        let f0 = 18000.0
        let f1 = 22000.0
        let T = 8192.0
        let Fs = Double(sampleRate)
        for t in 0..<8192 {
            let phase = (2.0 * Double.pi / Fs) * (f0 * Double(t) + ((f1 - f0) / (2.0 * T)) * Double(t) * Double(t))
            let window = sin(Double.pi * Double(t) / T)
            let sampleVal = cos(phase) * window
            chirpData[t] = Float(sampleVal)
        }
    }

    func play() {
        lock.lock(); defer { lock.unlock() }
        if isPlaying { return }
        isPlaying = true
        chirpIndex = 0
        
        let engine = AVAudioEngine()
        self.engine = engine
        
        let sourceNode = AVAudioSourceNode { [weak self] (_, _, frameCount, audioBufferList) -> OSStatus in
            guard let self = self, self.isPlaying else { return noErr }
            
            let abl = UnsafeMutableAudioBufferListPointer(audioBufferList)
            var index = self.chirpIndex
            for buffer in abl {
                if let ptr = buffer.mData?.assumingMemoryBound(to: Float.self) {
                    for frame in 0..<Int(frameCount) {
                        ptr[frame] = self.chirpData[(index + frame) % 8192]
                    }
                }
            }
            self.chirpIndex = (index + Int(frameCount)) % 8192
            return noErr
        }
        
        self.sourceNode = sourceNode
        engine.attach(sourceNode)
        
        guard let format = AVAudioFormat(standardFormatWithSampleRate: sampleRate, channels: 1) else {
            print("ChirpProducer failed to create mono audio format")
            return
        }
        
        engine.connect(sourceNode, to: engine.mainMixerNode, format: format)
        
        do {
            try engine.start()
        } catch {
            print("ChirpProducer failed to start AVAudioEngine: \(error)")
        }
    }

    func stop() {
        lock.lock(); defer { lock.unlock() }
        isPlaying = false
        engine?.stop()
        if let sourceNode = sourceNode {
            engine?.detach(sourceNode)
        }
        sourceNode = nil
        engine = nil
    }
}
