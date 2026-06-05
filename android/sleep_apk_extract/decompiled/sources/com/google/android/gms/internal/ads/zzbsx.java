package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.Predicate;
import java.util.Objects;
import javax.annotation.ParametersAreNonnullByDefault;
import oauth.signpost.OAuth;

/* JADX INFO: loaded from: classes3.dex */
@ParametersAreNonnullByDefault
public final class zzbsx implements zzbsp, zzbsn {
    private zzcku zza;

    public zzbsx(Context context, VersionInfoParcel versionInfoParcel, zzbap zzbapVar, com.google.android.gms.ads.internal.zza zzaVar) throws zzclj {
        com.google.android.gms.ads.internal.zzt.zzd();
        zzcku zzckuVarZza = zzclk.zza(context, zzcne.zzb(), "", false, false, null, null, versionInfoParcel, null, null, null, zzbhp.zza(), null, null, null, null, null);
        this.zza = zzckuVarZza;
        zzckuVarZza.zzE().setWillNotDraw(true);
    }

    private static final void zzs(Runnable runnable) {
        com.google.android.gms.ads.internal.client.zzay.zza();
        if (com.google.android.gms.ads.internal.util.client.zzf.zzB()) {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is the main thread, the runnable will be run now");
            runnable.run();
        } else {
            com.google.android.gms.ads.internal.util.zze.zza("runOnUiThread > the UI thread is not the main thread, the runnable will be added to the message queue");
            if (com.google.android.gms.ads.internal.util.zzs.zza.post(runnable)) {
                return;
            }
            com.google.android.gms.ads.internal.util.client.zzo.zzi("runOnUiThread > the runnable could not be placed to the message queue");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsy
    public final void zza(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("invokeJavascript on adWebView from js");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbsw
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzo(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzf(String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascript on adWebView from path: ".concat(String.valueOf(str)));
        final String str2 = "<!DOCTYPE html><html><head><script src=\"" + str + "\"></script></head><body></body></html>";
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbss
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzp(str2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzg(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtmlWrapper on adWebView from path: ".concat(String.valueOf(str)));
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbsu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzr(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzh(final String str) {
        com.google.android.gms.ads.internal.util.zze.zza("loadHtml on adWebView from html");
        zzs(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbst
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzq(str);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzi(final zzbso zzbsoVar) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzcms zzcmsVarZzP = zzckuVar.zzP();
            Objects.requireNonNull(zzbsoVar);
            zzcmsVarZzP.zzH(new zzcmr() { // from class: com.google.android.gms.internal.ads.zzbsr
                @Override // com.google.android.gms.internal.ads.zzcmr
                public final /* synthetic */ void zza() {
                    zzbsoVar.zza();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final void zzj() {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.destroy();
            this.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final boolean zzk() {
        zzcku zzckuVar = this.zza;
        return zzckuVar == null || zzckuVar.zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzbsp
    public final zzbtw zzl() {
        return new zzbtw(this);
    }

    @Override // com.google.android.gms.internal.ads.zzbtv
    public final void zzm(String str, zzbpq zzbpqVar) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.zzab(str, new zzbsq(this, zzbpqVar));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtv
    public final void zzn(String str, final zzbpq zzbpqVar) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.zzad(str, new Predicate() { // from class: com.google.android.gms.internal.ads.zzbsv
                @Override // com.google.android.gms.common.util.Predicate
                public final /* synthetic */ boolean apply(Object obj) {
                    zzbpq zzbpqVar2 = (zzbpq) obj;
                    if (zzbpqVar2 instanceof zzbsq) {
                        return ((zzbsq) zzbpqVar2).zzb().equals(zzbpqVar);
                    }
                    return false;
                }
            });
        }
    }

    public final /* synthetic */ void zzo(String str) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.zza(str);
        }
    }

    public final /* synthetic */ void zzp(String str) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.loadData(str, "text/html", OAuth.ENCODING);
        }
    }

    public final /* synthetic */ void zzq(String str) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.loadData(str, "text/html", OAuth.ENCODING);
        }
    }

    public final /* synthetic */ void zzr(String str) {
        zzcku zzckuVar = this.zza;
        if (zzckuVar != null) {
            zzckuVar.loadUrl(str);
        }
    }
}
