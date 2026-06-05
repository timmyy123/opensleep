package com.urbandroid.sleep.smartwatch;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.sleep.smartlight.DiscoveryActivity$$ExternalSyntheticLambda2;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ResourceUtil;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class WearablesListAdapter extends ArrayAdapter<Wearable> {
    private final Context context;
    private final List<Wearable> items;
    private Wearable selected;

    public WearablesListAdapter(Context context, List<Wearable> list) {
        super(context, 0, list);
        this.context = context;
        this.items = list;
        this.selected = new Settings(context).getSelectedWearable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getView$0(Wearable wearable, View view) {
        SharedApplicationContext.getSettings().installWearableAddon(wearable);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Wearable wearable = (Wearable) getItem(i);
        if (view == null) {
            view = InflatorUtil.get(getContext()).inflate(R.layout.row_wearable_addon, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(android.R.id.title);
        TextView textView2 = (TextView) view.findViewById(android.R.id.summary);
        View viewFindViewById = view.findViewById(R.id.button);
        ImageView imageView = (ImageView) view.findViewById(R.id.icon_bg);
        ((ImageView) view.findViewById(android.R.id.icon)).setImageResource(wearable.iconRes);
        Wearable wearable2 = Wearable.AUTO;
        Context context = this.context;
        textView.setText(wearable == wearable2 ? wearable.getName(context).toUpperCase() : wearable.getName(context));
        Wearable wearable3 = this.selected;
        Context context2 = this.context;
        if (wearable == wearable3) {
            textView.setTextColor(ContextCompat.getColor(context2, R.color.tint));
        } else {
            textView.setTextColor(ContextCompat.getColor(context2, R.color.primary));
        }
        int i2 = 1;
        if (i > 0) {
            imageView.setImageResource(R.drawable.circle_bg_accent);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(1);
            Context context3 = this.context;
            StringBuilder sb = new StringBuilder("t");
            sb.append(i % 7);
            sb.append(i % 2 == 0 ? "a" : "");
            gradientDrawable.setColor(ColorUtil.i(context3, ResourceUtil.getResourceByName(context3, "color", sb.toString())));
            imageView.setImageDrawable(gradientDrawable);
        } else {
            imageView.setImageResource(R.drawable.empty);
        }
        String description = wearable.getDescription(this.context);
        textView2.setText(description);
        if (description.length() > 0) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        if (wearable.isAddonInstalled(this.context) && wearable.isVendorInstalled(this.context)) {
            viewFindViewById.setVisibility(8);
            return view;
        }
        viewFindViewById.setVisibility(0);
        viewFindViewById.setOnClickListener(new DiscoveryActivity$$ExternalSyntheticLambda2(wearable, i2));
        return view;
    }
}
