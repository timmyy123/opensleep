package twitter4j.conf;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u001a\u0010\u000e\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\u0018\u0010\u000e\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\f\u0010\u0006¨\u0006\u0014"}, d2 = {"Ltwitter4j/conf/V2CustomConfiguration;", "", "()V", "clientId", "", "getClientId", "()Ljava/lang/String;", "clientId$delegate", "Lkotlin/Lazy;", "props", "Ljava/util/Properties;", "redirectUri", "getRedirectUri", "redirectUri$delegate", "loadProperties", "", "", "inputStream", "Ljava/io/InputStream;", "path", "twitter4j-v2-support"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class V2CustomConfiguration {
    private Properties props;

    /* JADX INFO: renamed from: clientId$delegate, reason: from kotlin metadata */
    private final Lazy clientId = LazyKt.lazy(new Function0<String>() { // from class: twitter4j.conf.V2CustomConfiguration$clientId$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Properties properties = this.this$0.props;
            if (properties == null) {
                Intrinsics.throwUninitializedPropertyAccessException("props");
                properties = null;
            }
            return properties.getProperty("oauth2.client_id", "");
        }
    });

    /* JADX INFO: renamed from: redirectUri$delegate, reason: from kotlin metadata */
    private final Lazy redirectUri = LazyKt.lazy(new Function0<String>() { // from class: twitter4j.conf.V2CustomConfiguration$redirectUri$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Properties properties = this.this$0.props;
            if (properties == null) {
                Intrinsics.throwUninitializedPropertyAccessException("props");
                properties = null;
            }
            return properties.getProperty("oauth2.redirect_uri", "");
        }
    });

    public V2CustomConfiguration() {
        loadProperties();
    }

    private final void loadProperties() {
        Properties properties = null;
        try {
            Object objClone = System.getProperties().clone();
            objClone.getClass();
            this.props = (Properties) objClone;
            try {
                Map<String, String> map = System.getenv();
                for (String str : map.keySet()) {
                    Properties properties2 = this.props;
                    if (properties2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("props");
                        properties2 = null;
                    }
                    properties2.setProperty(str, map.get(str));
                }
            } catch (SecurityException unused) {
            }
        } catch (SecurityException unused2) {
            this.props = new Properties();
        }
        Properties properties3 = this.props;
        if (properties3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("props");
            properties3 = null;
        }
        loadProperties(properties3, "." + File.separatorChar + "twitter4j.properties");
        Properties properties4 = this.props;
        if (properties4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("props");
            properties4 = null;
        }
        loadProperties(properties4, Configuration.class.getResourceAsStream("/twitter4j.properties"));
        Properties properties5 = this.props;
        if (properties5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("props");
        } else {
            properties = properties5;
        }
        loadProperties(properties, Configuration.class.getResourceAsStream("/WEB-INF/twitter4j.properties"));
    }

    public final String getClientId() {
        Object value = this.clientId.getValue();
        value.getClass();
        return (String) value;
    }

    public final String getRedirectUri() {
        Object value = this.redirectUri.getValue();
        value.getClass();
        return (String) value;
    }

    private final boolean loadProperties(Properties props, String path) {
        try {
            File file = new File(path);
            if (!file.exists() || !file.isFile()) {
                return false;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                props.load(fileInputStream);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileInputStream, null);
                return true;
            } finally {
            }
        } catch (Exception unused) {
            return false;
        }
    }

    private final boolean loadProperties(Properties props, InputStream inputStream) {
        try {
            props.load(inputStream);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
