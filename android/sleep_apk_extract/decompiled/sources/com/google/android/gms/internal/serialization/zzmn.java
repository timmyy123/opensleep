package com.google.android.gms.internal.serialization;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/home/automation/serialization/UnknownOperand;", "Lcom/google/home/automation/serialization/OperandWithType;", "rawBytes", "", "<init>", "([B)V", "getRawBytes", "()[B", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmn extends OperandWithType {
    private final byte[] zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzmn(byte[] bArr) {
        super(null, null, null);
        bArr.getClass();
        this.zza = bArr;
    }

    /* JADX INFO: renamed from: zza, reason: from getter */
    public final byte[] getZza() {
        return this.zza;
    }
}
