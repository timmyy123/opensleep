package androidx.health.platform.client.proto;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface FieldMaskOrBuilder extends MessageLiteOrBuilder {
    String getPaths(int i);

    ByteString getPathsBytes(int i);

    int getPathsCount();

    List<String> getPathsList();
}
