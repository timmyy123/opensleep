package kotlin.reflect.jvm.internal.types;

import kotlin.Metadata;
import kotlin.reflect.KVariance;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¨\u0006\u0003"}, d2 = {"intersectWith", "Lkotlin/reflect/KVariance;", "other", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class KTypeSubstitutorKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final KVariance intersectWith(KVariance kVariance, KVariance kVariance2) {
        KVariance kVariance3 = KVariance.INVARIANT;
        if (kVariance == kVariance3) {
            return kVariance2;
        }
        if (kVariance2 == kVariance3 || kVariance == kVariance2) {
            return kVariance;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("CONFLICTING_PROJECTION");
        return null;
    }
}
