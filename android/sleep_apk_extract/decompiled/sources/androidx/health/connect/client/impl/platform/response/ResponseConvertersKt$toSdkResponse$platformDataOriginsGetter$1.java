package androidx.health.connect.client.impl.platform.response;

import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.DataOrigin;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import androidx.health.connect.client.impl.platform.records.RecordMappingsKt$$ExternalSyntheticApiModelOutline2;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda1;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
public /* synthetic */ class ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$1 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Set<DataOrigin>> {
    public ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$1(Object obj) {
        super(1, obj, FacebookSdk$$ExternalSyntheticLambda1.m(), "getDataOrigins", "getDataOrigins(Landroid/health/connect/datatypes/AggregationType;)Ljava/util/Set;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<DataOrigin> invoke2(AggregationType<Object> aggregationType) {
        aggregationType.getClass();
        return Fragment$$ExternalSyntheticBUOutline0.m(this.receiver).getDataOrigins(aggregationType);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Set<DataOrigin> invoke(AggregationType<Object> aggregationType) {
        return invoke2(RecordMappingsKt$$ExternalSyntheticApiModelOutline2.m152m((Object) aggregationType));
    }
}
