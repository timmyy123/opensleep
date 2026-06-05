package androidx.appfunctions.service.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.os.Parcelable;
import android.util.Log;
import androidx.appfunctions.AppFunctionData;
import androidx.appfunctions.AppFunctionInvalidArgumentException;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.Constants;
import androidx.appfunctions.metadata.AppFunctionArrayTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionBooleanTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionBytesTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionDataTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionDoubleTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionFloatTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionIntTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionLongTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionObjectTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionParameterMetadata;
import androidx.appfunctions.metadata.AppFunctionParcelableTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionReferenceTypeMetadata;
import androidx.appfunctions.metadata.AppFunctionStringTypeMetadata;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a.\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003\u001a\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0007H\u0002¨\u0006\u0011"}, d2 = {IntrospectionHelper.ServiceInternalHelper.UNSAFE_GET_PARAMETER_VALUE_METHOD, "", "Landroidx/appfunctions/AppFunctionData;", "parameterMetadata", "Landroidx/appfunctions/metadata/AppFunctionParameterMetadata;", "getArrayTypeParameterValue", SDKConstants.PARAM_KEY, "", "arrayDataTypeMetadata", "Landroidx/appfunctions/metadata/AppFunctionArrayTypeMetadata;", "isNullable", "", "isRequired", "getParcelableClass", "Ljava/lang/Class;", "Landroid/os/Parcelable;", "className", "appfunctions-service"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionDataParameterExtractorKt {
    private static final Object getArrayTypeParameterValue(AppFunctionData appFunctionData, String str, AppFunctionArrayTypeMetadata appFunctionArrayTypeMetadata, boolean z, boolean z2) {
        AppFunctionDataTypeMetadata itemType = appFunctionArrayTypeMetadata.getItemType();
        if (itemType instanceof AppFunctionIntTypeMetadata) {
            if (z2 || z) {
                return appFunctionData.getIntArray(str);
            }
            int[] intArray = appFunctionData.getIntArray(str);
            return intArray == null ? new int[0] : intArray;
        }
        if (itemType instanceof AppFunctionLongTypeMetadata) {
            if (z2 || z) {
                return appFunctionData.getLongArray(str);
            }
            long[] longArray = appFunctionData.getLongArray(str);
            return longArray == null ? new long[0] : longArray;
        }
        if (itemType instanceof AppFunctionFloatTypeMetadata) {
            if (z2 || z) {
                return appFunctionData.getFloatArray(str);
            }
            float[] floatArray = appFunctionData.getFloatArray(str);
            return floatArray == null ? new float[0] : floatArray;
        }
        if (itemType instanceof AppFunctionDoubleTypeMetadata) {
            if (z2 || z) {
                return appFunctionData.getDoubleArray(str);
            }
            double[] doubleArray = appFunctionData.getDoubleArray(str);
            return doubleArray == null ? new double[0] : doubleArray;
        }
        if (itemType instanceof AppFunctionBooleanTypeMetadata) {
            if (z2 || z) {
                return appFunctionData.getBooleanArray(str);
            }
            boolean[] booleanArray = appFunctionData.getBooleanArray(str);
            return booleanArray == null ? new boolean[0] : booleanArray;
        }
        if (itemType instanceof AppFunctionBytesTypeMetadata) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("List<ByteArray> is not supported");
            return null;
        }
        if (itemType instanceof AppFunctionStringTypeMetadata) {
            if (z2 || z) {
                return appFunctionData.getStringList(str);
            }
            List<String> stringList = appFunctionData.getStringList(str);
            return stringList == null ? CollectionsKt.emptyList() : stringList;
        }
        if (itemType instanceof AppFunctionParcelableTypeMetadata) {
            Class<Parcelable> parcelableClass = getParcelableClass(((AppFunctionParcelableTypeMetadata) itemType).getQualifiedName());
            if (z2 || z) {
                return appFunctionData.getParcelableList(str, parcelableClass);
            }
            List parcelableList = appFunctionData.getParcelableList(str, parcelableClass);
            return parcelableList == null ? CollectionsKt.emptyList() : parcelableList;
        }
        if (itemType instanceof AppFunctionObjectTypeMetadata) {
            if (!z2 && !z) {
                List<AppFunctionData> appFunctionDataList = appFunctionData.getAppFunctionDataList(str);
                if (appFunctionDataList == null) {
                    return CollectionsKt.emptyList();
                }
                List<AppFunctionData> list = appFunctionDataList;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (AppFunctionData appFunctionData2 : list) {
                    String qualifiedName = ((AppFunctionObjectTypeMetadata) itemType).getQualifiedName();
                    if (qualifiedName == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    arrayList.add(appFunctionData2.deserialize(qualifiedName));
                }
                return arrayList;
            }
            List<AppFunctionData> appFunctionDataList2 = appFunctionData.getAppFunctionDataList(str);
            if (appFunctionDataList2 != null) {
                List<AppFunctionData> list2 = appFunctionDataList2;
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                for (AppFunctionData appFunctionData3 : list2) {
                    String qualifiedName2 = ((AppFunctionObjectTypeMetadata) itemType).getQualifiedName();
                    if (qualifiedName2 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    arrayList2.add(appFunctionData3.deserialize(qualifiedName2));
                }
                return arrayList2;
            }
        } else {
            if (!(itemType instanceof AppFunctionReferenceTypeMetadata)) {
                Home$$ExternalSyntheticBUOutline0.m("Unknown item DataTypeMetadata: ", (Object) itemType.getClass());
                return null;
            }
            if (!z2 && !z) {
                List<AppFunctionData> appFunctionDataList3 = appFunctionData.getAppFunctionDataList(str);
                if (appFunctionDataList3 == null) {
                    return CollectionsKt.emptyList();
                }
                List<AppFunctionData> list3 = appFunctionDataList3;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                for (AppFunctionData appFunctionData4 : list3) {
                    String referenceDataType = ((AppFunctionReferenceTypeMetadata) itemType).getReferenceDataType();
                    if (referenceDataType == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    arrayList3.add(appFunctionData4.deserialize(referenceDataType));
                }
                return arrayList3;
            }
            List<AppFunctionData> appFunctionDataList4 = appFunctionData.getAppFunctionDataList(str);
            if (appFunctionDataList4 != null) {
                List<AppFunctionData> list4 = appFunctionDataList4;
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                for (AppFunctionData appFunctionData5 : list4) {
                    String referenceDataType2 = ((AppFunctionReferenceTypeMetadata) itemType).getReferenceDataType();
                    if (referenceDataType2 == null) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Required value was null.");
                        return null;
                    }
                    arrayList4.add(appFunctionData5.deserialize(referenceDataType2));
                }
                return arrayList4;
            }
        }
        return null;
    }

    private static final Class<Parcelable> getParcelableClass(String str) {
        try {
            Class cls = Class.forName(str);
            if (Parcelable.class.isAssignableFrom(cls)) {
                return cls;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3(FileInsert$$ExternalSyntheticOutline0.m("Class '", str, "' is not a Parcelable."));
            return null;
        } catch (ClassNotFoundException e) {
            Types$$ExternalSyntheticBUOutline0.m(FileInsert$$ExternalSyntheticOutline0.m("Class '", str, "' could not be found."), e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object unsafeGetParameterValue(AppFunctionData appFunctionData, AppFunctionParameterMetadata appFunctionParameterMetadata) throws AppFunctionInvalidArgumentException {
        Object objDeserialize;
        appFunctionData.getClass();
        appFunctionParameterMetadata.getClass();
        try {
            String name = appFunctionParameterMetadata.getName();
            boolean isRequired = appFunctionParameterMetadata.getIsRequired();
            boolean isNullable = appFunctionParameterMetadata.getDataType().getIsNullable();
            AppFunctionDataTypeMetadata dataType = appFunctionParameterMetadata.getDataType();
            if (dataType instanceof AppFunctionIntTypeMetadata) {
                if (isRequired || isNullable) {
                    objDeserialize = appFunctionData.getIntOrNull(name);
                } else {
                    Integer intOrNull = appFunctionData.getIntOrNull(name);
                    objDeserialize = Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0);
                }
            } else if (dataType instanceof AppFunctionLongTypeMetadata) {
                if (isRequired || isNullable) {
                    objDeserialize = appFunctionData.getLongOrNull(name);
                } else {
                    Long longOrNull = appFunctionData.getLongOrNull(name);
                    objDeserialize = Long.valueOf(longOrNull != null ? longOrNull.longValue() : 0L);
                }
            } else if (dataType instanceof AppFunctionFloatTypeMetadata) {
                if (isRequired || isNullable) {
                    objDeserialize = appFunctionData.getFloatOrNull(name);
                } else {
                    Float floatOrNull = appFunctionData.getFloatOrNull(name);
                    objDeserialize = Float.valueOf(floatOrNull != null ? floatOrNull.floatValue() : 0.0f);
                }
            } else if (dataType instanceof AppFunctionDoubleTypeMetadata) {
                if (isRequired || isNullable) {
                    objDeserialize = appFunctionData.getDoubleOrNull(name);
                } else {
                    Double doubleOrNull = appFunctionData.getDoubleOrNull(name);
                    objDeserialize = Double.valueOf(doubleOrNull != null ? doubleOrNull.doubleValue() : 0.0d);
                }
            } else if (dataType instanceof AppFunctionBooleanTypeMetadata) {
                if (isRequired || isNullable) {
                    objDeserialize = appFunctionData.getBooleanOrNull(name);
                } else {
                    Boolean booleanOrNull = appFunctionData.getBooleanOrNull(name);
                    objDeserialize = Boolean.valueOf(booleanOrNull != null ? booleanOrNull.booleanValue() : false);
                }
            } else if (dataType instanceof AppFunctionBytesTypeMetadata) {
                if (isRequired || isNullable) {
                    objDeserialize = appFunctionData.getByteArray(name);
                } else {
                    objDeserialize = appFunctionData.getByteArray(name);
                    if (objDeserialize == null) {
                        objDeserialize = new byte[0];
                    }
                }
            } else if (dataType instanceof AppFunctionStringTypeMetadata) {
                objDeserialize = appFunctionData.getString(name);
            } else if (dataType instanceof AppFunctionParcelableTypeMetadata) {
                objDeserialize = appFunctionData.getParcelable(name, getParcelableClass(((AppFunctionParcelableTypeMetadata) dataType).getQualifiedName()));
            } else if (dataType instanceof AppFunctionObjectTypeMetadata) {
                AppFunctionData appFunctionData2 = appFunctionData.getAppFunctionData(name);
                if (appFunctionData2 != null) {
                    String qualifiedName = ((AppFunctionObjectTypeMetadata) dataType).getQualifiedName();
                    if (qualifiedName == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    objDeserialize = appFunctionData2.deserialize(qualifiedName);
                } else {
                    objDeserialize = null;
                }
            } else if (dataType instanceof AppFunctionArrayTypeMetadata) {
                objDeserialize = getArrayTypeParameterValue(appFunctionData, appFunctionParameterMetadata.getName(), (AppFunctionArrayTypeMetadata) dataType, dataType.getIsNullable(), appFunctionParameterMetadata.getIsRequired());
            } else {
                if (!(dataType instanceof AppFunctionReferenceTypeMetadata)) {
                    throw new IllegalStateException("Unknown DataTypeMetadata: " + dataType.getClass());
                }
                AppFunctionData appFunctionData3 = appFunctionData.getAppFunctionData(name);
                if (appFunctionData3 != null) {
                    String referenceDataType = ((AppFunctionReferenceTypeMetadata) dataType).getReferenceDataType();
                    if (referenceDataType == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    objDeserialize = appFunctionData3.deserialize(referenceDataType);
                }
            }
            if (objDeserialize == null && appFunctionParameterMetadata.getIsRequired() && !appFunctionParameterMetadata.getDataType().getIsNullable()) {
                Log.d(Constants.APP_FUNCTIONS_TAG, "Parameter " + appFunctionParameterMetadata.getName() + " is required");
                throw new IllegalArgumentException(("Parameter " + appFunctionParameterMetadata.getName() + " is required").toString());
            }
            return objDeserialize;
        } catch (IllegalArgumentException e) {
            Log.d(Constants.APP_FUNCTIONS_TAG, "Parameter " + appFunctionParameterMetadata.getName() + " should be the type of " + appFunctionParameterMetadata.getDataType(), e);
            throw new AppFunctionInvalidArgumentException("Parameter " + appFunctionParameterMetadata.getName() + " should be the type of " + appFunctionParameterMetadata.getDataType());
        }
    }
}
