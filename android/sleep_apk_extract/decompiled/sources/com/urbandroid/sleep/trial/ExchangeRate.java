package com.urbandroid.sleep.trial;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/trial/ExchangeRate;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class ExchangeRate {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Double> rates;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/trial/ExchangeRate$Companion;", "", "<init>", "()V", "rates", "", "", "", "getRates", "()Ljava/util/Map;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Map<String, Double> getRates() {
            return ExchangeRate.rates;
        }

        private Companion() {
        }
    }

    static {
        Pair pair = TuplesKt.to("AUD", Double.valueOf(14.672d));
        Pair pair2 = TuplesKt.to("BRL", Double.valueOf(4.075d));
        Pair pair3 = TuplesKt.to("CAD", Double.valueOf(15.368d));
        Pair pair4 = TuplesKt.to("CNY", Double.valueOf(3.096d));
        Pair pair5 = TuplesKt.to("DKK", Double.valueOf(3.286d));
        Pair pair6 = TuplesKt.to("EUR", Double.valueOf(24.555d));
        Pair pair7 = TuplesKt.to("HKD", Double.valueOf(2.731d));
        Pair pair8 = TuplesKt.to("HUF", Double.valueOf(0.06304d));
        Pair pair9 = TuplesKt.to("ISK", Double.valueOf(0.17123000000000002d));
        Pair pair10 = TuplesKt.to("XDR", Double.valueOf(29.073d));
        Pair pair11 = TuplesKt.to("INR", Double.valueOf(0.22588d));
        Pair pair12 = TuplesKt.to("IDR", Double.valueOf(0.001259d));
        Pair pair13 = TuplesKt.to("ILS", Double.valueOf(6.772d));
        Pair pair14 = TuplesKt.to("JPY", Double.valueOf(0.13416d));
        Pair pair15 = TuplesKt.to("MYR", Double.valueOf(5.312d));
        Pair pair16 = TuplesKt.to("MXN", Double.valueOf(1.182d));
        Pair pair17 = TuplesKt.to("NZD", Double.valueOf(12.237d));
        Pair pair18 = TuplesKt.to("NOK", Double.valueOf(2.193d));
        Pair pair19 = TuplesKt.to("PHP", Double.valueOf(0.35247d));
        Pair pair20 = TuplesKt.to("PLN", Double.valueOf(5.727d));
        Pair pair21 = TuplesKt.to("RON", Double.valueOf(4.817d));
        Pair pair22 = TuplesKt.to("SGD", Double.valueOf(16.584d));
        Pair pair23 = TuplesKt.to("ZAR", Double.valueOf(1.245d));
        Pair pair24 = TuplesKt.to("KRW", Double.valueOf(0.01409d));
        Pair pair25 = TuplesKt.to("SEK", Double.valueOf(2.251d));
        Pair pair26 = TuplesKt.to("CHF", Double.valueOf(26.734d));
        Pair pair27 = TuplesKt.to("THB", Double.valueOf(0.6512300000000001d));
        Pair pair28 = TuplesKt.to("TRY", Double.valueOf(0.48117d));
        Pair pair29 = TuplesKt.to("GBP", Double.valueOf(28.295d));
        Pair pair30 = TuplesKt.to("USD", Double.valueOf(21.398d));
        Pair pair31 = TuplesKt.to("AFN", Double.valueOf(0.32496d));
        Pair pair32 = TuplesKt.to("ALL", Double.valueOf(0.25266d));
        Pair pair33 = TuplesKt.to("DZD", Double.valueOf(0.15884d));
        Pair pair34 = TuplesKt.to("AOA", Double.valueOf(0.02252d));
        Pair pair35 = TuplesKt.to("ARS", Double.valueOf(0.014610000000000001d));
        Pair pair36 = TuplesKt.to("AMD", Double.valueOf(0.05492d));
        Double dValueOf = Double.valueOf(11.54d);
        Pair pair37 = TuplesKt.to("AWG", dValueOf);
        Pair pair38 = TuplesKt.to("AZN", Double.valueOf(12.119d));
        Double dValueOf2 = Double.valueOf(20.541d);
        Pair pair39 = TuplesKt.to("BSD", dValueOf2);
        Pair pair40 = TuplesKt.to("BHD", Double.valueOf(54.5d));
        Pair pair41 = TuplesKt.to("BDT", Double.valueOf(0.16878d));
        Pair pair42 = TuplesKt.to("BBD", Double.valueOf(10.28d));
        Pair pair43 = TuplesKt.to("XOF", Double.valueOf(0.03723d));
        Pair pair44 = TuplesKt.to("XAF", Double.valueOf(0.03696d));
        Pair pair45 = TuplesKt.to("BYN", Double.valueOf(7.118d));
        Pair pair46 = TuplesKt.to("BZD", Double.valueOf(10.269d));
        Pair pair47 = TuplesKt.to("BMD", dValueOf2);
        Pair pair48 = TuplesKt.to("BTN", Double.valueOf(0.22563d));
        Pair pair49 = TuplesKt.to("BOB", Double.valueOf(2.999d));
        Pair pair50 = TuplesKt.to("BAM", Double.valueOf(12.396d));
        Pair pair51 = TuplesKt.to("BWP", Double.valueOf(1.477d));
        Pair pair52 = TuplesKt.to("BND", Double.valueOf(16.232d));
        Pair pair53 = TuplesKt.to("BIF", Double.valueOf(0.006952d));
        Pair pair54 = TuplesKt.to("KHR", Double.valueOf(0.005131d));
        Pair pair55 = TuplesKt.to("CVE", Double.valueOf(0.21989999999999998d));
        Pair pair56 = TuplesKt.to("KYD", Double.valueOf(24.823d));
        Pair pair57 = TuplesKt.to("CLP", Double.valueOf(0.02357d));
        Pair pair58 = TuplesKt.to("COP", Double.valueOf(0.005465d));
        Pair pair59 = TuplesKt.to("KMF", Double.valueOf(0.04929d));
        Pair pair60 = TuplesKt.to("CDF", Double.valueOf(0.009644d));
        Pair pair61 = TuplesKt.to("CRC", Double.valueOf(0.04376d));
        Pair pair62 = TuplesKt.to("CUP", Double.valueOf(0.85588d));
        Pair pair63 = TuplesKt.to("XCG", dValueOf);
        Pair pair64 = TuplesKt.to("DJF", Double.valueOf(0.11566000000000001d));
        Pair pair65 = TuplesKt.to("DOP", Double.valueOf(0.34171999999999997d));
        Pair pair66 = TuplesKt.to("XCD", Double.valueOf(7.636d));
        Pair pair67 = TuplesKt.to("EGP", Double.valueOf(0.42883000000000004d));
        Pair pair68 = TuplesKt.to("SVC", Double.valueOf(2.348d));
        Pair pair69 = TuplesKt.to("ERN", Double.valueOf(1.369d));
        Pair pair70 = TuplesKt.to("ETB", Double.valueOf(0.13376d));
        Double dValueOf3 = Double.valueOf(27.667d);
        Pair pair71 = TuplesKt.to("FKP", dValueOf3);
        Pair pair72 = TuplesKt.to("FJD", Double.valueOf(9.243d));
        Pair pair73 = TuplesKt.to("XPF", Double.valueOf(0.20379999999999998d));
        Pair pair74 = TuplesKt.to("GMD", Double.valueOf(0.27814d));
        Pair pair75 = TuplesKt.to("GEL", Double.valueOf(7.769d));
        Pair pair76 = TuplesKt.to("GHS", Double.valueOf(1.929d));
        Pair pair77 = TuplesKt.to("GIP", dValueOf3);
        Pair pair78 = TuplesKt.to("GTQ", Double.valueOf(2.682d));
        Pair pair79 = TuplesKt.to("GNF", Double.valueOf(0.00235d));
        Pair pair80 = TuplesKt.to("GYD", Double.valueOf(0.09876d));
        Pair pair81 = TuplesKt.to("HTG", Double.valueOf(0.15744999999999998d));
        Pair pair82 = TuplesKt.to("HNL", Double.valueOf(0.77673d));
        Pair pair83 = TuplesKt.to("IRR", Double.valueOf(1.56E-5d));
        Pair pair84 = TuplesKt.to("IQD", Double.valueOf(0.015686d));
        Pair pair85 = TuplesKt.to("JMD", Double.valueOf(0.13251d));
        Pair pair86 = TuplesKt.to("JOD", Double.valueOf(29.013d));
        Pair pair87 = TuplesKt.to("KZT", Double.valueOf(0.041299999999999996d));
        Pair pair88 = TuplesKt.to("KES", Double.valueOf(0.15936d));
        Pair pair89 = TuplesKt.to("KPW", Double.valueOf(0.15801d));
        Pair pair90 = TuplesKt.to("KWD", Double.valueOf(67.248d));
        Pair pair91 = TuplesKt.to("KGS", Double.valueOf(0.23489000000000002d));
        Pair pair92 = TuplesKt.to("LAK", Double.valueOf(9.64E-4d));
        Pair pair93 = TuplesKt.to("LBP", Double.valueOf(2.3E-4d));
        Double dValueOf4 = Double.valueOf(1.287d);
        rates = MapsKt.mutableMapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, pair19, pair20, pair21, pair22, pair23, pair24, pair25, pair26, pair27, pair28, pair29, pair30, pair31, pair32, pair33, pair34, pair35, pair36, pair37, pair38, pair39, pair40, pair41, pair42, pair43, pair44, pair45, pair46, pair47, pair48, pair49, pair50, pair51, pair52, pair53, pair54, pair55, pair56, pair57, pair58, pair59, pair60, pair61, pair62, pair63, pair64, pair65, pair66, pair67, pair68, pair69, pair70, pair71, pair72, pair73, pair74, pair75, pair76, pair77, pair78, pair79, pair80, pair81, pair82, pair83, pair84, pair85, pair86, pair87, pair88, pair89, pair90, pair91, pair92, pair93, TuplesKt.to("LSL", dValueOf4), TuplesKt.to("LRD", Double.valueOf(0.11225d)), TuplesKt.to("LYD", Double.valueOf(3.26d)), TuplesKt.to("MOP", Double.valueOf(2.549d)), TuplesKt.to("MGA", Double.valueOf(0.004915d)), TuplesKt.to("MWK", Double.valueOf(0.01196d)), TuplesKt.to("MVR", Double.valueOf(1.332d)), TuplesKt.to("MRU", Double.valueOf(0.5154299999999999d)), TuplesKt.to("MUR", Double.valueOf(0.44442d)), TuplesKt.to("MDL", Double.valueOf(1.21d)), TuplesKt.to("MNT", Double.valueOf(0.0057599999999999995d)), TuplesKt.to("MAD", Double.valueOf(2.243d)), TuplesKt.to("MZN", Double.valueOf(0.32272d)), TuplesKt.to("MMK", Double.valueOf(0.009811d)), TuplesKt.to("NAD", dValueOf4), TuplesKt.to("NPR", Double.valueOf(0.14112d)), TuplesKt.to("NIO", Double.valueOf(0.56123d)), TuplesKt.to("NGN", Double.valueOf(0.0151d)), TuplesKt.to("MKD", Double.valueOf(0.39479d)), TuplesKt.to("OMR", Double.valueOf(53.373d)), TuplesKt.to("PKR", Double.valueOf(0.07357d)), TuplesKt.to("PAB", dValueOf2), TuplesKt.to("PGK", Double.valueOf(4.626d)), TuplesKt.to("PYG", Double.valueOf(0.003192d)), TuplesKt.to("PEN", Double.valueOf(6.124d)), TuplesKt.to("QAR", Double.valueOf(5.636d)), TuplesKt.to("RUB", Double.valueOf(0.26634d)), TuplesKt.to("RWF", Double.valueOf(0.01414d)), TuplesKt.to("SHP", dValueOf3), TuplesKt.to("WST", Double.valueOf(7.419d)), TuplesKt.to("STN", Double.valueOf(0.9897400000000001d)), TuplesKt.to("SAR", Double.valueOf(5.476d)), TuplesKt.to("RSD", Double.valueOf(0.20675000000000002d)), TuplesKt.to("SCR", Double.valueOf(1.503d)), TuplesKt.to("SLE", Double.valueOf(0.849d)), TuplesKt.to("SBD", Double.valueOf(2.512d)), TuplesKt.to("SOS", Double.valueOf(0.036164d)), TuplesKt.to("SSP", Double.valueOf(0.00459d)), TuplesKt.to("LKR", Double.valueOf(0.06643d)), TuplesKt.to("SDG", Double.valueOf(0.034318d)), TuplesKt.to("SRD", Double.valueOf(0.5459499999999999d)), TuplesKt.to("SZL", dValueOf4), TuplesKt.to("SYP", Double.valueOf(0.1858914d)), TuplesKt.to("TJS", Double.valueOf(2.187d)), TuplesKt.to("TWD", Double.valueOf(0.65461d)), TuplesKt.to("TZS", Double.valueOf(0.008151d)), TuplesKt.to("TOP", Double.valueOf(8.457d)), TuplesKt.to("TTD", Double.valueOf(3.054d)), TuplesKt.to("TND", Double.valueOf(7.196d)), TuplesKt.to("TMT", Double.valueOf(5.878d)), TuplesKt.to("UGX", Double.valueOf(0.005706d)), TuplesKt.to("UAH", Double.valueOf(0.47659d)), TuplesKt.to("AED", Double.valueOf(5.594d)), TuplesKt.to("UYU", Double.valueOf(0.53492d)), TuplesKt.to("UZS", Double.valueOf(0.001689d)), TuplesKt.to("VUV", Double.valueOf(0.17662d)), TuplesKt.to("VND", Double.valueOf(7.888E-4d)), TuplesKt.to("YER", Double.valueOf(0.08628d)), TuplesKt.to("ZMW", Double.valueOf(1.093d)));
    }
}
