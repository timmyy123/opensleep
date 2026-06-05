package androidx.transition;

import android.view.ViewGroup;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public abstract class Scene {
    public static Scene getCurrentScene(ViewGroup viewGroup) {
        if (viewGroup.getTag(R$id.transition_current_scene) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public static void setCurrentScene(ViewGroup viewGroup, Scene scene) {
        viewGroup.setTag(R$id.transition_current_scene, scene);
    }
}
