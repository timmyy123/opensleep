package com.google.android.gms.internal.serialization;

import com.google.home.DeviceType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/google/home/DeviceType$Metadata;", "it", "", "Lcom/google/home/Trait;", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zznf extends Lambda implements Function1 {
    final /* synthetic */ boolean zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zznf(boolean z) {
        super(1);
        this.zza = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return new DeviceType.Metadata(this.zza, zzng.zzd((List) obj));
    }
}
