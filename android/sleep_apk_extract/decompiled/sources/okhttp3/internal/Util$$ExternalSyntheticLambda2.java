package okhttp3.internal;

import androidx.view.result.ActivityResult;
import androidx.view.result.ActivityResultCallback;
import com.google.android.gms.tasks.OnSuccessListener;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda3;
import com.urbandroid.sleep.service.google.healthconnect.HealthConnectSyncActivity;
import com.urbandroid.sleep.service.matter.MatterActivity;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.util.Set;
import okhttp3.EventListener;
import okhttp3.sse.EventSource;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Util$$ExternalSyntheticLambda2 implements OnSuccessListener, ActivityResultCallback, EventListener.Factory, EventSource.Factory {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Util$$ExternalSyntheticLambda2(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // androidx.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 5:
                HealthConnectSyncActivity.requestPermissions$lambda$0((HealthConnectSyncActivity) obj2, (Set) obj);
                break;
            default:
                MatterActivity.commissioningLauncher$lambda$0((MatterActivity) obj2, (ActivityResult) obj);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        int i = this.$r8$classId;
        Object obj2 = this.f$0;
        switch (i) {
            case 1:
                ((Endpoint$$ExternalSyntheticLambda3) obj2).invoke(obj);
                break;
            case 2:
                ((Endpoint$$ExternalSyntheticLambda3) obj2).invoke(obj);
                break;
            case 3:
                ((Endpoint$$ExternalSyntheticLambda3) obj2).invoke(obj);
                break;
            case 4:
                ((CodecsKt$$ExternalSyntheticLambda2) obj2).invoke(obj);
                break;
            default:
                ((CodecsKt$$ExternalSyntheticLambda2) obj2).invoke(obj);
                break;
        }
    }
}
