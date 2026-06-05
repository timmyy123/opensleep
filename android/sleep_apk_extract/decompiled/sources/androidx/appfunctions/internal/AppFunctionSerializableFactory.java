package androidx.appfunctions.internal;

import adamb.ogg.OggIO$$ExternalSyntheticBUOutline0;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.metadata.AppFunctionAllOfTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionObjectTypeMetadata;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0001\u0011J\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H&¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "T", "", IntrospectionHelper.AppFunctionSerializableFactoryClass.FromAppFunctionDataMethod.METHOD_NAME, "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;)Ljava/lang/Object;", IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.METHOD_NAME, IntrospectionHelper.AppFunctionSerializableFactoryClass.ToAppFunctionDataMethod.APP_FUNCTION_SERIALIZABLE_PARAM_NAME, "(Ljava/lang/Object;)Landroidx/appfunctions/AppFunctionData;", "getAppFunctionComponentsMetadata", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.METHOD_NAME, "Landroidx/appfunctions/AppFunctionData$Builder;", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataBuilder.QUALIFIED_NAME_PARAM_NAME, "", IntrospectionHelper.AppFunctionSerializableFactoryClass.GetAppFunctionDataWithSpec.METHOD_NAME, "TypeParameter", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppFunctionSerializableFactory<T> {

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002:\u0004\u000f\u0010\u0011\u0012J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0001H'¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00028\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH'¢\u0006\u0002\u0010\u000e\u0082\u0001\u0004\u0013\u0014\u0015\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "T", "", "setValueInAppFunctionData", "", "appFunctionDataBuilder", "Landroidx/appfunctions/AppFunctionData$Builder;", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "getFromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/lang/Object;", "PrimitiveTypeParameter", "PrimitiveListTypeParameter", "SerializableTypeParameter", "SerializableListTypeParameter", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveListTypeParameter;", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveTypeParameter;", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableListTypeParameter;", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableTypeParameter;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface TypeParameter<T> {

        @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u000e\b\u0003\u0010\u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0003H\u0017¢\u0006\u0002\u0010\u0012J\u001d\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0016J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006HÆ\u0003J%\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004J\n\u0010\u001f\u001a\u00020\u0010HÖ\u0081\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006 "}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveListTypeParameter;", "I", "T", "", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "itemClazz", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getItemClazz", "()Ljava/lang/Class;", "setValueInAppFunctionData", "", "appFunctionDataBuilder", "Landroidx/appfunctions/AppFunctionData$Builder;", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/util/List;)V", "getFromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class PrimitiveListTypeParameter<I, T extends List<?>> implements TypeParameter<T> {
            private final Class<I> itemClazz;

            public PrimitiveListTypeParameter(Class<I> cls) {
                cls.getClass();
                this.itemClazz = cls;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PrimitiveListTypeParameter copy$default(PrimitiveListTypeParameter primitiveListTypeParameter, Class cls, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = primitiveListTypeParameter.itemClazz;
                }
                return primitiveListTypeParameter.copy(cls);
            }

            public final Class<I> component1() {
                return this.itemClazz;
            }

            public final PrimitiveListTypeParameter<I, T> copy(Class<I> itemClazz) {
                itemClazz.getClass();
                return new PrimitiveListTypeParameter<>(itemClazz);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PrimitiveListTypeParameter) && Intrinsics.areEqual(this.itemClazz, ((PrimitiveListTypeParameter) other).itemClazz);
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                appFunctionData.getClass();
                key.getClass();
                if (Intrinsics.areEqual(this.itemClazz, String.class)) {
                    return appFunctionData.getStringList(key);
                }
                OggIO$$ExternalSyntheticBUOutline0.m("Unsupported item type for primitive list: ", this.itemClazz);
                return null;
            }

            public final Class<I> getItemClazz() {
                return this.itemClazz;
            }

            public int hashCode() {
                return this.itemClazz.hashCode();
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                appFunctionDataBuilder.getClass();
                key.getClass();
                if (value == null) {
                    return;
                }
                if (Intrinsics.areEqual(this.itemClazz, String.class)) {
                    appFunctionDataBuilder.setStringList(key, value);
                } else {
                    OggIO$$ExternalSyntheticBUOutline0.m("Unsupported item type for primitive list: ", this.itemClazz);
                }
            }

            public String toString() {
                return "PrimitiveListTypeParameter(itemClazz=" + this.itemClazz + ')';
            }
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0002H\u0017¢\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00028\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0014J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004HÆ\u0003J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u000eHÖ\u0081\u0004R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001e"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$PrimitiveTypeParameter;", "T", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "clazz", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getClazz", "()Ljava/lang/Class;", "setValueInAppFunctionData", "", "appFunctionDataBuilder", "Landroidx/appfunctions/AppFunctionData$Builder;", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "getFromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/lang/Object;", "component1", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class PrimitiveTypeParameter<T> implements TypeParameter<T> {
            private final Class<T> clazz;

            public PrimitiveTypeParameter(Class<T> cls) {
                cls.getClass();
                this.clazz = cls;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ PrimitiveTypeParameter copy$default(PrimitiveTypeParameter primitiveTypeParameter, Class cls, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = primitiveTypeParameter.clazz;
                }
                return primitiveTypeParameter.copy(cls);
            }

            public final Class<T> component1() {
                return this.clazz;
            }

            public final PrimitiveTypeParameter<T> copy(Class<T> clazz) {
                clazz.getClass();
                return new PrimitiveTypeParameter<>(clazz);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof PrimitiveTypeParameter) && Intrinsics.areEqual(this.clazz, ((PrimitiveTypeParameter) other).clazz);
            }

            public final Class<T> getClazz() {
                return this.clazz;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                appFunctionData.getClass();
                key.getClass();
                Class<T> cls = this.clazz;
                if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                    return (T) Integer.valueOf(appFunctionData.getInt(key));
                }
                if (Intrinsics.areEqual(cls, Long.TYPE)) {
                    return (T) Long.valueOf(appFunctionData.getLong(key));
                }
                if (Intrinsics.areEqual(cls, Float.TYPE)) {
                    return (T) Float.valueOf(appFunctionData.getFloat(key));
                }
                if (Intrinsics.areEqual(cls, Double.TYPE)) {
                    return (T) Double.valueOf(appFunctionData.getDouble(key));
                }
                if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                    return (T) Boolean.valueOf(appFunctionData.getBoolean(key));
                }
                if (Intrinsics.areEqual(cls, String.class)) {
                    return (T) appFunctionData.getString(key);
                }
                if (Intrinsics.areEqual(cls, int[].class)) {
                    return (T) appFunctionData.getIntArray(key);
                }
                if (Intrinsics.areEqual(cls, long[].class)) {
                    return (T) appFunctionData.getLongArray(key);
                }
                if (Intrinsics.areEqual(cls, float[].class)) {
                    return (T) appFunctionData.getFloatArray(key);
                }
                if (Intrinsics.areEqual(cls, double[].class)) {
                    return (T) appFunctionData.getDoubleArray(key);
                }
                if (Intrinsics.areEqual(cls, boolean[].class)) {
                    return (T) appFunctionData.getBooleanArray(key);
                }
                if (Intrinsics.areEqual(cls, byte[].class)) {
                    return (T) appFunctionData.getByteArray(key);
                }
                OggIO$$ExternalSyntheticBUOutline0.m("Unsupported primitive type: ", this.clazz);
                return null;
            }

            public int hashCode() {
                return this.clazz.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                appFunctionDataBuilder.getClass();
                key.getClass();
                if (value == 0) {
                    return;
                }
                Class<T> cls = this.clazz;
                if (Intrinsics.areEqual(cls, Integer.TYPE)) {
                    appFunctionDataBuilder.setInt(key, ((Integer) value).intValue());
                    return;
                }
                if (Intrinsics.areEqual(cls, Long.TYPE)) {
                    appFunctionDataBuilder.setLong(key, ((Long) value).longValue());
                    return;
                }
                if (Intrinsics.areEqual(cls, Float.TYPE)) {
                    appFunctionDataBuilder.setFloat(key, ((Float) value).floatValue());
                    return;
                }
                if (Intrinsics.areEqual(cls, Double.TYPE)) {
                    appFunctionDataBuilder.setDouble(key, ((Double) value).doubleValue());
                    return;
                }
                if (Intrinsics.areEqual(cls, Boolean.TYPE)) {
                    appFunctionDataBuilder.setBoolean(key, ((Boolean) value).booleanValue());
                    return;
                }
                if (Intrinsics.areEqual(cls, String.class)) {
                    appFunctionDataBuilder.setString(key, (String) value);
                    return;
                }
                if (Intrinsics.areEqual(cls, int[].class)) {
                    appFunctionDataBuilder.setIntArray(key, (int[]) value);
                    return;
                }
                if (Intrinsics.areEqual(cls, long[].class)) {
                    appFunctionDataBuilder.setLongArray(key, (long[]) value);
                    return;
                }
                if (Intrinsics.areEqual(cls, float[].class)) {
                    appFunctionDataBuilder.setFloatArray(key, (float[]) value);
                    return;
                }
                if (Intrinsics.areEqual(cls, double[].class)) {
                    appFunctionDataBuilder.setDoubleArray(key, (double[]) value);
                    return;
                }
                if (Intrinsics.areEqual(cls, boolean[].class)) {
                    appFunctionDataBuilder.setBooleanArray(key, (boolean[]) value);
                } else if (Intrinsics.areEqual(cls, byte[].class)) {
                    appFunctionDataBuilder.setByteArray(key, (byte[]) value);
                } else {
                    OggIO$$ExternalSyntheticBUOutline0.m("Unsupported primitive type: ", this.clazz);
                }
            }

            public String toString() {
                return "PrimitiveTypeParameter(clazz=" + this.clazz + ')';
            }
        }

        @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\u000e\b\u0003\u0010\u0003*\b\u0012\u0002\b\u0003\u0018\u00010\u00042\b\u0012\u0004\u0012\u0002H\u00030\u0005B#\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00028\u0003H\u0017¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u00028\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u0015H\u0017¢\u0006\u0002\u0010\u001bJ\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00020\tHÆ\u0003J5\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tHÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableListTypeParameter;", "I", "", "T", "", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "itemClazz", "Ljava/lang/Class;", "serializableFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "<init>", "(Ljava/lang/Class;Landroidx/appfunctions/internal/AppFunctionSerializableFactory;)V", "getItemClazz", "()Ljava/lang/Class;", "getSerializableFactory", "()Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "setValueInAppFunctionData", "", "appFunctionDataBuilder", "Landroidx/appfunctions/AppFunctionData$Builder;", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/util/List;)V", "getFromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class SerializableListTypeParameter<I, T extends List<?>> implements TypeParameter<T> {
            private final Class<I> itemClazz;
            private final AppFunctionSerializableFactory<I> serializableFactory;

            public SerializableListTypeParameter(Class<I> cls, AppFunctionSerializableFactory<I> appFunctionSerializableFactory) {
                cls.getClass();
                appFunctionSerializableFactory.getClass();
                this.itemClazz = cls;
                this.serializableFactory = appFunctionSerializableFactory;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SerializableListTypeParameter copy$default(SerializableListTypeParameter serializableListTypeParameter, Class cls, AppFunctionSerializableFactory appFunctionSerializableFactory, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = serializableListTypeParameter.itemClazz;
                }
                if ((i & 2) != 0) {
                    appFunctionSerializableFactory = serializableListTypeParameter.serializableFactory;
                }
                return serializableListTypeParameter.copy(cls, appFunctionSerializableFactory);
            }

            public final Class<I> component1() {
                return this.itemClazz;
            }

            public final AppFunctionSerializableFactory<I> component2() {
                return this.serializableFactory;
            }

            public final SerializableListTypeParameter<I, T> copy(Class<I> itemClazz, AppFunctionSerializableFactory<I> serializableFactory) {
                itemClazz.getClass();
                serializableFactory.getClass();
                return new SerializableListTypeParameter<>(itemClazz, serializableFactory);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SerializableListTypeParameter)) {
                    return false;
                }
                SerializableListTypeParameter serializableListTypeParameter = (SerializableListTypeParameter) other;
                return Intrinsics.areEqual(this.itemClazz, serializableListTypeParameter.itemClazz) && Intrinsics.areEqual(this.serializableFactory, serializableListTypeParameter.serializableFactory);
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                appFunctionData.getClass();
                key.getClass();
                List<AppFunctionData> appFunctionDataList = appFunctionData.getAppFunctionDataList(key);
                if (appFunctionDataList == null) {
                    return null;
                }
                List<AppFunctionData> list = appFunctionDataList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(this.serializableFactory.fromAppFunctionData((AppFunctionData) it.next()));
                }
                return arrayList;
            }

            public final Class<I> getItemClazz() {
                return this.itemClazz;
            }

            public final AppFunctionSerializableFactory<I> getSerializableFactory() {
                return this.serializableFactory;
            }

            public int hashCode() {
                return this.serializableFactory.hashCode() + (this.itemClazz.hashCode() * 31);
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                appFunctionDataBuilder.getClass();
                key.getClass();
                if (value == null) {
                    return;
                }
                T t = value;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(t, 10));
                for (T t2 : t) {
                    AppFunctionSerializableFactory<I> appFunctionSerializableFactory = this.serializableFactory;
                    t2.getClass();
                    arrayList.add(appFunctionSerializableFactory.toAppFunctionData(t2));
                }
                appFunctionDataBuilder.setAppFunctionDataList(key, arrayList);
            }

            public String toString() {
                return "SerializableListTypeParameter(itemClazz=" + this.itemClazz + ", serializableFactory=" + this.serializableFactory + ')';
            }
        }

        @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\n\b\u0003\u0010\u0003*\u0004\u0018\u0001H\u00012\b\u0012\u0004\u0012\u0002H\u00030\u0004B#\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b¢\u0006\u0004\b\t\u0010\nJ%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00028\u0003H\u0017¢\u0006\u0002\u0010\u0016J\u001d\u0010\u0017\u001a\u00028\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0017¢\u0006\u0002\u0010\u001aJ\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00020\bHÆ\u0003J5\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\bHÆ\u0001J\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0014HÖ\u0081\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter$SerializableTypeParameter;", "I", "", "T", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory$TypeParameter;", "clazz", "Ljava/lang/Class;", "serializableFactory", "Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "<init>", "(Ljava/lang/Class;Landroidx/appfunctions/internal/AppFunctionSerializableFactory;)V", "getClazz", "()Ljava/lang/Class;", "getSerializableFactory", "()Landroidx/appfunctions/internal/AppFunctionSerializableFactory;", "setValueInAppFunctionData", "", "appFunctionDataBuilder", "Landroidx/appfunctions/AppFunctionData$Builder;", SDKConstants.PARAM_KEY, "", SDKConstants.PARAM_VALUE, "(Landroidx/appfunctions/AppFunctionData$Builder;Ljava/lang/String;Ljava/lang/Object;)V", "getFromAppFunctionData", "appFunctionData", "Landroidx/appfunctions/AppFunctionData;", "(Landroidx/appfunctions/AppFunctionData;Ljava/lang/String;)Ljava/lang/Object;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final /* data */ class SerializableTypeParameter<I, T extends I> implements TypeParameter<T> {
            private final Class<T> clazz;
            private final AppFunctionSerializableFactory<I> serializableFactory;

            public SerializableTypeParameter(Class<T> cls, AppFunctionSerializableFactory<I> appFunctionSerializableFactory) {
                cls.getClass();
                appFunctionSerializableFactory.getClass();
                this.clazz = cls;
                this.serializableFactory = appFunctionSerializableFactory;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SerializableTypeParameter copy$default(SerializableTypeParameter serializableTypeParameter, Class cls, AppFunctionSerializableFactory appFunctionSerializableFactory, int i, Object obj) {
                if ((i & 1) != 0) {
                    cls = serializableTypeParameter.clazz;
                }
                if ((i & 2) != 0) {
                    appFunctionSerializableFactory = serializableTypeParameter.serializableFactory;
                }
                return serializableTypeParameter.copy(cls, appFunctionSerializableFactory);
            }

            public final Class<T> component1() {
                return this.clazz;
            }

            public final AppFunctionSerializableFactory<I> component2() {
                return this.serializableFactory;
            }

            public final SerializableTypeParameter<I, T> copy(Class<T> clazz, AppFunctionSerializableFactory<I> serializableFactory) {
                clazz.getClass();
                serializableFactory.getClass();
                return new SerializableTypeParameter<>(clazz, serializableFactory);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SerializableTypeParameter)) {
                    return false;
                }
                SerializableTypeParameter serializableTypeParameter = (SerializableTypeParameter) other;
                return Intrinsics.areEqual(this.clazz, serializableTypeParameter.clazz) && Intrinsics.areEqual(this.serializableFactory, serializableTypeParameter.serializableFactory);
            }

            public final Class<T> getClazz() {
                return this.clazz;
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public T getFromAppFunctionData(AppFunctionData appFunctionData, String key) {
                appFunctionData.getClass();
                key.getClass();
                AppFunctionData appFunctionData2 = appFunctionData.getAppFunctionData(key);
                if (appFunctionData2 != null) {
                    return this.serializableFactory.fromAppFunctionData(appFunctionData2);
                }
                return null;
            }

            public final AppFunctionSerializableFactory<I> getSerializableFactory() {
                return this.serializableFactory;
            }

            public int hashCode() {
                return this.serializableFactory.hashCode() + (this.clazz.hashCode() * 31);
            }

            @Override // androidx.appfunctions.internal.AppFunctionSerializableFactory.TypeParameter
            public void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value) {
                appFunctionDataBuilder.getClass();
                key.getClass();
                if (value == null) {
                    return;
                }
                appFunctionDataBuilder.setAppFunctionData(key, this.serializableFactory.toAppFunctionData(value));
            }

            public String toString() {
                return "SerializableTypeParameter(clazz=" + this.clazz + ", serializableFactory=" + this.serializableFactory + ')';
            }
        }

        T getFromAppFunctionData(AppFunctionData appFunctionData, String key);

        void setValueInAppFunctionData(AppFunctionData.Builder appFunctionDataBuilder, String key, T value);
    }

    private default AppFunctionComponentsMetadata getAppFunctionComponentsMetadata() {
        AppFunctionComponentsMetadata componentsMetadata;
        AppFunctionInventory appFunctionInventory$appfunctions = Dependencies.INSTANCE.getAppFunctionInventory$appfunctions();
        return (appFunctionInventory$appfunctions == null || (componentsMetadata = appFunctionInventory$appfunctions.getComponentsMetadata()) == null) ? new AppFunctionComponentsMetadata(null, 1, null) : componentsMetadata;
    }

    T fromAppFunctionData(AppFunctionData appFunctionData);

    default AppFunctionData.Builder getAppFunctionDataBuilder(String qualifiedName) {
        qualifiedName.getClass();
        AppFunctionComponentsMetadata appFunctionComponentsMetadata = getAppFunctionComponentsMetadata();
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = appFunctionComponentsMetadata.getDataTypes().get(qualifiedName);
        if (appFunctionDataTypeMetadata == null) {
            return new AppFunctionData.Builder(qualifiedName, null, 2, null);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata) {
            return new AppFunctionData.Builder((AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata, appFunctionComponentsMetadata);
        }
        if (appFunctionDataTypeMetadata instanceof AppFunctionAllOfTypeMetadata) {
            return new AppFunctionData.Builder((AppFunctionAllOfTypeMetadata) appFunctionDataTypeMetadata, appFunctionComponentsMetadata);
        }
        FacebookSdk$$ExternalSyntheticLambda1.m("Unable to serialize ", qualifiedName, " with ", appFunctionDataTypeMetadata);
        return null;
    }

    default AppFunctionData getAppFunctionDataWithSpec(AppFunctionData appFunctionData, String qualifiedName) {
        appFunctionData.getClass();
        qualifiedName.getClass();
        AppFunctionComponentsMetadata appFunctionComponentsMetadata = getAppFunctionComponentsMetadata();
        AppFunctionDataTypeMetadata appFunctionDataTypeMetadata = appFunctionComponentsMetadata.getDataTypes().get(qualifiedName);
        AppFunctionObjectTypeMetadata appFunctionObjectTypeMetadata = appFunctionDataTypeMetadata instanceof AppFunctionObjectTypeMetadata ? (AppFunctionObjectTypeMetadata) appFunctionDataTypeMetadata : null;
        return appFunctionObjectTypeMetadata == null ? appFunctionData : appFunctionData.replaceSpecWith$appfunctions(appFunctionObjectTypeMetadata, appFunctionComponentsMetadata);
    }

    AppFunctionData toAppFunctionData(T appFunctionSerializable);
}
