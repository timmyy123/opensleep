package com.urbandroid.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug;
import android.os.Process;

/* JADX INFO: loaded from: classes4.dex */
public class MemoryStats {
    private final ActivityManager am;

    public MemoryStats(Context context) {
        this.am = (ActivityManager) context.getSystemService("activity");
    }

    public String getStats() {
        StringBuilder sb = new StringBuilder();
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            this.am.getMemoryInfo(memoryInfo);
            sb.append("Device stats: memoryClass=" + this.am.getMemoryClass() + ", availMem=" + memoryInfo.availMem + ", lowMemory=" + memoryInfo.lowMemory + ", threshold=" + memoryInfo.threshold + ", totalMem=" + memoryInfo.totalMem + "\n");
            Runtime runtime = Runtime.getRuntime();
            StringBuilder sb2 = new StringBuilder("Runtime: freeMemory=");
            sb2.append(runtime.freeMemory());
            sb2.append(", maxMemory=");
            sb2.append(runtime.maxMemory());
            sb2.append(", totalMemory=");
            sb2.append(runtime.totalMemory());
            sb2.append(", used=");
            sb2.append(runtime.totalMemory() - runtime.freeMemory());
            sb2.append("\n");
            sb.append(sb2.toString());
            Debug.MemoryInfo memoryInfo2 = this.am.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
            sb.append("Dalvik: privateDirty=" + memoryInfo2.dalvikPrivateDirty + ", sharedDirty=" + memoryInfo2.dalvikSharedDirty + ", pss=" + memoryInfo2.dalvikPss + "\n");
            sb.append("Native: privateDirty=" + memoryInfo2.nativePrivateDirty + ", sharedDirty=" + memoryInfo2.nativeSharedDirty + ", pss=" + memoryInfo2.nativePss + "\n");
            sb.append("Other: privateDirty=" + memoryInfo2.otherPrivateDirty + ", sharedDirty=" + memoryInfo2.otherSharedDirty + ", pss=" + memoryInfo2.otherPss + "\n");
        } catch (Exception e) {
            sb.append(e.getClass().getName() + ": " + e.getMessage());
        }
        return sb.toString();
    }
}
