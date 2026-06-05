package com.philips.lighting.hue.sdk.clip.serialisation;

/* JADX INFO: loaded from: classes4.dex */
public class PHScheduleSerializer4 extends PHScheduleSerializer3 {
    private static PHScheduleSerializer4 schedulesSerialisation4;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHScheduleSerializer4 m859getInstance() {
        try {
            if (schedulesSerialisation4 == null) {
                schedulesSerialisation4 = new PHScheduleSerializer4();
            }
        } catch (Throwable th) {
            throw th;
        }
        return schedulesSerialisation4;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHScheduleSerializer1, com.philips.lighting.hue.sdk.clip.PHScheduleSerializer
    public boolean canFetchAll() {
        return true;
    }
}
