package com.urbandroid.sleep.alarmclock;

import android.app.Activity;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.urbandroid.sleep.trial.IBillingStatusListener;
import com.urbandroid.sleep.trial.JavaBilling;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class AlarmClock$$ExternalSyntheticLambda2 implements NavigationBarView.OnItemSelectedListener, IBillingStatusListener, JavaBilling.SkuDetailListener {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ AlarmClock$$ExternalSyntheticLambda2(Object obj, Object obj2) {
        this.f$0 = obj;
        this.f$1 = obj2;
    }

    @Override // com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        return ((AlarmClock) this.f$0).lambda$initTabs$21((BottomNavigationView) this.f$1, menuItem);
    }

    @Override // com.urbandroid.sleep.trial.IBillingStatusListener
    public void onStatusDetected(String str, IBillingStatusListener.Status status) {
        AlarmClock.lambda$initializeBilling$23((Activity) this.f$0, (IBillingStatusListener) this.f$1, str, status);
    }
}
