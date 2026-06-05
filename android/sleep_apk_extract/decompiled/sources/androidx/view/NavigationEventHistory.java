package androidx.view;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0010¢\u0006\u0004\b\u0007\u0010\tB1\b\u0011\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Landroidx/navigationevent/NavigationEventHistory;", "", "", "Landroidx/navigationevent/NavigationEventInfo;", "mergedHistory", "", "currentIndex", "<init>", "(Ljava/util/List;I)V", "()V", "currentInfo", "backInfo", "forwardInfo", "(Landroidx/navigationevent/NavigationEventInfo;Ljava/util/List;Ljava/util/List;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/List;", "getMergedHistory", "()Ljava/util/List;", "I", "getCurrentIndex", "navigationevent"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class NavigationEventHistory {
    private final int currentIndex;
    private final List<NavigationEventInfo> mergedHistory;

    /* JADX WARN: Multi-variable type inference failed */
    private NavigationEventHistory(List<? extends NavigationEventInfo> list, int i) {
        this.mergedHistory = list;
        this.currentIndex = i;
        if (list.isEmpty() && i == -1) {
            return;
        }
        if (!list.isEmpty()) {
            int size = list.size();
            if (i >= 0 && i < size) {
                return;
            }
        }
        Home$$ExternalSyntheticBUOutline0.m$1(Fragment$$ExternalSyntheticOutline1.m65m(i, "Invalid 'NavigationEventHistory' state:  'currentIndex' must be within the bounds of 'mergedHistory' (or -1 if empty). Received: currentIndex = '", "', bounds = '"), CollectionsKt.getIndices(list), "'.");
        throw null;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || NavigationEventHistory.class != other.getClass()) {
            return false;
        }
        NavigationEventHistory navigationEventHistory = (NavigationEventHistory) other;
        return this.currentIndex == navigationEventHistory.currentIndex && Intrinsics.areEqual(this.mergedHistory, navigationEventHistory.mergedHistory);
    }

    public int hashCode() {
        return this.mergedHistory.hashCode() + (this.currentIndex * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavigationEventHistory(currentIndex=");
        sb.append(this.currentIndex);
        sb.append(", mergedHistory=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, (List) this.mergedHistory, ')');
    }

    public NavigationEventHistory() {
        this(CollectionsKt.emptyList(), -1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationEventHistory(NavigationEventInfo navigationEventInfo, List<? extends NavigationEventInfo> list, List<? extends NavigationEventInfo> list2) {
        navigationEventInfo.getClass();
        list.getClass();
        list2.getClass();
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        List list3 = listCreateListBuilder;
        CollectionsKt__MutableCollectionsKt.addAll(list3, list);
        list3.add(navigationEventInfo);
        CollectionsKt__MutableCollectionsKt.addAll(list3, list2);
        this(CollectionsKt.build(listCreateListBuilder), list.size());
    }
}
