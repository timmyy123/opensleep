package com.urbandroid.sleep.media.lullaby;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001#B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u00028\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "T", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "layout", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem$Type;", "type", "<init>", "(Landroid/content/Context;ILcom/urbandroid/sleep/media/lullaby/LullabyItem$Type;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "bindView", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;)V", "onItemClicked", "()V", "Landroid/view/ViewGroup;", "viewGroup", "getViewHolder", "(Landroid/view/ViewGroup;)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "I", "getLayout", "()I", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem$Type;", "getType", "()Lcom/urbandroid/sleep/media/lullaby/LullabyItem$Type;", "Type", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class LullabyItem<T extends RecyclerView.ViewHolder> {
    private final Context context;
    private final int layout;
    private final Type type;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyItem$Type;", "", "<init>", "(Ljava/lang/String;I)V", "LULLABY", "LULLABY_SPOTIFY", "LULLABY_RADIO", "SECTION", "CARD_UNLOCK", "CARD_ADDON", "SPOTIFY_CONNECT", "CATEGORIES", "ADD_RADIO", "FEEDBACK", "CARD_ADDON_RATE", "GAP", "CARD_ADDON_FREE", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type LULLABY = new Type("LULLABY", 0);
        public static final Type LULLABY_SPOTIFY = new Type("LULLABY_SPOTIFY", 1);
        public static final Type LULLABY_RADIO = new Type("LULLABY_RADIO", 2);
        public static final Type SECTION = new Type("SECTION", 3);
        public static final Type CARD_UNLOCK = new Type("CARD_UNLOCK", 4);
        public static final Type CARD_ADDON = new Type("CARD_ADDON", 5);
        public static final Type SPOTIFY_CONNECT = new Type("SPOTIFY_CONNECT", 6);
        public static final Type CATEGORIES = new Type("CATEGORIES", 7);
        public static final Type ADD_RADIO = new Type("ADD_RADIO", 8);
        public static final Type FEEDBACK = new Type("FEEDBACK", 9);
        public static final Type CARD_ADDON_RATE = new Type("CARD_ADDON_RATE", 10);
        public static final Type GAP = new Type("GAP", 11);
        public static final Type CARD_ADDON_FREE = new Type("CARD_ADDON_FREE", 12);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{LULLABY, LULLABY_SPOTIFY, LULLABY_RADIO, SECTION, CARD_UNLOCK, CARD_ADDON, SPOTIFY_CONNECT, CATEGORIES, ADD_RADIO, FEEDBACK, CARD_ADDON_RATE, GAP, CARD_ADDON_FREE};
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

    public LullabyItem(Context context, int i, Type type) {
        context.getClass();
        type.getClass();
        this.context = context;
        this.layout = i;
        this.type = type;
    }

    public void bindView(T viewHolder) {
        viewHolder.getClass();
        viewHolder.itemView.setOnClickListener(new LullabyItem$$ExternalSyntheticLambda0(this, 0));
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

    public void onItemClicked() {
    }
}
