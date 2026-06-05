package com.urbandroid.sleep.fragment.dashboard.card;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\bJ\u0018\u0010\f\u001a\u00020\n2\u0010\u0010\r\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000eJ\u0016\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00108F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/RemovedCardList;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "list", "", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "add", "", "card", "addAll", "cards", "", "nameArray", "", "", "getNameArray", "()[Ljava/lang/CharSequence;", "checked", "", "getChecked", "()[Z", "setVisible", "index", "", "visible", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RemovedCardList {
    private final Context context;
    private final List<DashboardCard<?>> list;

    public RemovedCardList(Context context) {
        context.getClass();
        this.context = context;
        this.list = new ArrayList();
    }

    public final void add(DashboardCard<?> card) {
        card.getClass();
        if (!card.isRemovable() || (card instanceof ShowCaseCard)) {
            return;
        }
        this.list.add(card);
    }

    public final void addAll(Collection<? extends DashboardCard<?>> cards) {
        cards.getClass();
        for (DashboardCard<?> dashboardCard : cards) {
            if (dashboardCard.isRemovable()) {
                add(dashboardCard);
            }
        }
    }

    public final boolean[] getChecked() {
        boolean[] zArr = new boolean[this.list.size()];
        Iterator<DashboardCard<?>> it = this.list.iterator();
        int i = 0;
        while (it.hasNext()) {
            zArr[i] = !it.next().isRemoved();
            i++;
        }
        return zArr;
    }

    public final CharSequence[] getNameArray() {
        CharSequence[] charSequenceArr = new CharSequence[this.list.size()];
        Iterator<DashboardCard<?>> it = this.list.iterator();
        int i = 0;
        while (it.hasNext()) {
            charSequenceArr[i] = it.next().getName();
            i++;
        }
        return charSequenceArr;
    }

    public final void setVisible(int index, boolean visible) {
        this.list.get(index).setRemoved(!visible);
    }
}
