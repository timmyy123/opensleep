package com.philips.lighting.hue.sdk.clip.serialisation;

/* JADX INFO: loaded from: classes4.dex */
public class PHLightSerializer6 extends PHLightSerializer5 {
    private static final String TAG = "PHLightSerializer6";
    private static PHLightSerializer6 lightSerialisation6;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHLightSerializer6 m849getInstance() {
        try {
            if (lightSerialisation6 == null) {
                lightSerialisation6 = new PHLightSerializer6();
            }
        } catch (Throwable th) {
            throw th;
        }
        return lightSerialisation6;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHLightSerializer1, com.philips.lighting.hue.sdk.clip.PHLightSerializer
    public boolean canDelete() {
        return true;
    }
}
