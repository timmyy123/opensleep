package com.urbandroid.sleep.fragment.dashboard;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.fragment.dashboard.card.LayeredViewHolder;
import com.urbandroid.sleep.fragment.dashboard.card.NoSwipeViewHolder;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class SimpleItemTouchHelperCallback extends ItemTouchHelper.Callback {
    private final ItemTouchHelperAdapter adapter;
    private final AtomicBoolean onMove = new AtomicBoolean(false);

    public SimpleItemTouchHelperCallback(ItemTouchHelperAdapter itemTouchHelperAdapter) {
        this.adapter = itemTouchHelperAdapter;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof NoSwipeViewHolder) {
            return;
        }
        if (viewHolder instanceof LayeredViewHolder) {
            ItemTouchHelper.Callback.getDefaultUIUtil().clearView(((LayeredViewHolder) viewHolder).getForeground());
        } else {
            try {
                super.clearView(recyclerView, viewHolder);
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        try {
            if (!((DashboardAdapter) this.adapter).getCards().get(viewHolder.getAdapterPosition()).canBeSwiped()) {
                return 0;
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        return ItemTouchHelper.Callback.makeMovementFlags(3, 48);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (viewHolder instanceof NoSwipeViewHolder) {
            return;
        }
        if (!(viewHolder instanceof LayeredViewHolder) || i != 1) {
            super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
            return;
        }
        View foreground = ((LayeredViewHolder) viewHolder).getForeground();
        if (recyclerView == null || foreground == null) {
            return;
        }
        ItemTouchHelper.Callback.getDefaultUIUtil().onDraw(canvas, recyclerView, foreground, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (viewHolder instanceof NoSwipeViewHolder) {
            return;
        }
        if (!(viewHolder instanceof LayeredViewHolder) || i != 1) {
            super.onChildDrawOver(canvas, recyclerView, viewHolder, f, f2, i, z);
        } else {
            ItemTouchHelper.Callback.getDefaultUIUtil().onDrawOver(canvas, recyclerView, ((LayeredViewHolder) viewHolder).getForeground(), f, f2, i, z);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        this.adapter.onItemMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        this.onMove.set(i == 1);
        if (viewHolder instanceof NoSwipeViewHolder) {
            return;
        }
        if (viewHolder != null && (viewHolder instanceof LayeredViewHolder) && i == 1) {
            ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(((LayeredViewHolder) viewHolder).getForeground());
        } else {
            super.onSelectedChanged(viewHolder, i);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        this.adapter.onItemDismiss(viewHolder.getAdapterPosition(), i);
    }
}
