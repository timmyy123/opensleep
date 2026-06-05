package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class zzgrr {
    public static final /* synthetic */ int $r8$clinit = 0;
    private static final zzgsj zzc = new zzgsj("OverlayDisplayService");
    private static final Intent zzd = new Intent("com.google.android.play.core.lmd.BIND_OVERLAY_DISPLAY_SERVICE").setPackage("com.android.vending");
    final zzgsi zza;
    private final String zze;

    public zzgrr(Context context) {
        if (zzgsl.zza(context)) {
            this.zza = new zzgsi(context.getApplicationContext(), zzc, "OverlayDisplayService", zzd, zzgrc.zza);
        } else {
            this.zza = null;
        }
        this.zze = context.getPackageName();
    }

    private static boolean zzh(String str) {
        return zzgua.zza(str).trim().isEmpty();
    }

    private static void zzi(String str, zzgrq zzgrqVar) {
        if (zzh(str)) {
            return;
        }
        str.getClass();
        zzgrqVar.zza(str.trim());
    }

    private static boolean zzj(zzgrw zzgrwVar, String str, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!zzh((String) it.next())) {
                return true;
            }
        }
        zzc.zzc(str, new Object[0]);
        zzgru zzgruVarZzd = zzgrv.zzd();
        zzgruVarZzd.zzc(0);
        zzgruVarZzd.zza(8160);
        zzgrwVar.zza(zzgruVarZzd.zzd());
        return false;
    }

    public final void zza(final zzgrt zzgrtVar, final zzgrw zzgrwVar) {
        zzgsi zzgsiVar = this.zza;
        if (zzgsiVar == null) {
            zzc.zzc("error: %s", "Play Store not found.");
        } else if (zzj(zzgrwVar, "Failed to apply OverlayDisplayShowRequest: missing appId and sessionToken.", Arrays.asList(null, zzgrtVar.zzb()))) {
            zzgsiVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgro
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zze(zzgrtVar, zzgrwVar);
                }
            });
        }
    }

    public final void zzb(final zzgqy zzgqyVar, final zzgrw zzgrwVar) {
        zzgsi zzgsiVar = this.zza;
        if (zzgsiVar == null) {
            zzc.zzc("error: %s", "Play Store not found.");
        } else if (zzj(zzgrwVar, "Failed to apply OverlayDisplayDismissRequest: missing appId and sessionToken.", Arrays.asList(zzgqyVar.zza(), zzgqyVar.zzb()))) {
            zzgsiVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgrd
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzf(zzgqyVar, zzgrwVar);
                }
            });
        }
    }

    public final void zzc(final zzgry zzgryVar, final zzgrw zzgrwVar, final int i) {
        zzgsi zzgsiVar = this.zza;
        if (zzgsiVar == null) {
            zzc.zzc("error: %s", "Play Store not found.");
        } else if (zzj(zzgrwVar, "Failed to apply OverlayDisplayUpdateRequest: missing appId and sessionToken.", Arrays.asList(zzgryVar.zza(), zzgryVar.zzb()))) {
            zzgsiVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzgrf
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzg(zzgryVar, i, zzgrwVar);
                }
            });
        }
    }

    public final void zzd() {
        zzgsi zzgsiVar = this.zza;
        if (zzgsiVar == null) {
            return;
        }
        zzc.zza("unbind LMD display overlay service", new Object[0]);
        zzgsiVar.zzb();
    }

    public final /* synthetic */ void zze(zzgrt zzgrtVar, zzgrw zzgrwVar) {
        try {
            zzgsi zzgsiVar = this.zza;
            if (zzgsiVar == null) {
                throw null;
            }
            zzgqm zzgqmVar = (zzgqm) zzgsiVar.zzc();
            if (zzgqmVar == null) {
                return;
            }
            String str = this.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            bundle.putBinder("windowToken", zzgrtVar.zza());
            zzi(zzgrtVar.zzj(), new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrg
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("adFieldEnifd", str2);
                }
            });
            bundle.putInt("layoutGravity", zzgrtVar.zzc());
            bundle.putFloat("layoutVerticalMargin", zzgrtVar.zzd());
            bundle.putInt("displayMode", 0);
            bundle.putInt("triggerMode", 0);
            bundle.putInt("windowWidthPx", zzgrtVar.zzh());
            zzi(null, new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrh
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("deeplinkUrl", str2);
                }
            });
            zzi(null, new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgri
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("sessionToken", str2);
                }
            });
            zzi(zzgrtVar.zzb(), new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrj
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("appId", str2);
                }
            });
            zzi(null, new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrk
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("thirdPartyAuthCallerId", str2);
                }
            });
            bundle.putBoolean("stableSessionToken", true);
            zzgqmVar.zze(str, bundle, new zzgrp(this, zzgrwVar));
        } catch (RemoteException e) {
            zzc.zzd(e, "show overlay display from: %s", this.zze);
        }
    }

    public final /* synthetic */ void zzf(zzgqy zzgqyVar, zzgrw zzgrwVar) {
        try {
            zzgsi zzgsiVar = this.zza;
            if (zzgsiVar == null) {
                throw null;
            }
            zzgqm zzgqmVar = (zzgqm) zzgsiVar.zzc();
            if (zzgqmVar == null) {
                return;
            }
            String str = this.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            zzi(zzgqyVar.zza(), new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrl
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("sessionToken", str2);
                }
            });
            zzi(zzgqyVar.zzb(), new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrm
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i = zzgrr.$r8$clinit;
                    bundle.putString("appId", str2);
                }
            });
            zzgqmVar.zzf(bundle, new zzgrp(this, zzgrwVar));
        } catch (RemoteException e) {
            zzc.zzd(e, "dismiss overlay display from: %s", this.zze);
        }
    }

    public final /* synthetic */ void zzg(zzgry zzgryVar, int i, zzgrw zzgrwVar) {
        try {
            zzgsi zzgsiVar = this.zza;
            if (zzgsiVar == null) {
                throw null;
            }
            zzgqm zzgqmVar = (zzgqm) zzgsiVar.zzc();
            if (zzgqmVar == null) {
                return;
            }
            String str = this.zze;
            final Bundle bundle = new Bundle();
            bundle.putString("callerPackage", str);
            bundle.putInt("displayMode", i);
            zzi(zzgryVar.zza(), new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgrn
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i2 = zzgrr.$r8$clinit;
                    bundle.putString("sessionToken", str2);
                }
            });
            zzi(zzgryVar.zzb(), new zzgrq() { // from class: com.google.android.gms.internal.ads.zzgre
                @Override // com.google.android.gms.internal.ads.zzgrq
                public final /* synthetic */ void zza(String str2) {
                    int i2 = zzgrr.$r8$clinit;
                    bundle.putString("appId", str2);
                }
            });
            zzgqmVar.zzg(bundle, new zzgrp(this, zzgrwVar));
        } catch (RemoteException e) {
            zzc.zzd(e, "switchDisplayMode overlay display to %d from: %s", Integer.valueOf(i), this.zze);
        }
    }
}
