package com.urbandroid.smartlight.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.gson.Gson;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.smartlight.common.Common_smartlightKt;
import com.urbandroid.smartlight.hue.data.HueSharedPreferences;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.boxes.apple.TrackLoadSettingsAtom;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001d2\u00020\u0001:\u0005\u0019\u001a\u001b\u001c\u001dB%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0013\u001a\u00020\u0006J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011\u0082\u0001\u0004\u001e\u001f !¨\u0006\""}, d2 = {"Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "", "id", "", "ip", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getIp", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "isManualIp", "", "()Z", "needResolveIp", "ipExpirationInMs", "save", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "toAnonymized", "Hue", "YaHue", "Tradfri", "Dirigera", "Companion", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$YaHue;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class AuthenticatedGateway {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String tag = Common_smartlightKt.TAG;
    private final transient String id;
    private final transient String ip;
    private final transient Long timestamp;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\t*\u00020\u000bH\u0002¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000f\u001a\u00020\u000bH\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Companion;", "Lcom/urbandroid/common/FeatureLogger;", "<init>", "()V", "tag", "", "getTag", "()Ljava/lang/String;", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "(Landroid/content/Context;)Landroid/content/SharedPreferences;", "reset", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, TrackLoadSettingsAtom.TYPE, "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements FeatureLogger {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SharedPreferences prefs(Context context) {
            return context.getSharedPreferences(Common_smartlightKt.SHARED_PREFERENCES_STORE, 0);
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return AuthenticatedGateway.tag;
        }

        public final AuthenticatedGateway load(Context context) {
            AuthenticatedGateway authenticatedGateway;
            context.getClass();
            SharedPreferences sharedPreferencesPrefs = prefs(context);
            String string = sharedPreferencesPrefs.getString("smartlight-gateway-type", null);
            if (string == null) {
                HueSharedPreferences hueSharedPreferences = HueSharedPreferences.getInstance(context);
                String username = hueSharedPreferences.getUsername();
                if (username != null) {
                    String str = !StringsKt.isBlank(username) ? username : null;
                    if (str != null) {
                        String lastConnectedIPAddress = hueSharedPreferences.getLastConnectedIPAddress();
                        lastConnectedIPAddress.getClass();
                        String lastConnectedIPAddress2 = hueSharedPreferences.getLastConnectedIPAddress();
                        lastConnectedIPAddress2.getClass();
                        return new Hue(lastConnectedIPAddress, lastConnectedIPAddress2, null, str, 4, null);
                    }
                }
                return null;
            }
            String string2 = sharedPreferencesPrefs.getString("smartlight-gateway-value", null);
            if (string2 == null) {
                return null;
            }
            if (Intrinsics.areEqual(string, Hue.class.getSimpleName())) {
                authenticatedGateway = (AuthenticatedGateway) new Gson().fromJson(string2, Hue.class);
            } else if (Intrinsics.areEqual(string, Tradfri.class.getSimpleName())) {
                authenticatedGateway = (AuthenticatedGateway) new Gson().fromJson(string2, Tradfri.class);
            } else {
                if (!Intrinsics.areEqual(string, YaHue.class.getSimpleName())) {
                    Companion companion = AuthenticatedGateway.INSTANCE;
                    String strConcat = "Unsupported Authenticated Gateway type: ".concat(string);
                    Logger.logDebug(Logger.defaultTag, companion.getTag() + ": " + ((Object) strConcat), null);
                    return null;
                }
                authenticatedGateway = (AuthenticatedGateway) new Gson().fromJson(string2, YaHue.class);
            }
            Companion companion2 = AuthenticatedGateway.INSTANCE;
            String str2 = "load: " + authenticatedGateway.toAnonymized();
            Logger.logDebug(Logger.defaultTag, companion2.getTag() + ": " + ((Object) str2), null);
            return authenticatedGateway;
        }

        public final void reset(Context context) {
            context.getClass();
            SharedPreferences.Editor editorEdit = prefs(context).edit();
            editorEdit.remove("smartlight-gateway-type");
            editorEdit.remove("smartlight-gateway-value");
            editorEdit.apply();
            HueSharedPreferences.getInstance(context).reset();
        }

        private Companion() {
        }
    }

    public /* synthetic */ AuthenticatedGateway(String str, String str2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? Long.valueOf(System.currentTimeMillis()) : l, null);
    }

    public static final AuthenticatedGateway load(Context context) {
        return INSTANCE.load(context);
    }

    public static /* synthetic */ boolean needResolveIp$default(AuthenticatedGateway authenticatedGateway, long j, int i, Object obj) {
        if (obj != null) {
            Utf8$$ExternalSyntheticBUOutline0.m("Super calls with default arguments not supported in this target, function: needResolveIp");
            return false;
        }
        if ((i & 1) != 0) {
            j = 28800000;
        }
        return authenticatedGateway.needResolveIp(j);
    }

    public static final void reset(Context context) {
        INSTANCE.reset(context);
    }

    public String getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public final boolean isManualIp() {
        return Intrinsics.areEqual(getId(), getIp());
    }

    public final boolean needResolveIp(long ipExpirationInMs) {
        if (isManualIp()) {
            return false;
        }
        Long timestamp = getTimestamp();
        if (timestamp != null) {
            return System.currentTimeMillis() - timestamp.longValue() >= ipExpirationInMs;
        }
        return true;
    }

    public final void save(Context context) {
        context.getClass();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(Common_smartlightKt.SHARED_PREFERENCES_STORE, 0).edit();
        editorEdit.putString("smartlight-gateway-type", getClass().getSimpleName());
        editorEdit.putString("smartlight-gateway-value", new Gson().toJson(this));
        editorEdit.apply();
        Companion companion = INSTANCE;
        String str = "saved " + toAnonymized();
        Logger.logInfo(Logger.defaultTag, companion.getTag() + ": " + ((Object) str), null);
    }

    public final AuthenticatedGateway toAnonymized() {
        if ((this instanceof Hue) || (this instanceof YaHue)) {
            return this;
        }
        if (this instanceof Tradfri) {
            return Tradfri.copy$default((Tradfri) this, null, null, 0, "*****", null, "*****", null, 87, null);
        }
        if (this instanceof Dirigera) {
            return Dirigera.copy$default((Dirigera) this, null, null, 0, null, "*****", null, 47, null);
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    private AuthenticatedGateway(String str, String str2, Long l) {
        this.id = str;
        this.ip = str2;
        this.timestamp = l;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J3\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "id", "", "ip", "mac", "userName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "getMac", "getUserName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Hue extends AuthenticatedGateway {
        private final String id;
        private final String ip;
        private final String mac;
        private final String userName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Hue(String str, String str2, String str3, String str4) {
            super(str, str2, null, 4, null);
            Fragment$$ExternalSyntheticOutline1.m(str, str2, str4);
            this.id = str;
            this.ip = str2;
            this.mac = str3;
            this.userName = str4;
        }

        public static /* synthetic */ Hue copy$default(Hue hue, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hue.id;
            }
            if ((i & 2) != 0) {
                str2 = hue.ip;
            }
            if ((i & 4) != 0) {
                str3 = hue.mac;
            }
            if ((i & 8) != 0) {
                str4 = hue.userName;
            }
            return hue.copy(str, str2, str3, str4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIp() {
            return this.ip;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMac() {
            return this.mac;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUserName() {
            return this.userName;
        }

        public final Hue copy(String id, String ip, String mac, String userName) {
            id.getClass();
            ip.getClass();
            userName.getClass();
            return new Hue(id, ip, mac, userName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hue)) {
                return false;
            }
            Hue hue = (Hue) other;
            return Intrinsics.areEqual(this.id, hue.id) && Intrinsics.areEqual(this.ip, hue.ip) && Intrinsics.areEqual(this.mac, hue.mac) && Intrinsics.areEqual(this.userName, hue.userName);
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getIp() {
            return this.ip;
        }

        public final String getMac() {
            return this.mac;
        }

        public final String getUserName() {
            return this.userName;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip);
            String str = this.mac;
            return this.userName.hashCode() + ((iM + (str == null ? 0 : str.hashCode())) * 31);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Hue(id=");
            sb.append(this.id);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", mac=");
            sb.append(this.mac);
            sb.append(", userName=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.userName, ')');
        }

        public /* synthetic */ Hue(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3, str4);
        }
    }

    public /* synthetic */ AuthenticatedGateway(String str, String str2, Long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, l);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J=\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u0010¨\u0006 "}, d2 = {"Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$YaHue;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "id", "", "ip", "mac", "apiKey", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "getMac", "getApiKey", "setApiKey", "(Ljava/lang/String;)V", "getName", "setName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class YaHue extends AuthenticatedGateway {
        private String apiKey;
        private final String id;
        private final String ip;
        private final String mac;
        private String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public YaHue(String str, String str2, String str3, String str4, String str5) {
            super(str, str2, null, 4, null);
            str.getClass();
            str2.getClass();
            str4.getClass();
            str5.getClass();
            this.id = str;
            this.ip = str2;
            this.mac = str3;
            this.apiKey = str4;
            this.name = str5;
        }

        public static /* synthetic */ YaHue copy$default(YaHue yaHue, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = yaHue.id;
            }
            if ((i & 2) != 0) {
                str2 = yaHue.ip;
            }
            if ((i & 4) != 0) {
                str3 = yaHue.mac;
            }
            if ((i & 8) != 0) {
                str4 = yaHue.apiKey;
            }
            if ((i & 16) != 0) {
                str5 = yaHue.name;
            }
            String str6 = str5;
            String str7 = str3;
            return yaHue.copy(str, str2, str7, str4, str6);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIp() {
            return this.ip;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMac() {
            return this.mac;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getApiKey() {
            return this.apiKey;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getName() {
            return this.name;
        }

        public final YaHue copy(String id, String ip, String mac, String apiKey, String name) {
            id.getClass();
            ip.getClass();
            apiKey.getClass();
            name.getClass();
            return new YaHue(id, ip, mac, apiKey, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof YaHue)) {
                return false;
            }
            YaHue yaHue = (YaHue) other;
            return Intrinsics.areEqual(this.id, yaHue.id) && Intrinsics.areEqual(this.ip, yaHue.ip) && Intrinsics.areEqual(this.mac, yaHue.mac) && Intrinsics.areEqual(this.apiKey, yaHue.apiKey) && Intrinsics.areEqual(this.name, yaHue.name);
        }

        public final String getApiKey() {
            return this.apiKey;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getIp() {
            return this.ip;
        }

        public final String getMac() {
            return this.mac;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip);
            String str = this.mac;
            return this.name.hashCode() + FileInsert$$ExternalSyntheticOutline0.m((iM + (str == null ? 0 : str.hashCode())) * 31, 31, this.apiKey);
        }

        public final void setApiKey(String str) {
            str.getClass();
            this.apiKey = str;
        }

        public final void setName(String str) {
            str.getClass();
            this.name = str;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("YaHue(id=");
            sb.append(this.id);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", mac=");
            sb.append(this.mac);
            sb.append(", apiKey=");
            sb.append(this.apiKey);
            sb.append(", name=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, ')');
        }

        public /* synthetic */ YaHue(String str, String str2, String str3, String str4, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i & 4) != 0 ? null : str3, str4, str5);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JL\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u0006HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "id", "", "ip", "port", "", "code", "token", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getIp", "getPort", "()I", "getCode", "getToken", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Dirigera extends AuthenticatedGateway {
        private final String code;
        private final String id;
        private final String ip;
        private final int port;
        private final Long timestamp;
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dirigera(String str, String str2, int i, String str3, String str4, Long l) {
            super(str2, str2, null, 4, null);
            str.getClass();
            str2.getClass();
            str3.getClass();
            str4.getClass();
            this.id = str;
            this.ip = str2;
            this.port = i;
            this.code = str3;
            this.token = str4;
            this.timestamp = l;
        }

        public static /* synthetic */ Dirigera copy$default(Dirigera dirigera, String str, String str2, int i, String str3, String str4, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = dirigera.id;
            }
            if ((i2 & 2) != 0) {
                str2 = dirigera.ip;
            }
            if ((i2 & 4) != 0) {
                i = dirigera.port;
            }
            if ((i2 & 8) != 0) {
                str3 = dirigera.code;
            }
            if ((i2 & 16) != 0) {
                str4 = dirigera.token;
            }
            if ((i2 & 32) != 0) {
                l = dirigera.timestamp;
            }
            String str5 = str4;
            Long l2 = l;
            return dirigera.copy(str, str2, i, str3, str5, l2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIp() {
            return this.ip;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final Dirigera copy(String id, String ip, int port, String code, String token, Long timestamp) {
            id.getClass();
            ip.getClass();
            code.getClass();
            token.getClass();
            return new Dirigera(id, ip, port, code, token, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dirigera)) {
                return false;
            }
            Dirigera dirigera = (Dirigera) other;
            return Intrinsics.areEqual(this.id, dirigera.id) && Intrinsics.areEqual(this.ip, dirigera.ip) && this.port == dirigera.port && Intrinsics.areEqual(this.code, dirigera.code) && Intrinsics.areEqual(this.token, dirigera.token) && Intrinsics.areEqual(this.timestamp, dirigera.timestamp);
        }

        public final String getCode() {
            return this.code;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getIp() {
            return this.ip;
        }

        public final int getPort() {
            return this.port;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public Long getTimestamp() {
            return this.timestamp;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.port, FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip), 31), 31, this.code), 31, this.token);
            Long l = this.timestamp;
            return iM + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "Dirigera(id=" + this.id + ", ip=" + this.ip + ", port=" + this.port + ", code=" + this.code + ", token=" + this.token + ", timestamp=" + this.timestamp + ')';
        }

        public /* synthetic */ Dirigera(String str, String str2, int i, String str3, String str4, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? TradfriKt.DIRIGERA_PORT : i, str3, str4, (i2 & 32) != 0 ? Long.valueOf(System.currentTimeMillis()) : l);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017JV\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0006HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0096\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "id", "", "ip", "port", "", "secretCode", "identity", "token", "timestamp", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getId", "()Ljava/lang/String;", "getIp", "getPort", "()I", "getSecretCode", "getIdentity", "getToken", "getTimestamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Tradfri extends AuthenticatedGateway {
        private final String id;
        private final String identity;
        private final String ip;
        private final int port;
        private final String secretCode;
        private final Long timestamp;
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tradfri(String str, String str2, int i, String str3, String str4, String str5, Long l) {
            super(str, str2, null, 4, null);
            str.getClass();
            str2.getClass();
            str3.getClass();
            str4.getClass();
            str5.getClass();
            this.id = str;
            this.ip = str2;
            this.port = i;
            this.secretCode = str3;
            this.identity = str4;
            this.token = str5;
            this.timestamp = l;
        }

        public static /* synthetic */ Tradfri copy$default(Tradfri tradfri, String str, String str2, int i, String str3, String str4, String str5, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = tradfri.id;
            }
            if ((i2 & 2) != 0) {
                str2 = tradfri.ip;
            }
            if ((i2 & 4) != 0) {
                i = tradfri.port;
            }
            if ((i2 & 8) != 0) {
                str3 = tradfri.secretCode;
            }
            if ((i2 & 16) != 0) {
                str4 = tradfri.identity;
            }
            if ((i2 & 32) != 0) {
                str5 = tradfri.token;
            }
            if ((i2 & 64) != 0) {
                l = tradfri.timestamp;
            }
            String str6 = str5;
            Long l2 = l;
            String str7 = str4;
            int i3 = i;
            return tradfri.copy(str, str2, i3, str3, str7, str6, l2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getIp() {
            return this.ip;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getPort() {
            return this.port;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getSecretCode() {
            return this.secretCode;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getIdentity() {
            return this.identity;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getToken() {
            return this.token;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final Tradfri copy(String id, String ip, int port, String secretCode, String identity, String token, Long timestamp) {
            id.getClass();
            ip.getClass();
            secretCode.getClass();
            identity.getClass();
            token.getClass();
            return new Tradfri(id, ip, port, secretCode, identity, token, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tradfri)) {
                return false;
            }
            Tradfri tradfri = (Tradfri) other;
            return Intrinsics.areEqual(this.id, tradfri.id) && Intrinsics.areEqual(this.ip, tradfri.ip) && this.port == tradfri.port && Intrinsics.areEqual(this.secretCode, tradfri.secretCode) && Intrinsics.areEqual(this.identity, tradfri.identity) && Intrinsics.areEqual(this.token, tradfri.token) && Intrinsics.areEqual(this.timestamp, tradfri.timestamp);
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getId() {
            return this.id;
        }

        public final String getIdentity() {
            return this.identity;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public String getIp() {
            return this.ip;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getSecretCode() {
            return this.secretCode;
        }

        @Override // com.urbandroid.smartlight.common.model.AuthenticatedGateway
        public Long getTimestamp() {
            return this.timestamp;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(FileInsert$$ExternalSyntheticOutline0.m(this.port, FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip), 31), 31, this.secretCode), 31, this.identity), 31, this.token);
            Long l = this.timestamp;
            return iM + (l == null ? 0 : l.hashCode());
        }

        public String toString() {
            return "Tradfri(id=" + this.id + ", ip=" + this.ip + ", port=" + this.port + ", secretCode=" + this.secretCode + ", identity=" + this.identity + ", token=" + this.token + ", timestamp=" + this.timestamp + ')';
        }

        public /* synthetic */ Tradfri(String str, String str2, int i, String str3, String str4, String str5, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, i, str3, str4, str5, (i2 & 64) != 0 ? Long.valueOf(System.currentTimeMillis()) : l);
        }
    }
}
