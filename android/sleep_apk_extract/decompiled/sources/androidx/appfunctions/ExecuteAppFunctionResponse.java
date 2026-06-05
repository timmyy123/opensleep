package androidx.appfunctions;

import android.app.appsearch.GenericDocument;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.metadata.AppFunctionMetadata;
import androidx.core.os.BuildCompat$$ExternalSyntheticBackportWithForwarding1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.squareup.kotlinpoet.FunSpec$$ExternalSyntheticLambda1;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse;", "", "Success", "Error", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Error;", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ExecuteAppFunctionResponse {

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse$Error;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "error", "Landroidx/appfunctions/AppFunctionException;", "<init>", "(Landroidx/appfunctions/AppFunctionException;)V", "getError", "()Landroidx/appfunctions/AppFunctionException;", InAppPurchaseConstants.METHOD_TO_STRING, "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error implements ExecuteAppFunctionResponse {
        private final AppFunctionException error;

        public Error(AppFunctionException appFunctionException) {
            appFunctionException.getClass();
            this.error = appFunctionException;
        }

        public final AppFunctionException getError() {
            return this.error;
        }

        public String toString() {
            return "AppFunctionResponse.Error(error=" + this.error + ')';
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\nJ\b\u0010\u000b\u001a\u00020\fH\u0007J\u001d\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0001¢\u0006\u0002\b\u0013J\u0012\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "Landroidx/appfunctions/ExecuteAppFunctionResponse;", "returnValue", "Landroidx/appfunctions/AppFunctionData;", "<init>", "(Landroidx/appfunctions/AppFunctionData;)V", "getReturnValue", "()Landroidx/appfunctions/AppFunctionData;", "toPlatformExtensionClass", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "toPlatformExtensionClass$appfunctions", "toPlatformExecuteAppFunctionResponse", "Landroid/app/appfunctions/ExecuteAppFunctionResponse;", "grantUriAccess", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "callingPackageName", "", "grantUriAccess$appfunctions", "copy", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Success implements ExecuteAppFunctionResponse {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final String PROPERTY_RETURN_VALUE = "androidAppfunctionsReturnValue";
        private final AppFunctionData returnValue;

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0002\b\fJ\u0014\u0010\r\u001a\u00020\u0007*\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/ExecuteAppFunctionResponse$Success$Companion;", "", "<init>", "()V", "PROPERTY_RETURN_VALUE", "", "fromPlatformExtensionClass", "Landroidx/appfunctions/ExecuteAppFunctionResponse$Success;", "response", "Lcom/android/extensions/appfunctions/ExecuteAppFunctionResponse;", "functionMetadata", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "fromPlatformExtensionClass$appfunctions", "toCompatExecuteAppFunctionResponse", "Landroid/app/appfunctions/ExecuteAppFunctionResponse;", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Success fromPlatformExtensionClass$appfunctions(com.android.extensions.appfunctions.ExecuteAppFunctionResponse response, AppFunctionMetadata functionMetadata) {
                response.getClass();
                functionMetadata.getClass();
                GenericDocument resultDocument = response.getResultDocument();
                resultDocument.getClass();
                Bundle extras = response.getExtras();
                extras.getClass();
                return new Success(new AppFunctionData(resultDocument, extras).replaceSpecWith$appfunctions(functionMetadata.getResponse(), functionMetadata.getComponents()));
            }

            public final Success toCompatExecuteAppFunctionResponse(android.app.appfunctions.ExecuteAppFunctionResponse executeAppFunctionResponse, AppFunctionMetadata appFunctionMetadata) {
                executeAppFunctionResponse.getClass();
                appFunctionMetadata.getClass();
                GenericDocument resultDocument = executeAppFunctionResponse.getResultDocument();
                resultDocument.getClass();
                Bundle extras = executeAppFunctionResponse.getExtras();
                extras.getClass();
                return new Success(new AppFunctionData(resultDocument, extras).replaceSpecWith$appfunctions(appFunctionMetadata.getResponse(), appFunctionMetadata.getComponents()));
            }

            private Companion() {
            }
        }

        public Success(AppFunctionData appFunctionData) {
            appFunctionData.getClass();
            this.returnValue = appFunctionData;
        }

        public static /* synthetic */ Success copy$default(Success success, AppFunctionData appFunctionData, int i, Object obj) {
            if ((i & 1) != 0) {
                appFunctionData = success.returnValue;
            }
            return success.copy(appFunctionData);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit grantUriAccess$lambda$0(Context context, String str, AppFunctionUriGrant appFunctionUriGrant) {
            appFunctionUriGrant.getClass();
            context.grantUriPermission(str, appFunctionUriGrant.getUri(), appFunctionUriGrant.getModeFlags());
            return Unit.INSTANCE;
        }

        public static final Success toCompatExecuteAppFunctionResponse(android.app.appfunctions.ExecuteAppFunctionResponse executeAppFunctionResponse, AppFunctionMetadata appFunctionMetadata) {
            return INSTANCE.toCompatExecuteAppFunctionResponse(executeAppFunctionResponse, appFunctionMetadata);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit toPlatformExecuteAppFunctionResponse$lambda$0$0(List list, AppFunctionUriGrant appFunctionUriGrant) {
            appFunctionUriGrant.getClass();
            list.add(appFunctionUriGrant.toPlatformClass$appfunctions());
            return Unit.INSTANCE;
        }

        public final Success copy(AppFunctionData returnValue) {
            returnValue.getClass();
            return new Success(returnValue);
        }

        public final AppFunctionData getReturnValue() {
            return this.returnValue;
        }

        public final void grantUriAccess$appfunctions(Context context, String callingPackageName) {
            context.getClass();
            callingPackageName.getClass();
            this.returnValue.visitAppFunctionUriGrants(new FunSpec$$ExternalSyntheticLambda1(context, callingPackageName, 1));
        }

        public final android.app.appfunctions.ExecuteAppFunctionResponse toPlatformExecuteAppFunctionResponse() {
            if (Build.VERSION.SDK_INT < 37) {
                BuildCompat$$ExternalSyntheticBackportWithForwarding1.m$1();
                return BuildCompat$$ExternalSyntheticBackportWithForwarding1.m(this.returnValue.getGenericDocument(), this.returnValue.getExtras());
            }
            List listCreateListBuilder = CollectionsKt.createListBuilder();
            this.returnValue.visitAppFunctionUriGrants(new CodecsKt$$ExternalSyntheticLambda2(listCreateListBuilder, 1));
            List listBuild = CollectionsKt.build(listCreateListBuilder);
            BuildCompat$$ExternalSyntheticBackportWithForwarding1.m$1();
            return AppFunctionUriGrant$$ExternalSyntheticApiModelOutline0.m(this.returnValue.getGenericDocument(), this.returnValue.getExtras(), listBuild);
        }

        public final com.android.extensions.appfunctions.ExecuteAppFunctionResponse toPlatformExtensionClass$appfunctions() {
            return new com.android.extensions.appfunctions.ExecuteAppFunctionResponse(this.returnValue.getGenericDocument(), this.returnValue.getExtras());
        }
    }
}
