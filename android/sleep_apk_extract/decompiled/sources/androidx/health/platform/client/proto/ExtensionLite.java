package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.MessageLite;
import androidx.health.platform.client.proto.WireFormat;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract Type getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    public boolean isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
