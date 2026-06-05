package com.urbandroid.sleep.shortcut;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001#B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00028\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "layout", "Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem$Type;", "type", "<init>", "(Landroid/content/Context;ILcom/urbandroid/sleep/shortcut/AbstractShortcutItem$Type;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "bindView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onItemClicked", "()V", "Landroid/view/ViewGroup;", "viewGroup", "getViewHolder", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "I", "getLayout", "()I", "Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem$Type;", "getType", "()Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem$Type;", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class AbstractShortcutItem<T extends RecyclerView.ViewHolder> {
    private final Context context;
    private final int layout;
    private final Type type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/shortcut/AbstractShortcutItem$Type;", "", "<init>", "(Ljava/lang/String;I)V", "SHORTCUT", "SUMMARY", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type SHORTCUT = new Type("SHORTCUT", 0);
        public static final Type SUMMARY = new Type("SUMMARY", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{SHORTCUT, SUMMARY};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
        }

        private Type(String str, int i) {
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public AbstractShortcutItem(Context context, int i, Type type) {
        context.getClass();
        type.getClass();
        this.context = context;
        this.layout = i;
        this.type = type;
    }

    public void bindView(T viewHolder) {
        viewHolder.getClass();
        viewHolder.itemView.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 26));
    }

    public abstract T createViewHolder(View v);

    public final Context getContext() {
        return this.context;
    }

    public final Type getType() {
        return this.type;
    }

    public T getViewHolder(ViewGroup viewGroup) {
        View viewInflate = InflatorUtil.INSTANCE.get(this.context).inflate(this.layout, viewGroup, false);
        viewInflate.getClass();
        return (T) createViewHolder(viewInflate);
    }

    public abstract void onItemClicked();
}
