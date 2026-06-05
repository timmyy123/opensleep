package androidx.appfunctions.internal;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.compiler.processors.AppFunctionInventoryProcessor;
import androidx.appfunctions.metadata.AppFunctionComponentsMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R'\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/appfunctions/internal/AggregatedAppFunctionInventory;", "Landroidx/appfunctions/internal/AppFunctionInventory;", "<init>", "()V", IntrospectionHelper.AggregatedAppFunctionInventoryClass.PROPERTY_INVENTORIES_NAME, "", "getInventories", "()Ljava/util/List;", AppFunctionInventoryProcessor.FUNCTION_ID_TO_METADATA_MAP_PROPERTY_NAME, "", "", "Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "getFunctionIdToMetadataMap", "()Ljava/util/Map;", "functionIdToMetadataMap$delegate", "Lkotlin/Lazy;", AppFunctionInventoryProcessor.INVENTORY_COMPONENTS_METADATA_PROPERTY_NAME, "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "getComponentsMetadata", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "componentsMetadata$delegate", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AggregatedAppFunctionInventory implements AppFunctionInventory {

    /* JADX INFO: renamed from: componentsMetadata$delegate, reason: from kotlin metadata */
    private final Lazy componentsMetadata;

    /* JADX INFO: renamed from: functionIdToMetadataMap$delegate, reason: from kotlin metadata */
    private final Lazy functionIdToMetadataMap;

    public AggregatedAppFunctionInventory() {
        final int i = 0;
        this.functionIdToMetadataMap = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.internal.AggregatedAppFunctionInventory$$ExternalSyntheticLambda0
            public final /* synthetic */ AggregatedAppFunctionInventory f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                AggregatedAppFunctionInventory aggregatedAppFunctionInventory = this.f$0;
                switch (i2) {
                    case 0:
                        return AggregatedAppFunctionInventory.functionIdToMetadataMap_delegate$lambda$0(aggregatedAppFunctionInventory);
                    default:
                        return AggregatedAppFunctionInventory.componentsMetadata_delegate$lambda$0(aggregatedAppFunctionInventory);
                }
            }
        });
        final int i2 = 1;
        this.componentsMetadata = LazyKt.lazy(new Function0(this) { // from class: androidx.appfunctions.internal.AggregatedAppFunctionInventory$$ExternalSyntheticLambda0
            public final /* synthetic */ AggregatedAppFunctionInventory f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                AggregatedAppFunctionInventory aggregatedAppFunctionInventory = this.f$0;
                switch (i22) {
                    case 0:
                        return AggregatedAppFunctionInventory.functionIdToMetadataMap_delegate$lambda$0(aggregatedAppFunctionInventory);
                    default:
                        return AggregatedAppFunctionInventory.componentsMetadata_delegate$lambda$0(aggregatedAppFunctionInventory);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppFunctionComponentsMetadata componentsMetadata_delegate$lambda$0(AggregatedAppFunctionInventory aggregatedAppFunctionInventory) {
        Map map = null;
        boolean z = false;
        if (aggregatedAppFunctionInventory.getInventories().isEmpty()) {
            return new AppFunctionComponentsMetadata(map, 1, z ? 1 : 0);
        }
        List<AppFunctionInventory> inventories = aggregatedAppFunctionInventory.getInventories();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(inventories, 10));
        Iterator<T> it = inventories.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionInventory) it.next()).getComponentsMetadata().getDataTypes());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            Utf8$$ExternalSyntheticBUOutline0.m("Empty collection can't be reduced.");
            return null;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = MapsKt.plus((Map) next, (Map) it2.next());
        }
        return new AppFunctionComponentsMetadata((Map) next);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map functionIdToMetadataMap_delegate$lambda$0(AggregatedAppFunctionInventory aggregatedAppFunctionInventory) {
        if (aggregatedAppFunctionInventory.getInventories().isEmpty()) {
            return MapsKt.emptyMap();
        }
        List<AppFunctionInventory> inventories = aggregatedAppFunctionInventory.getInventories();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(inventories, 10));
        Iterator<T> it = inventories.iterator();
        while (it.hasNext()) {
            arrayList.add(((AppFunctionInventory) it.next()).getFunctionIdToMetadataMap());
        }
        Iterator it2 = arrayList.iterator();
        if (!it2.hasNext()) {
            Utf8$$ExternalSyntheticBUOutline0.m("Empty collection can't be reduced.");
            return null;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            next = MapsKt.plus((Map) next, (Map) it2.next());
        }
        return (Map) next;
    }

    @Override // androidx.appfunctions.internal.AppFunctionInventory
    public final AppFunctionComponentsMetadata getComponentsMetadata() {
        return (AppFunctionComponentsMetadata) this.componentsMetadata.getValue();
    }

    @Override // androidx.appfunctions.internal.AppFunctionInventory
    public final Map<String, CompileTimeAppFunctionMetadata> getFunctionIdToMetadataMap() {
        return (Map) this.functionIdToMetadataMap.getValue();
    }

    public abstract List<AppFunctionInventory> getInventories();
}
