package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfvm {
    private static final Pattern zza = Pattern.compile("^[a-zA-Z0-9 ]+$");
    private final List zzb = new ArrayList();

    public final List zza() {
        return this.zzb;
    }

    public final void zzb(View view, zzfur zzfurVar, String str) {
        zzfvl zzfvlVar;
        if (view == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("FriendlyObstruction is null");
            return;
        }
        if (!zza.matcher("Ad overlay").matches()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("FriendlyObstruction has detailed reason that contains characters not in [a-z][A-Z][0-9] or space");
            return;
        }
        List list = this.zzb;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzfvlVar = null;
                break;
            } else {
                zzfvlVar = (zzfvl) it.next();
                if (zzfvlVar.zza().get() == view) {
                    break;
                }
            }
        }
        if (zzfvlVar == null) {
            list.add(new zzfvl(view, zzfurVar, "Ad overlay"));
        }
    }

    public final void zzc() {
        this.zzb.clear();
    }
}
