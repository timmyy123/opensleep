package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zzae;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.util.zzaa;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzcg;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.util.zzv;
import com.google.android.gms.ads.internal.util.zzx;
import com.google.android.gms.ads.internal.util.zzy;
import com.google.android.gms.ads.internal.util.zzz;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzbgx;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzbjp;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbux;
import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzcdz;
import com.google.android.gms.internal.ads.zzcfd;
import com.google.android.gms.internal.ads.zzcfm;
import com.google.android.gms.internal.ads.zzcfx;
import com.google.android.gms.internal.ads.zzcge;
import com.google.android.gms.internal.ads.zzcit;
import com.google.android.gms.internal.ads.zzclk;
import com.google.android.gms.internal.ads.zzelh;
import com.google.android.gms.internal.ads.zzeli;

/* JADX INFO: loaded from: classes3.dex */
public final class zzt {
    private static final zzt zza = new zzt();
    private final zzbhm zzA;
    private final zzcdz zzB;
    private final zzcg zzC;
    private final zzcit zzD;
    private final zzcge zzE;
    private final com.google.android.gms.ads.internal.overlay.zza zzb;
    private final com.google.android.gms.ads.internal.overlay.zzn zzc;
    private final com.google.android.gms.ads.internal.util.zzs zzd;
    private final zzclk zze;
    private final zzcfm zzf;
    private final zzz zzg;
    private final zzbfl zzh;
    private final zzcfd zzi;
    private final zzaa zzj;
    private final zzbgx zzk;
    private final Clock zzl;
    private final zzf zzm;
    private final zzbiw zzn;
    private final zzbjp zzo;
    private final zzax zzp;
    private final zzcbk zzq;
    private final zzcfx zzr;
    private final zzbtz zzs;
    private final com.google.android.gms.ads.internal.overlay.zzz zzt;
    private final zzbq zzu;
    private final zzae zzv;
    private final zzaf zzw;
    private final zzbux zzx;
    private final zzbr zzy;
    private final zzeli zzz;

    public zzt() {
        com.google.android.gms.ads.internal.overlay.zza zzaVar = new com.google.android.gms.ads.internal.overlay.zza();
        com.google.android.gms.ads.internal.overlay.zzn zznVar = new com.google.android.gms.ads.internal.overlay.zzn();
        com.google.android.gms.ads.internal.util.zzs zzsVar = new com.google.android.gms.ads.internal.util.zzs();
        zzclk zzclkVar = new zzclk();
        zzcfm zzcfmVar = new zzcfm();
        int i = Build.VERSION.SDK_INT;
        zzz zzyVar = i >= 30 ? new zzy() : i >= 28 ? new zzx() : i >= 26 ? new zzv() : new zzu();
        zzbfl zzbflVar = new zzbfl();
        zzcfd zzcfdVar = new zzcfd();
        zzaa zzaaVar = new zzaa();
        zzbgx zzbgxVar = new zzbgx();
        Clock defaultClock = DefaultClock.getInstance();
        zzf zzfVar = new zzf();
        zzbiw zzbiwVar = new zzbiw();
        zzbjp zzbjpVar = new zzbjp();
        zzax zzaxVar = new zzax();
        zzcbk zzcbkVar = new zzcbk();
        zzcfx zzcfxVar = new zzcfx();
        zzbtz zzbtzVar = new zzbtz();
        com.google.android.gms.ads.internal.overlay.zzz zzzVar = new com.google.android.gms.ads.internal.overlay.zzz();
        zzbq zzbqVar = new zzbq();
        zzae zzaeVar = new zzae();
        zzaf zzafVar = new zzaf();
        zzbux zzbuxVar = new zzbux();
        zzbr zzbrVar = new zzbr();
        zzelh zzelhVar = new zzelh();
        zzbhm zzbhmVar = new zzbhm();
        zzcdz zzcdzVar = new zzcdz();
        zzcg zzcgVar = new zzcg();
        zzcit zzcitVar = new zzcit();
        zzcge zzcgeVar = new zzcge();
        this.zzb = zzaVar;
        this.zzc = zznVar;
        this.zzd = zzsVar;
        this.zze = zzclkVar;
        this.zzf = zzcfmVar;
        this.zzg = zzyVar;
        this.zzh = zzbflVar;
        this.zzi = zzcfdVar;
        this.zzj = zzaaVar;
        this.zzk = zzbgxVar;
        this.zzl = defaultClock;
        this.zzm = zzfVar;
        this.zzn = zzbiwVar;
        this.zzo = zzbjpVar;
        this.zzp = zzaxVar;
        this.zzq = zzcbkVar;
        this.zzr = zzcfxVar;
        this.zzs = zzbtzVar;
        this.zzu = zzbqVar;
        this.zzt = zzzVar;
        this.zzv = zzaeVar;
        this.zzw = zzafVar;
        this.zzx = zzbuxVar;
        this.zzy = zzbrVar;
        this.zzz = zzelhVar;
        this.zzA = zzbhmVar;
        this.zzB = zzcdzVar;
        this.zzC = zzcgVar;
        this.zzD = zzcitVar;
        this.zzE = zzcgeVar;
    }

    public static zzcg zzA() {
        return zza.zzC;
    }

    public static zzcit zzB() {
        return zza.zzD;
    }

    public static zzcge zzC() {
        return zza.zzE;
    }

    public static zzcdz zzD() {
        return zza.zzB;
    }

    public static com.google.android.gms.ads.internal.overlay.zza zza() {
        return zza.zzb;
    }

    public static com.google.android.gms.ads.internal.overlay.zzn zzb() {
        return zza.zzc;
    }

    public static com.google.android.gms.ads.internal.util.zzs zzc() {
        return zza.zzd;
    }

    public static zzclk zzd() {
        return zza.zze;
    }

    public static zzcfm zze() {
        return zza.zzf;
    }

    public static zzz zzf() {
        return zza.zzg;
    }

    public static zzbfl zzg() {
        return zza.zzh;
    }

    public static zzcfd zzh() {
        return zza.zzi;
    }

    public static zzaa zzi() {
        return zza.zzj;
    }

    public static zzbgx zzj() {
        return zza.zzk;
    }

    public static Clock zzk() {
        return zza.zzl;
    }

    public static zzf zzl() {
        return zza.zzm;
    }

    public static zzbiw zzm() {
        return zza.zzn;
    }

    public static zzbjp zzn() {
        return zza.zzo;
    }

    public static zzax zzo() {
        return zza.zzp;
    }

    public static zzcbk zzp() {
        return zza.zzq;
    }

    public static zzcfx zzq() {
        return zza.zzr;
    }

    public static zzbtz zzr() {
        return zza.zzs;
    }

    public static zzbq zzs() {
        return zza.zzu;
    }

    public static com.google.android.gms.ads.internal.overlay.zzz zzt() {
        return zza.zzt;
    }

    public static zzeli zzu() {
        return zza.zzz;
    }

    public static zzae zzv() {
        return zza.zzv;
    }

    public static zzaf zzw() {
        return zza.zzw;
    }

    public static zzbux zzx() {
        return zza.zzx;
    }

    public static zzbr zzy() {
        return zza.zzy;
    }

    public static zzbhm zzz() {
        return zza.zzA;
    }
}
