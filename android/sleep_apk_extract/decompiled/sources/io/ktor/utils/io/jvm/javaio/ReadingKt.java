package io.ktor.utils.io.jvm.javaio;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.pool.ByteArrayPoolKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.io.JvmCoreKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\t\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Ljava/io/InputStream;", "Lkotlin/coroutines/CoroutineContext;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lio/ktor/utils/io/pool/ObjectPool;", "", "pool", "Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannelWithArrayPool", "(Ljava/io/InputStream;Lkotlin/coroutines/CoroutineContext;Lio/ktor/utils/io/pool/ObjectPool;)Lio/ktor/utils/io/ByteReadChannel;", "toByteReadChannel", "ktor-io"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class ReadingKt {
    public static final ByteReadChannel toByteReadChannelWithArrayPool(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool<byte[]> objectPool) {
        inputStream.getClass();
        coroutineContext.getClass();
        objectPool.getClass();
        return new RawSourceChannel(JvmCoreKt.asSource(inputStream), coroutineContext);
    }

    public static /* synthetic */ ByteReadChannel toByteReadChannelWithArrayPool$default(InputStream inputStream, CoroutineContext coroutineContext, ObjectPool objectPool, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        if ((i & 2) != 0) {
            objectPool = ByteArrayPoolKt.getByteArrayPool();
        }
        return toByteReadChannelWithArrayPool(inputStream, coroutineContext, objectPool);
    }
}
