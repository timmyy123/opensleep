package com.google.home;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@kotlin.Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0018B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00000\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/google/home/DeviceType;", "", "Lcom/google/home/TraitProvider;", "Lcom/google/home/HasEvents;", "traitProvider", "eventProvider", "<init>", "(Lcom/google/home/TraitProvider;Lcom/google/home/HasEvents;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/home/TraitProvider;", "getTraitProvider", "()Lcom/google/home/TraitProvider;", "Lcom/google/home/HasEvents;", "Lcom/google/home/DeviceType$Metadata;", "getMetadata", "()Lcom/google/home/DeviceType$Metadata;", "metadata", "Lcom/google/home/DeviceTypeFactory;", "getFactory", "()Lcom/google/home/DeviceTypeFactory;", "factory", "Metadata", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class DeviceType implements TraitProvider, HasEvents {
    private final HasEvents eventProvider;
    private final TraitProvider traitProvider;

    /* JADX INFO: loaded from: classes3.dex */
    @kotlin.Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/google/home/DeviceType$Metadata;", "", "", "isPrimaryType", "Lcom/google/home/SourceConnectivity;", "sourceConnectivity", "<init>", "(ZLcom/google/home/SourceConnectivity;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Z", "()Z", "Lcom/google/home/SourceConnectivity;", "getSourceConnectivity", "()Lcom/google/home/SourceConnectivity;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Metadata {
        private final boolean isPrimaryType;
        private final SourceConnectivity sourceConnectivity;

        public Metadata(boolean z, SourceConnectivity sourceConnectivity) {
            sourceConnectivity.getClass();
            this.isPrimaryType = z;
            this.sourceConnectivity = sourceConnectivity;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Metadata)) {
                return false;
            }
            Metadata metadata = (Metadata) other;
            return this.isPrimaryType == metadata.isPrimaryType && Intrinsics.areEqual(this.sourceConnectivity, metadata.sourceConnectivity);
        }

        public int hashCode() {
            return Boolean.hashCode(this.isPrimaryType);
        }

        public String toString() {
            boolean z = this.isPrimaryType;
            StringBuilder sb = new StringBuilder(String.valueOf(z).length() + 24);
            sb.append("Metadata(isPrimaryType=");
            sb.append(z);
            sb.append(")");
            return sb.toString();
        }
    }

    public DeviceType(TraitProvider traitProvider, HasEvents hasEvents) {
        traitProvider.getClass();
        hasEvents.getClass();
        this.traitProvider = traitProvider;
        this.eventProvider = hasEvents;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        other.getClass();
        DeviceType deviceType = (DeviceType) other;
        return Intrinsics.areEqual(this.traitProvider, deviceType.traitProvider) && Intrinsics.areEqual(getMetadata(), deviceType.getMetadata()) && Intrinsics.areEqual(getFactory(), deviceType.getFactory());
    }

    public abstract DeviceTypeFactory<? extends DeviceType> getFactory();

    public abstract Metadata getMetadata();
}
