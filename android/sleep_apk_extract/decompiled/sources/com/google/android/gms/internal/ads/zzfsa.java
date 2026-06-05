package com.google.android.gms.internal.ads;

import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
final class zzfsa implements zzhbt {
    final /* synthetic */ zzfpw zza;
    final /* synthetic */ zzfqg zzb;
    final /* synthetic */ zzdfg zzc;
    final /* synthetic */ zzfsc zzd;

    public zzfsa(zzfsc zzfscVar, zzfpw zzfpwVar, zzfqg zzfqgVar, zzdfg zzdfgVar) {
        this.zza = zzfpwVar;
        this.zzb = zzfqgVar;
        this.zzc = zzdfgVar;
        Objects.requireNonNull(zzfscVar);
        this.zzd = zzfscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhbt
    public final void zza(Throwable th) {
        zzfpw zzfpwVar = this.zza;
        if (zzfpwVar == null) {
            return;
        }
        zzfpwVar.zzd(false);
        zzfqg zzfqgVar = this.zzb;
        if (zzfqgVar != null) {
            zzfqgVar.zza(zzfpwVar);
            zzfqgVar.zzh();
        } else {
            zzfsc zzfscVar = this.zzd;
            zzfscVar.zze().zzb(zzfpwVar.zzm());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb  */
    @Override // com.google.android.gms.internal.ads.zzhbt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        int i;
        zzfpw zzfpwVar = this.zza;
        com.google.android.gms.ads.internal.util.client.zzt zztVar = (com.google.android.gms.ads.internal.util.client.zzt) obj;
        if (zzfpwVar != null) {
            zzfpwVar.zzd(zztVar == com.google.android.gms.ads.internal.util.client.zzt.SUCCESS);
            zzfqg zzfqgVar = this.zzb;
            if (zzfqgVar == null) {
                this.zzd.zze().zzb(zzfpwVar.zzm());
            } else {
                zzfqgVar.zza(zzfpwVar);
                zzfqgVar.zzh();
            }
        }
        zzdfg zzdfgVar = this.zzc;
        if (zzdfgVar != null) {
            String strZzb = this.zzd.zzd().zzb();
            if (TextUtils.isEmpty(strZzb)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(strZzb);
                Parcelable.Creator<com.google.android.gms.ads.internal.client.zzt> creator = com.google.android.gms.ads.internal.client.zzt.CREATOR;
                String strOptString = jSONObject.optString("type");
                String strOptString2 = jSONObject.optString("precision");
                String strOptString3 = jSONObject.optString("currency");
                long jOptLong = jSONObject.optLong(SDKConstants.PARAM_VALUE, 0L);
                int iHashCode = strOptString.hashCode();
                int i2 = 3;
                if (iHashCode != 66934) {
                    if (iHashCode != 66944) {
                        if (iHashCode == 1349395245 && strOptString.equals("ONE_PIXEL")) {
                            jOptLong /= 1000;
                            i = 3;
                        } else {
                            i = 0;
                        }
                    } else if (strOptString.equals("CPM")) {
                        i = 1;
                    }
                } else if (strOptString.equals("CPC")) {
                    i = 2;
                }
                int iHashCode2 = strOptString2.hashCode();
                if (iHashCode2 != -2131980260) {
                    if (iHashCode2 != 399232571) {
                        i2 = (iHashCode2 == 1271254246 && strOptString2.equals("PUBLISHER_PROVIDED")) ? 2 : 0;
                    } else if (!strOptString2.equals("PRECISE")) {
                    }
                } else if (strOptString2.equals("ESTIMATED")) {
                    i2 = 1;
                }
                zzdfgVar.zza(new com.google.android.gms.ads.internal.client.zzt(i, i2, strOptString3, jOptLong));
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "UrlPinger.pingUrl");
            }
        }
    }
}
