package io.github.zeroone3010.yahueapi.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.github.zeroone3010.yahueapi.v2.domain.Motion;
import j$.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class MotionSensorImpl implements MotionSensor {
    private final UUID id;
    private final String name;
    private final Supplier<Motion> stateProvider;

    public MotionSensorImpl(UUID uuid, String str, Supplier<Motion> supplier) {
        this.id = uuid;
        this.name = str;
        this.stateProvider = supplier;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    public UUID getId() {
        return this.id;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.MotionSensor
    public ZonedDateTime getLastChanged() {
        return (ZonedDateTime) Optional.ofNullable(this.stateProvider.get()).map(new Hue$$ExternalSyntheticLambda4(14)).map(new Hue$$ExternalSyntheticLambda4(15)).map(new Hue$$ExternalSyntheticLambda4(16)).orElse(null);
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    public String getName() {
        return this.name;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.MotionSensor
    public boolean isMotion() {
        return this.stateProvider.get().isMotion();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MotionSensorImpl{id=");
        sb.append(this.id);
        sb.append(", name='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, "'}");
    }
}
