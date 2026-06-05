package com.google.firebase.encoders.proto;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.proto.ProtobufEncoder;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ProtobufEncoder$Builder$$ExternalSyntheticLambda0 implements ObjectEncoder {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ ProtobufEncoder$Builder$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final void encode(Object obj, Object obj2) {
        switch (this.$r8$classId) {
            case 0:
                ProtobufEncoder.Builder.lambda$static$0(obj, (ObjectEncoderContext) obj2);
                break;
            default:
                ProtobufDataEncoderContext.lambda$static$0((Map.Entry) obj, (ObjectEncoderContext) obj2);
                break;
        }
    }
}
