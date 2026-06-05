package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzgdu implements zzggx {
    private final zzgdl zza;
    private final zzgdr zzb;
    private Context zzc;
    private View zzd;
    private Activity zze;
    private String zzf;
    private Map zzg;
    private zzaxm zzh;
    private zzgec zzi;

    public /* synthetic */ zzgdu(zzgdl zzgdlVar, zzgdr zzgdrVar, byte[] bArr) {
        this.zza = zzgdlVar;
        this.zzb = zzgdrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final zzggy zza() {
        zzinc.zzc(this.zzc, Context.class);
        zzinc.zzc(this.zzg, Map.class);
        zzinc.zzc(this.zzh, zzaxm.class);
        zzinc.zzc(this.zzi, zzgec.class);
        return new zzgdv(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi);
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* bridge */ /* synthetic */ zzggx zzb(zzgec zzgecVar) {
        zzgecVar.getClass();
        this.zzi = zzgecVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* bridge */ /* synthetic */ zzggx zzc(zzaxm zzaxmVar) {
        zzaxmVar.getClass();
        this.zzh = zzaxmVar;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* bridge */ /* synthetic */ zzggx zzd(Map map) {
        this.zzg = map;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* synthetic */ zzggx zze(String str) {
        this.zzf = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* synthetic */ zzggx zzf(Activity activity) {
        this.zze = activity;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* synthetic */ zzggx zzg(View view) {
        this.zzd = view;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzggx
    public final /* bridge */ /* synthetic */ zzggx zzh(Context context) {
        context.getClass();
        this.zzc = context;
        return this;
    }
}
