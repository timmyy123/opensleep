package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.media.AudioTrack;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import androidx.work.impl.WorkerWrapper$$ExternalSyntheticLambda1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.FirebaseApp;
import com.google.firebase.ai.common.APIControllerKt;
import com.google.firebase.ai.common.util.KotlinKt;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.FirebaseAIException;
import com.google.firebase.ai.type.FunctionResponsePart;
import com.google.firebase.ai.type.InlineData;
import com.google.firebase.ai.type.LiveAudioConversationConfig;
import com.google.firebase.annotations.concurrent.Blocking;
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.time.Duration;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0007\u0018\u0000 P2\u00020\u0001:\u0004MNOPB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017H\u0087@¢\u0006\u0002\u0010\u001aJ0\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010\u001dJR\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001f2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010!Jj\u0010\u0014\u001a\u00020\u00152\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172 \b\u0002\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001f2\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0087@¢\u0006\u0002\u0010$J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010%\u001a\u00020&H\u0087@¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u001cJ\u0006\u0010*\u001a\u00020\u001cJ\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J\u0006\u0010.\u001a\u00020\u0015J\u001c\u0010/\u001a\u00020\u00152\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001901H\u0086@¢\u0006\u0002\u00102J\u0016\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u000205H\u0086@¢\u0006\u0002\u00106J\u0016\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u000205H\u0086@¢\u0006\u0002\u00106J\u0016\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;H\u0086@¢\u0006\u0002\u0010<J\u001c\u0010=\u001a\u00020\u00152\f\u0010>\u001a\b\u0012\u0004\u0012\u00020?01H\u0087@¢\u0006\u0002\u00102J\u0016\u0010@\u001a\u00020\u00152\u0006\u0010A\u001a\u00020BH\u0086@¢\u0006\u0002\u0010CJ\u001e\u0010D\u001a\u00020\u0015\"\u0006\b\u0000\u0010E\u0018\u00012\u0006\u0010F\u001a\u0002HEH\u0082H¢\u0006\u0002\u0010GJ\u0016\u0010@\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;H\u0086@¢\u0006\u0002\u0010<J\u000e\u0010H\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010IJ\b\u0010J\u001a\u00020\u0015H\u0002JT\u0010K\u001a\u00020\u00152\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00172\u001e\u0010\u001e\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001f2\u0014\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017H\u0002J\u0012\u0010L\u001a\u00020\u00152\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession;", "", "session", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "blockingDispatcher", "Lkotlin/coroutines/CoroutineContext;", "audioHelper", "Lcom/google/firebase/ai/type/AudioHelper;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "<init>", "(Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/ai/type/AudioHelper;Lcom/google/firebase/FirebaseApp;)V", "networkScope", "Lkotlinx/coroutines/CoroutineScope;", "audioScope", "playBackQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "", "startedReceiving", "Ljava/util/concurrent/atomic/AtomicBoolean;", "startAudioConversation", "", "functionCallHandler", "Lkotlin/Function1;", "Lcom/google/firebase/ai/type/FunctionCallPart;", "Lcom/google/firebase/ai/type/FunctionResponsePart;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enableInterruptions", "", "(Lkotlin/jvm/functions/Function1;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transcriptHandler", "Lkotlin/Function2;", "Lcom/google/firebase/ai/type/Transcription;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goAwayHandler", "Lcom/google/firebase/ai/type/LiveServerGoAway;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "liveAudioConversationConfig", "Lcom/google/firebase/ai/type/LiveAudioConversationConfig;", "(Lcom/google/firebase/ai/type/LiveAudioConversationConfig;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stopAudioConversation", "isClosed", "isAudioConversationActive", "receive", "Lkotlinx/coroutines/flow/Flow;", "Lcom/google/firebase/ai/type/LiveServerMessage;", "stopReceiving", "sendFunctionResponse", "functionList", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendAudioRealtime", "audio", "Lcom/google/firebase/ai/type/InlineData;", "(Lcom/google/firebase/ai/type/InlineData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendVideoRealtime", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "sendTextRealtime", "text", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMediaStream", "mediaChunks", "Lcom/google/firebase/ai/type/MediaData;", "send", "content", "Lcom/google/firebase/ai/type/Content;", "(Lcom/google/firebase/ai/type/Content;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendFrame", "T", "data", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "close", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordUserAudio", "processModelResponses", "listenForModelPlayback", "BidiGenerateContentClientContentSetup", "BidiGenerateContentToolResponseSetup", "BidiGenerateContentRealtimeInputSetup", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveSession {
    private static final ExecutorCoroutineDispatcher audioDispatcher;
    private AudioHelper audioHelper;
    private CoroutineScope audioScope;
    private final CoroutineContext blockingDispatcher;
    private final FirebaseApp firebaseApp;
    private CoroutineScope networkScope;
    private final ConcurrentLinkedQueue<byte[]> playBackQueue;
    private final DefaultClientWebSocketSession session;
    private final AtomicBoolean startedReceiving;
    private static final Companion Companion = new Companion(null);
    private static final String TAG = "LiveSession";
    private static final int MIN_BUFFER_SIZE = AudioTrack.getMinBufferSize(24000, 4, 2);

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$Companion;", "", "<init>", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "Ljava/lang/String;", "MIN_BUFFER_SIZE", "", "getMIN_BUFFER_SIZE", "()I", "audioDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getAudioDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecutorCoroutineDispatcher getAudioDispatcher() {
            return LiveSession.audioDispatcher;
        }

        public final int getMIN_BUFFER_SIZE() {
            return LiveSession.MIN_BUFFER_SIZE;
        }

        public final String getTAG() {
            return LiveSession.TAG;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$close$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$close$2", f = "LiveSession.kt", l = {486}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LiveSession.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DefaultClientWebSocketSession defaultClientWebSocketSession = LiveSession.this.session;
                this.label = 1;
                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, this, 1, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            LiveSession.this.stopAudioConversation();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$listenForModelPlayback$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$listenForModelPlayback$1", f = "LiveSession.kt", l = {605}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enableInterruptions;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$enableInterruptions = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = LiveSession.this.new AnonymousClass1(this.$enableInterruptions, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            AudioHelper audioHelper;
            AudioHelper audioHelper2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                byte[] bArr = (byte[]) LiveSession.this.playBackQueue.poll();
                boolean z = this.$enableInterruptions;
                if (bArr == null) {
                    if (!z && (audioHelper = LiveSession.this.audioHelper) != null) {
                        audioHelper.resumeRecording();
                    }
                    this.L$0 = coroutineScope;
                    this.label = 1;
                    if (DelayKt.delay(0L, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (!z && (audioHelper2 = LiveSession.this.audioHelper) != null) {
                        audioHelper2.pauseRecording();
                    }
                    AudioHelper audioHelper3 = LiveSession.this.audioHelper;
                    if (audioHelper3 != null) {
                        audioHelper3.playAudio(bArr);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$processModelResponses$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/google/firebase/ai/type/LiveServerMessage;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$processModelResponses$1", f = "LiveSession.kt", l = {540}, m = "invokeSuspend")
    public static final class C20581 extends SuspendLambda implements Function2<LiveServerMessage, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<FunctionCallPart, FunctionResponsePart> $functionCallHandler;
        final /* synthetic */ Function1<LiveServerGoAway, Unit> $goAwayHandler;
        final /* synthetic */ Function2<Transcription, Transcription, Unit> $transcriptHandler;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LiveSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C20581(Function1<? super FunctionCallPart, FunctionResponsePart> function1, LiveSession liveSession, Function2<? super Transcription, ? super Transcription, Unit> function2, Function1<? super LiveServerGoAway, Unit> function12, Continuation<? super C20581> continuation) {
            super(2, continuation);
            this.$functionCallHandler = function1;
            this.this$0 = liveSession;
            this.$transcriptHandler = function2;
            this.$goAwayHandler = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C20581 c20581 = new C20581(this.$functionCallHandler, this.this$0, this.$transcriptHandler, this.$goAwayHandler, continuation);
            c20581.L$0 = obj;
            return c20581;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(LiveServerMessage liveServerMessage, Continuation<? super Unit> continuation) {
            return ((C20581) create(liveServerMessage, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v6, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r2v8 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Function2<Transcription, Transcription, Unit> function2;
            List<Part> parts;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            List listEmptyList = 0;
            listEmptyList = 0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LiveServerMessage liveServerMessage = (LiveServerMessage) this.L$0;
                if (liveServerMessage instanceof LiveServerToolCall) {
                    LiveServerToolCall liveServerToolCall = (LiveServerToolCall) liveServerMessage;
                    if (liveServerToolCall.getFunctionCalls().isEmpty()) {
                        Boxing.boxInt(Log.w(LiveSession.Companion.getTAG(), "The model sent a tool call request, but it was missing functions to call."));
                    } else if (this.$functionCallHandler != null) {
                        LiveSession liveSession = this.this$0;
                        List<FunctionCallPart> functionCalls = liveServerToolCall.getFunctionCalls();
                        Function1<FunctionCallPart, FunctionResponsePart> function1 = this.$functionCallHandler;
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(functionCalls, 10));
                        Iterator<T> it = functionCalls.iterator();
                        while (it.hasNext()) {
                            arrayList.add(function1.invoke((FunctionCallPart) it.next()));
                        }
                        List<FunctionResponsePart> list = CollectionsKt.toList(arrayList);
                        this.label = 1;
                        if (liveSession.sendFunctionResponse(list, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        Boxing.boxInt(Log.w(LiveSession.Companion.getTAG(), "Function calls were present in the response, but a functionCallHandler was not provided."));
                    }
                } else if (liveServerMessage instanceof LiveServerToolCallCancellation) {
                    Log.w(LiveSession.Companion.getTAG(), "The model sent a tool cancellation request, but tool cancellation is not supported when using startAudioConversation().");
                } else if (liveServerMessage instanceof LiveServerContent) {
                    LiveServerContent liveServerContent = (LiveServerContent) liveServerMessage;
                    if ((liveServerContent.getInputTranscription() != null || liveServerContent.getOutputTranscription() != null) && (function2 = this.$transcriptHandler) != null) {
                        function2.invoke(liveServerContent.getInputTranscription(), liveServerContent.getOutputTranscription());
                    }
                    if (liveServerContent.getInterrupted()) {
                        this.this$0.playBackQueue.clear();
                    } else {
                        Content content = liveServerContent.getContent();
                        if (content != null && (parts = content.getParts()) != null) {
                            listEmptyList = new ArrayList();
                            for (Object obj2 : parts) {
                                if (obj2 instanceof InlineDataPart) {
                                    listEmptyList.add(obj2);
                                }
                            }
                        }
                        if (listEmptyList == 0) {
                            listEmptyList = CollectionsKt.emptyList();
                        }
                        Iterator it2 = listEmptyList.iterator();
                        while (it2.hasNext()) {
                            this.this$0.playBackQueue.add(((InlineDataPart) it2.next()).getInlineData());
                        }
                    }
                } else if (liveServerMessage instanceof LiveServerSetupComplete) {
                    Log.w(LiveSession.Companion.getTAG(), "The model sent LiveServerSetupComplete after the connection was established.");
                } else if (liveServerMessage instanceof LiveServerGoAway) {
                    Duration durationM403getTimeLeftFghU774 = ((LiveServerGoAway) liveServerMessage).getTimeLeft();
                    Log.i(LiveSession.Companion.getTAG(), "Server initiated disconnect".concat(durationM403getTimeLeftFghU774 != null ? " (time left: " + ((Object) Duration.m2554toStringimpl(durationM403getTimeLeftFghU774.getRawValue())) + ')' : ""));
                    Function1<LiveServerGoAway, Unit> function12 = this.$goAwayHandler;
                    if (function12 != null) {
                        function12.invoke((LiveServerGoAway) liveServerMessage);
                    }
                }
                return Unit.INSTANCE;
            }
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Unit unit = Unit.INSTANCE;
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$recordUserAudio$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$recordUserAudio$1", f = "LiveSession.kt", l = {500, 503}, m = "invokeSuspend")
    public static final class C20591 extends SuspendLambda implements Function2<byte[], Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C20591(Continuation<? super C20591> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C20591 c20591 = LiveSession.this.new C20591(continuation);
            c20591.L$0 = obj;
            return c20591;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(byte[] bArr, Continuation<? super Unit> continuation) {
            return ((C20591) create(bArr, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(0, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                byte[] bArr = (byte[]) this.L$0;
                LiveSession liveSession = LiveSession.this;
                InlineData inlineData = new InlineData(bArr, "audio/pcm");
                this.label = 1;
                if (liveSession.sendAudioRealtime(inlineData, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$recordUserAudio$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$recordUserAudio$2", f = "LiveSession.kt", l = {}, m = "invokeSuspend")
    public static final class C20602 extends SuspendLambda implements Function3<FlowCollector<? super byte[]>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public C20602(Continuation<? super C20602> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(FlowCollector<? super byte[]> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
            C20602 c20602 = new C20602(continuation);
            c20602.L$0 = th;
            return c20602.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            throw FirebaseAIException.INSTANCE.from$com_google_firebase_ai_logic_firebase_ai((Throwable) this.L$0);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$send$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$send$3", f = "LiveSession.kt", l = {473}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ String $text;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str, Continuation<? super AnonymousClass3> continuation) {
            super(1, continuation);
            this.$text = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LiveSession.this.new AnonymousClass3(this.$text, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LiveSession liveSession = LiveSession.this;
                Content contentBuild = new Content.Builder().addText(this.$text).build();
                this.label = 1;
                if (liveSession.send(contentBuild, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$sendFrame$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$sendFrame$2", f = "LiveSession.kt", l = {462}, m = "invokeSuspend")
    public static final class C20612 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ T $data;
        int label;
        final /* synthetic */ LiveSession this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C20612(T t, LiveSession liveSession, Continuation<? super C20612> continuation) {
            super(1, continuation);
            this.$data = t;
            this.this$0 = liveSession;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C20612(this.$data, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((C20612) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Json json = APIControllerKt.getJSON();
                T t = this.$data;
                SerializersModule serializersModule = json.getSerializersModule();
                Intrinsics.reifiedOperationMarker(6, "T");
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                String strEncodeToString = json.encodeToString(SerializersKt.serializer(serializersModule, null), t);
                DefaultClientWebSocketSession defaultClientWebSocketSession = this.this$0.session;
                Frame.Text text = new Frame.Text(strEncodeToString);
                this.label = 1;
                if (defaultClientWebSocketSession.send(text, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.ai.type.LiveSession$startAudioConversation$8, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.type.LiveSession$startAudioConversation$8", f = "LiveSession.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass8 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        final /* synthetic */ LiveAudioConversationConfig $liveAudioConversationConfig;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(LiveAudioConversationConfig liveAudioConversationConfig, Continuation<? super AnonymousClass8> continuation) {
            super(1, continuation);
            this.$liveAudioConversationConfig = liveAudioConversationConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return LiveSession.this.new AnonymousClass8(this.$liveAudioConversationConfig, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            if (CoroutineScopeKt.isActive(LiveSession.this.networkScope) || CoroutineScopeKt.isActive(LiveSession.this.audioScope)) {
                Log.w(LiveSession.Companion.getTAG(), "startAudioConversation called after the recording has already started. Call stopAudioConversation to close the previous connection.");
                return Unit.INSTANCE;
            }
            LiveSession liveSession = LiveSession.this;
            CoroutineContext coroutineContext = liveSession.blockingDispatcher;
            CoroutineContext context = getContext();
            Job.Companion companion = Job.INSTANCE;
            Job jobJob$default = (Job) context.get(companion);
            if (jobJob$default == null) {
                jobJob$default = JobKt__JobKt.Job$default(null, 1, null);
            }
            liveSession.networkScope = CoroutineScopeKt.CoroutineScope(coroutineContext.plus(JobKt.Job(jobJob$default)).plus(new CoroutineName("LiveSession Network")));
            LiveSession liveSession2 = LiveSession.this;
            ExecutorCoroutineDispatcher audioDispatcher = LiveSession.Companion.getAudioDispatcher();
            Job jobJob$default2 = (Job) getContext().get(companion);
            if (jobJob$default2 == null) {
                jobJob$default2 = JobKt__JobKt.Job$default(null, 1, null);
            }
            liveSession2.audioScope = CoroutineScopeKt.CoroutineScope(audioDispatcher.plus(JobKt.Job(jobJob$default2)).plus(new CoroutineName("LiveSession Audio")));
            LiveSession.this.audioHelper = AudioHelper.INSTANCE.build(this.$liveAudioConversationConfig.getInitializationHandler$com_google_firebase_ai_logic_firebase_ai());
            LiveSession.this.recordUserAudio();
            LiveSession.this.processModelResponses(this.$liveAudioConversationConfig.getFunctionCallHandler$com_google_firebase_ai_logic_firebase_ai(), this.$liveAudioConversationConfig.getTranscriptHandler$com_google_firebase_ai_logic_firebase_ai(), this.$liveAudioConversationConfig.getGoAwayHandler$com_google_firebase_ai_logic_firebase_ai());
            LiveSession.this.listenForModelPlayback(this.$liveAudioConversationConfig.getEnableInterruptions());
            return Unit.INSTANCE;
        }
    }

    static {
        ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool(new AudioThreadFactory());
        executorServiceNewCachedThreadPool.getClass();
        audioDispatcher = ExecutorsKt.from(executorServiceNewCachedThreadPool);
    }

    public LiveSession(DefaultClientWebSocketSession defaultClientWebSocketSession, @Blocking CoroutineContext coroutineContext, AudioHelper audioHelper, FirebaseApp firebaseApp) {
        defaultClientWebSocketSession.getClass();
        coroutineContext.getClass();
        firebaseApp.getClass();
        this.session = defaultClientWebSocketSession;
        this.blockingDispatcher = coroutineContext;
        this.audioHelper = audioHelper;
        this.firebaseApp = firebaseApp;
        this.networkScope = KotlinKt.getCancelledCoroutineScope();
        this.audioScope = KotlinKt.getCancelledCoroutineScope();
        this.playBackQueue = new ConcurrentLinkedQueue<>();
        this.startedReceiving = new AtomicBoolean(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void listenForModelPlayback(boolean enableInterruptions) {
        BuildersKt__Builders_commonKt.launch$default(this.audioScope, null, null, new AnonymousClass1(enableInterruptions, null), 3, null);
    }

    public static /* synthetic */ void listenForModelPlayback$default(LiveSession liveSession, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        liveSession.listenForModelPlayback(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void processModelResponses(Function1<? super FunctionCallPart, FunctionResponsePart> functionCallHandler, Function2<? super Transcription, ? super Transcription, Unit> transcriptHandler, Function1<? super LiveServerGoAway, Unit> goAwayHandler) {
        FlowKt.launchIn(FlowKt.onEach(receive(), new C20581(functionCallHandler, this, transcriptHandler, goAwayHandler, null)), this.networkScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow receive$lambda$3(LiveSession liveSession) {
        if (liveSession.startedReceiving.getAndSet(true)) {
            throw new SessionAlreadyReceivingException();
        }
        return FlowKt.m2600catch(FlowKt.onCompletion(FlowKt.flow(new LiveSession$receive$1$1(liveSession, null)), new LiveSession$receive$1$2(liveSession, null)), new LiveSession$receive$1$3(null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordUserAudio() {
        Flow<byte[]> flowListenToRecording;
        Flow flowBuffer$default;
        Flow flowFlowOn;
        Flow flowAccumulateUntil$default;
        Flow flowOnEach;
        Flow flowM2600catch;
        AudioHelper audioHelper = this.audioHelper;
        if (audioHelper == null || (flowListenToRecording = audioHelper.listenToRecording()) == null || (flowBuffer$default = FlowKt__ContextKt.buffer$default(flowListenToRecording, Integer.MAX_VALUE, null, 2, null)) == null || (flowFlowOn = FlowKt.flowOn(flowBuffer$default, audioDispatcher)) == null || (flowAccumulateUntil$default = KotlinKt.accumulateUntil$default(flowFlowOn, MIN_BUFFER_SIZE, false, 2, null)) == null || (flowOnEach = FlowKt.onEach(flowAccumulateUntil$default, new C20591(null))) == null || (flowM2600catch = FlowKt.m2600catch(flowOnEach, new C20602(null))) == null) {
            return;
        }
        FlowKt.launchIn(flowM2600catch, this.networkScope);
    }

    private final /* synthetic */ <T> Object sendFrame(T t, Continuation<? super Unit> continuation) {
        FirebaseAIException.Companion companion = FirebaseAIException.INSTANCE;
        Intrinsics.needClassReification();
        C20612 c20612 = new C20612(t, this, null);
        InlineMarker.mark(0);
        companion.catchAsync$com_google_firebase_ai_logic_firebase_ai(c20612, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object startAudioConversation$default(LiveSession liveSession, Function1 function1, Function2 function2, Function1 function12, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return liveSession.startAudioConversation(function1, function2, function12, z, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startAudioConversation$lambda$0(Function1 function1, Function2 function2, boolean z, LiveAudioConversationConfig.Builder builder) {
        builder.getClass();
        builder.functionCallHandler = function1;
        builder.transcriptHandler = function2;
        builder.goAwayHandler = null;
        builder.enableInterruptions = z;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startAudioConversation$lambda$1(Function1 function1, Function2 function2, Function1 function12, boolean z, LiveAudioConversationConfig.Builder builder) {
        builder.getClass();
        builder.functionCallHandler = function1;
        builder.transcriptHandler = function2;
        builder.goAwayHandler = function12;
        builder.enableInterruptions = z;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopAudioConversation$lambda$2(LiveSession liveSession) {
        if (!liveSession.startedReceiving.getAndSet(false)) {
            return Unit.INSTANCE;
        }
        CoroutineScopeKt.cancel$default(liveSession.networkScope, null, 1, null);
        CoroutineScopeKt.cancel$default(liveSession.audioScope, null, 1, null);
        liveSession.playBackQueue.clear();
        AudioHelper audioHelper = liveSession.audioHelper;
        if (audioHelper != null) {
            audioHelper.release();
        }
        liveSession.audioHelper = null;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopReceiving$lambda$4(LiveSession liveSession) {
        if (!liveSession.startedReceiving.getAndSet(false)) {
            return Unit.INSTANCE;
        }
        CoroutineScopeKt.cancel$default(liveSession.networkScope, null, 1, null);
        CoroutineScopeKt.cancel$default(liveSession.audioScope, null, 1, null);
        liveSession.playBackQueue.clear();
        AudioHelper audioHelper = liveSession.audioHelper;
        if (audioHelper != null) {
            audioHelper.release();
        }
        liveSession.audioHelper = null;
        return Unit.INSTANCE;
    }

    public final Object close(Continuation<? super Unit> continuation) {
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new AnonymousClass2(null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final boolean isAudioConversationActive() {
        return this.audioHelper != null;
    }

    public final boolean isClosed() {
        return !CoroutineScopeKt.isActive(this.session) || ChannelResult.m2590isClosedimpl(this.session.getIncoming().mo2580tryReceivePtdJZtk());
    }

    public final Flow<LiveServerMessage> receive() {
        return (Flow) FirebaseAIException.INSTANCE.catch$com_google_firebase_ai_logic_firebase_ai(new LiveSession$$ExternalSyntheticLambda1(this, 2));
    }

    public final Object send(Content content, Continuation<? super Unit> continuation) {
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new LiveSession$send$$inlined$sendFrame$1(new BidiGenerateContentClientContentSetup(CollectionsKt.listOf(content.toInternal$com_google_firebase_ai_logic_firebase_ai()), true).toInternal(), this, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final Object sendAudioRealtime(InlineData inlineData, Continuation<? super Unit> continuation) {
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new LiveSession$sendAudioRealtime$$inlined$sendFrame$1(new BidiGenerateContentRealtimeInputSetup(null, inlineData, null, null, 13, null).toInternal(), this, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final Object sendFunctionResponse(List<FunctionResponsePart> list, Continuation<? super Unit> continuation) {
        List<FunctionResponsePart> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(((FunctionResponsePart) it.next()).toInternalFunctionResponse$com_google_firebase_ai_logic_firebase_ai());
        }
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new LiveSession$sendFunctionResponse$$inlined$sendFrame$1(new BidiGenerateContentToolResponseSetup(arrayList).toInternal(), this, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final Object sendMediaStream(List<MediaData> list, Continuation<? super Unit> continuation) {
        List<MediaData> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (MediaData mediaData : list2) {
            arrayList.add(new InlineData(mediaData.getData(), mediaData.getMimeType()));
        }
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new LiveSession$sendMediaStream$$inlined$sendFrame$1(new BidiGenerateContentRealtimeInputSetup(arrayList, null, null, null, 14, null).toInternal(), this, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final Object sendTextRealtime(String str, Continuation<? super Unit> continuation) {
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new LiveSession$sendTextRealtime$$inlined$sendFrame$1(new BidiGenerateContentRealtimeInputSetup(null, null, null, str, 7, null).toInternal(), this, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final Object sendVideoRealtime(InlineData inlineData, Continuation<? super Unit> continuation) {
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new LiveSession$sendVideoRealtime$$inlined$sendFrame$1(new BidiGenerateContentRealtimeInputSetup(null, null, inlineData, null, 11, null).toInternal(), this, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object startAudioConversation(LiveAudioConversationConfig liveAudioConversationConfig, Continuation<? super Unit> continuation) {
        Context applicationContext = this.firebaseApp.getApplicationContext();
        applicationContext.getClass();
        Throwable th = null;
        Object[] objArr = 0;
        if (ContextCompat.checkSelfPermission(applicationContext, "android.permission.RECORD_AUDIO") != 0) {
            throw new PermissionMissingException("Audio access not provided by the user", th, 2, objArr == true ? 1 : 0);
        }
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new AnonymousClass8(liveAudioConversationConfig, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public final void stopAudioConversation() {
        FirebaseAIException.INSTANCE.catch$com_google_firebase_ai_logic_firebase_ai(new LiveSession$$ExternalSyntheticLambda1(this, 0));
    }

    public final void stopReceiving() {
        FirebaseAIException.INSTANCE.catch$com_google_firebase_ai_logic_firebase_ai(new LiveSession$$ExternalSyntheticLambda1(this, 1));
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000bB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\t\u001a\u00020\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup;", "", "functionResponses", "", "Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "<init>", "(Ljava/util/List;)V", "getFunctionResponses", "()Ljava/util/List;", "toInternal", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BidiGenerateContentToolResponseSetup {
        private final List<FunctionResponsePart.Internal.FunctionResponse> functionResponses;

        public BidiGenerateContentToolResponseSetup(List<FunctionResponsePart.Internal.FunctionResponse> list) {
            list.getClass();
            this.functionResponses = list;
        }

        public final List<FunctionResponsePart.Internal.FunctionResponse> getFunctionResponses() {
            return this.functionResponses;
        }

        public final Internal toInternal() {
            return new Internal(new Internal.BidiGenerateContentToolResponse(this.functionResponses));
        }

        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006 "}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal;", "", "toolResponse", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse;", "<init>", "(Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getToolResponse", "()Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "BidiGenerateContentToolResponse", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Internal {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final BidiGenerateContentToolResponse toolResponse;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Internal> serializer() {
                    return LiveSession$BidiGenerateContentToolResponseSetup$Internal$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Internal(int i, BidiGenerateContentToolResponse bidiGenerateContentToolResponse, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, LiveSession$BidiGenerateContentToolResponseSetup$Internal$$serializer.INSTANCE.getDescriptor());
                }
                this.toolResponse = bidiGenerateContentToolResponse;
            }

            public static /* synthetic */ Internal copy$default(Internal internal, BidiGenerateContentToolResponse bidiGenerateContentToolResponse, int i, Object obj) {
                if ((i & 1) != 0) {
                    bidiGenerateContentToolResponse = internal.toolResponse;
                }
                return internal.copy(bidiGenerateContentToolResponse);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final BidiGenerateContentToolResponse getToolResponse() {
                return this.toolResponse;
            }

            public final Internal copy(BidiGenerateContentToolResponse toolResponse) {
                toolResponse.getClass();
                return new Internal(toolResponse);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Internal) && Intrinsics.areEqual(this.toolResponse, ((Internal) other).toolResponse);
            }

            public final BidiGenerateContentToolResponse getToolResponse() {
                return this.toolResponse;
            }

            public int hashCode() {
                return this.toolResponse.hashCode();
            }

            public String toString() {
                return "Internal(toolResponse=" + this.toolResponse + ')';
            }

            @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\bHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J%\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0001¢\u0006\u0002\b\u001dR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006 "}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse;", "", "functionResponses", "", "Lcom/google/firebase/ai/type/FunctionResponsePart$Internal$FunctionResponse;", "<init>", "(Ljava/util/List;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getFunctionResponses", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            @Serializable
            public static final /* data */ class BidiGenerateContentToolResponse {
                private final List<FunctionResponsePart.Internal.FunctionResponse> functionResponses;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(FunctionResponsePart$Internal$FunctionResponse$$serializer.INSTANCE)};

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    public final KSerializer<BidiGenerateContentToolResponse> serializer() {
                        return LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse$$serializer.INSTANCE;
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                public /* synthetic */ BidiGenerateContentToolResponse(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
                    if (1 != (i & 1)) {
                        PluginExceptionsKt.throwMissingFieldException(i, 1, LiveSession$BidiGenerateContentToolResponseSetup$Internal$BidiGenerateContentToolResponse$$serializer.INSTANCE.getDescriptor());
                    }
                    this.functionResponses = list;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ BidiGenerateContentToolResponse copy$default(BidiGenerateContentToolResponse bidiGenerateContentToolResponse, List list, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = bidiGenerateContentToolResponse.functionResponses;
                    }
                    return bidiGenerateContentToolResponse.copy(list);
                }

                public final List<FunctionResponsePart.Internal.FunctionResponse> component1() {
                    return this.functionResponses;
                }

                public final BidiGenerateContentToolResponse copy(List<FunctionResponsePart.Internal.FunctionResponse> functionResponses) {
                    functionResponses.getClass();
                    return new BidiGenerateContentToolResponse(functionResponses);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    return (other instanceof BidiGenerateContentToolResponse) && Intrinsics.areEqual(this.functionResponses, ((BidiGenerateContentToolResponse) other).functionResponses);
                }

                public final List<FunctionResponsePart.Internal.FunctionResponse> getFunctionResponses() {
                    return this.functionResponses;
                }

                public int hashCode() {
                    return this.functionResponses.hashCode();
                }

                public String toString() {
                    return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder("BidiGenerateContentToolResponse(functionResponses="), (List) this.functionResponses, ')');
                }

                public BidiGenerateContentToolResponse(List<FunctionResponsePart.Internal.FunctionResponse> list) {
                    list.getClass();
                    this.functionResponses = list;
                }
            }

            public Internal(BidiGenerateContentToolResponse bidiGenerateContentToolResponse) {
                bidiGenerateContentToolResponse.getClass();
                this.toolResponse = bidiGenerateContentToolResponse;
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u000fB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup;", "", "turns", "", "Lcom/google/firebase/ai/type/Content$Internal;", "turnComplete", "", "<init>", "(Ljava/util/List;Z)V", "getTurns", "()Ljava/util/List;", "getTurnComplete", "()Z", "toInternal", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BidiGenerateContentClientContentSetup {
        private final boolean turnComplete;
        private final List<Content.Internal> turns;

        public BidiGenerateContentClientContentSetup(List<Content.Internal> list, boolean z) {
            list.getClass();
            this.turns = list;
            this.turnComplete = z;
        }

        public final boolean getTurnComplete() {
            return this.turnComplete;
        }

        public final List<Content.Internal> getTurns() {
            return this.turns;
        }

        public final Internal toInternal() {
            return new Internal(new Internal.BidiGenerateContentClientContent(this.turns, this.turnComplete));
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal;", "", "clientContent", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent;", "<init>", "(Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getClientContent", "()Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "BidiGenerateContentClientContent", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final class Internal {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final BidiGenerateContentClientContent clientContent;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Internal> serializer() {
                    return LiveSession$BidiGenerateContentClientContentSetup$Internal$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Internal(int i, BidiGenerateContentClientContent bidiGenerateContentClientContent, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, LiveSession$BidiGenerateContentClientContentSetup$Internal$$serializer.INSTANCE.getDescriptor());
                }
                this.clientContent = bidiGenerateContentClientContent;
            }

            public final BidiGenerateContentClientContent getClientContent() {
                return this.clientContent;
            }

            public Internal(BidiGenerateContentClientContent bidiGenerateContentClientContent) {
                bidiGenerateContentClientContent.getClass();
                this.clientContent = bidiGenerateContentClientContent;
            }

            @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bB3\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J#\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\nHÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J%\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006$"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent;", "", "turns", "", "Lcom/google/firebase/ai/type/Content$Internal;", "turnComplete", "", "<init>", "(Ljava/util/List;Z)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTurns", "()Ljava/util/List;", "getTurnComplete", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            @Serializable
            public static final /* data */ class BidiGenerateContentClientContent {
                private final boolean turnComplete;
                private final List<Content.Internal> turns;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(Content$Internal$$serializer.INSTANCE), null};

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    public final KSerializer<BidiGenerateContentClientContent> serializer() {
                        return LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent$$serializer.INSTANCE;
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                public /* synthetic */ BidiGenerateContentClientContent(int i, List list, boolean z, SerializationConstructorMarker serializationConstructorMarker) {
                    if (3 != (i & 3)) {
                        PluginExceptionsKt.throwMissingFieldException(i, 3, LiveSession$BidiGenerateContentClientContentSetup$Internal$BidiGenerateContentClientContent$$serializer.INSTANCE.getDescriptor());
                    }
                    this.turns = list;
                    this.turnComplete = z;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ BidiGenerateContentClientContent copy$default(BidiGenerateContentClientContent bidiGenerateContentClientContent, List list, boolean z, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = bidiGenerateContentClientContent.turns;
                    }
                    if ((i & 2) != 0) {
                        z = bidiGenerateContentClientContent.turnComplete;
                    }
                    return bidiGenerateContentClientContent.copy(list, z);
                }

                public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(BidiGenerateContentClientContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    output.encodeSerializableElement(serialDesc, 0, $childSerializers[0], self.turns);
                    output.encodeBooleanElement(serialDesc, 1, self.turnComplete);
                }

                public final List<Content.Internal> component1() {
                    return this.turns;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final boolean getTurnComplete() {
                    return this.turnComplete;
                }

                public final BidiGenerateContentClientContent copy(List<Content.Internal> turns, boolean turnComplete) {
                    turns.getClass();
                    return new BidiGenerateContentClientContent(turns, turnComplete);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof BidiGenerateContentClientContent)) {
                        return false;
                    }
                    BidiGenerateContentClientContent bidiGenerateContentClientContent = (BidiGenerateContentClientContent) other;
                    return Intrinsics.areEqual(this.turns, bidiGenerateContentClientContent.turns) && this.turnComplete == bidiGenerateContentClientContent.turnComplete;
                }

                public final boolean getTurnComplete() {
                    return this.turnComplete;
                }

                public final List<Content.Internal> getTurns() {
                    return this.turns;
                }

                public int hashCode() {
                    return Boolean.hashCode(this.turnComplete) + (this.turns.hashCode() * 31);
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("BidiGenerateContentClientContent(turns=");
                    sb.append(this.turns);
                    sb.append(", turnComplete=");
                    return Fragment$$ExternalSyntheticOutline1.m(sb, this.turnComplete, ')');
                }

                public BidiGenerateContentClientContent(List<Content.Internal> list, boolean z) {
                    list.getClass();
                    this.turns = list;
                    this.turnComplete = z;
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001:\u0001\u0014B=\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup;", "", "mediaChunks", "", "Lcom/google/firebase/ai/type/InlineData;", "audio", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "text", "", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/type/InlineData;Lcom/google/firebase/ai/type/InlineData;Ljava/lang/String;)V", "getMediaChunks", "()Ljava/util/List;", "getAudio", "()Lcom/google/firebase/ai/type/InlineData;", "getVideo", "getText", "()Ljava/lang/String;", "toInternal", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class BidiGenerateContentRealtimeInputSetup {
        private final InlineData audio;
        private final List<InlineData> mediaChunks;
        private final String text;
        private final InlineData video;

        public /* synthetic */ BidiGenerateContentRealtimeInputSetup(List list, InlineData inlineData, InlineData inlineData2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : inlineData, (i & 4) != 0 ? null : inlineData2, (i & 8) != 0 ? null : str);
        }

        public final InlineData getAudio() {
            return this.audio;
        }

        public final List<InlineData> getMediaChunks() {
            return this.mediaChunks;
        }

        public final String getText() {
            return this.text;
        }

        public final InlineData getVideo() {
            return this.video;
        }

        public final Internal toInternal() {
            ArrayList arrayList;
            List<InlineData> list = this.mediaChunks;
            if (list != null) {
                List<InlineData> list2 = list;
                arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(((InlineData) it.next()).toInternal$com_google_firebase_ai_logic_firebase_ai());
                }
            } else {
                arrayList = null;
            }
            InlineData inlineData = this.audio;
            InlineData.Internal internal$com_google_firebase_ai_logic_firebase_ai = inlineData != null ? inlineData.toInternal$com_google_firebase_ai_logic_firebase_ai() : null;
            InlineData inlineData2 = this.video;
            return new Internal(new Internal.BidiGenerateContentRealtimeInput(arrayList, internal$com_google_firebase_ai_logic_firebase_ai, inlineData2 != null ? inlineData2.toInternal$com_google_firebase_ai_logic_firebase_ai() : null, this.text));
        }

        @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000 \u00172\u00020\u0001:\u0003\u0015\u0016\u0017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ%\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\b\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal;", "", "realtimeInput", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;", "<init>", "(Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getRealtimeInput", "()Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "BidiGenerateContentRealtimeInput", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final class Internal {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final BidiGenerateContentRealtimeInput realtimeInput;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Internal> serializer() {
                    return LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Internal(int i, BidiGenerateContentRealtimeInput bidiGenerateContentRealtimeInput, SerializationConstructorMarker serializationConstructorMarker) {
                if (1 != (i & 1)) {
                    PluginExceptionsKt.throwMissingFieldException(i, 1, LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$$serializer.INSTANCE.getDescriptor());
                }
                this.realtimeInput = bidiGenerateContentRealtimeInput;
            }

            public final BidiGenerateContentRealtimeInput getRealtimeInput() {
                return this.realtimeInput;
            }

            public Internal(BidiGenerateContentRealtimeInput bidiGenerateContentRealtimeInput) {
                bidiGenerateContentRealtimeInput.getClass();
                this.realtimeInput = bidiGenerateContentRealtimeInput;
            }

            @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 *2\u00020\u0001:\u0002)*B5\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u001b\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006+"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;", "", "mediaChunks", "", "Lcom/google/firebase/ai/type/InlineData$Internal;", "audio", AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, "text", "", "<init>", "(Ljava/util/List;Lcom/google/firebase/ai/type/InlineData$Internal;Lcom/google/firebase/ai/type/InlineData$Internal;Ljava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lcom/google/firebase/ai/type/InlineData$Internal;Lcom/google/firebase/ai/type/InlineData$Internal;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMediaChunks", "()Ljava/util/List;", "getAudio", "()Lcom/google/firebase/ai/type/InlineData$Internal;", "getVideo", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            @Serializable
            public static final /* data */ class BidiGenerateContentRealtimeInput {
                private final InlineData.Internal audio;
                private final List<InlineData.Internal> mediaChunks;
                private final String text;
                private final InlineData.Internal video;

                /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
                public static final Companion INSTANCE = new Companion(null);
                private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(InlineData$Internal$$serializer.INSTANCE), null, null, null};

                @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
                public static final class Companion {
                    private Companion() {
                    }

                    public final KSerializer<BidiGenerateContentRealtimeInput> serializer() {
                        return LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer.INSTANCE;
                    }

                    public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                        this();
                    }
                }

                public /* synthetic */ BidiGenerateContentRealtimeInput(int i, List list, InlineData.Internal internal, InlineData.Internal internal2, String str, SerializationConstructorMarker serializationConstructorMarker) {
                    if (15 != (i & 15)) {
                        PluginExceptionsKt.throwMissingFieldException(i, 15, LiveSession$BidiGenerateContentRealtimeInputSetup$Internal$BidiGenerateContentRealtimeInput$$serializer.INSTANCE.getDescriptor());
                    }
                    this.mediaChunks = list;
                    this.audio = internal;
                    this.video = internal2;
                    this.text = str;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ BidiGenerateContentRealtimeInput copy$default(BidiGenerateContentRealtimeInput bidiGenerateContentRealtimeInput, List list, InlineData.Internal internal, InlineData.Internal internal2, String str, int i, Object obj) {
                    if ((i & 1) != 0) {
                        list = bidiGenerateContentRealtimeInput.mediaChunks;
                    }
                    if ((i & 2) != 0) {
                        internal = bidiGenerateContentRealtimeInput.audio;
                    }
                    if ((i & 4) != 0) {
                        internal2 = bidiGenerateContentRealtimeInput.video;
                    }
                    if ((i & 8) != 0) {
                        str = bidiGenerateContentRealtimeInput.text;
                    }
                    return bidiGenerateContentRealtimeInput.copy(list, internal, internal2, str);
                }

                public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(BidiGenerateContentRealtimeInput self, CompositeEncoder output, SerialDescriptor serialDesc) {
                    output.encodeNullableSerializableElement(serialDesc, 0, $childSerializers[0], self.mediaChunks);
                    InlineData$Internal$$serializer inlineData$Internal$$serializer = InlineData$Internal$$serializer.INSTANCE;
                    output.encodeNullableSerializableElement(serialDesc, 1, inlineData$Internal$$serializer, self.audio);
                    output.encodeNullableSerializableElement(serialDesc, 2, inlineData$Internal$$serializer, self.video);
                    output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.text);
                }

                public final List<InlineData.Internal> component1() {
                    return this.mediaChunks;
                }

                /* JADX INFO: renamed from: component2, reason: from getter */
                public final InlineData.Internal getAudio() {
                    return this.audio;
                }

                /* JADX INFO: renamed from: component3, reason: from getter */
                public final InlineData.Internal getVideo() {
                    return this.video;
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final String getText() {
                    return this.text;
                }

                public final BidiGenerateContentRealtimeInput copy(List<InlineData.Internal> mediaChunks, InlineData.Internal audio, InlineData.Internal video, String text) {
                    return new BidiGenerateContentRealtimeInput(mediaChunks, audio, video, text);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof BidiGenerateContentRealtimeInput)) {
                        return false;
                    }
                    BidiGenerateContentRealtimeInput bidiGenerateContentRealtimeInput = (BidiGenerateContentRealtimeInput) other;
                    return Intrinsics.areEqual(this.mediaChunks, bidiGenerateContentRealtimeInput.mediaChunks) && Intrinsics.areEqual(this.audio, bidiGenerateContentRealtimeInput.audio) && Intrinsics.areEqual(this.video, bidiGenerateContentRealtimeInput.video) && Intrinsics.areEqual(this.text, bidiGenerateContentRealtimeInput.text);
                }

                public final InlineData.Internal getAudio() {
                    return this.audio;
                }

                public final List<InlineData.Internal> getMediaChunks() {
                    return this.mediaChunks;
                }

                public final String getText() {
                    return this.text;
                }

                public final InlineData.Internal getVideo() {
                    return this.video;
                }

                public int hashCode() {
                    List<InlineData.Internal> list = this.mediaChunks;
                    int iHashCode = (list == null ? 0 : list.hashCode()) * 31;
                    InlineData.Internal internal = this.audio;
                    int iHashCode2 = (iHashCode + (internal == null ? 0 : internal.hashCode())) * 31;
                    InlineData.Internal internal2 = this.video;
                    int iHashCode3 = (iHashCode2 + (internal2 == null ? 0 : internal2.hashCode())) * 31;
                    String str = this.text;
                    return iHashCode3 + (str != null ? str.hashCode() : 0);
                }

                public String toString() {
                    StringBuilder sb = new StringBuilder("BidiGenerateContentRealtimeInput(mediaChunks=");
                    sb.append(this.mediaChunks);
                    sb.append(", audio=");
                    sb.append(this.audio);
                    sb.append(", video=");
                    sb.append(this.video);
                    sb.append(", text=");
                    return FileInsert$$ExternalSyntheticOutline0.m(sb, this.text, ')');
                }

                public BidiGenerateContentRealtimeInput(List<InlineData.Internal> list, InlineData.Internal internal, InlineData.Internal internal2, String str) {
                    this.mediaChunks = list;
                    this.audio = internal;
                    this.video = internal2;
                    this.text = str;
                }
            }
        }

        public BidiGenerateContentRealtimeInputSetup(List<InlineData> list, InlineData inlineData, InlineData inlineData2, String str) {
            this.mediaChunks = list;
            this.audio = inlineData;
            this.video = inlineData2;
            this.text = str;
        }

        public BidiGenerateContentRealtimeInputSetup() {
            this(null, null, null, null, 15, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object startAudioConversation$default(LiveSession liveSession, Function1 function1, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return liveSession.startAudioConversation(function1, z, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object startAudioConversation$default(LiveSession liveSession, Function1 function1, Function2 function2, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function2 = null;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return liveSession.startAudioConversation(function1, function2, z, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object startAudioConversation$default(LiveSession liveSession, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        return liveSession.startAudioConversation((Function1<? super FunctionCallPart, FunctionResponsePart>) function1, (Continuation<? super Unit>) continuation);
    }

    public final Object send(String str, Continuation<? super Unit> continuation) {
        Object objCatchAsync$com_google_firebase_ai_logic_firebase_ai = FirebaseAIException.INSTANCE.catchAsync$com_google_firebase_ai_logic_firebase_ai(new AnonymousClass3(str, null), continuation);
        return objCatchAsync$com_google_firebase_ai_logic_firebase_ai == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCatchAsync$com_google_firebase_ai_logic_firebase_ai : Unit.INSTANCE;
    }

    public /* synthetic */ LiveSession(DefaultClientWebSocketSession defaultClientWebSocketSession, CoroutineContext coroutineContext, AudioHelper audioHelper, FirebaseApp firebaseApp, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(defaultClientWebSocketSession, coroutineContext, (i & 4) != 0 ? null : audioHelper, firebaseApp);
    }

    public final Object startAudioConversation(Function1<? super FunctionCallPart, FunctionResponsePart> function1, boolean z, Continuation<? super Unit> continuation) {
        Object objStartAudioConversation = startAudioConversation(function1, null, null, z, continuation);
        return objStartAudioConversation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartAudioConversation : Unit.INSTANCE;
    }

    public final Object startAudioConversation(final Function1<? super FunctionCallPart, FunctionResponsePart> function1, final Function2<? super Transcription, ? super Transcription, Unit> function2, final boolean z, Continuation<? super Unit> continuation) {
        Object objStartAudioConversation = startAudioConversation(LiveAudioConversationConfigKt.liveAudioConversationConfig(new Function1() { // from class: com.google.firebase.ai.type.LiveSession$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LiveSession.startAudioConversation$lambda$0(function1, function2, z, (LiveAudioConversationConfig.Builder) obj);
            }
        }), continuation);
        return objStartAudioConversation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartAudioConversation : Unit.INSTANCE;
    }

    public final Object startAudioConversation(Function1<? super FunctionCallPart, FunctionResponsePart> function1, Function2<? super Transcription, ? super Transcription, Unit> function2, Function1<? super LiveServerGoAway, Unit> function12, boolean z, Continuation<? super Unit> continuation) {
        Object objStartAudioConversation = startAudioConversation(LiveAudioConversationConfigKt.liveAudioConversationConfig(new WorkerWrapper$$ExternalSyntheticLambda1(function1, function2, function12, z)), continuation);
        return objStartAudioConversation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartAudioConversation : Unit.INSTANCE;
    }

    public final Object startAudioConversation(Function1<? super FunctionCallPart, FunctionResponsePart> function1, Continuation<? super Unit> continuation) {
        Object objStartAudioConversation = startAudioConversation(function1, null, null, false, continuation);
        return objStartAudioConversation == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objStartAudioConversation : Unit.INSTANCE;
    }
}
