package com.google.android.gms.internal.serialization;

import com.google.home.FactoryRegistry;
import com.google.home.HomeConfig;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u00012\n\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "it", "", "Lcom/google/nest/platform/mesh/serialization/TraitId;", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzro extends Lambda implements Function1 {
    final /* synthetic */ zzrp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzro(zzrp zzrpVar) {
        super(1);
        this.zza = zzrpVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        HomeConfig homeConfigZza;
        FactoryRegistry factoryRegistry;
        String str = (String) obj;
        str.getClass();
        InteractionClient interactionClient = (InteractionClient) this.zza.zzc.getValue();
        if (interactionClient == null || (homeConfigZza = interactionClient.zza()) == null || (factoryRegistry = homeConfigZza.getFactoryRegistry()) == null) {
            return null;
        }
        return factoryRegistry.getTraitOrNull(str);
    }
}
