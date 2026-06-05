package com.urbandroid.sleep.service.google.calendar;

import android.preference.CheckBoxPreference;
import com.urbandroid.sleep.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$refresh$2$1$progressJob$1", f = "GoogleCalendarSettingActivity.kt", l = {104}, m = "invokeSuspend", v = 2)
public final class GoogleCalendarSettingActivity$refresh$2$1$progressJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckBoxPreference $backupPreference;
    final /* synthetic */ Ref$IntRef $progressState;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GoogleCalendarSettingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSettingActivity$refresh$2$1$progressJob$1(Ref$IntRef ref$IntRef, CheckBoxPreference checkBoxPreference, GoogleCalendarSettingActivity googleCalendarSettingActivity, Continuation<? super GoogleCalendarSettingActivity$refresh$2$1$progressJob$1> continuation) {
        super(2, continuation);
        this.$progressState = ref$IntRef;
        this.$backupPreference = checkBoxPreference;
        this.this$0 = googleCalendarSettingActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        GoogleCalendarSettingActivity$refresh$2$1$progressJob$1 googleCalendarSettingActivity$refresh$2$1$progressJob$1 = new GoogleCalendarSettingActivity$refresh$2$1$progressJob$1(this.$progressState, this.$backupPreference, this.this$0, continuation);
        googleCalendarSettingActivity$refresh$2$1$progressJob$1.L$0 = obj;
        return googleCalendarSettingActivity$refresh$2$1$progressJob$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleCalendarSettingActivity$refresh$2$1$progressJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002d -> B:14:0x0030). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (CoroutineScopeKt.isActive(coroutineScope)) {
            }
        } else {
            if (i != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            ResultKt.throwOnFailure(obj);
            Ref$IntRef ref$IntRef = this.$progressState;
            ref$IntRef.element = (ref$IntRef.element + 1) % 3;
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.$backupPreference.setSummary(this.this$0.getString(R.string.google_calendar_creating_sleep_calendar) + "\t" + StringsKt__StringsJVMKt.repeat(".", this.$progressState.element + 1));
            }
            if (CoroutineScopeKt.isActive(coroutineScope)) {
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(400L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Ref$IntRef ref$IntRef2 = this.$progressState;
                ref$IntRef2.element = (ref$IntRef2.element + 1) % 3;
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                }
                if (CoroutineScopeKt.isActive(coroutineScope)) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
