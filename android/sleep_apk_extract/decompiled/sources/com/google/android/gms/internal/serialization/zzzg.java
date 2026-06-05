package com.google.android.gms.internal.serialization;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.google.android.gms.internal.serialization.zzyy;
import com.google.android.gms.internal.serialization.zzzg;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzzg<MessageType extends zzzg<MessageType, BuilderType>, BuilderType extends zzyy<MessageType, BuilderType>> extends zzvy<MessageType, BuilderType> {
    private static final int MEMOIZED_SERIALIZED_SIZE_MASK = Integer.MAX_VALUE;
    private static final int MUTABLE_FLAG_MASK = Integer.MIN_VALUE;
    static final int UNINITIALIZED_HASH_CODE = 0;
    static final int UNINITIALIZED_SERIALIZED_SIZE = Integer.MAX_VALUE;
    private static Map<Class<?>, zzzg<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    private int memoizedSerializedSize = -1;
    protected zzabs unknownFields = zzabs.zza();

    private static <T extends zzzg<T, ?>> T checkMessageInitialized(T t) throws zzzv {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw t.newUninitializedMessageException().zza();
    }

    private int computeSerializedSize(zzabe<?> zzabeVar) {
        if (zzabeVar != null) {
            return zzabeVar.zze(this);
        }
        return zzaba.zza().zzb(getClass()).zze(this);
    }

    public static zzzo emptyIntList() {
        return zzzh.zzd();
    }

    public static zzzr emptyLongList() {
        return zzaae.zzg();
    }

    public static <E> zzzs<E> emptyProtobufList() {
        return zzabb.zzd();
    }

    public static <T extends zzzg> T getDefaultInstance(Class<T> cls) {
        zzzg<?, ?> zzzgVar = defaultInstanceMap.get(cls);
        if (zzzgVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzzgVar = defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e) {
                Types$$ExternalSyntheticBUOutline0.m("Class initialization cannot fail.", e);
                return null;
            }
        }
        if (zzzgVar != null) {
            return zzzgVar;
        }
        zzzg<?, ?> defaultInstanceForType = ((zzzg) zzaby.zzc(cls)).getDefaultInstanceForType();
        if (defaultInstanceForType != null) {
            defaultInstanceMap.put(cls, defaultInstanceForType);
            return defaultInstanceForType;
        }
        Home$$ExternalSyntheticBUOutline0.m$2();
        return null;
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends zzzg<T, ?>> boolean isInitialized(T t, boolean z) {
        byte bByteValue = ((Byte) t.dynamicMethod(zzzf.GET_MEMOIZED_IS_INITIALIZED, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzaba.zza().zzb(t.getClass()).zzl(t);
        if (z) {
            t.dynamicMethod(zzzf.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t, null);
        }
        return zZzl;
    }

    public static <E> zzzs<E> mutableCopy(zzzs<E> zzzsVar) {
        int size = zzzsVar.size();
        return zzzsVar.zzh(size + size);
    }

    public static Object newMessageInfo(zzaaq zzaaqVar, String str, Object[] objArr) {
        return new zzabc(zzaaqVar, str, objArr);
    }

    public static <ContainingType extends zzaaq, Type> zzze<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, zzaaq zzaaqVar, zzzl zzzlVar, int i, zzace zzaceVar, Class cls) {
        return new zzze<>(containingtype, type, zzaaqVar, new zzzd(zzzlVar, i, zzaceVar, false, false), cls);
    }

    public static <T extends zzzg<T, ?>> T parseFrom(T t, byte[] bArr) throws zzzv {
        int length = bArr.length;
        zzyp zzypVar = zzyp.zza;
        int i = zzaba.$r8$clinit;
        T t2 = (T) parsePartialFrom(t, bArr, 0, length, zzyp.zza);
        checkMessageInitialized(t2);
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends zzzg<T, ?>> T parsePartialFrom(T t, byte[] bArr, int i, int i2, zzyp zzypVar) throws zzzv {
        if (i2 == 0) {
            return t;
        }
        T t2 = (T) t.newMutableInstance();
        try {
            zzabe zzabeVarZzb = zzaba.zza().zzb(t2.getClass());
            zzabeVarZzb.zzj(t2, bArr, i, i + i2, new zzwg(zzypVar));
            zzabeVarZzb.zzk(t2);
            return t2;
        } catch (zzabq e) {
            throw e.zza();
        } catch (zzzv e2) {
            if (e2.zzb()) {
                throw new zzzv(e2);
            }
            throw e2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzzv) {
                throw ((zzzv) e3.getCause());
            }
            throw new zzzv(e3);
        } catch (IndexOutOfBoundsException unused) {
            Gson$$ExternalSyntheticBUOutline0.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            return null;
        }
    }

    public static <T extends zzzg> void registerDefaultInstance(Class<T> cls, T t) {
        t.markImmutable();
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() {
        return dynamicMethod(zzzf.BUILD_MESSAGE_INFO, null, null);
    }

    public void clearMemoizedHashCode() {
        this.memoizedHashCode = 0;
    }

    public void clearMemoizedSerializedSize() {
        setMemoizedSerializedSize(Integer.MAX_VALUE);
    }

    public int computeHashCode() {
        return zzaba.zza().zzb(getClass()).zzc(this);
    }

    public final <MessageType extends zzzg<MessageType, BuilderType>, BuilderType extends zzyy<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) dynamicMethod(zzzf.NEW_BUILDER, null, null);
    }

    public abstract Object dynamicMethod(zzzf zzzfVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzaba.zza().zzb(getClass()).zzb(this, (zzzg) obj);
    }

    @Override // com.google.android.gms.internal.serialization.zzaar
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) dynamicMethod(zzzf.GET_DEFAULT_INSTANCE, null, null);
    }

    public int getMemoizedHashCode() {
        return this.memoizedHashCode;
    }

    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize & Integer.MAX_VALUE;
    }

    public final zzaay<MessageType> getParserForType() {
        return (zzaay) dynamicMethod(zzzf.GET_PARSER, null, null);
    }

    @Override // com.google.android.gms.internal.serialization.zzvy
    public int getSerializedSize(zzabe zzabeVar) {
        if (isMutable()) {
            int iComputeSerializedSize = computeSerializedSize(zzabeVar);
            if (iComputeSerializedSize >= 0) {
                return iComputeSerializedSize;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(iComputeSerializedSize, "serialized size must be non-negative, was ", new StringBuilder(String.valueOf(iComputeSerializedSize).length() + 42)));
            return 0;
        }
        if (getMemoizedSerializedSize() != Integer.MAX_VALUE) {
            return getMemoizedSerializedSize();
        }
        int iComputeSerializedSize2 = computeSerializedSize(zzabeVar);
        setMemoizedSerializedSize(iComputeSerializedSize2);
        return iComputeSerializedSize2;
    }

    public int hashCode() {
        if (isMutable()) {
            return computeHashCode();
        }
        if (hashCodeIsNotMemoized()) {
            setMemoizedHashCode(computeHashCode());
        }
        return getMemoizedHashCode();
    }

    public boolean hashCodeIsNotMemoized() {
        return getMemoizedHashCode() == 0;
    }

    public boolean isMutable() {
        return (this.memoizedSerializedSize & MUTABLE_FLAG_MASK) != 0;
    }

    public void makeImmutable() {
        zzaba.zza().zzb(getClass()).zzk(this);
        markImmutable();
    }

    public void markImmutable() {
        this.memoizedSerializedSize &= Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.serialization.zzaaq
    public final BuilderType newBuilderForType() {
        return (BuilderType) dynamicMethod(zzzf.NEW_BUILDER, null, null);
    }

    public MessageType newMutableInstance() {
        return (MessageType) dynamicMethod(zzzf.NEW_MUTABLE_INSTANCE, null, null);
    }

    public void setMemoizedHashCode(int i) {
        this.memoizedHashCode = i;
    }

    public void setMemoizedSerializedSize(int i) {
        if (i >= 0) {
            this.memoizedSerializedSize = i | (this.memoizedSerializedSize & MUTABLE_FLAG_MASK);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3(zzba$$ExternalSyntheticOutline0.m(i, "serialized size must be non-negative, was ", new StringBuilder(String.valueOf(i).length() + 42)));
        }
    }

    @Override // com.google.android.gms.internal.serialization.zzaaq
    public final BuilderType toBuilder() {
        return (BuilderType) ((zzyy) dynamicMethod(zzzf.NEW_BUILDER, null, null)).mergeFrom(this);
    }

    public String toString() {
        return zzaas.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.serialization.zzaaq
    public void writeTo(zzxb zzxbVar) {
        zzaba.zza().zzb(getClass()).zzf(this, zzxc.zza(zzxbVar));
    }

    public static <T extends zzzg<T, ?>> T parseFrom(T t, zzwr zzwrVar, zzyp zzypVar) throws zzzv {
        T t2 = (T) parsePartialFrom(t, zzwrVar, zzypVar);
        checkMessageInitialized(t2);
        return t2;
    }

    public static <T extends zzzg<T, ?>> T parseFrom(T t, zzwr zzwrVar) throws zzzv {
        zzyp zzypVar = zzyp.zza;
        int i = zzaba.$r8$clinit;
        T t2 = (T) parseFrom(t, zzwrVar, zzyp.zza);
        checkMessageInitialized(t2);
        return t2;
    }

    @Override // com.google.android.gms.internal.serialization.zzaar
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    @Override // com.google.android.gms.internal.serialization.zzaaq
    public int getSerializedSize() {
        return getSerializedSize(null);
    }

    public static <T extends zzzg<T, ?>> T parsePartialFrom(T t, zzwv zzwvVar, zzyp zzypVar) throws zzzv {
        T t2 = (T) t.newMutableInstance();
        try {
            zzabe zzabeVarZzb = zzaba.zza().zzb(t2.getClass());
            zzabeVarZzb.zzg(t2, zzww.zza(zzwvVar), zzypVar);
            zzabeVarZzb.zzk(t2);
            return t2;
        } catch (zzabq e) {
            throw e.zza();
        } catch (zzzv e2) {
            if (e2.zzb()) {
                throw new zzzv(e2);
            }
            throw e2;
        } catch (IOException e3) {
            if (e3.getCause() instanceof zzzv) {
                throw ((zzzv) e3.getCause());
            }
            throw new zzzv(e3);
        } catch (RuntimeException e4) {
            if (e4.getCause() instanceof zzzv) {
                throw ((zzzv) e4.getCause());
            }
            throw e4;
        }
    }

    private static <T extends zzzg<T, ?>> T parsePartialFrom(T t, zzwr zzwrVar, zzyp zzypVar) {
        zzwv zzwvVarZzk = zzwrVar.zzk();
        T t2 = (T) parsePartialFrom(t, zzwvVarZzk, zzypVar);
        zzwvVarZzk.zzb(0);
        return t2;
    }
}
