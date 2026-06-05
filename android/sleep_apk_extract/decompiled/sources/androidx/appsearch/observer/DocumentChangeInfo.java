package androidx.appsearch.observer;

import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentChangeInfo {
    private final Set<String> mChangedDocumentIds;
    private final String mDatabase;
    private final String mNamespace;
    private final String mPackageName;
    private final String mSchemaName;

    public DocumentChangeInfo(String str, String str2, String str3, String str4, Set<String> set) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mDatabase = (String) Preconditions.checkNotNull(str2);
        this.mNamespace = (String) Preconditions.checkNotNull(str3);
        this.mSchemaName = (String) Preconditions.checkNotNull(str4);
        this.mChangedDocumentIds = Collections.unmodifiableSet((Set) Preconditions.checkNotNull(set));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DocumentChangeInfo)) {
            return false;
        }
        DocumentChangeInfo documentChangeInfo = (DocumentChangeInfo) obj;
        return this.mPackageName.equals(documentChangeInfo.mPackageName) && this.mDatabase.equals(documentChangeInfo.mDatabase) && this.mNamespace.equals(documentChangeInfo.mNamespace) && this.mSchemaName.equals(documentChangeInfo.mSchemaName) && this.mChangedDocumentIds.equals(documentChangeInfo.mChangedDocumentIds);
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.mPackageName, this.mDatabase, this.mNamespace, this.mSchemaName, this.mChangedDocumentIds);
    }

    public String toString() {
        return "DocumentChangeInfo{packageName='" + this.mPackageName + "', database='" + this.mDatabase + "', namespace='" + this.mNamespace + "', schemaName='" + this.mSchemaName + "', changedDocumentIds='" + this.mChangedDocumentIds + "'}";
    }
}
