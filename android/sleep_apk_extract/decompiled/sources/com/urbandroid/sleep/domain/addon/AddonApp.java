package com.urbandroid.sleep.domain.addon;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.res.Resources;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.getpebble.android.kit.Constants;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ResourceUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u000bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0012\u0010\u000bR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/urbandroid/sleep/domain/addon/AddonApp;", "Lcom/urbandroid/sleep/domain/addon/AddonItem;", "", Constants.CUST_ICON, "", "title", "desc", "link", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", InAppPurchaseConstants.METHOD_TO_STRING, "I", "getIcon", "()I", "Ljava/lang/String;", "getDesc", "getLink", "", "isInstalled", "Z", "()Z", "setInstalled", "(Z)V", "isResourceIcon", "setResourceIcon", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class AddonApp implements AddonItem {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String desc;
    private final int icon;
    private boolean isInstalled;
    private boolean isResourceIcon;
    private final String link;
    private final String title;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010J*\u0010\u0011\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002¨\u0006\u0016"}, d2 = {"Lcom/urbandroid/sleep/domain/addon/AddonApp$Companion;", "", "<init>", "()V", "random", "Lcom/urbandroid/sleep/domain/addon/AddonApp;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "from", "", "Lcom/urbandroid/sleep/domain/addon/AddonItem;", "keys", "", "", "filterInstalled", "", "(Landroid/content/Context;[Ljava/lang/String;Z)Ljava/util/List;", "getString", "res", "Landroid/content/res/Resources;", "addonKey", "suffix", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ List from$default(Companion companion, Context context, String[] strArr, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.from(context, strArr, z);
        }

        private final String getString(Context context, Resources res, String addonKey, String suffix) {
            int identifier = res.getIdentifier(FileInsert$$ExternalSyntheticOutline0.m$1(addonKey, "_", suffix), "string", context.getPackageName());
            if (identifier > 0) {
                return res.getString(identifier);
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:18:0x00c5  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00fc  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x0103  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0121  */
        /* JADX WARN: Removed duplicated region for block: B:40:0x0126  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x014b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<AddonItem> from(Context context, String[] keys, boolean filterInstalled) {
            boolean z;
            int resourceByName;
            AddonApp addonApp;
            context.getClass();
            keys.getClass();
            ArrayList arrayList = new ArrayList();
            for (String str : keys) {
                Resources resources = context.getResources();
                resources.getClass();
                String string = getString(context, resources, str, "title");
                String string2 = getString(context, resources, str, "desc");
                String string3 = getString(context, resources, str, "package");
                String string4 = getString(context, resources, str, "link");
                String string5 = getString(context, resources, str, "res");
                if (!Intrinsics.areEqual("addons_hue", str)) {
                    Integer numValueOf = string3 == null ? Integer.valueOf(context.getPackageManager().checkSignatures(context.getPackageName(), string3)) : null;
                    boolean z2 = true;
                    z = numValueOf != null && numValueOf.intValue() == 0;
                    Logger.logInfo("Addon: " + str + " " + z);
                    if (string4 == null && string3 != null) {
                        if (TrialFilter.getInstance().getVersion() != TrialFilter.Version.TRIAL) {
                            string4 = "market://details?id=".concat(string3);
                        } else if (TrialFilter.getInstance().getVersion() == TrialFilter.Version.AMAZON && StringsKt.startsWith$default(str, "addons")) {
                            string4 = "amzn://apps/android?p=".concat(string3);
                        }
                    }
                    if (string5 == null) {
                        resourceByName = ResourceUtil.getResourceByName(R.drawable.class, string5);
                    } else {
                        resourceByName = ResourceUtil.getResourceByName(R.drawable.class, str + "_icon");
                        z2 = false;
                    }
                    addonApp = new AddonApp(resourceByName, string, string2, string4);
                    addonApp.setResourceIcon(z2);
                    addonApp.setInstalled(z);
                    if (z || !filterInstalled) {
                        arrayList.add(addonApp);
                    }
                } else if (SharedApplicationContext.getSettings().isPhilipsOffer()) {
                    string2 = TrialFilter.getInstance().isTrial() ? FileInsert$$ExternalSyntheticOutline0.m(context.getResources().getString(R.string.purchase_hue_advocate), ".\n\n", context.getResources().getString(R.string.philips_hue_offer), ".") : FileInsert$$ExternalSyntheticOutline0.m(context.getResources().getString(R.string.purchase_hue_advocate), ".\n\n", context.getResources().getString(R.string.philips_hue_offer_unlocked), ".");
                    string4 = TrialFilter.getInstance().isTrial() ? context.getResources().getString(R.string.philips_hue_offer_link) : context.getResources().getString(R.string.philips_hue_offer_link_unlocked);
                    if (string3 == null) {
                    }
                    boolean z22 = true;
                    if (numValueOf != null) {
                        Logger.logInfo("Addon: " + str + " " + z);
                        if (string4 == null) {
                            if (TrialFilter.getInstance().getVersion() != TrialFilter.Version.TRIAL) {
                            }
                        }
                        if (string5 == null) {
                        }
                        addonApp = new AddonApp(resourceByName, string, string2, string4);
                        addonApp.setResourceIcon(z22);
                        addonApp.setInstalled(z);
                        if (z) {
                            arrayList.add(addonApp);
                        }
                    }
                }
            }
            return CollectionsKt.toList(arrayList);
        }

        public final AddonApp random(Context context) {
            context.getClass();
            String[] stringArray = context.getResources().getStringArray(R.array.addons_entries);
            stringArray.getClass();
            return (AddonApp) CollectionsKt.firstOrNull(CollectionsKt.shuffled(from$default(this, context, stringArray, false, 4, null)));
        }

        private Companion() {
        }

        public final List<AddonItem> from(Context context, String[] strArr) {
            context.getClass();
            strArr.getClass();
            return from$default(this, context, strArr, false, 4, null);
        }
    }

    public AddonApp(int i, String str, String str2, String str3) {
        this.icon = i;
        this.title = str;
        this.desc = str2;
        this.link = str3;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final String getLink() {
        return this.link;
    }

    @Override // com.urbandroid.sleep.domain.addon.AddonItem
    public String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: isInstalled, reason: from getter */
    public final boolean getIsInstalled() {
        return this.isInstalled;
    }

    public final void setInstalled(boolean z) {
        this.isInstalled = z;
    }

    public final void setResourceIcon(boolean z) {
        this.isResourceIcon = z;
    }

    public String toString() {
        return FileInsert$$ExternalSyntheticOutline0.m$1(this.title, " ", this.link);
    }
}
