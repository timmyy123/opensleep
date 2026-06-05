package androidx.core.view;

/* JADX INFO: loaded from: classes.dex */
public interface DifferentialMotionFlingTarget {
    float getScaledScrollFactor();

    boolean startDifferentialMotionFling(float f);

    void stopDifferentialMotionFling();
}
