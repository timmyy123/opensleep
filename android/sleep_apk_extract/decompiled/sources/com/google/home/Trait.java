package com.google.home;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0006R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/google/home/Trait;", "", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "metadata", "TraitMetadata", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface Trait {
    TraitMetadata getMetadata();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/Trait$TraitMetadata;", "", "sourceConnectivity", "Lcom/google/home/SourceConnectivity;", "<init>", "(Lcom/google/home/SourceConnectivity;)V", "getSourceConnectivity", "()Lcom/google/home/SourceConnectivity;", "equals", "", "other", "hashCode", "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TraitMetadata {
        private final SourceConnectivity sourceConnectivity;

        public /* synthetic */ TraitMetadata(SourceConnectivity sourceConnectivity, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? null : sourceConnectivity);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TraitMetadata) && Intrinsics.areEqual(this.sourceConnectivity, ((TraitMetadata) other).sourceConnectivity);
        }

        public final SourceConnectivity getSourceConnectivity() {
            return this.sourceConnectivity;
        }

        public int hashCode() {
            SourceConnectivity sourceConnectivity = this.sourceConnectivity;
            if (sourceConnectivity != null) {
                return sourceConnectivity.hashCode();
            }
            return 0;
        }

        public TraitMetadata(SourceConnectivity sourceConnectivity) {
            this.sourceConnectivity = sourceConnectivity;
        }
    }
}
