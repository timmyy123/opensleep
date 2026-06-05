package com.urbandroid.sleep.service.google.home;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.home.HomeDevice;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartlight.SmartLight;
import com.urbandroid.smartlight.common.Configuration;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0003\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0083@¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u0010\u0010\u0004J\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0010\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001b\u0010\u0004J\u000f\u0010\u001c\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001c\u0010\u0004J\u000f\u0010\u001d\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001d\u0010\u0004J\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u001d\u0010\u0016J\u000f\u0010\u001f\u001a\u00020\u000fH\u0017¢\u0006\u0004\b\u001f\u0010\u0004R\u001a\u0010!\u001a\u00020 8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0006\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010\u0007¨\u0006)"}, d2 = {"Lcom/urbandroid/sleep/service/google/home/GoogleHomeSmartLight;", "Lcom/urbandroid/sleep/smartlight/SmartLight;", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "(Landroid/content/Context;)V", "", "Lcom/google/home/HomeDevice;", "getSelectedDevices", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "isConnected", "()Z", "", "off", "force", "(Z)V", "", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", ViewHierarchyConstants.HINT_KEY, "loop", "shortHint", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleHomeSmartLight implements SmartLight, CoroutineScope {
    private final /* synthetic */ CoroutineScope $$delegate_0;
    public Context context;
    private final CoroutineContext coroutineContext;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$hint$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$hint$1", f = "GoogleHomeSmartLight.kt", l = {140, 141, 142, 145, 146, 148, 150, 152, 153, 155}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $loop;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ GoogleHomeSmartLight this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(int i, GoogleHomeSmartLight googleHomeSmartLight, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$loop = i;
            this.this$0 = googleHomeSmartLight;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$loop, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x013f, code lost:
        
            if (r15.color(r1, 50, r14) != r0) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0129  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x015b  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01c3 A[PHI: r1 r5 r6 r7 r8 r9 r10 r11
          0x01c3: PHI (r1v23 int) = (r1v13 int), (r1v24 int) binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r5v19 int) = (r5v9 int), (r5v20 int) binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r6v14 int) = (r6v3 int), (r6v15 int) binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r7v11 java.lang.Object) = (r7v1 java.lang.Object), (r7v12 java.lang.Object) binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r8v20 java.util.Iterator<java.lang.Integer>) = (r8v4 java.util.Iterator<java.lang.Integer>), (r8v21 java.util.Iterator<java.lang.Integer>) binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r9v17 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight) = 
          (r9v4 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
          (r9v18 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
         binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r10v20 java.lang.Iterable) = (r10v4 java.lang.Iterable), (r10v21 java.lang.Iterable) binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]
          0x01c3: PHI (r11v17 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r11v4 java.util.List<? extends com.google.home.HomeDevice>)
          (r11v18 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:12:0x00aa, B:35:0x01bf] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x01f0 A[PHI: r1 r5 r6 r7 r8 r9 r10 r11
          0x01f0: PHI (r1v22 int) = (r1v14 int), (r1v23 int) binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r5v18 int) = (r5v10 int), (r5v19 int) binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r6v13 int) = (r6v4 int), (r6v14 int) binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r7v10 java.lang.Object) = (r7v2 java.lang.Object), (r7v11 java.lang.Object) binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r8v19 java.util.Iterator<java.lang.Integer>) = (r8v6 java.util.Iterator<java.lang.Integer>), (r8v20 java.util.Iterator<java.lang.Integer>) binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r9v16 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight) = 
          (r9v6 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
          (r9v17 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
         binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r10v19 java.lang.Iterable) = (r10v6 java.lang.Iterable), (r10v20 java.lang.Iterable) binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]
          0x01f0: PHI (r11v16 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r11v6 java.util.List<? extends com.google.home.HomeDevice>)
          (r11v17 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:11:0x008d, B:38:0x01ec] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0215 A[PHI: r1 r5 r6 r7 r8 r9 r10 r11
          0x0215: PHI (r1v21 int) = (r1v15 int), (r1v22 int) binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r5v17 int) = (r5v11 int), (r5v18 int) binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r6v12 int) = (r6v5 int), (r6v13 int) binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r7v9 java.lang.Object) = (r7v3 java.lang.Object), (r7v10 java.lang.Object) binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r8v18 java.util.Iterator<java.lang.Integer>) = (r8v8 java.util.Iterator<java.lang.Integer>), (r8v19 java.util.Iterator<java.lang.Integer>) binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r9v15 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight) = 
          (r9v8 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
          (r9v16 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
         binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r10v18 java.lang.Iterable) = (r10v8 java.lang.Iterable), (r10v19 java.lang.Iterable) binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]
          0x0215: PHI (r11v15 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r11v8 java.util.List<? extends com.google.home.HomeDevice>)
          (r11v16 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:10:0x0070, B:41:0x0211] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0242 A[PHI: r1 r5 r6 r7 r8 r9 r10 r11
          0x0242: PHI (r1v20 int) = (r1v16 int), (r1v21 int) binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r5v16 int) = (r5v12 int), (r5v17 int) binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r6v11 int) = (r6v6 int), (r6v12 int) binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r7v8 java.lang.Object) = (r7v4 java.lang.Object), (r7v9 java.lang.Object) binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r8v17 java.util.Iterator<java.lang.Integer>) = (r8v10 java.util.Iterator<java.lang.Integer>), (r8v18 java.util.Iterator<java.lang.Integer>) binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r9v14 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight) = 
          (r9v10 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
          (r9v15 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
         binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r10v17 java.lang.Iterable) = (r10v10 java.lang.Iterable), (r10v18 java.lang.Iterable) binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]
          0x0242: PHI (r11v14 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r11v10 java.util.List<? extends com.google.home.HomeDevice>)
          (r11v15 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:9:0x0053, B:44:0x023f] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:52:0x029c  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x02a1  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x004b A[PHI: r1 r5 r6 r7 r8 r9 r10 r11
          0x004b: PHI (r1v18 int) = (r1v17 int), (r1v20 int) binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r5v14 int) = (r5v13 int), (r5v16 int) binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r6v8 int) = (r6v7 int), (r6v11 int) binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r7v6 java.lang.Object) = (r7v5 java.lang.Object), (r7v8 java.lang.Object) binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r8v13 java.util.Iterator<java.lang.Integer>) = (r8v12 java.util.Iterator<java.lang.Integer>), (r8v17 java.util.Iterator<java.lang.Integer>) binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r9v13 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight) = 
          (r9v12 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
          (r9v14 com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight)
         binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r10v13 java.lang.Iterable) = (r10v12 java.lang.Iterable), (r10v17 java.lang.Iterable) binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]
          0x004b: PHI (r11v13 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r11v12 java.util.List<? extends com.google.home.HomeDevice>)
          (r11v14 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:7:0x0030, B:47:0x026c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x029c -> B:28:0x0155). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<? extends HomeDevice> list;
            GoogleHomeClient companion;
            List<? extends HomeDevice> list2;
            Iterable iterable;
            List<? extends HomeDevice> list3;
            GoogleHomeSmartLight googleHomeSmartLight;
            Iterator<Integer> it;
            int i;
            int i2;
            int i3;
            Object obj2;
            GoogleHomeClient companion2;
            GoogleHomeClient companion3;
            GoogleHomeClient companion4;
            GoogleHomeClient companion5;
            GoogleHomeClient companion6;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    zza$$ExternalSyntheticOutline0.m(this.$loop, "Home: hint ");
                    GoogleHomeSmartLight googleHomeSmartLight2 = this.this$0;
                    this.label = 1;
                    obj = googleHomeSmartLight2.getSelectedDevices(this);
                    if (obj != coroutine_suspended) {
                        list = (List) obj;
                        companion = GoogleHomeClient.INSTANCE.getInstance(this.this$0.getContext());
                        this.L$0 = list;
                        this.label = 2;
                        if (companion.level(list, 50, this) != coroutine_suspended) {
                            list2 = list;
                            GoogleHomeClient companion7 = GoogleHomeClient.INSTANCE.getInstance(this.this$0.getContext());
                            this.L$0 = list2;
                            this.label = 3;
                        }
                        break;
                    }
                    return coroutine_suspended;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    companion = GoogleHomeClient.INSTANCE.getInstance(this.this$0.getContext());
                    this.L$0 = list;
                    this.label = 2;
                    if (companion.level(list, 50, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 2:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    GoogleHomeClient companion72 = GoogleHomeClient.INSTANCE.getInstance(this.this$0.getContext());
                    this.L$0 = list2;
                    this.label = 3;
                    break;
                case 3:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    IntRange intRange = new IntRange(0, this.$loop);
                    iterable = intRange;
                    list3 = list2;
                    googleHomeSmartLight = this.this$0;
                    it = intRange.iterator();
                    i = 0;
                    if (it.hasNext()) {
                        Integer next = it.next();
                        int iIntValue = next.intValue();
                        GoogleHomeClient companion8 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                        this.L$0 = list3;
                        this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                        this.L$2 = googleHomeSmartLight;
                        this.L$3 = it;
                        this.L$4 = SpillingKt.nullOutSpilledVariable(next);
                        this.I$0 = i;
                        this.I$1 = iIntValue;
                        this.I$2 = 0;
                        this.label = 4;
                        if (companion8.level(list3, 50, this) != coroutine_suspended) {
                            obj2 = next;
                            i3 = iIntValue;
                            i2 = 0;
                            companion6 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                            this.L$0 = list3;
                            this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                            this.L$2 = googleHomeSmartLight;
                            this.L$3 = it;
                            this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                            this.I$0 = i;
                            this.I$1 = i3;
                            this.I$2 = i2;
                            this.label = 5;
                            if (companion6.color(list3, 50, this) != coroutine_suspended) {
                                companion5 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                                this.L$0 = list3;
                                this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                                this.L$2 = googleHomeSmartLight;
                                this.L$3 = it;
                                this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                                this.I$0 = i;
                                this.I$1 = i3;
                                this.I$2 = i2;
                                this.label = 6;
                                if (companion5.toggle(list3, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                                    this.L$0 = list3;
                                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                                    this.L$2 = googleHomeSmartLight;
                                    this.L$3 = it;
                                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                                    this.I$0 = i;
                                    this.I$1 = i3;
                                    this.I$2 = i2;
                                    this.label = 7;
                                    if (DelayKt.delay(500L, this) != coroutine_suspended) {
                                        companion4 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                                        this.L$0 = list3;
                                        this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                                        this.L$2 = googleHomeSmartLight;
                                        this.L$3 = it;
                                        this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                                        this.I$0 = i;
                                        this.I$1 = i3;
                                        this.I$2 = i2;
                                        this.label = 8;
                                        if (companion4.level(list3, 1, this) != coroutine_suspended) {
                                            companion3 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                                            this.L$0 = list3;
                                            this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                                            this.L$2 = googleHomeSmartLight;
                                            this.L$3 = it;
                                            this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                                            this.I$0 = i;
                                            this.I$1 = i3;
                                            this.I$2 = i2;
                                            this.label = 9;
                                            if (companion3.color(list3, 1, this) != coroutine_suspended) {
                                                int i4 = i2;
                                                int i5 = i;
                                                int i6 = i3;
                                                Iterator<Integer> it2 = it;
                                                Object obj3 = obj2;
                                                Iterable iterable2 = iterable;
                                                companion2 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                                                this.L$0 = list3;
                                                this.L$1 = SpillingKt.nullOutSpilledVariable(iterable2);
                                                this.L$2 = googleHomeSmartLight;
                                                this.L$3 = it2;
                                                this.L$4 = SpillingKt.nullOutSpilledVariable(obj3);
                                                this.I$0 = i5;
                                                this.I$1 = i6;
                                                this.I$2 = i4;
                                                this.label = 10;
                                                if (companion2.toggle(list3, false, (Continuation<? super Unit>) this) != coroutine_suspended) {
                                                    i = i5;
                                                    it = it2;
                                                    iterable = iterable2;
                                                    if (it.hasNext()) {
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    }
                    break;
                case 4:
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i = this.I$0;
                    obj2 = this.L$4;
                    it = (Iterator) this.L$3;
                    googleHomeSmartLight = (GoogleHomeSmartLight) this.L$2;
                    iterable = (Iterable) this.L$1;
                    list3 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion6 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                    this.L$0 = list3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$2 = googleHomeSmartLight;
                    this.L$3 = it;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.label = 5;
                    if (companion6.color(list3, 50, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 5:
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i = this.I$0;
                    obj2 = this.L$4;
                    it = (Iterator) this.L$3;
                    googleHomeSmartLight = (GoogleHomeSmartLight) this.L$2;
                    iterable = (Iterable) this.L$1;
                    list3 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion5 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                    this.L$0 = list3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$2 = googleHomeSmartLight;
                    this.L$3 = it;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.label = 6;
                    if (companion5.toggle(list3, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 6:
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i = this.I$0;
                    obj2 = this.L$4;
                    it = (Iterator) this.L$3;
                    googleHomeSmartLight = (GoogleHomeSmartLight) this.L$2;
                    iterable = (Iterable) this.L$1;
                    list3 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    this.L$0 = list3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$2 = googleHomeSmartLight;
                    this.L$3 = it;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.label = 7;
                    if (DelayKt.delay(500L, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 7:
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i = this.I$0;
                    obj2 = this.L$4;
                    it = (Iterator) this.L$3;
                    googleHomeSmartLight = (GoogleHomeSmartLight) this.L$2;
                    iterable = (Iterable) this.L$1;
                    list3 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion4 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                    this.L$0 = list3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$2 = googleHomeSmartLight;
                    this.L$3 = it;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.label = 8;
                    if (companion4.level(list3, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 8:
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i = this.I$0;
                    obj2 = this.L$4;
                    it = (Iterator) this.L$3;
                    googleHomeSmartLight = (GoogleHomeSmartLight) this.L$2;
                    iterable = (Iterable) this.L$1;
                    list3 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion3 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                    this.L$0 = list3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable);
                    this.L$2 = googleHomeSmartLight;
                    this.L$3 = it;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.I$0 = i;
                    this.I$1 = i3;
                    this.I$2 = i2;
                    this.label = 9;
                    if (companion3.color(list3, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 9:
                    i2 = this.I$2;
                    i3 = this.I$1;
                    i = this.I$0;
                    obj2 = this.L$4;
                    it = (Iterator) this.L$3;
                    googleHomeSmartLight = (GoogleHomeSmartLight) this.L$2;
                    iterable = (Iterable) this.L$1;
                    list3 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    int i42 = i2;
                    int i52 = i;
                    int i62 = i3;
                    Iterator<Integer> it22 = it;
                    Object obj32 = obj2;
                    Iterable iterable22 = iterable;
                    companion2 = GoogleHomeClient.INSTANCE.getInstance(googleHomeSmartLight.getContext());
                    this.L$0 = list3;
                    this.L$1 = SpillingKt.nullOutSpilledVariable(iterable22);
                    this.L$2 = googleHomeSmartLight;
                    this.L$3 = it22;
                    this.L$4 = SpillingKt.nullOutSpilledVariable(obj32);
                    this.I$0 = i52;
                    this.I$1 = i62;
                    this.I$2 = i42;
                    this.label = 10;
                    if (companion2.toggle(list3, false, (Continuation<? super Unit>) this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 10:
                    int i7 = this.I$0;
                    Iterator<Integer> it3 = (Iterator) this.L$3;
                    GoogleHomeSmartLight googleHomeSmartLight3 = (GoogleHomeSmartLight) this.L$2;
                    Iterable iterable3 = (Iterable) this.L$1;
                    List<? extends HomeDevice> list4 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    googleHomeSmartLight = googleHomeSmartLight3;
                    list3 = list4;
                    iterable = iterable3;
                    i = i7;
                    it = it3;
                    if (it.hasNext()) {
                    }
                    break;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$nightLight$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$nightLight$1", f = "GoogleHomeSmartLight.kt", l = {70, 72, 73, 74, 75, 76, 79, 82}, m = "invokeSuspend", v = 2)
    public static final class C21691 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $timeoutSeconds;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21691(int i, Continuation<? super C21691> continuation) {
            super(2, continuation);
            this.$timeoutSeconds = i;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeSmartLight.this.new C21691(this.$timeoutSeconds, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21691) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x0112, code lost:
        
            if (r7.toggle(r1, false, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r6) == r0) goto L40;
         */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x009b A[PHI: r1
          0x009b: PHI (r1v8 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v5 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v10 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:22:0x0097, B:11:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00b3 A[PHI: r1
          0x00b3: PHI (r1v11 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v8 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v13 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:25:0x00b0, B:10:0x0035] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00cb A[PHI: r1
          0x00cb: PHI (r1v14 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v11 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v16 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:28:0x00c8, B:9:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e3 A[PHI: r1
          0x00e3: PHI (r1v17 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v14 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v19 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:31:0x00e0, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<? extends HomeDevice> list;
            GoogleHomeClient companion;
            List<? extends HomeDevice> list2;
            GoogleHomeClient companion2;
            GoogleHomeClient companion3;
            GoogleHomeClient companion4;
            GoogleHomeClient companion5;
            int i;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Logger.logInfo("Home: nighLight");
                    GoogleHomeSmartLight googleHomeSmartLight = GoogleHomeSmartLight.this;
                    this.label = 1;
                    obj = googleHomeSmartLight.getSelectedDevices(this);
                    if (obj != coroutine_suspended) {
                        list = (List) obj;
                        companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                        this.L$0 = list;
                        this.label = 2;
                        if (companion.level(list, 1, this) != coroutine_suspended) {
                            list2 = list;
                            companion2 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                            this.L$0 = list2;
                            this.label = 3;
                            if (companion2.color(list2, 1, this) != coroutine_suspended) {
                                companion3 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                this.L$0 = list2;
                                this.label = 4;
                                if (companion3.toggle(list2, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                                    companion4 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                    this.L$0 = list2;
                                    this.label = 5;
                                    if (companion4.level(list2, 1, this) != coroutine_suspended) {
                                        companion5 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                        this.L$0 = list2;
                                        this.label = 6;
                                        if (companion5.color(list2, 1, this) != coroutine_suspended) {
                                            i = this.$timeoutSeconds;
                                            if (i > 0) {
                                                this.L$0 = list2;
                                                this.label = 7;
                                                if (DelayKt.delay(((long) i) * 1000, this) != coroutine_suspended) {
                                                }
                                            }
                                            GoogleHomeClient companion6 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                            this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                            this.label = 8;
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return coroutine_suspended;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list;
                    this.label = 2;
                    if (companion.level(list, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 2:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion2 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 3;
                    if (companion2.color(list2, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 3:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion3 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 4;
                    if (companion3.toggle(list2, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 4:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion4 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 5;
                    if (companion4.level(list2, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 5:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion5 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 6;
                    if (companion5.color(list2, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 6:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    i = this.$timeoutSeconds;
                    if (i > 0) {
                    }
                    GoogleHomeClient companion62 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                    this.label = 8;
                    break;
                case 7:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    GoogleHomeClient companion622 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                    this.label = 8;
                    break;
                case 8:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$off$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$off$1", f = "GoogleHomeSmartLight.kt", l = {56, 56}, m = "invokeSuspend", v = 2)
    public static final class C21701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public C21701(Continuation<? super C21701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeSmartLight.this.new C21701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
        
            if (r1.toggle((java.util.List<? extends com.google.home.HomeDevice>) r5, false, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r4) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            GoogleHomeClient companion;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.logInfo("Home: off");
                companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                GoogleHomeSmartLight googleHomeSmartLight = GoogleHomeSmartLight.this;
                this.L$0 = companion;
                this.label = 1;
                obj = googleHomeSmartLight.getSelectedDevices(this);
                if (obj != coroutine_suspended) {
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
            companion = (GoogleHomeClient) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.L$0 = null;
            this.label = 2;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$sunrise$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$sunrise$1", f = "GoogleHomeSmartLight.kt", l = {92, 96, 97}, m = "invokeSuspend", v = 2)
    public static final class C21711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $max;
        final /* synthetic */ int $progress;
        int I$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C21711(int i, int i2, Continuation<? super C21711> continuation) {
            super(2, continuation);
            this.$progress = i;
            this.$max = i2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeSmartLight.this.new C21711(this.$progress, this.$max, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x008e, code lost:
        
            if (r9.color(r3, r1, r8) != r0) goto L22;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int iCoerceAtMost;
            List<? extends HomeDevice> list;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GoogleHomeSmartLight googleHomeSmartLight = GoogleHomeSmartLight.this;
                this.label = 1;
                obj = googleHomeSmartLight.getSelectedDevices(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i != 2) {
                    if (i != 3) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                iCoerceAtMost = this.I$0;
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                GoogleHomeClient companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.I$0 = iCoerceAtMost;
                this.label = 3;
            }
            List<? extends HomeDevice> list2 = (List) obj;
            iCoerceAtMost = RangesKt.coerceAtMost(RangesKt.coerceAtLeast((int) ((((double) this.$progress) / ((double) this.$max)) * 100.0d), 0), 100);
            zza$$ExternalSyntheticOutline0.m(iCoerceAtMost, "Home: sun level ");
            GoogleHomeClient companion2 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
            this.L$0 = list2;
            this.I$0 = iCoerceAtMost;
            this.label = 2;
            if (companion2.level(list2, iCoerceAtMost, this) != coroutine_suspended) {
                list = list2;
                GoogleHomeClient companion3 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.I$0 = iCoerceAtMost;
                this.label = 3;
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$sunriseFull$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$sunriseFull$1", f = "GoogleHomeSmartLight.kt", l = {122, 124, 125, 126}, m = "invokeSuspend", v = 2)
    public static final class C21721 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public C21721(Continuation<? super C21721> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeSmartLight.this.new C21721(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21721) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x0096, code lost:
        
            if (r9.color(r1, 100, r8) != r0) goto L27;
         */
        /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[PHI: r1
          0x007e: PHI (r1v6 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v5 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v10 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:22:0x007b, B:11:0x0026] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<? extends HomeDevice> list;
            GoogleHomeClient companion;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Logger.logInfo("Home: sunriseFull ");
                GoogleHomeSmartLight googleHomeSmartLight = GoogleHomeSmartLight.this;
                this.label = 1;
                obj = googleHomeSmartLight.getSelectedDevices(this);
                if (obj != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                if (i == 2) {
                    list = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list;
                    this.label = 3;
                    if (companion.level(list, 100, this) != coroutine_suspended) {
                        GoogleHomeClient companion2 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                        this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                        this.label = 4;
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    if (i != 4) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                list = (List) this.L$0;
                ResultKt.throwOnFailure(obj);
                GoogleHomeClient companion22 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                this.L$0 = SpillingKt.nullOutSpilledVariable(list);
                this.label = 4;
            }
            List<? extends HomeDevice> list2 = (List) obj;
            GoogleHomeClient companion3 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
            this.L$0 = list2;
            this.label = 2;
            if (companion3.toggle(list2, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                list = list2;
                companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                this.L$0 = list;
                this.label = 3;
                if (companion.level(list, 100, this) != coroutine_suspended) {
                }
            }
            return coroutine_suspended;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$sunriseStart$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight$sunriseStart$1", f = "GoogleHomeSmartLight.kt", l = {107, 109, 110, 111, 112, 113}, m = "invokeSuspend", v = 2)
    public static final class C21731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        public C21731(Continuation<? super C21731> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoogleHomeSmartLight.this.new C21731(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C21731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00d0, code lost:
        
            if (r5.color(r1, 1, r4) != r0) goto L31;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0087 A[PHI: r1
          0x0087: PHI (r1v8 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v5 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v10 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:20:0x0084, B:9:0x002c] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[PHI: r1
          0x009f: PHI (r1v11 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v8 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v13 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:23:0x009c, B:8:0x0023] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00b7 A[PHI: r1
          0x00b7: PHI (r1v14 java.util.List<? extends com.google.home.HomeDevice>) = 
          (r1v11 java.util.List<? extends com.google.home.HomeDevice>)
          (r1v16 java.util.List<? extends com.google.home.HomeDevice>)
         binds: [B:26:0x00b4, B:7:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List<? extends HomeDevice> list;
            GoogleHomeClient companion;
            List<? extends HomeDevice> list2;
            GoogleHomeClient companion2;
            GoogleHomeClient companion3;
            GoogleHomeClient companion4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Logger.logInfo("Home: sunStart ");
                    GoogleHomeSmartLight googleHomeSmartLight = GoogleHomeSmartLight.this;
                    this.label = 1;
                    obj = googleHomeSmartLight.getSelectedDevices(this);
                    if (obj != coroutine_suspended) {
                        list = (List) obj;
                        companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                        this.L$0 = list;
                        this.label = 2;
                        if (companion.level(list, 1, this) != coroutine_suspended) {
                            list2 = list;
                            companion2 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                            this.L$0 = list2;
                            this.label = 3;
                            if (companion2.color(list2, 1, this) != coroutine_suspended) {
                                companion3 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                this.L$0 = list2;
                                this.label = 4;
                                if (companion3.toggle(list2, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                                    companion4 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                    this.L$0 = list2;
                                    this.label = 5;
                                    if (companion4.level(list2, 1, this) != coroutine_suspended) {
                                        GoogleHomeClient companion5 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                                        this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                                        this.label = 6;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    return coroutine_suspended;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    list = (List) obj;
                    companion = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list;
                    this.label = 2;
                    if (companion.level(list, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 2:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion2 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 3;
                    if (companion2.color(list2, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 3:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion3 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 4;
                    if (companion3.toggle(list2, true, (Continuation<? super Unit>) this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 4:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    companion4 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = list2;
                    this.label = 5;
                    if (companion4.level(list2, 1, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                case 5:
                    list2 = (List) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    GoogleHomeClient companion52 = GoogleHomeClient.INSTANCE.getInstance(GoogleHomeSmartLight.this.getContext());
                    this.L$0 = SpillingKt.nullOutSpilledVariable(list2);
                    this.label = 6;
                    break;
                case 6:
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                default:
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
            }
        }
    }

    public GoogleHomeSmartLight() {
        this.$$delegate_0 = CoroutineScopeKt.MainScope();
        this.coroutineContext = Dispatchers.getIO().plus(new GoogleHomeSmartLight$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.INSTANCE, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object getSelectedDevices(Continuation<? super List<? extends HomeDevice>> continuation) {
        return GoogleHomeClient.INSTANCE.getInstance(getContext()).getSelectedDevices(new Configuration(getContext(), null, 2, 0 == true ? 1 : 0).getSelectedLights(), continuation);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public /* bridge */ void close() {
        super.close();
    }

    public final Context getContext() {
        Context context = this.context;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException(IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME);
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint(int loop) {
        Logger.logInfo("Home: hint " + loop);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new AnonymousClass1(loop, this, null), 3, null);
    }

    public boolean isConnected() {
        return SharedApplicationContext.getSettings().isGoogleHomeSmartlight();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void nightLight(int timeoutSeconds) {
        Logger.logInfo("Home: nighLight");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21691(timeoutSeconds, null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off() {
        Logger.logInfo("Home: off");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21701(null), 3, null);
    }

    public final void setContext(Context context) {
        context.getClass();
        this.context = context;
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
        hint(1);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunrise(int progress, int max) {
        Logger.logInfo("Home: sun " + progress + " " + max);
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21711(progress, max, null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseFull() {
        Logger.logInfo("Home: sunriseFull ");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21721(null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseStart() {
        Logger.logInfo("Home: sunStart ");
        BuildersKt__Builders_commonKt.launch$default(this, null, null, new C21731(null), 3, null);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off(boolean force) {
        off();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GoogleHomeSmartLight(Context context) {
        this();
        context.getClass();
        setContext(context);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint() {
        hint(3);
    }
}
