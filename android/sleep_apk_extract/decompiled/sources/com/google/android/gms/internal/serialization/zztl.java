package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "name", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zztl extends Lambda implements Function2 {
    final /* synthetic */ Ref$ObjectRef zza;
    final /* synthetic */ Ref$ObjectRef zzb;
    final /* synthetic */ Ref$ObjectRef zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zztl(Ref$ObjectRef ref$ObjectRef, Ref$ObjectRef ref$ObjectRef2, Ref$ObjectRef ref$ObjectRef3) {
        super(2);
        this.zza = ref$ObjectRef;
        this.zzb = ref$ObjectRef2;
        this.zzc = ref$ObjectRef3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [T, java.lang.String] */
    @Override // kotlin.jvm.functions.Function2
    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        zzvs zzvsVar = (zzvs) obj;
        String str = (String) obj2;
        zzvsVar.getClass();
        str.getClass();
        int iHashCode = str.hashCode();
        if (iHashCode != 323183821) {
            if (iHashCode != 623174938) {
                if (iHashCode == 2145552616 && str.equals("dataSourceLocality")) {
                    Ref$ObjectRef ref$ObjectRef = this.zzb;
                    zztk zztkVar = zztk.zza;
                    String strZzh = zzvsVar.zzh();
                    strZzh.getClass();
                    zztk zztkVar2 = (zztk) zztk.zzf.get(strZzh);
                    T t = zztkVar2;
                    if (zztkVar2 == null) {
                        t = zztk.zza;
                    }
                    ref$ObjectRef.element = t;
                }
            } else if (str.equals("connectivityState")) {
                Ref$ObjectRef ref$ObjectRef2 = this.zza;
                zzsk zzskVar = zzsk.zza;
                String strZzh2 = zzvsVar.zzh();
                strZzh2.getClass();
                zzsk zzskVar2 = (zzsk) zzsk.zzf.get(strZzh2);
                T t2 = zzskVar2;
                if (zzskVar2 == null) {
                    t2 = zzsk.zza;
                }
                ref$ObjectRef2.element = t2;
            }
        } else if (str.equals("owningDeviceId")) {
            this.zzc.element = zzvsVar.zzh();
        }
        return Unit.INSTANCE;
    }
}
