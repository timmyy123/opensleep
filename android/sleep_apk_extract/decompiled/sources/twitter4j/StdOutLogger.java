package twitter4j;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Date;
import twitter4j.conf.ConfigurationContext;

/* JADX INFO: loaded from: classes5.dex */
final class StdOutLogger extends Logger {
    private static final boolean DEBUG = ConfigurationContext.getInstance().isDebugEnabled();

    @Override // twitter4j.Logger
    public void debug(String str) {
        if (DEBUG) {
            System.out.println("[" + new Date() + "]" + str);
        }
    }

    @Override // twitter4j.Logger
    public void error(String str) {
        System.out.println("[" + new Date() + "]" + str);
    }

    @Override // twitter4j.Logger
    public boolean isDebugEnabled() {
        return DEBUG;
    }

    @Override // twitter4j.Logger
    public void error(String str, Throwable th) {
        System.out.println(str);
        th.printStackTrace(System.err);
    }

    @Override // twitter4j.Logger
    public void debug(String str, String str2) {
        if (DEBUG) {
            debug(FileInsert$$ExternalSyntheticOutline0.m$1(str, str2));
        }
    }
}
