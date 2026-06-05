package com.google.android.gms.internal.serialization;

import com.google.home.automation.SequentialFlow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/google/home/automation/Node;", "it", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzks extends Lambda implements Function1 {
    final /* synthetic */ SequentialFlow zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzks(SequentialFlow sequentialFlow) {
        super(1);
        this.zza = sequentialFlow;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        ((String) obj).getClass();
        return this.zza;
    }
}
