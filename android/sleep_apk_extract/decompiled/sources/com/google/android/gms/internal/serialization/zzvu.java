package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a%\u0010\u0004\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a%\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0005\u001a+\u0010\n\u001a\u00020\u0002*\u00020\u00002\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/google/nest/platform/mesh/serialization/json/JsonReader;", "Lkotlin/Function1;", "", "block", "consumeObject", "(Lcom/google/nest/platform/mesh/serialization/json/JsonReader;Lkotlin/jvm/functions/Function1;)V", "consumeArray", "Lkotlin/Function2;", "", "parseValueForName", "iterateObject", "(Lcom/google/nest/platform/mesh/serialization/json/JsonReader;Lkotlin/jvm/functions/Function2;)V", "java.com.google.nest.platform.mesh.serialization.json_json-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzvu {
    public static final void zza(zzvs zzvsVar, Function1 function1) {
        zzvsVar.getClass();
        function1.getClass();
        zzvsVar.zza();
        function1.invoke(zzvsVar);
        while (zzvsVar.zze()) {
            zzvsVar.zzk();
        }
        zzvsVar.zzb();
    }

    public static final void zzb(zzvs zzvsVar, Function2 function2) {
        zzvsVar.getClass();
        function2.getClass();
        zzvt zzvtVar = new zzvt(function2);
        zzvsVar.getClass();
        zzvsVar.zzc();
        zzvtVar.invoke(zzvsVar);
        while (zzvsVar.zze()) {
            zzvsVar.zzk();
        }
        zzvsVar.zzd();
    }
}
