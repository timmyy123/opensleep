package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u00019B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u000bJ\r\u0010\u0010\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000eJ\r\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u000bJ\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u000eJ\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u000bJ\r\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u000eJ\r\u0010\u0015\u001a\u00020\t¢\u0006\u0004\b\u0015\u0010\u000bJ\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u000eJ\r\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R$\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020 8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010+\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020&8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010.\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020&8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R$\u00101\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020&8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R$\u00104\u001a\u00020&2\u0006\u0010\u001a\u001a\u00020&8G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u0011\u00108\u001a\u0002058G¢\u0006\u0006\u001a\u0004\b6\u00107¨\u0006:"}, d2 = {"Lcom/google/protos/home/internal/interaction_api/FilterMatcherKt$Dsl;", "", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Builder;", "_builder", "<init>", "(Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Builder;)V", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher;", "_build", "()Lcom/google/protos/home/internal/interaction_api/FilterMatcher;", "", "clearType", "()V", "", "hasType", "()Z", "clearTrait", "hasTrait", "clearObjectType", "hasObjectType", "clearFieldName", "hasFieldName", "clearFieldValue", "hasFieldValue", "clearSource", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Builder;", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Type;", SDKConstants.PARAM_VALUE, "getType", "()Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Type;", "setType", "(Lcom/google/protos/home/internal/interaction_api/FilterMatcher$Type;)V", "type", "", "getTypeValue", "()I", "setTypeValue", "(I)V", "typeValue", "", "getTrait", "()Ljava/lang/String;", "setTrait", "(Ljava/lang/String;)V", "trait", "getObjectType", "setObjectType", "objectType", "getFieldName", "setFieldName", "fieldName", "getFieldValue", "setFieldValue", "fieldValue", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher$SourceCase;", "getSourceCase", "()Lcom/google/protos/home/internal/interaction_api/FilterMatcher$SourceCase;", "sourceCase", "Companion", "nest.platform.mesh.core.proto_interaction_api_lite_kt"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzadp {
    private final zzadl zza;

    public final /* synthetic */ zzadn zza() {
        zzzg zzzgVarBuild = this.zza.build();
        zzzgVarBuild.getClass();
        return (zzadn) zzzgVarBuild;
    }

    public final void zzb(zzadm zzadmVar) {
        zzadmVar.getClass();
        this.zza.zza(zzadmVar);
    }

    public final void zzc(String str) {
        str.getClass();
        this.zza.zzb(str);
    }

    public final void zzd(String str) {
        this.zza.zzc("home.internal.types.Component");
    }
}
