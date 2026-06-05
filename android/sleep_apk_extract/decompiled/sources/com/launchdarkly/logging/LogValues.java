package com.launchdarkly.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LogValues {

    public static final class DeferImpl {
        private final StringProvider stringProvider;

        public DeferImpl(StringProvider stringProvider) {
            this.stringProvider = stringProvider;
        }

        public String toString() {
            return this.stringProvider.get();
        }
    }

    public interface StringProvider {
        String get();
    }

    public static Object defer(StringProvider stringProvider) {
        return new DeferImpl(stringProvider);
    }

    public static Object exceptionSummary(Throwable th) {
        return th;
    }

    public static Object exceptionTrace(final Throwable th) {
        if (th == null) {
            return null;
        }
        return defer(new StringProvider() { // from class: com.launchdarkly.logging.LogValues.1
            @Override // com.launchdarkly.logging.LogValues.StringProvider
            public String get() {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                return stringWriter.toString();
            }
        });
    }
}
