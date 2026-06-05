package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class zzpp {
    private static final Object zza = new Object();
    private static volatile Map zzb;
    private final String zzc;

    public zzpp(Context context, zzpr zzprVar) {
        this.zzc = zzprVar.zzb() ? zzlg.zzb(context, zzprVar.zza(), false) : zzprVar.zza();
        zzprVar.zzc();
        zzprVar.zzf();
        zzprVar.zzd();
        zzprVar.zze();
    }

    public static Map zza(Context context) {
        Map mapBuildOrThrow;
        Map map = zzb;
        if (map != null) {
            return map;
        }
        synchronized (zza) {
            mapBuildOrThrow = zzb;
            if (mapBuildOrThrow == null) {
                ImmutableMap.Builder builder = ImmutableMap.builder();
                try {
                    String[] list = context.getAssets().list("phenotype");
                    if (list != null) {
                        for (String str : list) {
                            if (str.endsWith("_package_metadata.binarypb")) {
                                try {
                                    AssetManager assets = context.getAssets();
                                    StringBuilder sb = new StringBuilder(str.length() + 10);
                                    sb.append("phenotype/");
                                    sb.append(str);
                                    InputStream inputStreamOpen = assets.open(sb.toString());
                                    try {
                                        zzpp zzppVar = new zzpp(context, zzpr.zzh(inputStreamOpen, zzadf.zza()));
                                        builder.put(zzppVar.zzc, zzppVar);
                                        if (inputStreamOpen != null) {
                                            inputStreamOpen.close();
                                        }
                                    } catch (Throwable th) {
                                        if (inputStreamOpen != null) {
                                            try {
                                                inputStreamOpen.close();
                                            } catch (Throwable th2) {
                                                th.addSuppressed(th2);
                                            }
                                        }
                                        throw th;
                                    }
                                } catch (zzaeh e) {
                                    StringBuilder sb2 = new StringBuilder(str.length() + 45);
                                    sb2.append("Unable to read Phenotype PackageMetadata for ");
                                    sb2.append(str);
                                    Log.e("PackageInfo", sb2.toString(), e);
                                }
                            }
                        }
                    }
                } catch (IOException e2) {
                    Log.e("PackageInfo", "Unable to read Phenotype PackageMetadata from assets.", e2);
                }
                mapBuildOrThrow = builder.buildOrThrow();
                zzb = mapBuildOrThrow;
            }
        }
        return mapBuildOrThrow;
    }
}
