package androidx.work.impl;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.work.Configuration;
import androidx.work.impl.model.WorkGenerationalId;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV2V4;
import com.facebook.appevents.iap.InAppPurchaseBillingClientWrapperV5V7;
import com.facebook.appevents.iap.InAppPurchaseUtils;
import com.facebook.appevents.suggestedevents.ViewOnClickListener;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.urbandroid.sleep.alarmclock.AlarmClock;
import com.urbandroid.sleep.alarmclock.timepicker.MaterialTimePicker;
import com.urbandroid.sleep.service.Settings;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Schedulers$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;
    public final /* synthetic */ Object f$3;

    public /* synthetic */ Schedulers$$ExternalSyntheticLambda1(InAppPurchaseBillingClientWrapper inAppPurchaseBillingClientWrapper, Runnable runnable, InAppPurchaseUtils.IAPProductType iAPProductType, List list, int i) {
        this.$r8$classId = i;
        this.f$1 = inAppPurchaseBillingClientWrapper;
        this.f$2 = runnable;
        this.f$3 = iAPProductType;
        this.f$0 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$3;
        Object obj2 = this.f$2;
        Object obj3 = this.f$1;
        Object obj4 = this.f$0;
        switch (i) {
            case 0:
                Schedulers.lambda$registerRescheduling$0((List) obj4, (WorkGenerationalId) obj3, (Configuration) obj2, (WorkDatabase) obj);
                break;
            case 1:
                InAppPurchaseBillingClientWrapperV2V4.querySkuDetailsAsync$lambda$1((InAppPurchaseBillingClientWrapperV2V4) obj3, (Runnable) obj2, (InAppPurchaseUtils.IAPProductType) obj, (List) obj4);
                break;
            case 2:
                InAppPurchaseBillingClientWrapperV5V7.queryProductDetailsAsync$lambda$2((InAppPurchaseBillingClientWrapperV5V7) obj3, (Runnable) obj2, (InAppPurchaseUtils.IAPProductType) obj, (List) obj4);
                break;
            case 3:
                ViewOnClickListener.predictAndProcess$lambda$0((JSONObject) obj4, (String) obj3, (ViewOnClickListener) obj2, (String) obj);
                break;
            case 4:
                ((DefaultScheduler) obj4).lambda$schedule$1((TransportContext) obj3, (TransportScheduleCallback) obj2, (EventInternal) obj);
                break;
            case 5:
                ((AlarmClock) obj4).lambda$showRatingPlayStore$24((ReviewManager) obj3, (ReviewInfo) obj2, (Settings) obj);
                break;
            default:
                MaterialTimePicker.show$lambda$5((MaterialTimePicker) obj4, (View) obj3, (View) obj2, (FragmentActivity) obj);
                break;
        }
    }

    public /* synthetic */ Schedulers$$ExternalSyntheticLambda1(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
        this.f$3 = obj4;
    }
}
