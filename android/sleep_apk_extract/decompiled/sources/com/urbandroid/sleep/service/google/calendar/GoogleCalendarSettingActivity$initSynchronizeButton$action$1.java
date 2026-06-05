package com.urbandroid.sleep.service.google.calendar;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.ProgressBar;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.ProgressBarJoiner;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.service.health.HealthManualSynchronizationAction;
import com.urbandroid.sleep.service.health.HealthServiceProvider;
import com.urbandroid.sleep.service.health.HealthSynchronization;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.Arrays;
import java.util.EnumSet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\fH\u0014J\b\u0010\u0011\u001a\u00020\fH\u0014J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"com/urbandroid/sleep/service/google/calendar/GoogleCalendarSettingActivity$initSynchronizeButton$action$1", "Lcom/urbandroid/sleep/service/health/HealthManualSynchronizationAction;", "numberOfCalendars", "", "currentCalendar", "prepareSynchronization", "Lcom/urbandroid/sleep/service/health/HealthSynchronization;", "prepareProgressBarJoiner", "Lcom/urbandroid/common/ProgressBarJoiner;", "progressBar", "Landroid/widget/ProgressBar;", "preSynchronization", "", "activity", "Landroid/app/Activity;", "postSynchronization", "result", "hideProgressBarAndSnackBarOnEnd", "isUpdateProgressEvent", "event", "Lcom/urbandroid/sleep/service/health/HealthSynchronization$ProgressListener$Event;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleCalendarSettingActivity$initSynchronizeButton$action$1 extends HealthManualSynchronizationAction {
    final /* synthetic */ String $accountName;
    private int currentCalendar;
    private final int numberOfCalendars;
    final /* synthetic */ GoogleCalendarSettingActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleCalendarSettingActivity$initSynchronizeButton$action$1(GoogleCalendarSettingActivity googleCalendarSettingActivity, String str, HealthServiceProvider.GoogleCalendar googleCalendar) {
        super(googleCalendarSettingActivity, googleCalendar);
        this.this$0 = googleCalendarSettingActivity;
        this.$accountName = str;
        this.numberOfCalendars = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postSynchronization$lambda$0$0(GoogleCalendarSettingActivity googleCalendarSettingActivity, DialogInterface dialogInterface, int i) {
        googleCalendarSettingActivity.isRunning.set(false);
        googleCalendarSettingActivity.finish();
    }

    @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
    public boolean hideProgressBarAndSnackBarOnEnd() {
        int i = this.currentCalendar + 1;
        this.currentCalendar = i;
        return i == this.numberOfCalendars;
    }

    @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
    public boolean isUpdateProgressEvent(HealthSynchronization.ProgressListener.Event event) {
        event.getClass();
        return EnumSet.of(HealthSynchronization.ProgressListener.Event.LOCAL_DB_READ, HealthSynchronization.ProgressListener.Event.HEALTH_READ, HealthSynchronization.ProgressListener.Event.HEALTH_INSERT).contains(event);
    }

    @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
    public boolean postSynchronization(Activity activity, boolean result) {
        activity.getClass();
        if (result) {
            return this.currentCalendar == this.numberOfCalendars;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(this.this$0);
        GoogleCalendarSettingActivity googleCalendarSettingActivity = this.this$0;
        materialAlertDialogBuilder.setMessage((CharSequence) "Google Calendar with name Sleep not found");
        materialAlertDialogBuilder.setNeutralButton(googleCalendarSettingActivity.getResources().getText(R.string.button_cancel), (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(googleCalendarSettingActivity, 15));
        materialAlertDialogBuilder.create().show();
        return false;
    }

    @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
    public boolean preSynchronization(Activity activity) {
        activity.getClass();
        return true;
    }

    @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
    public ProgressBarJoiner prepareProgressBarJoiner(ProgressBar progressBar) {
        progressBar.getClass();
        int i = this.numberOfCalendars * 3;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = 1;
        }
        ProgressBarJoiner progressBarJoinerFrom = ProgressBarJoiner.from(progressBar, Arrays.copyOf(iArr, i));
        progressBarJoinerFrom.getClass();
        return progressBarJoinerFrom;
    }

    @Override // com.urbandroid.sleep.service.health.HealthManualSynchronizationAction
    public HealthSynchronization<?> prepareSynchronization() {
        this.this$0.setEnableOptions(false);
        return this.this$0.prepareCalendarSynchronization(this.$accountName);
    }
}
