package kotlin.coroutines;

import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.list.CaptchaRecyclerViewAdapter;
import io.ktor.client.plugins.websocket.BuildersKt;
import io.ktor.http.URLBuilder;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineContextKt;
import kotlinx.coroutines.flow.internal.SafeCollector;
import kotlinx.serialization.SerializersCacheKt;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CombinedContext$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ CombinedContext$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return CombinedContext.toString$lambda$0((String) obj, (CoroutineContext.Element) obj2);
            case 1:
                return Integer.valueOf(CaptchaRecyclerViewAdapter.add$lambda$0((CaptchaInfo) obj, (CaptchaInfo) obj2));
            case 2:
                return BuildersKt.webSocketSession$lambda$2$lambda$1((URLBuilder) obj, (URLBuilder) obj2);
            case 3:
                return CoroutineContext.DefaultImpls.plus$lambda$0((CoroutineContext) obj, (CoroutineContext.Element) obj2);
            case 4:
                return Boolean.valueOf(CoroutineContextKt.hasCopyableElements$lambda$0(((Boolean) obj).booleanValue(), (CoroutineContext.Element) obj2));
            case 5:
                return ((CoroutineContext) obj).plus((CoroutineContext.Element) obj2);
            case 6:
                return Integer.valueOf(SafeCollector.collectContextSize$lambda$0(((Integer) obj).intValue(), (CoroutineContext.Element) obj2));
            case 7:
                return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$3((KClass) obj, (List) obj2);
            default:
                return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$5((KClass) obj, (List) obj2);
        }
    }
}
