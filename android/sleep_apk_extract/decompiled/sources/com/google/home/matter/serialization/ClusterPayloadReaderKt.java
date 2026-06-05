package com.google.home.matter.serialization;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\u0004\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayloadReader;", "Lcom/google/home/matter/serialization/ClusterId;", "id", "", "unwrapPayload", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;Lcom/google/home/matter/serialization/ClusterId;)V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;Lcom/google/home/matter/serialization/ScopedCommandId;)V", "java.com.google.home.matter.serialization_serialization-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ClusterPayloadReaderKt {
    public static final void unwrapPayload(ClusterPayloadReader clusterPayloadReader, ScopedCommandId scopedCommandId) {
        clusterPayloadReader.getClass();
        scopedCommandId.getClass();
        clusterPayloadReader.unwrapPayload(CollectionsKt.listOf((Object[]) new UInt[]{UInt.m2388boximpl(UInt.m2389constructorimpl((char) scopedCommandId.getCluster().getSource())), UInt.m2388boximpl(UInt.m2389constructorimpl((char) scopedCommandId.getCluster().getId())), UInt.m2388boximpl(scopedCommandId.getUddmId())}));
    }

    public static final void unwrapPayload(ClusterPayloadReader clusterPayloadReader, ClusterId clusterId) {
        clusterPayloadReader.getClass();
        clusterId.getClass();
        clusterPayloadReader.unwrapPayload(CollectionsKt.listOf((Object[]) new UInt[]{UInt.m2388boximpl(UInt.m2389constructorimpl((char) clusterId.getSource())), UInt.m2388boximpl(UInt.m2389constructorimpl((char) clusterId.getId()))}));
    }
}
