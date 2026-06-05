package io.ktor.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.SendChannel;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", l = {76}, m = "invokeSuspend")
public final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    public NonceKt$nonceGeneratorJob$1(Continuation<? super NonceKt$nonceGeneratorJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonceKt$nonceGeneratorJob$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NonceKt$nonceGeneratorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007d A[Catch: all -> 0x0041, LOOP:1: B:14:0x007b->B:15:0x007d, LOOP_END, TryCatch #0 {all -> 0x0041, blocks: (B:6:0x0030, B:25:0x00f1, B:22:0x00d0, B:26:0x00f3, B:28:0x0102, B:13:0x0072, B:15:0x007d, B:16:0x0086, B:18:0x0092, B:20:0x00a3, B:19:0x00a0), top: B:37:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0092 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:6:0x0030, B:25:0x00f1, B:22:0x00d0, B:26:0x00f3, B:28:0x0102, B:13:0x0072, B:15:0x007d, B:16:0x0086, B:18:0x0092, B:20:0x00a3, B:19:0x00a0), top: B:37:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:6:0x0030, B:25:0x00f1, B:22:0x00d0, B:26:0x00f3, B:28:0x0102, B:13:0x0072, B:15:0x007d, B:16:0x0086, B:18:0x0092, B:20:0x00a3, B:19:0x00a0), top: B:37:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d0 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:6:0x0030, B:25:0x00f1, B:22:0x00d0, B:26:0x00f3, B:28:0x0102, B:13:0x0072, B:15:0x007d, B:16:0x0086, B:18:0x0092, B:20:0x00a3, B:19:0x00a0), top: B:37:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3 A[Catch: all -> 0x0041, TryCatch #0 {all -> 0x0041, blocks: (B:6:0x0030, B:25:0x00f1, B:22:0x00d0, B:26:0x00f3, B:28:0x0102, B:13:0x0072, B:15:0x007d, B:16:0x0086, B:18:0x0092, B:20:0x00a3, B:19:0x00a0), top: B:37:0x0030 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ee -> B:25:0x00f1). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws NoSuchAlgorithmException {
        ArrayList arrayList;
        SecureRandom secureRandomLookupSecureRandom;
        SecureRandom secureRandom;
        byte[] bArr;
        byte[] bArr2;
        long j;
        Channel channel;
        int length;
        int i;
        long jCurrentTimeMillis;
        int size;
        int i2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Channel<String> seedChannel = NonceKt.getSeedChannel();
            arrayList = new ArrayList();
            secureRandomLookupSecureRandom = NonceKt.lookupSecureRandom();
            secureRandom = SecureRandom.getInstance("SHA1PRNG");
            bArr = new byte[128];
            bArr2 = new byte[512];
            secureRandom.setSeed(secureRandomLookupSecureRandom.generateSeed(128));
            j = 0;
            channel = seedChannel;
            secureRandomLookupSecureRandom.nextBytes(bArr);
            secureRandom.nextBytes(bArr2);
            length = bArr.length;
            while (i < length) {
            }
            jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - j <= 30000) {
            }
            if (i2 >= size) {
            }
        } else {
            if (i3 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            size = this.I$1;
            i2 = this.I$0;
            long j2 = this.J$0;
            List list = (List) this.L$6;
            byte[] bArr3 = (byte[]) this.L$5;
            byte[] bArr4 = (byte[]) this.L$4;
            SecureRandom secureRandom2 = (SecureRandom) this.L$3;
            SecureRandom secureRandom3 = (SecureRandom) this.L$2;
            ArrayList arrayList2 = (ArrayList) this.L$1;
            channel = (Channel) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                List list2 = list;
                SecureRandom secureRandom4 = secureRandom2;
                byte[] bArr5 = bArr3;
                SecureRandom secureRandom5 = secureRandom3;
                ArrayList arrayList3 = arrayList2;
                long j3 = j2;
                i2++;
                if (i2 >= size) {
                    Object obj2 = list2.get(i2);
                    this.L$0 = channel;
                    this.L$1 = arrayList3;
                    this.L$2 = secureRandom5;
                    this.L$3 = secureRandom4;
                    this.L$4 = bArr4;
                    this.L$5 = bArr5;
                    this.L$6 = list2;
                    this.J$0 = j3;
                    this.I$0 = i2;
                    this.I$1 = size;
                    this.label = 1;
                    if (channel.send(obj2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    i2++;
                    if (i2 >= size) {
                        arrayList3.clear();
                        int size2 = list2.size();
                        for (int size3 = list2.size() / 2; size3 < size2; size3++) {
                            arrayList3.add(list2.get(size3));
                        }
                        arrayList = arrayList3;
                        secureRandomLookupSecureRandom = secureRandom5;
                        secureRandom = secureRandom4;
                        bArr = bArr4;
                        bArr2 = bArr5;
                        j = j3;
                        secureRandomLookupSecureRandom.nextBytes(bArr);
                        secureRandom.nextBytes(bArr2);
                        length = bArr.length;
                        for (i = 0; i < length; i++) {
                            bArr2[i * 4] = bArr[i];
                        }
                        jCurrentTimeMillis = System.currentTimeMillis();
                        if (jCurrentTimeMillis - j <= 30000) {
                            secureRandom.setSeed(j - jCurrentTimeMillis);
                            secureRandom.setSeed(secureRandomLookupSecureRandom.generateSeed(bArr.length));
                            List listShuffled = CollectionsKt__CollectionsJVMKt.shuffled(kotlin.collections.CollectionsKt.plus((Collection) StringsKt___StringsKt.chunked(CryptoKt.hex(bArr2), 16), (Iterable) arrayList), secureRandom);
                            byte[] bArr6 = bArr;
                            list2 = listShuffled;
                            size = listShuffled.size() / 2;
                            j3 = jCurrentTimeMillis;
                            bArr5 = bArr2;
                            bArr4 = bArr6;
                            SecureRandom secureRandom6 = secureRandomLookupSecureRandom;
                            arrayList3 = arrayList;
                            i2 = 0;
                            secureRandom4 = secureRandom;
                            secureRandom5 = secureRandom6;
                        } else {
                            secureRandom.setSeed(bArr);
                            List listShuffled2 = CollectionsKt__CollectionsJVMKt.shuffled(kotlin.collections.CollectionsKt.plus((Collection) StringsKt___StringsKt.chunked(CryptoKt.hex(bArr2), 16), (Iterable) arrayList), secureRandom);
                            byte[] bArr7 = bArr;
                            list2 = listShuffled2;
                            size = listShuffled2.size() / 2;
                            j3 = j;
                            bArr5 = bArr2;
                            bArr4 = bArr7;
                            SecureRandom secureRandom7 = secureRandomLookupSecureRandom;
                            arrayList3 = arrayList;
                            i2 = 0;
                            secureRandom4 = secureRandom;
                            secureRandom5 = secureRandom7;
                        }
                        if (i2 >= size) {
                        }
                    }
                }
            } catch (Throwable th) {
                try {
                    channel.close(th);
                    SendChannel.close$default(channel, null, 1, null);
                    return Unit.INSTANCE;
                } catch (Throwable th2) {
                    SendChannel.close$default(channel, null, 1, null);
                    throw th2;
                }
            }
        }
    }
}
