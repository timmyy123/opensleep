package com.google.android.gms.internal.serialization;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001:\u0003012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u0010\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ(\u0010\u0012\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u0011\u0010\u000fJ-\u0010\u0017\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J.\u0010\u0012\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0013H\u0087\n¢\u0006\u0004\b\u0018\u0010\u0016J0\u0010\u001d\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020\nH\u0087\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001f\u0010\u001f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tH\u0007¢\u0006\u0004\b\u001b\u0010\u001eJ'\u0010\u0010\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t2\u0006\u0010\f\u001a\u00020 H\u0007¢\u0006\u0004\b\"\u0010#J(\u0010\u0012\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t2\u0006\u0010\f\u001a\u00020 H\u0087\n¢\u0006\u0004\b$\u0010#J-\u0010\u0017\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020 0\u0013H\u0007¢\u0006\u0004\b%\u0010\u0016J.\u0010\u0012\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020 0\u0013H\u0087\n¢\u0006\u0004\b&\u0010\u0016J0\u0010\u001d\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\f\u001a\u00020 H\u0087\u0002¢\u0006\u0004\b'\u0010(J\u001f\u0010\u001f\u001a\u00020\r*\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\tH\u0007¢\u0006\u0004\b)\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u001d\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001d\u0010/\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\t8F¢\u0006\u0006\u001a\u0004\b.\u0010,¨\u00063"}, d2 = {"Lcom/google/protos/home/internal/interaction_api/FilterQueryKt$Dsl;", "", "Lcom/google/protos/home/internal/interaction_api/FilterQuery$Builder;", "_builder", "<init>", "(Lcom/google/protos/home/internal/interaction_api/FilterQuery$Builder;)V", "Lcom/google/protos/home/internal/interaction_api/FilterQuery;", "_build", "()Lcom/google/protos/home/internal/interaction_api/FilterQuery;", "Lcom/google/protobuf/kotlin/DslList;", "", "Lcom/google/protos/home/internal/interaction_api/FilterQueryKt$Dsl$ObjectIdsProxy;", SDKConstants.PARAM_VALUE, "", "addObjectIds", "(Lcom/google/protobuf/kotlin/DslList;Ljava/lang/String;)V", "add", "plusAssignObjectIds", "plusAssign", "", "values", "addAllObjectIds", "(Lcom/google/protobuf/kotlin/DslList;Ljava/lang/Iterable;)V", "addAll", "plusAssignAllObjectIds", "", "index", "setObjectIds", "(Lcom/google/protobuf/kotlin/DslList;ILjava/lang/String;)V", "set", "(Lcom/google/protobuf/kotlin/DslList;)V", "clear", "Lcom/google/protos/home/internal/interaction_api/FilterMatcher;", "Lcom/google/protos/home/internal/interaction_api/FilterQueryKt$Dsl$MatchersProxy;", "addMatchers", "(Lcom/google/protobuf/kotlin/DslList;Lcom/google/protos/home/internal/interaction_api/FilterMatcher;)V", "plusAssignMatchers", "addAllMatchers", "plusAssignAllMatchers", "setMatchers", "(Lcom/google/protobuf/kotlin/DslList;ILcom/google/protos/home/internal/interaction_api/FilterMatcher;)V", "clearMatchers", "Lcom/google/protos/home/internal/interaction_api/FilterQuery$Builder;", "getObjectIds", "()Lcom/google/protobuf/kotlin/DslList;", "objectIds", "getMatchers", "matchers", "Companion", "ObjectIdsProxy", "MatchersProxy", "nest.platform.mesh.core.proto_interaction_api_lite_kt"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzadt {
    private final zzadq zza;

    public final /* synthetic */ zzadr zza() {
        zzzg zzzgVarBuild = this.zza.build();
        zzzgVarBuild.getClass();
        return (zzadr) zzzgVarBuild;
    }

    public final zzack zzb() {
        List listZza = this.zza.zza();
        listZza.getClass();
        return new zzack(listZza);
    }

    public final /* synthetic */ void zzc(zzack zzackVar, Iterable iterable) {
        zzackVar.getClass();
        iterable.getClass();
        this.zza.zzb(iterable);
    }

    public final /* synthetic */ zzack zzd() {
        List listZzc = this.zza.zzc();
        listZzc.getClass();
        return new zzack(listZzc);
    }

    public final /* synthetic */ void zze(zzack zzackVar, zzadn zzadnVar) {
        zzackVar.getClass();
        zzadnVar.getClass();
        this.zza.zzd(zzadnVar);
    }

    public final /* synthetic */ void zzf(zzack zzackVar, Iterable iterable) {
        zzackVar.getClass();
        iterable.getClass();
        this.zza.zze(iterable);
    }
}
