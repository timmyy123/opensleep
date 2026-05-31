# 🌙 OpenSleep

<p align="center">
  <img src="https://img.shields.io/badge/Platform-iOS%20%7C%20Android-4f46e5?style=for-the-badge&logo=apple&logoColor=white" alt="Platform Supported" />
  <img src="https://img.shields.io/badge/AI-Gemma%204%20(Local)-db2777?style=for-the-badge&logo=google-gemma&logoColor=white" alt="AI Engine" />
  <img src="https://img.shields.io/badge/Privacy-100%25%20On--Device-059669?style=for-the-badge&logo=shield&logoColor=white" alt="Privacy Level" />
  <img src="https://img.shields.io/badge/Source-Open%20Source-2563eb?style=for-the-badge&logo=github&logoColor=white" alt="Open Source" />
</p>

---

### **OpenSleep** is a next-generation, premium sleep tracking application that redefines personal sleep science through a uncompromising **100% on-device, private-first architecture**. 

Unlike standard trackers that transmit your personal bio-data to remote servers, OpenSleep does all of its telemetry processing and advanced AI analysis directly on your smartphone. Featuring a fully integrated, localized **Gemma 4 AI Sleep Coach**, OpenSleep delivers personalized wellness guidance with complete cloud isolation.

---

## 🚀 Key Pillars

### 1. 🛡️ 100% On-Device & Zero-Server Privacy
* **Local Sensor Processing**: Raw accelerometer, gyroscope, and audio data from your device's sensors are analyzed completely locally.
* **No External Servers**: Zero analytics endpoints, zero tracking SDKs, and zero database synchronization in the cloud. Your data belongs to you alone.
* **Health Integration**: Syncs directly and securely with native system aggregates (**Apple Health** on iOS, **Google Health Connect** on Android) through highly secure local APIs.

### 2. 🧠 Local Gemma 4 AI Coach
* **Fully Offline Intelligence**: OpenSleep runs a highly optimized, localized **Gemma 4 LLM** directly on-device. No API requests, no cloud latency, and no chance of conversation leakage.
* **Smart Sleep Analytics**: The AI coach reads your sleep patterns locally to offer customized tips for improving sleep hygiene, tracking circadian rhythm, and managing daytime sleepiness.
* **Dynamic Chat Interface**: A gorgeous, reactive conversation dashboard supporting markdown rendering, tabular sleep summaries, and granular context window controls.

### 3. 📊 Interactive Analytics & Insights
* **Sleep Stage Breakdowns**: Premium multi-stage sleep graphs depicting Deep, Light, REM, and Awake durations.
* **Adaptive Calendars**: Toggle sleep history metrics seamlessly across daily, weekly, monthly, and yearly intervals.
* **Swipe-to-Manage Control**: Securely delete historical sleep sessions instantly with intuitive swipe-left triggers or bulk selection controls.

---

## 🏗️ Architecture & Data Flow

Below is the design of the on-device environment showing the isolation from external cloud services:

```mermaid
graph TD
    subgraph Device ["User Device (iOS & Android)"]
        Sensors["Motion & Sound Sensors<br>(Accelerometer, Gyro, Mic)"] -->|Raw Telemetry| Processor["On-Device Analytics Engine"]
        Processor -->|Local Sleep Stages| Storage["Local DB & Sync<br>(Apple Health / Health Connect)"]
        
        Storage -->|Contextual Sleep Data| AI["Local Gemma 4 AI Coach<br>(On-Device LiteRT-LM / LLM Component)"]
        User["User Interaction"] <-->|Chat Interface| AI
    end
    
    subgraph Cloud ["External Network"]
        direction LR
        Server["External Server"] -.->|PROHIBITED / BLOCKED| Device
    end
    
    style Device fill:#0f172a,stroke:#3b82f6,stroke-width:2px,color:#fff
    style Cloud fill:#1e293b,stroke:#f43f5e,stroke-width:1px,stroke-dasharray: 5 5,color:#cbd5e1
    style Sensors fill:#1e293b,stroke:#10b981,stroke-width:1px,color:#fff
    style Processor fill:#1e293b,stroke:#8b5cf6,stroke-width:1px,color:#fff
    style Storage fill:#1e293b,stroke:#3b82f6,stroke-width:1px,color:#fff
    style AI fill:#1e293b,stroke:#ec4899,stroke-width:2px,color:#fff
    style User fill:#334155,stroke:#94a3b8,stroke-width:1px,color:#fff
    style Server fill:#1e293b,stroke:#f43f5e,stroke-width:1px,color:#94a3b8
```

---

## 🛠️ Technology Stack

| Platform | Frontend | Local Storage | AI Engine |
| :--- | :--- | :--- | :--- |
| **iOS** | Swift & SwiftUI (Premium UI Design) | SwiftData & Apple HealthKit | LiteRT-LM (Swift Package) |
| **Android** | Kotlin & Jetpack Compose (Material 3) | Room & Google Health Connect | LiteRT-LM (Kotlin Library) |

---

> [!IMPORTANT]
> **OpenSleep does not connect to the internet.**
> It never collects, stores, or sells your personal information, sleep logs, audio metadata, or conversation histories. All AI calculations are run directly on the physical processor of your device.

---

## 📬 Support & Community

OpenSleep is an open-source project created and maintained for the benefit of developers and health enthusiasts alike. 

* **GitHub Repository**: [https://github.com/timmyy123/opensleep](https://github.com/timmyy123/opensleep)
* **Support Email**: If you have any inquiries, feedback, or need assistance, feel free to reach out directly to the creator at [timmy@opensleep.tech](mailto:timmy@opensleep.tech).

---
*OpenSleep — Your Sleep, Your Data, 100% On-Device.*
