package androidx.health.connect.client;

import androidx.health.connect.client.contracts.HealthPermissionsRequestContract;
import androidx.view.result.contract.ActivityResultContract;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H¦@¢\u0006\u0002\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0003"}, d2 = {"Landroidx/health/connect/client/PermissionController;", "", "getGrantedPermissions", "", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "revokeAllPermissions", "", "Companion", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface PermissionController {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\t"}, d2 = {"Landroidx/health/connect/client/PermissionController$Companion;", "", "<init>", "()V", "createRequestPermissionResultContract", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "providerPackageName", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public static /* synthetic */ ActivityResultContract createRequestPermissionResultContract$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = "com.google.android.apps.healthdata";
            }
            return companion.createRequestPermissionResultContract(str);
        }

        public final ActivityResultContract<Set<String>, Set<String>> createRequestPermissionResultContract(String providerPackageName) {
            providerPackageName.getClass();
            return new HealthPermissionsRequestContract(providerPackageName);
        }
    }

    Object getGrantedPermissions(Continuation<? super Set<String>> continuation);

    Object revokeAllPermissions(Continuation<? super Unit> continuation);
}
