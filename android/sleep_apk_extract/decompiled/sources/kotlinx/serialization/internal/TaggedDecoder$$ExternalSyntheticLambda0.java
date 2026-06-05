package kotlinx.serialization.internal;

import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class TaggedDecoder$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ TaggedDecoder f$0;
    public final /* synthetic */ DeserializationStrategy f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ TaggedDecoder$$ExternalSyntheticLambda0(TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy, Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = taggedDecoder;
        this.f$1 = deserializationStrategy;
        this.f$2 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$2;
        DeserializationStrategy deserializationStrategy = this.f$1;
        TaggedDecoder taggedDecoder = this.f$0;
        switch (i) {
            case 0:
                return taggedDecoder.decodeSerializableValue(deserializationStrategy, obj);
            default:
                return TaggedDecoder.decodeNullableSerializableElement$lambda$3(taggedDecoder, deserializationStrategy, obj);
        }
    }
}
