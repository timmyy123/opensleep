package com.urbandroid.sleep.media.lullaby;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.alarmclock.settings.LullabySettingsActivity;
import com.urbandroid.sleep.gui.GraphListClickHandler$$ExternalSyntheticLambda2;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class MeditationDialogFragment extends DialogFragment {
    private LayoutInflater vi;

    public static class Item {
        public Long id;
        public String title;

        public Item(String str, Long l) {
            this.title = str;
            this.id = l;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.id, ((Item) obj).id);
        }

        public int hashCode() {
            return Objects.hash(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(List list, DialogInterface dialogInterface, int i) {
        Item item = (Item) list.get(i);
        ((LullabySettingsActivity) getActivity()).onMeditationSelected(getActivity(), item.title, item.id);
        dialogInterface.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i) {
        if (getActivity() != null) {
            ViewIntent.urlCustomTab(getActivity(), "https://play.google.com/store/apps/details?id=com.urbandroid.lis10");
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Logger.logInfo("LullabyDialog: onCreate()");
        FragmentActivity activity = getActivity();
        new Settings(activity);
        this.vi = InflatorUtil.get(activity);
        TrialFilter.getInstance().reevaluate();
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getActivity());
        materialAlertDialogBuilder.setTitle((CharSequence) (getActivity().getString(R.string.meditation)));
        final ArrayList arrayList = new ArrayList();
        int i = 1;
        try {
            Cursor cursorQuery = activity.getContentResolver().query(Uri.parse("content://com.urbandroid.lis10/sessions"), null, null, null, null);
            Logger.logInfo("Meditation: query " + cursorQuery);
            if (cursorQuery != null) {
                while (cursorQuery.moveToNext()) {
                    long j = cursorQuery.getLong(0);
                    Long lValueOf = Long.valueOf(j);
                    String string = cursorQuery.getString(1);
                    Logger.logInfo("Meditation: Lis10 retrieved from content provider " + j + " " + string);
                    arrayList.add(new Item(string, lValueOf));
                }
            }
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        materialAlertDialogBuilder.setAdapter((ListAdapter) new BaseAdapter() { // from class: com.urbandroid.sleep.media.lullaby.MeditationDialogFragment.1
            @Override // android.widget.Adapter
            public int getCount() {
                return arrayList.size();
            }

            @Override // android.widget.Adapter
            public Object getItem(int i2) {
                return arrayList.get(i2);
            }

            @Override // android.widget.Adapter
            public long getItemId(int i2) {
                return i2;
            }

            @Override // android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                Item item = (Item) arrayList.get(i2);
                if (item == null) {
                    return view;
                }
                View viewInflate = MeditationDialogFragment.this.vi.inflate(R.layout.dialog_item_entry, (ViewGroup) null);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
                ((TextView) viewInflate.findViewById(R.id.title)).setText(item.title);
                if (imageView != null) {
                    imageView.setImageResource(R.drawable.ic_next);
                }
                return viewInflate;
            }

            @Override // android.widget.BaseAdapter, android.widget.Adapter
            public int getViewTypeCount() {
                return 2;
            }
        }, (DialogInterface.OnClickListener) new GraphListClickHandler$$ExternalSyntheticLambda2(this, arrayList, 5));
        materialAlertDialogBuilder.setPositiveButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.media.lullaby.MeditationDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        materialAlertDialogBuilder.setNeutralButton(R.string.help, (DialogInterface.OnClickListener) new LullabyRadioItem$$ExternalSyntheticLambda1(this, i));
        return materialAlertDialogBuilder.create();
    }
}
