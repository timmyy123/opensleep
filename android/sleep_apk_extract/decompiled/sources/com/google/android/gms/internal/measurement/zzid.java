package com.google.android.gms.internal.measurement;

import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzid extends zzadu implements zzafd {
    private static final zzid zzaw;
    private static volatile zzafj zzax;
    private long zzA;
    private int zzB;
    private boolean zzE;
    private int zzH;
    private int zzI;
    private int zzJ;
    private long zzL;
    private long zzM;
    private int zzP;
    private zzig zzR;
    private long zzT;
    private long zzU;
    private int zzX;
    private boolean zzY;
    private boolean zzaa;
    private zzhy zzab;
    private long zzaf;
    private boolean zzag;
    private boolean zzai;
    private int zzak;
    private zzhe zzam;
    private int zzan;
    private zzha zzao;
    private zzis zzaq;
    private long zzar;
    private zzho zzat;
    private int zzb;
    private int zze;
    private int zzf;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private int zzr;
    private long zzv;
    private long zzw;
    private boolean zzy;
    private zzaef zzg = zzadu.zzcy();
    private zzaef zzh = zzadu.zzcy();
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzs = "";
    private String zzt = "";
    private String zzu = "";
    private String zzx = "";
    private String zzz = "";
    private String zzC = "";
    private String zzD = "";
    private zzaef zzF = zzadu.zzcy();
    private String zzG = "";
    private String zzK = "";
    private String zzN = "";
    private String zzO = "";
    private String zzQ = "";
    private zzaeb zzS = zzadu.zzcv();
    private String zzV = "";
    private String zzW = "";
    private String zzZ = "";
    private String zzac = "";
    private zzaef zzad = zzadu.zzcy();
    private String zzae = "";
    private String zzah = "";
    private String zzaj = "";
    private String zzal = "";
    private String zzap = "";
    private String zzas = "";
    private String zzau = "";
    private zzaef zzav = zzadu.zzcy();

    static {
        zzid zzidVar = new zzid();
        zzaw = zzidVar;
        zzadu.zzcs(zzid.class, zzidVar);
    }

    private zzid() {
    }

    public static zzic zzaE() {
        return (zzic) zzaw.zzcn();
    }

    public static zzic zzaF(zzid zzidVar) {
        zzadp zzadpVarZzcn = zzaw.zzcn();
        zzadpVarZzcn.zzbe(zzidVar);
        return (zzic) zzadpVarZzcn;
    }

    private final void zzcE() {
        zzaef zzaefVar = this.zzg;
        if (zzaefVar.zza()) {
            return;
        }
        this.zzg = zzadu.zzcz(zzaefVar);
    }

    private final void zzcF() {
        zzaef zzaefVar = this.zzh;
        if (zzaefVar.zza()) {
            return;
        }
        this.zzh = zzadu.zzcz(zzaefVar);
    }

    public final String zzA() {
        return this.zzt;
    }

    public final String zzB() {
        return this.zzu;
    }

    public final boolean zzC() {
        return (this.zzb & 16384) != 0;
    }

    public final long zzD() {
        return this.zzv;
    }

    public final boolean zzE() {
        return (this.zzb & 32768) != 0;
    }

    public final long zzF() {
        return this.zzw;
    }

    public final String zzG() {
        return this.zzx;
    }

    public final boolean zzH() {
        return (this.zzb & 131072) != 0;
    }

    public final boolean zzI() {
        return this.zzy;
    }

    public final String zzJ() {
        return this.zzz;
    }

    public final boolean zzK() {
        return (this.zzb & 524288) != 0;
    }

    public final long zzL() {
        return this.zzA;
    }

    public final boolean zzM() {
        return (this.zzb & 1048576) != 0;
    }

    public final int zzN() {
        return this.zzB;
    }

    public final String zzO() {
        return this.zzC;
    }

    public final String zzP() {
        return this.zzD;
    }

    public final boolean zzQ() {
        return (this.zzb & 8388608) != 0;
    }

    public final boolean zzR() {
        return this.zzE;
    }

    public final List zzS() {
        return this.zzF;
    }

    public final String zzT() {
        return this.zzG;
    }

    public final boolean zzU() {
        return (this.zzb & 33554432) != 0;
    }

    public final int zzV() {
        return this.zzH;
    }

    public final boolean zzW() {
        return (this.zzb & 536870912) != 0;
    }

    public final long zzX() {
        return this.zzL;
    }

    public final boolean zzY() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final String zzZ() {
        return this.zzN;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zzaA() {
        return (this.zze & 134217728) != 0;
    }

    public final long zzaB() {
        return this.zzar;
    }

    public final boolean zzaC() {
        return (this.zze & 536870912) != 0;
    }

    public final zzho zzaD() {
        zzho zzhoVar = this.zzat;
        return zzhoVar == null ? zzho.zzc() : zzhoVar;
    }

    public final /* synthetic */ void zzaG(int i) {
        this.zzb |= 1;
        this.zzf = 1;
    }

    public final /* synthetic */ void zzaH(int i, zzhs zzhsVar) {
        zzhsVar.getClass();
        zzcE();
        this.zzg.set(i, zzhsVar);
    }

    public final /* synthetic */ void zzaI(zzhs zzhsVar) {
        zzhsVar.getClass();
        zzcE();
        this.zzg.add(zzhsVar);
    }

    public final /* synthetic */ void zzaJ(Iterable iterable) {
        zzcE();
        zzacb.zzcg(iterable, this.zzg);
    }

    public final /* synthetic */ void zzaK() {
        this.zzg = zzadu.zzcy();
    }

    public final /* synthetic */ void zzaL(int i) {
        zzcE();
        this.zzg.remove(i);
    }

    public final /* synthetic */ void zzaM(int i, zziu zziuVar) {
        zziuVar.getClass();
        zzcF();
        this.zzh.set(i, zziuVar);
    }

    public final /* synthetic */ void zzaN(zziu zziuVar) {
        zziuVar.getClass();
        zzcF();
        this.zzh.add(zziuVar);
    }

    public final /* synthetic */ void zzaO(Iterable iterable) {
        zzcF();
        zzacb.zzcg(iterable, this.zzh);
    }

    public final /* synthetic */ void zzaP(int i) {
        zzcF();
        this.zzh.remove(i);
    }

    public final /* synthetic */ void zzaQ(long j) {
        this.zzb |= 2;
        this.zzi = j;
    }

    public final /* synthetic */ void zzaR() {
        this.zzb &= -3;
        this.zzi = 0L;
    }

    public final /* synthetic */ void zzaS(long j) {
        this.zzb |= 4;
        this.zzj = j;
    }

    public final /* synthetic */ void zzaT(long j) {
        this.zzb |= 8;
        this.zzk = j;
    }

    public final /* synthetic */ void zzaU(long j) {
        this.zzb |= 16;
        this.zzl = j;
    }

    public final /* synthetic */ void zzaV() {
        this.zzb &= -17;
        this.zzl = 0L;
    }

    public final /* synthetic */ void zzaW(long j) {
        this.zzb |= 32;
        this.zzm = j;
    }

    public final /* synthetic */ void zzaX() {
        this.zzb &= -33;
        this.zzm = 0L;
    }

    public final /* synthetic */ void zzaY(String str) {
        this.zzb |= 64;
        this.zzn = "android";
    }

    public final /* synthetic */ void zzaZ(String str) {
        str.getClass();
        this.zzb |= 128;
        this.zzo = str;
    }

    public final boolean zzaa() {
        return (this.zze & 2) != 0;
    }

    public final int zzab() {
        return this.zzP;
    }

    public final boolean zzac() {
        return (this.zze & 16) != 0;
    }

    public final long zzad() {
        return this.zzT;
    }

    public final boolean zzae() {
        return (this.zze & 128) != 0;
    }

    public final String zzaf() {
        return this.zzW;
    }

    public final boolean zzag() {
        return (this.zze & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
    }

    public final String zzah() {
        return this.zzac;
    }

    public final boolean zzai() {
        return (this.zze & 32768) != 0;
    }

    public final long zzaj() {
        return this.zzaf;
    }

    public final boolean zzak() {
        return this.zzag;
    }

    public final boolean zzal() {
        return (this.zze & 131072) != 0;
    }

    public final String zzam() {
        return this.zzah;
    }

    public final boolean zzan() {
        return (this.zze & 262144) != 0;
    }

    public final boolean zzao() {
        return this.zzai;
    }

    public final boolean zzap() {
        return (this.zze & 524288) != 0;
    }

    public final String zzaq() {
        return this.zzaj;
    }

    public final int zzar() {
        return this.zzak;
    }

    public final boolean zzas() {
        return (this.zze & 4194304) != 0;
    }

    public final zzhe zzat() {
        zzhe zzheVar = this.zzam;
        return zzheVar == null ? zzhe.zzj() : zzheVar;
    }

    public final boolean zzau() {
        return (this.zze & 8388608) != 0;
    }

    public final int zzav() {
        return this.zzan;
    }

    public final boolean zzaw() {
        return (this.zze & 16777216) != 0;
    }

    public final zzha zzax() {
        zzha zzhaVar = this.zzao;
        return zzhaVar == null ? zzha.zzu() : zzhaVar;
    }

    public final boolean zzay() {
        return (this.zze & 67108864) != 0;
    }

    public final zzis zzaz() {
        zzis zzisVar = this.zzaq;
        return zzisVar == null ? zzis.zzc() : zzisVar;
    }

    public final int zzb() {
        return this.zzf;
    }

    public final /* synthetic */ void zzbA(long j) {
        this.zzb |= 536870912;
        this.zzL = j;
    }

    public final /* synthetic */ void zzbB(String str) {
        str.getClass();
        this.zzb |= Integer.MIN_VALUE;
        this.zzN = str;
    }

    public final /* synthetic */ void zzbC() {
        this.zzb &= Integer.MAX_VALUE;
        this.zzN = zzaw.zzN;
    }

    public final /* synthetic */ void zzbD(int i) {
        this.zze |= 2;
        this.zzP = i;
    }

    public final /* synthetic */ void zzbE(zzig zzigVar) {
        zzigVar.getClass();
        this.zzR = zzigVar;
        this.zze |= 8;
    }

    public final /* synthetic */ void zzbF(Iterable iterable) {
        zzaeb zzaebVar = this.zzS;
        if (!zzaebVar.zza()) {
            int size = zzaebVar.size();
            this.zzS = zzaebVar.zzg(size + size);
        }
        zzacb.zzcg(iterable, this.zzS);
    }

    public final /* synthetic */ void zzbG(long j) {
        this.zze |= 16;
        this.zzT = j;
    }

    public final /* synthetic */ void zzbH(long j) {
        this.zze |= 32;
        this.zzU = j;
    }

    public final /* synthetic */ void zzbI(String str) {
        this.zze |= 128;
        this.zzW = str;
    }

    public final /* synthetic */ void zzbJ(String str) {
        str.getClass();
        this.zze |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzac = str;
    }

    public final /* synthetic */ void zzbK() {
        this.zze &= -8193;
        this.zzac = zzaw.zzac;
    }

    public final /* synthetic */ void zzbL(Iterable iterable) {
        zzaef zzaefVar = this.zzad;
        if (!zzaefVar.zza()) {
            this.zzad = zzadu.zzcz(zzaefVar);
        }
        zzacb.zzcg(iterable, this.zzad);
    }

    public final /* synthetic */ void zzbM(String str) {
        str.getClass();
        this.zze |= 16384;
        this.zzae = str;
    }

    public final /* synthetic */ void zzbN(long j) {
        this.zze |= 32768;
        this.zzaf = j;
    }

    public final /* synthetic */ void zzbO(boolean z) {
        this.zze |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.zzag = z;
    }

    public final /* synthetic */ void zzbP(String str) {
        this.zze |= 131072;
        this.zzah = str;
    }

    public final /* synthetic */ void zzbQ(boolean z) {
        this.zze |= 262144;
        this.zzai = z;
    }

    public final /* synthetic */ void zzbR(String str) {
        str.getClass();
        this.zze |= 524288;
        this.zzaj = str;
    }

    public final /* synthetic */ void zzbS(int i) {
        this.zze |= 1048576;
        this.zzak = i;
    }

    public final /* synthetic */ void zzbT(zzhe zzheVar) {
        zzheVar.getClass();
        this.zzam = zzheVar;
        this.zze |= 4194304;
    }

    public final /* synthetic */ void zzbU(int i) {
        this.zze |= 8388608;
        this.zzan = i;
    }

    public final /* synthetic */ void zzbV(zzha zzhaVar) {
        zzhaVar.getClass();
        this.zzao = zzhaVar;
        this.zze |= 16777216;
    }

    public final /* synthetic */ void zzbW(zzis zzisVar) {
        this.zzaq = zzisVar;
        this.zze |= 67108864;
    }

    public final /* synthetic */ void zzbX(long j) {
        this.zze |= 134217728;
        this.zzar = j;
    }

    public final /* synthetic */ void zzbY(zzho zzhoVar) {
        zzhoVar.getClass();
        this.zzat = zzhoVar;
        this.zze |= 536870912;
    }

    public final /* synthetic */ void zzbZ(String str) {
        str.getClass();
        this.zze |= 1073741824;
        this.zzau = str;
    }

    public final /* synthetic */ void zzba(String str) {
        str.getClass();
        this.zzb |= 256;
        this.zzp = str;
    }

    public final /* synthetic */ void zzbb() {
        this.zzb &= -257;
        this.zzp = zzaw.zzp;
    }

    public final /* synthetic */ void zzbc(String str) {
        str.getClass();
        this.zzb |= 512;
        this.zzq = str;
    }

    public final /* synthetic */ void zzbd(int i) {
        this.zzb |= 1024;
        this.zzr = i;
    }

    public final /* synthetic */ void zzbe(String str) {
        str.getClass();
        this.zzb |= 2048;
        this.zzs = str;
    }

    public final /* synthetic */ void zzbf(String str) {
        str.getClass();
        this.zzb |= 4096;
        this.zzt = str;
    }

    public final /* synthetic */ void zzbg(String str) {
        str.getClass();
        this.zzb |= Utility.DEFAULT_STREAM_BUFFER_SIZE;
        this.zzu = str;
    }

    public final /* synthetic */ void zzbh(long j) {
        this.zzb |= 16384;
        this.zzv = j;
    }

    public final /* synthetic */ void zzbi(long j) {
        this.zzb |= 32768;
        this.zzw = 161000L;
    }

    public final /* synthetic */ void zzbj(String str) {
        str.getClass();
        this.zzb |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        this.zzx = str;
    }

    public final /* synthetic */ void zzbk() {
        this.zzb &= -65537;
        this.zzx = zzaw.zzx;
    }

    public final /* synthetic */ void zzbl(boolean z) {
        this.zzb |= 131072;
        this.zzy = z;
    }

    public final /* synthetic */ void zzbm() {
        this.zzb &= -131073;
        this.zzy = false;
    }

    public final /* synthetic */ void zzbn(String str) {
        str.getClass();
        this.zzb |= 262144;
        this.zzz = str;
    }

    public final /* synthetic */ void zzbo() {
        this.zzb &= -262145;
        this.zzz = zzaw.zzz;
    }

    public final /* synthetic */ void zzbp(long j) {
        this.zzb |= 524288;
        this.zzA = j;
    }

    public final /* synthetic */ void zzbq(int i) {
        this.zzb |= 1048576;
        this.zzB = i;
    }

    public final /* synthetic */ void zzbr(String str) {
        this.zzb |= 2097152;
        this.zzC = str;
    }

    public final /* synthetic */ void zzbs() {
        this.zzb &= -2097153;
        this.zzC = zzaw.zzC;
    }

    public final /* synthetic */ void zzbt(String str) {
        str.getClass();
        this.zzb |= 4194304;
        this.zzD = str;
    }

    public final /* synthetic */ void zzbu(boolean z) {
        this.zzb |= 8388608;
        this.zzE = z;
    }

    public final /* synthetic */ void zzbv(Iterable iterable) {
        zzaef zzaefVar = this.zzF;
        if (!zzaefVar.zza()) {
            this.zzF = zzadu.zzcz(zzaefVar);
        }
        zzacb.zzcg(iterable, this.zzF);
    }

    public final /* synthetic */ void zzbw() {
        this.zzF = zzadu.zzcy();
    }

    public final /* synthetic */ void zzbx(String str) {
        str.getClass();
        this.zzb |= 16777216;
        this.zzG = str;
    }

    public final /* synthetic */ void zzby(int i) {
        this.zzb |= 33554432;
        this.zzH = i;
    }

    public final /* synthetic */ void zzbz() {
        this.zzb &= -268435457;
        this.zzK = zzaw.zzK;
    }

    public final List zzc() {
        return this.zzg;
    }

    public final /* synthetic */ void zzca(Iterable iterable) {
        zzaef zzaefVar = this.zzav;
        if (!zzaefVar.zza()) {
            this.zzav = zzadu.zzcz(zzaefVar);
        }
        zzacb.zzcg(iterable, this.zzav);
    }

    public final int zzd() {
        return this.zzg.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzhs zze(int i) {
        return (zzhs) this.zzg.get(i);
    }

    public final List zzf() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.measurement.zzadu
    public final Object zzg(int i, Object obj, Object obj2) {
        zzafj zzadqVar;
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzadu.zzct(zzaw, "\u0004E\u0000\u0002\u0001YE\u0000\u0006\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'5᠌(7ဇ)9ဈ*:ဇ+;ဉ,?ဈ-@\u001aAဈ.Cဂ/Dဇ0Gဈ1Hဇ2Iဈ3Jင4Kဈ5Lဉ6Mင7Oဉ8Pဈ9Qဉ:Rဂ;Sဈ<Vဉ=Xဈ>Y\u001b", new Object[]{"zzb", "zze", "zzf", "zzg", zzhs.class, "zzh", zziu.class, "zzi", "zzj", "zzk", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", "zzl", "zzE", "zzF", zzhg.class, "zzG", "zzH", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzU", "zzV", "zzW", "zzX", zzgw.zza, "zzY", "zzZ", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav", zzfb.class});
        }
        if (i2 == 3) {
            return new zzid();
        }
        byte[] bArr = null;
        if (i2 == 4) {
            return new zzic(bArr);
        }
        if (i2 == 5) {
            return zzaw;
        }
        if (i2 != 6) {
            throw null;
        }
        zzafj zzafjVar = zzax;
        if (zzafjVar != null) {
            return zzafjVar;
        }
        synchronized (zzid.class) {
            try {
                zzadqVar = zzax;
                if (zzadqVar == null) {
                    zzadqVar = new zzadq(zzaw);
                    zzax = zzadqVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzadqVar;
    }

    public final int zzh() {
        return this.zzh.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zziu zzi(int i) {
        return (zziu) this.zzh.get(i);
    }

    public final boolean zzj() {
        return (this.zzb & 2) != 0;
    }

    public final long zzk() {
        return this.zzi;
    }

    public final boolean zzl() {
        return (this.zzb & 4) != 0;
    }

    public final long zzm() {
        return this.zzj;
    }

    public final boolean zzn() {
        return (this.zzb & 8) != 0;
    }

    public final long zzo() {
        return this.zzk;
    }

    public final boolean zzp() {
        return (this.zzb & 16) != 0;
    }

    public final long zzq() {
        return this.zzl;
    }

    public final boolean zzr() {
        return (this.zzb & 32) != 0;
    }

    public final long zzs() {
        return this.zzm;
    }

    public final String zzt() {
        return this.zzn;
    }

    public final String zzu() {
        return this.zzo;
    }

    public final String zzv() {
        return this.zzp;
    }

    public final String zzw() {
        return this.zzq;
    }

    public final boolean zzx() {
        return (this.zzb & 1024) != 0;
    }

    public final int zzy() {
        return this.zzr;
    }

    public final String zzz() {
        return this.zzs;
    }
}
