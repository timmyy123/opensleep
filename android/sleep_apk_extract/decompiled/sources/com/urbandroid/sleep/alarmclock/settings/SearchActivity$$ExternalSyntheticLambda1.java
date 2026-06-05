package com.urbandroid.sleep.alarmclock.settings;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class SearchActivity$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ SearchActivity f$0;

    public /* synthetic */ SearchActivity$$ExternalSyntheticLambda1(SearchActivity searchActivity, int i) {
        this.$r8$classId = i;
        this.f$0 = searchActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        SearchActivity searchActivity = this.f$0;
        switch (i) {
            case 0:
                SearchActivity.onCreate$lambda$1(searchActivity);
                break;
            default:
                SearchActivity.onOptionsItemSelected$lambda$0(searchActivity);
                break;
        }
    }
}
