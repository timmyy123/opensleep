package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/* JADX INFO: loaded from: classes5.dex */
public interface Group {
    Collection<Light> addLight(Light light);

    UUID getId();

    Optional<Light> getLightByName(String str);

    Collection<Light> getLights();

    String getName();

    Optional<Scene> getSceneByName(String str);

    List<Scene> getScenes();

    ResourceType getType();

    boolean isAnyOn();

    Collection<Light> removeLight(Light light);

    void setBrightness(int i);

    void setState(UpdateState updateState);

    void turnOff();

    void turnOn();
}
