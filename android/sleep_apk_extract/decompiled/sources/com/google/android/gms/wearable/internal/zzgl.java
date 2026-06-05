package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgl extends com.google.android.gms.internal.wearable.zzb implements zzgm {
    public zzgl() {
        super("com.google.android.gms.wearable.internal.IWearableCallbacks");
    }

    @Override // com.google.android.gms.internal.wearable.zzb
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zzfd zzfdVar = (zzfd) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfd.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzb(zzfdVar);
                break;
            case 3:
                zzil zzilVar = (zzil) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzil.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzh(zzilVar);
                break;
            case 4:
                zzfj zzfjVar = (zzfj) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfj.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzi(zzfjVar);
                break;
            case 5:
                DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.wearable.zzc.zza(parcel, DataHolder.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzj(dataHolder);
                break;
            case 6:
                zzed zzedVar = (zzed) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzed.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzk(zzedVar);
                break;
            case 7:
                zziv zzivVar = (zziv) com.google.android.gms.internal.wearable.zzc.zza(parcel, zziv.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzl(zzivVar);
                break;
            case 8:
                zzfr zzfrVar = (zzfr) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfr.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzn(zzfrVar);
                break;
            case 9:
                zzfx zzfxVar = (zzfx) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfx.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzo(zzfxVar);
                break;
            case 10:
                zzfh zzfhVar = (zzfh) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfh.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzp(zzfhVar);
                break;
            case 11:
                Status status = (Status) com.google.android.gms.internal.wearable.zzc.zza(parcel, Status.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzy(status);
                break;
            case 12:
                zziz zzizVar = (zziz) com.google.android.gms.internal.wearable.zzc.zza(parcel, zziz.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzz(zzizVar);
                break;
            case 13:
                zzff zzffVar = (zzff) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzff.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzc(zzffVar);
                break;
            case 14:
                zzid zzidVar = (zzid) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzid.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzr(zzidVar);
                break;
            case 15:
                zzco zzcoVar = (zzco) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzco.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzs(zzcoVar);
                break;
            case 16:
                zzco zzcoVar2 = (zzco) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzco.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzt(zzcoVar2);
                break;
            case 17:
                zzer zzerVar = (zzer) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzer.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzu(zzerVar);
                break;
            case 18:
                zzet zzetVar = (zzet) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzet.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzv(zzetVar);
                break;
            case 19:
                zzci zzciVar = (zzci) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzci.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzw(zzciVar);
                break;
            case 20:
                zzck zzckVar = (zzck) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzck.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzx(zzckVar);
                break;
            case 21:
            case 24:
            case 25:
            case 31:
            case 32:
            case 33:
            case 44:
            case 45:
            default:
                return false;
            case 22:
                zzep zzepVar = (zzep) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzep.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzA(zzepVar);
                break;
            case 23:
                zzeh zzehVar = (zzeh) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzeh.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzB(zzehVar);
                break;
            case 26:
                zzh zzhVar = (zzh) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzh.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzC(zzhVar);
                break;
            case 27:
                zzip zzipVar = (zzip) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzip.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzD(zzipVar);
                break;
            case 28:
                zzew zzewVar = (zzew) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzew.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zze(zzewVar);
                break;
            case 29:
                zzfa zzfaVar = (zzfa) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfa.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzg(zzfaVar);
                break;
            case 30:
                zzey zzeyVar = (zzey) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzey.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzf(zzeyVar);
                break;
            case 34:
                zzit zzitVar = (zzit) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzit.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzm(zzitVar);
                break;
            case 35:
                zzfl zzflVar = (zzfl) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfl.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzF(zzflVar);
                break;
            case 36:
                zzij zzijVar = (zzij) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzij.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzG(zzijVar);
                break;
            case 37:
                zzfb zzfbVar = (zzfb) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfb.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzq(zzfbVar);
                break;
            case 38:
                zzcs zzcsVar = (zzcs) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzcs.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzH(zzcsVar);
                break;
            case 39:
                zzfz zzfzVar = (zzfz) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfz.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzd(zzfzVar);
                break;
            case 40:
                zzp zzpVar = (zzp) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzI(zzpVar);
                break;
            case 41:
                zzej zzejVar = (zzej) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzej.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzJ(zzejVar);
                break;
            case 42:
                zzel zzelVar = (zzel) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzel.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzL(zzelVar);
                break;
            case 43:
                zzgd zzgdVar = (zzgd) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgd.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzM(zzgdVar);
                break;
            case 46:
                zzu zzuVar = (zzu) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzu.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzO(zzuVar);
                break;
            case 47:
                zzgb zzgbVar = (zzgb) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgb.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzN(zzgbVar);
                break;
            case 48:
                zzfp zzfpVar = (zzfp) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfp.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzP(zzfpVar);
                break;
            case 49:
                zzgf zzgfVar = (zzgf) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzgf.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzK(zzgfVar);
                break;
            case 50:
                zzfn zzfnVar = (zzfn) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfn.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzQ(zzfnVar);
                break;
            case 51:
                zzen zzenVar = (zzen) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzen.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzR(zzenVar);
                break;
            case 52:
                zzfv zzfvVar = (zzfv) com.google.android.gms.internal.wearable.zzc.zza(parcel, zzfv.CREATOR);
                com.google.android.gms.internal.wearable.zzc.zzd(parcel);
                zzE(zzfvVar);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
