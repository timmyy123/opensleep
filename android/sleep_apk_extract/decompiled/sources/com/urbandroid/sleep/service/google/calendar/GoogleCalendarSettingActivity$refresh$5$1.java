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
import kotlinx.coroutines.CoroutineScope;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
@DebugMetadata(c = "com.urbandroid.sleep.service.google.calendar.GoogleCalendarSettingActivity$refresh$5$1", f = "GoogleCalendarSettingActivity.kt", l = {213}, m = "invokeSuspend", v = 2)
public final class GoogleCalendarSettingActivity$refresh$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountName;
    final /* synthetic */ CheckBoxPreference $eventPreference;
    int label;
    final /* synthetic */ GoogleCalendarSettingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSettingActivity$refresh$5$1(GoogleCalendarSettingActivity googleCalendarSettingActivity, String str, CheckBoxPreference checkBoxPreference, Continuation<? super GoogleCalendarSettingActivity$refresh$5$1> continuation) {
        super(2, continuation);
        this.this$0 = googleCalendarSettingActivity;
        this.$accountName = str;
        this.$eventPreference = checkBoxPreference;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeSuspend$lambda$0(DialogInterface dialogInterface, int i) {
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GoogleCalendarSettingActivity$refresh$5$1(this.this$0, this.$accountName, this.$eventPreference, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GoogleCalendarSettingActivity$refresh$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CachedCalendarProviderApi cachedCalendarProviderApi = this.this$0.calendarProvider;
                if (cachedCalendarProviderApi == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("calendarProvider");
                    cachedCalendarProviderApi = null;
                }
                this.label = 1;
                obj = cachedCalendarProviderApi.getPrimaryCalendar(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            GoogleCalendar googleCalendar = (GoogleCalendar) obj;
            GoogleCalendarSettingActivity googleCalendarSettingActivity = this.this$0;
            if (googleCalendar == null) {
                String str = "Personal Google Calendar not found for " + this.$accountName;
                Logger.logWarning(Logger.defaultTag, googleCalendarSettingActivity.getTag() + ": " + str, null);
                this.$eventPreference.setChecked(false);
                AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(this.this$0).setMessage((CharSequence) ("\nPersonal Google Calendar not found for " + this.$accountName + "\n")).setNeutralButton(this.this$0.getResources().getText(R.string.button_cancel), (DialogInterface.OnClickListener) new GoogleCalendarSettingActivity$refresh$3$1$$ExternalSyntheticLambda0(2)).create();
                alertDialogCreate.getClass();
                alertDialogCreate.show();
            } else {
                String str2 = Logger.defaultTag;
                Logger.logInfo(str2, googleCalendarSettingActivity.getTag() + ": " + ("Personal Google Calendar found: " + googleCalendar), null);
            }
        } catch (Exception e) {
            Logger.logSevere(Logger.defaultTag, this.this$0.getTag(), e);
        }
        return Unit.INSTANCE;
    }
}
