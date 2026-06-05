package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class zzd extends zzf {
    private final Map zza;
    private final Map zzb;
    private long zzc;

    public zzd(zzic zzicVar) {
        super(zzicVar);
        this.zzb = new ArrayMap();
        this.zza = new ArrayMap();
    }

    private final void zzh(long j, zzlu zzluVar) {
        if (zzluVar == null) {
            this.zzu.zzaW().zzk().zza("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            this.zzu.zzaW().zzk().zzb("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        zzpp.zzay(zzluVar, bundle, true);
        this.zzu.zzj().zzE("am", "_xa", bundle);
    }

    private final void zzi(String str, long j, zzlu zzluVar) {
        if (zzluVar == null) {
            this.zzu.zzaW().zzk().zza("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            this.zzu.zzaW().zzk().zzb("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        zzpp.zzay(zzluVar, bundle, true);
        this.zzu.zzj().zzE("am", "_xu", bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final void zzf(long j) {
        Map map = this.zza;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            map.put((String) it.next(), Long.valueOf(j));
        }
        if (map.isEmpty()) {
            return;
        }
        this.zzc = j;
    }

    public final void zza(String str, long j) {
        if (str == null || str.length() == 0) {
            zza$$ExternalSyntheticOutline0.m(this.zzu, "Ad unit id must be a non-empty string");
        } else {
            this.zzu.zzaX().zzj(new zza(this, str, j));
        }
    }

    public final void zzb(String str, long j) {
        if (str == null || str.length() == 0) {
            zza$$ExternalSyntheticOutline0.m(this.zzu, "Ad unit id must be a non-empty string");
        } else {
            this.zzu.zzaX().zzj(new zzb(this, str, j));
        }
    }

    public final void zzc(long j) {
        zzlu zzluVarZzh = this.zzu.zzs().zzh(false);
        Map map = this.zza;
        for (String str : map.keySet()) {
            zzi(str, j - ((Long) map.get(str)).longValue(), zzluVarZzh);
        }
        if (!map.isEmpty()) {
            zzh(j - this.zzc, zzluVarZzh);
        }
        zzf(j);
    }

    public final /* synthetic */ void zzd(String str, long j) {
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzb;
        if (map.isEmpty()) {
            this.zzc = j;
        }
        Integer num = (Integer) map.get(str);
        if (num != null) {
            map.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (map.size() >= 100) {
            this.zzu.zzaW().zze().zza("Too many ads visible");
        } else {
            map.put(str, 1);
            this.zza.put(str, Long.valueOf(j));
        }
    }

    public final /* synthetic */ void zze(String str, long j) {
        zzg();
        Preconditions.checkNotEmpty(str);
        Map map = this.zzb;
        Integer num = (Integer) map.get(str);
        zzic zzicVar = this.zzu;
        if (num == null) {
            zzicVar.zzaW().zzb().zzb("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        zzlu zzluVarZzh = zzicVar.zzs().zzh(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            map.put(str, Integer.valueOf(iIntValue));
            return;
        }
        map.remove(str);
        Map map2 = this.zza;
        Long l = (Long) map2.get(str);
        if (l == null) {
            zza$$ExternalSyntheticOutline0.m(this.zzu, "First ad unit exposure time was never set");
        } else {
            long jLongValue = j - l.longValue();
            map2.remove(str);
            zzi(str, jLongValue, zzluVarZzh);
        }
        if (map.isEmpty()) {
            long j2 = this.zzc;
            if (j2 == 0) {
                zza$$ExternalSyntheticOutline0.m(this.zzu, "First ad exposure time was never set");
            } else {
                zzh(j - j2, zzluVarZzh);
                this.zzc = 0L;
            }
        }
    }
}
