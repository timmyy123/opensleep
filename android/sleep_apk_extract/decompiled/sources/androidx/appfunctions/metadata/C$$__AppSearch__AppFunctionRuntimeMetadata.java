package androidx.appfunctions.metadata;

import androidx.appfunctions.compiler.core.AppFunctionXmlGenerator;
import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: androidx.appfunctions.metadata.$$__AppSearch__AppFunctionRuntimeMetadata, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__AppFunctionRuntimeMetadata implements DocumentClassFactory<AppFunctionRuntimeMetadata> {
    public static final String SCHEMA_NAME = "AppFunctionRuntimeMetadata";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionRuntimeMetadata fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String id = genericDocument.getId();
        String namespace = genericDocument.getNamespace();
        String[] propertyStringArray = genericDocument.getPropertyStringArray(AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG);
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("packageName");
        String str3 = (propertyStringArray2 == null || propertyStringArray2.length == 0) ? null : propertyStringArray2[0];
        long propertyLong = genericDocument.getPropertyLong("enabled");
        String[] propertyStringArray3 = genericDocument.getPropertyStringArray(AppFunctionRuntimeMetadata.STATIC_METADATA_JOIN_PROPERTY);
        if (propertyStringArray3 != null && propertyStringArray3.length != 0) {
            str = propertyStringArray3[0];
        }
        return new AppFunctionRuntimeMetadata(id, namespace, str2, str3, propertyLong, str);
    }

    public List<Class<?>> getDependencyDocumentClasses() {
        return Collections.EMPTY_LIST;
    }

    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.StringPropertyConfig.Builder(AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG).setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("packageName").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.LongPropertyConfig.Builder("enabled").setCardinality(2).setIndexingType(0).build()).addProperty(new AppSearchSchema.StringPropertyConfig.Builder(AppFunctionRuntimeMetadata.STATIC_METADATA_JOIN_PROPERTY).setCardinality(2).setTokenizerType(1).setIndexingType(1).setJoinableValueType(1).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionRuntimeMetadata appFunctionRuntimeMetadata) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionRuntimeMetadata.getNamespace(), appFunctionRuntimeMetadata.getId(), SCHEMA_NAME);
        String functionId = appFunctionRuntimeMetadata.getFunctionId();
        if (functionId != null) {
            builder.setPropertyString(AppFunctionXmlGenerator.APP_FUNCTION_ID_TAG, functionId);
        }
        String packageName = appFunctionRuntimeMetadata.getPackageName();
        if (packageName != null) {
            builder.setPropertyString("packageName", packageName);
        }
        builder.setPropertyLong("enabled", appFunctionRuntimeMetadata.getEnabled());
        String appFunctionStaticMetadataQualifiedId = appFunctionRuntimeMetadata.getAppFunctionStaticMetadataQualifiedId();
        if (appFunctionStaticMetadataQualifiedId != null) {
            builder.setPropertyString(AppFunctionRuntimeMetadata.STATIC_METADATA_JOIN_PROPERTY, appFunctionStaticMetadataQualifiedId);
        }
        return builder.build();
    }
}
