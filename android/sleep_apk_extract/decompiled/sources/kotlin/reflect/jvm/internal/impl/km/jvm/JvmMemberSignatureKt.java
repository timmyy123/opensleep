package kotlin.reflect.jvm.internal.impl.km.jvm;

import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;

/* JADX INFO: loaded from: classes5.dex */
public abstract class JvmMemberSignatureKt {
    public static final JvmMethodSignature wrapAsPublic(JvmMemberSignature.Method method) {
        method.getClass();
        return new JvmMethodSignature(method.getName(), method.getDesc());
    }

    public static final JvmFieldSignature wrapAsPublic(JvmMemberSignature.Field field) {
        field.getClass();
        return new JvmFieldSignature(field.getName(), field.getDesc());
    }
}
