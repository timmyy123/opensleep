package com.facebook.internal.instrument;

import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class InstrumentUtility$$ExternalSyntheticLambda0 implements FilenameFilter {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ InstrumentUtility$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.$r8$classId) {
            case 0:
                return InstrumentUtility.listExceptionReportFiles$lambda$3(file, str);
            case 1:
                return InstrumentUtility.listAnrReportFiles$lambda$1(file, str);
            case 2:
                return InstrumentUtility.listExceptionAnalysisReportFiles$lambda$2(file, str);
            default:
                return ErrorReportHandler.listErrorReportFiles$lambda$3(file, str);
        }
    }
}
