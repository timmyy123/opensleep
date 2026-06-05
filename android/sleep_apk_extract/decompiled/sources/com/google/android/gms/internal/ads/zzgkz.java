package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgkz {
    final File zza;
    private final File zzb;
    private final SharedPreferences zzc;
    private final zzimo zzd;
    private final zzgqh zze;

    public zzgkz(Context context, SharedPreferences sharedPreferences, zzimo zzimoVar, zzgqh zzgqhVar) {
        this.zzc = sharedPreferences;
        File dir = context.getDir("pccache2", 0);
        zzfyr.zzd(dir, false);
        this.zzb = dir;
        File dir2 = context.getDir("tmppccache2", 0);
        zzfyr.zzd(dir2, true);
        this.zza = dir2;
        this.zzd = zzimoVar;
        this.zze = zzgqhVar;
    }

    private final File zzd() {
        File file = new File(this.zzb, Integer.toString(((zzbds) this.zzd.zzb()).zza()));
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    private final String zze() {
        int iZza = ((zzbds) this.zzd.zzb()).zza();
        return zzba$$ExternalSyntheticOutline0.m(iZza, "FBAMTD", new StringBuilder(String.valueOf(iZza).length() + 6));
    }

    private final String zzf() {
        int iZza = ((zzbds) this.zzd.zzb()).zza();
        return zzba$$ExternalSyntheticOutline0.m(iZza, "LATMTD", new StringBuilder(String.valueOf(iZza).length() + 6));
    }

    public final boolean zza(zzgfq zzgfqVar, byte[] bArr, byte[] bArr2) {
        boolean z;
        String strZza = zzgfqVar.zza().zza();
        if (!TextUtils.isEmpty(strZza) && bArr2.length != 0) {
            File file = this.zza;
            zzfyr.zze(file);
            file.mkdirs();
            File fileZzc = zzfyr.zzc(strZza, file);
            fileZzc.getClass();
            fileZzc.mkdirs();
            File fileZza = zzfyr.zza(strZza, "pcam.jar", file);
            fileZza.getClass();
            if (bArr == null || bArr.length <= 0 || zzfyr.zzb(fileZza, bArr)) {
                File fileZza2 = zzfyr.zza(strZza, "pcbc", file);
                fileZza2.getClass();
                if (zzfyr.zzb(fileZza2, bArr2)) {
                    String strZza2 = zzgfqVar.zza().zza();
                    if (TextUtils.isEmpty(strZza2)) {
                        z = false;
                    } else {
                        File fileZza3 = zzfyr.zza(strZza2, "pcam.jar", file);
                        fileZza3.getClass();
                        File fileZza4 = zzfyr.zza(strZza2, "pcbc", file);
                        fileZza4.getClass();
                        File fileZza5 = zzfyr.zza(strZza2, "pcam.jar", zzd());
                        fileZza5.getClass();
                        File fileZza6 = zzfyr.zza(strZza2, "pcbc", zzd());
                        fileZza6.getClass();
                        if (fileZza3.exists() && !fileZza3.renameTo(fileZza5)) {
                            this.zze.zzb(15318);
                        } else if (fileZza4.exists() && fileZza4.renameTo(fileZza6)) {
                            zzgfq zzgfqVarZzc = zzc(1);
                            SharedPreferences.Editor editorEdit = this.zzc.edit();
                            if (zzgfqVarZzc != null && !zzgfqVar.zza().zza().equals(zzgfqVarZzc.zza().zza())) {
                                editorEdit.putString(zze(), Hex.bytesToStringLowercase(zzgfqVarZzc.zzaN()));
                            }
                            editorEdit.putString(zzf(), Hex.bytesToStringLowercase(zzgfqVar.zzaN()));
                            if (editorEdit.commit()) {
                                z = true;
                            } else {
                                this.zze.zzb(15320);
                            }
                        } else {
                            this.zze.zzb(15319);
                        }
                        z = false;
                    }
                    HashSet hashSet = new HashSet();
                    zzgfq zzgfqVarZzc2 = zzc(1);
                    if (zzgfqVarZzc2 != null) {
                        hashSet.add(zzgfqVarZzc2.zza().zza());
                    }
                    zzgfq zzgfqVarZzc3 = zzc(2);
                    if (zzgfqVarZzc3 != null) {
                        hashSet.add(zzgfqVarZzc3.zza().zza());
                    }
                    File[] fileArrListFiles = zzd().listFiles();
                    if (fileArrListFiles != null) {
                        for (File file2 : fileArrListFiles) {
                            String name = file2.getName();
                            if (!hashSet.contains(name)) {
                                File fileZzc2 = zzfyr.zzc(name, zzd());
                                fileZzc2.getClass();
                                zzfyr.zze(fileZzc2);
                            }
                        }
                    }
                    return z;
                }
            }
        }
        this.zze.zzb(15316);
        return false;
    }

    public final zzfyp zzb(int i) {
        zzgfq zzgfqVarZzc = zzc(1);
        if (zzgfqVarZzc == null) {
            this.zze.zzb(15315);
            return null;
        }
        String strZza = zzgfqVarZzc.zza().zza();
        File fileZza = zzfyr.zza(strZza, "pcam.jar", zzd());
        fileZza.getClass();
        if (!fileZza.exists()) {
            fileZza = zzfyr.zza(strZza, "pcam", zzd());
            fileZza.getClass();
        }
        File fileZza2 = zzfyr.zza(strZza, "pcopt", zzd());
        fileZza2.getClass();
        File fileZza3 = zzfyr.zza(strZza, "pcbc", zzd());
        fileZza3.getClass();
        return new zzfyp(zzgfqVarZzc.zza(), fileZza, fileZza3, fileZza2);
    }

    public final zzgfq zzc(int i) {
        zzgfq zzgfqVarZze;
        String strZza;
        File fileZza;
        SharedPreferences sharedPreferences = this.zzc;
        String string = i == 1 ? sharedPreferences.getString(zzf(), null) : sharedPreferences.getString(zze(), null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            byte[] bArrStringToBytes = Hex.stringToBytes(string);
            zzida zzidaVar = zzida.zza;
            zzgfqVarZze = zzgfq.zze(zzida.zzt(bArrStringToBytes, 0, bArrStringToBytes.length));
            strZza = zzgfqVarZze.zza().zza();
            fileZza = zzfyr.zza(strZza, "pcam.jar", zzd());
        } catch (zziet unused) {
            this.zze.zzb(15317);
        }
        if (fileZza == null) {
            throw null;
        }
        if (!fileZza.exists() && (fileZza = zzfyr.zza(strZza, "pcam", zzd())) == null) {
            throw null;
        }
        File fileZza2 = zzfyr.zza(strZza, "pcbc", zzd());
        if (fileZza2 == null) {
            throw null;
        }
        if (fileZza.exists() && fileZza2.exists()) {
            return zzgfqVarZze;
        }
        return null;
    }
}
