package androidx.appsearch.app;

/* JADX INFO: loaded from: classes.dex */
public interface DocumentClassFactory<T> {
    T fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext);

    String getSchemaName();

    GenericDocument toGenericDocument(T t);
}
