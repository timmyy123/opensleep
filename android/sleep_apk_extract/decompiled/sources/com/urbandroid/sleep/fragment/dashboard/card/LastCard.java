package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AlertDialog;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.NoiseFragment$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.persistence.ExportUtilKt$$ExternalSyntheticLambda0;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class LastCard extends DashboardCard<LastViewHolder> {
    private RemovedCardList removedCardList;

    public class LastViewHolder extends NoSwipeViewHolder {
        protected Button hideButton;

        public LastViewHolder(View view) {
            super(view);
            this.hideButton = (Button) view.findViewById(R.id.hide_button);
        }
    }

    public LastCard(Activity activity, List<DashboardCard<?>> list) {
        super(activity, DashboardCard.Type.LAST, R.layout.card_last);
        RemovedCardList removedCardList = new RemovedCardList(activity);
        this.removedCardList = removedCardList;
        removedCardList.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindView$0(DialogInterface dialogInterface, int i, boolean z) {
        this.removedCardList.setVisible(i, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$bindView$1(DialogInterface dialogInterface, int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindView$2(DialogInterface dialogInterface) {
        reloadAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindView$3(View view) {
        AlertDialog alertDialogCreate = new MaterialAlertDialogBuilder(getContext()).setTitle(R.string.show).setMultiChoiceItems(this.removedCardList.getNameArray(), this.removedCardList.getChecked(), (DialogInterface.OnMultiChoiceClickListener) new ExportUtilKt$$ExternalSyntheticLambda0(this, 1)).setPositiveButton(R.string.button_ok, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(6)).create();
        alertDialogCreate.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.urbandroid.sleep.fragment.dashboard.card.LastCard$$ExternalSyntheticLambda3
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                this.f$0.lambda$bindView$2(dialogInterface);
            }
        });
        alertDialogCreate.show();
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(LastViewHolder lastViewHolder) {
        lastViewHolder.hideButton.setText(getContext().getString(R.string.hide) + " / " + getContext().getString(R.string.show));
        lastViewHolder.hideButton.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 12));
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean canChangePosition() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public LastViewHolder createViewHolder(View view) {
        return new LastViewHolder(view);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemovable() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isRemoved() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isScreenReady() {
        return false;
    }
}
