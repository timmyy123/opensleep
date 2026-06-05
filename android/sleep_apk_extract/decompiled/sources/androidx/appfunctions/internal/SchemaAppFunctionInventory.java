package androidx.appfunctions.internal;

import androidx.appfunctions.metadata.AppFunctionSchemaMetadata;
import androidx.appfunctions.metadata.CompileTimeAppFunctionMetadata;
import io.ktor.http.Url$$ExternalSyntheticLambda0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R'\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Landroidx/appfunctions/internal/SchemaAppFunctionInventory;", "Landroidx/appfunctions/internal/AppFunctionInventory;", "<init>", "()V", "schemaFunctionsMap", "", "Landroidx/appfunctions/metadata/AppFunctionSchemaMetadata;", "Landroidx/appfunctions/metadata/CompileTimeAppFunctionMetadata;", "getSchemaFunctionsMap", "()Ljava/util/Map;", "schemaFunctionsMap$delegate", "Lkotlin/Lazy;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class SchemaAppFunctionInventory implements AppFunctionInventory {

    /* JADX INFO: renamed from: schemaFunctionsMap$delegate, reason: from kotlin metadata */
    private final Lazy schemaFunctionsMap = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(this, 3));

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map schemaFunctionsMap_delegate$lambda$0(SchemaAppFunctionInventory schemaAppFunctionInventory) {
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        for (CompileTimeAppFunctionMetadata compileTimeAppFunctionMetadata : schemaAppFunctionInventory.getFunctionIdToMetadataMap().values()) {
            AppFunctionSchemaMetadata schema = compileTimeAppFunctionMetadata.getSchema();
            if (schema != null) {
                mapCreateMapBuilder.put(schema, compileTimeAppFunctionMetadata);
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }

    public final Map<AppFunctionSchemaMetadata, CompileTimeAppFunctionMetadata> getSchemaFunctionsMap() {
        return (Map) this.schemaFunctionsMap.getValue();
    }
}
