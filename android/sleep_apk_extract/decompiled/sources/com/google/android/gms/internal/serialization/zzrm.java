package com.google.android.gms.internal.serialization;

import com.google.home.ConnectivityState;
import com.google.home.Id;
import com.google.home.LocalityType;
import com.google.home.SourceConnectivity;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getSourceConnectivity", "Lcom/google/home/SourceConnectivity;", "Lcom/google/nest/platform/mesh/data_model/generated/internal/ghp/traits/SupportedTypesTraitSerialization$SupportedTraitInfo;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzrm {
    public static final SourceConnectivity zza(zztm zztmVar) {
        Set of;
        zztmVar.getClass();
        zzsk zza = zztmVar.getZza();
        zza.getClass();
        zzsk zzskVar = zzsk.zza;
        int iOrdinal = zza.ordinal();
        ConnectivityState connectivityState = iOrdinal != 1 ? iOrdinal != 2 ? ConnectivityState.UNKNOWN : ConnectivityState.OFFLINE : ConnectivityState.ONLINE;
        zztk zzb = zztmVar.getZzb();
        zzb.getClass();
        zztk zztkVar = zztk.zza;
        int iOrdinal2 = zzb.ordinal();
        LocalityType localityType = iOrdinal2 != 1 ? iOrdinal2 != 2 ? iOrdinal2 != 3 ? LocalityType.UNSPECIFIED : LocalityType.REMOTE : LocalityType.PEER : LocalityType.DIRECT;
        if (zztmVar.getZzc().length() == 0) {
            of = SetsKt.emptySet();
        } else {
            String zzc = zztmVar.getZzc();
            Id.m441constructorimpl(zzc);
            of = SetsKt.setOf(Id.m440boximpl(zzc));
        }
        return new SourceConnectivity(connectivityState, localityType, of);
    }
}
