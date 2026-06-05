package io.github.zeroone3010.yahueapi.v2;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Hue$$ExternalSyntheticLambda31 implements Predicate {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ String f$0;

    public /* synthetic */ Hue$$ExternalSyntheticLambda31(String str, int i) {
        this.$r8$classId = i;
        this.f$0 = str;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.$r8$classId;
        String str = this.f$0;
        switch (i) {
            case 0:
                return Hue.lambda$getRoomByName$32(str, (Group) obj);
            case 1:
                return ButtonEventType.lambda$parseFromButtonEventType$0(str, (ButtonEventType) obj);
            case 2:
                return GroupImpl.lambda$getSceneByName$0(str, (Scene) obj);
            case 3:
                return GroupImpl.lambda$getLightByName$1(str, (Light) obj);
            case 4:
                return Hue.lambda$getNewLightsSearchStatus$35(str, (Light) obj);
            default:
                return Hue.lambda$getZoneByName$33(str, (Group) obj);
        }
    }
}
