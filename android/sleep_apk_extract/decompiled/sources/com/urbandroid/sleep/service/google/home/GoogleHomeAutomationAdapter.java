package com.urbandroid.sleep.service.google.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes5.dex */
public class GoogleHomeAutomationAdapter extends BaseAdapter {
    private final Context context;
    private final List<Item> items = new ArrayList();
    private final LayoutInflater vi;

    public static class Item {
        String id;
        String title;

        public Item(String str, String str2) {
            this.id = str;
            this.title = str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return Objects.equals(this.title, ((Item) obj).title);
        }

        public int hashCode() {
            String str = this.title;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }
    }

    public GoogleHomeAutomationAdapter(Context context) {
        this.context = context;
        this.vi = InflatorUtil.get(context);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.items.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.items.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public List<Item> getItems() {
        return this.items;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Item item = this.items.get(i);
        if (item == null) {
            return view;
        }
        View viewInflate = this.vi.inflate(R.layout.drawer_item_entry, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.title);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.icon);
        textView.setText(item.title);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ic_automagic);
        }
        return viewInflate;
    }

    public void setItems(List<Item> list) {
        this.items.addAll(list);
        notifyDataSetChanged();
    }
}
