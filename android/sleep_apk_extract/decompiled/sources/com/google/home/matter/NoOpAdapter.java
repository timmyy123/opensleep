package com.google.home.matter;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.StructAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/NoOpAdapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/NoData;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter_matter-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NoOpAdapter implements StructAdapter<NoData> {
    public static final NoOpAdapter INSTANCE = new NoOpAdapter();

    private NoOpAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.home.matter.serialization.StructAdapter
    public NoData read(ClusterPayloadReader reader) {
        reader.getClass();
        return new NoData();
    }

    @Override // com.google.home.matter.serialization.StructAdapter
    public void write(ClusterPayloadWriter writer, NoData value) {
        writer.getClass();
        value.getClass();
    }
}
