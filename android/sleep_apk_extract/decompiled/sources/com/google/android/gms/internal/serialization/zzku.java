package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0004*\n\u0010\u0000\"\u00020\u00012\u00020\u0001*\"\u0010\u0002\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0007"}, d2 = {"OperatorProto", "Lcom/google/home/platform/traits/Expression$Operator;", "DeviceTypeIdToTraitId", "Lkotlin/Pair;", "", "isMatterTrait", "", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzku {
    public static final boolean zza(String str) {
        str.getClass();
        return StringsKt.startsWith$default(str, "home.matter.");
    }
}
