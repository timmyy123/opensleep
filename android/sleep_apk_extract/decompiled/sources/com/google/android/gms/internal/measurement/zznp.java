package com.google.android.gms.internal.measurement;

import android.os.Build;
import android.util.Log;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
abstract class zznp implements zzom {
    private final String zza;
    private final zzph zzb;

    public zznp(String str, String str2, zzph zzphVar) {
        this.zza = str2;
        this.zzb = zzphVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzom, com.google.common.base.Supplier
    public final Object get() {
        return Preconditions.checkNotNull(zzb(zzlk.zzb()));
    }

    public abstract Object zza();

    public final Object zzaA(zznw zznwVar, final zzlk zzlkVar, String str) {
        zzpg zzpgVarZza;
        Object objZza;
        String strZza;
        int iZzf = zznwVar.zzf();
        if (iZzf == -1 || iZzf < zznwVar.zzg().zza()) {
            synchronized (zznwVar) {
                try {
                    int iZzf2 = zznwVar.zzf();
                    Object objZzd = null;
                    if (iZzf2 == -1) {
                        zzlk.zzl();
                        Preconditions.checkNotNull(zzlkVar);
                        zzpgVarZza = this.zzb.zza(zzlkVar, "");
                        zznwVar.zzj(zzpgVarZza.zzc());
                    } else {
                        zzpgVarZza = null;
                    }
                    int iZza = zznwVar.zzg().zza();
                    if (iZzf2 < iZza) {
                        zzlk.zzl();
                        Preconditions.checkNotNull(zzlkVar);
                        Optional optionalZza = zzlf.zza(zzlkVar.zzc());
                        if (!optionalZza.isPresent() || (strZza = ((zzle) optionalZza.get()).zza(zzlg.zza("com.google.android.gms.measurement"), null, null, this.zza)) == null) {
                            objZza = null;
                        } else {
                            try {
                                objZza = zzc(strZza);
                            } catch (IOException | IllegalArgumentException e) {
                                Log.e("FilePhenotypeFlags", "Invalid Phenotype flag value for flag ".concat(this.zza), e);
                                objZza = null;
                            }
                        }
                        if (zzpgVarZza == null) {
                            zzpgVarZza = this.zzb.zza(zzlkVar, "");
                        }
                        final String strZzb = zzpgVarZza.zzb();
                        if (Build.VERSION.SDK_INT >= 26 && !zzlkVar.zzc().getPackageName().equals("com.android.vending") && !strZzb.startsWith("com.google.android.gms.measurement#")) {
                            zzpx.zza(zzlkVar.zzg().submit(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzpn
                                @Override // java.lang.Runnable
                                public final /* synthetic */ void run() {
                                    Map mapZza = zzpp.zza(zzlkVar.zzc());
                                    String str2 = strZzb;
                                    if (mapZza.containsKey(str2)) {
                                        return;
                                    }
                                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 173);
                                    sb.append("Config package ");
                                    sb.append(str2);
                                    sb.append(" cannot use FILE backing without declarative registration. See go/phenotype-android-integration#phenotype for more information. This will lead to stale flags.");
                                    Log.e("FilePhenotypeFlags", sb.toString());
                                }
                            }));
                        }
                        Object objZza2 = zzpgVarZza.zza(this.zza, false);
                        if (objZza2 != null) {
                            try {
                                objZzd = zzd(objZza2);
                            } catch (IOException | ClassCastException e2) {
                                Log.e("FilePhenotypeFlags", "Invalid Phenotype flag value for flag ".concat(this.zza), e2);
                            }
                        }
                        if (true != optionalZza.isPresent()) {
                            objZza = objZzd;
                        }
                        if (objZza == null) {
                            objZza = zza();
                        }
                        if (objZza != null) {
                            zznwVar.zzh(objZza);
                            zznwVar.zzi(iZza);
                        }
                        return objZza;
                    }
                } finally {
                }
            }
        }
        return zznwVar.zze();
    }

    public abstract Object zzb(zzlk zzlkVar);

    public abstract Object zzc(String str);

    public abstract Object zzd(Object obj);
}
