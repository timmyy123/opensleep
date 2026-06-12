import Foundation
import AVFoundation

class ChirpProducer {
    let sampleRate: Double
    private var engine: AVAudioEngine?
    private var sourceNode: AVAudioSourceNode?
    private var isPlaying = false
    private let lock = NSLock()

    init(sampleRate: Int) {
        self.sampleRate = Double(sampleRate)
    }

    func play() {
        lock.lock(); defer { lock.unlock() }
        if isPlaying { return }
        isPlaying = true
        
        let engine = AVAudioEngine()
        self.engine = engine
        
        var time = 0.0
        let frequency = 20000.0
        
        let sourceNode = AVAudioSourceNode { [weak self] (_, _, frameCount, audioBufferList) -> OSStatus in
            guard let self = self, self.isPlaying else { return noErr }
            
            let abl = UnsafeMutableAudioBufferListPointer(audioBufferList)
            for buffer in abl {
                if let ptr = buffer.mData?.assumingMemoryBound(to: Float.self) {
                    for frame in 0..<Int(frameCount) {
                        let sampleVal = sin(time * 2.0 * Double.pi * frequency)
                        ptr[frame] = Float(sampleVal)
                        time += 1.0 / self.sampleRate
                    }
                }
            }
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
