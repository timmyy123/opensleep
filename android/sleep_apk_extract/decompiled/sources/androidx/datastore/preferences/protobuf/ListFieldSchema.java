package androidx.datastore.preferences.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface ListFieldSchema {
    void makeImmutableListAt(Object obj, long j);

    <L> void mergeListsAt(Object obj, Object obj2, long j);

    <L> List<L> mutableListAt(Object obj, long j);
}
