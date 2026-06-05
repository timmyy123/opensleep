package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;

/* JADX INFO: loaded from: classes4.dex */
public class UndoCard extends DashboardCard<UndoViewHolder> {
    private DashboardCard card;
    private Handler h;
    private Runnable removeRunnable;

    public class UndoViewHolder extends AnimatedViewHolder {
        protected TextView cardNameText;
        protected Button undoButton;

        public UndoViewHolder(View view) {
            super(view);
            this.undoButton = (Button) view.findViewById(R.id.undo_button);
            this.cardNameText = (TextView) view.findViewById(R.id.text);
        }
    }

    public UndoCard(Activity activity, DashboardCard dashboardCard) {
        super(activity, DashboardCard.Type.UNDO, R.layout.card_undo);
        this.removeRunnable = new Runnable() { // from class: com.urbandroid.sleep.fragment.dashboard.card.UndoCard.2
            @Override // java.lang.Runnable
            public void run() {
                UndoCard.this.removeForNow();
            }
        };
        this.card = dashboardCard;
        this.h = new Handler();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(UndoViewHolder undoViewHolder) {
        setCardVisibility(getContext(), (ViewGroup) undoViewHolder.itemView, true);
        undoViewHolder.cardNameText.setText(this.card.getNameResource());
        undoViewHolder.undoButton.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.UndoCard.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int position = UndoCard.this.getPosition();
                try {
                    UndoCard.this.getAdapter().getCards().remove(position);
                    UndoCard.this.getAdapter().notifyItemRemoved(position);
                    UndoCard.this.getAdapter().getCards().add(position, UndoCard.this.card);
                    UndoCard.this.getAdapter().notifyItemInserted(position);
                    UndoCard.this.card.setRemoved(false);
                    UndoCard.this.h.removeCallbacks(UndoCard.this.removeRunnable);
                } catch (Exception unused) {
                }
            }
        });
        this.h.removeCallbacks(this.removeRunnable);
        this.h.postDelayed(this.removeRunnable, 10000L);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean canChangePosition() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public UndoViewHolder createViewHolder(View view) {
        return new UndoViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return true;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemoved() {
        return false;
    }
}
