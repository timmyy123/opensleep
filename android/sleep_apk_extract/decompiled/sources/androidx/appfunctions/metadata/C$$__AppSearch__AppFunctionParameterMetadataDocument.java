package androidx.appfunctions.metadata;

import androidx.appsearch.app.AppSearchSchema;
import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: androidx.appfunctions.metadata.$$__AppSearch__AppFunctionParameterMetadataDocument, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__AppFunctionParameterMetadataDocument implements DocumentClassFactory<AppFunctionParameterMetadataDocument> {
    public static final String SCHEMA_NAME = "AppFunctionParameterMetadataDocument";

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public AppFunctionParameterMetadataDocument fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        String[] propertyStringArray = genericDocument.getPropertyStringArray("name");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        boolean propertyBoolean = genericDocument.getPropertyBoolean("isRequired");
        GenericDocument propertyDocument = genericDocument.getPropertyDocument("dataTypeMetadata");
        AppFunctionDataTypeMetadataDocument appFunctionDataTypeMetadataDocument = propertyDocument != null ? (AppFunctionDataTypeMetadataDocument) propertyDocument.toDocumentClass(AppFunctionDataTypeMetadataDocument.class, documentClassMappingContext) : null;
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("description");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        return new AppFunctionParameterMetadataDocument(namespace, id, str2, propertyBoolean, appFunctionDataTypeMetadataDocument, str);
    }

    public List<Class<?>> getDependencyDocumentClasses() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(AppFunctionDataTypeMetadataDocument.class);
        return arrayList;
    }

    public AppSearchSchema getSchema() {
        return new AppSearchSchema.Builder(SCHEMA_NAME).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("name").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).addProperty(new AppSearchSchema.BooleanPropertyConfig.Builder("isRequired").setCardinality(2).build()).addProperty(new AppSearchSchema.DocumentPropertyConfig.Builder("dataTypeMetadata", C$$__AppSearch__AppFunctionDataTypeMetadataDocument.SCHEMA_NAME).setCardinality(2).setShouldIndexNestedProperties(false).build()).addProperty(new AppSearchSchema.StringPropertyConfig.Builder("description").setCardinality(2).setTokenizerType(0).setIndexingType(0).setJoinableValueType(0).build()).build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return SCHEMA_NAME;
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(AppFunctionParameterMetadataDocument appFunctionParameterMetadataDocument) {
        GenericDocument.Builder builder = new GenericDocument.Builder(appFunctionParameterMetadataDocument.getNamespace(), appFunctionParameterMetadataDocument.getId(), SCHEMA_NAME);
        String name = appFunctionParameterMetadataDocument.getName();
        if (name != null) {
            builder.setPropertyString("name", name);
        }
        builder.setPropertyBoolean("isRequired", appFunctionParameterMetadataDocument.isRequired());
        AppFunctionDataTypeMetadataDocument dataTypeMetadata = appFunctionParameterMetadataDocument.getDataTypeMetadata();
        if (dataTypeMetadata != null) {
            builder.setPropertyDocument("dataTypeMetadata", GenericDocument.fromDocumentClass(dataTypeMetadata));
        }
        String description = appFunctionParameterMetadataDocument.getDescription();
        if (description != null) {
            builder.setPropertyString("description", description);
        }
        return builder.build();
    }
}
