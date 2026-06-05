package com.urbandroid.sleep.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.urbandroid.common.logging.Logger;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LazyFragment extends Fragment implements ILazyFragment {
    private View baseView;
    private boolean dataUpdated;
    private LayoutInflater inflater;
    private Bundle savedInstanceState;
    private boolean alreadyLoaded = false;
    private boolean visible = false;

    public LazyFragment() {
        if (Logger.isInitialized()) {
            Logger.logInfo("Fragment: Lazy Creating fragment: ".concat(getClass().getSimpleName()));
        }
    }

    public boolean eagerLoad() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public boolean isAlreadyLoaded() {
        return this.alreadyLoaded;
    }

    public boolean isFramentVisible() {
        return this.visible;
    }

    public void load() {
        if (this.alreadyLoaded || getActivity() == null) {
            return;
        }
        Logger.logInfo("Fragment: Lazy Loading ".concat(getClass().getSimpleName()));
        this.alreadyLoaded = true;
        populateBaseView(this.baseView, this.inflater, this.savedInstanceState);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Logger.logInfo("Fragment: onCreateView() ".concat(getClass().getSimpleName()));
        this.inflater = layoutInflater;
        this.savedInstanceState = bundle;
        this.baseView = createBaseView(layoutInflater, viewGroup, bundle);
        this.alreadyLoaded = false;
        if (eagerLoad() || this.visible) {
            load();
        }
        return this.baseView;
    }

    public void onSetVisible() {
    }

    public void preload() {
        Logger.logInfo("Fragment: Lazy Preload requested: ".concat(getClass().getSimpleName()));
        load();
        refreshOnDataUpdate();
        this.dataUpdated = false;
    }

    public void refreshOnDataUpdate() {
    }

    public final void setDataUpdated() {
        if (!this.visible && !eagerLoad()) {
            this.dataUpdated = true;
            return;
        }
        Logger.logInfo("Fragment: Eager refreshing fragment: ".concat(getClass().getSimpleName()));
        refreshOnDataUpdate();
        this.dataUpdated = false;
    }

    public void setInvisible() {
        Logger.logInfo("Fragment: Lazy Setting fragment invisible: " + getClass().getSimpleName() + " (already invisible: " + this.visible + ")");
        this.visible = false;
    }

    public void setVisible() {
        Logger.logInfo("Fragment: Setting fragment visible: " + getClass().getSimpleName() + " (already visible: " + this.visible + ")");
        if (this.visible) {
            return;
        }
        onSetVisible();
        this.visible = true;
        if (this.inflater == null) {
            return;
        }
        load();
        if (this.dataUpdated) {
            Logger.logInfo("Fragment: Lazy refreshing fragment: ".concat(getClass().getSimpleName()));
            refreshOnDataUpdate();
            this.dataUpdated = false;
        }
    }
}
