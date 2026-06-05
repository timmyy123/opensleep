package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzsv implements zzrt {
    private final zzafc zza;
    private zzro[] zzb;

    private zzsv(zzafc zzafcVar) {
        this.zza = zzafcVar;
    }

    public static zzsv zzb(zzafc zzafcVar) {
        return new zzsv(zzafcVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzrt
    public final /* bridge */ /* synthetic */ Object zza(zzrs zzrsVar) throws IOException {
        Uri uriZza = zzsu.zza(zzrsVar.zzb());
        List listZzd = zzrsVar.zzd(zzrsVar.zza().zzj(uriZza));
        zzro[] zzroVarArr = this.zzb;
        if (zzroVarArr != null) {
            zzroVarArr[0].zza(listZzd);
        }
        try {
            OutputStream outputStream = (OutputStream) listZzd.get(0);
            try {
                this.zza.zzce(outputStream);
                zzro[] zzroVarArr2 = this.zzb;
                if (zzroVarArr2 != null) {
                    zzroVarArr2[0].zzb();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                zzrsVar.zza().zzl(uriZza, zzrsVar.zzb());
                return null;
            } finally {
            }
        } catch (Exception e) {
            try {
                zzrsVar.zza().zzk(uriZza);
            } catch (FileNotFoundException unused) {
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            throw new IOException(e);
        }
    }

    public final zzsv zzc(zzro... zzroVarArr) {
        this.zzb = zzroVarArr;
        return this;
    }
}
