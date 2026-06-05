package com.urbandroid.sleep.fragment.dashboard;

import android.app.Activity;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.NewsCard;
import com.urbandroid.sleep.fragment.dashboard.card.PageAwareDashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.UndoCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class DashboardAdapter extends RecyclerView.Adapter implements ItemTouchHelperAdapter {
    private List<DashboardCard<?>> cards = new ArrayList();
    private Activity context;
    private RecyclerView recyclerView;
    private Animation revealAnim;

    public DashboardAdapter(Activity activity) {
        this.revealAnim = AnimationUtils.loadAnimation(activity, R.anim.scale_show_card);
        this.context = activity;
    }

    public List<DashboardCard<?>> getCards() {
        return this.cards;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.cards.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.cards.get(i).getType().ordinal();
    }

    public RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        DashboardCard<?> dashboardCard = this.cards.get(i);
        dashboardCard.bindView(viewHolder);
        TextView textView = (TextView) viewHolder.itemView.findViewById(R.id.title);
        if (textView != null) {
            if (dashboardCard.isPinned()) {
                textView.setCompoundDrawablesWithIntrinsicBounds(dashboardCard.isThemeCard() ? R.drawable.ic_pin_small : R.drawable.ic_pin_small_white, 0, 0, 0);
                textView.setCompoundDrawablePadding(ActivityUtils.getDip(this.context, 4));
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        viewHolder.itemView.setVisibility(0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        for (DashboardCard<?> dashboardCard : this.cards) {
            if (dashboardCard.getType().ordinal() == i) {
                return dashboardCard.getViewHolder(viewGroup);
            }
        }
        return null;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.ItemTouchHelperAdapter
    public void onItemDismiss(int i, int i2) {
        DashboardCard<?> dashboardCard = this.cards.get(i);
        if (dashboardCard instanceof PageAwareDashboardCard) {
            if (i2 == 32) {
                ((PageAwareDashboardCard) dashboardCard).next();
                return;
            } else {
                if (i2 == 16) {
                    ((PageAwareDashboardCard) dashboardCard).prev();
                    return;
                }
                return;
            }
        }
        if (!dashboardCard.isRemovable()) {
            if (dashboardCard instanceof NewsCard) {
                dashboardCard.removeForNow();
                ((NewsCard) dashboardCard).setCurrentNewsAsShown();
                return;
            }
            return;
        }
        dashboardCard.setRemovedBySwipe();
        this.cards.remove(i);
        notifyItemRemoved(i);
        if (dashboardCard instanceof UndoCard) {
            return;
        }
        UndoCard undoCard = new UndoCard(this.context, dashboardCard);
        undoCard.setAdapter(this);
        this.cards.add(i, undoCard);
        notifyItemInserted(i);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.ItemTouchHelperAdapter
    public void onItemMove(int i, int i2) {
        if (this.cards.get(i).canChangePosition()) {
            if (i < i2) {
                int i3 = i;
                while (i3 < i2) {
                    int i4 = i3 + 1;
                    Collections.swap(this.cards, i3, i4);
                    i3 = i4;
                }
            } else {
                for (int i5 = i; i5 > i2; i5--) {
                    Collections.swap(this.cards, i5, i5 - 1);
                }
            }
            notifyItemMoved(i, i2);
        }
    }

    public void refreshCards(List<DashboardCard<?>> list) {
        setCards(list);
        notifyDataSetChanged();
    }

    public void saveCards() {
        Iterator<DashboardCard<?>> it = this.cards.iterator();
        while (it.hasNext()) {
            it.next().save();
        }
    }

    public void setCards(List<DashboardCard<?>> list) {
        this.cards = list;
        Iterator<DashboardCard<?>> it = list.iterator();
        while (it.hasNext()) {
            it.next().setAdapter(this);
        }
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
