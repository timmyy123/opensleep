package androidx.core.view.insets;

import android.graphics.RectF;
import androidx.core.graphics.Insets;
import androidx.core.view.insets.SystemBarStateMonitor;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class ProtectionGroup implements SystemBarStateMonitor.Callback {
    private int mAnimationCount;
    private boolean mDisposed;
    private Insets mInsets;
    private Insets mInsetsIgnoringVisibility;
    private final SystemBarStateMonitor mMonitor;
    private final ArrayList<Protection> mProtections = new ArrayList<>();

    public ProtectionGroup(SystemBarStateMonitor systemBarStateMonitor, List<Protection> list) {
        Insets insets = Insets.NONE;
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets;
        addProtections(list, false);
        addProtections(list, true);
        systemBarStateMonitor.addCallback(this);
        this.mMonitor = systemBarStateMonitor;
    }

    private void addProtections(List<Protection> list, boolean z) {
        if (list.size() <= 0) {
            return;
        }
        list.get(0).getClass();
        Events$$ExternalSyntheticBUOutline0.m();
    }

    private void updateInsets() {
        Insets insets = Insets.NONE;
        int size = this.mProtections.size() - 1;
        if (size < 0) {
            return;
        }
        this.mProtections.get(size).getClass();
        Events$$ExternalSyntheticBUOutline0.m();
    }

    public void dispose() {
        if (this.mDisposed) {
            return;
        }
        this.mDisposed = true;
        this.mMonitor.removeCallback(this);
        int size = this.mProtections.size() - 1;
        ArrayList<Protection> arrayList = this.mProtections;
        if (size < 0) {
            arrayList.clear();
        } else {
            arrayList.get(size).getClass();
            Events$$ExternalSyntheticBUOutline0.m();
        }
    }

    public Protection getProtection(int i) {
        if (this.mProtections.get(i) == null) {
            return null;
        }
        Events$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onAnimationEnd() {
        int i = this.mAnimationCount;
        boolean z = i > 0;
        int i2 = i - 1;
        this.mAnimationCount = i2;
        if (z && i2 == 0) {
            updateInsets();
        }
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onAnimationProgress(int i, Insets insets, RectF rectF) {
        int size = this.mProtections.size() - 1;
        if (size < 0) {
            return;
        }
        this.mProtections.get(size).getClass();
        Events$$ExternalSyntheticBUOutline0.m();
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onAnimationStart() {
        this.mAnimationCount++;
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onColorHintChanged(int i) {
        int size = this.mProtections.size() - 1;
        if (size < 0) {
            return;
        }
        this.mProtections.get(size).getClass();
        Events$$ExternalSyntheticBUOutline0.m();
    }

    @Override // androidx.core.view.insets.SystemBarStateMonitor.Callback
    public void onInsetsChanged(Insets insets, Insets insets2) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets2;
        updateInsets();
    }

    public int size() {
        return this.mProtections.size();
    }
}
