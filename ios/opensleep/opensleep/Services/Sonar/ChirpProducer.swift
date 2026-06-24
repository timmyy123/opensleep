import Foundation
import AVFoundation

class ChirpProducer {
    let sampleRate: Double
    var chirpData = [Float](repeating: 0.0, count: 8192)

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
}
