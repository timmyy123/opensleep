package kotlin.text;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.internal.EnumDescriptor;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Regex$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ int $r8$classId = 1;
    public final /* synthetic */ Serializable f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ Regex$$ExternalSyntheticLambda1(int i, String str, EnumDescriptor enumDescriptor) {
        this.f$2 = i;
        this.f$0 = str;
        this.f$1 = enumDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$1;
        Serializable serializable = this.f$0;
        int i2 = this.f$2;
        switch (i) {
            case 0:
                return ((Regex) serializable).find((CharSequence) obj, i2);
            default:
                return EnumDescriptor.elementDescriptors_delegate$lambda$0(i2, (String) serializable, (EnumDescriptor) obj);
        }
    }

    public /* synthetic */ Regex$$ExternalSyntheticLambda1(Regex regex, CharSequence charSequence, int i) {
        this.f$0 = regex;
        this.f$1 = charSequence;
        this.f$2 = i;
    }
}
