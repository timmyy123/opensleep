package io.github.zeroone3010.yahueapi.v2;

import io.github.zeroone3010.yahueapi.v2.domain.GroupedLightResource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import io.github.zeroone3010.yahueapi.v2.domain.update.On;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class GroupImpl implements Group {
    private static final Logger logger = LoggerFactory.getLogger("io.github.zeroone3010.yahueapi");
    private UUID id;
    private Supplier<Collection<Light>> lights;
    private final Function<Collection<Light>, String> lightsSetter;
    private String name;
    private List<Scene> scenes;
    private Supplier<GroupedLightResource> stateProvider;
    private final Function<UpdateLight, String> stateSetter;
    private ResourceType type;

    public GroupImpl(UUID uuid, ResourceType resourceType, String str, List<Scene> list, Supplier<Collection<Light>> supplier, Supplier<GroupedLightResource> supplier2, Function<UpdateLight, String> function, Function<Collection<Light>, String> function2) {
        this.id = uuid;
        this.type = resourceType;
        this.name = str;
        this.scenes = list;
        this.lights = supplier;
        this.stateProvider = supplier2;
        this.stateSetter = function;
        this.lightsSetter = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getLightByName$1(String str, Light light) {
        return Objects.equals(light.getName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getSceneByName$0(String str, Scene scene) {
        return Objects.equals(scene.getName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeLight$2(Light light, Light light2) {
        return Objects.equals(light.getId(), light2.getId());
    }

    private void setState(UpdateLight updateLight) {
        logger.info("Group update result: {}", this.stateSetter.apply(updateLight));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public Collection<Light> addLight(Light light) {
        HashSet hashSet = new HashSet();
        hashSet.addAll(getLights());
        if (hashSet.add(light)) {
            this.lightsSetter.apply(hashSet);
        }
        return getLights();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public UUID getId() {
        return this.id;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public Optional<Light> getLightByName(String str) {
        return this.lights.get().stream().filter(new Hue$$ExternalSyntheticLambda31(str, 3)).findFirst();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public Collection<Light> getLights() {
        return this.lights.get();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public String getName() {
        return this.name;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public Optional<Scene> getSceneByName(String str) {
        return this.scenes.stream().filter(new Hue$$ExternalSyntheticLambda31(str, 2)).findFirst();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public List<Scene> getScenes() {
        return this.scenes;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public ResourceType getType() {
        return this.type;
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public boolean isAnyOn() {
        return this.stateProvider.get().getOn().isOn();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public Collection<Light> removeLight(Light light) {
        HashSet hashSet = new HashSet(getLights());
        if (hashSet.removeIf(new GroupImpl$$ExternalSyntheticLambda0(light, 0))) {
            this.lightsSetter.apply(hashSet);
        }
        return getLights();
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public void setBrightness(int i) {
        setState(new UpdateState().brightness(i).getUpdateLight());
    }

    public String toString() {
        return "GroupImpl{id=" + this.id + ", name='" + this.name + "', lights=" + this.lights.get() + '}';
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public void turnOff() {
        this.stateSetter.apply(new UpdateLight().setOn(On.OFF));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public void turnOn() {
        this.stateSetter.apply(new UpdateLight().setOn(On.ON));
    }

    @Override // io.github.zeroone3010.yahueapi.v2.Group
    public void setState(UpdateState updateState) {
        setState(updateState.getUpdateLight());
    }
}
