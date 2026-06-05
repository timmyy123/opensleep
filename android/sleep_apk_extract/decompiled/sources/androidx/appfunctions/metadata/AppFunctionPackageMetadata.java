package androidx.appfunctions.metadata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.appfunctions.internal.Constants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 !2\u00020\u0001:\u0001!B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u000bJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionPackageMetadata;", "", "packageName", "", "appFunctions", "", "Landroidx/appfunctions/metadata/AppFunctionMetadata;", "components", "Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "<init>", "(Ljava/lang/String;Ljava/util/List;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "(Ljava/lang/String;Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;)V", "getPackageName", "()Ljava/lang/String;", "getAppFunctions", "()Ljava/util/List;", "getComponents$appfunctions", "()Landroidx/appfunctions/metadata/AppFunctionComponentsMetadata;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "resolveAppFunctionAppMetadata", "Landroidx/appfunctions/metadata/AppFunctionAppMetadata;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "getXmlAttributeValue", "xmlParser", "Landroid/content/res/XmlResourceParser;", "attributeName", "getXmlAttributeResourceValue", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionPackageMetadata {
    private static final String APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE = "http://schemas.android.com/apk/androidx.appfunctions";
    private static final String APP_METADATA_ATTRIBUTE_NAMESPACE = "http://schemas.android.com/apk/res-auto";
    private static final String APP_METADATA_XML_PROPERTY = "android.app.appfunctions.app_metadata";
    private static final Companion Companion = new Companion(null);
    private static final String DESCRIPTION_ATTRIBUTE_NAME = "description";
    private static final String DISPLAY_DESCRIPTION_ATTRIBUTE_NAME = "displayDescription";
    private final List<AppFunctionMetadata> appFunctions;
    private final AppFunctionComponentsMetadata components;
    private final String packageName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/metadata/AppFunctionPackageMetadata$Companion;", "", "<init>", "()V", "APP_METADATA_XML_PROPERTY", "", "APP_METADATA_ATTRIBUTE_NAMESPACE", "APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE", "DISPLAY_DESCRIPTION_ATTRIBUTE_NAME", "DESCRIPTION_ATTRIBUTE_NAME", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AppFunctionPackageMetadata(String str, List<AppFunctionMetadata> list, AppFunctionComponentsMetadata appFunctionComponentsMetadata) {
        str.getClass();
        list.getClass();
        appFunctionComponentsMetadata.getClass();
        this.packageName = str;
        this.appFunctions = list;
        this.components = appFunctionComponentsMetadata;
    }

    private final int getXmlAttributeResourceValue(XmlResourceParser xmlParser, String attributeName) {
        int attributeResourceValue = xmlParser.getAttributeResourceValue(APP_METADATA_ATTRIBUTE_NAMESPACE, attributeName, 0);
        return attributeResourceValue == 0 ? xmlParser.getAttributeResourceValue(APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE, attributeName, 0) : attributeResourceValue;
    }

    private final String getXmlAttributeValue(XmlResourceParser xmlParser, String attributeName) {
        String attributeValue = xmlParser.getAttributeValue(APP_METADATA_ATTRIBUTE_NAMESPACE, attributeName);
        return attributeValue == null ? xmlParser.getAttributeValue(APP_METADATA_APPFUNCTIONS_LIBRARY_ATTRIBUTE_NAMESPACE, attributeName) : attributeValue;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(AppFunctionPackageMetadata.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        AppFunctionPackageMetadata appFunctionPackageMetadata = (AppFunctionPackageMetadata) other;
        return Intrinsics.areEqual(this.packageName, appFunctionPackageMetadata.packageName) && Intrinsics.areEqual(this.appFunctions, appFunctionPackageMetadata.appFunctions) && Intrinsics.areEqual(this.components, appFunctionPackageMetadata.components);
    }

    public final List<AppFunctionMetadata> getAppFunctions() {
        return this.appFunctions;
    }

    /* JADX INFO: renamed from: getComponents$appfunctions, reason: from getter */
    public final AppFunctionComponentsMetadata getComponents() {
        return this.components;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.components.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((List) this.appFunctions, this.packageName.hashCode() * 31, 31);
    }

    public final AppFunctionAppMetadata resolveAppFunctionAppMetadata(Context context) {
        context.getClass();
        PackageManager packageManager = context.getPackageManager();
        try {
            int resourceId = packageManager.getProperty(APP_METADATA_XML_PROPERTY, this.packageName).getResourceId();
            if (resourceId == 0) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.packageName, 0);
            applicationInfo.getClass();
            Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo, context.getResources().getConfiguration());
            resourcesForApplication.getClass();
            XmlResourceParser xml = resourcesForApplication.getXml(resourceId);
            xml.getClass();
            while (xml.getEventType() != 2) {
                xml.next();
                if (xml.getEventType() == 1) {
                    return null;
                }
            }
            String xmlAttributeValue = getXmlAttributeValue(xml, "description");
            int xmlAttributeResourceValue = getXmlAttributeResourceValue(xml, DISPLAY_DESCRIPTION_ATTRIBUTE_NAME);
            String string = xmlAttributeResourceValue != 0 ? resourcesForApplication.getString(xmlAttributeResourceValue) : getXmlAttributeValue(xml, DISPLAY_DESCRIPTION_ATTRIBUTE_NAME);
            if (xmlAttributeValue == null) {
                xmlAttributeValue = "";
            }
            if (string == null) {
                string = "";
            }
            return new AppFunctionAppMetadata(xmlAttributeValue, string);
        } catch (Exception e) {
            if (Log.isLoggable(Constants.APP_FUNCTIONS_TAG, 3)) {
                Log.d(Constants.APP_FUNCTIONS_TAG, "Encountered an error while resolving app metadata for package: " + this.packageName + '.', e);
            }
            return null;
        }
    }

    public String toString() {
        return "AppFunctionPackageMetadata(packageName='" + this.packageName + "', appFunctions=" + this.appFunctions + ", components=" + this.components + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionPackageMetadata(String str, List<AppFunctionMetadata> list) {
        this(str, list, null, 4, null);
        str.getClass();
        list.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ AppFunctionPackageMetadata(String str, List list, AppFunctionComponentsMetadata appFunctionComponentsMetadata, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 4) != 0) {
            appFunctionComponentsMetadata = new AppFunctionComponentsMetadata(null, 1, 0 == true ? 1 : 0);
        }
        this(str, list, appFunctionComponentsMetadata);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppFunctionPackageMetadata(String str, AppFunctionComponentsMetadata appFunctionComponentsMetadata) {
        this(str, CollectionsKt.emptyList(), appFunctionComponentsMetadata);
        str.getClass();
        appFunctionComponentsMetadata.getClass();
    }
}
