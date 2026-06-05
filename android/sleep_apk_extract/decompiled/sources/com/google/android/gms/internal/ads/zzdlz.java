package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public final class zzdlz extends zzcxt {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdkc zze;
    private final zzdno zzf;
    private final zzcyo zzg;
    private final zzfxq zzh;
    private final zzdde zzi;
    private final zzcfi zzj;
    private final zzdzl zzk;
    private boolean zzl;

    public zzdlz(zzcxs zzcxsVar, Context context, @Nullable zzcku zzckuVar, zzdkc zzdkcVar, zzdno zzdnoVar, zzcyo zzcyoVar, zzfxq zzfxqVar, zzdde zzddeVar, zzcfi zzcfiVar, zzdzl zzdzlVar) {
        super(zzcxsVar);
        this.zzl = false;
        this.zzc = context;
        this.zzd = new WeakReference(zzckuVar);
        this.zze = zzdkcVar;
        this.zzf = zzdnoVar;
        this.zzg = zzcyoVar;
        this.zzh = zzfxqVar;
        this.zzi = zzddeVar;
        this.zzj = zzcfiVar;
        this.zzk = zzdzlVar;
    }

    public final void finalize() throws Throwable {
        try {
            final zzcku zzckuVar = (zzcku) this.zzd.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzhG)).booleanValue()) {
                if (!this.zzl && zzckuVar != null) {
                    zzcfr.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdly
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            zzckuVar.destroy();
                        }
                    });
                }
            } else if (zzckuVar != null) {
                zzckuVar.destroy();
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(boolean z, @Nullable Activity activity) {
        zzfkf zzfkfVarZzC;
        zzdkc zzdkcVar = this.zze;
        zzdkcVar.zza();
        com.google.android.gms.ads.internal.zzt.zzc();
        zzdno zzdnoVar = this.zzf;
        if (!com.google.android.gms.ads.internal.util.zzs.zzR(zzdnoVar.zzb())) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzpc)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                com.google.android.gms.ads.internal.util.zzs.zzQ(this.zzc, this.zzb, this.zzk);
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbm)).booleanValue()) {
                com.google.android.gms.ads.internal.zzt.zzc();
                if (com.google.android.gms.ads.internal.util.zzs.zzJ(this.zzc)) {
                    int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                    com.google.android.gms.ads.internal.util.client.zzo.zzi("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://goo.gle/admob-interstitial-policies");
                    this.zzi.zze();
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzbn)).booleanValue()) {
                        this.zzh.zza(this.zza.zzb.zzb.zzb);
                    }
                } else {
                    zzcku zzckuVar = (zzcku) this.zzd.get();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zznr)).booleanValue() || zzckuVar == null || (zzfkfVarZzC = zzckuVar.zzC()) == null || !zzfkfVarZzC.zzar || zzfkfVarZzC.zzas == this.zzj.zzj()) {
                        if (this.zzl) {
                            int i2 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                            com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial ad has been shown.");
                            this.zzi.zzc(zzfma.zzd(10, null, null));
                        }
                        Context context = activity;
                        if (!this.zzl) {
                            if (activity == null) {
                                context = this.zzc;
                            }
                            try {
                                zzdnoVar.zza(z, context, this.zzi);
                                zzdkcVar.zzb();
                                this.zzl = true;
                                return true;
                            } catch (zzdnn e) {
                                this.zzi.zzd(e);
                            }
                        }
                    } else {
                        int i3 = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
                        com.google.android.gms.ads.internal.util.client.zzo.zzi("The interstitial consent form has been shown.");
                        this.zzi.zzc(zzfma.zzd(12, "The consent form has already been shown.", null));
                    }
                }
            }
        }
        return false;
    }

    public final boolean zzb() {
        return this.zzg.zzl();
    }
}
