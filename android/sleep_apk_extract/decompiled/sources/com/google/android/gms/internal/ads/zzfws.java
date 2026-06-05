package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfws implements zzfvt {
    private static final zzfws zza = new zzfws();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzk = new zzfwo();
    private static final Runnable zzl = new zzfwp();
    private int zze;
    private long zzj;
    private final List zzd = new ArrayList();
    private final List zzf = new ArrayList();
    private final zzfwl zzh = new zzfwl();
    private final zzfvv zzg = new zzfvv();
    private final zzfwm zzi = new zzfwm(new zzfwv());

    public static zzfws zzb() {
        return zza;
    }

    private final void zzk(View view, zzfvu zzfvuVar, JSONObject jSONObject, int i, boolean z) {
        zzfvuVar.zzb(view, jSONObject, this, i == 1, z);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zzl);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvt
    public final void zza(View view, zzfvu zzfvuVar, JSONObject jSONObject, boolean z) {
        zzfwl zzfwlVar;
        int iZzl;
        boolean z2;
        zzfws zzfwsVar;
        View view2;
        zzfvu zzfvuVar2;
        boolean z3;
        if (zzfwj.zza(view) != null || (iZzl = (zzfwlVar = this.zzh).zzl(view)) == 3) {
            return;
        }
        JSONObject jSONObjectZza = zzfvuVar.zza(view);
        zzfwe.zze(jSONObject, jSONObjectZza);
        String strZzg = zzfwlVar.zzg(view);
        if (strZzg != null) {
            zzfwe.zzd(jSONObjectZza, strZzg);
            try {
                jSONObjectZza.put("hasWindowFocus", Boolean.valueOf(this.zzh.zzj(view)));
            } catch (JSONException e) {
                zzfwf.zza("Error with setting has window focus", e);
            }
            boolean zZzk = this.zzh.zzk(strZzg);
            Boolean boolValueOf = Boolean.valueOf(zZzk);
            if (zZzk) {
                try {
                    jSONObjectZza.put("isPipActive", boolValueOf);
                } catch (JSONException e2) {
                    zzfwf.zza("Error with setting is picture-in-picture active", e2);
                }
            }
            this.zzh.zzf();
            zzfwsVar = this;
        } else {
            zzfwk zzfwkVarZzi = zzfwlVar.zzi(view);
            if (zzfwkVarZzi != null) {
                zzfvl zzfvlVarZzb = zzfwkVarZzi.zzb();
                JSONArray jSONArray = new JSONArray();
                ArrayList arrayListZzc = zzfwkVarZzi.zzc();
                int size = arrayListZzc.size();
                for (int i = 0; i < size; i++) {
                    jSONArray.put((String) arrayListZzc.get(i));
                }
                try {
                    jSONObjectZza.put("isFriendlyObstructionFor", jSONArray);
                    jSONObjectZza.put("friendlyObstructionClass", zzfvlVarZzb.zzb());
                    jSONObjectZza.put("friendlyObstructionPurpose", zzfvlVarZzb.zzc());
                    jSONObjectZza.put("friendlyObstructionReason", zzfvlVarZzb.zzd());
                } catch (JSONException e3) {
                    zzfwf.zza("Error with setting friendly obstruction", e3);
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || z2) {
                zzfwsVar = this;
                view2 = view;
                zzfvuVar2 = zzfvuVar;
                z3 = true;
            } else {
                view2 = view;
                zzfvuVar2 = zzfvuVar;
                z3 = false;
                zzfwsVar = this;
            }
            zzfwsVar.zzk(view2, zzfvuVar2, jSONObjectZza, iZzl, z3);
        }
        zzfwsVar.zze++;
    }

    public final void zzc() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzk);
            zzc.postDelayed(zzl, 200L);
        }
    }

    public final void zzd() {
        zzl();
        this.zzd.clear();
        zzb.post(new zzfwn(this));
    }

    public final void zze() {
        zzl();
    }

    public final /* synthetic */ void zzf() {
        zzfws zzfwsVar;
        this.zze = 0;
        this.zzf.clear();
        for (zzfuo zzfuoVar : zzfvi.zza().zzf()) {
        }
        this.zzj = System.nanoTime();
        zzfwl zzfwlVar = this.zzh;
        zzfwlVar.zzd();
        zzfvv zzfvvVar = this.zzg;
        long jNanoTime = System.nanoTime();
        zzfvu zzfvuVarZza = zzfvvVar.zza();
        if (zzfwlVar.zzb().size() > 0) {
            for (String str : zzfwlVar.zzb()) {
                JSONObject jSONObjectZza = zzfvuVarZza.zza(null);
                View viewZzh = zzfwlVar.zzh(str);
                zzfvu zzfvuVarZzb = zzfvvVar.zzb();
                String strZzc = zzfwlVar.zzc(str);
                if (strZzc != null) {
                    JSONObject jSONObjectZza2 = zzfvuVarZzb.zza(viewZzh);
                    zzfwe.zzd(jSONObjectZza2, str);
                    try {
                        jSONObjectZza2.put("notVisibleReason", strZzc);
                    } catch (JSONException e) {
                        zzfwf.zza("Error with setting not visible reason", e);
                    }
                    zzfwe.zze(jSONObjectZza, jSONObjectZza2);
                }
                zzfwe.zzf(jSONObjectZza);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                this.zzi.zzb(jSONObjectZza, hashSet, jNanoTime);
            }
        }
        zzfwl zzfwlVar2 = this.zzh;
        if (zzfwlVar2.zza().size() > 0) {
            JSONObject jSONObjectZza3 = zzfvuVarZza.zza(null);
            zzfwsVar = this;
            zzfwsVar.zzk(null, zzfvuVarZza, jSONObjectZza3, 1, false);
            zzfwe.zzf(jSONObjectZza3);
            zzfwsVar.zzi.zza(jSONObjectZza3, zzfwlVar2.zza(), jNanoTime);
        } else {
            zzfwsVar = this;
            zzfwsVar.zzi.zzc();
        }
        zzfwlVar2.zze();
        System.nanoTime();
        List list = zzfwsVar.zzd;
        if (list.size() > 0) {
            Iterator it = list.iterator();
            if (it.hasNext()) {
                throw FileInsert$$ExternalSyntheticOutline0.m(it);
            }
        }
        zzfvs.zza().zzc();
    }

    public final /* synthetic */ zzfwm zzh() {
        return this.zzi;
    }
}
