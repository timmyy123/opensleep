package kotlinx.serialization.json;

import android.database.Cursor;
import io.rebble.pebblekit2.client.DefaultPebbleInfoRetriever;
import java.util.Map;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.serialization.SerializersCacheKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class JsonObject$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ JsonObject$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return JsonObject.toString$lambda$1((Map.Entry) obj);
            case 1:
                return DefaultPebbleInfoRetriever.getConnectedWatches$lambda$0((String) obj);
            case 2:
                return DefaultPebbleInfoRetriever.getConnectedWatches$lambda$1((Cursor) obj);
            case 3:
                return CoroutineDispatcher.Companion._init_$lambda$0((CoroutineContext.Element) obj);
            case 4:
                return ExecutorCoroutineDispatcher.Companion._init_$lambda$0((CoroutineContext.Element) obj);
            case 5:
                return SerializersCacheKt.SERIALIZERS_CACHE$lambda$0((KClass) obj);
            case 6:
                return SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE$lambda$1((KClass) obj);
            case 7:
                return SerialDescriptorsKt.buildSerialDescriptor$lambda$6((ClassSerialDescriptorBuilder) obj);
            default:
                return JsonElementSerializer.descriptor$lambda$5((ClassSerialDescriptorBuilder) obj);
        }
    }
}
