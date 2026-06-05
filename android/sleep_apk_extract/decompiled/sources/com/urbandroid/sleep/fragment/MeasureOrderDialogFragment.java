package com.urbandroid.sleep.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter;
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView;
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.ContextExtKt;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.SleepScore;
import com.urbandroid.sleep.alarmclock.settings.StatsSettingsActivity;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.media.MediaListActivity$$ExternalSyntheticLambda1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "SortAdapter", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class MeasureOrderDialogFragment extends DialogFragment {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment$SortAdapter;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter;", "Lcom/urbandroid/sleep/addon/stats/SleepScore$ScoreMeasure;", "Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment$SortAdapter$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "dataSet", "<init>", "(Landroid/content/Context;Ljava/util/List;)V", "Landroid/view/View;", "itemView", "getViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment$SortAdapter$ViewHolder;", "item", "viewHolder", "", "position", "", "onBindViewHolder", "(Lcom/urbandroid/sleep/addon/stats/SleepScore$ScoreMeasure;Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment$SortAdapter$ViewHolder;I)V", "getViewToTouchToStartDraggingItem", "(Lcom/urbandroid/sleep/addon/stats/SleepScore$ScoreMeasure;Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment$SortAdapter$ViewHolder;I)Landroid/view/View;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SortAdapter extends DragDropSwipeAdapter<SleepScore.ScoreMeasure, ViewHolder> {
        private final Context context;

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/fragment/MeasureOrderDialogFragment$SortAdapter$ViewHolder;", "Lcom/ernestoyaquello/dragdropswiperecyclerview/DragDropSwipeAdapter$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "itemText", "Landroid/widget/TextView;", "getItemText", "()Landroid/widget/TextView;", "posText", "getPosText", "dragIcon", "Landroid/widget/ImageView;", "getDragIcon", "()Landroid/widget/ImageView;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class ViewHolder extends DragDropSwipeAdapter.ViewHolder {
            private final ImageView dragIcon;
            private final TextView itemText;
            private final TextView posText;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(View view) {
                super(view);
                view.getClass();
                View viewFindViewById = view.findViewById(R.id.item_text);
                viewFindViewById.getClass();
                this.itemText = (TextView) viewFindViewById;
                View viewFindViewById2 = view.findViewById(R.id.position_text);
                viewFindViewById2.getClass();
                this.posText = (TextView) viewFindViewById2;
                View viewFindViewById3 = view.findViewById(R.id.drag_icon);
                viewFindViewById3.getClass();
                this.dragIcon = (ImageView) viewFindViewById3;
            }

            public final ImageView getDragIcon() {
                return this.dragIcon;
            }

            public final TextView getItemText() {
                return this.itemText;
            }

            public final TextView getPosText() {
                return this.posText;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SortAdapter(Context context, List<? extends SleepScore.ScoreMeasure> list) {
            super(list);
            context.getClass();
            list.getClass();
            this.context = context;
        }

        @Override // com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
        public ViewHolder getViewHolder(View itemView) {
            itemView.getClass();
            return new ViewHolder(itemView);
        }

        @Override // com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
        public View getViewToTouchToStartDraggingItem(SleepScore.ScoreMeasure item, ViewHolder viewHolder, int position) {
            item.getClass();
            viewHolder.getClass();
            return viewHolder.getDragIcon();
        }

        @Override // com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter
        public void onBindViewHolder(SleepScore.ScoreMeasure item, ViewHolder viewHolder, int position) {
            item.getClass();
            viewHolder.getClass();
            viewHolder.getItemText().setText(this.context.getString(item.getLabel()));
            viewHolder.getPosText().setText(String.valueOf(position + 1));
            viewHolder.getItemText().setCompoundDrawablesRelativeWithIntrinsicBounds(item.getIcon(), 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$0$1(FragmentActivity fragmentActivity, SortAdapter sortAdapter, MeasureOrderDialogFragment measureOrderDialogFragment, DialogInterface dialogInterface, int i) {
        ContextExtKt.getSettings(fragmentActivity).saveScoreMeasureOrder(sortAdapter.getDataSet());
        dialogInterface.dismiss();
        FragmentActivity activity = measureOrderDialogFragment.getActivity();
        activity.getClass();
        activity.recreate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$0$0$3(MeasureOrderDialogFragment measureOrderDialogFragment, FragmentActivity fragmentActivity, DialogInterface dialogInterface, int i) {
        Intent intent = new Intent(measureOrderDialogFragment.getActivity(), (Class<?>) StatsSettingsActivity.class);
        intent.putExtra("extra_highlight_key", "graph_color_theme");
        ContextCompat.startActivity(fragmentActivity, intent, null);
        dialogInterface.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
            dialogOnCreateDialog.getClass();
            return dialogOnCreateDialog;
        }
        FragmentActivity activity2 = getActivity();
        activity2.getClass();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(activity2);
        View viewInflate = InflatorUtil.INSTANCE.get(activity).inflate(R.layout.dialog_measure_order, (ViewGroup) null);
        viewInflate.getClass();
        ViewGroup viewGroup = (ViewGroup) viewInflate;
        List<SleepScore.ScoreMeasure> listOrderMeasures = ContextExtKt.getSettings(activity).orderMeasures(ArraysKt.toList(SleepScore.ScoreMeasure.values()));
        listOrderMeasures.getClass();
        materialAlertDialogBuilder.setTitle((CharSequence) activity.getString(R.string.prioritize));
        final SortAdapter sortAdapter = new SortAdapter(activity, listOrderMeasures);
        DragDropSwipeRecyclerView dragDropSwipeRecyclerView = (DragDropSwipeRecyclerView) viewGroup.findViewById(R.id.list);
        dragDropSwipeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dragDropSwipeRecyclerView.setAdapter((DragDropSwipeAdapter<?, ?>) sortAdapter);
        dragDropSwipeRecyclerView.disableSwipeDirection(DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.LEFT);
        dragDropSwipeRecyclerView.disableSwipeDirection(DragDropSwipeRecyclerView.ListOrientation.DirectionFlag.RIGHT);
        dragDropSwipeRecyclerView.setDragListener(new OnItemDragListener<SleepScore.ScoreMeasure>() { // from class: com.urbandroid.sleep.fragment.MeasureOrderDialogFragment$onCreateDialog$1$1$1$1
            @Override // com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener
            public void onItemDropped(int initialPosition, int finalPosition, SleepScore.ScoreMeasure item) {
                item.getClass();
                Logger.logInfo("Drag dropped", null);
                Iterator<T> it = sortAdapter.getDataSet().iterator();
                while (it.hasNext()) {
                    Logger.logInfo("Drag " + ((SleepScore.ScoreMeasure) it.next()).name(), null);
                }
            }

            @Override // com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener
            public void onItemDragged(int previousPosition, int newPosition, SleepScore.ScoreMeasure item) {
                item.getClass();
            }
        });
        materialAlertDialogBuilder.setView((View) viewGroup);
        materialAlertDialogBuilder.setPositiveButton(R.string.btn_ok, (DialogInterface.OnClickListener) new MediaListActivity$$ExternalSyntheticLambda1(activity, sortAdapter, this, 3));
        materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new NoiseFragment$$ExternalSyntheticLambda6(5));
        materialAlertDialogBuilder.setNeutralButton(R.string.graph_color_theme_title, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.fragment.MeasureOrderDialogFragment$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                MeasureOrderDialogFragment.onCreateDialog$lambda$0$0$3(this.f$0, activity, dialogInterface, i);
            }
        });
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }
}
