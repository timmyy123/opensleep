package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.serialization.ObjectData;
import com.google.android.gms.internal.serialization.TraitSubscriber;
import com.google.android.gms.internal.serialization.zzadv;
import com.google.android.gms.internal.serialization.zzaet;
import com.google.android.gms.internal.serialization.zzaeu;
import com.google.android.gms.internal.serialization.zzvd;
import com.google.android.gms.internal.serialization.zzvh;
import com.google.android.gms.internal.serialization.zzvj;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/google/android/gms/home/internal/InternalInteractionClient$registerTraitSubscriber$2$1$onTraitNotification$1", "Lcom/google/android/gms/common/api/internal/ListenerHolder$Notifier;", "Lcom/google/nest/platform/mesh/interaction/TraitSubscriber;", "notifyListener", "", "subscriber", "onNotifyListenerFailed", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzae implements ListenerHolder.Notifier {
    final /* synthetic */ com.google.android.gms.internal.serialization.zzai zza;
    final /* synthetic */ String zzb;

    public zzae(com.google.android.gms.internal.serialization.zzai zzaiVar, String str) {
        this.zza = zzaiVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        TraitSubscriber traitSubscriber = (TraitSubscriber) obj;
        traitSubscriber.getClass();
        zzaeu zzaeuVarZza = this.zza.zza();
        int iZzg = zzaeuVarZza.zzg() - 2;
        if (iZzg == 1) {
            String str = this.zzb;
            zzvh zzvhVar = ObjectData.zza;
            zzadv zzadvVarZza = zzaeuVarZza.zza();
            zzadvVarZza.getClass();
            traitSubscriber.zza(str, zzvj.zzd(zzvhVar, zzadvVarZza));
            return;
        }
        if (iZzg == 2) {
            String str2 = this.zzb;
            zzvh zzvhVar2 = ObjectData.zza;
            zzadv zzadvVarZza2 = zzaeuVarZza.zza();
            zzadvVarZza2.getClass();
            ObjectData objectDataZzd = zzvj.zzd(zzvhVar2, zzadvVarZza2);
            List listZzb = zzaeuVarZza.zzb();
            listZzb.getClass();
            traitSubscriber.zzb(str2, objectDataZzd, listZzb);
            return;
        }
        if (iZzg == 3) {
            String str3 = this.zzb;
            List listZzc = zzaeuVarZza.zzc();
            listZzc.getClass();
            traitSubscriber.zzc(str3, listZzc);
            return;
        }
        if (iZzg == 4) {
            traitSubscriber.zzd(this.zzb);
            return;
        }
        if (iZzg != 5) {
            return;
        }
        String str4 = this.zzb;
        zzaet zzaetVarZzd = zzaeuVarZza.zzd();
        zzaetVarZzd.getClass();
        int iOrdinal = zzaetVarZzd.ordinal();
        traitSubscriber.zze(str4, iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? iOrdinal != 4 ? zzvd.zza : zzvd.zze : zzvd.zzd : zzvd.zzc : zzvd.zzb);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
