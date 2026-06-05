package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.v2.domain.ButtonResource;
import io.github.zeroone3010.yahueapi.v2.domain.ButtonResourceRoot;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes5.dex */
public class SwitchFactory {
    private static final Predicate<ResourceIdentifier> BUTTON_FILTER = new Color$$ExternalSyntheticLambda1(25);
    private final Hue hue;
    private final ObjectMapper objectMapper;

    public SwitchFactory(Hue hue, ObjectMapper objectMapper) {
        this.hue = hue;
        this.objectMapper = objectMapper;
    }

    private Supplier<ButtonResource> createButtonStateProvider(UUID uuid) {
        return new LightFactory$$ExternalSyntheticLambda1(this, uuid, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ButtonImpl lambda$buildSwitch$1(ButtonResource buttonResource) {
        return new ButtonImpl(createButtonStateProvider(buttonResource.getId()), buttonResource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Button lambda$buildSwitch$2(ButtonImpl buttonImpl) {
        return buttonImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$buildSwitch$3(SwitchImpl switchImpl, Button button) {
        ((ButtonImpl) button).setOwner(switchImpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ButtonResource lambda$createButtonStateProvider$4(UUID uuid) {
        try {
            InputStream inputStream = this.hue.getUrlConnection("/button/" + uuid.toString()).getInputStream();
            try {
                ButtonResource buttonResource = ((ButtonResourceRoot) this.objectMapper.readValue(inputStream, ButtonResourceRoot.class)).getData().get(0);
                if (inputStream != null) {
                    inputStream.close();
                }
                return buttonResource;
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(ResourceIdentifier resourceIdentifier) {
        return ResourceType.BUTTON == resourceIdentifier.getResourceType();
    }

    public SwitchImpl buildSwitch(DeviceResource deviceResource, final Map<UUID, ButtonResource> map) {
        Stream<ResourceIdentifier> stream = deviceResource.getServices().stream();
        Predicate<ResourceIdentifier> predicate = BUTTON_FILTER;
        if (stream.noneMatch(predicate)) {
            return null;
        }
        Stream<R> map2 = deviceResource.getServices().stream().filter(predicate).map(new Color$$ExternalSyntheticLambda0(14));
        Objects.requireNonNull(map);
        final int i = 0;
        final int i2 = 1;
        Map map3 = (Map) map2.map(new Function() { // from class: io.github.zeroone3010.yahueapi.v2.SwitchFactory$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i3 = i;
                Object obj2 = map;
                switch (i3) {
                    case 0:
                        return (ButtonResource) ((Map) obj2).get((UUID) obj);
                    default:
                        return ((SwitchFactory) obj2).lambda$buildSwitch$1((ButtonResource) obj);
                }
            }
        }).map(new Function() { // from class: io.github.zeroone3010.yahueapi.v2.SwitchFactory$$ExternalSyntheticLambda1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i3 = i2;
                Object obj2 = this;
                switch (i3) {
                    case 0:
                        return (ButtonResource) ((Map) obj2).get((UUID) obj);
                    default:
                        return ((SwitchFactory) obj2).lambda$buildSwitch$1((ButtonResource) obj);
                }
            }
        }).collect(Collectors.toMap(new Hue$$ExternalSyntheticLambda4(17), new Hue$$ExternalSyntheticLambda4(18)));
        SwitchImpl switchImpl = new SwitchImpl(deviceResource.getId(), map3, deviceResource.getMetadata().getName());
        map3.values().forEach(new SwitchFactory$$ExternalSyntheticLambda5(switchImpl, i));
        return switchImpl;
    }
}
