package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
public final class zzaym extends zziee implements zzifq {
    private static final zzaym zzbo;
    private static volatile zzifx zzbp;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzH;
    private long zzI;
    private long zzJ;
    private long zzL;
    private zzayo zzO;
    private int zza;
    private zzayh zzaF;
    private zzayf zzaG;
    private long zzaM;
    private long zzaN;
    private long zzaQ;
    private zzaxw zzaR;
    private zzaxy zzaS;
    private int zzaV;
    private zzayj zzag;
    private zzayl zzai;
    private int zzat;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzazd zzax;
    private int zzb;
    private int zzba;
    private zzaxu zzbb;
    private boolean zzbc;
    private long zzbd;
    private boolean zzbg;
    private long zzbi;
    private zzazb zzbj;
    private int zzc;
    private int zzd;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;
    private String zze = "";
    private String zzf = "";
    private String zzu = "";
    private String zzE = "";
    private String zzF = "D";
    private String zzG = "";
    private String zzK = "";
    private long zzM = -1;
    private long zzN = -1;
    private long zzP = -1;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private String zzV = "D";
    private String zzW = "D";
    private long zzX = -1;
    private int zzY = 1000;
    private int zzZ = 1000;
    private long zzaa = -1;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private int zzaf = 1000;
    private zzieq zzah = zziee.zzbM();
    private long zzaj = -1;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private String zzar = "D";
    private long zzas = -1;
    private long zzay = -1;
    private int zzaz = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzieq zzaC = zziee.zzbM();
    private int zzaD = 1000;
    private zzieq zzaE = zziee.zzbM();
    private String zzaH = "";
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL = -1;
    private long zzaO = -1;
    private String zzaP = "";
    private long zzaT = -1;
    private long zzaU = -1;
    private String zzaW = "";
    private String zzaX = "";
    private long zzaY = -1;
    private long zzaZ = -1;
    private String zzbe = "";
    private int zzbf = 2;
    private String zzbh = "";
    private long zzbk = -1;
    private String zzbl = "";
    private zziem zzbm = zziee.zzbC();
    private long zzbn = -1;

    static {
        zzaym zzaymVar = new zzaym();
        zzbo = zzaymVar;
        zziee.zzbu(zzaym.class, zzaymVar);
    }

    private zzaym() {
    }

    public static zzaym zzi(byte[] bArr, zzido zzidoVar) {
        return (zzaym) zziee.zzbV(zzbo, bArr, zzidoVar);
    }

    public static zzaxm zzj() {
        return (zzaxm) zzbo.zzbn();
    }

    public static zzaym zzk() {
        return zzbo;
    }

    public final /* synthetic */ void zzA(String str) {
        str.getClass();
        this.zza |= 16777216;
        this.zzG = str;
    }

    public final /* synthetic */ void zzB(long j) {
        this.zza |= 33554432;
        this.zzH = j;
    }

    public final /* synthetic */ void zzC(long j) {
        this.zza |= 67108864;
        this.zzI = j;
    }

    public final /* synthetic */ void zzD(long j) {
        this.zza |= 134217728;
        this.zzJ = j;
    }

    public final /* synthetic */ void zzE(String str) {
        str.getClass();
        this.zza |= ClientDefaults.MAX_MSG_SIZE;
        this.zzK = str;
    }

    public final /* synthetic */ void zzF(long j) {
        this.zza |= 536870912;
        this.zzL = j;
    }

    public final /* synthetic */ void zzG(long j) {
        this.zza |= 1073741824;
        this.zzM = j;
    }

    public final /* synthetic */ void zzH(long j) {
        this.zza |= Integer.MIN_VALUE;
        this.zzN = j;
    }

    public final /* synthetic */ void zzI(long j) {
        this.zzb |= 2;
        this.zzP = j;
    }

    public final /* synthetic */ void zzJ(long j) {
        this.zzb |= 4;
        this.zzQ = j;
    }

    public final /* synthetic */ void zzK(long j) {
        this.zzb |= 8;
        this.zzR = j;
    }

    public final /* synthetic */ void zzL(long j) {
        this.zzb |= 16;
        this.zzS = j;
    }

    public final /* synthetic */ void zzM(long j) {
        this.zzb |= 32;
        this.zzT = j;
    }

    public final /* synthetic */ void zzN(long j) {
        this.zzb |= 64;
        this.zzU = j;
    }

    public final /* synthetic */ void zzO(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzV = str;
    }

    public final /* synthetic */ void zzP(String str) {
        str.getClass();
        this.zzb |= 256;
        this.zzW = str;
    }

    public final /* synthetic */ void zzQ(long j) {
        this.zzb |= 4096;
        this.zzaa = j;
    }

    public final /* synthetic */ void zzR(long j) {
        this.zzb |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzab = j;
    }

    public final /* synthetic */ void zzS(long j) {
        this.zzb |= 16384;
        this.zzac = j;
    }

    public final /* synthetic */ void zzT(zzayj zzayjVar) {
        zzayjVar.getClass();
        this.zzag = zzayjVar;
        this.zzb |= 262144;
    }

    public final /* synthetic */ void zzU(zzayj zzayjVar) {
        zzayjVar.getClass();
        zzieq zzieqVar = this.zzah;
        if (!zzieqVar.zza()) {
            this.zzah = zziee.zzbN(zzieqVar);
        }
        this.zzah.add(zzayjVar);
    }

    public final /* synthetic */ void zzV() {
        this.zzah = zziee.zzbM();
    }

    public final /* synthetic */ void zzW(zzayl zzaylVar) {
        zzaylVar.getClass();
        this.zzai = zzaylVar;
        this.zzb |= 524288;
    }

    public final /* synthetic */ void zzX(long j) {
        this.zzb |= 1048576;
        this.zzaj = j;
    }

    public final /* synthetic */ void zzY(long j) {
        this.zzb |= 2097152;
        this.zzak = j;
    }

    public final /* synthetic */ void zzZ(long j) {
        this.zzb |= 4194304;
        this.zzal = j;
    }

    public final boolean zza() {
        return (this.zza & 4194304) != 0;
    }

    public final /* synthetic */ void zzaa(long j) {
        this.zzb |= 8388608;
        this.zzam = j;
    }

    public final /* synthetic */ void zzab(long j) {
        this.zzb |= 16777216;
        this.zzan = j;
    }

    public final /* synthetic */ void zzac(long j) {
        this.zzb |= 67108864;
        this.zzap = j;
    }

    public final /* synthetic */ void zzad(long j) {
        this.zzb |= 134217728;
        this.zzaq = j;
    }

    public final /* synthetic */ void zzae(String str) {
        str.getClass();
        this.zzb |= ClientDefaults.MAX_MSG_SIZE;
        this.zzar = str;
    }

    public final /* synthetic */ void zzaf(String str) {
        str.getClass();
        this.zzc |= 1024;
        this.zzaH = str;
    }

    public final /* synthetic */ void zzag(long j) {
        this.zzc |= 2048;
        this.zzaI = j;
    }

    public final /* synthetic */ void zzah(long j) {
        this.zzc |= 4096;
        this.zzaJ = j;
    }

    public final /* synthetic */ void zzai(long j) {
        this.zzc |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzaK = j;
    }

    public final /* synthetic */ void zzaj(long j) {
        this.zzc |= 16384;
        this.zzaL = j;
    }

    public final /* synthetic */ void zzak(String str) {
        str.getClass();
        this.zzc |= 262144;
        this.zzaP = str;
    }

    public final /* synthetic */ void zzal(long j) {
        this.zzc |= 8388608;
        this.zzaU = j;
    }

    public final /* synthetic */ void zzam(long j) {
        this.zzd |= 32;
        this.zzbi = j;
    }

    public final /* synthetic */ void zzan(zzazb zzazbVar) {
        zzazbVar.getClass();
        this.zzbj = zzazbVar;
        this.zzd |= 64;
    }

    public final /* synthetic */ void zzap(int i) {
        this.zzY = i - 1;
        this.zzb |= 1024;
    }

    public final /* synthetic */ void zzaq(int i) {
        this.zzZ = i - 1;
        this.zzb |= 2048;
    }

    public final /* synthetic */ void zzar(int i) {
        this.zzaf = i - 1;
        this.zzb |= 131072;
    }

    public final /* synthetic */ void zzas(int i) {
        this.zzaz = i - 1;
        this.zzc |= 16;
    }

    public final /* synthetic */ void zzat(int i) {
        this.zzaA = i - 1;
        this.zzc |= 32;
    }

    public final /* synthetic */ void zzau(int i) {
        this.zzaV = i - 1;
        this.zzc |= 16777216;
    }

    public final String zzb() {
        return this.zzE;
    }

    public final boolean zzc() {
        return (this.zzb & 1048576) != 0;
    }

    public final long zzd() {
        return this.zzaj;
    }

    @Override // com.google.android.gms.internal.ads.zziee
    public final Object zzdc(zzied zziedVar, Object obj, Object obj2) {
        zzifx zzidzVar;
        int iOrdinal = zziedVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zziek zziekVar = zzaxq.zza;
            zziek zziekVar2 = zzayw.zza;
            return zziee.zzbv(zzbo, "\u0001n\u0000\u0004\u0001Įn\u0000\u0004\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ`\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈa\u0019ဂe\u001a᠌b\u001bဈ\u0016\u001cဇc\u001dဈ\u0018\u001eဈd\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉT[ဉU\\ဂV]ဂW^᠌X_᠌@`ဉIaဂPbဈYcဈZdဂ[eဂ\\f᠌]gဂShဉ^iဇ_j'kဂiÉဉfĭဂgĮဈh", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzbd", "zzC", "zzD", "zzbe", "zzbi", "zzbf", zziekVar, "zzE", "zzbg", "zzG", "zzbh", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzah", zzayj.class, "zzT", "zzU", "zzV", "zzW", "zzY", zziekVar2, "zzZ", zziekVar2, "zzag", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", zziekVar2, "zzai", "zzaj", "zzak", "zzal", "zzam", "zzap", "zzaq", "zzas", "zzat", zzayv.zza, "zzau", zzayz.zza, "zzar", "zzaw", zzaxn.zza, "zzax", "zzay", "zzan", "zzao", "zzaz", zziekVar2, "zzX", "zzF", "zzaA", zziekVar2, "zzaB", "zzaC", zzayd.class, "zzaD", zziekVar2, "zzaE", zzaxp.class, "zzaF", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaO", "zzaP", "zzaR", "zzaS", "zzaT", "zzaU", "zzaV", zzaxz.zza, "zzav", zzaxr.zza, "zzaG", "zzaN", "zzaW", "zzaX", "zzaY", "zzaZ", "zzba", zzayb.zza, "zzaQ", "zzbb", "zzbc", "zzbm", "zzbn", "zzbj", "zzbk", "zzbl"});
        }
        if (iOrdinal == 3) {
            return new zzaym();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaxm(bArr);
        }
        if (iOrdinal == 5) {
            return zzbo;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzifx zzifxVar = zzbp;
        if (zzifxVar != null) {
            return zzifxVar;
        }
        synchronized (zzaym.class) {
            try {
                zzidzVar = zzbp;
                if (zzidzVar == null) {
                    zzidzVar = new zzidz(zzbo);
                    zzbp = zzidzVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzidzVar;
    }

    public final long zze() {
        return this.zzan;
    }

    public final boolean zzg() {
        return (this.zzd & 64) != 0;
    }

    public final zzazb zzh() {
        zzazb zzazbVar = this.zzbj;
        return zzazbVar == null ? zzazb.zze() : zzazbVar;
    }

    public final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void zzm(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzf = str;
    }

    public final /* synthetic */ void zzn(long j) {
        this.zza |= 4;
        this.zzg = j;
    }

    public final /* synthetic */ void zzo(long j) {
        this.zza |= 16;
        this.zzi = j;
    }

    public final /* synthetic */ void zzp(long j) {
        this.zza |= 32;
        this.zzj = j;
    }

    public final /* synthetic */ void zzq(long j) {
        this.zza |= 1024;
        this.zzo = j;
    }

    public final /* synthetic */ void zzr(long j) {
        this.zza |= 2048;
        this.zzp = j;
    }

    public final /* synthetic */ void zzs(long j) {
        this.zza |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzv = j;
    }

    public final /* synthetic */ void zzt(long j) {
        this.zza |= 16384;
        this.zzw = j;
    }

    public final /* synthetic */ void zzu(long j) {
        this.zza |= 32768;
        this.zzx = j;
    }

    public final /* synthetic */ void zzv(long j) {
        this.zza |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.zzy = j;
    }

    public final /* synthetic */ void zzw(long j) {
        this.zza |= 524288;
        this.zzB = j;
    }

    public final /* synthetic */ void zzx(long j) {
        this.zza |= 1048576;
        this.zzC = j;
    }

    public final /* synthetic */ void zzy(long j) {
        this.zza |= 2097152;
        this.zzD = j;
    }

    public final /* synthetic */ void zzz(String str) {
        str.getClass();
        this.zza |= 4194304;
        this.zzE = str;
    }
}
