package com.google.android.gms.internal.serialization;

import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Type;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096D¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"com/google/home/automation/serialization/ExpressionWithType$determineReferenceTypes$AdHocField", "Lcom/google/home/Field;", "<init>", "()V", "", "typeName", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "descriptor", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzmg implements Field {
    private final String zza = "Boolean";
    private final Type zzb = Type.Boolean;
    private final Descriptor zzc = NoOpDescriptor.INSTANCE;

    @Override // com.google.home.Field
    /* JADX INFO: renamed from: getDescriptor, reason: from getter */
    public final Descriptor getZzc() {
        return this.zzc;
    }

    @Override // com.google.home.Field
    /* JADX INFO: renamed from: getTypeEnum, reason: from getter */
    public final Type getZzb() {
        return this.zzb;
    }

    @Override // com.google.home.Field
    /* JADX INFO: renamed from: getTypeName, reason: from getter */
    public final String getZza() {
        return this.zza;
    }
}
