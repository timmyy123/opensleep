package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcvf extends zzcxt {
    private final zzcku zzc;
    private final int zzd;
    private final Context zze;
    private final zzcut zzf;
    private final zzdno zzg;
    private final zzdkc zzh;
    private final zzdde zzi;
    private final boolean zzj;
    private final zzcfi zzk;
    private final zzdzl zzl;
    private boolean zzm;

    public zzcvf(zzcxs zzcxsVar, Context context, zzcku zzckuVar, int i, zzcut zzcutVar, zzdno zzdnoVar, zzdkc zzdkcVar, zzdde zzddeVar, zzcfi zzcfiVar, zzdzl zzdzlVar) {
        super(zzcxsVar);
        this.zzm = false;
        this.zzc = zzckuVar;
        this.zze = context;
        this.zzd = i;
        this.zzf = zzcutVar;
        this.zzg = zzdnoVar;
        this.zzh = zzdkcVar;
        this.zzi = zzddeVar;
        this.zzj = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzgv)).booleanValue();
        this.zzk = zzcfiVar;
        this.zzl = zzdzlVar;
    }

    public final void zza(zzbgd zzbgdVar) {
        zzcku zzckuVar = this.zzc;
        if (zzckuVar != null) {
            zzckuVar.zzay(zzbgdVar);
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void zzb(Activity activity, zzbgq zzbgqVar, boolean z) {
        zzcku zzckuVar;
        zzfkf zzfkfVarZzC;
        Context context = activity;
        if (activity == null) {
            context = this.zze;
        }
        boolean z2 = this.zzj;
        if (z2) {
            this.zzh.zza();
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        zzdno zzdnoVar = this.zzg;
        if (!com.google.android.gms.ads.internal.util.zzs.zzR(zzdnoVar.zzb())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpc)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                com.google.android.gms.ads.internal.util.zzs.zzQ(context, this.zzb, this.zzl);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbm)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                if (com.google.android.gms.ads.internal.util.zzs.zzJ(context)) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://goo.gle/admob-interstitial-policies");
                    this.zzi.zze();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbn)).booleanValue()) {
                        new zzfxq(context.getApplicationContext(), com.google.android.gms.ads.internal.zzt.zzs().zza()).zza(this.zza.zzb.zzb.zzb);
                        return;
                    }
                    return;
                }
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznr)).booleanValue() && (zzckuVar = this.zzc) != null && (zzfkfVarZzC = zzckuVar.zzC()) != null && zzfkfVarZzC.zzar && zzfkfVarZzC.zzas != this.zzk.zzj()) {
            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("The app open consent form has been shown.");
            this.zzi.zzc(zzfma.zzd(12, "The consent form has already been shown.", null));
            return;
        }
        if (this.zzm) {
            int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("App open interstitial ad is already visible.");
            this.zzi.zzc(zzfma.zzd(10, null, null));
        }
        if (this.zzm) {
            return;
        }
        try {
            zzdnoVar.zza(z, context, this.zzi);
            if (z2) {
                this.zzh.zzb();
            }
            this.zzm = true;
        } catch (zzdnn e) {
            this.zzi.zzd(e);
        }
    }

    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final void zzd() {
        super.zzd();
        zzcku zzckuVar = this.zzc;
        if (zzckuVar != null) {
            zzckuVar.destroy();
        }
    }

    public final void zze(long j, int i) {
        this.zzf.zza(j, i);
    }
}
