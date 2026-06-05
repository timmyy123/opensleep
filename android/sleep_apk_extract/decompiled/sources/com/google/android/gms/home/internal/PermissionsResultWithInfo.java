package com.google.android.gms.home.internal;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.PermissionsResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.google.android.gms.home.internal.zzbp, reason: from toString */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$PermissionsResultWithInfo;", "", "permissionsResult", "Lcom/google/home/PermissionsResult;", "oauthInfo", "Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPermissionsInfo;", "<init>", "(Lcom/google/home/PermissionsResult;Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPermissionsInfo;)V", "getPermissionsResult", "()Lcom/google/home/PermissionsResult;", "getOauthInfo", "()Lcom/google/android/gms/home/internal/PermissionsUiManager$Companion$AccountPermissionsInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class PermissionsResultWithInfo {

    /* JADX INFO: renamed from: zza, reason: from toString */
    private final PermissionsResult permissionsResult;

    /* JADX INFO: renamed from: zzb, reason: from toString */
    private final zzbn oauthInfo;

    public PermissionsResultWithInfo(PermissionsResult permissionsResult, zzbn zzbnVar) {
        permissionsResult.getClass();
        this.permissionsResult = permissionsResult;
        this.oauthInfo = zzbnVar;
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionsResultWithInfo)) {
            return false;
        }
        PermissionsResultWithInfo permissionsResultWithInfo = (PermissionsResultWithInfo) other;
        return Intrinsics.areEqual(this.permissionsResult, permissionsResultWithInfo.permissionsResult) && Intrinsics.areEqual(this.oauthInfo, permissionsResultWithInfo.oauthInfo);
    }

    public final int hashCode() {
        int iHashCode = this.permissionsResult.hashCode() * 31;
        zzbn zzbnVar = this.oauthInfo;
        return iHashCode + (zzbnVar == null ? 0 : zzbnVar.hashCode());
    }

    public final String toString() {
        PermissionsResult permissionsResult = this.permissionsResult;
        int length = permissionsResult.toString().length();
        zzbn zzbnVar = this.oauthInfo;
        StringBuilder sb = new StringBuilder(length + 56 + String.valueOf(zzbnVar).length() + 1);
        sb.append("PermissionsResultWithInfo(permissionsResult=");
        sb.append(permissionsResult);
        sb.append(", oauthInfo=");
        sb.append(zzbnVar);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final PermissionsResult getPermissionsResult() {
        return this.permissionsResult;
    }

    /* JADX INFO: renamed from: zzb, reason: from getter */
    public final zzbn getOauthInfo() {
        return this.oauthInfo;
    }
}
