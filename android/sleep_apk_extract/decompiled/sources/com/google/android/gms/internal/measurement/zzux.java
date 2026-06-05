package com.google.android.gms.internal.measurement;

import android.net.Uri;
import android.system.Os;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzux {
    public static IOException zza(zzru zzruVar, Uri uri, IOException iOException, String str) {
        try {
            zzsr zzsrVarZzb = zzsr.zzb();
            zzsrVarZzb.zzc();
            File file = (File) zzruVar.zza(uri, zzsrVarZzb);
            return file.exists() ? file.isFile() ? file.canRead() ? file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str) : file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str) : file.canRead() ? file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str) : file.canWrite() ? zzb(file, iOException, str) : zzb(file, iOException, str) : zzb(file, iOException, str);
        } catch (IOException unused) {
            return new IOException(iOException);
        }
    }

    private static IOException zzb(File file, IOException iOException, String str) {
        File parentFile = file.getParentFile();
        return parentFile == null ? zzc(file, iOException, str) : parentFile.exists() ? parentFile.isDirectory() ? parentFile.canRead() ? parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str) : parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str) : parentFile.canRead() ? parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str) : parentFile.canWrite() ? zzc(file, iOException, str) : zzc(file, iOException, str) : zzc(file, iOException, str);
    }

    private static IOException zzc(File file, IOException iOException, String str) {
        String strConcat;
        try {
            Locale locale = Locale.US;
            String str2 = " canonical[" + file.getCanonicalPath() + "] freeSpace[" + file.getFreeSpace() + "] protoName[" + str + "]";
            StringBuilder sb = new StringBuilder(str2.length() + 16);
            sb.append("Inoperable file:");
            sb.append(str2);
            strConcat = sb.toString();
            try {
                String str3 = " mode[" + Os.stat(file.getCanonicalPath()).st_mode + "]";
                StringBuilder sb2 = new StringBuilder(strConcat.length() + str3.length());
                sb2.append(strConcat);
                sb2.append(str3);
                strConcat = sb2.toString();
            } catch (Exception unused) {
            }
        } catch (IOException unused2) {
            strConcat = "Inoperable file:".concat(" failed");
        }
        return new IOException(strConcat, iOException);
    }
}
