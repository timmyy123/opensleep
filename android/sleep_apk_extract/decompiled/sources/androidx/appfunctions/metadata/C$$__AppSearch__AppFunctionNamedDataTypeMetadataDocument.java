package androidx.appfunctions.metadata;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: androidx.appfunctions.metadata.$$__AppSearch__AppFunctionNamedDataTypeMetadataDocument, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__AppFunctionNamedDataTypeMetadataDocument implements DocumentClassFactory<AppFunctionNamedDataTypeMetadataDocument> {
    public static final String SCHEMA_NAME = "AppFunctionNamedDataTypeMetadataDocument";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionNamedDataTypeMetadataDocument fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dataTypeMetadata");
        return new AppFunctionNamedDataTypeMetadataDocument(namespace, id, str, propertyDocument != null ? (AppFunctionDataTypeMetadataDocument) propertyDocument.toDocumentClass(AppFunctionDataTypeMetadataDocument.class, documentClassMappingContext) : null);
    }

    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AppFunctionDataTypeMetadataDocument.class);
        return arrayList;
    }

    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("name").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder("dataTypeMetadata", C$$__AppSearch__AppFunctionDataTypeMetadataDocument.SCHEMA_NAME).setCardinality(2).setShouldIndexNestedProperties(false).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionNamedDataTypeMetadataDocument appFunctionNamedDataTypeMetadataDocument) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionNamedDataTypeMetadataDocument.getNamespace(), appFunctionNamedDataTypeMetadataDocument.getId(), SCHEMA_NAME);
        String name = appFunctionNamedDataTypeMetadataDocument.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        AppFunctionDataTypeMetadataDocument dataTypeMetadata = appFunctionNamedDataTypeMetadataDocument.getDataTypeMetadata();
        if (dataTypeMetadata != null) {
            builder.setPropertyDocument("dataTypeMetadata", GenericDocument.fromDocumentClass(dataTypeMetadata));
        }
        return builder.build();
    }
}
