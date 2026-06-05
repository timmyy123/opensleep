package androidx.constraintlayout.core.motion.utils;

/* JADX INFO: loaded from: classes4.dex */
public class Easing {
    String mStr = "identity";
    static Easing sDefault = new Easing();
    public static String[] NAMED_EASING = {"standard", "accelerate", "decelerate", "linear"};

    public String toString() {
        return this.mStr;
    }
}
