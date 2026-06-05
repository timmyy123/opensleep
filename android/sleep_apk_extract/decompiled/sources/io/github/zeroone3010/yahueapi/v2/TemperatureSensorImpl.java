package io.github.zeroone3010.yahueapi.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.github.zeroone3010.yahueapi.v2.domain.Temperature;
import j$.time.ZonedDateTime;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class TemperatureSensorImpl implements TemperatureSensor {
    private static final int SCALE = 2;
    private final UUID id;
    private final String name;
    private final Supplier<Temperature> stateProvider;
    private static final BigDecimal ONE_POINT_EIGHT = new BigDecimal("1.8");
    private static final BigDecimal THIRTY_TWO = new BigDecimal("32");

    public TemperatureSensorImpl(UUID uuid, String str, Supplier<Temperature> supplier) {
        this.id = uuid;
        this.name = str;
        this.stateProvider = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigDecimal lambda$getDegreesCelsius$0(BigDecimal bigDecimal) {
        return bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BigDecimal lambda$getDegreesFahrenheit$1(BigDecimal bigDecimal) {
        return bigDecimal.multiply(ONE_POINT_EIGHT).add(THIRTY_TWO).setScale(2, RoundingMode.HALF_UP);
    }

    @Override // io.github.zeroone3010.yahueapi.v2.TemperatureSensor
    public BigDecimal getDegreesCelsius() {
        return (BigDecimal) Optional.ofNullable(this.stateProvider.get().getTemperature()).map(new Hue$$ExternalSyntheticLambda4(19)).orElse(null);
    }

    @Override // io.github.zeroone3010.yahueapi.v2.TemperatureSensor
    public BigDecimal getDegreesFahrenheit() {
        return (BigDecimal) Optional.ofNullable(this.stateProvider.get().getTemperature()).map(new Hue$$ExternalSyntheticLambda4(22)).orElse(null);
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    public UUID getId() {
        return this.id;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.TemperatureSensor
    public ZonedDateTime getLastChanged() {
        return (ZonedDateTime) Optional.ofNullable(this.stateProvider.get()).map(new Hue$$ExternalSyntheticLambda4(20)).map(new Hue$$ExternalSyntheticLambda4(21)).map(new Hue$$ExternalSyntheticLambda4(16)).orElse(null);
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MotionSensorImpl{id=");
        sb.append(this.id);
        sb.append(", name='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, "'}");
    }
}
