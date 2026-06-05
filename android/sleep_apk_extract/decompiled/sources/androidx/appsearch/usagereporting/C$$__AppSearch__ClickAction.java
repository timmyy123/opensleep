package androidx.appsearch.usagereporting;

import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.usagereporting.ClickAction;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: renamed from: androidx.appsearch.usagereporting.$$__AppSearch__ClickAction, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__ClickAction implements DocumentClassFactory<ClickAction> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public ClickAction fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long ttlMillis = genericDocument.getTtlMillis();
        long creationTimestampMillis = genericDocument.getCreationTimestampMillis();
        int propertyLong = (int) genericDocument.getPropertyLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE);
        String[] propertyStringArray = genericDocument.getPropertyStringArray("query");
        String str = null;
        String str2 = (propertyStringArray == null || propertyStringArray.length == 0) ? null : propertyStringArray[0];
        String[] propertyStringArray2 = genericDocument.getPropertyStringArray("referencedQualifiedId");
        if (propertyStringArray2 != null && propertyStringArray2.length != 0) {
            str = propertyStringArray2[0];
        }
        String str3 = str;
        int propertyLong2 = (int) genericDocument.getPropertyLong("resultRankInBlock");
        int propertyLong3 = (int) genericDocument.getPropertyLong("resultRankGlobal");
        long propertyLong4 = genericDocument.getPropertyLong("timeStayOnResultMillis");
        ClickAction.Builder builder = new ClickAction.Builder(namespace, id, creationTimestampMillis, propertyLong);
        builder.setDocumentTtlMillis(ttlMillis);
        builder.setQuery(str2);
        builder.setReferencedQualifiedId(str3);
        builder.setResultRankInBlock(propertyLong2);
        builder.setResultRankGlobal(propertyLong3);
        builder.setTimeStayOnResultMillis(propertyLong4);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return "builtin:ClickAction";
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(ClickAction clickAction) {
        GenericDocument.Builder builder = new GenericDocument.Builder(clickAction.getNamespace(), clickAction.getId(), "builtin:ClickAction");
        builder.setTtlMillis(clickAction.getDocumentTtlMillis());
        builder.setCreationTimestampMillis(clickAction.getActionTimestampMillis());
        builder.setPropertyLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, clickAction.getActionType());
        String query = clickAction.getQuery();
        if (query != null) {
            builder.setPropertyString("query", query);
        }
        String referencedQualifiedId = clickAction.getReferencedQualifiedId();
        if (referencedQualifiedId != null) {
            builder.setPropertyString("referencedQualifiedId", referencedQualifiedId);
        }
        builder.setPropertyLong("resultRankInBlock", clickAction.getResultRankInBlock());
        builder.setPropertyLong("resultRankGlobal", clickAction.getResultRankGlobal());
        builder.setPropertyLong("timeStayOnResultMillis", clickAction.getTimeStayOnResultMillis());
        return builder.build();
    }
}
