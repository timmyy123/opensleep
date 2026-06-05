package com.google.home.matter.serialization;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class ClusterPayload$RawFieldReaderNoDefault$getList$1<T> extends FunctionReferenceImpl implements Function0<List<? extends T>> {
    public static final ClusterPayload$RawFieldReaderNoDefault$getList$1 INSTANCE = new ClusterPayload$RawFieldReaderNoDefault$getList$1();

    public ClusterPayload$RawFieldReaderNoDefault$getList$1() {
        super(0, CollectionsKt.class, "emptyList", "emptyList()Ljava/util/List;", 1);
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<T> invoke() {
        return CollectionsKt.emptyList();
    }
}
