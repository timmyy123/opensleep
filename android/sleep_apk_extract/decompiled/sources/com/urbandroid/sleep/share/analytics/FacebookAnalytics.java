package com.urbandroid.sleep.share.analytics;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.Bundle;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.urbandroid.common.logging.Logger;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/share/analytics/FacebookAnalytics;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class FacebookAnalytics {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: loaded from: classes.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/sleep/share/analytics/FacebookAnalytics$Companion;", "", "<init>", "()V", "logPurchase", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "productId", "", "orderId", "currency", "amount", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void logPurchase(Context context, String productId, String orderId, String currency, double amount) {
            context.getClass();
            productId.getClass();
            orderId.getClass();
            currency.getClass();
            StringBuilder sb = new StringBuilder("Facebook: subscribe ");
            FileInsert$$ExternalSyntheticOutline0.m(sb, productId, " ", orderId, " ");
            sb.append(currency);
            sb.append(" ");
            sb.append(amount);
            Logger.logInfo(sb.toString());
            AppEventsLogger appEventsLoggerNewLogger = AppEventsLogger.INSTANCE.newLogger(context);
            Bundle bundleM = zzba$$ExternalSyntheticOutline0.m(AppEventsConstants.EVENT_PARAM_ORDER_ID, orderId);
            String upperCase = currency.toUpperCase(Locale.ROOT);
            upperCase.getClass();
            bundleM.putString(AppEventsConstants.EVENT_PARAM_CURRENCY, upperCase);
            bundleM.putString(AppEventsConstants.EVENT_PARAM_CONTENT_TYPE, "product");
            bundleM.putString(AppEventsConstants.EVENT_PARAM_CONTENT_ID, productId);
            bundleM.putString(AppEventsConstants.EVENT_PARAM_CONTENT, "[{\"id\": \"" + productId + "\", \"quantity\": 1}");
            appEventsLoggerNewLogger.logEvent(AppEventsConstants.EVENT_NAME_SUBSCRIBE, amount, bundleM);
            appEventsLoggerNewLogger.logEvent(AppEventsConstants.EVENT_NAME_PURCHASED, amount, bundleM);
        }

        private Companion() {
        }
    }
}
