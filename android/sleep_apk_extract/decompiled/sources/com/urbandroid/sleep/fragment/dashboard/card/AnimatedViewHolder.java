package com.urbandroid.sleep.fragment.dashboard.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AnimatedViewHolder extends RecyclerView.ViewHolder {
    private long ts;

    public AnimatedViewHolder(View view) {
        super(view);
        this.ts = -1L;
    }
}
