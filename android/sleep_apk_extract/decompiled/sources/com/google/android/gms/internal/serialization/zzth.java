package com.google.android.gms.internal.serialization;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "name", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzth extends Lambda implements Function2 {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;
    final /* synthetic */ Map zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzth(List list, List list2, Map map) {
        super(2);
        this.zza = list;
        this.zzb = list2;
        this.zzc = map;
    }

    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        zzvs zzvsVar = (zzvs) obj;
        String str = (String) obj2;
        zzvsVar.getClass();
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != -1292849428) {
            if (iHashCode != 210212709) {
                if (iHashCode == 292181619 && str.equals("supportedTraits")) {
                    zzvu.zza(zzvsVar, new zztf(this.zzb));
                }
            } else if (str.equals("supportedTraitInfos")) {
                zzvu.zzb(zzvsVar, new zztg(this.zzc));
            }
        } else if (str.equals("supportedObjectTypes")) {
            zzvu.zza(zzvsVar, new zzte(this.zza));
        }
        return Unit.INSTANCE;
    }
}
