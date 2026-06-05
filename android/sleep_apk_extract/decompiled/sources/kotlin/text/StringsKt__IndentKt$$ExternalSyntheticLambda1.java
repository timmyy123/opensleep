package kotlin.text;

import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class StringsKt__IndentKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ StringsKt__IndentKt$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                return StringsKt__IndentKt.getIndentFunction$lambda$1$StringsKt__IndentKt((String) obj2, (String) obj);
            case 1:
                return StringsKt__IndentKt.prependIndent$lambda$0$StringsKt__IndentKt((String) obj2, (String) obj);
            default:
                return ((MatcherMatchResult$groups$1) obj2).get(((Integer) obj).intValue());
        }
    }
}
