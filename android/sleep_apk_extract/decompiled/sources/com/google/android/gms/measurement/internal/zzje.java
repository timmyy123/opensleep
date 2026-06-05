package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

/* JADX INFO: loaded from: classes4.dex */
abstract class zzje implements zzjg {
    protected final zzic zzu;

    public zzje(zzic zzicVar) {
        Preconditions.checkNotNull(zzicVar);
        this.zzu = zzicVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzae zzaV() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzgu zzaW() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final zzhz zzaX() {
        throw null;
    }

    public void zzaY() {
        this.zzu.zzaX().zzaY();
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Context zzaZ() {
        throw null;
    }

    @Override // com.google.android.gms.measurement.internal.zzjg
    public final Clock zzba() {
        throw null;
    }

    public void zzg() {
        this.zzu.zzaX().zzg();
    }
}
