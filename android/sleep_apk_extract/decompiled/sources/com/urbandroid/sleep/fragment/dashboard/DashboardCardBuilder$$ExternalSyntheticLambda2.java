package com.urbandroid.sleep.fragment.dashboard;

import android.app.Activity;
import android.speech.SpeechRecognizer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class DashboardCardBuilder$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Activity f$0;

    public /* synthetic */ DashboardCardBuilder$$ExternalSyntheticLambda2(Activity activity, int i) {
        this.$r8$classId = i;
        this.f$0 = activity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Activity activity = this.f$0;
        switch (i) {
            case 0:
                return DashboardCardBuilder.initTutorial$lambda$0$0(activity);
            case 1:
                return DashboardCardBuilder.initTutorial$lambda$0$17(activity);
            case 2:
                return DashboardCardBuilder.initTutorial$lambda$0$1(activity);
            case 3:
                return DashboardCardBuilder.initTutorial$lambda$0$2(activity);
            case 4:
                return DashboardCardBuilder.initTutorial$lambda$0$3(activity);
            case 5:
                return DashboardCardBuilder.initTutorial$lambda$0$4(activity);
            case 6:
                return DashboardCardBuilder.initTutorial$lambda$0$5(activity);
            case 7:
                return DashboardCardBuilder.initTutorial$lambda$0$6(activity);
            case 8:
                return DashboardCardBuilder.initTutorial$lambda$0$7(activity);
            case 9:
                return DashboardCardBuilder.initTutorial$lambda$0$8(activity);
            case 10:
                return DashboardCardBuilder.initTutorial$lambda$0$9(activity);
            case 11:
                return DashboardCardBuilder.initTutorial$lambda$0$10(activity);
            case 12:
                return DashboardCardBuilder.initTutorial$lambda$0$11(activity);
            case 13:
                return DashboardCardBuilder.initTutorial$lambda$0$12(activity);
            case 14:
                return DashboardCardBuilder.initTutorial$lambda$0$13(activity);
            case 15:
                return DashboardCardBuilder.initTutorial$lambda$0$14(activity);
            case 16:
                return DashboardCardBuilder.initTutorial$lambda$0$15(activity);
            case 17:
                return DashboardCardBuilder.initTutorial$lambda$0$16(activity);
            default:
                return SpeechRecognizer.createSpeechRecognizer(activity);
        }
    }
}
