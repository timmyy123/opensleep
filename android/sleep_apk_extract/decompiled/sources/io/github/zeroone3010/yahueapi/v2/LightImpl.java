package io.github.zeroone3010.yahueapi.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.v2.domain.LightResource;
import io.github.zeroone3010.yahueapi.v2.domain.update.EffectType;
import io.github.zeroone3010.yahueapi.v2.domain.update.On;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class LightImpl implements Light {
    private static final Logger logger = LoggerFactory.getLogger("io.github.zeroone3010.yahueapi");
    private final UUID id;
    private final String idV1;
    private final String name;
    private final UUID ownerId;
    private final Supplier<LightResource> stateProvider;
    private final Function<UpdateLight, String> stateSetter;

    public LightImpl(UUID uuid, LightResource lightResource, Supplier<LightResource> supplier, Function<UpdateLight, String> function) {
        this.id = uuid;
        if (lightResource == null) {
            throw new HueApiException("Light " + uuid + " cannot be found.");
        }
        this.name = lightResource.getMetadata().getName();
        this.stateProvider = supplier;
        this.stateSetter = function;
        this.ownerId = lightResource.getOwner().getResourceId();
        this.idV1 = lightResource.getIdV1();
    }

    private LightResource getLightState() {
        LightResource lightResource = this.stateProvider.get();
        logger.trace(lightResource.toString());
        return lightResource;
    }

    private void setState(UpdateLight updateLight) {
        logger.info("Update result: {}", this.stateSetter.apply(updateLight));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light, io.github.zeroone3010.yahueapi.v2.Device
    public UUID getId() {
        return this.id;
    }

    public String getIdV1() {
        return this.idV1;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light, io.github.zeroone3010.yahueapi.v2.Device
    public String getName() {
        return this.name;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public UUID getOwnerId() {
        return this.ownerId;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public Collection<EffectType> getSupportedEffects() {
        return (Collection) Optional.ofNullable(this.stateProvider.get().getEffects()).map(new Hue$$ExternalSyntheticLambda4(12)).orElse(Collections.EMPTY_LIST);
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public boolean isOn() {
        return getLightState().getOn().isOn();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public void setBrightness(int i) {
        setState(new UpdateState().brightness(i).getUpdateLight());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Light{id='");
        sb.append(this.id);
        sb.append("', name='");
        return FileInsert$$ExternalSyntheticOutline0.m(sb, this.name, "'}");
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public void turnOff() {
        this.stateSetter.apply(new UpdateLight().setOn(On.OFF));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public void turnOn() {
        this.stateSetter.apply(new UpdateLight().setOn(On.ON));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Light
    public void setState(UpdateState updateState) {
        setState(updateState.getUpdateLight());
    }
}
