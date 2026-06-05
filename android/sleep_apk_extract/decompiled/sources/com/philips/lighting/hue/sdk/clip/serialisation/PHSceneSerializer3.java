package com.philips.lighting.hue.sdk.clip.serialisation;

/* JADX INFO: loaded from: classes4.dex */
public class PHSceneSerializer3 extends PHSceneSerializer2 {
    private static PHSceneSerializer3 sceneSerializer3;

    /* JADX INFO: renamed from: getInstance, reason: collision with other method in class */
    public static synchronized PHSceneSerializer3 m854getInstance() {
        try {
            if (sceneSerializer3 == null) {
                sceneSerializer3 = new PHSceneSerializer3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return sceneSerializer3;
    }

    @Override // com.philips.lighting.hue.sdk.clip.serialisation.PHSceneSerializer1, com.philips.lighting.hue.sdk.clip.PHSceneSerializer
    public boolean canFetchAll() {
        return true;
    }
}
