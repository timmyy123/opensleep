package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import com.urbandroid.sleep.alarmclock.Alarm;
import com.urbandroid.sleep.alarmclock.AlarmKlaxon;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Processor$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ Processor$$ExternalSyntheticLambda2(Object obj, Object obj2, boolean z, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
        this.f$1 = obj2;
        this.f$2 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        boolean z = this.f$2;
        Object obj = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((Processor) obj2).lambda$runOnExecuted$2((WorkGenerationalId) obj, z);
                break;
            default:
                ((AlarmKlaxon) obj2).lambda$startKlaxon$0((Alarm) obj, z);
                break;
        }
    }
}
