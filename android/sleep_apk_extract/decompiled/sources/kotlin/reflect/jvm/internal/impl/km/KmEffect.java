package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class KmEffect {
    private KmEffectExpression conclusion;
    private final List<KmEffectExpression> constructorArguments;
    private KmEffectInvocationKind invocationKind;
    private KmEffectType type;

    public KmEffect(KmEffectType kmEffectType, KmEffectInvocationKind kmEffectInvocationKind) {
        kmEffectType.getClass();
        this.type = kmEffectType;
        this.invocationKind = kmEffectInvocationKind;
        this.constructorArguments = new ArrayList(1);
    }

    public final List<KmEffectExpression> getConstructorArguments() {
        return this.constructorArguments;
    }

    public final void setConclusion(KmEffectExpression kmEffectExpression) {
        this.conclusion = kmEffectExpression;
    }
}
