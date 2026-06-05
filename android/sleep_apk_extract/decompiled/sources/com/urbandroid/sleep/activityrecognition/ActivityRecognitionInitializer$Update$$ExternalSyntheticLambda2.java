package com.urbandroid.sleep.activityrecognition;

import com.google.android.gms.tasks.OnFailureListener;
import com.urbandroid.sleep.activityrecognition.ActivityRecognitionInitializer;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ActivityRecognitionInitializer$Update$$ExternalSyntheticLambda2 implements OnFailureListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ ActivityRecognitionInitializer f$0;

    public /* synthetic */ ActivityRecognitionInitializer$Update$$ExternalSyntheticLambda2(ActivityRecognitionInitializer activityRecognitionInitializer, int i) {
        this.$r8$classId = i;
        this.f$0 = activityRecognitionInitializer;
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        int i = this.$r8$classId;
        ActivityRecognitionInitializer activityRecognitionInitializer = this.f$0;
        switch (i) {
            case 0:
                ActivityRecognitionInitializer.Update.initialize$lambda$0$0$3(activityRecognitionInitializer, exc);
                break;
            case 1:
                ActivityRecognitionInitializer.Transition.initialize$lambda$0$2(activityRecognitionInitializer, exc);
                break;
            default:
                ActivityRecognitionInitializer.Transition.initializeOld$lambda$0$0$2(activityRecognitionInitializer, exc);
                break;
        }
    }
}
