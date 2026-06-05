package androidx.appsearch.observer;

/* JADX INFO: loaded from: classes.dex */
public interface ObserverCallback {
    void onDocumentChanged(DocumentChangeInfo documentChangeInfo);

    void onSchemaChanged(SchemaChangeInfo schemaChangeInfo);
}
