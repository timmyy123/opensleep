package com.google.android.gms.internal.aicore;

import com.google.android.gms.internal.ads.zzbuy$$ExternalSyntheticBUOutline0;
import com.google.android.gms.internal.aicore.zzet;
import com.google.android.gms.internal.aicore.zzex;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzex<MessageType extends zzex<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdo<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzgw zzc = zzgw.zza();

    private static final boolean zza(zzex zzexVar, boolean z) {
        byte bByteValue = ((Byte) zzexVar.zzd(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzi = zzgh.zza().zzb(zzexVar.getClass()).zzi(zzexVar);
        if (z) {
            zzexVar.zzd(2, true != zZzi ? null : zzexVar, null);
        }
        return zZzi;
    }

    private static zzex zzc(zzex zzexVar, byte[] bArr, int i, int i2, zzek zzekVar) throws zzfi {
        if (i2 == 0) {
            return zzexVar;
        }
        zzex zzexVarZzk = zzexVar.zzk();
        try {
            zzgk zzgkVarZzb = zzgh.zza().zzb(zzexVarZzk.getClass());
            zzgkVarZzb.zzg(zzexVarZzk, bArr, 0, i2, new zzdr(zzekVar));
            zzgkVarZzb.zzh(zzexVarZzk);
            return zzexVarZzk;
        } catch (zzfi e) {
            throw e;
        } catch (zzgu e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzfi) {
                throw ((zzfi) e3.getCause());
            }
            throw new zzfi(e3);
        } catch (IndexOutOfBoundsException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m$2("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
    }

    public static zzex zzo(Class cls) {
        Map map = zzd;
        zzex zzexVar = (zzex) map.get(cls);
        if (zzexVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzexVar = (zzex) map.get(cls);
            } catch (ClassNotFoundException e) {
                Types$$ExternalSyntheticBUOutline0.m("Class initialization cannot fail.", e);
                return null;
            }
        }
        if (zzexVar != null) {
            return zzexVar;
        }
        zzex zzexVar2 = (zzex) ((zzex) zzhc.zzc(cls)).zzd(6, null, null);
        if (zzexVar2 != null) {
            map.put(cls, zzexVar2);
            return zzexVar2;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }

    public static void zzp(Class cls, zzex zzexVar) {
        zzexVar.zzj();
        zzd.put(cls, zzexVar);
    }

    public static Object zzq(zzga zzgaVar, String str, Object[] objArr) {
        return new zzgj(zzgaVar, str, objArr);
    }

    public static Object zzr(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            Utf8$$ExternalSyntheticBUOutline0.m("Couldn't use Java reflection to implement protocol message reflection.", (Throwable) e);
            return null;
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            Utf8$$ExternalSyntheticBUOutline0.m("Unexpected exception thrown by generated accessor method.", cause);
            return null;
        }
    }

    public static zzfg zzs() {
        return zzgi.zzd();
    }

    public static zzex zzt(zzex zzexVar, byte[] bArr, zzek zzekVar) throws zzfi {
        zzex zzexVarZzc = zzc(zzexVar, bArr, 0, bArr.length, zzekVar);
        if (zzexVarZzc == null || zza(zzexVarZzc, true)) {
            return zzexVarZzc;
        }
        throw new zzgu(zzexVarZzc).zza();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgh.zza().zzb(getClass()).zzb(this, (zzex) obj);
    }

    public final int hashCode() {
        if (zzi()) {
            return zzl();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzl = zzl();
        this.zza = iZzl;
        return iZzl;
    }

    public final String toString() {
        return zzgc.zza(this, super.toString());
    }

    public abstract Object zzd(int i, Object obj, Object obj2);

    public final boolean zzi() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void zzj() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final zzex zzk() {
        return (zzex) zzd(4, null, null);
    }

    public final int zzl() {
        return zzgh.zza().zzb(getClass()).zzc(this);
    }

    public final void zzm() {
        zzgh.zza().zzb(getClass()).zzh(this);
        zzj();
    }

    public final void zzn(int i) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.aicore.zzga
    public final /* synthetic */ zzfz zzu() {
        return (zzet) zzd(5, null, null);
    }

    @Override // com.google.android.gms.internal.aicore.zzgb
    public final /* synthetic */ zzga zzx() {
        return (zzex) zzd(6, null, null);
    }
}
