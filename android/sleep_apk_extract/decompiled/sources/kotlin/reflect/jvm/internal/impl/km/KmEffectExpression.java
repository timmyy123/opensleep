package kotlin.reflect.jvm.internal.impl.km;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class KmEffectExpression {
    private KmConstantValue constantValue;
    private int flags;
    private KmType isInstanceType;
    private Integer parameterIndex;
    private final List<KmEffectExpression> andArguments = new ArrayList(0);
    private final List<KmEffectExpression> orArguments = new ArrayList(0);

    public final List<KmEffectExpression> getAndArguments() {
        return this.andArguments;
    }

    public final int getFlags$kotlin_metadata() {
        return this.flags;
    }

    public final List<KmEffectExpression> getOrArguments() {
        return this.orArguments;
    }

    public final void setConstantValue(KmConstantValue kmConstantValue) {
        this.constantValue = kmConstantValue;
    }

    public final void setFlags$kotlin_metadata(int i) {
        this.flags = i;
    }

    public final void setInstanceType(KmType kmType) {
        this.isInstanceType = kmType;
    }

    public final void setParameterIndex(Integer num) {
        this.parameterIndex = num;
    }
}
