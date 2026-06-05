package androidx.appfunctions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/appfunctions/AppFunctionResourceContainer;", "", "resources", "", "Landroidx/appfunctions/AppFunctionTextResource;", "getResources", "()Ljava/util/List;", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface AppFunctionResourceContainer {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0006H\u0007R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Landroidx/appfunctions/AppFunctionResourceContainer$Companion;", "", "<init>", "()V", "asAppFunctionResourceContainer", "Landroidx/appfunctions/AppFunctionResourceContainer;", "Landroidx/appfunctions/AppFunctionData;", "RESOURCES_PROPERTY", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final String RESOURCES_PROPERTY = "resources";

        private Companion() {
        }

        public final AppFunctionResourceContainer asAppFunctionResourceContainer(AppFunctionData appFunctionData) {
            appFunctionData.getClass();
            List<AppFunctionData> appFunctionDataList = appFunctionData.getAppFunctionDataList(RESOURCES_PROPERTY);
            if (appFunctionDataList == null) {
                return null;
            }
            List<AppFunctionData> list = appFunctionDataList;
            final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((AppFunctionTextResource) ((AppFunctionData) it.next()).deserialize(AppFunctionTextResource.class));
            }
            return new AppFunctionResourceContainer(arrayList) { // from class: androidx.appfunctions.AppFunctionResourceContainer$Companion$asAppFunctionResourceContainer$1
                private final List<AppFunctionTextResource> resources;

                {
                    this.resources = arrayList;
                }

                @Override // androidx.appfunctions.AppFunctionResourceContainer
                public List<AppFunctionTextResource> getResources() {
                    return this.resources;
                }
            };
        }
    }

    static AppFunctionResourceContainer asAppFunctionResourceContainer(AppFunctionData appFunctionData) {
        return INSTANCE.asAppFunctionResourceContainer(appFunctionData);
    }

    default List<AppFunctionTextResource> getResources() {
        return CollectionsKt.emptyList();
    }
}
