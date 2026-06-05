package androidx.health.platform.client.proto;

/* JADX INFO: loaded from: classes.dex */
@CheckReturnValue
interface MessageInfo {
    MessageLite getDefaultInstance();

    ProtoSyntax getSyntax();

    boolean isMessageSetWireFormat();
}
