package com.google.android.gms.internal.serialization;

import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "name", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzss extends Lambda implements Function2 {
    final /* synthetic */ Map zza;
    final /* synthetic */ Map zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzss(Map map, Map map2) {
        super(2);
        this.zza = map;
        this.zzb = map2;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        zzvs zzvsVar = (zzvs) obj;
        String str = (String) obj2;
        zzvsVar.getClass();
        str.getClass();
        switch (str.hashCode()) {
            case -2113241981:
                if (str.equals("vendorId")) {
                    this.zza.put("vendorId", UInt.m2388boximpl(zzvsVar.zzl()));
                }
                break;
            case -1860412254:
                if (str.equals("softwareVersionString")) {
                    this.zzb.put("softwareVersionString", zzvsVar.zzh());
                }
                break;
            case -1051830678:
                if (str.equals("productId")) {
                    this.zza.put("productId", UInt.m2388boximpl(zzvsVar.zzl()));
                }
                break;
            case 303003953:
                if (str.equals("softwareVersion")) {
                    this.zza.put("softwareVersion", UInt.m2388boximpl(zzvsVar.zzl()));
                }
                break;
            case 447697426:
                if (str.equals("nodeLabel")) {
                    this.zzb.put("nodeLabel", zzvsVar.zzh());
                }
                break;
            case 996441925:
                if (str.equals("productLabel")) {
                    this.zzb.put("productLabel", zzvsVar.zzh());
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
