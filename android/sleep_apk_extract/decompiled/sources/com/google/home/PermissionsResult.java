package com.google.home;

import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/home/PermissionsResult;", "", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "Lcom/google/home/PermissionsResultStatus;", "errorMessage", "", "<init>", "(Lcom/google/home/PermissionsResultStatus;Ljava/lang/String;)V", "getStatus", "()Lcom/google/home/PermissionsResultStatus;", "getErrorMessage", "()Ljava/lang/String;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PermissionsResult {
    private final String errorMessage;
    private final PermissionsResultStatus status;

    public PermissionsResult(PermissionsResultStatus permissionsResultStatus, String str) {
        permissionsResultStatus.getClass();
        this.status = permissionsResultStatus;
        this.errorMessage = str;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final PermissionsResultStatus getStatus() {
        return this.status;
    }

    public /* synthetic */ PermissionsResult(PermissionsResultStatus permissionsResultStatus, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(permissionsResultStatus, (i & 2) != 0 ? null : str);
    }
}
