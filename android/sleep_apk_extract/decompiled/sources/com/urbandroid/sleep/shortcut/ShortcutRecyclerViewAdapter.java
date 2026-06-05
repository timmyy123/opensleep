package com.urbandroid.sleep.shortcut;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.urbandroid.sleep.domain.shortcut.ShortcutSleep;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001a0\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010 \u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/shortcut/ShortcutRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/app/Activity;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "getItemViewType", "(I)I", "holder", "", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "()I", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "", "Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ShortcutRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Activity context;
    private final Handler handler;
    private final List<AbstractShortcutItem<?>> items;

    public ShortcutRecyclerViewAdapter(Activity activity) {
        activity.getClass();
        this.context = activity;
        this.items = new ArrayList();
        this.handler = new Handler();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType().ordinal();
    }

    public final List<AbstractShortcutItem<?>> getItems() {
        return this.items;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.getClass();
        AbstractShortcutItem<?> abstractShortcutItem = this.items.get(position);
        abstractShortcutItem.getClass();
        abstractShortcutItem.bindView(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parent.getClass();
        for (AbstractShortcutItem<?> abstractShortcutItem : this.items) {
            if (abstractShortcutItem.getType().ordinal() == viewType) {
                return abstractShortcutItem.getViewHolder(parent);
            }
        }
        return new ShortcutItem(this.context, new ShortcutSleep()).createViewHolder((View) parent);
    }
}
