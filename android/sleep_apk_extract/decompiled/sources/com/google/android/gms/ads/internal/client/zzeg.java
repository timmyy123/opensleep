package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class zzeg {
    private String zzg;
    private String zzi;
    private String zzj;
    private boolean zzl;
    private String zzm;
    private long zzo;
    private final HashSet zza = new HashSet();
    private final Bundle zzb = new Bundle();
    private final HashMap zzc = new HashMap();
    private final HashSet zzd = new HashSet();
    private final Bundle zze = new Bundle();
    private final HashSet zzf = new HashSet();
    private final List zzh = new ArrayList();
    private int zzk = -1;
    private int zzn = 60000;

    public final /* synthetic */ String zzA() {
        return this.zzj;
    }

    public final /* synthetic */ int zzB() {
        return this.zzk;
    }

    public final /* synthetic */ boolean zzC() {
        return this.zzl;
    }

    public final /* synthetic */ String zzD() {
        return this.zzm;
    }

    public final /* synthetic */ int zzE() {
        return this.zzn;
    }

    public final /* synthetic */ long zzF() {
        return this.zzo;
    }

    public final void zza(String str) {
        this.zza.add(str);
    }

    public final void zzc(Class cls, Bundle bundle) {
        this.zzb.putBundle(cls.getName(), bundle);
    }

    public final void zze(String str) {
        this.zzd.add(str);
    }

    public final void zzf(String str) {
        this.zzd.remove("B3EEABB8EE11C2BE770B684D95219ECB");
    }

    public final void zzg(String str) {
        this.zzg = str;
    }

    public final void zzh(List list) {
        List list2 = this.zzh;
        list2.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (TextUtils.isEmpty(str)) {
                com.google.android.gms.ads.internal.util.client.zzo.zzi("neighboring content URL should not be null or empty");
            } else {
                list2.add(str);
            }
        }
    }

    public final void zzi(String str) {
        this.zzi = str;
    }

    public final void zzj(String str) {
        this.zzj = str;
    }

    @Deprecated
    public final void zzk(boolean z) {
        this.zzk = z ? 1 : 0;
    }

    public final void zzl(String str, String str2) {
        this.zze.putString(str, str2);
    }

    public final void zzm(String str) {
        this.zzf.add(str);
    }

    @Deprecated
    public final void zzn(boolean z) {
        this.zzl = z;
    }

    public final /* synthetic */ HashSet zzr() {
        return this.zza;
    }

    public final /* synthetic */ Bundle zzs() {
        return this.zzb;
    }

    public final /* synthetic */ HashMap zzt() {
        return this.zzc;
    }

    public final /* synthetic */ HashSet zzu() {
        return this.zzd;
    }

    public final /* synthetic */ Bundle zzv() {
        return this.zze;
    }

    public final /* synthetic */ HashSet zzw() {
        return this.zzf;
    }

    public final /* synthetic */ String zzx() {
        return this.zzg;
    }

    public final /* synthetic */ List zzy() {
        return this.zzh;
    }

    public final /* synthetic */ String zzz() {
        return this.zzi;
    }
}
