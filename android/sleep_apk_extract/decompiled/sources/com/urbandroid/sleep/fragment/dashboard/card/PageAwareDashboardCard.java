package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;

/* JADX INFO: loaded from: classes4.dex */
public abstract class PageAwareDashboardCard<T extends RecyclerView.ViewHolder> extends DashboardCard<T> {
    public PageAwareDashboardCard(Activity activity, DashboardCard.Type type, int i) {
        super(activity, type, i);
    }

    public abstract void next();

    public abstract void prev();
}
