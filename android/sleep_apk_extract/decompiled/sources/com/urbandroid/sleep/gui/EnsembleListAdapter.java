package com.urbandroid.sleep.gui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class EnsembleListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {
    private Context context;
    private final List<Section> sections = new ArrayList();
    private final List<String> headers = new ArrayList();

    public class Section {
        private BaseAdapter adapter;
        private boolean collapsed = false;
        private boolean collapsible;
        private String name;

        public Section(String str, BaseAdapter baseAdapter, boolean z) {
            this.name = str;
            this.adapter = baseAdapter;
            this.collapsible = z;
        }

        public BaseAdapter getAdapter() {
            return this.adapter;
        }

        public String getName() {
            return this.name;
        }

        public int getSize() {
            if (this.collapsible && this.collapsed) {
                return 1;
            }
            return this.adapter.getCount() + 1;
        }

        public void toggleCollapse() {
            this.collapsed = !this.collapsed;
        }
    }

    public EnsembleListAdapter(Context context) {
        this.context = context;
    }

    private void setHeaderArrow(TextView textView, boolean z) {
        ViewUtil.setCompoundDrawablesCompat(textView, z ? R.drawable.arrow_down_trans : R.drawable.arrow_up_trans, 0, 0, 0);
        textView.setCompoundDrawablePadding(32);
    }

    public void addSection(String str, BaseAdapter baseAdapter, boolean z) {
        Section section = new Section(str, baseAdapter, z);
        this.headers.add(section.getName());
        this.sections.add(section);
    }

    public void clear() {
        this.sections.clear();
        this.headers.clear();
    }

    public Collection<IFilterListAdapter> getAdapters() {
        ArrayList arrayList = new ArrayList();
        Iterator<Section> it = this.sections.iterator();
        while (it.hasNext()) {
            arrayList.add((IFilterListAdapter) it.next().getAdapter());
        }
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Iterator<Section> it = this.sections.iterator();
        int size = 0;
        while (it.hasNext()) {
            size += it.next().getSize();
        }
        return size;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        for (Section section : this.sections) {
            BaseAdapter adapter = section.getAdapter();
            int size = section.getSize();
            if (i == 0) {
                return section;
            }
            if (i < size) {
                return adapter.getItem(i - 1);
            }
            i -= size;
        }
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        int viewTypeCount = 1;
        for (Section section : this.sections) {
            BaseAdapter adapter = section.getAdapter();
            int size = section.getSize();
            if (i == 0) {
                return 0;
            }
            if (i < size) {
                return adapter.getItemViewType(i - 1) + viewTypeCount;
            }
            i -= size;
            viewTypeCount += adapter.getViewTypeCount();
        }
        return -1;
    }

    public String getSectionTexts() {
        StringBuilder sb = new StringBuilder();
        Iterator<Section> it = this.sections.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next().getName());
            i++;
            if (i == this.sections.toArray().length) {
                sb.append("...");
            } else {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        int i2 = 0;
        for (final Section section : this.sections) {
            final BaseAdapter adapter = section.getAdapter();
            int size = section.getSize();
            if (i == 0) {
                if (size == 1 && !section.collapsed) {
                    return new View(this.context);
                }
                ViewGroup viewGroup2 = (ViewGroup) InflatorUtil.get(this.context).inflate(R.layout.category_search, viewGroup, false);
                TextView textView = (TextView) viewGroup2.findViewById(android.R.id.title);
                textView.setText(this.headers.get(i2));
                if (section.collapsible) {
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.gui.EnsembleListAdapter.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view2) {
                            section.toggleCollapse();
                            EnsembleListAdapter.this.notifyDataSetChanged();
                            adapter.notifyDataSetChanged();
                        }
                    });
                    setHeaderArrow(textView, section.collapsed);
                }
                return viewGroup2;
            }
            if (i < size) {
                Logger.logDebug("Section adapter " + section.getAdapter().getClass().toString());
                return adapter.getView(i - 1, view, viewGroup);
            }
            i -= size;
            i2++;
        }
        return null;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        Iterator<Section> it = this.sections.iterator();
        int viewTypeCount = 1;
        while (it.hasNext()) {
            viewTypeCount += it.next().getAdapter().getViewTypeCount();
        }
        return viewTypeCount;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        return getItemViewType(i) != 0;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        for (Section section : this.sections) {
            IFilterListAdapter iFilterListAdapter = (IFilterListAdapter) section.getAdapter();
            int size = section.getSize();
            if (i < size) {
                iFilterListAdapter.onItemClick(adapterView, view, i - 1, j);
                return;
            }
            i -= size;
        }
    }

    public void addSection(String str, BaseAdapter baseAdapter) {
        addSection(str, baseAdapter, true);
    }
}
