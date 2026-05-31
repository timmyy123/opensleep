import SwiftUI

// MARK: - Donut Ring Chart

struct SleepRingChart: View {
    let stageDurations: [SleepStageType: TimeInterval]
    @AppStorage("app_language") private var selectedLanguage = "en"

    private var languageBundle: Bundle {
        if let path = Bundle.main.path(forResource: selectedLanguage, ofType: "lproj"),
           let bundle = Bundle(path: path) {
            return bundle
        }
        return Bundle.main
    }

    private func localizedString(_ key: String) -> String {
        return languageBundle.localizedString(forKey: key, value: nil, table: nil)
    }

    private var total: TimeInterval {
        stageDurations.values.reduce(0, +)
    }

    private var nonZero: [(SleepStageType, TimeInterval)] {
        stageDurations.filter { $0.value > 0 }
            .sorted { $0.key.rawValue < $1.key.rawValue }
    }

    var body: some View {
        ZStack {
            Canvas { ctx, size in
                let diameter = min(size.width, size.height)
                let lineWidth: CGFloat = 24
                let rect = CGRect(
                    x: (size.width - diameter) / 2 + lineWidth / 2,
                    y: (size.height - diameter) / 2 + lineWidth / 2,
                    width: diameter - lineWidth,
                    height: diameter - lineWidth
                )
                var startAngle = Angle.degrees(-90)
                for (type, duration) in nonZero {
                    let fraction = duration / total
                    let sweep = Angle.degrees(fraction * 360)
                    var path = Path()
                    path.addArc(center: CGPoint(x: size.width / 2, y: size.height / 2),
                               radius: (diameter - lineWidth) / 2,
                               startAngle: startAngle,
                               endAngle: startAngle + sweep,
                               clockwise: false)
                    ctx.stroke(path,
                               with: .color(Color.forStage(type)),
                               style: StrokeStyle(lineWidth: lineWidth, lineCap: .butt))
                    startAngle += sweep
                }
            }

            // Center label
            VStack(spacing: 2) {
                let h = Int(total / 3600)
                let m = Int((total.truncatingRemainder(dividingBy: 3600)) / 60)
                Text("\(h)h \(m)m")
                    .font(.system(size: 18, weight: .bold, design: .rounded))
                    .foregroundStyle(Color.textPrimary)
                Text(localizedString("total"))
                    .font(AppTextStyle.labelSmall)
                    .foregroundStyle(Color.textSecondary)
            }
        }
    }
}

// MARK: - Hypnogram

struct SleepHypnogram: View {
    let stages: [SleepStage]
    let totalDuration: TimeInterval

    private let stageOrder: [SleepStageType] = [.awake, .rem, .light, .deep]

    var body: some View {
        Canvas { ctx, size in
            guard !stages.isEmpty, totalDuration > 0 else { return }
            let trackH = size.height / CGFloat(stageOrder.count)
            let startTime = stages.first?.startDate.timeIntervalSinceReferenceDate ?? 0

            for stage in stages {
                let x = CGFloat((stage.startDate.timeIntervalSinceReferenceDate - startTime) / totalDuration) * size.width
                let w = max(CGFloat(stage.durationSeconds / totalDuration) * size.width, 2)
                let yIdx = stageOrder.firstIndex(of: stage.type) ?? 0
                let y = CGFloat(yIdx) * trackH

                let rect = CGRect(x: x, y: y, width: w, height: trackH - 2)
                ctx.fill(Path(roundedRect: rect, cornerRadius: 2),
                        with: .color(Color.forStage(stage.type).opacity(0.85)))
            }
        }
        .frame(height: 80)
    }
}

// MARK: - Stage Legend

struct SleepStageLegend: View {
    let stageDurations: [SleepStageType: TimeInterval]

    var body: some View {
        HStack {
            ForEach(SleepStageType.allCases, id: \.self) { type in
                let minutes = Int((stageDurations[type] ?? 0) / 60)
                VStack(spacing: 4) {
                    Circle()
                        .fill(Color.forStage(type))
                        .frame(width: 8, height: 8)
                    Text(type.displayName)
                        .font(AppTextStyle.labelSmall)
                        .foregroundStyle(Color.forStage(type))
                    Text("\(minutes)m")
                        .font(AppTextStyle.labelSmall)
                        .foregroundStyle(Color.textSecondary)
                }
                .frame(maxWidth: .infinity)
            }
        }
    }
}
