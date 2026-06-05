package androidx.appsearch.usagereporting;

import androidx.appsearch.app.AppSearchDocumentClassMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.appsearch.usagereporting.$$__AppSearch__DocumentClassMap_d8c38be6e7324bce3bef36b39418d987bb4285b33ec2e33e3aea0d9ccb6519d7_0, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__DocumentClassMap_d8c38be6e7324bce3bef36b39418d987bb4285b33ec2e33e3aea0d9ccb6519d7_0 extends AppSearchDocumentClassMap {
    @Override // androidx.appsearch.app.AppSearchDocumentClassMap
    public Map<String, List<String>> getMap() {
        HashMap map = new HashMap();
        map.put("builtin:ClickAction", Arrays.asList("androidx.appsearch.usagereporting.ClickAction"));
        map.put("builtin:SearchAction", Arrays.asList("androidx.appsearch.usagereporting.SearchAction"));
        map.put("builtin:DismissAction", Arrays.asList("androidx.appsearch.usagereporting.DismissAction"));
        map.put("builtin:ImpressionAction", Arrays.asList("androidx.appsearch.usagereporting.ImpressionAction"));
        map.put("builtin:TakenAction", Arrays.asList("androidx.appsearch.usagereporting.TakenAction"));
        return map;
    }
}
