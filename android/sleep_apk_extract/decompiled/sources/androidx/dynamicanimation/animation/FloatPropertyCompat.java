package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public abstract class FloatPropertyCompat<T> {
    final String mPropertyName;

    public FloatPropertyCompat(String str) {
        this.mPropertyName = str;
    }

    public abstract float getValue(T t);

    public abstract void setValue(T t, float f);
}
