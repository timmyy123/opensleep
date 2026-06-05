package androidx.health.platform.client.proto;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> cls);
}
