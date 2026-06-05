package androidx.datastore.preferences.protobuf;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ExtensionSchemaLite extends ExtensionSchema<Object> {
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> entry) {
        throw Fragment$$ExternalSyntheticOutline1.m(entry);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        extensionRegistryLite.findLiteExtensionByNumber(messageLite, i);
        return null;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public FieldSet<Object> getExtensions(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public FieldSet<Object> getMutableExtensions(Object obj) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite messageLite) {
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public <UT, UB> UB parseExtension(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<Object> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Object> fieldSet) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Object> fieldSet) {
        throw FileInsert$$ExternalSyntheticOutline0.m(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) {
        throw Fragment$$ExternalSyntheticOutline1.m(entry);
    }
}
