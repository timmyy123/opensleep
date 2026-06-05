package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.observer.ObserverSpec;
import androidx.appsearch.observer.DocumentChangeInfo;
import androidx.appsearch.observer.SchemaChangeInfo;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public abstract class ObserverSpecToPlatformConverter {
    public static DocumentChangeInfo toJetpackDocumentChangeInfo(android.app.appsearch.observer.DocumentChangeInfo documentChangeInfo) {
        Preconditions.checkNotNull(documentChangeInfo);
        return new DocumentChangeInfo(documentChangeInfo.getPackageName(), documentChangeInfo.getDatabaseName(), documentChangeInfo.getNamespace(), documentChangeInfo.getSchemaName(), documentChangeInfo.getChangedDocumentIds());
    }

    public static SchemaChangeInfo toJetpackSchemaChangeInfo(android.app.appsearch.observer.SchemaChangeInfo schemaChangeInfo) {
        Preconditions.checkNotNull(schemaChangeInfo);
        return new SchemaChangeInfo(schemaChangeInfo.getPackageName(), schemaChangeInfo.getDatabaseName(), schemaChangeInfo.getChangedSchemaNames());
    }

    public static ObserverSpec toPlatformObserverSpec(androidx.appsearch.observer.ObserverSpec observerSpec) {
        Preconditions.checkNotNull(observerSpec);
        return new ObserverSpec.Builder().addFilterSchemas(observerSpec.getFilterSchemas()).build();
    }
}
