package com.urbandroid.sleep.gui.drawer;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerRecyclerViewAdapter extends RecyclerView.Adapter<DrawerItemHolder> {
    private boolean showCircle = false;
    private List<EntryItem> items = new ArrayList();

    public static class DrawerItemHolder extends RecyclerView.ViewHolder {
        private ImageView button;
        private TextView title;

        public DrawerItemHolder(View view) {
            super(view);
            this.button = (ImageView) view.findViewById(R.id.icon);
            this.title = (TextView) view.findViewById(R.id.title);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindViewHolder$0(int i, View view) {
        this.items.get(i).onClick();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    public boolean isShowCircle() {
        return this.showCircle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DrawerItemHolder drawerItemHolder, int i) {
        drawerItemHolder.button.setImageResource(this.items.get(i).icon);
        drawerItemHolder.button.setOnClickListener(new DotsIndicator$$ExternalSyntheticLambda0(this, i, 1));
        if (!this.showCircle || this.items.get(i).title == null || this.items.get(i).title.isEmpty()) {
            drawerItemHolder.title.setText("");
            drawerItemHolder.button.setBackgroundResource(0);
        } else {
            drawerItemHolder.title.setText(this.items.get(i).title);
            drawerItemHolder.button.setBackgroundResource(R.drawable.btn_circle);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DrawerItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new DrawerItemHolder(InflatorUtil.get(viewGroup.getContext()).inflate(R.layout.drawer_item_button, viewGroup, false));
    }

    public void setItems(List<EntryItem> list) {
        this.items = list;
    }

    public void setShowCircle(boolean z) {
        this.showCircle = z;
    }
}
