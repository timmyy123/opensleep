package com.urbandroid.sleep.service.google.fit.api;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.work.WorkerKt$$ExternalSyntheticLambda0;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.alarmclock.settings.ServicesSettingsActivity$$ExternalSyntheticLambda10;
import com.urbandroid.sleep.service.google.fit.GoogleFitConstantsKt;
import io.ktor.http.CodecsKt$$ExternalSyntheticLambda2;
import kotlin.Metadata;
import kotlin.Unit;
import okhttp3.internal.Util$$ExternalSyntheticLambda2;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApiFactory;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "create", "Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApi;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "account", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "disconnectAppFromFit", "", "listener", "Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApiFactory$DisconnectAppFromFitListener;", "DisconnectAppFromFitListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GoogleFitApiFactory implements FeatureLogger {
    private final String tag = "fit-api";

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/service/google/fit/api/GoogleFitApiFactory$DisconnectAppFromFitListener;", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface DisconnectAppFromFitListener {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit disconnectAppFromFit$lambda$0(DisconnectAppFromFitListener disconnectAppFromFitListener, Void r1) {
        ((ServicesSettingsActivity$$ExternalSyntheticLambda10) disconnectAppFromFitListener).disconnected(Status.RESULT_SUCCESS);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void disconnectAppFromFit$lambda$2(DisconnectAppFromFitListener disconnectAppFromFitListener, GoogleFitApiFactory googleFitApiFactory, Exception exc) {
        exc.getClass();
        ((ServicesSettingsActivity$$ExternalSyntheticLambda10) disconnectAppFromFitListener).disconnected(Status.RESULT_INTERNAL_ERROR);
        Logger.logWarning(Logger.defaultTag, googleFitApiFactory.getTag() + ": There was an error disabling Google Fit", exc);
    }

    public final GoogleFitApi create(Context context, GoogleSignInAccount account) {
        context.getClass();
        account.getClass();
        return new GoogleFitApi(context, account);
    }

    public final void disconnectAppFromFit(Context context, DisconnectAppFromFitListener listener) {
        context.getClass();
        listener.getClass();
        Fitness.getConfigClient(context, GoogleSignIn.getAccountForExtension(context, GoogleFitConstantsKt.fitnessOptions(true))).disableFit().addOnSuccessListener(new Util$$ExternalSyntheticLambda2(new CodecsKt$$ExternalSyntheticLambda2(listener, 15), 4)).addOnFailureListener(new WorkerKt$$ExternalSyntheticLambda0(listener, this, 19));
    }

    @Override // com.urbandroid.common.FeatureLogger
    public String getTag() {
        return this.tag;
    }
}
