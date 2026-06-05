package com.urbandroid.sleep.gui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.util.VolumeUtil$$ExternalSyntheticLambda0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/gui/dialog/ItemDialogFragment;", "Lcom/urbandroid/sleep/gui/dialog/FixedDialogFragment;", "<init>", "()V", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "createItems", "(Landroid/app/Activity;)Lcom/urbandroid/sleep/gui/dialog/ItemDialogFragment;", "", "getTitleRes", "()I", "getSubtitleRes", "getIconRes", "Landroid/app/Dialog;", "createDialog", "()Landroid/app/Dialog;", "", "Lcom/urbandroid/sleep/gui/dialog/DialogItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ItemDialogFragment extends FixedDialogFragment {
    private final List<DialogItem> items = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createDialog$lambda$1(ItemDialogFragment itemDialogFragment, DialogInterface dialogInterface, int i) {
        itemDialogFragment.items.get(i).onClick();
    }

    @Override // com.urbandroid.sleep.gui.dialog.FixedDialogFragment
    public Dialog createDialog() {
        final FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.getClass();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(fragmentActivityRequireActivity);
        materialAlertDialogBuilder.setTitle(getTitleRes());
        materialAlertDialogBuilder.setIcon(R.drawable.preview_support);
        View viewInflate = InflatorUtil.INSTANCE.get(fragmentActivityRequireActivity).inflate(R.layout.dialog_support_title, (ViewGroup) null, false);
        ((TextView) viewInflate.findViewById(R.id.title)).setText(getTitleRes());
        if (getSubtitleRes() != -1) {
            ((TextView) viewInflate.findViewById(R.id.subtitle)).setText(getSubtitleRes());
        } else {
            ((TextView) viewInflate.findViewById(R.id.subtitle)).setVisibility(8);
        }
        if (getIconRes() != -1) {
            ((ImageView) viewInflate.findViewById(R.id.icon)).setImageResource(getIconRes());
        } else {
            ((ImageView) viewInflate.findViewById(R.id.icon)).setVisibility(8);
        }
        materialAlertDialogBuilder.setCustomTitle(viewInflate);
        createItems(fragmentActivityRequireActivity);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this) { // from class: com.urbandroid.sleep.gui.dialog.ItemDialogFragment$createDialog$arrayAdapter$1
            final /* synthetic */ ItemDialogFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(this.$context, R.layout.drawer_item_entry_subtitle);
                this.this$0 = this;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View convertView, ViewGroup parent) {
                parent.getClass();
                if (convertView == null) {
                    convertView = InflatorUtil.INSTANCE.get(this.$context).inflate(R.layout.drawer_item_entry_subtitle, parent, false);
                }
                DialogItem dialogItem = this.this$0.getItems().get(position);
                String title = dialogItem.getTitle();
                String subtitle = dialogItem.getSubtitle();
                int iconRes = dialogItem.getIconRes();
                View viewFindViewById = convertView.findViewById(R.id.title);
                viewFindViewById.getClass();
                ((TextView) viewFindViewById).setText(title);
                if (subtitle != null) {
                    View viewFindViewById2 = convertView.findViewById(R.id.subtitle);
                    viewFindViewById2.getClass();
                    ((TextView) viewFindViewById2).setText(subtitle);
                    View viewFindViewById3 = convertView.findViewById(R.id.subtitle);
                    viewFindViewById3.getClass();
                    ((TextView) viewFindViewById3).setVisibility(0);
                } else {
                    View viewFindViewById4 = convertView.findViewById(R.id.subtitle);
                    viewFindViewById4.getClass();
                    ((TextView) viewFindViewById4).setVisibility(8);
                }
                View viewFindViewById5 = convertView.findViewById(R.id.icon);
                viewFindViewById5.getClass();
                ((ImageView) viewFindViewById5).setImageResource(iconRes);
                return convertView;
            }
        };
        Iterator<T> it = this.items.iterator();
        while (it.hasNext()) {
            arrayAdapter.add(((DialogItem) it.next()).getTitle());
        }
        materialAlertDialogBuilder.setAdapter((ListAdapter) arrayAdapter, (DialogInterface.OnClickListener) new VolumeUtil$$ExternalSyntheticLambda0(this, 12));
        materialAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
        AlertDialog alertDialogCreate = materialAlertDialogBuilder.create();
        alertDialogCreate.getClass();
        return alertDialogCreate;
    }

    public abstract ItemDialogFragment createItems(Activity context);

    public int getIconRes() {
        return -1;
    }

    public final List<DialogItem> getItems() {
        return this.items;
    }

    public int getSubtitleRes() {
        return -1;
    }

    public abstract int getTitleRes();
}
