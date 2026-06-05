package com.polar.androidcommunications.api.ble.model.polar;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004¨\u0006\t"}, d2 = {"Lcom/polar/androidcommunications/api/ble/model/polar/PolarAdvDataUtility;", "", "()V", "getPolarModelNameFromAdvLocalName", "", "advLocalName", "isPolarDevice", "", "name", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PolarAdvDataUtility {
    public static final PolarAdvDataUtility INSTANCE = new PolarAdvDataUtility();

    private PolarAdvDataUtility() {
    }

    public final String getPolarModelNameFromAdvLocalName(String advLocalName) {
        advLocalName.getClass();
        if (!isPolarDevice(advLocalName)) {
            return "";
        }
        String strReplaceFirst$default = StringsKt__StringsJVMKt.replaceFirst$default(StringsKt.trim(advLocalName).toString(), "Polar ", "", false, 4, null);
        return strReplaceFirst$default.substring(0, StringsKt__StringsKt.lastIndexOf$default((CharSequence) strReplaceFirst$default, " ", 0, false, 6, (Object) null));
    }

    public final boolean isPolarDevice(String name) {
        name.getClass();
        return StringsKt.startsWith$default(StringsKt.trim(name).toString(), "Polar") && StringsKt.split$default(StringsKt.trim(name).toString(), new String[]{" "}, 0, 6).size() > 2;
    }
}
