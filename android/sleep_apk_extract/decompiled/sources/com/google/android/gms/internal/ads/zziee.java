package com.google.android.gms.internal.ads;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.ads.zzidy;
import com.google.android.gms.internal.ads.zziee;
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
public abstract class zziee<MessageType extends zziee<MessageType, BuilderType>, BuilderType extends zzidy<MessageType, BuilderType>> extends zzicj<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static final Map<Class<?>, zziee<?, ?>> zzd = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzc = -1;
    protected zzigu zzt = zzigu.zza();

    public static Object zzbB(Method method, Object obj, Object... objArr) {
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

    public static zziem zzbC() {
        return zzief.zzd();
    }

    public static zziem zzbD(zziem zziemVar) {
        int size = zziemVar.size();
        return zziemVar.zzh(size + size);
    }

    public static zziep zzbE() {
        return zzifd.zzg();
    }

    public static zziep zzbF(zziep zziepVar) {
        int size = zziepVar.size();
        return zziepVar.zzh(size + size);
    }

    public static <E> zzieq<E> zzbM() {
        return zziga.zzd();
    }

    public static <E> zzieq<E> zzbN(zzieq<E> zzieqVar) {
        int size = zzieqVar.size();
        return zzieqVar.zzh(size + size);
    }

    public static <T extends zziee<T, ?>> T zzbO(T t, zzide zzideVar, zzido zzidoVar) throws zziet {
        T t2 = (T) t.zzbg();
        try {
            zzigh zzighVarZzb = zzifz.zza().zzb(t2.getClass());
            zzighVarZzb.zzg(t2, zzidf.zza(zzideVar), zzidoVar);
            zzighVarZzb.zzk(t2);
            return t2;
        } catch (zziet e) {
            if (e.zzb()) {
                throw new zziet(e);
            }
            throw e;
        } catch (zzigs e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zziet) {
                throw ((zziet) e3.getCause());
            }
            throw new zziet(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zziet) {
                throw ((zziet) e4.getCause());
            }
            throw e4;
        }
    }

    public static <T extends zziee<T, ?>> T zzbS(T t, zzida zzidaVar) throws zziet {
        zzido zzidoVar = zzido.zza;
        int i = zzicn.$r8$clinit;
        T t2 = (T) zzbT(t, zzidaVar, zzido.zza);
        zzi(t2);
        return t2;
    }

    public static <T extends zziee<T, ?>> T zzbT(T t, zzida zzidaVar, zzido zzidoVar) throws zziet {
        T t2 = (T) zzj(t, zzidaVar, zzidoVar);
        zzi(t2);
        return t2;
    }

    public static <T extends zziee<T, ?>> T zzbU(T t, byte[] bArr) throws zziet {
        int length = bArr.length;
        zzido zzidoVar = zzido.zza;
        int i = zzicn.$r8$clinit;
        T t2 = (T) zzh(t, bArr, 0, length, zzido.zza);
        zzi(t2);
        return t2;
    }

    public static <T extends zziee<T, ?>> T zzbV(T t, byte[] bArr, zzido zzidoVar) throws zziet {
        T t2 = (T) zzh(t, bArr, 0, bArr.length, zzidoVar);
        zzi(t2);
        return t2;
    }

    public static <T extends zziee<T, ?>> T zzbW(T t, InputStream inputStream) throws zziet {
        zzide zzideVarZzH = zzide.zzH(inputStream, 4096);
        zzido zzidoVar = zzido.zza;
        int i = zzicn.$r8$clinit;
        T t2 = (T) zzbO(t, zzideVarZzH, zzido.zza);
        zzi(t2);
        return t2;
    }

    public static <T extends zziee<T, ?>> T zzbX(T t, InputStream inputStream, zzido zzidoVar) throws zziet {
        T t2 = (T) zzbO(t, zzide.zzH(inputStream, 4096), zzidoVar);
        zzi(t2);
        return t2;
    }

    public static <T extends zziee> T zzbt(Class<T> cls) {
        Map<Class<?>, zziee<?, ?>> map = zzd;
        zziee<?, ?> zzieeVar = map.get(cls);
        if (zzieeVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzieeVar = map.get(cls);
            } catch (ClassNotFoundException e) {
                Types$$ExternalSyntheticBUOutline0.m("Class initialization cannot fail.", e);
                return null;
            }
        }
        if (zzieeVar != null) {
            return zzieeVar;
        }
        zziee<?, ?> zzieeVarZzbw = ((zziee) zziha.zzb(cls)).zzbw();
        if (zzieeVarZzbw != null) {
            map.put(cls, zzieeVarZzbw);
            return zzieeVarZzbw;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }

    public static <T extends zziee> void zzbu(Class<T> cls, T t) {
        t.zzaY();
        zzd.put(cls, t);
    }

    public static Object zzbv(zzifp zzifpVar, String str, Object[] objArr) {
        return new zzigb(zzifpVar, str, objArr);
    }

    private int zzd(zzigh<?> zzighVar) {
        if (zzighVar != null) {
            return zzighVar.zze(this);
        }
        return zzifz.zza().zzb(getClass()).zze(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zziee<T, ?>> boolean zzg(T t, boolean z) {
        byte bByteValue = ((Byte) t.zzdc(zzied.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzifz.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.zzdc(zzied.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t, null);
        }
        return zZzl;
    }

    private static <T extends zziee<T, ?>> T zzh(T t, byte[] bArr, int i, int i2, zzido zzidoVar) throws zziet {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.zzbg();
        try {
            zzigh zzighVarZzb = zzifz.zza().zzb(t2.getClass());
            zzighVarZzb.zzj(t2, bArr, i, i + i2, new zzico(zzidoVar));
            zzighVarZzb.zzk(t2);
            return t2;
        } catch (zziet e) {
            if (e.zzb()) {
                throw new zziet(e);
            }
            throw e;
        } catch (zzigs e2) {
            throw e2.zza();
        } catch (IOException e3) {
            if (e3.getCause() instanceof zziet) {
                throw ((zziet) e3.getCause());
            }
            throw new zziet(e3);
        } catch (IndexOutOfBoundsException unused) {
            zzbuy$$ExternalSyntheticBUOutline0.m$1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
    }

    private static <T extends zziee<T, ?>> T zzi(T t) throws zziet {
        if (t == null || t.zzbi()) {
            return t;
        }
        throw t.zzaU().zza();
    }

    private static <T extends zziee<T, ?>> T zzj(T t, zzida zzidaVar, zzido zzidoVar) {
        zzide zzideVarZzm = zzidaVar.zzm();
        T t2 = (T) zzbO(t, zzideVarZzm, zzidoVar);
        zzideVarZzm.zzb(0);
        return t2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzifz.zza().zzb(getClass()).zzb(this, (zziee) obj);
    }

    public int hashCode() {
        if (zzaX()) {
            return zzbh();
        }
        if (zzbc()) {
            zzba(zzbh());
        }
        return zzaZ();
    }

    public String toString() {
        return zzifr.zza(this, super.toString());
    }

    public final int zzaQ() {
        return this.zzc & Integer.MAX_VALUE;
    }

    public void zzaR(int i) {
        if (i >= 0) {
            this.zzc = i | (this.zzc & zza);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(i, "serialized size must be non-negative, was ", new StringBuilder(String.valueOf(i).length() + 42)));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzicj
    public int zzaT(zzigh zzighVar) {
        if (zzaX()) {
            int iZzd = zzd(zzighVar);
            if (iZzd >= 0) {
                return iZzd;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(iZzd, "serialized size must be non-negative, was ", new StringBuilder(String.valueOf(iZzd).length() + 42)));
            return 0;
        }
        if (zzaQ() != Integer.MAX_VALUE) {
            return zzaQ();
        }
        int iZzd2 = zzd(zzighVar);
        zzaR(iZzd2);
        return iZzd2;
    }

    public final boolean zzaX() {
        return (this.zzc & zza) != 0;
    }

    public final void zzaY() {
        this.zzc &= Integer.MAX_VALUE;
    }

    public final int zzaZ() {
        return this.zzq;
    }

    public final void zzba(int i) {
        this.zzq = i;
    }

    public final void zzbb() {
        this.zzq = 0;
    }

    public final boolean zzbc() {
        return zzaZ() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public final zzifx<MessageType> zzbd() {
        return (zzifx) zzdc(zzied.GET_PARSER, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    /* JADX INFO: renamed from: zzbe, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbw() {
        return (MessageType) zzdc(zzied.GET_DEFAULT_INSTANCE, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    /* JADX INFO: renamed from: zzbf, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcY() {
        return (BuilderType) zzdc(zzied.NEW_BUILDER, null, null);
    }

    public final MessageType zzbg() {
        return (MessageType) zzdc(zzied.NEW_MUTABLE_INSTANCE, null, null);
    }

    public final int zzbh() {
        return zzifz.zza().zzb(getClass()).zzc(this);
    }

    @Override // com.google.android.gms.internal.ads.zzifq
    public final boolean zzbi() {
        return zzg(this, true);
    }

    public final void zzbm() {
        zzifz.zza().zzb(getClass()).zzk(this);
        zzaY();
    }

    public final <MessageType2 extends zziee<MessageType2, BuilderType2>, BuilderType2 extends zzidy<MessageType2, BuilderType2>> BuilderType2 zzbn() {
        return (BuilderType2) zzdc(zzied.NEW_BUILDER, null, null);
    }

    public final BuilderType zzbp() {
        BuilderType buildertype = (BuilderType) zzdc(zzied.NEW_BUILDER, null, null);
        buildertype.zzbo(this);
        return buildertype;
    }

    public final void zzbq() {
        zzaR(Integer.MAX_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public int zzbr() {
        return zzaT(null);
    }

    public final Object zzbs() {
        return zzdc(zzied.BUILD_MESSAGE_INFO, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifp
    public void zzcX(zzidj zzidjVar) {
        zzifz.zza().zzb(getClass()).zzf(this, zzidk.zza(zzidjVar));
    }

    public abstract Object zzdc(zzied zziedVar, Object obj, Object obj2);
}
