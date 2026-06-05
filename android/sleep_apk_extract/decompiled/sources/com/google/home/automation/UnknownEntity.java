package com.google.home.automation;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.HasId;
import com.google.home.Id;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0014\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/google/home/automation/UnknownEntity;", "Lcom/google/home/HasId;", "Lcom/google/home/Id;", "id", "", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/String;", "getId-sJHuco4", "getName", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnknownEntity implements HasId {
    private final String id;
    private final String name;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UnknownEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            Id.m441constructorimpl("");
            str = "";
        }
        this(str, (i & 2) != 0 ? "" : str2, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnknownEntity)) {
            return false;
        }
        UnknownEntity unknownEntity = (UnknownEntity) other;
        return Id.m443equalsimpl0(getId(), unknownEntity.getId()) && Intrinsics.areEqual(this.name, unknownEntity.name);
    }

    @Override // com.google.home.HasId
    /* JADX INFO: renamed from: getId-sJHuco4, reason: from getter */
    public String getId() {
        return this.id;
    }

    public int hashCode() {
        return Id.m444hashCodeimpl(getId());
    }

    public String toString() {
        String strM445toStringimpl = Id.m445toStringimpl(getId());
        int length = strM445toStringimpl.length();
        String str = this.name;
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(str).length() + 1);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "UnknownEntity(id=", strM445toStringimpl, " , name=", str);
        sb.append(")");
        return sb.toString();
    }

    public /* synthetic */ UnknownEntity(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    private UnknownEntity(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.id = str;
        this.name = str2;
    }
}
