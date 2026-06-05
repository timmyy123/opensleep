package com.google.android.gms.common.api.internal;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zaae extends zabb {
    final /* synthetic */ zaag zaa;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaae(zaag zaagVar, zaba zabaVar) {
        super(zabaVar);
        Objects.requireNonNull(zaagVar);
        this.zaa = zaagVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabb
    public final void zaa() {
        this.zaa.zah(1);
    }
}
