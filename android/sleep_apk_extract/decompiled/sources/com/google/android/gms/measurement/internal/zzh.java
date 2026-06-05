package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
final class zzh {
    private Long zzA;
    private long zzB;
    private String zzC;
    private int zzD;
    private int zzE;
    private long zzF;
    private String zzG;
    private byte[] zzH;
    private int zzI;
    private long zzJ;
    private long zzK;
    private long zzL;
    private long zzM;
    private long zzN;
    private long zzO;
    private long zzP;
    private String zzQ;
    private boolean zzR;
    private long zzS;
    private long zzT;
    private final zzic zza;
    private final String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private String zzj;
    private long zzk;
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;
    private Boolean zzq;
    private long zzr;
    private List zzs;
    private String zzt;
    private boolean zzu;
    private long zzv;
    private long zzw;
    private int zzx;
    private boolean zzy;
    private Long zzz;

    public zzh(zzic zzicVar, String str) {
        Preconditions.checkNotNull(zzicVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzicVar;
        this.zzb = str;
        zzicVar.zzaX().zzg();
    }

    public final void zzA(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzn != j;
        this.zzn = j;
    }

    public final long zzB() {
        this.zza.zzaX().zzg();
        return this.zzr;
    }

    public final void zzC(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzr != j;
        this.zzr = j;
    }

    public final boolean zzD() {
        this.zza.zzaX().zzg();
        return this.zzo;
    }

    public final void zzE(boolean z) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzo != z;
        this.zzo = z;
    }

    public final void zzF(long j) {
        Preconditions.checkArgument(j >= 0);
        this.zza.zzaX().zzg();
        this.zzR |= this.zzg != j;
        this.zzg = j;
    }

    public final long zzG() {
        this.zza.zzaX().zzg();
        return this.zzg;
    }

    public final long zzH() {
        this.zza.zzaX().zzg();
        return this.zzS;
    }

    public final void zzI(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzS != j;
        this.zzS = j;
    }

    public final long zzJ() {
        this.zza.zzaX().zzg();
        return this.zzT;
    }

    public final void zzK(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzT != j;
        this.zzT = j;
    }

    public final void zzL() {
        zzic zzicVar = this.zza;
        zzicVar.zzaX().zzg();
        long j = this.zzg + 1;
        if (j > 2147483647L) {
            zzicVar.zzaW().zze().zzb("Bundle index overflow. appId", zzgu.zzl(this.zzb));
            j = 0;
        }
        this.zzR = true;
        this.zzg = j;
    }

    public final void zzM(long j) {
        zzic zzicVar = this.zza;
        zzicVar.zzaX().zzg();
        long j2 = this.zzg + j;
        if (j2 > 2147483647L) {
            zzicVar.zzaW().zze().zzb("Bundle index overflow. appId", zzgu.zzl(this.zzb));
            j2 = (-1) + j;
        }
        long j3 = this.zzF + 1;
        if (j3 > 2147483647L) {
            zzicVar.zzaW().zze().zzb("Delivery index overflow. appId", zzgu.zzl(this.zzb));
            j3 = 0;
        }
        this.zzR = true;
        this.zzg = j2;
        this.zzF = j3;
    }

    public final long zzN() {
        this.zza.zzaX().zzg();
        return this.zzK;
    }

    public final void zzO(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzK != j;
        this.zzK = j;
    }

    public final long zzP() {
        this.zza.zzaX().zzg();
        return this.zzL;
    }

    public final void zzQ(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzL != j;
        this.zzL = j;
    }

    public final long zzR() {
        this.zza.zzaX().zzg();
        return this.zzM;
    }

    public final void zzS(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzM != j;
        this.zzM = j;
    }

    public final long zzT() {
        this.zza.zzaX().zzg();
        return this.zzN;
    }

    public final void zzU(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzN != j;
        this.zzN = j;
    }

    public final long zzV() {
        this.zza.zzaX().zzg();
        return this.zzP;
    }

    public final void zzW(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzP != j;
        this.zzP = j;
    }

    public final long zzX() {
        this.zza.zzaX().zzg();
        return this.zzO;
    }

    public final void zzY(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzO != j;
        this.zzO = j;
    }

    public final String zzZ() {
        this.zza.zzaX().zzg();
        return this.zzQ;
    }

    public final boolean zza() {
        this.zza.zzaX().zzg();
        return this.zzR;
    }

    public final int zzaA() {
        this.zza.zzaX().zzg();
        return this.zzD;
    }

    public final void zzaB(int i) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzD != i;
        this.zzD = i;
    }

    public final int zzaC() {
        this.zza.zzaX().zzg();
        return this.zzE;
    }

    public final void zzaD(int i) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzE != i;
        this.zzE = i;
    }

    public final void zzaE(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzF != j;
        this.zzF = j;
    }

    public final long zzaF() {
        this.zza.zzaX().zzg();
        return this.zzF;
    }

    public final void zzaG(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzG != str;
        this.zzG = str;
    }

    public final String zzaH() {
        this.zza.zzaX().zzg();
        return this.zzG;
    }

    public final void zzaI(byte[] bArr) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzH != bArr;
        this.zzH = bArr;
    }

    public final byte[] zzaJ() {
        this.zza.zzaX().zzg();
        return this.zzH;
    }

    public final void zzaK(int i) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzI != i;
        this.zzI = i;
    }

    public final int zzaL() {
        this.zza.zzaX().zzg();
        return this.zzI;
    }

    public final void zzaM(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzJ != j;
        this.zzJ = j;
    }

    public final long zzaN() {
        this.zza.zzaX().zzg();
        return this.zzJ;
    }

    public final String zzaa() {
        this.zza.zzaX().zzg();
        String str = this.zzQ;
        zzab(null);
        return str;
    }

    public final void zzab(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzQ, str);
        this.zzQ = str;
    }

    public final boolean zzac() {
        this.zza.zzaX().zzg();
        return this.zzp;
    }

    public final void zzad(boolean z) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzp != z;
        this.zzp = z;
    }

    public final Boolean zzae() {
        this.zza.zzaX().zzg();
        return this.zzq;
    }

    public final void zzaf(Boolean bool) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzq, bool);
        this.zzq = bool;
    }

    public final List zzag() {
        this.zza.zzaX().zzg();
        return this.zzs;
    }

    public final void zzah(List list) {
        this.zza.zzaX().zzg();
        if (Objects.equals(this.zzs, list)) {
            return;
        }
        this.zzR = true;
        this.zzs = list != null ? new ArrayList(list) : null;
    }

    public final boolean zzai() {
        this.zza.zzaX().zzg();
        return this.zzu;
    }

    public final void zzaj(boolean z) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzu != z;
        this.zzu = z;
    }

    public final long zzak() {
        this.zza.zzaX().zzg();
        return this.zzv;
    }

    public final void zzal(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzv != j;
        this.zzv = j;
    }

    public final long zzam() {
        this.zza.zzaX().zzg();
        return this.zzw;
    }

    public final void zzan(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzw != j;
        this.zzw = j;
    }

    public final int zzao() {
        this.zza.zzaX().zzg();
        return this.zzx;
    }

    public final void zzap(int i) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzx != i;
        this.zzx = i;
    }

    public final boolean zzaq() {
        this.zza.zzaX().zzg();
        return this.zzy;
    }

    public final void zzar(boolean z) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzy != z;
        this.zzy = z;
    }

    public final Long zzas() {
        this.zza.zzaX().zzg();
        return this.zzz;
    }

    public final void zzat(Long l) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzz, l);
        this.zzz = l;
    }

    public final Long zzau() {
        this.zza.zzaX().zzg();
        return this.zzA;
    }

    public final void zzav(Long l) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzA, l);
        this.zzA = l;
    }

    public final long zzaw() {
        this.zza.zzaX().zzg();
        return this.zzB;
    }

    public final void zzax(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzB != j;
        this.zzB = j;
    }

    public final String zzay() {
        this.zza.zzaX().zzg();
        return this.zzC;
    }

    public final void zzaz(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzC != str;
        this.zzC = str;
    }

    public final void zzb() {
        this.zza.zzaX().zzg();
        this.zzR = false;
    }

    public final String zzc() {
        this.zza.zzaX().zzg();
        return this.zzb;
    }

    public final String zzd() {
        this.zza.zzaX().zzg();
        return this.zzc;
    }

    public final void zze(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzc, str);
        this.zzc = str;
    }

    public final String zzf() {
        this.zza.zzaX().zzg();
        return this.zzd;
    }

    public final void zzg(String str) {
        this.zza.zzaX().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzR |= true ^ Objects.equals(this.zzd, str);
        this.zzd = str;
    }

    public final String zzh() {
        this.zza.zzaX().zzg();
        return this.zzt;
    }

    public final void zzi(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzt, str);
        this.zzt = str;
    }

    public final String zzj() {
        this.zza.zzaX().zzg();
        return this.zze;
    }

    public final void zzk(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zze, str);
        this.zze = str;
    }

    public final String zzl() {
        this.zza.zzaX().zzg();
        return this.zzf;
    }

    public final void zzm(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzf, str);
        this.zzf = str;
    }

    public final long zzn() {
        this.zza.zzaX().zzg();
        return this.zzh;
    }

    public final void zzo(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzh != j;
        this.zzh = j;
    }

    public final long zzp() {
        this.zza.zzaX().zzg();
        return this.zzi;
    }

    public final void zzq(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzi != j;
        this.zzi = j;
    }

    public final String zzr() {
        this.zza.zzaX().zzg();
        return this.zzj;
    }

    public final void zzs(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzj, str);
        this.zzj = str;
    }

    public final long zzt() {
        this.zza.zzaX().zzg();
        return this.zzk;
    }

    public final void zzu(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzk != j;
        this.zzk = j;
    }

    public final String zzv() {
        this.zza.zzaX().zzg();
        return this.zzl;
    }

    public final void zzw(String str) {
        this.zza.zzaX().zzg();
        this.zzR |= !Objects.equals(this.zzl, str);
        this.zzl = str;
    }

    public final long zzx() {
        this.zza.zzaX().zzg();
        return this.zzm;
    }

    public final void zzy(long j) {
        this.zza.zzaX().zzg();
        this.zzR |= this.zzm != j;
        this.zzm = j;
    }

    public final long zzz() {
        this.zza.zzaX().zzg();
        return this.zzn;
    }
}
