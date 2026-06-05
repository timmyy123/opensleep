package com.urbandroid.sleep.ai;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.google.firebase.ai.type.Content;
import com.google.firebase.ai.type.GenerationConfig;
import com.urbandroid.sleep.audio.AudioRecorder;
import com.urbandroid.sleep.audio.consumer.TensorflowAudioConsumerV4Kt;
import com.urbandroid.sleep.autostart.ExpectedTrackingRange;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.fragment.dashboard.DashboardCardBuilder;
import com.urbandroid.sleep.fragment.dashboard.card.InterestingNoiseCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailCommentCard$startRecogition$listener$1;
import com.urbandroid.sleep.fragment.dashboard.morning.MorningCardBuilder;
import com.urbandroid.sleep.hr.DeviceDetectionResult;
import com.urbandroid.sleep.hr.SmartScanKt;
import com.urbandroid.sleep.nearby.core.ConnectionStatus;
import com.urbandroid.sleep.nearby.core.Endpoint;
import com.urbandroid.sleep.nearby.core.ReliableMessageQueue;
import com.urbandroid.sleep.service.automation.AutomationService;
import com.urbandroid.sleep.service.automation.AutomationTrigger;
import com.urbandroid.sleep.service.awake.AwakeWhenHighActivity;
import com.urbandroid.sleep.service.google.calendar.alarm.GoogleCalendarAlarmManager;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendarKt;
import com.urbandroid.sleep.service.health.HeathSyncKt;
import com.urbandroid.sleep.service.health.session.HealthSessionSegment;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AiPrompt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ AiPrompt$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return AiPrompt.askFollowUp$lambda$0((Content.Builder) obj);
            case 1:
                return AiActivity.onCreate$lambda$2((GenerationConfig.Builder) obj);
            case 2:
                return AiPrompt.askFollowUp$lambda$1((Content.Builder) obj);
            case 3:
                return Boolean.valueOf(AudioRecorder.resume$lambda$0$1((AudioRecorder.Consumer) obj));
            case 4:
                return Boolean.valueOf(AudioRecorder.resume$lambda$0$2((AudioRecorder.Consumer) obj));
            case 5:
                return Boolean.valueOf(AudioRecorder.openConsumers$lambda$0((AudioRecorder.Consumer) obj));
            case 6:
                return Boolean.valueOf(TensorflowAudioConsumerV4Kt.nullHandler$lambda$0(((Float) obj).floatValue()));
            case 7:
                return Long.valueOf(ExpectedTrackingRange.Companion.calculate$lambda$0((Context) obj));
            case 8:
                return DashboardCardBuilder.loadData$lambda$1$1((Noise) obj);
            case 9:
                return DashboardCardBuilder.loadData$lambda$1$2((Noise) obj);
            case 10:
                return InterestingNoiseCard.bindView$lambda$1((Noise) obj);
            case 11:
                return InterestingNoiseCard.bindView$lambda$2((Noise) obj);
            case 12:
                return SleepDetailCommentCard$startRecogition$listener$1.onResults$lambda$0((String) obj);
            case 13:
                return MorningCardBuilder.loadData$lambda$0$1((Noise) obj);
            case 14:
                return MorningCardBuilder.loadData$lambda$0$2((Noise) obj);
            case 15:
                return SmartScanKt.unrecognizedDevice$lambda$0((Context) obj);
            case 16:
                return SmartScanKt.smartScan2$lambda$0((BluetoothDevice) obj);
            case 17:
                return SmartScanKt.smartScan2$lambda$1((DeviceDetectionResult) obj);
            case 18:
                return SmartScanKt.smartScan2$lambda$2((DeviceDetectionResult) obj);
            case 19:
                return Endpoint._init_$lambda$0((ConnectionStatus) obj);
            case 20:
                return ReliableMessageQueue._init_$lambda$0((ConnectionStatus) obj);
            case 21:
                return AutomationService.getNotification$lambda$1$0((AutomationTrigger) obj);
            case 22:
                return Boolean.valueOf(AwakeWhenHighActivity.UNINITIALIZED$lambda$0(((Float) obj).floatValue()));
            case 23:
                return GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$3((GoogleCalendar.Event) obj);
            case 24:
                return GoogleCalendarAlarmManager.skipNextIfHoliday$lambda$6$0((GoogleCalendar.Event) obj);
            case 25:
                return Boolean.valueOf(CalendarProviderApi.getPrimaryCalendar$lambda$0((GoogleCalendar) obj));
            case 26:
                return Boolean.valueOf(CalendarProviderApi.getHolidayCalendars$lambda$0((GoogleCalendar) obj));
            case 27:
                return Boolean.valueOf(CalendarProviderApi.getOrCreateSleepCalendar$lambda$0((GoogleCalendar) obj));
            case 28:
                return GoogleCalendarKt.anonymousIds$lambda$0((GoogleCalendar) obj);
            default:
                return HeathSyncKt.pretty$lambda$0((HealthSessionSegment) obj);
        }
    }
}
