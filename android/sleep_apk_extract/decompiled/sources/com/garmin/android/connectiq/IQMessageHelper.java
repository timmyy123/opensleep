package com.garmin.android.connectiq;

import com.garmin.monkeybrains.serialization.MonkeyArray;
import com.garmin.monkeybrains.serialization.MonkeyByteArray;
import com.garmin.monkeybrains.serialization.MonkeyHash;
import com.garmin.monkeybrains.serialization.MonkeyType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/garmin/android/connectiq/IQMessageHelper;", "", "<init>", "()V", "Lcom/garmin/monkeybrains/serialization/MonkeyType;", "object", "convertToJava", "(Lcom/garmin/monkeybrains/serialization/MonkeyType;)Ljava/lang/Object;", "connectiq-companion-app-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class IQMessageHelper {
    public static final IQMessageHelper INSTANCE = new IQMessageHelper();

    private IQMessageHelper() {
    }

    public final Object convertToJava(MonkeyType<?> object) {
        object.getClass();
        byte b = object.mType;
        if (b == 0) {
            return null;
        }
        if (b == 1 || b == 14 || b == 2 || b == 15 || b == 3 || b == 9 || b == 19) {
            return object.toJava();
        }
        if (b == 5) {
            List<MonkeyType<?>> java = ((MonkeyArray) object).toJava();
            ArrayList arrayList = new ArrayList();
            for (MonkeyType<?> monkeyType : java) {
                monkeyType.getClass();
                arrayList.add(convertToJava(monkeyType));
            }
            return arrayList;
        }
        if (b != 11) {
            if (b == 20) {
                return new ArrayList(((MonkeyByteArray) object).toJava());
            }
            return null;
        }
        HashMap<MonkeyType<?>, MonkeyType<?>> java2 = ((MonkeyHash) object).toJava();
        HashMap map = new HashMap();
        for (MonkeyType<?> monkeyType2 : java2.keySet()) {
            monkeyType2.getClass();
            Object objConvertToJava = convertToJava(monkeyType2);
            MonkeyType<?> monkeyType3 = java2.get(monkeyType2);
            monkeyType3.getClass();
            map.put(objConvertToJava, convertToJava(monkeyType3));
        }
        return map;
    }
}
