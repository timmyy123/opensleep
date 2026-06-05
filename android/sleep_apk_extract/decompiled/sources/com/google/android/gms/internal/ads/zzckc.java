package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzckc extends zzche implements zzin, zznp {
    public static final /* synthetic */ int $r8$clinit = 0;
    private final Context zzb;
    private final zzcjm zzc;
    private final zzaay zzd;
    private final zzchm zze;
    private final WeakReference zzf;
    private final zzyt zzg;
    private zzjv zzh;
    private ByteBuffer zzi;
    private boolean zzj;
    private zzchd zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private final String zzo;
    private final int zzp;
    private Integer zzr;
    private final ArrayList zzs;
    private volatile zzcjp zzt;
    private final Object zzq = new Object();
    private final Set zzu = new HashSet();

    /* JADX WARN: Removed duplicated region for block: B:22:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzckc(Context context, zzchm zzchmVar, zzchn zzchnVar, Integer num) {
        final zzho zzhoVar;
        this.zzb = context;
        this.zze = zzchmVar;
        this.zzr = num;
        this.zzf = new WeakReference(zzchnVar);
        zzcjm zzcjmVar = new zzcjm();
        this.zzc = zzcjmVar;
        zzaay zzaayVar = new zzaay(context);
        this.zzd = zzaayVar;
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter initialize ".concat(toString()));
        }
        zzche.zzf().incrementAndGet();
        zznj zznjVar = new zznj(context, new zznf() { // from class: com.google.android.gms.internal.ads.zzcjx
            @Override // com.google.android.gms.internal.ads.zznf
            public final /* synthetic */ zzna[] zza(Handler handler, zzaep zzaepVar, zzrv zzrvVar, zzzq zzzqVar, zzwi zzwiVar) {
                return this.zza.zzW(handler, zzaepVar, zzrvVar, zzzqVar, zzwiVar);
            }
        });
        zznjVar.zza(zzaayVar);
        zznjVar.zzb(zzcjmVar);
        zznk zznkVarZzc = zznjVar.zzc();
        this.zzh = zznkVarZzc;
        zznkVarZzc.zzD(this);
        this.zzl = 0;
        this.zzn = 0L;
        this.zzm = 0;
        this.zzs = new ArrayList();
        this.zzt = null;
        this.zzo = (String) zzgth.zzd(zzchnVar != null ? zzchnVar.zzn() : null).zza("");
        this.zzp = zzchnVar != null ? zzchnVar.zzp() : 0;
        final String strZze = com.google.android.gms.ads.internal.zzt.zzc().zze(context, zzchnVar.zzs().afmaVersion);
        if (!this.zzj || this.zzi.limit() <= 0) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcJ)).booleanValue()) {
                if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue()) {
                    final boolean z = zzchmVar.zzi ? false : true;
                    final zzho zzhoVar2 = zzchmVar.zzl ? new zzho() { // from class: com.google.android.gms.internal.ads.zzcjs
                        @Override // com.google.android.gms.internal.ads.zzho
                        public final /* synthetic */ zzhp zza() {
                            return this.zza.zzS(strZze, z);
                        }
                    } : zzchmVar.zzh > 0 ? new zzho() { // from class: com.google.android.gms.internal.ads.zzcju
                        @Override // com.google.android.gms.internal.ads.zzho
                        public final /* synthetic */ zzhp zza() {
                            return this.zza.zzU(strZze, z);
                        }
                    } : new zzho() { // from class: com.google.android.gms.internal.ads.zzcjt
                        @Override // com.google.android.gms.internal.ads.zzho
                        public final /* synthetic */ zzhp zza() {
                            return this.zza.zzT(strZze, z);
                        }
                    };
                    zzhoVar = zzchmVar.zzi ? new zzho() { // from class: com.google.android.gms.internal.ads.zzcjv
                        @Override // com.google.android.gms.internal.ads.zzho
                        public final /* synthetic */ zzhp zza() {
                            return this.zza.zzV(zzhoVar2);
                        }
                    } : zzhoVar2;
                    ByteBuffer byteBuffer = this.zzi;
                    if (byteBuffer != null && byteBuffer.limit() > 0) {
                        final byte[] bArr = new byte[this.zzi.limit()];
                        this.zzi.get(bArr);
                        zzhoVar = new zzho() { // from class: com.google.android.gms.internal.ads.zzcjw
                            @Override // com.google.android.gms.internal.ads.zzho
                            public final /* synthetic */ zzhp zza() {
                                int i = zzckc.$r8$clinit;
                                zzhp zzhpVarZza = zzhoVar.zza();
                                byte[] bArr2 = bArr;
                                return new zzcjq(new zzhk(bArr2), bArr2.length, zzhpVarZza);
                            }
                        };
                    }
                }
            }
        } else {
            final byte[] bArr2 = new byte[this.zzi.limit()];
            this.zzi.get(bArr2);
            zzhoVar = new zzho() { // from class: com.google.android.gms.internal.ads.zzcjr
                @Override // com.google.android.gms.internal.ads.zzho
                public final /* synthetic */ zzhp zza() {
                    int i = zzckc.$r8$clinit;
                    return new zzhk(bArr2);
                }
            };
        }
        this.zzg = new zzyt(zzhoVar, ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzp)).booleanValue() ? zzcjz.zza : zzcjy.zza);
    }

    private final boolean zzY() {
        return this.zzt != null && this.zzt.zzl();
    }

    public final void finalize() {
        zzche.zzf().decrementAndGet();
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("SimpleExoPlayerAdapter finalize ".concat(toString()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzA(int i) {
        Iterator it = this.zzu.iterator();
        while (it.hasNext()) {
            zzcjl zzcjlVar = (zzcjl) ((WeakReference) it.next()).get();
            if (zzcjlVar != null) {
                zzcjlVar.zzk(i);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final boolean zzB() {
        return this.zzh != null;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final int zzC() {
        return this.zzh.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzD() {
        return this.zzh.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzE(boolean z) {
        this.zzh.zzj(z);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzF(int i) {
        this.zzc.zzk(i);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzG(int i) {
        this.zzc.zzl(i);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzH() {
        return this.zzh.zzt();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzI() {
        if (zzY()) {
            return 0L;
        }
        return this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzJ() {
        if (zzY() && this.zzt.zzm()) {
            return Math.min(this.zzl, this.zzt.zzo());
        }
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzK() {
        if (zzY()) {
            return this.zzt.zzp();
        }
        synchronized (this.zzq) {
            while (true) {
                ArrayList arrayList = this.zzs;
                if (!arrayList.isEmpty()) {
                    long j = this.zzn;
                    Map mapZzj = ((zzii) arrayList.remove(0)).zzj();
                    long j2 = 0;
                    if (mapZzj != null) {
                        Iterator it = mapZzj.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (entry != null) {
                                try {
                                    if (entry.getKey() != null && zzgss.zze("content-length", (CharSequence) entry.getKey()) && entry.getValue() != null && ((List) entry.getValue()).get(0) != null) {
                                        j2 = Long.parseLong((String) ((List) entry.getValue()).get(0));
                                        break;
                                    }
                                } catch (NumberFormatException unused) {
                                    continue;
                                }
                            }
                        }
                    }
                    this.zzn = j + j2;
                }
            }
        }
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final int zzL() {
        return this.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzM(boolean z) {
        if (this.zzh == null) {
            return;
        }
        int i = 0;
        while (true) {
            this.zzh.zzF();
            if (i >= 2) {
                return;
            }
            zzaay zzaayVar = this.zzd;
            zzaal zzaalVarZzd = zzaayVar.zzc().zzd();
            zzaalVarZzd.zzy(i, !z);
            zzaayVar.zzf(zzaalVarZzd);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzN() {
        return this.zzh.zzv();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final long zzO() {
        return this.zzl;
    }

    public final zzxm zzR(Uri uri) {
        zzz zzzVar = new zzz();
        zzzVar.zzb(uri);
        zzak zzakVarZzc = zzzVar.zzc();
        zzyt zzytVar = this.zzg;
        zzytVar.zza(this.zze.zzf);
        return zzytVar.zzb(zzakVarZzc);
    }

    public final /* synthetic */ zzhp zzS(String str, boolean z) {
        zzckc zzckcVar = true != z ? null : this;
        zzchm zzchmVar = this.zze;
        return new zzckf(str, zzckcVar, zzchmVar.zzd, zzchmVar.zze, zzchmVar.zzm, zzchmVar.zzn);
    }

    public final /* synthetic */ zzhp zzT(String str, boolean z) {
        zzhw zzhwVar = new zzhw();
        zzhwVar.zzb(str);
        zzhwVar.zzf(true != z ? null : this);
        zzchm zzchmVar = this.zze;
        zzhwVar.zzc(zzchmVar.zzd);
        zzhwVar.zzd(zzchmVar.zze);
        zzhwVar.zze(true);
        return zzhwVar.zza();
    }

    public final /* synthetic */ zzhp zzU(String str, boolean z) {
        zzckc zzckcVar = true != z ? null : this;
        zzchm zzchmVar = this.zze;
        zzcjl zzcjlVar = new zzcjl(str, zzckcVar, zzchmVar.zzd, zzchmVar.zze, zzchmVar.zzh);
        this.zzu.add(new WeakReference(zzcjlVar));
        return zzcjlVar;
    }

    public final /* synthetic */ zzhp zzV(zzho zzhoVar) {
        zzhp zzhpVarZza = zzhoVar.zza();
        zzcjn zzcjnVar = new zzcjn() { // from class: com.google.android.gms.internal.ads.zzcka
            @Override // com.google.android.gms.internal.ads.zzcjn
            public final /* synthetic */ void zza(boolean z, long j) {
                this.zza.zzX(z, j);
            }
        };
        return new zzcjp(this.zzb, zzhpVarZza, this.zzo, this.zzp, this, zzcjnVar);
    }

    public final /* synthetic */ zzna[] zzW(Handler handler, zzaep zzaepVar, zzrv zzrvVar, zzzq zzzqVar, zzwi zzwiVar) {
        zzvv zzvvVar = zzvv.zzb;
        Context context = this.zzb;
        zztx zztxVar = new zztx(context, new zzvb(context, null, null), zzvvVar, false, handler, zzrvVar, new zztk(context).zza());
        zzadc zzadcVar = new zzadc(context);
        zzadcVar.zza(zzvvVar);
        zzadcVar.zzb(handler);
        zzadcVar.zzc(zzaepVar);
        return new zzna[]{zztxVar, zzadcVar.zzd()};
    }

    public final /* synthetic */ void zzX(boolean z, long j) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzr(z, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zza(zzhp zzhpVar, zzht zzhtVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzb(zzhp zzhpVar, zzht zzhtVar, boolean z) {
        if (zzhpVar instanceof zzii) {
            synchronized (this.zzq) {
                this.zzs.add((zzii) zzhpVar);
            }
        } else if (zzhpVar instanceof zzcjp) {
            this.zzt = (zzcjp) zzhpVar;
            final zzchn zzchnVar = (zzchn) this.zzf.get();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue() && zzchnVar != null && this.zzt.zzk()) {
                final HashMap map = new HashMap();
                map.put("gcacheHit", String.valueOf(this.zzt.zzm()));
                map.put("gcacheDownloaded", String.valueOf(this.zzt.zzn()));
                com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckb
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        int i = zzckc.$r8$clinit;
                        zzchnVar.zze("onGcacheInfoEvent", map);
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzc(zzhp zzhpVar, zzht zzhtVar, boolean z, int i) {
        this.zzl += i;
    }

    @Override // com.google.android.gms.internal.ads.zzin
    public final void zzd(zzhp zzhpVar, zzht zzhtVar, boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zze(zznn zznnVar, int i) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzs(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzg(zznn zznnVar, zzau zzauVar) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzu("onPlayerError", zzauVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzh(zznn zznnVar, zzxb zzxbVar, zzxg zzxgVar, IOException iOException, boolean z) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            if (this.zze.zzj) {
                zzchdVar.zzv("onLoadException", iOException);
            } else {
                zzchdVar.zzu("onLoadError", iOException);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final Integer zzj() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzk(zznn zznnVar, zzv zzvVar, zzjc zzjcVar) {
        zzchn zzchnVar = (zzchn) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue() || zzchnVar == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = zzvVar.zzo;
        if (str != null) {
            map.put("audioMime", str);
        }
        String str2 = zzvVar.zzp;
        if (str2 != null) {
            map.put("audioSampleMime", str2);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            map.put("audioCodec", str3);
        }
        zzchnVar.zze("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzl(zznn zznnVar, zzv zzvVar, zzjc zzjcVar) {
        zzchn zzchnVar = (zzchn) this.zzf.get();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzd(zzbiq.zzcB)).booleanValue() || zzchnVar == null) {
            return;
        }
        HashMap map = new HashMap();
        map.put("frameRate", String.valueOf(zzvVar.zzA));
        map.put("bitRate", String.valueOf(zzvVar.zzj));
        int i = zzvVar.zzw;
        int i2 = zzvVar.zzx;
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 1 + String.valueOf(i2).length());
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        map.put("resolution", sb.toString());
        String str = zzvVar.zzo;
        if (str != null) {
            map.put("videoMime", str);
        }
        String str2 = zzvVar.zzp;
        if (str2 != null) {
            map.put("videoSampleMime", str2);
        }
        String str3 = zzvVar.zzk;
        if (str3 != null) {
            map.put("videoCodec", str3);
        }
        zzchnVar.zze("onMetadataEvent", map);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzm(zznn zznnVar, int i, long j) {
        this.zzm += i;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzn(Integer num) {
        this.zzr = num;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzo(zznn zznnVar, Object obj, long j) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzD();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzp(zznn zznnVar, zzbv zzbvVar) {
        zzchd zzchdVar = this.zzk;
        if (zzchdVar != null) {
            zzchdVar.zzt(zzbvVar.zzb, zzbvVar.zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzq(Uri[] uriArr, String str) {
        zzr(uriArr, str, ByteBuffer.allocate(0), false);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzr(Uri[] uriArr, String str, ByteBuffer byteBuffer, boolean z) {
        zzxm zzybVar;
        if (this.zzh != null) {
            this.zzi = byteBuffer;
            this.zzj = z;
            int length = uriArr.length;
            if (length == 1) {
                zzybVar = zzR(uriArr[0]);
            } else {
                zzxm[] zzxmVarArr = new zzxm[length];
                for (int i = 0; i < uriArr.length; i++) {
                    zzxmVarArr[i] = zzR(uriArr[i]);
                }
                zzybVar = new zzyb(false, false, new zzwv(), zzxmVarArr);
            }
            this.zzh.zzG(zzybVar);
            this.zzh.zzg();
            zzche.zzi().incrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzs(zzchd zzchdVar) {
        this.zzk = zzchdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzt() {
        zzjv zzjvVar = this.zzh;
        if (zzjvVar != null) {
            zzjvVar.zzE(this);
            this.zzh.zzH();
            this.zzh = null;
            zzche.zzi().decrementAndGet();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzu(Surface surface, boolean z) {
        zzjv zzjvVar = this.zzh;
        if (zzjvVar != null) {
            zzjvVar.zzC(surface);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzv(float f, boolean z) {
        zzjv zzjvVar = this.zzh;
        if (zzjvVar != null) {
            zzjvVar.zzB(f);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzw() {
        this.zzh.zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzx(long j) {
        this.zzh.zzb(j);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzy(int i) {
        this.zzc.zzm(i);
    }

    @Override // com.google.android.gms.internal.ads.zzche
    public final void zzz(int i) {
        this.zzc.zzn(i);
    }
}
