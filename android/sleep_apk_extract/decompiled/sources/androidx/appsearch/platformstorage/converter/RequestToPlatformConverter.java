package androidx.appsearch.platformstorage.converter;

import android.app.appsearch.GetByDocumentIdRequest;
import androidx.core.util.Preconditions;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class RequestToPlatformConverter {
    public static GetByDocumentIdRequest toPlatformGetByDocumentIdRequest(androidx.appsearch.app.GetByDocumentIdRequest getByDocumentIdRequest) {
        Preconditions.checkNotNull(getByDocumentIdRequest);
        GetByDocumentIdRequest.Builder builderAddIds = new GetByDocumentIdRequest.Builder(getByDocumentIdRequest.getNamespace()).addIds(getByDocumentIdRequest.getIds());
        for (Map.Entry<String, List<String>> entry : getByDocumentIdRequest.getProjections().entrySet()) {
            builderAddIds.addProjection(entry.getKey(), entry.getValue());
        }
        return builderAddIds.build();
    }
}
