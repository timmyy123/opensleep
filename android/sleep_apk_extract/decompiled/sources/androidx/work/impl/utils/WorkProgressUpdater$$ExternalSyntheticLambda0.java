package androidx.work.impl.utils;

import android.view.ViewGroup;
import androidx.room.BaseRoomConnectionManager;
import androidx.work.Data;
import com.urbandroid.sleep.fragment.dashboard.card.NativeAdCard;
import java.util.UUID;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WorkProgressUpdater$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ WorkProgressUpdater$$ExternalSyntheticLambda0(Object obj, Object obj2, Object obj3, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = obj3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$2;
        Object obj2 = this.f$1;
        Object obj3 = this.f$0;
        switch (i) {
            case 0:
                return ((WorkProgressUpdater) obj3).lambda$updateProgress$0((UUID) obj2, (Data) obj);
            case 1:
                return BaseRoomConnectionManager.DriverWrapper.openLocked$lambda$1((BaseRoomConnectionManager) obj3, (BaseRoomConnectionManager.DriverWrapper) obj2, (String) obj);
            default:
                return NativeAdCard.bindView$lambda$1((NativeAdCard) obj3, (ViewGroup) obj2, (NativeAdCard.NativeAdViewHolder) obj);
        }
    }
}
