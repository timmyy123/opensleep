package androidx.appfunctions;

import android.os.Bundle;
import androidx.core.os.BuildCompat$$ExternalSyntheticBackportWithForwarding1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u001b2\u00060\u0001j\u0002`\u0002:\u0003\u0019\u001a\u001bB#\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u0004X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\f¨\u0006\u001c"}, d2 = {"Landroidx/appfunctions/AppFunctionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "internalErrorCode", "", "errorMessage", "", "extras", "Landroid/os/Bundle;", "<init>", "(ILjava/lang/String;Landroid/os/Bundle;)V", "getInternalErrorCode$appfunctions", "()I", "getErrorMessage", "()Ljava/lang/String;", "getExtras$appfunctions", "()Landroid/os/Bundle;", "toPlatformExtensionsClass", "Lcom/android/extensions/appfunctions/AppFunctionException;", "toPlatformClass", "Landroid/app/appfunctions/AppFunctionException;", "errorCategory", "getErrorCategory$appfunctions$annotations", "()V", "getErrorCategory$appfunctions", "ErrorCategory", "ErrorCode", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AppFunctionException extends Exception {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int ERROR_APP_UNKNOWN_ERROR = 3000;
    public static final int ERROR_CANCELLED = 2001;
    public static final int ERROR_CATEGORY_APP = 3;
    public static final int ERROR_CATEGORY_REQUEST_ERROR = 1;
    public static final int ERROR_CATEGORY_SYSTEM = 2;
    public static final int ERROR_CATEGORY_UNKNOWN = 0;
    public static final int ERROR_DENIED = 1000;
    public static final int ERROR_DISABLED = 1002;
    public static final int ERROR_FUNCTION_NOT_FOUND = 1003;
    public static final int ERROR_INVALID_ARGUMENT = 1001;
    public static final int ERROR_LIMIT_EXCEEDED = 1501;
    public static final int ERROR_NOT_SUPPORTED = 3501;
    public static final int ERROR_PERMISSION_REQUIRED = 3500;
    public static final int ERROR_RESOURCE_ALREADY_EXISTS = 1502;
    public static final int ERROR_RESOURCE_NOT_FOUND = 1500;
    public static final int ERROR_SYSTEM_ERROR = 2000;
    private final int errorCategory;
    private final String errorMessage;
    private final Bundle extras;
    private final int internalErrorCode;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/appfunctions/AppFunctionException$Companion;", "", "<init>", "()V", "fromPlatformExtensionsClass", "Landroidx/appfunctions/AppFunctionException;", "exception", "Lcom/android/extensions/appfunctions/AppFunctionException;", "fromPlatformClass", "Landroid/app/appfunctions/AppFunctionException;", "ERROR_CATEGORY_UNKNOWN", "", "ERROR_CATEGORY_REQUEST_ERROR", "ERROR_CATEGORY_SYSTEM", "ERROR_CATEGORY_APP", "ERROR_DENIED", "ERROR_INVALID_ARGUMENT", "ERROR_DISABLED", "ERROR_FUNCTION_NOT_FOUND", "ERROR_RESOURCE_NOT_FOUND", "ERROR_LIMIT_EXCEEDED", "ERROR_RESOURCE_ALREADY_EXISTS", "ERROR_SYSTEM_ERROR", "ERROR_CANCELLED", "ERROR_APP_UNKNOWN_ERROR", "ERROR_PERMISSION_REQUIRED", "ERROR_NOT_SUPPORTED", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppFunctionException fromPlatformClass(android.app.appfunctions.AppFunctionException exception) {
            exception.getClass();
            int errorCode = exception.getErrorCode();
            if (errorCode == 2000) {
                String errorMessage = exception.getErrorMessage();
                Bundle extras = exception.getExtras();
                extras.getClass();
                return new AppFunctionSystemUnknownException(errorMessage, extras);
            }
            if (errorCode == 2001) {
                String errorMessage2 = exception.getErrorMessage();
                Bundle extras2 = exception.getExtras();
                extras2.getClass();
                return new AppFunctionCancelledException(errorMessage2, extras2);
            }
            if (errorCode == 3000) {
                String errorMessage3 = exception.getErrorMessage();
                Bundle extras3 = exception.getExtras();
                extras3.getClass();
                return new AppFunctionAppUnknownException(errorMessage3, extras3);
            }
            if (errorCode == 3500) {
                String errorMessage4 = exception.getErrorMessage();
                Bundle extras4 = exception.getExtras();
                extras4.getClass();
                return new AppFunctionPermissionRequiredException(errorMessage4, extras4);
            }
            if (errorCode == 3501) {
                String errorMessage5 = exception.getErrorMessage();
                Bundle extras5 = exception.getExtras();
                extras5.getClass();
                return new AppFunctionNotSupportedException(errorMessage5, extras5);
            }
            switch (errorCode) {
                case 1000:
                    String errorMessage6 = exception.getErrorMessage();
                    Bundle extras6 = exception.getExtras();
                    extras6.getClass();
                    return new AppFunctionDeniedException(errorMessage6, extras6);
                case 1001:
                    String errorMessage7 = exception.getErrorMessage();
                    Bundle extras7 = exception.getExtras();
                    extras7.getClass();
                    return new AppFunctionInvalidArgumentException(errorMessage7, extras7);
                case 1002:
                    String errorMessage8 = exception.getErrorMessage();
                    Bundle extras8 = exception.getExtras();
                    extras8.getClass();
                    return new AppFunctionDisabledException(errorMessage8, extras8);
                case AppFunctionException.ERROR_FUNCTION_NOT_FOUND /* 1003 */:
                    String errorMessage9 = exception.getErrorMessage();
                    Bundle extras9 = exception.getExtras();
                    extras9.getClass();
                    return new AppFunctionFunctionNotFoundException(errorMessage9, extras9);
                default:
                    switch (errorCode) {
                        case AppFunctionException.ERROR_RESOURCE_NOT_FOUND /* 1500 */:
                            String errorMessage10 = exception.getErrorMessage();
                            Bundle extras10 = exception.getExtras();
                            extras10.getClass();
                            return new AppFunctionElementNotFoundException(errorMessage10, extras10);
                        case AppFunctionException.ERROR_LIMIT_EXCEEDED /* 1501 */:
                            String errorMessage11 = exception.getErrorMessage();
                            Bundle extras11 = exception.getExtras();
                            extras11.getClass();
                            return new AppFunctionLimitExceededException(errorMessage11, extras11);
                        case AppFunctionException.ERROR_RESOURCE_ALREADY_EXISTS /* 1502 */:
                            String errorMessage12 = exception.getErrorMessage();
                            Bundle extras12 = exception.getExtras();
                            extras12.getClass();
                            return new AppFunctionElementAlreadyExistsException(errorMessage12, extras12);
                        default:
                            int errorCode2 = exception.getErrorCode();
                            String errorMessage13 = exception.getErrorMessage();
                            Bundle extras13 = exception.getExtras();
                            extras13.getClass();
                            return new AppFunctionUnknownException(errorCode2, errorMessage13, extras13);
                    }
            }
        }

        public final AppFunctionException fromPlatformExtensionsClass(com.android.extensions.appfunctions.AppFunctionException exception) {
            exception.getClass();
            int errorCode = exception.getErrorCode();
            if (errorCode == 2000) {
                String errorMessage = exception.getErrorMessage();
                Bundle extras = exception.getExtras();
                extras.getClass();
                return new AppFunctionSystemUnknownException(errorMessage, extras);
            }
            if (errorCode == 2001) {
                String errorMessage2 = exception.getErrorMessage();
                Bundle extras2 = exception.getExtras();
                extras2.getClass();
                return new AppFunctionCancelledException(errorMessage2, extras2);
            }
            if (errorCode == 3000) {
                String errorMessage3 = exception.getErrorMessage();
                Bundle extras3 = exception.getExtras();
                extras3.getClass();
                return new AppFunctionAppUnknownException(errorMessage3, extras3);
            }
            if (errorCode == 3500) {
                String errorMessage4 = exception.getErrorMessage();
                Bundle extras4 = exception.getExtras();
                extras4.getClass();
                return new AppFunctionPermissionRequiredException(errorMessage4, extras4);
            }
            if (errorCode == 3501) {
                String errorMessage5 = exception.getErrorMessage();
                Bundle extras5 = exception.getExtras();
                extras5.getClass();
                return new AppFunctionNotSupportedException(errorMessage5, extras5);
            }
            switch (errorCode) {
                case 1000:
                    String errorMessage6 = exception.getErrorMessage();
                    Bundle extras6 = exception.getExtras();
                    extras6.getClass();
                    return new AppFunctionDeniedException(errorMessage6, extras6);
                case 1001:
                    String errorMessage7 = exception.getErrorMessage();
                    Bundle extras7 = exception.getExtras();
                    extras7.getClass();
                    return new AppFunctionInvalidArgumentException(errorMessage7, extras7);
                case 1002:
                    String errorMessage8 = exception.getErrorMessage();
                    Bundle extras8 = exception.getExtras();
                    extras8.getClass();
                    return new AppFunctionDisabledException(errorMessage8, extras8);
                case AppFunctionException.ERROR_FUNCTION_NOT_FOUND /* 1003 */:
                    String errorMessage9 = exception.getErrorMessage();
                    Bundle extras9 = exception.getExtras();
                    extras9.getClass();
                    return new AppFunctionFunctionNotFoundException(errorMessage9, extras9);
                default:
                    switch (errorCode) {
                        case AppFunctionException.ERROR_RESOURCE_NOT_FOUND /* 1500 */:
                            String errorMessage10 = exception.getErrorMessage();
                            Bundle extras10 = exception.getExtras();
                            extras10.getClass();
                            return new AppFunctionElementNotFoundException(errorMessage10, extras10);
                        case AppFunctionException.ERROR_LIMIT_EXCEEDED /* 1501 */:
                            String errorMessage11 = exception.getErrorMessage();
                            Bundle extras11 = exception.getExtras();
                            extras11.getClass();
                            return new AppFunctionLimitExceededException(errorMessage11, extras11);
                        case AppFunctionException.ERROR_RESOURCE_ALREADY_EXISTS /* 1502 */:
                            String errorMessage12 = exception.getErrorMessage();
                            Bundle extras12 = exception.getExtras();
                            extras12.getClass();
                            return new AppFunctionElementAlreadyExistsException(errorMessage12, extras12);
                        default:
                            int errorCode2 = exception.getErrorCode();
                            String errorMessage13 = exception.getErrorMessage();
                            Bundle extras13 = exception.getExtras();
                            extras13.getClass();
                            return new AppFunctionUnknownException(errorCode2, errorMessage13, extras13);
                    }
            }
        }

        private Companion() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/appfunctions/AppFunctionException$ErrorCategory;", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ErrorCategory {
    }

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/appfunctions/AppFunctionException$ErrorCode;", "", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public @interface ErrorCode {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFunctionException(int i, String str, Bundle bundle) {
        super(str);
        bundle.getClass();
        this.internalErrorCode = i;
        this.errorMessage = str;
        this.extras = bundle;
        this.errorCategory = (1000 > i || i >= 2000) ? (2000 > i || i >= 3000) ? (3000 > i || i >= 4000) ? 0 : 3 : 2 : 1;
    }

    public static /* synthetic */ void getErrorCategory$appfunctions$annotations() {
    }

    /* JADX INFO: renamed from: getErrorCategory$appfunctions, reason: from getter */
    public final int getErrorCategory() {
        return this.errorCategory;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    /* JADX INFO: renamed from: getExtras$appfunctions, reason: from getter */
    public final Bundle getExtras() {
        return this.extras;
    }

    /* JADX INFO: renamed from: getInternalErrorCode$appfunctions, reason: from getter */
    public final int getInternalErrorCode() {
        return this.internalErrorCode;
    }

    public final android.app.appfunctions.AppFunctionException toPlatformClass() {
        BuildCompat$$ExternalSyntheticBackportWithForwarding1.m57m();
        return BuildCompat$$ExternalSyntheticBackportWithForwarding1.m(this.internalErrorCode, this.errorMessage, this.extras);
    }

    public final com.android.extensions.appfunctions.AppFunctionException toPlatformExtensionsClass() {
        return new com.android.extensions.appfunctions.AppFunctionException(this.internalErrorCode, this.errorMessage, this.extras);
    }
}
