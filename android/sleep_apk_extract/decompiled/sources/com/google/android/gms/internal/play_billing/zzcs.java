package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public final class zzcs {
    private final List zza = new ArrayList();

    public final zzcs zza(zzdh zzdhVar) {
        if (zzdhVar.zzd()) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(zzbf.zza("range must not be empty, but was %s", zzdhVar));
            return null;
        }
        this.zza.add(zzdhVar);
        return this;
    }

    public final zzcs zzb(zzcs zzcsVar) {
        Iterator it = zzcsVar.zza.iterator();
        while (it.hasNext()) {
            zza((zzdh) it.next());
        }
        return this;
    }

    public final zzct zzc() {
        zzck zzckVar = new zzck(this.zza.size());
        Collections.sort(this.zza, zzdg.zza);
        Iterator it = this.zza.iterator();
        zzcy zzcyVar = it instanceof zzcy ? (zzcy) it : new zzcy(it);
        while (zzcyVar.hasNext()) {
            zzdh zzdhVarZzc = (zzdh) zzcyVar.next();
            while (zzcyVar.hasNext()) {
                zzdh zzdhVar = (zzdh) zzcyVar.zza();
                if (zzdhVarZzc.zza.compareTo(zzdhVar.zzb) > 0 || zzdhVar.zza.compareTo(zzdhVarZzc.zzb) > 0) {
                    break;
                }
                zzbe.zzd(zzdhVarZzc.zzb(zzdhVar).zzd(), "Overlapping ranges not permitted but found %s overlapping %s", zzdhVarZzc, zzdhVar);
                zzdhVarZzc = zzdhVarZzc.zzc((zzdh) zzcyVar.next());
            }
            zzckVar.zzd(zzdhVarZzc);
        }
        zzco zzcoVarZze = zzckVar.zze();
        if (zzcoVarZze.isEmpty()) {
            return zzct.zzb();
        }
        if (zzcoVarZze.size() == 1) {
            zzdx zzdxVarListIterator = zzcoVarZze.listIterator(0);
            Object next = zzdxVarListIterator.next();
            if (zzdxVarListIterator.hasNext()) {
                StringBuilder sb = new StringBuilder("expected one element but was: <");
                sb.append(next);
                for (int i = 0; i < 4 && zzdxVarListIterator.hasNext(); i++) {
                    sb.append(", ");
                    sb.append(zzdxVarListIterator.next());
                }
                if (zzdxVarListIterator.hasNext()) {
                    sb.append(", ...");
                }
                sb.append('>');
                throw new IllegalArgumentException(sb.toString());
            }
            if (((zzdh) next).equals(zzdh.zza())) {
                return zzct.zza();
            }
        }
        return new zzct(zzcoVarZze);
    }
}
