package com.urbandroid.sleep.fragment.addon;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.core.text.HtmlCompat;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.domain.addon.AddonApp;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.eclipse.paho.client.mqttv3.internal.ClientDefaults;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JF\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/fragment/addon/AddOnBinder;", "", "<init>", "()V", "bind", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "app", "Lcom/urbandroid/sleep/domain/addon/AddonApp;", "image", "Landroid/widget/ImageView;", "title", "Landroid/widget/TextView;", "desc", "button", "Landroid/widget/Button;", "iconSize", "", "padding", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AddOnBinder {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void bind$lambda$1(AddonApp addonApp, Context context, View view) {
        String link = addonApp.getLink();
        if (Intrinsics.areEqual(link, "market://details?id=health.myage")) {
            link = "https://play.google.com/store/apps/details?id=health.myage&referrer=utm_source%3Dsleepasandroid%26utm_medium%3Daddons";
        }
        if (link == null || !(StringsKt.startsWith$default(link, "market://details?id=") || StringsKt.startsWith$default(link, "amzn://apps/android?p="))) {
            if (link != null && StringsKt.startsWith$default(link, "intent://")) {
                view.getContext().startActivity(Intent.parseUri(link, 1));
                return;
            }
            if (Intrinsics.areEqual(link, context.getString(R.string.addons_sms_link))) {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSmsLink();
            }
            Logger.logInfo("Add-on clicked: url " + link);
            ViewIntent.url(context, link);
            return;
        }
        String strPackageFromMarketUrl = ViewIntent.packageFromMarketUrl(link);
        Logger.logInfo("Add-on clicked: " + strPackageFromMarketUrl + " url " + link);
        PackageManager packageManager = context.getPackageManager();
        if (context.getPackageManager().checkSignatures(context.getPackageName(), strPackageFromMarketUrl) != 0) {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventAddonClicked(strPackageFromMarketUrl);
        }
        try {
            try {
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(strPackageFromMarketUrl);
                if (launchIntentForPackage == null) {
                    view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(link)));
                } else {
                    launchIntentForPackage.addFlags(ClientDefaults.MAX_MSG_SIZE);
                    context.startActivity(launchIntentForPackage);
                }
            } catch (Exception unused) {
                Toast.makeText(view.getContext(), "Cannot open ".concat(link), 0).show();
            }
        } catch (Exception unused2) {
            view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(link)));
        }
    }

    public final void bind(Context context, AddonApp app, ImageView image, TextView title, TextView desc, Button button, int iconSize, int padding) {
        context.getClass();
        app.getClass();
        image.getClass();
        title.getClass();
        desc.getClass();
        button.getClass();
        String desc2 = app.getDesc();
        if (desc2 == null) {
            desc2 = "";
        }
        desc.setText(HtmlCompat.fromHtml(desc2, 63));
        try {
            image.setImageResource(app.getIcon());
        } catch (Exception e) {
            Logger.logSevere(e);
        }
        image.setPadding(0, 0, 0, 0);
        if (app.getLink() == null) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
            if (StringsKt.startsWith$default(app.getLink(), "http")) {
                button.setText(R.string.addons_install);
            } else {
                button.setText(app.getIsInstalled() ? R.string.addons_run : R.string.install_button);
            }
        }
        if (app.getLink() != null && Intrinsics.areEqual(app.getLink(), context.getString(R.string.addons_sms_link))) {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventSmsLink();
            button.setText(R.string.sleepmasters_act_now);
        }
        if (app.getLink() != null && Intrinsics.areEqual(app.getLink(), context.getString(R.string.featured_fitify_link))) {
            button.setText(R.string.install_button);
        }
        button.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(app, context, 12));
        title.setText(app.getTitle());
    }
}
