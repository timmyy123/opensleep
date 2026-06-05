package com.urbandroid.smartlight.common.model;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.ikea.tradfri.TradfriKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000b\f\r\u000eB\u0019\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b\u0082\u0001\u0004\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Gateway;", "", "id", "", "ip", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "toAnonymized", "Hue", "YaHue", "Tradfri", "Dirigera", "Lcom/urbandroid/smartlight/common/model/Gateway$Dirigera;", "Lcom/urbandroid/smartlight/common/model/Gateway$Hue;", "Lcom/urbandroid/smartlight/common/model/Gateway$Tradfri;", "Lcom/urbandroid/smartlight/common/model/Gateway$YaHue;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Gateway {
    private final String id;
    private final String ip;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Gateway$Hue;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "id", "", "ip", "mac", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "getMac", "toAuthenticated", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Hue;", "userName", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Hue extends Gateway {
        private final String id;
        private final String ip;
        private final String mac;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Hue(String str, String str2, String str3) {
            super(str, str2, null);
            str.getClass();
            str2.getClass();
            this.id = str;
            this.ip = str2;
            this.mac = str3;
        }

        public static /* synthetic */ Hue copy$default(Hue hue, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = hue.id;
            }
            if ((i & 2) != 0) {
                str2 = hue.ip;
            }
            if ((i & 4) != 0) {
                str3 = hue.mac;
            }
            return hue.copy(str, str2, str3);
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

        public final Hue copy(String id, String ip, String mac) {
            id.getClass();
            ip.getClass();
            return new Hue(id, ip, mac);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Hue)) {
                return false;
            }
            Hue hue = (Hue) other;
            return Intrinsics.areEqual(this.id, hue.id) && Intrinsics.areEqual(this.ip, hue.ip) && Intrinsics.areEqual(this.mac, hue.mac);
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getIp() {
            return this.ip;
        }

        public final String getMac() {
            return this.mac;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip);
            String str = this.mac;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final AuthenticatedGateway.Hue toAuthenticated(String userName) {
            userName.getClass();
            return new AuthenticatedGateway.Hue(getId(), getIp(), this.mac, userName);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Hue(id=");
            sb.append(this.id);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", mac=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.mac, ')');
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J3\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Gateway$YaHue;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "id", "", "ip", "mac", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "getMac", "getName", "toAuthenticated", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$YaHue;", "apiKey", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class YaHue extends Gateway {
        private final String id;
        private final String ip;
        private final String mac;
        private final String name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public YaHue(String str, String str2, String str3, String str4) {
            super(str, str2, null);
            Fragment$$ExternalSyntheticOutline1.m(str, str2, str4);
            this.id = str;
            this.ip = str2;
            this.mac = str3;
            this.name = str4;
        }

        public static /* synthetic */ YaHue copy$default(YaHue yaHue, String str, String str2, String str3, String str4, int i, Object obj) {
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
                str4 = yaHue.name;
            }
            return yaHue.copy(str, str2, str3, str4);
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
        public final String getName() {
            return this.name;
        }

        public final YaHue copy(String id, String ip, String mac, String name) {
            id.getClass();
            ip.getClass();
            name.getClass();
            return new YaHue(id, ip, mac, name);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof YaHue)) {
                return false;
            }
            YaHue yaHue = (YaHue) other;
            return Intrinsics.areEqual(this.id, yaHue.id) && Intrinsics.areEqual(this.ip, yaHue.ip) && Intrinsics.areEqual(this.mac, yaHue.mac) && Intrinsics.areEqual(this.name, yaHue.name);
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
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
            return this.name.hashCode() + ((iM + (str == null ? 0 : str.hashCode())) * 31);
        }

        public final AuthenticatedGateway.YaHue toAuthenticated(String apiKey) {
            apiKey.getClass();
            return new AuthenticatedGateway.YaHue(getId(), getIp(), this.mac, apiKey, this.name);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("YaHue(id=");
            sb.append(this.id);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", mac=");
            sb.append(this.mac);
            sb.append(", name=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, ')');
        }
    }

    private Gateway(String str, String str2) {
        this.id = str;
        this.ip = str2;
    }

    public String getId() {
        return this.id;
    }

    public String getIp() {
        return this.ip;
    }

    public final Gateway toAnonymized() {
        if (this instanceof Hue) {
            return this;
        }
        if (this instanceof Tradfri) {
            return Tradfri.copy$default((Tradfri) this, null, null, 0, "*****", 7, null);
        }
        if ((this instanceof YaHue) || (this instanceof Dirigera)) {
            return this;
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public /* synthetic */ Gateway(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Gateway$Dirigera;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "id", "", "ip", "port", "", "codeVerifier", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "getPort", "()I", "getCodeVerifier", "setCodeVerifier", "(Ljava/lang/String;)V", "toAuthenticated", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Dirigera;", "code", "token", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Dirigera extends Gateway {
        private String codeVerifier;
        private final String id;
        private final String ip;
        private final int port;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Dirigera(String str, String str2, int i, String str3) {
            super(str2, str2, null);
            str.getClass();
            str2.getClass();
            this.id = str;
            this.ip = str2;
            this.port = i;
            this.codeVerifier = str3;
        }

        public static /* synthetic */ Dirigera copy$default(Dirigera dirigera, String str, String str2, int i, String str3, int i2, Object obj) {
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
                str3 = dirigera.codeVerifier;
            }
            return dirigera.copy(str, str2, i, str3);
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
        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        public final Dirigera copy(String id, String ip, int port, String codeVerifier) {
            id.getClass();
            ip.getClass();
            return new Dirigera(id, ip, port, codeVerifier);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Dirigera)) {
                return false;
            }
            Dirigera dirigera = (Dirigera) other;
            return Intrinsics.areEqual(this.id, dirigera.id) && Intrinsics.areEqual(this.ip, dirigera.ip) && this.port == dirigera.port && Intrinsics.areEqual(this.codeVerifier, dirigera.codeVerifier);
        }

        public final String getCodeVerifier() {
            return this.codeVerifier;
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getIp() {
            return this.ip;
        }

        public final int getPort() {
            return this.port;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.port, FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip), 31);
            String str = this.codeVerifier;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final void setCodeVerifier(String str) {
            this.codeVerifier = str;
        }

        public final AuthenticatedGateway.Dirigera toAuthenticated(String code, String token) {
            code.getClass();
            token.getClass();
            return new AuthenticatedGateway.Dirigera(getId(), getIp(), TradfriKt.DIRIGERA_PORT, code, token, null, 32, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Dirigera(id=");
            sb.append(this.id);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", port=");
            sb.append(this.port);
            sb.append(", codeVerifier=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.codeVerifier, ')');
        }

        public /* synthetic */ Dirigera(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i2 & 4) != 0 ? TradfriKt.DIRIGERA_PORT : i, (i2 & 8) != 0 ? null : str3);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Gateway$Tradfri;", "Lcom/urbandroid/smartlight/common/model/Gateway;", "id", "", "ip", "port", "", "secretCode", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getIp", "getPort", "()I", "getSecretCode", "toAuthenticated", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway$Tradfri;", "identity", "token", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Tradfri extends Gateway {
        private final String id;
        private final String ip;
        private final int port;
        private final String secretCode;

        public /* synthetic */ Tradfri(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? str : str2, (i2 & 4) != 0 ? TradfriKt.COAPS_PORT : i, (i2 & 8) != 0 ? null : str3);
        }

        public static /* synthetic */ Tradfri copy$default(Tradfri tradfri, String str, String str2, int i, String str3, int i2, Object obj) {
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
            return tradfri.copy(str, str2, i, str3);
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

        public final Tradfri copy(String id, String ip, int port, String secretCode) {
            id.getClass();
            ip.getClass();
            return new Tradfri(id, ip, port, secretCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Tradfri)) {
                return false;
            }
            Tradfri tradfri = (Tradfri) other;
            return Intrinsics.areEqual(this.id, tradfri.id) && Intrinsics.areEqual(this.ip, tradfri.ip) && this.port == tradfri.port && Intrinsics.areEqual(this.secretCode, tradfri.secretCode);
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getId() {
            return this.id;
        }

        @Override // com.urbandroid.smartlight.common.model.Gateway
        public String getIp() {
            return this.ip;
        }

        public final int getPort() {
            return this.port;
        }

        public final String getSecretCode() {
            return this.secretCode;
        }

        public int hashCode() {
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.port, FileInsert$$ExternalSyntheticOutline0.m(this.id.hashCode() * 31, 31, this.ip), 31);
            String str = this.secretCode;
            return iM + (str == null ? 0 : str.hashCode());
        }

        public final AuthenticatedGateway.Tradfri toAuthenticated(String identity, String token) {
            identity.getClass();
            token.getClass();
            String id = getId();
            String ip = getIp();
            int i = this.port;
            String str = this.secretCode;
            if (str == null) {
                str = "";
            }
            return new AuthenticatedGateway.Tradfri(id, ip, i, str, identity, token, null, 64, null);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Tradfri(id=");
            sb.append(this.id);
            sb.append(", ip=");
            sb.append(this.ip);
            sb.append(", port=");
            sb.append(this.port);
            sb.append(", secretCode=");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.secretCode, ')');
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Tradfri(String str, String str2, int i, String str3) {
            super(str, str2, null);
            str.getClass();
            str2.getClass();
            this.id = str;
            this.ip = str2;
            this.port = i;
            this.secretCode = str3;
        }
    }
}
