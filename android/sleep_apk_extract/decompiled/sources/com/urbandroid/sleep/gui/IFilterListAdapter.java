package com.urbandroid.sleep.gui;

import android.widget.AdapterView;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes4.dex */
public interface IFilterListAdapter extends ListAdapter, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    public interface IFilter {
        String getFilterString();
    }

    void filter(IFilter iFilter);

    void notifyChanged();

    void pause();
}
