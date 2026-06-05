package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.android.gms.internal.ads.zzbhv$zzab;
import com.google.android.gms.internal.ads.zzbhv$zzaf;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class zzejl extends zzejm {
    private static final SparseArray zzg;
    private final Context zzb;
    private final zzdbw zzc;
    private final TelephonyManager zzd;
    private final zzejd zze;
    private zzbhv$zzq zzf;

    static {
        SparseArray sparseArray = new SparseArray();
        zzg = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzbhv$zzaf.zzd.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzbhv$zzaf.zzd zzdVar = zzbhv$zzaf.zzd.CONNECTING;
        sparseArray.put(iOrdinal, zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzbhv$zzaf.zzd.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzbhv$zzaf.zzd zzdVar2 = zzbhv$zzaf.zzd.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzdVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzbhv$zzaf.zzd.SUSPENDED);
        sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzdVar);
        sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzdVar);
    }

    public zzejl(Context context, zzdbw zzdbwVar, zzejd zzejdVar, zzeiz zzeizVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        super(zzeizVar, zzgVar);
        this.zzb = context;
        this.zzc = zzdbwVar;
        this.zze = zzejdVar;
        this.zzd = (TelephonyManager) context.getSystemService("phone");
    }

    public static final /* synthetic */ zzbhv$zzaf.zzd zze(Bundle bundle) {
        return (zzbhv$zzaf.zzd) zzg.get(zzfln.zza(zzfln.zza(bundle, DeviceRequestsHelper.DEVICE_INFO_DEVICE), "network").getInt("active_network_state", -1), zzbhv$zzaf.zzd.UNSPECIFIED);
    }

    private static final zzbhv$zzq zzg(boolean z) {
        return z ? zzbhv$zzq.ENUM_TRUE : zzbhv$zzq.ENUM_FALSE;
    }

    public final void zza(boolean z) {
        zzhbw.zzr(this.zzc.zza(new Bundle()), new zzejk(this, z), zzcfr.zzh);
    }

    public final /* synthetic */ zzbhv$zzab zzb(Bundle bundle) {
        zzbhv$zzab.zzb zzbVar;
        zzbhv$zzab.zza zzaVarZzq = zzbhv$zzab.zzq();
        int i = bundle.getInt("cnt", -2);
        int i2 = bundle.getInt("gnt", 0);
        if (i == -1) {
            this.zzf = zzbhv$zzq.ENUM_TRUE;
        } else {
            this.zzf = zzbhv$zzq.ENUM_FALSE;
            if (i == 0) {
                zzaVarZzq.zzc(zzbhv$zzab.zzc.CELL);
            } else if (i != 1) {
                zzaVarZzq.zzc(zzbhv$zzab.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarZzq.zzc(zzbhv$zzab.zzc.WIFI);
            }
            switch (i2) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzbhv$zzab.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzbhv$zzab.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzbhv$zzab.zzb.LTE;
                    break;
                default:
                    zzbVar = zzbhv$zzab.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarZzq.zzg(zzbVar);
        }
        return zzaVarZzq.zzbm();
    }

    public final /* synthetic */ byte[] zzc(boolean z, ArrayList arrayList, zzbhv$zzab zzbhv_zzab, zzbhv$zzaf.zzd zzdVar) {
        zzbhv$zzaf.zza.C0004zza c0004zzaZzz = zzbhv$zzaf.zza.zzz();
        c0004zzaZzz.zzv(arrayList);
        Context context = this.zzb;
        c0004zzaZzz.zzJ(zzg(Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0));
        c0004zzaZzz.zzN(com.google.android.gms.ads.internal.zzt.zzf().zzf(context, this.zzd));
        zzejd zzejdVar = this.zze;
        c0004zzaZzz.zzk(zzejdVar.zzf());
        c0004zzaZzz.zzo(zzejdVar.zzj());
        c0004zzaZzz.zzR(zzejdVar.zzd());
        c0004zzaZzz.zzZ(zzdVar);
        c0004zzaZzz.zzz(zzbhv_zzab);
        c0004zzaZzz.zzV(this.zzf);
        c0004zzaZzz.zzg(zzg(z));
        c0004zzaZzz.zzad(zzejdVar.zzb());
        c0004zzaZzz.zzc(com.google.android.gms.ads.internal.zzt.zzk().currentTimeMillis());
        c0004zzaZzz.zzF(zzg(Settings.Global.getInt(context.getContentResolver(), "wifi_on", 0) != 0));
        return c0004zzaZzz.zzbm().zzaN();
    }

    public final /* synthetic */ zzejd zzd() {
        return this.zze;
    }
}
