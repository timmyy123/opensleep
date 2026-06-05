package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;

/* JADX INFO: loaded from: classes3.dex */
public final class zzadg extends Surface {
    private static int zzb;
    private static boolean zzc;
    public final boolean zza;
    private final zzadf zzd;
    private boolean zze;

    public /* synthetic */ zzadg(zzadf zzadfVar, SurfaceTexture surfaceTexture, boolean z, byte[] bArr) {
        super(surfaceTexture);
        this.zzd = zzadfVar;
        this.zza = z;
    }

    public static synchronized boolean zza(Context context) {
        if (!zzc) {
            try {
            } catch (zzdw e) {
                zzeg.zze("PlaceholderSurface", "Failed to determine secure mode due to GL error: ".concat(String.valueOf(e.getMessage())));
            }
            int i = zzdx.zza(context) ? zzdx.zzb() ? 1 : 2 : 0;
            zzb = i;
            zzc = true;
        }
        return zzb != 0;
    }

    public static zzadg zzb(Context context, boolean z) {
        boolean z2 = true;
        if (z && !zza(context)) {
            z2 = false;
        }
        zzgtj.zzi(z2);
        return new zzadf().zza(z ? zzb : 0);
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        zzadf zzadfVar = this.zzd;
        synchronized (zzadfVar) {
            try {
                if (!this.zze) {
                    zzadfVar.zzb();
                    this.zze = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
