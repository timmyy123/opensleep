package com.urbandroid.sleep.media.spotify;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.facebook.share.internal.ShareConstants;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.PlayerApi;
import com.spotify.android.appremote.api.SpotifyAppRemote;
import com.spotify.protocol.client.CallResult;
import com.spotify.protocol.client.Subscription;
import com.spotify.protocol.types.Empty;
import com.spotify.protocol.types.PlayerState;
import com.spotify.protocol.types.Track;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.media.spotify.SpotifySdk;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u000bH\u0086@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0019R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifySdk;", "Lcom/urbandroid/common/FeatureLogger;", "Lcom/spotify/android/appremote/api/SpotifyAppRemote;", "spotifyAppRemote", "<init>", "(Lcom/spotify/android/appremote/api/SpotifyAppRemote;)V", "", "resume", "()V", "", ShareConstants.MEDIA_URI, "", "shouldOverrideMediaControls", "mediaStream", "play", "(Ljava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pause", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "disconnect", "Lcom/spotify/android/appremote/api/SpotifyAppRemote;", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "shouldBePlaying", "Z", "isPlaying", "disconnected", "Lcom/spotify/protocol/client/Subscription;", "Lcom/spotify/protocol/types/PlayerState;", "subscription", "Lcom/spotify/protocol/client/Subscription;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SpotifySdk implements FeatureLogger {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean disconnected;
    private boolean isPlaying;
    private boolean shouldBePlaying;
    private boolean shouldOverrideMediaControls;
    private final SpotifyAppRemote spotifyAppRemote;
    private Subscription<PlayerState> subscription;
    private final String tag;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/media/spotify/SpotifySdk$Companion;", "", "<init>", "()V", "connect", "Lcom/urbandroid/sleep/media/spotify/SpotifySdk;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Object connect(Context context, Continuation<? super SpotifySdk> continuation) {
            ConnectionParams connectionParamsBuild = new ConnectionParams.Builder("695f79131de248ee9f4e7f06f241b983").setRedirectUri("sleep-spotify-login://callback").showAuthView(true).build();
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            final SafeResumeContinuation safeResumeContinuation = new SafeResumeContinuation(safeContinuation);
            Logger.logInfo("Spotify auth connect()", null);
            SpotifyAppRemote.connect(context, connectionParamsBuild, new Connector.ConnectionListener() { // from class: com.urbandroid.sleep.media.spotify.SpotifySdk$Companion$connect$2$1
                @Override // com.spotify.android.appremote.api.Connector.ConnectionListener
                public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                    spotifyAppRemote.getClass();
                    Logger.logInfo("Spotify onConnected: " + spotifyAppRemote + " ", null);
                    SafeResumeContinuation<SpotifySdk> safeResumeContinuation2 = safeResumeContinuation;
                    Result.Companion companion = Result.INSTANCE;
                    safeResumeContinuation2.resumeWith(Result.m2357constructorimpl(new SpotifySdk(spotifyAppRemote)));
                }

                @Override // com.spotify.android.appremote.api.Connector.ConnectionListener
                public void onFailure(Throwable error) {
                    Logger.logInfo("Spotify onFailure: " + error, null);
                    safeResumeContinuation.resumeWith(Result.m2357constructorimpl(null));
                }
            });
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdk$pause$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdk$pause$2", f = "SpotifySdk.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SpotifySdk.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            SpotifySdk spotifySdk = SpotifySdk.this;
            String strM = FileInsert$$ExternalSyntheticOutline0.m(spotifySdk.hashCode(), "async pause() ");
            Logger.logInfo(Logger.defaultTag, spotifySdk.getTag() + ": " + strM, null);
            com.spotify.protocol.client.Result<Empty> resultAwait = SpotifySdk.this.spotifyAppRemote.getPlayerApi().pause().await(10L, TimeUnit.SECONDS);
            if (resultAwait.isSuccessful()) {
                Empty data2 = resultAwait.getData();
                SpotifySdk spotifySdk2 = SpotifySdk.this;
                String str = "pause success " + data2 + " " + spotifySdk2.hashCode();
                Logger.logInfo(Logger.defaultTag, spotifySdk2.getTag() + ": " + str, null);
                z = true;
            } else {
                SpotifySdk spotifySdk3 = SpotifySdk.this;
                Throwable error = resultAwait.getError();
                error.getClass();
                Logger.logSevere(Logger.defaultTag, spotifySdk3.getTag(), error);
                z = false;
            }
            return Boxing.boxBoolean(z);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdk$play$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdk$play$2", f = "SpotifySdk.kt", l = {106, 122, 123}, m = "invokeSuspend", v = 2)
    public static final class C21332 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
        final /* synthetic */ boolean $mediaStream;
        final /* synthetic */ boolean $shouldOverrideMediaControls;
        final /* synthetic */ String $uri;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ SpotifySdk this$0;

        /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdk$play$2$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdk$play$2$1", f = "SpotifySdk.kt", l = {}, m = "invokeSuspend", v = 2)
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $shouldOverrideMediaControls;
            int label;
            final /* synthetic */ SpotifySdk this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(SpotifySdk spotifySdk, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = spotifySdk;
                this.$shouldOverrideMediaControls = z;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$0(SpotifySdk spotifySdk, boolean z, PlayerState playerState) {
                String strM = FileInsert$$ExternalSyntheticOutline0.m(spotifySdk.hashCode(), "listener: ");
                Logger.logInfo(Logger.defaultTag, spotifySdk.getTag() + ": " + strM, null);
                Track track = playerState.track;
                String str = track.name;
                String str2 = track.artist.name;
                boolean z2 = playerState.isPaused;
                int iHashCode = spotifySdk.hashCode();
                StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("track '", str, "' by '", str2, "' paused: ");
                sbM6m.append(z2);
                sbM6m.append(" ");
                sbM6m.append(iHashCode);
                String string = sbM6m.toString();
                Logger.logInfo(Logger.defaultTag, spotifySdk.getTag() + ": " + string, null);
                spotifySdk.isPlaying = playerState.isPaused ^ true;
                if (!spotifySdk.isPlaying && z && spotifySdk.shouldBePlaying) {
                    spotifySdk.resume();
                }
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$shouldOverrideMediaControls, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
                SpotifySdk spotifySdk = this.this$0;
                Subscription<PlayerState> subscriptionSubscribeToPlayerState = spotifySdk.spotifyAppRemote.getPlayerApi().subscribeToPlayerState();
                final SpotifySdk spotifySdk2 = this.this$0;
                final boolean z = this.$shouldOverrideMediaControls;
                spotifySdk.subscription = subscriptionSubscribeToPlayerState.setEventCallback(new Subscription.EventCallback() { // from class: com.urbandroid.sleep.media.spotify.SpotifySdk$play$2$1$$ExternalSyntheticLambda0
                    @Override // com.spotify.protocol.client.Subscription.EventCallback
                    public final void onEvent(Object obj2) {
                        SpotifySdk.C21332.AnonymousClass1.invokeSuspend$lambda$0(spotifySdk2, z, (PlayerState) obj2);
                    }
                });
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: renamed from: com.urbandroid.sleep.media.spotify.SpotifySdk$play$2$2, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
        @DebugMetadata(c = "com.urbandroid.sleep.media.spotify.SpotifySdk$play$2$2", f = "SpotifySdk.kt", l = {}, m = "invokeSuspend", v = 2)
        public static final class C00432 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
            int label;
            final /* synthetic */ SpotifySdk this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00432(SpotifySdk spotifySdk, Continuation<? super C00432> continuation) {
                super(2, continuation);
                this.this$0 = spotifySdk;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00432(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                return ((C00432) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    return Boxing.boxBoolean(this.this$0.isPlaying);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21332(String str, SpotifySdk spotifySdk, boolean z, boolean z2, Continuation<? super C21332> continuation) {
            super(2, continuation);
            this.$uri = str;
            this.this$0 = spotifySdk;
            this.$shouldOverrideMediaControls = z;
            this.$mediaStream = z2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C21332(this.$uri, this.this$0, this.$shouldOverrideMediaControls, this.$mediaStream, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
            return ((C21332) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:37:0x01ad, code lost:
        
            if (r14 != r0) goto L39;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CallResult<Empty> callResultPlay;
            boolean zBooleanValue;
            String str;
            com.spotify.protocol.client.Result<Empty> result;
            Empty empty;
            com.spotify.protocol.client.Result<Empty> result2;
            CallResult<Empty> callResult;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str2 = this.$uri;
                String str3 = str2 == null ? "spotify:album:6TJmQnO44YE5BtTxH8pop1" : str2;
                SpotifySdk spotifySdk = this.this$0;
                int iHashCode = spotifySdk.hashCode();
                boolean z = this.$shouldOverrideMediaControls;
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(iHashCode, "play async ", str2, " ", " use ALARM stream ");
                sbM.append(z);
                String string = sbM.toString();
                Logger.logInfo(Logger.defaultTag, spotifySdk.getTag() + ": " + string, null);
                if (Intrinsics.areEqual(str3, "spotify-play-last-song")) {
                    callResultPlay = this.this$0.spotifyAppRemote.getPlayerApi().resume();
                } else if (this.$shouldOverrideMediaControls) {
                    boolean z2 = this.$mediaStream;
                    SpotifySdk spotifySdk2 = this.this$0;
                    callResultPlay = z2 ? spotifySdk2.spotifyAppRemote.getPlayerApi().play(str3) : spotifySdk2.spotifyAppRemote.getPlayerApi().play(str3, PlayerApi.StreamType.ALARM);
                } else {
                    callResultPlay = this.this$0.spotifyAppRemote.getPlayerApi().play(str3);
                }
                this.this$0.shouldBePlaying = true;
                com.spotify.protocol.client.Result<Empty> resultAwait = callResultPlay.await(10L, TimeUnit.SECONDS);
                boolean unused = this.this$0.shouldBePlaying;
                if (!resultAwait.isSuccessful()) {
                    SpotifySdk spotifySdk3 = this.this$0;
                    Throwable error = resultAwait.getError();
                    error.getClass();
                    Logger.logSevere(Logger.defaultTag, spotifySdk3.getTag(), error);
                    zBooleanValue = false;
                    return Boxing.boxBoolean(zBooleanValue);
                }
                Empty data2 = resultAwait.getData();
                SpotifySdk spotifySdk4 = this.this$0;
                String str4 = Logger.defaultTag;
                Logger.logInfo(str4, spotifySdk4.getTag() + ": " + ("play success " + data2), null);
                MainCoroutineDispatcher main = Dispatchers.getMain();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$shouldOverrideMediaControls, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(str3);
                this.L$1 = SpillingKt.nullOutSpilledVariable(callResultPlay);
                this.L$2 = SpillingKt.nullOutSpilledVariable(resultAwait);
                this.L$3 = SpillingKt.nullOutSpilledVariable(data2);
                this.label = 1;
                if (BuildersKt.withContext(main, anonymousClass1, this) != coroutine_suspended) {
                    str = str3;
                    result = resultAwait;
                    empty = data2;
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                empty = (Empty) this.L$3;
                result = (com.spotify.protocol.client.Result) this.L$2;
                CallResult<Empty> callResult2 = (CallResult) this.L$1;
                String str5 = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                callResultPlay = callResult2;
                str = str5;
            } else {
                if (i != 2) {
                    if (i != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    zBooleanValue = ((Boolean) obj).booleanValue();
                    return Boxing.boxBoolean(zBooleanValue);
                }
                empty = (Empty) this.L$3;
                result2 = (com.spotify.protocol.client.Result) this.L$2;
                callResult = (CallResult) this.L$1;
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                MainCoroutineDispatcher main2 = Dispatchers.getMain();
                C00432 c00432 = new C00432(this.this$0, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.L$1 = SpillingKt.nullOutSpilledVariable(callResult);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(empty);
                this.label = 3;
                obj = BuildersKt.withContext(main2, c00432, this);
            }
            this.L$0 = SpillingKt.nullOutSpilledVariable(str);
            this.L$1 = SpillingKt.nullOutSpilledVariable(callResultPlay);
            this.L$2 = SpillingKt.nullOutSpilledVariable(result);
            this.L$3 = SpillingKt.nullOutSpilledVariable(empty);
            this.label = 2;
            if (DelayKt.delay(2000L, this) != coroutine_suspended) {
                result2 = result;
                callResult = callResultPlay;
                MainCoroutineDispatcher main22 = Dispatchers.getMain();
                C00432 c004322 = new C00432(this.this$0, null);
                this.L$0 = SpillingKt.nullOutSpilledVariable(str);
                this.L$1 = SpillingKt.nullOutSpilledVariable(callResult);
                this.L$2 = SpillingKt.nullOutSpilledVariable(result2);
                this.L$3 = SpillingKt.nullOutSpilledVariable(empty);
                this.label = 3;
                obj = BuildersKt.withContext(main22, c004322, this);
            }
            return coroutine_suspended;
        }
    }

    public SpotifySdk(SpotifyAppRemote spotifyAppRemote) {
        spotifyAppRemote.getClass();
        this.spotifyAppRemote = spotifyAppRemote;
        this.tag = "SpotifySdkPlayer";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disconnect$lambda$0(SpotifySdk spotifySdk, Empty empty) {
        String strM = FileInsert$$ExternalSyntheticOutline0.m(spotifySdk.hashCode(), "disconnect after pause ");
        Logger.logInfo(Logger.defaultTag, spotifySdk.getTag() + ": " + strM, null);
        SpotifyAppRemote.disconnect(spotifySdk.spotifyAppRemote);
        spotifySdk.disconnected = true;
    }

    public final Object disconnect(Continuation<? super Unit> continuation) {
        String strM = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "disconnect() ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        this.isPlaying = false;
        this.shouldBePlaying = false;
        String strM2 = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "async pause() ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
        this.spotifyAppRemote.getPlayerApi().pause().setResultCallback(new LoginFragment$$ExternalSyntheticLambda0(this, 28));
        return Unit.INSTANCE;
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }

    public final Object pause(Continuation<? super Boolean> continuation) {
        this.shouldOverrideMediaControls = false;
        this.shouldBePlaying = false;
        if (this.disconnected) {
            Logger.logWarning(Logger.defaultTag, getTag() + ": no pause - spotify disconnected", null);
            return Boxing.boxBoolean(false);
        }
        Subscription<PlayerState> subscription = this.subscription;
        if (subscription != null) {
            subscription.cancel();
        }
        this.subscription = null;
        String strM = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "pause() ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(null), continuation);
    }

    public final Object play(String str, boolean z, boolean z2, Continuation<? super Boolean> continuation) {
        this.shouldOverrideMediaControls = z;
        if (this.disconnected) {
            String strM = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "no play - spotify disconnected ");
            Logger.logWarning(Logger.defaultTag, getTag() + ": " + strM, null);
            return Boxing.boxBoolean(false);
        }
        String strM2 = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "play() ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM2, null);
        return BuildersKt.withContext(Dispatchers.getIO(), new C21332(str, this, z, z2, null), continuation);
    }

    public final void resume() {
        String strM = FileInsert$$ExternalSyntheticOutline0.m(hashCode(), "resume() ");
        Logger.logInfo(Logger.defaultTag, getTag() + ": " + strM, null);
        this.spotifyAppRemote.getPlayerApi().resume();
    }
}
