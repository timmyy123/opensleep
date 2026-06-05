package androidx.health.connect.client.impl.converters.records;

import androidx.health.platform.client.proto.DataProto;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0000\u001a\u0010\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0000\u001a&\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00070\u000eH\u0000¨\u0006\u000f"}, d2 = {"longVal", "Landroidx/health/platform/client/proto/DataProto$Value;", SDKConstants.PARAM_VALUE, "", "doubleVal", "", "stringVal", "", "enumVal", "boolVal", "", "enumValFromInt", "", "intToStringMap", "", "connect-client_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ValueExtKt {
    public static final DataProto.Value boolVal(boolean z) {
        DataProto.Value valueBuild = DataProto.Value.newBuilder().setBooleanVal(z).build();
        valueBuild.getClass();
        return valueBuild;
    }

    public static final DataProto.Value doubleVal(double d) {
        DataProto.Value valueBuild = DataProto.Value.newBuilder().setDoubleVal(d).build();
        valueBuild.getClass();
        return valueBuild;
    }

    public static final DataProto.Value enumVal(String str) {
        str.getClass();
        DataProto.Value valueBuild = DataProto.Value.newBuilder().setEnumVal(str).build();
        valueBuild.getClass();
        return valueBuild;
    }

    public static final DataProto.Value enumValFromInt(int i, Map<Integer, String> map) {
        map.getClass();
        String str = map.get(Integer.valueOf(i));
        if (str != null) {
            return enumVal(str);
        }
        return null;
    }

    public static final DataProto.Value longVal(long j) {
        DataProto.Value valueBuild = DataProto.Value.newBuilder().setLongVal(j).build();
        valueBuild.getClass();
        return valueBuild;
    }

    public static final DataProto.Value stringVal(String str) {
        str.getClass();
        DataProto.Value valueBuild = DataProto.Value.newBuilder().setStringVal(str).build();
        valueBuild.getClass();
        return valueBuild;
    }
}
