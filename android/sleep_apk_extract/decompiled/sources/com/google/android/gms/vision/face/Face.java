package com.google.android.gms.vision.face;

import android.graphics.PointF;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Face {
    private int zza;
    private PointF zzb;
    private float zzc;
    private float zzd;
    private float zze;
    private float zzf;
    private float zzg;
    private List<Landmark> zzh;
    private final List<Contour> zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private final float zzm;

    public Face(int i, PointF pointF, float f, float f2, float f3, float f4, float f5, Landmark[] landmarkArr, Contour[] contourArr, float f6, float f7, float f8, float f9) {
        this.zza = i;
        this.zzb = pointF;
        this.zzc = f;
        this.zzd = f2;
        this.zze = f3;
        this.zzf = f4;
        this.zzg = f5;
        this.zzh = Arrays.asList(landmarkArr);
        this.zzi = Arrays.asList(contourArr);
        this.zzj = zza(f6);
        this.zzk = zza(f7);
        this.zzl = zza(f8);
        this.zzm = zza(f9);
    }

    private static float zza(float f) {
        if (f < 0.0f || f > 1.0f) {
            return -1.0f;
        }
        return f;
    }

    public float getHeight() {
        return this.zzd;
    }

    public int getId() {
        return this.zza;
    }

    public float getIsSmilingProbability() {
        return this.zzl;
    }

    public PointF getPosition() {
        PointF pointF = this.zzb;
        return new PointF(pointF.x - (this.zzc / 2.0f), pointF.y - (this.zzd / 2.0f));
    }

    public float getWidth() {
        return this.zzc;
    }
}
