package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
final class zzli extends zzlo {
    private final /* synthetic */ zzlh zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzli(zzlh zzlhVar) {
        super(zzlhVar, null);
        this.zza = zzlhVar;
    }

    @Override // com.google.android.gms.internal.vision.zzlo, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzlj(this.zza, null);
    }

    public /* synthetic */ zzli(zzlh zzlhVar, zzlg zzlgVar) {
        this(zzlhVar);
    }
}
