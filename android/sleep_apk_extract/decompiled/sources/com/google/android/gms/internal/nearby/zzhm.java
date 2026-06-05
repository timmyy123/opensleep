package com.google.android.gms.internal.nearby;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.nearby.connection.Payload;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzhm {
    private static File zza;

    public static Payload zza(Context context, zzhk zzhkVar) {
        long jZzb = zzhkVar.zzb();
        int iZza = zzhkVar.zza();
        if (iZza == 1) {
            zzhg zzhgVarZzh = zzhkVar.zzh();
            byte[] bArrZzc = zzhgVarZzh != null ? zzhgVarZzh.zzc() : zzhkVar.zzz();
            zzpm.zzc(bArrZzc, "Payload bytes cannot be null if type is BYTES.");
            return Payload.zzb(bArrZzc, jZzb);
        }
        if (iZza != 2) {
            if (iZza != 3) {
                Log.w("NearbyConnections", String.format("Incoming ParcelablePayload %d has unknown type %d", Long.valueOf(zzhkVar.zzb()), Integer.valueOf(zzhkVar.zza())));
                return null;
            }
            ParcelFileDescriptor parcelFileDescriptorZzf = zzhkVar.zzf();
            zzpm.zzc(parcelFileDescriptorZzf, "Data ParcelFileDescriptor cannot be null for type STREAM");
            return Payload.zze(Payload.Stream.zzb(parcelFileDescriptorZzf), jZzb);
        }
        String strZzj = zzhkVar.zzj();
        Uri uriZze = zzhkVar.zze();
        if (strZzj == null || uriZze == null) {
            if (uriZze != null && zzhkVar.zzf() == null) {
                Log.d("NearbyConnections", "Created file payload based on uri instead pfd");
                return Payload.zzd(uriZze, zzhkVar.zzd(), jZzb);
            }
            ParcelFileDescriptor parcelFileDescriptorZzf2 = zzhkVar.zzf();
            zzpm.zzc(parcelFileDescriptorZzf2, "Data ParcelFileDescriptor cannot be null for type FILE");
            return Payload.zzc(Payload.File.zzc(parcelFileDescriptorZzf2), jZzb);
        }
        try {
            ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uriZze, "r");
            if (parcelFileDescriptorOpenFileDescriptor == null) {
                Log.w("NearbyConnections", String.format("Failed to get ParcelFileDescriptor for %s", uriZze));
                return null;
            }
            zzj zzjVar = zzj.zza;
            Payload payloadZzc = Payload.zzc(Payload.File.zzb(new File(strZzj), parcelFileDescriptorOpenFileDescriptor, zzhkVar.zzc(), uriZze), jZzb);
            if (!TextUtils.isEmpty(zzhkVar.zzk())) {
                payloadZzc.setParentFolder(zzhkVar.zzk());
            }
            if (!TextUtils.isEmpty(zzhkVar.zzi())) {
                payloadZzc.setFileName(zzhkVar.zzi());
            }
            return payloadZzc;
        } catch (FileNotFoundException e) {
            Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uriZze, strZzj), e);
            return null;
        } catch (SecurityException e2) {
            Log.w("NearbyConnections", String.format("Failed to create Payload from ParcelablePayload: unable to open uri %s for file %s.", uriZze, strZzj), e2);
            return null;
        }
    }

    public static File zzb() {
        return zza;
    }

    public static void zzc(File file) {
        if (file == null) {
            Log.e("NearbyConnections", "Cannot set null temp directory");
        } else {
            zza = file;
        }
    }
}
