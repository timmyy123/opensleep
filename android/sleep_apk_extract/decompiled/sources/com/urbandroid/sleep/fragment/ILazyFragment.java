package com.urbandroid.sleep.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public interface ILazyFragment {
    View createBaseView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    boolean isAlreadyLoaded();

    void populateBaseView(View view, LayoutInflater layoutInflater, Bundle bundle);

    void setInvisible();

    void setVisible();
}
