package com.google.android.gms.internal.ads;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.internal.ads.zzbhv$zzaf;
import com.google.android.gms.internal.ads.zzbhv$zzd;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
final class zzejk implements zzhbt {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzejl zzb;

    public zzejk(zzejl zzejlVar, boolean z) {
        this.zza = z;
        Objects.requireNonNull(zzejlVar);
        this.zzb = zzejlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        int i = com.google.android.gms.ads.internal.util.zze.$r8$clinit;
        com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to get signals bundle");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0092  */
    @Override // com.google.android.gms.internal.ads.zzhbt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List<String> listUnmodifiableList;
        List listAsList;
        zzbhv$zzd.zza zzaVar;
        zzejl zzejlVar = this.zzb;
        Bundle bundle = (Bundle) obj;
        if (zzejlVar.zzf()) {
            return;
        }
        Object obj2 = bundle.get("ad_types");
        if (obj2 instanceof List) {
            listAsList = (List) obj2;
        } else {
            if (!(obj2 instanceof String[])) {
                listUnmodifiableList = Collections.EMPTY_LIST;
                final ArrayList arrayList = new ArrayList();
                for (String str : listUnmodifiableList) {
                    switch (str.hashCode()) {
                        case -1396342996:
                            zzaVar = str.equals("banner") ? zzbhv$zzd.zza.BANNER : zzbhv$zzd.zza.AD_FORMAT_TYPE_UNSPECIFIED;
                            break;
                        case -1052618729:
                            if (str.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
                                zzaVar = zzbhv$zzd.zza.NATIVE_APP_INSTALL;
                                break;
                            }
                            break;
                        case -239580146:
                            if (str.equals("rewarded")) {
                                zzaVar = zzbhv$zzd.zza.REWARD_BASED_VIDEO_AD;
                                break;
                            }
                            break;
                        case 604727084:
                            if (str.equals("interstitial")) {
                                zzaVar = zzbhv$zzd.zza.INTERSTITIAL;
                                break;
                            }
                            break;
                    }
                    arrayList.add(zzaVar);
                }
                final zzbhv$zzaf.zzd zzdVarZze = zzejl.zze(bundle);
                final zzbhv$zzab zzbhv_zzabZzb = zzejlVar.zzb(bundle);
                final boolean z = this.zza;
                zzejlVar.zza.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejj
                    @Override // com.google.android.gms.internal.ads.zzfok
                    public final /* synthetic */ Object zza(Object obj3) {
                        zzejl zzejlVar2 = this.zza.zzb;
                        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj3;
                        if (zzejlVar2.zzf()) {
                            return null;
                        }
                        zzbhv$zzaf.zzd zzdVar = zzdVarZze;
                        zzbhv$zzab zzbhv_zzab = zzbhv_zzabZzb;
                        ArrayList arrayList2 = arrayList;
                        boolean z2 = z;
                        byte[] bArrZzc = zzejlVar2.zzc(z2, arrayList2, zzbhv_zzab, zzdVar);
                        zzejo.zzf(sQLiteDatabase, z2, true);
                        zzejo.zze(sQLiteDatabase, zzejlVar2.zzd().zzb(), bArrZzc);
                        return null;
                    }
                });
            }
            listAsList = Arrays.asList((String[]) obj2);
        }
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj3 : listAsList) {
            if (obj3 instanceof String) {
                arrayList2.add((String) obj3);
            }
        }
        listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        final ArrayList arrayList3 = new ArrayList();
        while (r1.hasNext()) {
        }
        final zzbhv$zzaf.zzd zzdVarZze2 = zzejl.zze(bundle);
        final zzbhv$zzab zzbhv_zzabZzb2 = zzejlVar.zzb(bundle);
        final boolean z2 = this.zza;
        zzejlVar.zza.zza(new zzfok() { // from class: com.google.android.gms.internal.ads.zzejj
            @Override // com.google.android.gms.internal.ads.zzfok
            public final /* synthetic */ Object zza(Object obj32) {
                zzejl zzejlVar2 = this.zza.zzb;
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj32;
                if (zzejlVar2.zzf()) {
                    return null;
                }
                zzbhv$zzaf.zzd zzdVar = zzdVarZze2;
                zzbhv$zzab zzbhv_zzab = zzbhv_zzabZzb2;
                ArrayList arrayList22 = arrayList3;
                boolean z22 = z2;
                byte[] bArrZzc = zzejlVar2.zzc(z22, arrayList22, zzbhv_zzab, zzdVar);
                zzejo.zzf(sQLiteDatabase, z22, true);
                zzejo.zze(sQLiteDatabase, zzejlVar2.zzd().zzb(), bArrZzc);
                return null;
            }
        });
    }
}
