package androidx.appfunctions.metadata;

import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: androidx.appfunctions.metadata.$$__AppSearch__AppFunctionMetadataDocument, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__AppFunctionMetadataDocument implements DocumentClassFactory<AppFunctionMetadataDocument> {
    public static final String SCHEMA_NAME = "AppFunctionStaticMetadata";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionMetadataDocument fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        ArrayList arrayList;
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        boolean propertyBoolean = genericDocument.getPropertyBoolean("enabledByDefault");
        String[] propertyStringArray = genericDocument.getPropertyStringArray("schemaCategory");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("schemaName");
        String str2 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        long[] propertyLongArray = genericDocument.getPropertyLongArray("schemaVersion");
        Long lValueOf = (propertyLongArray == null || propertyLongArray.length == 0) ? null : Long.valueOf(propertyLongArray[0]);
        GenericDocument[] propertyDocumentArray = genericDocument.getPropertyDocumentArray(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME);
        if (propertyDocumentArray != null) {
            ArrayList arrayList2 = new ArrayList(propertyDocumentArray.length);
            for (GenericDocument genericDocument2 : propertyDocumentArray) {
                arrayList2.add((AppFunctionParameterMetadataDocument) genericDocument2.toDocumentClass(AppFunctionParameterMetadataDocument.class, documentClassMappingContext));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("response");
        AppFunctionResponseMetadataDocument appFunctionResponseMetadataDocument = propertyDocument != null ? (AppFunctionResponseMetadataDocument) propertyDocument.toDocumentClass(AppFunctionResponseMetadataDocument.class, documentClassMappingContext) : null;
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray("description");
        String str3 = (propertyStringArray3 == null || propertyStringArray3.length == 0) ? null : propertyStringArray3[0];
        GenericDocument propertyDocument2 = genericDocument.getPropertyDocument("deprecation");
        return new AppFunctionMetadataDocument(namespace, id, propertyBoolean, str, str2, lValueOf, arrayList, appFunctionResponseMetadataDocument, str3, propertyDocument2 != null ? (AppFunctionDeprecationMetadataDocument) propertyDocument2.toDocumentClass(AppFunctionDeprecationMetadataDocument.class, documentClassMappingContext) : null);
    }

    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AppFunctionParameterMetadataDocument.class);
        arrayList.add(AppFunctionResponseMetadataDocument.class);
        arrayList.add(AppFunctionDeprecationMetadataDocument.class);
        return arrayList;
    }

    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("enabledByDefault").setCardinality(2).build()).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("schemaCategory").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("schemaName").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.LongPropertyConfig.Builder("schemaVersion").setCardinality(2).setIndexingType(0).build()).addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, C$$__AppSearch__AppFunctionParameterMetadataDocument.SCHEMA_NAME).setCardinality(1).setShouldIndexNestedProperties(false).build()).addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder("response", C$$__AppSearch__AppFunctionResponseMetadataDocument.SCHEMA_NAME).setCardinality(2).setShouldIndexNestedProperties(false).build()).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("description").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder("deprecation", C$$__AppSearch__AppFunctionDeprecationMetadataDocument.SCHEMA_NAME).setCardinality(2).setShouldIndexNestedProperties(false).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionMetadataDocument appFunctionMetadataDocument) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionMetadataDocument.getNamespace(), appFunctionMetadataDocument.getId(), SCHEMA_NAME);
        int i = 0;
        builder.setPropertyBoolean("enabledByDefault", appFunctionMetadataDocument.isEnabledByDefault());
        String schemaCategory = appFunctionMetadataDocument.getSchemaCategory();
        if (schemaCategory != null) {
            builder.setPropertyString("schemaCategory", schemaCategory);
        }
        String schemaName = appFunctionMetadataDocument.getSchemaName();
        if (schemaName != null) {
            builder.setPropertyString("schemaName", schemaName);
        }
        Long schemaVersion = appFunctionMetadataDocument.getSchemaVersion();
        if (schemaVersion != null) {
            builder.setPropertyLong("schemaVersion", schemaVersion.longValue());
        }
        List<AppFunctionParameterMetadataDocument> parameters = appFunctionMetadataDocument.getParameters();
        if (parameters != null) {
            GenericDocument[] genericDocumentArr = new GenericDocument[parameters.size()];
            Iterator<AppFunctionParameterMetadataDocument> it = parameters.iterator();
            while (it.hasNext()) {
                genericDocumentArr[i] = GenericDocument.fromDocumentClass(it.next());
                i++;
            }
            builder.setPropertyDocument(IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, genericDocumentArr);
        }
        AppFunctionResponseMetadataDocument response = appFunctionMetadataDocument.getResponse();
        if (response != null) {
            builder.setPropertyDocument("response", GenericDocument.fromDocumentClass(response));
        }
        String description = appFunctionMetadataDocument.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        AppFunctionDeprecationMetadataDocument deprecation = appFunctionMetadataDocument.getDeprecation();
        if (deprecation != null) {
            builder.setPropertyDocument("deprecation", GenericDocument.fromDocumentClass(deprecation));
        }
        return builder.build();
    }
}
