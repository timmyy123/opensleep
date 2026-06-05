package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.impl.R$string;
import java.util.Map;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes3.dex */
public final class zzbxx extends zzbyg {
    private final Map zza;
    private final Context zzb;
    private final String zzc;
    private final long zzd;
    private final long zze;
    private final String zzf;
    private final String zzg;

    public zzbxx(zzcku zzckuVar, Map map) {
        super(zzckuVar, "createCalendarEvent");
        this.zza = map;
        this.zzb = zzckuVar.zzj();
        this.zzc = zzd("description");
        this.zzf = zzd("summary");
        this.zzd = zze("start_ticks");
        this.zze = zze("end_ticks");
        this.zzg = zzd("location");
    }

    private final String zzd(String str) {
        Map map = this.zza;
        return TextUtils.isEmpty((CharSequence) map.get(str)) ? "" : (String) map.get(str);
    }

    private final long zze(String str) {
        String str2 = (String) this.zza.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public final void zza() {
        Context context = this.zzb;
        if (context == null) {
            zzg("Activity context is not available.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        if (!new zzbhx(context).zzb()) {
            zzg("This feature is not available on the device.");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzc();
        AlertDialog.Builder builderZzN = com.google.android.gms.ads.internal.util.zzs.zzN(context);
        Resources resourcesZzf = com.google.android.gms.ads.internal.zzt.zzh().zzf();
        builderZzN.setTitle(resourcesZzf != null ? resourcesZzf.getString(R$string.s5) : "Create calendar event");
        builderZzN.setMessage(resourcesZzf != null ? resourcesZzf.getString(R$string.s6) : "Allow Ad to create a calendar event?");
        builderZzN.setPositiveButton(resourcesZzf != null ? resourcesZzf.getString(R$string.s3) : "Accept", new zzbxv(this));
        builderZzN.setNegativeButton(resourcesZzf != null ? resourcesZzf.getString(R$string.s4) : "Decline", new zzbxw(this));
        builderZzN.create().show();
    }

    public final Intent zzb() {
        Intent data2 = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data2.putExtra("title", this.zzc);
        data2.putExtra("eventLocation", this.zzg);
        data2.putExtra("description", this.zzf);
        long j = this.zzd;
        if (j > -1) {
            data2.putExtra("beginTime", j);
        }
        long j2 = this.zze;
        if (j2 > -1) {
            data2.putExtra(SDKConstants.PARAM_END_TIME, j2);
        }
        data2.setFlags(ClientDefaults.MAX_MSG_SIZE);
        return data2;
    }

    public final /* synthetic */ Context zzc() {
        return this.zzb;
    }
}
