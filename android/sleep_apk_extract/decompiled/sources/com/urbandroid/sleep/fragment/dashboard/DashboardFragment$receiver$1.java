package com.urbandroid.sleep.fragment.dashboard;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/fragment/dashboard/DashboardFragment$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", SDKConstants.PARAM_INTENT, "Landroid/content/Intent;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DashboardFragment$receiver$1 extends BroadcastReceiver {
    final /* synthetic */ DashboardFragment this$0;

    public DashboardFragment$receiver$1(DashboardFragment dashboardFragment) {
        this.this$0 = dashboardFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$0(DashboardFragment dashboardFragment) {
        List<DashboardCard<?>> cards;
        AppBarLayout appBarLayout;
        AppBarLayout appBarLayout2;
        try {
            FragmentActivity activity = dashboardFragment.getActivity();
            if (activity != null && (appBarLayout2 = (AppBarLayout) activity.findViewById(R.id.appbar)) != null) {
                appBarLayout2.setActivated(true);
            }
            FragmentActivity activity2 = dashboardFragment.getActivity();
            if (activity2 != null && (appBarLayout = (AppBarLayout) activity2.findViewById(R.id.appbar)) != null) {
                appBarLayout.setExpanded(false, true);
            }
            RecyclerView recyclerView = dashboardFragment.cardList;
            if (recyclerView != null) {
                DashboardAdapter dashboardAdapter = dashboardFragment.adapter;
                recyclerView.smoothScrollToPosition(((dashboardAdapter == null || (cards = dashboardAdapter.getCards()) == null) ? 2 : cards.size()) - 1);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onReceive$lambda$1(DashboardFragment dashboardFragment) {
        AppBarLayout appBarLayout;
        try {
            RecyclerView recyclerView = dashboardFragment.cardList;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(0);
            }
            FragmentActivity activity = dashboardFragment.getActivity();
            if (activity == null || (appBarLayout = (AppBarLayout) activity.findViewById(R.id.appbar)) == null) {
                return;
            }
            appBarLayout.setExpanded(true, true);
        } catch (Exception unused) {
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        context.getClass();
        intent.getClass();
        if (!Intrinsics.areEqual(intent.getAction(), "com.urbandroid.sleep.ACTION_DASHBOARD_SCROLL_DOWN")) {
            this.this$0.reload();
            return;
        }
        Handler handler = new Handler();
        final DashboardFragment dashboardFragment = this.this$0;
        final int i = 0;
        handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment$receiver$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                DashboardFragment dashboardFragment2 = dashboardFragment;
                switch (i2) {
                    case 0:
                        DashboardFragment$receiver$1.onReceive$lambda$0(dashboardFragment2);
                        break;
                    default:
                        DashboardFragment$receiver$1.onReceive$lambda$1(dashboardFragment2);
                        break;
                }
            }
        }, 300L);
        final DashboardFragment dashboardFragment2 = this.this$0;
        final int i2 = 1;
        handler.postDelayed(new Runnable() { // from class: com.urbandroid.sleep.fragment.dashboard.DashboardFragment$receiver$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i2;
                DashboardFragment dashboardFragment22 = dashboardFragment2;
                switch (i22) {
                    case 0:
                        DashboardFragment$receiver$1.onReceive$lambda$0(dashboardFragment22);
                        break;
                    default:
                        DashboardFragment$receiver$1.onReceive$lambda$1(dashboardFragment22);
                        break;
                }
            }
        }, 1000L);
    }
}
