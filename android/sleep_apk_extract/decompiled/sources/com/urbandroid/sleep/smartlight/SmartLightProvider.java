package com.urbandroid.sleep.smartlight;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.google.home.GoogleHomeSmartLight;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaser;
import com.urbandroid.sleep.smartwatch.phaser.SleepPhaserProvider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/smartlight/SmartLightProvider;", "", "<init>", "()V", "getSmartLight", "Lcom/urbandroid/sleep/smartlight/SmartLight;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SmartLightProvider {
    public static final SmartLightProvider INSTANCE = new SmartLightProvider();

    private SmartLightProvider() {
    }

    public static final SmartLight getSmartLight(Context context) {
        context.getClass();
        Settings settings = new Settings(context);
        EnsembleSmartLight ensembleSmartLight = new EnsembleSmartLight();
        boolean zIsSmartlightEnabled = settings.isSmartlightEnabled();
        if ((settings.isSleepPhaserSmartLight() && settings.getSleepPhaserAddress() != null) || (settings.isSmartlightMaskEnabled() && settings.getSleepMaskBtAddress() != null)) {
            Logger.logInfo("Found phaser " + settings.getSleepPhaserAddress() + " mask " + settings.getSleepMaskBtAddress());
            SleepPhaser sleepPhaser = SleepPhaserProvider.getSleepPhaser(context);
            sleepPhaser.getClass();
            ensembleSmartLight.add(sleepPhaser);
            zIsSmartlightEnabled = true;
        }
        if (settings.isSmartlightMaskEnabled()) {
            Mask mask = new Mask(context.getApplicationContext());
            if (mask.isConnected()) {
                ensembleSmartLight.add(mask);
            }
        }
        UnifiedSmartLight unifiedSmartLight = new UnifiedSmartLight(context);
        if (unifiedSmartLight.isConnected()) {
            ensembleSmartLight.add(unifiedSmartLight);
        }
        GoogleHomeSmartLight googleHomeSmartLight = new GoogleHomeSmartLight(context);
        if (googleHomeSmartLight.isConnected()) {
            ensembleSmartLight.add(googleHomeSmartLight);
        }
        if (ensembleSmartLight.size() <= 0 || !zIsSmartlightEnabled) {
            return null;
        }
        return ensembleSmartLight;
    }
}
