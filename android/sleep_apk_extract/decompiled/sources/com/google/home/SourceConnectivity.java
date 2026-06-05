package com.google.home;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/google/home/SourceConnectivity;", "", "connectivityState", "Lcom/google/home/ConnectivityState;", "dataSourceLocality", "Lcom/google/home/LocalityType;", "backingHubs", "", "Lcom/google/home/Id;", "<init>", "(Lcom/google/home/ConnectivityState;Lcom/google/home/LocalityType;Ljava/util/Set;)V", "getConnectivityState", "()Lcom/google/home/ConnectivityState;", "getDataSourceLocality", "()Lcom/google/home/LocalityType;", "getBackingHubs", "()Ljava/util/Set;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SourceConnectivity {
    private final Set<Id> backingHubs;
    private final ConnectivityState connectivityState;
    private final LocalityType dataSourceLocality;

    public SourceConnectivity(ConnectivityState connectivityState, LocalityType localityType, Set<Id> set) {
        connectivityState.getClass();
        localityType.getClass();
        set.getClass();
        this.connectivityState = connectivityState;
        this.dataSourceLocality = localityType;
        this.backingHubs = set;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SourceConnectivity)) {
            return false;
        }
        SourceConnectivity sourceConnectivity = (SourceConnectivity) other;
        return this.connectivityState == sourceConnectivity.connectivityState && this.dataSourceLocality == sourceConnectivity.dataSourceLocality && Intrinsics.areEqual(this.backingHubs, sourceConnectivity.backingHubs);
    }

    public final Set<Id> getBackingHubs() {
        return this.backingHubs;
    }

    public final ConnectivityState getConnectivityState() {
        return this.connectivityState;
    }

    public final LocalityType getDataSourceLocality() {
        return this.dataSourceLocality;
    }

    public int hashCode() {
        int iHashCode = this.dataSourceLocality.hashCode() + (this.connectivityState.hashCode() * 31);
        return this.backingHubs.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        ConnectivityState connectivityState = this.connectivityState;
        int length = String.valueOf(connectivityState).length();
        LocalityType localityType = this.dataSourceLocality;
        StringBuilder sb = new StringBuilder(length + 58 + String.valueOf(localityType).length() + 1);
        sb.append("SourceConnectivity(connectivityState=");
        sb.append(connectivityState);
        sb.append(", dataSourceLocality=");
        sb.append(localityType);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ SourceConnectivity(ConnectivityState connectivityState, LocalityType localityType, Set set, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(connectivityState, localityType, (i & 4) != 0 ? SetsKt.emptySet() : set);
    }
}
