package androidx.appsearch.platformstorage;

import android.app.appsearch.GenericDocument;
import androidx.appsearch.platformstorage.converter.GenericDocumentToPlatformConverter;
import java.util.function.Function;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class GlobalSearchSessionImpl$$ExternalSyntheticLambda2 implements Function {
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return GenericDocumentToPlatformConverter.toJetpackGenericDocument((GenericDocument) obj);
    }
}
