package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.share.internal.ShareInternalUtility;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhv implements zzhp {
    private final Context zza;
    private final List zzb = new ArrayList();
    private final zzhp zzc;
    private zzhp zzd;
    private zzhp zze;
    private zzhp zzf;
    private zzhp zzg;
    private zzhp zzh;
    private zzhp zzi;
    private zzhp zzj;
    private zzhp zzk;

    public zzhv(Context context, zzhp zzhpVar) {
        this.zza = context.getApplicationContext();
        this.zzc = zzhpVar;
    }

    private final zzhp zzf() {
        if (this.zze == null) {
            zzhg zzhgVar = new zzhg(this.zza);
            this.zze = zzhgVar;
            zzg(zzhgVar);
        }
        return this.zze;
    }

    private final void zzg(zzhp zzhpVar) {
        int i = 0;
        while (true) {
            List list = this.zzb;
            if (i >= list.size()) {
                return;
            }
            zzhpVar.zze((zzin) list.get(i));
            i++;
        }
    }

    private static final void zzh(zzhp zzhpVar, zzin zzinVar) {
        if (zzhpVar != null) {
            zzhpVar.zze(zzinVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzj
    public final int zza(byte[] bArr, int i, int i2) {
        zzhp zzhpVar = this.zzk;
        zzhpVar.getClass();
        return zzhpVar.zza(bArr, i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final long zzb(zzht zzhtVar) {
        zzhp zzhpVar;
        zzgtj.zzi(this.zzk == null);
        Uri uri = zzhtVar.zza;
        String scheme = uri.getScheme();
        String str = zzfl.zza;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || Objects.equals(scheme2, ShareInternalUtility.STAGING_PARAM)) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.zzd == null) {
                    zzic zzicVar = new zzic();
                    this.zzd = zzicVar;
                    zzg(zzicVar);
                }
                this.zzk = this.zzd;
            } else {
                this.zzk = zzf();
            }
        } else if ("asset".equals(scheme)) {
            this.zzk = zzf();
        } else if ("content".equals(scheme)) {
            if (this.zzf == null) {
                zzhm zzhmVar = new zzhm(this.zza);
                this.zzf = zzhmVar;
                zzg(zzhmVar);
            }
            this.zzk = this.zzf;
        } else if ("rtmp".equals(scheme)) {
            if (this.zzg == null) {
                try {
                    zzhp zzhpVar2 = (zzhp) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                    this.zzg = zzhpVar2;
                    zzg(zzhpVar2);
                } catch (ClassNotFoundException unused) {
                    zzeg.zzc("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                } catch (Exception e) {
                    Utf8$$ExternalSyntheticBUOutline0.m("Error instantiating RTMP extension", (Throwable) e);
                    return 0L;
                }
                if (this.zzg == null) {
                    this.zzg = this.zzc;
                }
            }
            this.zzk = this.zzg;
        } else if ("udp".equals(scheme)) {
            if (this.zzh == null) {
                zzip zzipVar = new zzip(2000);
                this.zzh = zzipVar;
                zzg(zzipVar);
            }
            this.zzk = this.zzh;
        } else if ("data".equals(scheme)) {
            if (this.zzi == null) {
                zzhn zzhnVar = new zzhn();
                this.zzi = zzhnVar;
                zzg(zzhnVar);
            }
            this.zzk = this.zzi;
        } else {
            if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.zzj == null) {
                    zzil zzilVar = new zzil(this.zza);
                    this.zzj = zzilVar;
                    zzg(zzilVar);
                }
                zzhpVar = this.zzj;
            } else {
                zzhpVar = this.zzc;
            }
            this.zzk = zzhpVar;
        }
        return this.zzk.zzb(zzhtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final Uri zzc() {
        zzhp zzhpVar = this.zzk;
        if (zzhpVar == null) {
            return null;
        }
        return zzhpVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzd() {
        zzhp zzhpVar = this.zzk;
        if (zzhpVar != null) {
            try {
                zzhpVar.zzd();
            } finally {
                this.zzk = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zze(zzin zzinVar) {
        zzinVar.getClass();
        this.zzc.zze(zzinVar);
        this.zzb.add(zzinVar);
        zzh(this.zzd, zzinVar);
        zzh(this.zze, zzinVar);
        zzh(this.zzf, zzinVar);
        zzh(this.zzg, zzinVar);
        zzh(this.zzh, zzinVar);
        zzh(this.zzi, zzinVar);
        zzh(this.zzj, zzinVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhp, com.google.android.gms.internal.ads.zzii
    public final Map zzj() {
        zzhp zzhpVar = this.zzk;
        return zzhpVar == null ? Collections.EMPTY_MAP : zzhpVar.zzj();
    }
}
