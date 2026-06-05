package com.google.android.gms.home.internal;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.internal.serialization.EventImportance;
import com.google.android.gms.internal.serialization.EventPayload;
import com.google.android.gms.internal.serialization.TraitElementPayload;
import com.google.android.gms.internal.serialization.zzabp;
import com.google.android.gms.internal.serialization.zzacv;
import com.google.android.gms.internal.serialization.zzade;
import com.google.android.gms.internal.serialization.zzadg;
import com.google.android.gms.internal.serialization.zzadi;
import com.google.android.gms.internal.serialization.zzaep;
import com.google.android.gms.internal.serialization.zzh;
import com.google.android.gms.internal.serialization.zzid;
import com.google.android.gms.internal.serialization.zztr;
import com.google.android.gms.internal.serialization.zzvj;
import com.google.android.gms.internal.serialization.zzvm;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/google/android/gms/home/internal/InternalInteractionClient$registerEventSubscriber$2$1$onEvent$1", "Lcom/google/android/gms/common/api/internal/ListenerHolder$Notifier;", "Lcom/google/nest/platform/mesh/interaction/EventSubscriber;", "notifyListener", "", "subscriber", "onNotifyListenerFailed", "java.com.google.android.gmscore.integ.client.home_home"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class zzu implements ListenerHolder.Notifier {
    final /* synthetic */ zzh zza;
    final /* synthetic */ String zzb;

    public zzu(zzh zzhVar, String str) {
        this.zza = zzhVar;
        this.zzb = str;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final void notifyListener(zztr zztrVar) {
        EventImportance eventImportance;
        zztrVar.getClass();
        zzadi zzadiVarZza = this.zza.zza();
        if (zzadiVarZza.zzd() - 2 != 1) {
            return;
        }
        String str = this.zzb;
        String strZza = zzadiVarZza.zza().zza();
        strZza.getClass();
        List listZzb = zzadiVarZza.zza().zzb();
        listZzb.getClass();
        List<zzadg> list = listZzb;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (zzadg zzadgVar : list) {
            zzadgVar.getClass();
            zzabp zzabpVarZza = zzadgVar.zza();
            zzacv.zza(zzabpVarZza);
            long jZza = zzid.zza(zzid.zzc(zzabpVarZza.zza(), 1000L), zzabpVarZza.zzb() / 1000000);
            zzvm zzvmVar = TraitElementPayload.zza;
            zzaep zzaepVarZzb = zzadgVar.zzb();
            zzaepVarZzb.getClass();
            TraitElementPayload traitElementPayloadZzb = zzvj.zzb(zzvmVar, zzaepVarZzb);
            zzade zzadeVarZzc = zzadgVar.zzc();
            zzadeVarZzc.getClass();
            int iOrdinal = zzadeVarZzc.ordinal();
            if (iOrdinal == 0) {
                eventImportance = EventImportance.zze;
            } else if (iOrdinal == 1) {
                eventImportance = EventImportance.zza;
            } else if (iOrdinal == 2) {
                eventImportance = EventImportance.zzb;
            } else if (iOrdinal == 3) {
                eventImportance = EventImportance.zzc;
            } else if (iOrdinal == 4) {
                eventImportance = EventImportance.zzd;
            } else {
                if (iOrdinal != 5) {
                    Home$$ExternalSyntheticBUOutline0.m();
                    return;
                }
                eventImportance = EventImportance.zze;
            }
            arrayList.add(new EventPayload(jZza, traitElementPayloadZzb, eventImportance, ULong.m2411constructorimpl(zzadgVar.zzd()), null));
        }
        zztrVar.zza(str, strZza, CollectionsKt.toList(arrayList));
    }
}
