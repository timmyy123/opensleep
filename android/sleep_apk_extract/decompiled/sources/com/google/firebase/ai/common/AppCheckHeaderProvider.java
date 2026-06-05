package com.google.firebase.ai.common;

import android.util.Log;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0011H\u0096@¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/ai/common/AppCheckHeaderProvider;", "Lcom/google/firebase/ai/common/HeaderProvider;", "logTag", "", "useLimitedUseAppCheckTokens", "", "appCheckTokenProvider", "Lcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;", "internalAuthProvider", "Lcom/google/firebase/auth/internal/InternalAuthProvider;", "<init>", "(Ljava/lang/String;ZLcom/google/firebase/appcheck/interop/InteropAppCheckTokenProvider;Lcom/google/firebase/auth/internal/InternalAuthProvider;)V", "timeout", "Lkotlin/time/Duration;", "getTimeout-UwyO8pc", "()J", "generateHeaders", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppCheckHeaderProvider implements HeaderProvider {
    private final InteropAppCheckTokenProvider appCheckTokenProvider;
    private final InternalAuthProvider internalAuthProvider;
    private final String logTag;
    private final boolean useLimitedUseAppCheckTokens;

    /* JADX INFO: renamed from: com.google.firebase.ai.common.AppCheckHeaderProvider$generateHeaders$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.ai.common.AppCheckHeaderProvider", f = "AppCheckHeaderProvider.kt", l = {47, 62}, m = "generateHeaders")
    public static final class AnonymousClass1 extends ContinuationImpl {
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
            return AppCheckHeaderProvider.this.generateHeaders(this);
        }
    }

    public /* synthetic */ AppCheckHeaderProvider(String str, boolean z, InteropAppCheckTokenProvider interopAppCheckTokenProvider, InternalAuthProvider internalAuthProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, (i & 4) != 0 ? null : interopAppCheckTokenProvider, (i & 8) != 0 ? null : internalAuthProvider);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.firebase.ai.common.HeaderProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object generateHeaders(Continuation<? super Map<String, String>> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Boxing.boxInt(Log.w(this.logTag, "AppCheck not registered, skipping"));
            Boxing.boxInt(Log.w(this.logTag, "Auth not registered, skipping"));
            return linkedHashMap;
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
            obj.getClass();
            Events$$ExternalSyntheticBUOutline0.m();
            return null;
        }
        if (i2 != 2) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        Map map = (Map) anonymousClass1.L$1;
        AppCheckHeaderProvider appCheckHeaderProvider = (AppCheckHeaderProvider) anonymousClass1.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            if (obj == null) {
                throw null;
            }
            throw new ClassCastException();
        } catch (Exception e) {
            Boxing.boxInt(Log.w(appCheckHeaderProvider.logTag, "Error getting Auth token ", e));
            return map;
        }
    }

    @Override // com.google.firebase.ai.common.HeaderProvider
    /* JADX INFO: renamed from: getTimeout-UwyO8pc, reason: not valid java name */
    public long mo395getTimeoutUwyO8pc() {
        Duration.Companion companion = Duration.INSTANCE;
        return DurationKt.toDuration(10, DurationUnit.SECONDS);
    }

    public AppCheckHeaderProvider(String str, boolean z, InteropAppCheckTokenProvider interopAppCheckTokenProvider, InternalAuthProvider internalAuthProvider) {
        str.getClass();
        this.logTag = str;
        this.useLimitedUseAppCheckTokens = z;
    }
}
