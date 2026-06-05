package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzzp extends zzws {
    protected final zzxm zza;

    public zzzp(zzxm zzxmVar) {
        this.zza = zzxmVar;
    }

    public abstract void zzB();

    public abstract void zzE(zzbf zzbfVar);

    public abstract zzxk zzF(zzxk zzxkVar);

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzbf zzH() {
        this.zza.zzH();
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final boolean zzI() {
        this.zza.zzI();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxm
    public final zzak zzJ() {
        return this.zza.zzJ();
    }

    @Override // com.google.android.gms.internal.ads.zzws, com.google.android.gms.internal.ads.zzwj
    public final void zza(zzin zzinVar) {
        super.zza(zzinVar);
        zzB();
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ void zzu(Object obj, zzxm zzxmVar, zzbf zzbfVar) {
        zzE(zzbfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* bridge */ /* synthetic */ int zzw(Object obj, int i) {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ zzxk zzx(Object obj, zzxk zzxkVar) {
        return zzF(zzxkVar);
    }

    @Override // com.google.android.gms.internal.ads.zzws
    public final /* synthetic */ long zzy(Object obj, long j, zzxk zzxkVar) {
        return j;
    }
}
