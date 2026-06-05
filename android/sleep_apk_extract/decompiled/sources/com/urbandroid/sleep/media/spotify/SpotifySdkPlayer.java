package com.urbandroid.sleep.media.spotify;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.share.internal.ShareConstants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.media.player.PlaybackListener;
import com.urbandroid.sleep.media.spotify.ISpotifyPlayer;
import com.urbandroid.sleep.media.spotify.SpotifySdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0086@¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010 \u001a\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020&8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0018\u0010+\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010-¨\u0006/"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifySdkPlayer;", "Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer;", "Lkotlinx/coroutines/CoroutineScope;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/media/player/PlaybackListener;", "playbackListener", "", "mediaStream", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/media/player/PlaybackListener;Z)V", "Lcom/urbandroid/sleep/media/spotify/SpotifySdk;", "connect", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setForcePlay", "()Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer;", "Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer$PlayerMode;", "mode", "setMode", "(Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer$PlayerMode;)Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer;", "", ShareConstants.MEDIA_URI, "play", "(Ljava/lang/String;)Lcom/urbandroid/sleep/media/spotify/SpotifySdkPlayer;", "stop", "()Lcom/urbandroid/sleep/media/spotify/SpotifySdkPlayer;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/urbandroid/sleep/media/player/PlaybackListener;", "getPlaybackListener", "()Lcom/urbandroid/sleep/media/player/PlaybackListener;", "Z", "getMediaStream", "()Z", "Lkotlinx/coroutines/CompletableJob;", "job", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "spotifySdk", "Lcom/urbandroid/sleep/media/spotify/SpotifySdk;", "Lcom/urbandroid/sleep/media/spotify/ISpotifyPlayer$PlayerMode;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpotifySdkPlayer implements ISpotifyPlayer, CoroutineScope {
    private static Mutex LOCK = MutexKt.Mutex$default(false, 1, null);
    private final /* synthetic */ CoroutineScope $$delegate_0;
    private final Context context;
    private final CoroutineContext coroutineContext;
    private final CompletableJob job;
    private final boolean mediaStream;
    private ISpotifyPlayer.PlayerMode mode;
    private final PlaybackListener playbackListener;
    private SpotifySdk spotifySdk;

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdkPlayer$connect$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdkPlayer", f = "SpotifySdkPlayer.kt", l = {73, 29}, m = "connect", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SpotifySdkPlayer.this.connect(this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdkPlayer$play$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdkPlayer$play$1", f = "SpotifySdkPlayer.kt", l = {47, 47}, m = "invokeSuspend", v = 2)
    public static final class C21341 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $uri;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21341(String str, Continuation<? super C21341> continuation) {
            super(2, continuation);
            this.$uri = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SpotifySdkPlayer.this.new C21341(this.$uri, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21341) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
        
            if (r7 == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.logInfo("play() media stream: " + SpotifySdkPlayer.this.getMediaStream(), null);
                SpotifySdkPlayer spotifySdkPlayer = SpotifySdkPlayer.this;
                this.label = 1;
                obj = spotifySdkPlayer.connect(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                if (((Boolean) obj).booleanValue()) {
                    SpotifySdkPlayer.this.getPlaybackListener().playbackStarted();
                } else {
                    SpotifySdkPlayer.this.getPlaybackListener().fail(5);
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            SpotifySdk spotifySdk = (SpotifySdk) obj;
            if (spotifySdk != null) {
                String str = this.$uri;
                boolean z = SpotifySdkPlayer.this.mode == ISpotifyPlayer.PlayerMode.ALARM;
                boolean mediaStream = SpotifySdkPlayer.this.getMediaStream();
                this.label = 2;
                obj = spotifySdk.play(str, z, mediaStream, this);
            }
            SpotifySdkPlayer.this.getPlaybackListener().fail(5);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdkPlayer$stop$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdkPlayer$stop$1", f = "SpotifySdkPlayer.kt", l = {59, 59, 60}, m = "invokeSuspend", v = 2)
    public static final class C21351 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C21351(Continuation<? super C21351> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SpotifySdkPlayer.this.new C21351(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21351) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        
            if (r7 == r0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        
            if (r7.disconnect(r6) == r0) goto L25;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            SpotifySdk spotifySdk;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.logInfo("stop()", null);
                SpotifySdkPlayer spotifySdkPlayer = SpotifySdkPlayer.this;
                this.label = 1;
                obj = spotifySdkPlayer.connect(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                spotifySdk = SpotifySdkPlayer.this.spotifySdk;
                if (spotifySdk != null) {
                    this.label = 3;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            SpotifySdk spotifySdk2 = (SpotifySdk) obj;
            if (spotifySdk2 == null) {
                spotifySdk = SpotifySdkPlayer.this.spotifySdk;
                if (spotifySdk != null) {
                }
                return Unit.INSTANCE;
            }
            this.label = 2;
            obj = spotifySdk2.pause(this);
            return coroutine_suspended;
        }
    }

    public SpotifySdkPlayer(Context context, PlaybackListener playbackListener, boolean z) {
        context.getClass();
        playbackListener.getClass();
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.context = context;
        this.playbackListener = playbackListener;
        this.mediaStream = z;
        CompletableJob completableJobSupervisorJob$default = SupervisorKt.SupervisorJob$default(null, 1, null);
        this.job = completableJobSupervisorJob$default;
        this.coroutineContext = Dispatchers.getMain().plus(completableJobSupervisorJob$default).plus(new SpotifySdkPlayer$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE));
        this.mode = ISpotifyPlayer.PlayerMode.ALARM;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object connect(Continuation<? super SpotifySdk> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Mutex mutex;
        int i;
        Mutex mutex2;
        SpotifySdkPlayer spotifySdkPlayer;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = LOCK;
                anonymousClass1.L$0 = mutex;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                    i = 0;
                }
                return coroutine_suspended;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                spotifySdkPlayer = (SpotifySdkPlayer) anonymousClass1.L$1;
                mutex2 = (Mutex) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    spotifySdkPlayer.spotifySdk = (SpotifySdk) obj;
                    SpotifySdk spotifySdk = this.spotifySdk;
                    mutex2.unlock(null);
                    return spotifySdk;
                } catch (Throwable th) {
                    th = th;
                    mutex2.unlock(null);
                    throw th;
                }
            }
            i = anonymousClass1.I$0;
            Mutex mutex3 = (Mutex) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex3;
            Logger.logInfo("connect()", null);
            if (this.spotifySdk != null) {
                mutex2 = mutex;
                SpotifySdk spotifySdk2 = this.spotifySdk;
                mutex2.unlock(null);
                return spotifySdk2;
            }
            SpotifySdk.Companion companion = SpotifySdk.INSTANCE;
            Context context = this.context;
            anonymousClass1.L$0 = mutex;
            anonymousClass1.L$1 = this;
            anonymousClass1.I$0 = i;
            anonymousClass1.I$1 = 0;
            anonymousClass1.label = 2;
            Object objConnect = companion.connect(context, anonymousClass1);
            if (objConnect != coroutine_suspended) {
                mutex2 = mutex;
                obj = objConnect;
                spotifySdkPlayer = this;
                spotifySdkPlayer.spotifySdk = (SpotifySdk) obj;
                SpotifySdk spotifySdk22 = this.spotifySdk;
                mutex2.unlock(null);
                return spotifySdk22;
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex2 = mutex;
            mutex2.unlock(null);
            throw th;
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public final boolean getMediaStream() {
        return this.mediaStream;
    }

    public final PlaybackListener getPlaybackListener() {
        return this.playbackListener;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public SpotifySdkPlayer play(String uri) {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21341(uri, null), 3, null);
        return this;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public ISpotifyPlayer setForcePlay() {
        return this;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public ISpotifyPlayer setMode(ISpotifyPlayer.PlayerMode mode) {
        mode.getClass();
        this.mode = mode;
        return this;
    }

    @Override // com.urbandroid.sleep.media.spotify.ISpotifyPlayer
    public SpotifySdkPlayer stop() {
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21351(null), 3, null);
        return this;
    }
}
