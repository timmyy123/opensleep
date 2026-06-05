package com.urbandroid.sleep.service;

import androidx.appsearch.app.AppSearchSchema;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.anrreport.ANRHandler;
import com.facebook.internal.instrument.crashreport.CrashHandler;
import com.facebook.internal.instrument.errorreport.ErrorReportData;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import com.urbandroid.sleep.addon.stats.chart.DiffExtractorRangeChartBuilder;
import com.urbandroid.sleep.addon.stats.chart.ExtractorRangeChartBuilder;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.domain.EventsRawStorageKt;
import com.urbandroid.sleep.domain.IEvent;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Settings$$ExternalSyntheticLambda0 implements Comparator {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Settings$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                return Settings.lambda$getOnlineRadios$0((OnlineRadioRingtones.Radio) obj, (OnlineRadioRingtones.Radio) obj2);
            case 1:
                return AppSearchSchema.lambda$appendAppSearchSchemaString$0((AppSearchSchema.PropertyConfig) obj, (AppSearchSchema.PropertyConfig) obj2);
            case 2:
                return ANRHandler.sendANRReports$lambda$2((InstrumentData) obj, (InstrumentData) obj2);
            case 3:
                return CrashHandler.Companion.sendExceptionReports$lambda$2((InstrumentData) obj, (InstrumentData) obj2);
            case 4:
                return ErrorReportHandler.sendErrorReports$lambda$0((ErrorReportData) obj, (ErrorReportData) obj2);
            case 5:
                return DiffExtractorRangeChartBuilder.prepareYAxis$lambda$0$0((StatRecord) obj, (StatRecord) obj2);
            case 6:
                return ExtractorRangeChartBuilder.prepareYAxis$lambda$0$0((StatRecord) obj, (StatRecord) obj2);
            case 7:
                return StatRepo.lambda$initialize$0((StatRecord) obj, (StatRecord) obj2);
            default:
                return EventsRawStorageKt.read$lambda$0((IEvent) obj, (IEvent) obj2);
        }
    }
}
