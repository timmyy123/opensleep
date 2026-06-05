package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.integrity.IntegrityManager;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001b\u0010\u0003\u001a\u00020\u00022\f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\u0003\u0010\b\u001a%\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001d\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001aO\u0010\u001e\u001a\u00020\u001d*\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0004\b\u001e\u0010\u001f\u001aM\u0010\"\u001a\u00020\u001d*\u00020\u00122\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130 2\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u001c\u0010\u001c\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010(\u001a\u00020'2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0002¢\u0006\u0004\b(\u0010)¨\u0006*"}, d2 = {"", "bytes", "", InAppPurchaseConstants.METHOD_TO_STRING, "([B)Ljava/lang/String;", "toHexString", "", "", "(Ljava/util/Collection;)Ljava/lang/String;", "", "x", "low", "high", "", "checkRange", "(III)V", "toInt", "(BB)I", "Lkotlinx/coroutines/CoroutineScope;", "", "initialDelayMillis", "delayMillis", "Lkotlin/Function0;", "", "repeatWhile", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "block", "Lkotlinx/coroutines/Job;", "runWithFixedDelay", "(Lkotlinx/coroutines/CoroutineScope;JJLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "", "delaysMillis", "runWithDynamicDelay", "(Lkotlinx/coroutines/CoroutineScope;Ljava/util/Iterator;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/Job;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Landroid/bluetooth/BluetoothDevice;", "getBluetoothDevice", "(Landroid/content/Context;Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;", "Sleep_prodRelease"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class BLEUtilKt {

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEUtilKt$runWithDynamicDelay$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEUtilKt$runWithDynamicDelay$3", f = "BLEUtil.kt", l = {104, 106}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Iterator<Long> $delaysMillis;
        final /* synthetic */ Function0<Boolean> $repeatWhile;
        long J$0;
        Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Iterator<Long> it, Function0<Boolean> function0, Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$delaysMillis = it;
            this.$repeatWhile = function0;
            this.$block = function1;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$delaysMillis, this.$repeatWhile, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0065, code lost:
        
            if (r7.invoke(r6) == r0) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0065 -> B:7:0x0015). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Iterator<Long> it;
            long jLongValue;
            Iterator<Long> it2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                it = this.$delaysMillis;
                if (it.hasNext()) {
                }
                return Unit.INSTANCE;
            }
            if (i == 1) {
                jLongValue = this.J$0;
                it2 = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (this.$repeatWhile.invoke().booleanValue()) {
                }
                return Unit.INSTANCE;
            }
            if (i != 2) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            it2 = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
            it = it2;
            if (it.hasNext()) {
                jLongValue = it.next().longValue();
                this.L$0 = it;
                this.J$0 = jLongValue;
                this.label = 1;
                if (DelayKt.delay(jLongValue, this) != coroutine_suspended) {
                    it2 = it;
                    if (this.$repeatWhile.invoke().booleanValue()) {
                        Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                        this.L$0 = it2;
                        this.J$0 = jLongValue;
                        this.label = 2;
                    }
                }
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.bluetoothle.BLEUtilKt$runWithFixedDelay$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.bluetoothle.BLEUtilKt$runWithFixedDelay$3", f = "BLEUtil.kt", l = {83, 85, 86}, m = "invokeSuspend", v = 2)
    public static final class C20963 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ long $delayMillis;
        final /* synthetic */ long $initialDelayMillis;
        final /* synthetic */ Function0<Boolean> $repeatWhile;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C20963(long j, Function0<Boolean> function0, Function1<? super Continuation<? super Unit>, ? extends Object> function1, long j2, Continuation<? super C20963> continuation) {
            super(2, continuation);
            this.$initialDelayMillis = j;
            this.$repeatWhile = function0;
            this.$block = function1;
            this.$delayMillis = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C20963(this.$initialDelayMillis, this.$repeatWhile, this.$block, this.$delayMillis, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C20963) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0053  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0050 -> B:15:0x002f). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            long j;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j2 = this.$initialDelayMillis;
                this.label = 1;
                if (DelayKt.delay(j2, this) != coroutine_suspended) {
                }
                return coroutine_suspended;
            }
            if (i != 1) {
                if (i == 2) {
                    ResultKt.throwOnFailure(obj);
                    j = this.$delayMillis;
                    this.label = 3;
                    if (DelayKt.delay(j, this) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
                if (i != 3) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
            }
            ResultKt.throwOnFailure(obj);
            if (!this.$repeatWhile.invoke().booleanValue()) {
                Function1<Continuation<? super Unit>, Object> function1 = this.$block;
                this.label = 2;
                if (function1.invoke(this) != coroutine_suspended) {
                    j = this.$delayMillis;
                    this.label = 3;
                    if (DelayKt.delay(j, this) != coroutine_suspended) {
                        if (!this.$repeatWhile.invoke().booleanValue()) {
                            return Unit.INSTANCE;
                        }
                    }
                }
                return coroutine_suspended;
            }
        }
    }

    public static final void checkRange(int i, int i2, int i3) {
        if (i < i2 || i > i3) {
            throw new IllegalArgumentException((i + " should be between " + i2 + " and " + i3 + " (inclusive)").toString());
        }
    }

    public static final BluetoothDevice getBluetoothDevice(Context context, String str) {
        context.getClass();
        str.getClass();
        Object systemService = context.getSystemService("bluetooth");
        if (systemService == null) {
            Events$$ExternalSyntheticBUOutline0.m("Unable to initialize BluetoothManager");
            return null;
        }
        BluetoothAdapter adapter = ((BluetoothManager) systemService).getAdapter();
        if (adapter == null) {
            Events$$ExternalSyntheticBUOutline0.m("Unable to obtain a BluetoothAdapter");
            return null;
        }
        if (!adapter.isEnabled()) {
            Events$$ExternalSyntheticBUOutline0.m("BluetoothAdapter not enabled");
            return null;
        }
        try {
            BluetoothDevice remoteDevice = adapter.getRemoteDevice(str);
            remoteDevice.getClass();
            return remoteDevice;
        } catch (IllegalArgumentException e) {
            throw new BluetoothException(e);
        }
    }

    public static final Job runWithDynamicDelay(CoroutineScope coroutineScope, Iterator<Long> it, Function0<Boolean> function0, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        coroutineScope.getClass();
        it.getClass();
        function0.getClass();
        function1.getClass();
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new AnonymousClass3(it, function0, function1, null), 3, null);
    }

    public static final Job runWithFixedDelay(CoroutineScope coroutineScope, long j, long j2, Function0<Boolean> function0, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        coroutineScope.getClass();
        function0.getClass();
        function1.getClass();
        if (j2 > 0) {
            return BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C20963(j, function0, function1, j2, null), 3, null);
        }
        throw new IllegalArgumentException((j2 + " <= 0").toString());
    }

    public static final String toHexString(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Integer.valueOf(b & 255));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.toHexString(((Number) it.next()).intValue()));
        }
        return arrayList2.toString();
    }

    public static final int toInt(byte b, byte b2) {
        return ((b << 8) & 65280) + (b2 & 255);
    }

    public static final String toString(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b : bArr) {
            arrayList.add(Integer.valueOf(b & 255));
        }
        return arrayList.toString();
    }

    public static final String toString(Collection<Byte> collection) {
        collection.getClass();
        return toString(CollectionsKt.toByteArray(collection));
    }
}
