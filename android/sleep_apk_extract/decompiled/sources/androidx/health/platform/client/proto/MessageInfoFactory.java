package androidx.health.platform.client.proto;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface MessageInfoFactory {
    boolean isSupported(Class<?> cls);

    MessageInfo messageInfoFor(Class<?> cls);
}
