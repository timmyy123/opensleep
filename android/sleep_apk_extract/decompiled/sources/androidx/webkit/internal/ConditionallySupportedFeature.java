package androidx.webkit.internal;

/* JADX INFO: loaded from: classes.dex */
public interface ConditionallySupportedFeature {
    String getPublicFeatureName();

    boolean isSupported();
}
