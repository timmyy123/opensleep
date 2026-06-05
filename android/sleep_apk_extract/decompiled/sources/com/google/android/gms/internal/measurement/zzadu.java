package com.google.android.gms.internal.measurement;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.measurement.zzadp;
import com.google.android.gms.internal.measurement.zzadu;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzadu<MessageType extends zzadu<MessageType, BuilderType>, BuilderType extends zzadp<MessageType, BuilderType>> extends zzacb<MessageType, BuilderType> {
    public static final /* synthetic */ int zzd = 0;
    private static final Map zze = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzaga zzc = zzaga.zza();

    private final int zzc(zzafp zzafpVar) {
        return zzafl.zza().zzb(getClass()).zze(this);
    }

    public static zzadu zzcA(zzadu zzaduVar, byte[] bArr, zzadf zzadfVar) throws zzaeh {
        zzadu zzaduVarZze = zze(zzaduVar, bArr, 0, bArr.length, zzadfVar);
        zzf(zzaduVarZze);
        return zzaduVarZze;
    }

    public static zzadu zzcB(zzadu zzaduVar, InputStream inputStream, zzadf zzadfVar) throws zzaeh {
        zzacv zzacvVarZzM = zzacv.zzM(inputStream, 4096);
        zzadu zzaduVarZzck = zzaduVar.zzck();
        try {
            zzafp zzafpVarZzb = zzafl.zza().zzb(zzaduVarZzck.getClass());
            zzafpVarZzb.zzg(zzaduVarZzck, zzacw.zza(zzacvVarZzM), zzadfVar);
            zzafpVarZzb.zzk(zzaduVarZzck);
            zzf(zzaduVarZzck);
            return zzaduVarZzck;
        } catch (zzaeh e) {
            if (e.zzb()) {
                throw new zzaeh(e);
            }
            throw e;
        } catch (zzafy e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaeh) {
                throw ((zzaeh) e3.getCause());
            }
            throw new zzaeh(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzaeh) {
                throw ((zzaeh) e4.getCause());
            }
            throw e4;
        }
    }

    public static zzadu zzcC(zzadu zzaduVar, zzacv zzacvVar, zzadf zzadfVar) throws zzaeh {
        zzadu zzaduVarZzck = zzaduVar.zzck();
        try {
            zzafp zzafpVarZzb = zzafl.zza().zzb(zzaduVarZzck.getClass());
            zzafpVarZzb.zzg(zzaduVarZzck, zzacw.zza(zzacvVar), zzadfVar);
            zzafpVarZzb.zzk(zzaduVarZzck);
            zzf(zzaduVarZzck);
            return zzaduVarZzck;
        } catch (zzaeh e) {
            if (e.zzb()) {
                throw new zzaeh(e);
            }
            throw e;
        } catch (zzafy e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaeh) {
                throw ((zzaeh) e3.getCause());
            }
            throw new zzaeh(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzaeh) {
                throw ((zzaeh) e4.getCause());
            }
            throw e4;
        }
    }

    public static zzadu zzcr(Class cls) {
        Map map = zze;
        zzadu zzaduVar = (zzadu) map.get(cls);
        if (zzaduVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzaduVar = (zzadu) map.get(cls);
            } catch (ClassNotFoundException e) {
                Types$$ExternalSyntheticBUOutline0.m("Class initialization cannot fail.", e);
                return null;
            }
        }
        if (zzaduVar != null) {
            return zzaduVar;
        }
        zzadu zzaduVar2 = (zzadu) ((zzadu) zzagg.zzb(cls)).zzg(6, null, null);
        if (zzaduVar2 != null) {
            map.put(cls, zzaduVar2);
            return zzaduVar2;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }

    public static void zzcs(Class cls, zzadu zzaduVar) {
        zzaduVar.zzci();
        zze.put(cls, zzaduVar);
    }

    public static Object zzct(zzafc zzafcVar, String str, Object[] objArr) {
        return new zzafn(zzafcVar, str, objArr);
    }

    public static Object zzcu(Method method, Object obj, Object... objArr) {
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

    public static zzaeb zzcv() {
        return zzadv.zzd();
    }

    public static zzaee zzcw() {
        return zzaeq.zze();
    }

    public static zzaee zzcx(zzaee zzaeeVar) {
        int size = zzaeeVar.size();
        return zzaeeVar.zzg(size + size);
    }

    public static zzaef zzcy() {
        return zzafm.zzd();
    }

    public static zzaef zzcz(zzaef zzaefVar) {
        int size = zzaefVar.size();
        return zzaefVar.zzg(size + size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean zzd(zzadu zzaduVar, boolean z) {
        byte bByteValue = ((Byte) zzaduVar.zzg(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzafl.zza().zzb(zzaduVar.getClass()).zzl(zzaduVar);
        if (z) {
            zzaduVar.zzg(2, true != zZzl ? null : zzaduVar, null);
        }
        return zZzl;
    }

    private static zzadu zze(zzadu zzaduVar, byte[] bArr, int i, int i2, zzadf zzadfVar) throws zzaeh {
        if (i2 == 0) {
            return zzaduVar;
        }
        zzadu zzaduVarZzck = zzaduVar.zzck();
        try {
            zzafp zzafpVarZzb = zzafl.zza().zzb(zzaduVarZzck.getClass());
            zzafpVarZzb.zzj(zzaduVarZzck, bArr, 0, i2, new zzacg(zzadfVar));
            zzafpVarZzb.zzk(zzaduVarZzck);
            return zzaduVarZzck;
        } catch (zzaeh e) {
            if (e.zzb()) {
                throw new zzaeh(e);
            }
            throw e;
        } catch (zzafy e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzaeh) {
                throw ((zzaeh) e3.getCause());
            }
            throw new zzaeh(e3);
        } catch (IndexOutOfBoundsException unused) {
            Gson$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
    }

    private static zzadu zzf(zzadu zzaduVar) throws zzaeh {
        if (zzaduVar == null || zzd(zzaduVar, true)) {
            return zzaduVar;
        }
        throw new zzafy(zzaduVar).zza();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzafl.zza().zzb(getClass()).zzb(this, (zzadu) obj);
    }

    public final int hashCode() {
        if (zzch()) {
            return zzcl();
        }
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int iZzcl = zzcl();
        this.zza = iZzcl;
        return iZzcl;
    }

    public final String toString() {
        return zzafe.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final void zzcH(zzada zzadaVar) {
        zzafl.zza().zzb(getClass()).zzf(this, zzadb.zza(zzadaVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final /* synthetic */ zzafb zzcI() {
        return (zzadp) zzg(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final boolean zzcJ() {
        return zzd(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zzafd
    public final /* synthetic */ zzafc zzcK() {
        return (zzadu) zzg(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzacb
    public final int zzcf(zzafp zzafpVar) {
        if (zzch()) {
            int iZze = zzafpVar.zze(this);
            if (iZze >= 0) {
                return iZze;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m256m(zzba$$ExternalSyntheticOutline0.m(iZze, 42), iZze, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZze2 = zzafpVar.zze(this);
        if (iZze2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iZze2;
            return iZze2;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m256m(zzba$$ExternalSyntheticOutline0.m(iZze2, 42), iZze2, "serialized size must be non-negative, was "));
        return 0;
    }

    public final boolean zzch() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void zzci() {
        this.zzb &= Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final zzafj zzcj() {
        return (zzafj) zzg(7, null, null);
    }

    public final zzadu zzck() {
        return (zzadu) zzg(4, null, null);
    }

    public final int zzcl() {
        return zzafl.zza().zzb(getClass()).zzc(this);
    }

    public final void zzcm() {
        zzafl.zza().zzb(getClass()).zzk(this);
        zzci();
    }

    public final zzadp zzcn() {
        return (zzadp) zzg(5, null, null);
    }

    public final zzadp zzco() {
        zzadp zzadpVar = (zzadp) zzg(5, null, null);
        zzadpVar.zzbe(this);
        return zzadpVar;
    }

    public final void zzcp(int i) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzafc
    public final int zzcq() {
        if (zzch()) {
            int iZzc = zzc(null);
            if (iZzc >= 0) {
                return iZzc;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m256m(zzba$$ExternalSyntheticOutline0.m(iZzc, 42), iZzc, "serialized size must be non-negative, was "));
            return 0;
        }
        int i = this.zzb & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iZzc2 = zzc(null);
        if (iZzc2 >= 0) {
            this.zzb = (this.zzb & Integer.MIN_VALUE) | iZzc2;
            return iZzc2;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m256m(zzba$$ExternalSyntheticOutline0.m(iZzc2, 42), iZzc2, "serialized size must be non-negative, was "));
        return 0;
    }

    public abstract Object zzg(int i, Object obj, Object obj2);
}
