package com.google.home.matter.serialization;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.collections.MapsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\r\u001a\u00020\f2 \b\u0002\u0010\u000b\u001a\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\n0\tH&¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\nH&¢\u0006\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0013À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/serialization/ClusterPayloadReader;", "", "", "Lkotlin/UInt;", "Lcom/google/home/matter/serialization/TagId;", "tags", "", "unwrapPayload", "(Ljava/util/List;)V", "", "Lcom/google/home/matter/serialization/StructAdapter;", "adapters", "Lcom/google/home/matter/serialization/ClusterPayload;", "readPayload", "(Ljava/util/Map;)Lcom/google/home/matter/serialization/ClusterPayload;", "T", "adapter", "read", "(Lcom/google/home/matter/serialization/StructAdapter;)Ljava/lang/Object;", "java.com.google.home.matter.serialization_serialization-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ClusterPayloadReader {
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ ClusterPayload readPayload$default(ClusterPayloadReader clusterPayloadReader, Map map, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: readPayload");
            return null;
        }
        if ((i & 1) != 0) {
            map = MapsKt.emptyMap();
        }
        return clusterPayloadReader.readPayload(map);
    }

    <T> T read(StructAdapter<T> adapter);

    ClusterPayload readPayload(Map<UInt, ? extends StructAdapter<? extends Object>> adapters);

    void unwrapPayload(List<UInt> tags);
}
