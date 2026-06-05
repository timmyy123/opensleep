package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.update.EffectType;
import java.util.Collection;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public interface Light extends Device {
    @Override // io.github.zeroone3010.yahueapi.v2.Device
    UUID getId();

    @Override // io.github.zeroone3010.yahueapi.v2.Device
    String getName();

    UUID getOwnerId();

    Collection<EffectType> getSupportedEffects();

    boolean isOn();

    void setBrightness(int i);

    void setState(UpdateState updateState);

    void turnOff();

    void turnOn();
}
