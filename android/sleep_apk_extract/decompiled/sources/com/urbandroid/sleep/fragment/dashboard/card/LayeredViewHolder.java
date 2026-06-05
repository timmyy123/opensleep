package com.urbandroid.sleep.fragment.dashboard.card;

import android.view.View;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LayeredViewHolder extends AnimatedViewHolder {
    public View background;
    public View foreground;

    public LayeredViewHolder(View view) {
        super(view);
        this.foreground = view.findViewById(R.id.foreground);
        this.background = view.findViewById(R.id.background);
    }

    public View getForeground() {
        return this.foreground;
    }
}
