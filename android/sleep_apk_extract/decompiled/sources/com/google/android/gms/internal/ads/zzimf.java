package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzimf implements Iterator, Closeable, zzauq {
    private static final zzaup zza = new zzime("eof ");
    protected zzaum zzb;
    protected zzimg zzc;
    zzaup zzd = null;
    long zze = 0;
    long zzf = 0;
    private final List zzg = new ArrayList();

    static {
        zzimm.zzb(zzimf.class);
    }

    public void close() {
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzaup zzaupVar = this.zzd;
        if (zzaupVar == zza) {
            return false;
        }
        if (zzaupVar != null) {
            return true;
        }
        try {
            this.zzd = next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzd = zza;
            return false;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        int i = 0;
        while (true) {
            List list = this.zzg;
            if (i >= list.size()) {
                sb.append("]");
                return sb.toString();
            }
            if (i > 0) {
                sb.append(";");
            }
            sb.append(((zzaup) list.get(i)).toString());
            i++;
        }
    }

    public final List zzc() {
        return (this.zzc == null || this.zzd == zza) ? this.zzg : new zziml(this.zzg, this);
    }

    public final void zzd(zzimg zzimgVar, long j, zzaum zzaumVar) {
        this.zzc = zzimgVar;
        this.zze = zzimgVar.zzc();
        zzimgVar.zzd(zzimgVar.zzc() + j);
        this.zzf = zzimgVar.zzc();
        this.zzb = zzaumVar;
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzaup next() {
        zzaup zzaupVarZzb;
        zzaup zzaupVar = this.zzd;
        if (zzaupVar != null && zzaupVar != zza) {
            this.zzd = null;
            return zzaupVar;
        }
        zzimg zzimgVar = this.zzc;
        if (zzimgVar == null || this.zze >= this.zzf) {
            this.zzd = zza;
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        try {
            synchronized (zzimgVar) {
                this.zzc.zzd(this.zze);
                zzaupVarZzb = this.zzb.zzb(this.zzc, this);
                this.zze = this.zzc.zzc();
            }
            return zzaupVarZzb;
        } catch (EOFException unused) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        } catch (IOException unused2) {
            Types$$ExternalSyntheticBUOutline0.m();
            return null;
        }
    }
}
