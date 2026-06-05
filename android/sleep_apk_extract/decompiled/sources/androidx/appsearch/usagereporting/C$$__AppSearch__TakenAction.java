package androidx.appsearch.usagereporting;

import androidx.appsearch.app.DocumentClassFactory;
import androidx.appsearch.app.DocumentClassMappingContext;
import androidx.appsearch.app.GenericDocument;
import androidx.appsearch.usagereporting.TakenAction;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;

/* JADX INFO: renamed from: androidx.appsearch.usagereporting.$$__AppSearch__TakenAction, reason: invalid class name */
/* JADX INFO: loaded from: classes.dex */
public final class C$$__AppSearch__TakenAction implements DocumentClassFactory<TakenAction> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.appsearch.app.DocumentClassFactory
    public TakenAction fromGenericDocument(GenericDocument genericDocument, DocumentClassMappingContext documentClassMappingContext) {
        String namespace = genericDocument.getNamespace();
        String id = genericDocument.getId();
        long ttlMillis = genericDocument.getTtlMillis();
        TakenAction.Builder builder = new TakenAction.Builder(namespace, id, genericDocument.getCreationTimestampMillis(), (int) genericDocument.getPropertyLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE));
        builder.setDocumentTtlMillis(ttlMillis);
        return builder.build();
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public String getSchemaName() {
        return "builtin:TakenAction";
    }

    @Override // androidx.appsearch.app.DocumentClassFactory
    public GenericDocument toGenericDocument(TakenAction takenAction) {
        GenericDocument.Builder builder = new GenericDocument.Builder(takenAction.getNamespace(), takenAction.getId(), "builtin:TakenAction");
        builder.setTtlMillis(takenAction.getDocumentTtlMillis());
        builder.setCreationTimestampMillis(takenAction.getActionTimestampMillis());
        builder.setPropertyLong(SDKConstants.PARAM_GAME_REQUESTS_ACTION_TYPE, takenAction.getActionType());
        return builder.build();
    }
}
