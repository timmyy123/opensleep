package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.datastore.DataStoreFile;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgbc implements zzimu {
    private final zzind zza;

    private zzgbc(zzind zzindVar, zzind zzindVar2) {
        this.zza = zzindVar;
    }

    public static zzgbc zza(zzind zzindVar, zzind zzindVar2) {
        return new zzgbc(zzindVar, zzindVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzinj
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context contextZza = ((zzcnq) this.zza).zza();
        zzgbg zzgbgVarZzc = zzcnu.zzc();
        contextZza.getClass();
        zzgbgVarZzc.getClass();
        DataStore dataStoreCreate$default = DataStoreFactory.create$default(DataStoreFactory.INSTANCE, zzgba.zza, null, null, zzgbgVarZzc.zza(), new Function0() { // from class: com.google.android.gms.internal.ads.zzgbb
            @Override // kotlin.jvm.functions.Function0
            public final /* synthetic */ Object invoke() {
                return DataStoreFile.dataStoreFile(contextZza, "ad_quality_data.pb");
            }
        }, 6, null);
        zzinc.zzb(dataStoreCreate$default);
        return dataStoreCreate$default;
    }
}
