package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.util.SparseArray;
import androidx.appfunctions.AppFunctionException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpr implements zznm {
    private final zzdo zza;
    private final zzbd zzb;
    private final zzbe zzc;
    private final zzpq zzd;
    private final SparseArray zze;
    private zzef zzf;
    private zzbb zzg;
    private zzdz zzh;
    private boolean zzi;

    public zzpr(zzdo zzdoVar) {
        zzdoVar.getClass();
        this.zza = zzdoVar;
        this.zzf = new zzef(zzfl.zzf().getThread());
        zzbd zzbdVar = new zzbd();
        this.zzb = zzbdVar;
        this.zzc = new zzbe();
        this.zzd = new zzpq(zzbdVar);
        this.zze = new SparseArray();
    }

    private final zznn zzad(zzxk zzxkVar) {
        this.zzg.getClass();
        zzbf zzbfVarZze = zzxkVar == null ? null : this.zzd.zze(zzxkVar);
        if (zzxkVar != null && zzbfVarZze != null) {
            return zzaa(zzbfVarZze, zzbfVarZze.zzo(zzxkVar.zza, this.zzb).zzc, zzxkVar);
        }
        int iZzs = this.zzg.zzs();
        zzbf zzbfVarZzq = this.zzg.zzq();
        if (iZzs >= zzbfVarZzq.zza()) {
            zzbfVarZzq = zzbf.zza;
        }
        return zzaa(zzbfVarZzq, iZzs, null);
    }

    private final zznn zzae() {
        return zzad(this.zzd.zzb());
    }

    private final zznn zzaf() {
        return zzad(this.zzd.zzc());
    }

    private final zznn zzag(int i, zzxk zzxkVar) {
        zzbb zzbbVar = this.zzg;
        zzbbVar.getClass();
        if (zzxkVar != null) {
            return this.zzd.zze(zzxkVar) != null ? zzad(zzxkVar) : zzaa(zzbf.zza, i, zzxkVar);
        }
        zzbf zzbfVarZzq = zzbbVar.zzq();
        if (i >= zzbfVarZzq.zza()) {
            zzbfVarZzq = zzbf.zza;
        }
        return zzaa(zzbfVarZzq, i, null);
    }

    private final zznn zzah(zzau zzauVar) {
        zzxk zzxkVar;
        return (!(zzauVar instanceof zzjk) || (zzxkVar = ((zzjk) zzauVar).zzh) == null) ? zzZ() : zzad(zzxkVar);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzA() {
        if (this.zzi) {
            return;
        }
        final zznn zznnVarZzZ = zzZ();
        this.zzi = true;
        zzY(zznnVarZzZ, -1, new zzea(zznnVarZzZ) { // from class: com.google.android.gms.internal.ads.zzob
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzB(final int i, final int i2, final boolean z) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1033, new zzea(zznnVarZzaf, i, i2, z) { // from class: com.google.android.gms.internal.ads.zzom
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzC(final zzjb zzjbVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1007, new zzea(zznnVarZzaf, zzjbVar) { // from class: com.google.android.gms.internal.ads.zzox
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzD(final String str, final long j, final long j2) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1008, new zzea(zznnVarZzaf, str, j2, j) { // from class: com.google.android.gms.internal.ads.zzph
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzE(final zzv zzvVar, final zzjc zzjcVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1009, new zzea() { // from class: com.google.android.gms.internal.ads.zzpk
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzk(zznnVarZzaf, zzvVar, zzjcVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzF(final long j) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1010, new zzea(zznnVarZzaf, j) { // from class: com.google.android.gms.internal.ads.zzpl
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzG(final int i, final long j, final long j2) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1011, new zzea(zznnVarZzaf, i, j, j2) { // from class: com.google.android.gms.internal.ads.zzpm
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzH(final String str) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1012, new zzea(zznnVarZzaf, str) { // from class: com.google.android.gms.internal.ads.zzpn
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzI(final zzjb zzjbVar) {
        final zznn zznnVarZzae = zzae();
        zzY(zznnVarZzae, 1013, new zzea(zznnVarZzae, zzjbVar) { // from class: com.google.android.gms.internal.ads.zzpo
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzJ(final Exception exc) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1014, new zzea(zznnVarZzaf, exc) { // from class: com.google.android.gms.internal.ads.zznr
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzK(final Exception exc) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1029, new zzea(zznnVarZzaf, exc) { // from class: com.google.android.gms.internal.ads.zzns
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzL(final zzry zzryVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1031, new zzea(zznnVarZzaf, zzryVar) { // from class: com.google.android.gms.internal.ads.zznt
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzM(final zzry zzryVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1032, new zzea(zznnVarZzaf, zzryVar) { // from class: com.google.android.gms.internal.ads.zznu
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzN(final zzjb zzjbVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1015, new zzea(zznnVarZzaf, zzjbVar) { // from class: com.google.android.gms.internal.ads.zznw
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzO(final String str, final long j, final long j2) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1016, new zzea(zznnVarZzaf, str, j2, j) { // from class: com.google.android.gms.internal.ads.zznx
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzP(final zzv zzvVar, final zzjc zzjcVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1017, new zzea() { // from class: com.google.android.gms.internal.ads.zzny
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzl(zznnVarZzaf, zzvVar, zzjcVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzQ(final int i, final long j) {
        final zznn zznnVarZzae = zzae();
        zzY(zznnVarZzae, 1018, new zzea() { // from class: com.google.android.gms.internal.ads.zznz
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzm(zznnVarZzae, i, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzR(final String str) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1019, new zzea(zznnVarZzaf, str) { // from class: com.google.android.gms.internal.ads.zzoa
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzS(final zzjb zzjbVar) {
        final zznn zznnVarZzae = zzae();
        zzY(zznnVarZzae, 1020, new zzea() { // from class: com.google.android.gms.internal.ads.zzoc
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzdh(zznnVarZzae, zzjbVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzT(final Object obj, final long j) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 26, new zzea() { // from class: com.google.android.gms.internal.ads.zzod
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj2) {
                ((zznp) obj2).zzo(zznnVarZzaf, obj, j);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzU(final long j, final int i) {
        final zznn zznnVarZzae = zzae();
        zzY(zznnVarZzae, 1021, new zzea(zznnVarZzae, j, i) { // from class: com.google.android.gms.internal.ads.zzoe
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzV(final Exception exc) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 1030, new zzea(zznnVarZzaf, exc) { // from class: com.google.android.gms.internal.ads.zzof
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzW(final int i) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 1034, new zzea(zznnVarZzZ, i) { // from class: com.google.android.gms.internal.ads.zzog
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzabp
    public final void zzX(final int i, final long j, final long j2) {
        final zznn zznnVarZzad = zzad(this.zzd.zzd());
        zzY(zznnVarZzad, 1006, new zzea() { // from class: com.google.android.gms.internal.ads.zzpi
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzdg(zznnVarZzad, i, j, j2);
            }
        });
    }

    public final void zzY(zznn zznnVar, int i, zzea zzeaVar) {
        this.zze.put(i, zznnVar);
        zzef zzefVar = this.zzf;
        zzefVar.zze(i, zzeaVar);
        zzefVar.zzf();
    }

    public final zznn zzZ() {
        return zzad(this.zzd.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zza(zzbb zzbbVar, zzay zzayVar) {
    }

    public final zznn zzaa(zzbf zzbfVar, int i, zzxk zzxkVar) {
        zzxk zzxkVar2 = true == zzbfVar.zzg() ? null : zzxkVar;
        long jZzb = this.zza.zzb();
        boolean z = zzbfVar.equals(this.zzg.zzq()) && i == this.zzg.zzs();
        long jZzr = 0;
        if (zzxkVar2 == null || !zzxkVar2.zzb()) {
            if (z) {
                jZzr = this.zzg.zzA();
            } else if (!zzbfVar.zzg()) {
                long j = zzbfVar.zzb(i, this.zzc, 0L).zzl;
                jZzr = zzfl.zzr(0L);
            }
        } else if (z && this.zzg.zzy() == zzxkVar2.zzb && this.zzg.zzz() == zzxkVar2.zzc) {
            jZzr = this.zzg.zzu();
        }
        return new zznn(jZzb, zzbfVar, i, zzxkVar2, jZzr, this.zzg.zzq(), this.zzg.zzs(), this.zzd.zza(), this.zzg.zzu(), this.zzg.zzw());
    }

    public final /* synthetic */ void zzab(zzbb zzbbVar, zznp zznpVar, zzs zzsVar) {
        zznpVar.zzdi(zzbbVar, new zzno(zzsVar, this.zze));
    }

    public final /* synthetic */ void zzac() {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 1028, new zzea(zznnVarZzZ) { // from class: com.google.android.gms.internal.ads.zzpj
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
        this.zzf.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzai(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar, final int i2) {
        final zznn zznnVarZzag = zzag(i, zzxkVar);
        zzY(zznnVarZzag, 1000, new zzea(zznnVarZzag, zzxbVar, zzxgVar, i2) { // from class: com.google.android.gms.internal.ads.zzoi
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzaj(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar) {
        final zznn zznnVarZzag = zzag(i, zzxkVar);
        zzY(zznnVarZzag, 1001, new zzea(zznnVarZzag, zzxbVar, zzxgVar) { // from class: com.google.android.gms.internal.ads.zzoj
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzak(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar) {
        final zznn zznnVarZzag = zzag(i, zzxkVar);
        zzY(zznnVarZzag, 1002, new zzea(zznnVarZzag, zzxbVar, zzxgVar) { // from class: com.google.android.gms.internal.ads.zzok
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzal(int i, zzxk zzxkVar, final zzxb zzxbVar, final zzxg zzxgVar, final IOException iOException, final boolean z) {
        final zznn zznnVarZzag = zzag(i, zzxkVar);
        zzY(zznnVarZzag, AppFunctionException.ERROR_FUNCTION_NOT_FOUND, new zzea() { // from class: com.google.android.gms.internal.ads.zzol
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzh(zznnVarZzag, zzxbVar, zzxgVar, iOException, z);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzxv
    public final void zzam(int i, zzxk zzxkVar, final zzxg zzxgVar) {
        final zznn zznnVarZzag = zzag(i, zzxkVar);
        zzY(zznnVarZzag, 1004, new zzea() { // from class: com.google.android.gms.internal.ads.zzon
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzdf(zznnVarZzag, zzxgVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzb(zzbf zzbfVar, final int i) {
        zzbb zzbbVar = this.zzg;
        zzbbVar.getClass();
        this.zzd.zzg(zzbbVar);
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 0, new zzea(zznnVarZzZ, i) { // from class: com.google.android.gms.internal.ads.zzoo
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzc(final zzak zzakVar, final int i) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 1, new zzea(zznnVarZzZ, zzakVar, i) { // from class: com.google.android.gms.internal.ads.zzop
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzd(final zzbn zzbnVar) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 2, new zzea(zznnVarZzZ, zzbnVar) { // from class: com.google.android.gms.internal.ads.zzoq
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zze(final zzan zzanVar) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 14, new zzea(zznnVarZzZ, zzanVar) { // from class: com.google.android.gms.internal.ads.zzpd
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzf(final boolean z) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 3, new zzea(zznnVarZzZ, z) { // from class: com.google.android.gms.internal.ads.zzor
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzg(final zzax zzaxVar) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 13, new zzea(zznnVarZzZ, zzaxVar) { // from class: com.google.android.gms.internal.ads.zzos
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzh(final boolean z, final int i) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, -1, new zzea(zznnVarZzZ, z, i) { // from class: com.google.android.gms.internal.ads.zzot
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzi(final int i) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 4, new zzea() { // from class: com.google.android.gms.internal.ads.zzou
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zze(zznnVarZzZ, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzj(final boolean z, final int i) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 5, new zzea(zznnVarZzZ, z, i) { // from class: com.google.android.gms.internal.ads.zzov
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzk(final int i) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 6, new zzea(zznnVarZzZ, i) { // from class: com.google.android.gms.internal.ads.zzow
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzl(final boolean z) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 7, new zzea(zznnVarZzZ, z) { // from class: com.google.android.gms.internal.ads.zzoy
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzm(final zzau zzauVar) {
        final zznn zznnVarZzah = zzah(zzauVar);
        zzY(zznnVarZzah, 10, new zzea() { // from class: com.google.android.gms.internal.ads.zzoz
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzg(zznnVarZzah, zzauVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzn(final zzau zzauVar) {
        final zznn zznnVarZzah = zzah(zzauVar);
        zzY(zznnVarZzah, 10, new zzea(zznnVarZzah, zzauVar) { // from class: com.google.android.gms.internal.ads.zzpa
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzo(final zzba zzbaVar, final zzba zzbaVar2, final int i) {
        if (i == 1) {
            this.zzi = false;
            i = 1;
        }
        zzpq zzpqVar = this.zzd;
        zzbb zzbbVar = this.zzg;
        zzbbVar.getClass();
        zzpqVar.zzf(zzbbVar);
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 11, new zzea() { // from class: com.google.android.gms.internal.ads.zzpb
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                ((zznp) obj).zzde(zznnVarZzZ, zzbaVar, zzbaVar2, i);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzp(final zzav zzavVar) {
        final zznn zznnVarZzZ = zzZ();
        zzY(zznnVarZzZ, 12, new zzea(zznnVarZzZ, zzavVar) { // from class: com.google.android.gms.internal.ads.zzpc
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzq(final int i) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 21, new zzea(zznnVarZzaf, i) { // from class: com.google.android.gms.internal.ads.zzpf
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzr(final float f) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 22, new zzea(zznnVarZzaf, f) { // from class: com.google.android.gms.internal.ads.zznv
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzs(final boolean z) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 23, new zzea(zznnVarZzaf, z) { // from class: com.google.android.gms.internal.ads.zzpe
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzt(final zzbv zzbvVar) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 25, new zzea() { // from class: com.google.android.gms.internal.ads.zzpg
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
                zznn zznnVar = zznnVarZzaf;
                zzbv zzbvVar2 = zzbvVar;
                ((zznp) obj).zzp(zznnVar, zzbvVar2);
                int i = zzbvVar2.zzb;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaz
    public final void zzu(final int i, final int i2) {
        final zznn zznnVarZzaf = zzaf();
        zzY(zznnVarZzaf, 24, new zzea(zznnVarZzaf, i, i2) { // from class: com.google.android.gms.internal.ads.zzoh
            @Override // com.google.android.gms.internal.ads.zzea
            public final /* synthetic */ void zza(Object obj) {
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzv(zznp zznpVar) {
        this.zzf.zzc(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzw(zznp zznpVar) {
        this.zzf.zzd(zznpVar);
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzx(final zzbb zzbbVar, Looper looper) {
        boolean z = true;
        if (this.zzg != null && !this.zzd.zzi().isEmpty()) {
            z = false;
        }
        zzgtj.zzi(z);
        zzbbVar.getClass();
        this.zzg = zzbbVar;
        zzdo zzdoVar = this.zza;
        this.zzh = zzdoVar.zzd(looper, null);
        this.zzf = this.zzf.zza(looper, zzdoVar, new zzeb() { // from class: com.google.android.gms.internal.ads.zzpp
            @Override // com.google.android.gms.internal.ads.zzeb
            public final /* synthetic */ void zza(Object obj, zzs zzsVar) {
                this.zza.zzab(zzbbVar, (zznp) obj, zzsVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzy() {
        zzdz zzdzVar = this.zzh;
        zzdzVar.getClass();
        zzdzVar.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zznq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzac();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zznm
    public final void zzz(List list, zzxk zzxkVar) {
        zzbb zzbbVar = this.zzg;
        zzbbVar.getClass();
        this.zzd.zzh(list, zzxkVar, zzbbVar);
    }
}
