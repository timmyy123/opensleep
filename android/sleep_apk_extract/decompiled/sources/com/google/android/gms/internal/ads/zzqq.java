package com.google.android.gms.internal.ads;

import android.media.AudioDescriptor;
import android.os.Build;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: loaded from: classes3.dex */
abstract class zzqq {
    public static zzgwm zza(List list) {
        if (Build.VERSION.SDK_INT < 31 || list == null) {
            return zzgwm.zzi();
        }
        TreeSet treeSet = new TreeSet(Comparator.comparing(zzqp.zza).reversed());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AudioDescriptor audioDescriptorM364m = zzbuy$$ExternalSyntheticBUOutline0.m364m(it.next());
            if (audioDescriptorM364m.getStandard() == 1) {
                byte[] descriptor = audioDescriptorM364m.getDescriptor();
                int length = descriptor.length;
                if (length != 3) {
                    zzba$$ExternalSyntheticOutline0.m258m(new StringBuilder(String.valueOf(length).length() + 20), "Invalid SAD length: ", length, "AudioDescriptorUtil");
                } else {
                    byte b = descriptor[0];
                    int i = (b & 7) + 1;
                    if (((b >> 3) & 15) == 1) {
                        treeSet.add(Integer.valueOf(zzfl.zzE(i)));
                    }
                }
            }
        }
        return zzgwm.zzq(treeSet);
    }
}
