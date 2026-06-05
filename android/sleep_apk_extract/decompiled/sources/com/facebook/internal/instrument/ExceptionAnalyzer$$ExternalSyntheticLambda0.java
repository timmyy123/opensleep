package com.facebook.internal.instrument;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.instrument.errorreport.ErrorReportHandler;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ExceptionAnalyzer$$ExternalSyntheticLambda0 implements GraphRequest.Callback {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ ExceptionAnalyzer$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // com.facebook.GraphRequest.Callback
    public final void onCompleted(GraphResponse graphResponse) {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                ExceptionAnalyzer.sendExceptionAnalysisReports$lambda$1((InstrumentData) obj, graphResponse);
                break;
            default:
                ErrorReportHandler.sendErrorReports$lambda$2((ArrayList) obj, graphResponse);
                break;
        }
    }
}
