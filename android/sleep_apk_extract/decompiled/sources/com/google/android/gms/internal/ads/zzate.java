package com.google.android.gms.internal.ads;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzate implements Comparable {
    private final zzatp zza;
    private final int zzb;
    private final String zzc;
    private final int zzd;
    private final Object zze;
    private final zzati zzf;
    private Integer zzg;
    private zzath zzh;
    private boolean zzi;
    private zzasn zzj;
    private zzatd zzk;
    private final zzass zzl;

    public zzate(int i, String str, zzati zzatiVar) {
        Uri uri;
        String host;
        this.zza = zzatp.zza ? new zzatp() : null;
        this.zze = new Object();
        int iHashCode = 0;
        this.zzi = false;
        this.zzj = null;
        this.zzb = i;
        this.zzc = str;
        this.zzf = zzatiVar;
        this.zzl = new zzass();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.zzd = iHashCode;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzg.intValue() - ((zzate) obj).zzg.intValue();
    }

    public final String toString() {
        String strValueOf = String.valueOf(Integer.toHexString(this.zzd));
        zzl();
        Integer num = this.zzg;
        String str = this.zzc;
        int length = String.valueOf(str).length();
        int length2 = String.valueOf(num).length();
        String strConcat = "0x".concat(strValueOf);
        StringBuilder sb = new StringBuilder(strConcat.length() + length + 5 + 8 + length2);
        FileInsert$$ExternalSyntheticOutline0.m(sb, "[ ] ", str, " ", strConcat);
        sb.append(" NORMAL ");
        sb.append(num);
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final void zzc(String str) {
        if (zzatp.zza) {
            this.zza.zza(str, Thread.currentThread().getId());
        }
    }

    public final void zzd(String str) {
        zzath zzathVar = this.zzh;
        if (zzathVar != null) {
            zzathVar.zzc(this);
        }
        if (zzatp.zza) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new zzatc(this, str, id));
                return;
            }
            zzatp zzatpVar = this.zza;
            zzatpVar.zza(str, id);
            zzatpVar.zzb(toString());
        }
    }

    public final void zze(int i) {
        zzath zzathVar = this.zzh;
        if (zzathVar != null) {
            zzathVar.zzd(this, i);
        }
    }

    public final zzate zzf(zzath zzathVar) {
        this.zzh = zzathVar;
        return this;
    }

    public final zzate zzg(int i) {
        this.zzg = Integer.valueOf(i);
        return this;
    }

    public final String zzh() {
        return this.zzc;
    }

    public final String zzi() {
        int i = this.zzb;
        String str = this.zzc;
        if (i == 0) {
            return str;
        }
        String string = Integer.toString(1);
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(string).length() + 1 + String.valueOf(str).length()), string, "-", str);
    }

    public final zzate zzj(zzasn zzasnVar) {
        this.zzj = zzasnVar;
        return this;
    }

    public final zzasn zzk() {
        return this.zzj;
    }

    public final boolean zzl() {
        synchronized (this.zze) {
        }
        return false;
    }

    public Map zzm() {
        return Collections.EMPTY_MAP;
    }

    public byte[] zzn() {
        return null;
    }

    public final int zzo() {
        return this.zzl.zza();
    }

    public final void zzp() {
        synchronized (this.zze) {
            this.zzi = true;
        }
    }

    public final boolean zzq() {
        boolean z;
        synchronized (this.zze) {
            z = this.zzi;
        }
        return z;
    }

    public abstract zzatk zzr(zzata zzataVar);

    public abstract void zzs(Object obj);

    public final void zzt(zzatn zzatnVar) {
        zzati zzatiVar;
        synchronized (this.zze) {
            zzatiVar = this.zzf;
        }
        zzatiVar.zza(zzatnVar);
    }

    public final void zzu(zzatd zzatdVar) {
        synchronized (this.zze) {
            this.zzk = zzatdVar;
        }
    }

    public final void zzv(zzatk zzatkVar) {
        zzatd zzatdVar;
        synchronized (this.zze) {
            zzatdVar = this.zzk;
        }
        if (zzatdVar != null) {
            zzatdVar.zza(this, zzatkVar);
        }
    }

    public final void zzw() {
        zzatd zzatdVar;
        synchronized (this.zze) {
            zzatdVar = this.zzk;
        }
        if (zzatdVar != null) {
            zzatdVar.zzb(this);
        }
    }

    public final /* synthetic */ zzatp zzx() {
        return this.zza;
    }

    public final zzass zzy() {
        return this.zzl;
    }
}
