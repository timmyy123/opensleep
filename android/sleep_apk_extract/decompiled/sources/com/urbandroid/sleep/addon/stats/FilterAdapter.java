package com.urbandroid.sleep.addon.stats;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.tag.Tag;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FilterAdapter extends ArrayAdapter<String> {
    private List<String> buildIn;
    private Map<String, Integer> counts;
    private List<String> tags;

    public FilterAdapter(Context context) {
        super(context, R.layout.charts_spinner_dropdown);
        this.buildIn = new ArrayList();
        this.tags = new ArrayList();
        for (CharSequence charSequence : context.getResources().getTextArray(R.array.filter_array)) {
            this.buildIn.add(charSequence.toString());
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.tags.size() + this.buildIn.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getDropDownView(i, view, viewGroup);
        textView.setCompoundDrawablePadding(ActivityUtils.getDip(viewGroup.getContext(), 8));
        Drawable drawableTagDrawable = Tag.tagDrawable(getContext(), getItem(i));
        if (drawableTagDrawable == null) {
            drawableTagDrawable = getContext().getResources().getDrawable(R.drawable.ic_tag);
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(drawableTagDrawable, (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setGravity(17);
        String item = getItem(i);
        Map<String, Integer> map = this.counts;
        if (map != null) {
            Integer num = map.get(item);
            if (this.counts != null && num != null && num.intValue() > 0) {
                StringBuilder sbM = Fragment$$ExternalSyntheticOutline1.m(item, " ");
                sbM.append(this.counts.get(item));
                sbM.append("x");
                textView.setText(sbM.toString());
            }
        }
        return textView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public String getItem(int i) {
        return i >= this.buildIn.size() ? this.tags.get(i - this.buildIn.size()) : this.buildIn.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) super.getView(i, view, viewGroup);
        textView.setTextColor(ContextCompat.getColor(getContext(), R.color.primary));
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setGravity(17);
        textView.setTextAlignment(4);
        return textView;
    }

    public int resolvePosition(String str) {
        if (str == null) {
            return -1;
        }
        int iIndexOf = this.buildIn.indexOf(str);
        if (iIndexOf != -1) {
            return iIndexOf;
        }
        int iIndexOf2 = this.tags.indexOf(str);
        return iIndexOf2 != -1 ? this.buildIn.size() + iIndexOf2 : iIndexOf2;
    }

    public void setCounts(Map<String, Integer> map) {
        this.counts = map;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }
}
