package androidx.appfunctions.metadata;

import androidx.appsearch.app.AppSearchDocumentClassMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: androidx.appfunctions.metadata.$$__AppSearch__DocumentClassMap_bcae608550740e646476acfd2133a68031488414e437242399de7561d6f7d9cd_0, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__DocumentClassMap_bcae608550740e646476acfd2133a68031488414e437242399de7561d6f7d9cd_0 extends AppSearchDocumentClassMap {
    @Override // androidx.appsearch.app.AppSearchDocumentClassMap
    public Map<String, List<String>> getMap() {
        HashMap map = new HashMap();
        map.put(C$$__AppSearch__AppFunctionComponentsMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionComponentsMetadataDocument"));
        map.put(C$$__AppSearch__AppFunctionDeprecationMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionDeprecationMetadataDocument"));
        map.put(C$$__AppSearch__AppFunctionMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionMetadataDocument"));
        map.put(C$$__AppSearch__AppFunctionResponseMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionResponseMetadataDocument"));
        map.put(C$$__AppSearch__AppFunctionRuntimeMetadata.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionRuntimeMetadata"));
        map.put(C$$__AppSearch__AppFunctionParameterMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionParameterMetadataDocument"));
        map.put(C$$__AppSearch__AppFunctionDataTypeMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionDataTypeMetadataDocument"));
        map.put(C$$__AppSearch__AppFunctionNamedDataTypeMetadataDocument.SCHEMA_NAME, Arrays.asList("androidx.appfunctions.metadata.AppFunctionNamedDataTypeMetadataDocument"));
        return map;
    }
}
