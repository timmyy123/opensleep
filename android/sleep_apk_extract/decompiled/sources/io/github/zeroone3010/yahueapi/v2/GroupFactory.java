package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.GroupResource;
import io.github.zeroone3010.yahueapi.v2.domain.GroupedLightResource;
import io.github.zeroone3010.yahueapi.v2.domain.GroupedLightResourceRoot;
import io.github.zeroone3010.yahueapi.v2.domain.Resource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import io.github.zeroone3010.yahueapi.v2.domain.SceneResource;
import io.github.zeroone3010.yahueapi.v2.domain.update.SceneActivation;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateRoom;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class GroupFactory {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) GroupFactory.class);
    private final Hue hue;
    private final ObjectMapper objectMapper;

    public GroupFactory(Hue hue, ObjectMapper objectMapper) {
        this.hue = hue;
        this.objectMapper = objectMapper;
    }

    private Supplier<GroupedLightResource> createStateProvider(GroupResource groupResource) {
        return new GroupFactory$$ExternalSyntheticLambda4(this, groupResource, 0);
    }

    private Function<Collection<Light>, String> groupLightsSetter(GroupResource groupResource) {
        return new GroupFactory$$ExternalSyntheticLambda3(this, groupResource, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildGroup$0(ResourceIdentifier resourceIdentifier) {
        return resourceIdentifier.getResourceType() == ResourceType.DEVICE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DeviceResource lambda$buildGroup$1(Resource resource) {
        return (DeviceResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildGroup$10(GroupResource groupResource, SceneResource sceneResource) {
        return Objects.equals(groupResource.getId(), sceneResource.getGroup().getResourceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SceneImpl lambda$buildGroup$11(SceneResource sceneResource) {
        return new SceneImpl(sceneResource.getId(), sceneResource.getMetadata().getName(), sceneStateSetter(sceneResource.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$buildGroup$2(DeviceResource deviceResource) {
        return deviceResource.getServices().stream();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildGroup$3(ResourceIdentifier resourceIdentifier) {
        return resourceIdentifier.getResourceType() == ResourceType.LIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Light lambda$buildGroup$4(ResourceIdentifier resourceIdentifier) {
        return this.hue.getLights().get(resourceIdentifier.getResourceId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildGroup$5(ResourceIdentifier resourceIdentifier) {
        return resourceIdentifier.getResourceType() == ResourceType.LIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Light lambda$buildGroup$6(UUID uuid) {
        return this.hue.getLights().get(uuid);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Collection lambda$buildGroup$7(GroupResource groupResource) {
        int i = 14;
        Stream<R> map = groupResource.getChildren().stream().filter(new Color$$ExternalSyntheticLambda1(7)).map(new Color$$ExternalSyntheticLambda0(i));
        Hue hue = this.hue;
        Objects.requireNonNull(hue);
        int i2 = 1;
        Set set = (Set) map.map(new Hue$$ExternalSyntheticLambda7(hue, i2)).map(new Color$$ExternalSyntheticLambda0(12)).flatMap(new Color$$ExternalSyntheticLambda0(13)).filter(new Color$$ExternalSyntheticLambda1(8)).map(new GroupFactory$$ExternalSyntheticLambda9(this, i2)).collect(Collectors.toSet());
        Set set2 = (Set) groupResource.getChildren().stream().filter(new Color$$ExternalSyntheticLambda1(9)).map(new Color$$ExternalSyntheticLambda0(i)).map(new GroupFactory$$ExternalSyntheticLambda9(this, 2)).collect(Collectors.toSet());
        HashSet hashSet = new HashSet(set);
        hashSet.addAll(set2);
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildGroup$8(Resource resource) {
        return resource.getType() == ResourceType.SCENE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SceneResource lambda$buildGroup$9(Resource resource) {
        return (SceneResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ GroupedLightResource lambda$createStateProvider$13(GroupResource groupResource) {
        try {
            InputStream inputStream = this.hue.getUrlConnection(resolveUrlPath(groupResource)).getInputStream();
            try {
                GroupedLightResource groupedLightResource = ((GroupedLightResourceRoot) this.objectMapper.readValue(inputStream, GroupedLightResourceRoot.class)).getData().get(0);
                if (inputStream != null) {
                    inputStream.close();
                }
                return groupedLightResource;
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$groupLightsSetter$14(GroupResource groupResource, Collection collection) {
        UpdateRoom updateRoom = new UpdateRoom();
        Stream map = collection.stream().map(new Color$$ExternalSyntheticLambda0(10));
        Hue hue = this.hue;
        Objects.requireNonNull(hue);
        updateRoom.setChildren((List) map.map(new Hue$$ExternalSyntheticLambda7(hue, 1)).map(new Color$$ExternalSyntheticLambda0(11)).collect(Collectors.toList()));
        try {
            String strResolveRoomUrlPath = resolveRoomUrlPath(groupResource);
            String strWriteValueAsString = this.objectMapper.writeValueAsString(updateRoom);
            Hue hue2 = this.hue;
            return HttpUtil.put(hue2, hue2.getResourceUrl(), strResolveRoomUrlPath, strWriteValueAsString);
        } catch (JsonProcessingException e) {
            throw new HueApiException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$resolveUrlPath$16(ResourceIdentifier resourceIdentifier) {
        return resourceIdentifier.getResourceType() == ResourceType.GROUPED_LIGHT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$resolveUrlPath$17(UUID uuid) {
        return "/grouped_light/" + uuid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$sceneStateSetter$12(UUID uuid) {
        try {
            String strResolveUrlPath = resolveUrlPath(uuid);
            String strWriteValueAsString = this.objectMapper.writeValueAsString(new SceneActivation());
            Hue hue = this.hue;
            return HttpUtil.put(hue, hue.getResourceUrl(), strResolveUrlPath, strWriteValueAsString);
        } catch (Exception e) {
            throw new HueApiException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$stateSetter$15(GroupResource groupResource, UpdateLight updateLight) {
        String strResolveUrlPath = resolveUrlPath(groupResource);
        try {
            String strWriteValueAsString = this.objectMapper.writeValueAsString(updateLight);
            Hue hue = this.hue;
            return HttpUtil.put(hue, hue.getResourceUrl(), strResolveUrlPath, strWriteValueAsString);
        } catch (Exception e) {
            throw new HueApiException(e);
        }
    }

    private String resolveRoomUrlPath(GroupResource groupResource) {
        return "/room/" + groupResource.getId();
    }

    private static String resolveUrlPath(GroupResource groupResource) {
        return (String) groupResource.getServices().stream().filter(new Color$$ExternalSyntheticLambda1(6)).map(new Color$$ExternalSyntheticLambda0(14)).findFirst().map(new Color$$ExternalSyntheticLambda0(15)).orElse(null);
    }

    private Supplier<String> sceneStateSetter(UUID uuid) {
        return new LightFactory$$ExternalSyntheticLambda1(this, uuid, 2);
    }

    private Function<UpdateLight, String> stateSetter(GroupResource groupResource) {
        return new GroupFactory$$ExternalSyntheticLambda3(this, groupResource, 0);
    }

    public GroupImpl buildGroup(GroupResource groupResource, Map<UUID, Resource> map) {
        GroupFactory$$ExternalSyntheticLambda4 groupFactory$$ExternalSyntheticLambda4 = new GroupFactory$$ExternalSyntheticLambda4(this, groupResource, 1);
        return new GroupImpl(groupResource.getId(), groupResource.getType(), groupResource.getMetadata().getName(), (List) map.values().stream().filter(new Color$$ExternalSyntheticLambda1(10)).map(new Color$$ExternalSyntheticLambda0(16)).filter(new GroupImpl$$ExternalSyntheticLambda0(groupResource, 2)).map(new GroupFactory$$ExternalSyntheticLambda9(this, 0)).collect(Collectors.toList()), groupFactory$$ExternalSyntheticLambda4, createStateProvider(groupResource), stateSetter(groupResource), groupLightsSetter(groupResource));
    }

    private static String resolveUrlPath(UUID uuid) {
        return "/scene/" + uuid;
    }
}
