package com.polar.androidcommunications.common.ble;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.polar.androidcommunications.api.ble.BleLogger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\tR&\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/polar/androidcommunications/common/ble/PhoneUtils;", "", "<init>", "()V", "", "brand", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "isMtuNegotiationBroken", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "Lkotlin/Pair;", "phonesWithMtuNegotiationProblem", "Ljava/util/List;", "library_sdkRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class PhoneUtils {
    public static final PhoneUtils INSTANCE = new PhoneUtils();
    private static final List<Pair<String, String>> phonesWithMtuNegotiationProblem = CollectionsKt.listOf((Object[]) new Pair[]{new Pair("Motorola", "moto g20"), new Pair("Motorola", "moto e20"), new Pair("Motorola", "moto e30"), new Pair("Motorola", "moto e32"), new Pair("Motorola", "moto e40"), new Pair("Nokia", "Nokia G21"), new Pair("Nokia", "Nokia G11"), new Pair("Nokia", "Nokia T20"), new Pair("Realme", "RMX3261"), new Pair("Realme", "RMX3262"), new Pair("Realme", "RMX3265"), new Pair("Realme", "RMX3269"), new Pair("Realme", "RMX3624"), new Pair("Realme", "RMX3760"), new Pair("Realme", "RMP2105"), new Pair("Realme", "RMP2106"), new Pair("Infinix", "Infinix X675"), new Pair("HTC", "Wildfire E2 plus"), new Pair("Micromax", "IN_2b"), new Pair("Micromax", "IN_2c"), new Pair("Samsung", "SM-X200")});

    private PhoneUtils() {
    }

    public static final boolean isMtuNegotiationBroken(String brand, String model) {
        brand.getClass();
        model.getClass();
        String strReplace$default = StringsKt.replace$default(StringsKt.replace$default(model, "(", ""), ")", "");
        List<Pair<String, String>> list = phonesWithMtuNegotiationProblem;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            if (StringsKt__StringsJVMKt.equals((String) pair.getFirst(), brand, true) && StringsKt__StringsJVMKt.equals((String) pair.getSecond(), strReplace$default, true)) {
                BleLogger.INSTANCE.d("PhoneUtils", Fragment$$ExternalSyntheticOutline1.m("MTU problematic phone detected. Manufacturer: ", brand, " Model: ", model));
                return true;
            }
        }
        return false;
    }
}
