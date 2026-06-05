package io.ktor.http;

import com.urbandroid.sleep.sensor.extra.ExtraDataProcessor;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.engine.okhttp.OkHttpEngineKt;
import io.ktor.util.StringValuesBuilderImpl;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.coroutines.flow.internal.SafeCollector_commonKt;
import okhttp3.Request;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class URLParserKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ URLParserKt$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        int i = this.$r8$classId;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return URLParserKt.parseQuery$lambda$5((URLBuilder) obj3, (String) obj, (List) obj2);
            case 1:
                return ExtraDataProcessor.start$lambda$0((ExtraDataProcessor) obj3, ((Float) obj).floatValue(), ((Long) obj2).longValue());
            case 2:
                return UtilsKt.mergeHeaders$lambda$2((Function2) obj3, (String) obj, (List) obj2);
            case 3:
                return OkHttpEngineKt.convertToOkHttpRequest$lambda$1$lambda$0((Request.Builder) obj3, (String) obj, (String) obj2);
            case 4:
                return StringValuesBuilderImpl.appendAll$lambda$0((StringValuesBuilderImpl) obj3, (String) obj, (List) obj2);
            default:
                return Integer.valueOf(SafeCollector_commonKt.checkContext$lambda$0((SafeCollector) obj3, ((Integer) obj).intValue(), (CoroutineContext.Element) obj2));
        }
    }
}
