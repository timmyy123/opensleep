package com.philips.lighting.hue.sdk.clip.serialisation;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer3 extends PHLightSerializer2 {
    private static PHLightSerializer3 lightSerialisation3;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer3 m846getInstance() {
        try {
            if (lightSerialisation3 == null) {
                lightSerialisation3 = new PHLightSerializer3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation3;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canFetchAll() {
        return true;
    }
}
