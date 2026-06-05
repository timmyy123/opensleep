package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.Color;
import io.github.zeroone3010.yahueapi.v2.domain.ButtonResource;
import io.github.zeroone3010.yahueapi.v2.domain.Effects;
import io.github.zeroone3010.yahueapi.v2.domain.Motion;
import io.github.zeroone3010.yahueapi.v2.domain.MotionReport;
import io.github.zeroone3010.yahueapi.v2.domain.Resource;
import io.github.zeroone3010.yahueapi.v2.domain.Temperature;
import io.github.zeroone3010.yahueapi.v2.domain.TemperatureReport;
import j$.time.Duration;
import j$.time.ZonedDateTime;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.Function;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class Hue$$ExternalSyntheticLambda4 implements Function {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ Hue$$ExternalSyntheticLambda4(int i) {
        this.$r8$classId = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        switch (this.$r8$classId) {
            case 0:
                return ((Switch) obj).getId();
            case 1:
                return Hue.lambda$refresh$4((LightImpl) obj);
            case 2:
                return Hue.lambda$refresh$6((Resource) obj);
            case 3:
                return ((Group) obj).getId();
            case 4:
                return Hue.lambda$getZones$31((Group) obj);
            case 5:
                return ((ButtonResource) obj).getId();
            case 6:
                return Hue.lambda$buildSwitch$25((ButtonResource) obj);
            case 7:
                return Hue.lambda$getRooms$29((Group) obj);
            case 8:
                return Hue.lambda$getDevices$27((Resource) obj);
            case 9:
                return Hue.lambda$refresh$10((Switch) obj);
            case 10:
                return ((MotionSensorImpl) obj).getId();
            case 11:
                return Hue.lambda$refresh$14((MotionSensorImpl) obj);
            case 12:
                return ((Effects) obj).getEffectValues();
            case 13:
                return ((UUID) obj).toString();
            case 14:
                return ((Motion) obj).getMotionReport();
            case 15:
                return ((MotionReport) obj).getChanged();
            case 16:
                return ZonedDateTime.parse((String) obj);
            case 17:
                return ((ButtonImpl) obj).getId();
            case 18:
                return SwitchFactory.lambda$buildSwitch$2((ButtonImpl) obj);
            case 19:
                return TemperatureSensorImpl.lambda$getDegreesCelsius$0((BigDecimal) obj);
            case 20:
                return ((Temperature) obj).getTemperatureReport();
            case 21:
                return ((TemperatureReport) obj).getChanged();
            case 22:
                return TemperatureSensorImpl.lambda$getDegreesFahrenheit$1((BigDecimal) obj);
            case 23:
                return UpdateState.lambda$gradient$0((Color) obj);
            case 24:
                return UpdateState.lambda$gradient$1((io.github.zeroone3010.yahueapi.v2.domain.update.Color) obj);
            default:
                return Long.valueOf(((Duration) obj).toMillis());
        }
    }
}
