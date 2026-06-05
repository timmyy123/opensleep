package org.slf4j;

import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Reporter;
import org.slf4j.helpers.SubstituteServiceProvider;
import org.slf4j.spi.MDCAdapter;
import org.slf4j.spi.SLF4JServiceProvider;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MDC {
    static MDCAdapter MDC_ADAPTER;

    public static void clear() {
        if (getMDCAdapter() != null) {
            getMDCAdapter().clear();
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
    }

    private static void emitTemporaryMDCAdapterWarningIfNeeded(SLF4JServiceProvider sLF4JServiceProvider) {
        if (sLF4JServiceProvider instanceof SubstituteServiceProvider) {
            Reporter.info("Temporary mdcAdapter given by SubstituteServiceProvider.");
            Reporter.info("This mdcAdapter will be replaced after backend initialization has completed.");
        }
    }

    public static MDCAdapter getMDCAdapter() {
        if (MDC_ADAPTER == null) {
            MDC_ADAPTER = getMDCAdapterGivenByProvider();
        }
        return MDC_ADAPTER;
    }

    private static MDCAdapter getMDCAdapterGivenByProvider() {
        SLF4JServiceProvider provider = LoggerFactory.getProvider();
        if (provider != null) {
            MDCAdapter mDCAdapter = provider.getMDCAdapter();
            emitTemporaryMDCAdapterWarningIfNeeded(provider);
            return mDCAdapter;
        }
        Reporter.error("Failed to find provider.");
        Reporter.error("Defaulting to no-operation MDCAdapter implementation.");
        return new NOPMDCAdapter();
    }

    public static void put(String str, String str2) {
        if (str == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("key parameter cannot be null");
        } else if (getMDCAdapter() != null) {
            getMDCAdapter().put(str, str2);
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
    }

    public static void setMDCAdapter(MDCAdapter mDCAdapter) {
        if (mDCAdapter != null) {
            MDC_ADAPTER = mDCAdapter;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$3("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
        }
    }
}
