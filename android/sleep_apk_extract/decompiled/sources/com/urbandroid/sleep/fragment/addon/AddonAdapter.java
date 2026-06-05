package com.urbandroid.sleep.fragment.addon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.domain.addon.AddonItem;
import com.urbandroid.sleep.domain.addon.AddonSection;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class AddonAdapter extends BaseAdapter implements IFilterListAdapter {
    private final List<AddonItem> allItems;
    private final AddOnBinder binder = new AddOnBinder();
    private final Context context;
    private final int iconSize;
    private final List<AddonItem> items;
    private final int padding;

    public AddonAdapter(Context context, List<AddonItem> list, int i, int i2) {
        this.context = context;
        this.items = new ArrayList(list);
        this.allItems = list;
        this.iconSize = i;
        this.padding = i2;
    }

    private void filterItems(String str) {
        this.items.clear();
        for (AddonItem addonItem : this.allItems) {
            if (str == null || "".equals(str)) {
                this.items.add(addonItem);
            } else if (addonItem instanceof AddonApp) {
                AddonApp addonApp = (AddonApp) addonItem;
                if (addonApp.getTitle().toLowerCase().contains(str) || addonApp.getDesc().toLowerCase().contains(str)) {
                    this.items.add(addonItem);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void filter(IFilterListAdapter.IFilter iFilter) {
        Logger.logInfo("Addon " + iFilter.getFilterString());
        filterItems(iFilter.getFilterString());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public AddonItem getItem(int i) {
        return this.items.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return !(this.items.get(i) instanceof AddonSection) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        AddonItem item = getItem(i);
        if (item instanceof AddonSection) {
            if (view == null) {
                view = InflatorUtil.get(viewGroup.getContext()).inflate(R.layout.category_first, viewGroup, false);
            }
        } else if (item instanceof AddonApp) {
            if (view == null) {
                view = InflatorUtil.get(viewGroup.getContext()).inflate(R.layout.row_addon_app, viewGroup, false);
            }
            AddonApp addonApp = (AddonApp) getItem(i);
            ImageView imageView = (ImageView) view.findViewById(android.R.id.icon);
            Button button = (Button) view.findViewById(R.id.button);
            this.binder.bind(this.context, addonApp, imageView, (TextView) view.findViewById(android.R.id.title), (TextView) view.findViewById(android.R.id.summary), button, this.iconSize, this.padding);
        }
        ((TextView) view.findViewById(android.R.id.title)).setText(item.getTitle());
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void notifyChanged() {
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void pause() {
    }
}
