package androidx.profileinstaller;

import android.content.IntentSender;
import androidx.profileinstaller.ProfileInstaller;
import androidx.view.ComponentActivity$activityResultRegistry$1;
import androidx.view.result.contract.ActivityResultContract;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ProfileInstaller$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ProfileInstaller$$ExternalSyntheticLambda0(int i, Object obj, Object obj2, int i2) {
        this.$r8$classId = i2;
        this.f$0 = obj;
        this.f$1 = i;
        this.f$2 = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$2;
        int i2 = this.f$1;
        Object obj2 = this.f$0;
        switch (i) {
            case 0:
                ((ProfileInstaller.DiagnosticsCallback) obj2).onResultReceived(i2, obj);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0((ComponentActivity$activityResultRegistry$1) obj2, i2, (ActivityResultContract.SynchronousResult) obj);
                break;
            case 2:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1((ComponentActivity$activityResultRegistry$1) obj2, i2, (IntentSender.SendIntentException) obj);
                break;
            default:
                ((DeviceProfileWriter) obj2).lambda$result$0(i2, obj);
                break;
        }
    }
}
