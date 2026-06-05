package io.github.zeroone3010.yahueapi;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.polar.androidcommunications.api.ble.model.DisInfo;
import com.polar.androidcommunications.api.ble.model.gatt.client.BleDisClient;
import com.urbandroid.sleep.addon.stats.model.StatRecord;
import io.github.zeroone3010.yahueapi.v2.ButtonEventType;
import io.github.zeroone3010.yahueapi.v2.GroupFactory;
import io.github.zeroone3010.yahueapi.v2.GroupImpl;
import io.github.zeroone3010.yahueapi.v2.Hue;
import io.github.zeroone3010.yahueapi.v2.Light;
import io.github.zeroone3010.yahueapi.v2.LightImpl;
import io.github.zeroone3010.yahueapi.v2.TemperatureSensorImpl;
import io.github.zeroone3010.yahueapi.v2.domain.BridgeResource;
import io.github.zeroone3010.yahueapi.v2.domain.ButtonSpecifics;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.Resource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import java.net.URL;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Color$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Color$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Color.lambda$of$1((String) obj);
            case 1:
                return ((AnnotatedMethod) obj).getFullName();
            case 2:
                return BleDisClient.lambda$observeDisInfoWithKeysAsStrings$6((DisInfo) obj);
            case 3:
                return ((DisInfo) obj).getKey();
            case 4:
                return UUID.fromString((String) obj);
            case 5:
                return ((StatRecord) obj).getToDate();
            case 6:
                return Color.lambda$of$3((String) obj);
            case 7:
                return Color.lambda$of$4((Integer) obj);
            case 8:
                return ((ButtonSpecifics) obj).getLastEvent();
            case 9:
                return ButtonEventType.parseFromButtonEventType((String) obj);
            case 10:
                return ((Light) obj).getOwnerId();
            case 11:
                return ((Resource) obj).identifier();
            case 12:
                return GroupFactory.lambda$buildGroup$1((Resource) obj);
            case 13:
                return GroupFactory.lambda$buildGroup$2((DeviceResource) obj);
            case 14:
                return ((ResourceIdentifier) obj).getResourceId();
            case 15:
                return GroupFactory.lambda$resolveUrlPath$17((UUID) obj);
            case 16:
                return GroupFactory.lambda$buildGroup$9((Resource) obj);
            case 17:
                return io.github.zeroone3010.yahueapi.v2.HttpUtil.getAnonymousUrlConnection((URL) obj);
            case 18:
                return ((Resource) obj).getId();
            case 19:
                return Hue.lambda$refresh$1((Resource) obj);
            case 20:
                return ((TemperatureSensorImpl) obj).getId();
            case 21:
                return Hue.lambda$refresh$18((TemperatureSensorImpl) obj);
            case 22:
                return Hue.lambda$refresh$20((Resource) obj);
            case 23:
                return ((GroupImpl) obj).getId();
            case 24:
                return Hue.lambda$refresh$21((GroupImpl) obj);
            case 25:
                return Hue.lambda$refresh$8((Resource) obj);
            case 26:
                return Hue.lambda$refresh$23((Resource) obj);
            case 27:
                return ((BridgeResource) obj).getBridgeId();
            case 28:
                return Hue.lambda$refresh$3((Resource) obj);
            default:
                return ((LightImpl) obj).getId();
        }
    }
}
