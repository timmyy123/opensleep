package androidx.appsearch.usagereporting;

import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.usagereporting.SearchAction;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: renamed from: androidx.appsearch.usagereporting.$$__AppSearch__SearchAction, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__SearchAction implements DocumentClassFactory<SearchAction> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public SearchAction fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long ttlMillis = genericDocument.getTtlMillis();
        long creationTimestampMillis = genericDocument.getCreationTimestampMillis();
        int propertyLong = (int) genericDocument.getPropertyLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        int propertyLong2 = (int) genericDocument.getPropertyLong("fetchedResultCount");
        SearchAction.Builder builder = new SearchAction.Builder(namespace, id, creationTimestampMillis, propertyLong);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setQuery(str);
        builder.setFetchedResultCount(propertyLong2);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return "builtin:SearchAction";
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(SearchAction searchAction) {
        GenericDocument.Builder builder = new GenericDocument.Builder(searchAction.getNamespace(), searchAction.getId(), "builtin:SearchAction");
        builder.setTtlMillis(searchAction.getDocumentTtlMillis());
        builder.setCreationTimestampMillis(searchAction.getActionTimestampMillis());
        builder.setPropertyLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, searchAction.getActionType());
        String query = searchAction.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        builder.setPropertyLong("fetchedResultCount", searchAction.getFetchedResultCount());
        return builder.build();
    }
}
