package io.github.zeroone3010.yahueapi;

import io.github.zeroone3010.yahueapi.v2.ButtonEventType;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Color$$ExternalSyntheticLambda4 implements Supplier {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ Color$$ExternalSyntheticLambda4(String str, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.$r8$classId;
        String str = this.f$0;
        switch (i) {
            case 0:
                return Color.lambda$of$5(str);
            default:
                return ButtonEventType.lambda$parseFromButtonEventType$1(str);
        }
    }
}
