package com.google.android.gms.internal.clearcut;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzdu<T> implements zzef<T> {
    private final zzdo zzmn;
    private final boolean zzmo;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;

    private zzdu(zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdo zzdoVar) {
        this.zzmx = zzexVar;
        this.zzmo = zzbuVar.zze(zzdoVar);
        this.zzmy = zzbuVar;
        this.zzmn = zzdoVar;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final boolean equals(T t, T t2) {
        if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
            return false;
        }
        if (this.zzmo) {
            return this.zzmy.zza(t).equals(this.zzmy.zza(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final int hashCode(T t) {
        int iHashCode = this.zzmx.zzq(t).hashCode();
        return this.zzmo ? (iHashCode * 53) + this.zzmy.zza(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final T newInstance() {
        return (T) this.zzmn.zzbd().zzbi();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0064 A[EDGE_INSN: B:51:0x0064->B:28:0x0064 BREAK  A[LOOP:1: B:14:0x0034->B:54:0x0034], SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzayVar) throws zzco {
        zzcg zzcgVar = (zzcg) t;
        zzey zzeyVarZzeb = zzcgVar.zzjp;
        if (zzeyVarZzeb == zzey.zzea()) {
            zzeyVarZzeb = zzey.zzeb();
            zzcgVar.zzjp = zzeyVarZzeb;
        }
        zzey zzeyVar = zzeyVarZzeb;
        while (i < i2) {
            int iZza = zzax.zza(bArr, i, zzayVar);
            int i3 = zzayVar.zzfd;
            if (i3 != 11) {
                byte[] bArr2 = bArr;
                int i4 = i2;
                zzay zzayVar2 = zzayVar;
                i = (i3 & 7) == 2 ? zzax.zza(i3, bArr2, iZza, i4, zzeyVar, zzayVar2) : zzax.zza(i3, bArr2, iZza, i4, zzayVar2);
            } else {
                byte[] bArr3 = bArr;
                int i5 = i2;
                zzay zzayVar3 = zzayVar;
                int i6 = 0;
                zzbb zzbbVar = null;
                while (true) {
                    if (iZza >= i5) {
                        i = iZza;
                        break;
                    }
                    i = zzax.zza(bArr3, iZza, zzayVar3);
                    int i7 = zzayVar3.zzfd;
                    int i8 = i7 >>> 3;
                    int i9 = i7 & 7;
                    if (i8 != 2) {
                        if (i8 != 3 || i9 != 2) {
                            if (i7 != 12) {
                                break;
                            } else {
                                iZza = zzax.zza(i7, bArr3, i, i5, zzayVar3);
                            }
                        } else {
                            iZza = zzax.zze(bArr3, i, zzayVar3);
                            zzbbVar = (zzbb) zzayVar3.zzff;
                        }
                    } else if (i9 == 0) {
                        iZza = zzax.zza(bArr3, i, zzayVar3);
                        i6 = zzayVar3.zzfd;
                    } else if (i7 != 12) {
                    }
                }
                if (zzbbVar != null) {
                    zzeyVar.zzb((i6 << 3) | 2, zzbbVar);
                }
                bArr = bArr3;
                i2 = i5;
                zzayVar = zzayVar3;
            }
        }
        if (i != i2) {
            throw zzco.zzbo();
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t, T t2) {
        zzeh.zza(this.zzmx, t, t2);
        if (this.zzmo) {
            zzeh.zza(this.zzmy, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final int zzm(T t) {
        zzex<?, ?> zzexVar = this.zzmx;
        int iZzr = zzexVar.zzr(zzexVar.zzq(t));
        return this.zzmo ? iZzr + this.zzmy.zza(t).zzat() : iZzr;
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final boolean zzo(T t) {
        return this.zzmy.zza(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zza(T t, zzfr zzfrVar) {
        Iterator<Map.Entry<?, Object>> it = this.zzmy.zza(t).iterator();
        if (it.hasNext()) {
            throw Fragment$$ExternalSyntheticOutline1.m(it.next());
        }
        zzex<?, ?> zzexVar = this.zzmx;
        zzexVar.zzc(zzexVar.zzq(t), zzfrVar);
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t) {
        this.zzmx.zzc(t);
        this.zzmy.zzc(t);
    }

    public static <T> zzdu<T> zza(zzex<?, ?> zzexVar, zzbu<?> zzbuVar, zzdo zzdoVar) {
        return new zzdu<>(zzexVar, zzbuVar, zzdoVar);
    }
}
