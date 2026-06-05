package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfyq {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final zzbds zzd;

    public zzfyq(Context context, zzbds zzbdsVar) {
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        File dir = context.getDir("pccache", 0);
        zzfyr.zzd(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache", 0);
        zzfyr.zzd(dir2, true);
        this.zza = dir2;
        this.zzd = zzbdsVar;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(this.zzd.zza()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        int iZza = this.zzd.zza();
        return zzba$$ExternalSyntheticOutline0.m(iZza, "FBAMTD", new StringBuilder(String.valueOf(iZza).length() + 6));
    }

    private final String zzf() {
        int iZza = this.zzd.zza();
        return zzba$$ExternalSyntheticOutline0.m(iZza, "LATMTD", new StringBuilder(String.valueOf(iZza).length() + 6));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean zza(zzbdu zzbduVar, zzfyw zzfywVar) {
        boolean z;
        String strZza = zzbduVar.zza().zza();
        byte[] bArrZzA = zzbduVar.zzb().zzA();
        byte[] bArrZzA2 = zzbduVar.zzc().zzA();
        if (!TextUtils.isEmpty(strZza) && bArrZzA2.length != 0) {
            File file = this.zza;
            zzfyr.zze(file);
            file.mkdirs();
            zzfyr.zzc(strZza, file).mkdirs();
            File fileZza = zzfyr.zza(strZza, "pcam.jar", file);
            if ((bArrZzA.length <= 0 || zzfyr.zzb(fileZza, bArrZzA)) && zzfyr.zzb(zzfyr.zza(strZza, "pcbc", file), bArrZzA2)) {
                File fileZza2 = zzfyr.zza(zzbduVar.zza().zza(), "pcam.jar", file);
                if (fileZza2.exists() && zzfywVar != null && !zzfywVar.zza(fileZza2)) {
                    return false;
                }
                String strZza2 = zzbduVar.zza().zza();
                if (TextUtils.isEmpty(strZza2)) {
                    z = false;
                } else {
                    File fileZza3 = zzfyr.zza(strZza2, "pcam.jar", file);
                    File fileZza4 = zzfyr.zza(strZza2, "pcbc", file);
                    File fileZza5 = zzfyr.zza(strZza2, "pcam.jar", zzd());
                    File fileZza6 = zzfyr.zza(strZza2, "pcbc", zzd());
                    if ((!fileZza3.exists() || fileZza3.renameTo(fileZza5)) && fileZza4.exists() && fileZza4.renameTo(fileZza6)) {
                        zzbea zzbeaVarZzi = zzbeb.zzi();
                        zzbeaVarZzi.zza(zzbduVar.zza().zza());
                        zzbeaVarZzi.zzb(zzbduVar.zza().zzb());
                        zzbeaVarZzi.zzd(zzbduVar.zza().zzd());
                        zzbeaVarZzi.zze(zzbduVar.zza().zze());
                        zzbeaVarZzi.zzc(zzbduVar.zza().zzc());
                        zzbeb zzbebVar = (zzbeb) zzbeaVarZzi.zzbm();
                        zzbeb zzbebVarZzc = zzc(1);
                        SharedPreferences.Editor editorEdit = this.zzc.edit();
                        if (zzbebVarZzc != null && !zzbebVar.zza().equals(zzbebVarZzc.zza())) {
                            editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzbebVarZzc.zzaN()));
                        }
                        editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzbebVar.zzaN()));
                        if (editorEdit.commit()) {
                            z = true;
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                zzbeb zzbebVarZzc2 = zzc(1);
                if (zzbebVarZzc2 != null) {
                    hashSet.add(zzbebVarZzc2.zza());
                }
                zzbeb zzbebVarZzc3 = zzc(2);
                if (zzbebVarZzc3 != null) {
                    hashSet.add(zzbebVarZzc3.zza());
                }
                for (File file2 : zzd().listFiles()) {
                    String name = file2.getName();
                    if (!hashSet.contains(name)) {
                        zzfyr.zze(zzfyr.zzc(name, zzd()));
                    }
                }
                return z;
            }
        }
        return false;
    }

    public final zzfyp zzb(int i) {
        zzbeb zzbebVarZzc = zzc(1);
        if (zzbebVarZzc == null) {
            return null;
        }
        String strZza = zzbebVarZzc.zza();
        File fileZza = zzfyr.zza(strZza, "pcam.jar", zzd());
        if (!fileZza.exists()) {
            fileZza = zzfyr.zza(strZza, "pcam", zzd());
        }
        return new zzfyp(zzbebVarZzc, fileZza, zzfyr.zza(strZza, "pcbc", zzd()), zzfyr.zza(strZza, "pcopt", zzd()));
    }

    public final zzbeb zzc(int i) {
        SharedPreferences sharedPreferences = this.zzc;
        String string = i == 1 ? sharedPreferences.getString(zzf(), null) : sharedPreferences.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzida zzidaVar = zzida.zza;
            zzbeb zzbebVarZzg = zzbeb.zzg(zzida.zzt(bArrStringToBytes, 0, bArrStringToBytes.length));
            String strZza = zzbebVarZzg.zza();
            File fileZza = zzfyr.zza(strZza, "pcam.jar", zzd());
            if (!fileZza.exists()) {
                fileZza = zzfyr.zza(strZza, "pcam", zzd());
            }
            File fileZza2 = zzfyr.zza(strZza, "pcbc", zzd());
            if (fileZza.exists()) {
                if (fileZza2.exists()) {
                    return zzbebVarZzg;
                }
            }
        } catch (zziet unused) {
        }
        return null;
    }
}
