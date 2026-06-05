package io.ktor.client.plugins.internal;

import io.ktor.client.plugins.internal.ByteChannelReplay;
import io.ktor.utils.io.WriterScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.internal.ByteChannelReplay$CopyFromSourceTask$receiveBody$1", f = "ByteChannelReplay.kt", l = {59, 60, 64, 65}, m = "invokeSuspend")
public final class ByteChannelReplay$CopyFromSourceTask$receiveBody$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ByteChannelReplay this$0;
    final /* synthetic */ ByteChannelReplay.CopyFromSourceTask this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteChannelReplay$CopyFromSourceTask$receiveBody$1(ByteChannelReplay byteChannelReplay, ByteChannelReplay.CopyFromSourceTask copyFromSourceTask, Continuation<? super ByteChannelReplay$CopyFromSourceTask$receiveBody$1> continuation) {
        super(2, continuation);
        this.this$0 = byteChannelReplay;
        this.this$1 = copyFromSourceTask;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ByteChannelReplay$CopyFromSourceTask$receiveBody$1 byteChannelReplay$CopyFromSourceTask$receiveBody$1 = new ByteChannelReplay$CopyFromSourceTask$receiveBody$1(this.this$0, this.this$1, continuation);
        byteChannelReplay$CopyFromSourceTask$receiveBody$1.L$0 = obj;
        return byteChannelReplay$CopyFromSourceTask$receiveBody$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ByteChannelReplay$CopyFromSourceTask$receiveBody$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 7, insn: 0x0111: INVOKE (r7 I:kotlinx.io.RawSink) INTERFACE call: kotlinx.io.RawSink.close():void A[MD:():void (m)] (LINE:274), block:B:52:0x0111 */
    /* JADX WARN: Path cross not found for [B:30:0x0080, B:33:0x0096], limit reached: 54 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004c A[PHI: r1 r7 r11
      0x004c: PHI (r1v2 io.ktor.utils.io.WriterScope) = (r1v5 io.ktor.utils.io.WriterScope), (r1v16 io.ktor.utils.io.WriterScope) binds: [B:34:0x00b2, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r7v2 kotlinx.io.Sink) = (r7v3 kotlinx.io.Sink), (r7v10 kotlinx.io.Sink) binds: [B:34:0x00b2, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x004c: PHI (r11v4 java.lang.Object) = (r11v11 java.lang.Object), (r11v0 java.lang.Object) binds: [B:34:0x00b2, B:19:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0076 A[Catch: all -> 0x0026, TRY_ENTER, TryCatch #1 {all -> 0x0026, blocks: (B:9:0x0021, B:45:0x00ec, B:25:0x0068, B:28:0x0076, B:30:0x0080, B:33:0x0096, B:36:0x00b5, B:37:0x00b8, B:39:0x00c2, B:42:0x00d9, B:46:0x00f2, B:48:0x00fc, B:51:0x0110, B:16:0x003b, B:19:0x0049, B:22:0x0057), top: B:55:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c2 A[Catch: all -> 0x0026, Exception -> 0x00ec, TryCatch #0 {Exception -> 0x00ec, blocks: (B:9:0x0021, B:37:0x00b8, B:39:0x00c2, B:42:0x00d9, B:16:0x003b), top: B:55:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2 A[Catch: all -> 0x0026, TryCatch #1 {all -> 0x0026, blocks: (B:9:0x0021, B:45:0x00ec, B:25:0x0068, B:28:0x0076, B:30:0x0080, B:33:0x0096, B:36:0x00b5, B:37:0x00b8, B:39:0x00c2, B:42:0x00d9, B:46:0x00f2, B:48:0x00fc, B:51:0x0110, B:16:0x003b, B:19:0x0049, B:22:0x0057), top: B:55:0x000b }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v20, types: [kotlinx.io.Source] */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object, kotlinx.io.Source] */
    /* JADX WARN: Type inference failed for: r1v7, types: [kotlinx.io.Source] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00c0 -> B:45:0x00ec). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00e9 -> B:45:0x00ec). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:54:0x00ec
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.internal.ByteChannelReplay$CopyFromSourceTask$receiveBody$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
