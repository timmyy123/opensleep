package androidx.health.connect.client.impl.converters.datatype;

import androidx.health.connect.client.records.Record;
import androidx.health.platform.client.proto.DataProto;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import kotlin.Metadata;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0006\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "", "toDataTypeName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "Landroidx/health/platform/client/proto/DataProto$DataType;", "toDataType", "(Lkotlin/reflect/KClass;)Landroidx/health/platform/client/proto/DataProto$DataType;", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class DataTypeConverterKt {
    public static final DataProto.DataType toDataType(KClass<? extends Record> kClass) {
        kClass.getClass();
        DataProto.DataType dataTypeBuild = DataProto.DataType.newBuilder().setName(toDataTypeName(kClass)).build();
        dataTypeBuild.getClass();
        return dataTypeBuild;
    }

    public static final String toDataTypeName(KClass<? extends Record> kClass) {
        kClass.getClass();
        String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(kClass);
        if (str != null) {
            return str;
        }
        Events$$ExternalSyntheticBUOutline0.m("Not supported yet: ", kClass);
        return null;
    }
}
