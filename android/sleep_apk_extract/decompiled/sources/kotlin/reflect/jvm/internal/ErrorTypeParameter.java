package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import kotlin.Metadata;
import kotlin.reflect.KClassifier;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/ErrorTypeParameter;", "Lkotlin/reflect/KClassifier;", "id", "", "<init>", "(I)V", InAppPurchaseConstants.METHOD_TO_STRING, "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ErrorTypeParameter implements KClassifier {
    private final int id;

    public ErrorTypeParameter(int i) {
        this.id = i;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m(new StringBuilder("[Error type parameter "), this.id, ']');
    }
}
