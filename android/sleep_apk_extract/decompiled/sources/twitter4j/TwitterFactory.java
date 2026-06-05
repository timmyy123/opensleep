package twitter4j;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;
import twitter4j.auth.Authorization;
import twitter4j.auth.AuthorizationFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationContext;

/* JADX INFO: loaded from: classes5.dex */
public class TwitterFactory implements Serializable {
    static final Authorization DEFAULT_AUTHORIZATION = AuthorizationFactory.getInstance(ConfigurationContext.getInstance());
    private static final Twitter SINGLETON;
    private static final Constructor<Twitter> TWITTER_CONSTRUCTOR;
    private static final long serialVersionUID = -563983536986910054L;
    private final Configuration conf;

    static {
        boolean z;
        String str = "twitter4j.AppEngineTwitterImpl";
        try {
            Class.forName("com.google.appengine.api.urlfetch.URLFetchService");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        if (z) {
            try {
                Class.forName("twitter4j.AppEngineTwitterImpl");
            } catch (ClassNotFoundException unused2) {
                str = null;
            }
        } else {
            str = null;
        }
        if (str == null) {
            str = "twitter4j.TwitterImpl";
        }
        try {
            Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(Configuration.class, Authorization.class);
            TWITTER_CONSTRUCTOR = declaredConstructor;
            try {
                SINGLETON = (Twitter) declaredConstructor.newInstance(ConfigurationContext.getInstance(), DEFAULT_AUTHORIZATION);
            } catch (IllegalAccessException e) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            } catch (InstantiationException e2) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
            } catch (InvocationTargetException e3) {
                Utf8$$ExternalSyntheticBUOutline0.m$1(e3);
            }
        } catch (ClassNotFoundException e4) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e4);
        } catch (NoSuchMethodException e5) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e5);
        }
    }

    public TwitterFactory(Configuration configuration) {
        if (configuration != null) {
            this.conf = configuration;
        } else {
            Types$$ExternalSyntheticBUOutline0.m$1("configuration cannot be null");
            throw null;
        }
    }

    public Twitter getInstance(Authorization authorization) {
        try {
            return TWITTER_CONSTRUCTOR.newInstance(this.conf, authorization);
        } catch (IllegalAccessException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e);
            return null;
        } catch (InstantiationException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e2);
            return null;
        } catch (InvocationTargetException e3) {
            Utf8$$ExternalSyntheticBUOutline0.m$1(e3);
            return null;
        }
    }

    public TwitterFactory() {
        this(ConfigurationContext.getInstance());
    }

    public Twitter getInstance() {
        return getInstance(AuthorizationFactory.getInstance(this.conf));
    }
}
