package kotlinx.serialization.json.internal;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.serialization.json.JsonElement;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TreeJsonEncoderKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ TreeJsonEncoderKt$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return TreeJsonEncoderKt.writeJson$lambda$0((Ref$ObjectRef) obj2, (JsonElement) obj);
            default:
                return AbstractJsonTreeEncoder.beginStructure$lambda$2((AbstractJsonTreeEncoder) obj2, (JsonElement) obj);
        }
    }
}
