package androidx.health.connect.client.permission;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.health.platform.client.impl.logger.Logger;
import androidx.health.platform.client.permission.Permission;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.service.HealthDataServiceConstants;
import androidx.view.result.contract.ActivityResultContract;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J,\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00112\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/health/connect/client/permission/HealthPermissionsRequestAppContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "providerPackageName", "<init>", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "input", "parseResult", "resultCode", "", SDKConstants.PARAM_INTENT, "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "connect-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HealthPermissionsRequestAppContract extends ActivityResultContract<Set<? extends String>, Set<? extends String>> {
    private final String providerPackageName;

    public HealthPermissionsRequestAppContract(String str) {
        str.getClass();
        this.providerPackageName = str;
    }

    /* JADX INFO: renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(Context context, Set<String> input) {
        context.getClass();
        input.getClass();
        ArrayList<? extends Parcelable> arrayList = (ArrayList) SequencesKt___SequencesKt.toCollection(SequencesKt.map(CollectionsKt.asSequence(input), new Function1<String, Permission>() { // from class: androidx.health.connect.client.permission.HealthPermissionsRequestAppContract$createIntent$protoPermissionList$1
            @Override // kotlin.jvm.functions.Function1
            public final Permission invoke(String str) {
                str.getClass();
                PermissionProto.Permission permissionBuild = PermissionProto.Permission.newBuilder().setPermission(str).build();
                permissionBuild.getClass();
                return new Permission(permissionBuild);
            }
        }), new ArrayList());
        Logger.debug("HealthConnectClient", "Requesting " + input.size() + " permissions.");
        Intent intent = new Intent(HealthDataServiceConstants.ACTION_REQUEST_PERMISSIONS);
        intent.putParcelableArrayListExtra(HealthDataServiceConstants.KEY_REQUESTED_PERMISSIONS_STRING, arrayList);
        if (this.providerPackageName.length() > 0) {
            intent.setPackage(this.providerPackageName);
        }
        return intent;
    }

    /* JADX INFO: renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public ActivityResultContract.SynchronousResult<Set<String>> getSynchronousResult2(Context context, Set<String> input) {
        context.getClass();
        input.getClass();
        return null;
    }

    @Override // androidx.view.result.contract.ActivityResultContract
    public Set<? extends String> parseResult(int resultCode, Intent intent) {
        Set<? extends String> setEmptySet;
        ArrayList parcelableArrayListExtra;
        Sequence sequenceAsSequence;
        Sequence map;
        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(HealthDataServiceConstants.KEY_GRANTED_PERMISSIONS_STRING)) == null || (sequenceAsSequence = CollectionsKt.asSequence(parcelableArrayListExtra)) == null || (map = SequencesKt.map(sequenceAsSequence, new Function1<Permission, String>() { // from class: androidx.health.connect.client.permission.HealthPermissionsRequestAppContract$parseResult$grantedPermissions$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Permission permission) {
                return permission.getProto().getPermission();
            }
        })) == null || (setEmptySet = SequencesKt.toSet(map)) == null) {
            setEmptySet = SetsKt.emptySet();
        }
        Logger.debug("HealthConnectClient", "Granted " + setEmptySet.size() + " permissions.");
        return setEmptySet;
    }

    @Override // androidx.view.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Set<? extends String>> getSynchronousResult(Context context, Set<? extends String> set) {
        return getSynchronousResult2(context, (Set<String>) set);
    }

    @Override // androidx.view.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Intent createIntent(Context context, Set<? extends String> set) {
        return createIntent2(context, (Set<String>) set);
    }
}
