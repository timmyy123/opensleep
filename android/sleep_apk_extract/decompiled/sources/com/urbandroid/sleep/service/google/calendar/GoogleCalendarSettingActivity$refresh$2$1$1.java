package com.urbandroid.sleep.service.google.calendar;

import android.content.DialogInterface;
import android.preference.CheckBoxPreference;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.NonCancellable;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$refresh$2$1$1", f = "GoogleCalendarSettingActivity.kt", l = {113, 128, 128, 128}, m = "invokeSuspend", v = 2)
public final class GoogleCalendarSettingActivity$refresh$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CheckBoxPreference $backupPreference;
    final /* synthetic */ Job $progressJob;
    Object L$0;
    int label;
    final /* synthetic */ GoogleCalendarSettingActivity this$0;

    /* JADX INFO: renamed from: com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$refresh$2$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$refresh$2$1$1$1", f = "GoogleCalendarSettingActivity.kt", l = {}, m = "invokeSuspend", v = 2)
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CheckBoxPreference $backupPreference;
        final /* synthetic */ Job $progressJob;
        int label;
        final /* synthetic */ GoogleCalendarSettingActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Job job, CheckBoxPreference checkBoxPreference, GoogleCalendarSettingActivity googleCalendarSettingActivity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$progressJob = job;
            this.$backupPreference = checkBoxPreference;
            this.this$0 = googleCalendarSettingActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$progressJob, this.$backupPreference, this.this$0, continuation);
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
            Job.cancel$default(this.$progressJob, null, 1, null);
            this.$backupPreference.setSummary("");
            this.this$0.setEnableOptions(true);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSettingActivity$refresh$2$1$1(GoogleCalendarSettingActivity googleCalendarSettingActivity, CheckBoxPreference checkBoxPreference, Job job, Continuation<? super GoogleCalendarSettingActivity$refresh$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = googleCalendarSettingActivity;
        this.$backupPreference = checkBoxPreference;
        this.$progressJob = job;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(DialogInterface dialogInterface, int i) {
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleCalendarSettingActivity$refresh$2$1$1(this.this$0, this.$backupPreference, this.$progressJob, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleCalendarSettingActivity$refresh$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00eb, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r13, r0, r12) == r2) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010c, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r13, r0, r12) != r2) goto L38;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        int i2 = 1;
        try {
            try {
            } catch (Exception e) {
                Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
                NonCancellable nonCancellable = NonCancellable.INSTANCE;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$progressJob, this.$backupPreference, this.this$0, null);
                this.label = 3;
            }
        } catch (Throwable th) {
            NonCancellable nonCancellable2 = NonCancellable.INSTANCE;
            AnonymousClass1 anonymousClass12 = new AnonymousClass1(this.$progressJob, this.$backupPreference, this.this$0, null);
            this.L$0 = th;
            this.label = 4;
            if (BuildersKt.withContext(nonCancellable2, anonymousClass12, this) != coroutine_suspended) {
                throw th;
            }
        }
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.setEnableOptions(false);
            CachedCalendarProviderApi cachedCalendarProviderApi = this.this$0.calendarProvider;
            if (cachedCalendarProviderApi == null) {
                Intrinsics.throwUninitializedPropertyAccessException("calendarProvider");
                cachedCalendarProviderApi = null;
            }
            this.label = 1;
            obj = cachedCalendarProviderApi.getOrCreateSleepCalendar(this);
            if (obj == coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i == 2 || i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i != 4) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            Throwable th2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(obj);
            throw th2;
        }
        ResultKt.throwOnFailure(obj);
        GoogleCalendar googleCalendar = (GoogleCalendar) obj;
        GoogleCalendarSettingActivity googleCalendarSettingActivity = this.this$0;
        String str = Logger.defaultTag;
        Logger.logInfo(str, googleCalendarSettingActivity.getTag() + ": " + ("Sleep Google Calendar found: " + googleCalendar), null);
        boolean z = googleCalendar == null;
        this.$backupPreference.setChecked(!z);
        if (z) {
            GoogleCalendarSettingActivity googleCalendarSettingActivity2 = this.this$0;
            Logger.logWarning(Logger.defaultTag, googleCalendarSettingActivity2.getTag() + ": Sleep Google Calendar not found", null);
            AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this.this$0).setMessage((CharSequence) "\nUnable to create Google Calendar with name Sleep as Android\n").setNeutralButton(this.this$0.getResources().getText(R.string.button_cancel), (DialogInterface.OnClickListener) new GoogleCalendarSettingActivity$refresh$3$1$$ExternalSyntheticLambda0(i2)).create();
            alertDialogCreate.getClass();
            alertDialogCreate.show();
        }
        NonCancellable nonCancellable3 = NonCancellable.INSTANCE;
        AnonymousClass1 anonymousClass13 = new AnonymousClass1(this.$progressJob, this.$backupPreference, this.this$0, null);
        this.label = 2;
    }
}
