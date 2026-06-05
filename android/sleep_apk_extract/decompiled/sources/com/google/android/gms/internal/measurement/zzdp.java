package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzdp extends zzeo {
    final /* synthetic */ Context zza;
    final /* synthetic */ Bundle zzb;
    final /* synthetic */ zzez zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzdp(zzez zzezVar, Context context, Bundle bundle) {
        super(zzezVar, true);
        this.zza = context;
        this.zzb = bundle;
        Objects.requireNonNull(zzezVar);
        this.zzc = zzezVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzeo
    public final void zza() {
        try {
            Context context = this.zza;
            Preconditions.checkNotNull(context);
            com.google.firebase.analytics.zzg.zza().zzb();
            String strZza = com.google.android.gms.measurement.internal.zzhu.zza(context);
            Preconditions.checkNotNull(context);
            Resources resources = context.getResources();
            if (TextUtils.isEmpty(strZza)) {
                strZza = com.google.android.gms.measurement.internal.zzhu.zza(context);
            }
            Boolean boolZzc = com.google.android.gms.measurement.internal.zzhu.zzc("google_analytics_force_disable_updates", resources, strZza);
            zzez zzezVar = this.zzc;
            zzezVar.zzT(zzezVar.zzc(context, boolZzc == null || !boolZzc.booleanValue()));
            if (zzezVar.zzS() == null) {
                Log.w(zzezVar.zzQ(), "Failed to connect to measurement client.");
                return;
            }
            int localVersion = DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID);
            int remoteVersion = DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID);
            int iMax = Math.max(localVersion, remoteVersion);
            boolean z = Boolean.TRUE.equals(boolZzc) || remoteVersion < localVersion;
            long j = iMax;
            zzezVar.zzU(j);
            zzdb zzdbVar = new zzdb(161000L, j, z, this.zzb, com.google.android.gms.measurement.internal.zzhu.zza(context));
            if (zzezVar.zzO()) {
                ((zzcp) Preconditions.checkNotNull(zzezVar.zzS())).initializeWithElapsedTime(ObjectWrapper.wrap(context), zzdbVar, this.zzi, this.zzj);
            } else {
                ((zzcp) Preconditions.checkNotNull(zzezVar.zzS())).initialize(ObjectWrapper.wrap(context), zzdbVar, this.zzi);
            }
        } catch (Exception e) {
            this.zzc.zzN(e, true, false);
        }
    }
}
