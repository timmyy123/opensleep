package io.github.zeroone3010.yahueapi;

import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import com.fasterxml.jackson.databind.introspect.AnnotatedAndMetadata;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import io.github.zeroone3010.yahueapi.v2.BasicHueEventHandler;
import io.github.zeroone3010.yahueapi.v2.Button;
import io.github.zeroone3010.yahueapi.v2.Group;
import io.github.zeroone3010.yahueapi.v2.GroupFactory;
import io.github.zeroone3010.yahueapi.v2.Hue;
import io.github.zeroone3010.yahueapi.v2.MotionSensorFactory;
import io.github.zeroone3010.yahueapi.v2.Switch;
import io.github.zeroone3010.yahueapi.v2.SwitchFactory;
import io.github.zeroone3010.yahueapi.v2.SwitchImpl;
import io.github.zeroone3010.yahueapi.v2.TemperatureSensorFactory;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.HueEventData;
import io.github.zeroone3010.yahueapi.v2.domain.Resource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Color$$ExternalSyntheticLambda1 implements Predicate {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Color$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return Color.lambda$of$2((String) obj);
            case 1:
                return StdKeyDeserializers.lambda$findStringBasedKeyDeserializer$0((AnnotatedAndMetadata) obj);
            case 2:
                return BeanSerializerFactory.lambda$removeSetterlessGetters$0((BeanPropertyDefinition) obj);
            case 3:
                return Color.lambda$new$0((Float) obj);
            case 4:
                return BasicHueEventHandler.lambda$parseAndAnnounceButtonEvents$0((HueEventData) obj);
            case 5:
                return BasicHueEventHandler.lambda$parseAndAnnounceButtonEvents$3((HueEventData) obj);
            case 6:
                return GroupFactory.lambda$resolveUrlPath$16((ResourceIdentifier) obj);
            case 7:
                return GroupFactory.lambda$buildGroup$0((ResourceIdentifier) obj);
            case 8:
                return GroupFactory.lambda$buildGroup$3((ResourceIdentifier) obj);
            case 9:
                return GroupFactory.lambda$buildGroup$5((ResourceIdentifier) obj);
            case 10:
                return GroupFactory.lambda$buildGroup$8((Resource) obj);
            case 11:
                return Hue.lambda$refresh$16((DeviceResource) obj);
            case 12:
                return Hue.lambda$refresh$19((Resource) obj);
            case 13:
                return Hue.lambda$refresh$22((Resource) obj);
            case 14:
                return Hue.lambda$refresh$2((Resource) obj);
            case 15:
                return Hue.lambda$refresh$5((Resource) obj);
            case 16:
                return Hue.lambda$refresh$7((Resource) obj);
            case 17:
                return Hue.lambda$getZones$30((Group) obj);
            case 18:
                return Hue.lambda$getRooms$28((Group) obj);
            case 19:
                return Objects.nonNull((Switch) obj);
            case 20:
                return Hue.lambda$refresh$15((ResourceIdentifier) obj);
            case 21:
                return Hue.lambda$refresh$11((ResourceIdentifier) obj);
            case 22:
                return Hue.lambda$getDevices$26((Resource) obj);
            case 23:
                return Hue.lambda$refresh$12((DeviceResource) obj);
            case 24:
                return MotionSensorFactory.lambda$buildMotionSensor$0((ResourceIdentifier) obj);
            case 25:
                return SwitchFactory.lambda$static$0((ResourceIdentifier) obj);
            case 26:
                return SwitchImpl.lambda$getLatestPressedButton$0((Button) obj);
            default:
                return TemperatureSensorFactory.lambda$buildTemperatureSensor$0((ResourceIdentifier) obj);
        }
    }
}
