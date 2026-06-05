package com.urbandroid.sleep.hr.berry.parser;

import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.hr.berry.parser.DataParser;

/* JADX INFO: loaded from: classes.dex */
public class PackageParserAuto {
    private final PackageParserBCI packageParserBCI;
    private final PackageParserIsrael packageParserIsrael;

    /* JADX INFO: renamed from: com.urbandroid.sleep.hr.berry.parser.PackageParserAuto$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$urbandroid$sleep$hr$berry$parser$DataParser$Protocol;

        static {
            int[] iArr = new int[DataParser.Protocol.values().length];
            $SwitchMap$com$urbandroid$sleep$hr$berry$parser$DataParser$Protocol = iArr;
            try {
                iArr[DataParser.Protocol.BCI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$urbandroid$sleep$hr$berry$parser$DataParser$Protocol[DataParser.Protocol.ISRAEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PackageParserAuto(OximeterResultListener oximeterResultListener) {
        this.packageParserBCI = new PackageParserBCI(oximeterResultListener);
        this.packageParserIsrael = new PackageParserIsrael(oximeterResultListener);
    }

    public void parse(DataParser.Protocol protocol2, int[] iArr) {
        int i = AnonymousClass1.$SwitchMap$com$urbandroid$sleep$hr$berry$parser$DataParser$Protocol[protocol2.ordinal()];
        if (i == 1) {
            this.packageParserBCI.parse(iArr);
        } else if (i == 2) {
            this.packageParserIsrael.parse(iArr);
        } else {
            Gson$$ExternalSyntheticBUOutline0.m("Invalid protocol: ", protocol2);
        }
    }
}
