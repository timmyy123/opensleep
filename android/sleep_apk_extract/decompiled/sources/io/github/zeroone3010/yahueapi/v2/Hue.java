package io.github.zeroone3010.yahueapi.v2;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.integrity.IntegrityManager;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.launchdarkly.eventsource.ConnectStrategy;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.HttpConnectStrategy;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.HueBridgeConnectionBuilder;
import io.github.zeroone3010.yahueapi.SecureJsonFactory;
import io.github.zeroone3010.yahueapi.v2.domain.BridgeResource;
import io.github.zeroone3010.yahueapi.v2.domain.ButtonResource;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.GroupResource;
import io.github.zeroone3010.yahueapi.v2.domain.LightResource;
import io.github.zeroone3010.yahueapi.v2.domain.Resource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceRoot;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import io.github.zeroone3010.yahueapi.v2.domain.RoomResource;
import io.github.zeroone3010.yahueapi.v2.domain.ZoneResource;
import j$.time.Duration;
import j$.time.ZonedDateTime;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class Hue {
    public static final long EVENTS_CONNECTION_TIMEOUT_MINUTES = 1;
    private static final int EXPECTED_NEW_LIGHTS_SEARCH_TIME_IN_SECONDS = 50;
    public static final String HUE_APPLICATION_KEY_HEADER = "hue-application-key";
    private Map<UUID, Resource> allResources;
    private final String apiKey;
    private String bridgeId;
    private final String bridgeIp;
    private final URL eventUrl;
    private final GroupFactory groupFactory;
    private Map<UUID, Group> groups;
    private final LightFactory lightFactory;
    private Map<UUID, Light> lights;
    private final MotionSensorFactory motionSensorFactory;
    private Map<UUID, MotionSensor> motionSensors;
    final ObjectMapper objectMapper;
    private final URL resourceUrl;
    private final SwitchFactory switchFactory;
    private Map<UUID, Switch> switches;
    private final TemperatureSensorFactory temperatureSensorFactory;
    private Map<UUID, TemperatureSensor> temperatureSensors;
    private static final Logger logger = LoggerFactory.getLogger("io.github.zeroone3010.yahueapi");
    public static final Duration EVENTS_READ_TIMEOUT = Duration.ofMillis(2147483647L);

    public Hue(String str, String str2) {
        this.bridgeIp = str;
        try {
            this.resourceUrl = new URL("https://" + str + "/clip/v2/resource");
            try {
                this.eventUrl = new URL("https://" + str + "/eventstream/clip/v2");
                this.apiKey = str2;
                ObjectMapper objectMapperBuildObjectMapper = HttpUtil.buildObjectMapper(str);
                this.objectMapper = objectMapperBuildObjectMapper;
                this.lightFactory = new LightFactory(this, objectMapperBuildObjectMapper);
                this.switchFactory = new SwitchFactory(this, objectMapperBuildObjectMapper);
                this.groupFactory = new GroupFactory(this, objectMapperBuildObjectMapper);
                this.motionSensorFactory = new MotionSensorFactory(this, objectMapperBuildObjectMapper);
                this.temperatureSensorFactory = new TemperatureSensorFactory(this, objectMapperBuildObjectMapper);
                refresh();
            } catch (MalformedURLException e) {
                throw new HueApiException(e);
            }
        } catch (MalformedURLException e2) {
            throw new HueApiException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GroupImpl buildGroup(GroupResource groupResource) {
        return this.groupFactory.buildGroup(groupResource, this.allResources);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public LightImpl buildLight(LightResource lightResource) {
        return this.lightFactory.buildLight(lightResource, this.resourceUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildMotionSensor, reason: merged with bridge method [inline-methods] */
    public MotionSensorImpl lambda$refresh$13(DeviceResource deviceResource) {
        return this.motionSensorFactory.buildMotionSensor(deviceResource, this.resourceUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildSwitch, reason: merged with bridge method [inline-methods] */
    public Switch lambda$refresh$9(DeviceResource deviceResource, List<ButtonResource> list) {
        return this.switchFactory.buildSwitch(deviceResource, (Map) ((List) Optional.ofNullable(list).orElse(Collections.EMPTY_LIST)).stream().collect(Collectors.toMap(new Hue$$ExternalSyntheticLambda4(5), new Hue$$ExternalSyntheticLambda4(6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: buildTemperatureSensor, reason: merged with bridge method [inline-methods] */
    public TemperatureSensorImpl lambda$refresh$17(DeviceResource deviceResource) {
        return this.temperatureSensorFactory.buildTemperatureSensor(deviceResource, this.resourceUrl);
    }

    public static HueBridgeConnectionBuilder hueBridgeConnectionBuilder(String str) {
        return new HueBridgeConnectionBuilder(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ButtonResource lambda$buildSwitch$25(ButtonResource buttonResource) {
        return buttonResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getDevices$26(Resource resource) {
        return resource.getType() == ResourceType.DEVICE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DeviceResource lambda$getDevices$27(Resource resource) {
        return (DeviceResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getNewLightsSearchStatus$35(String str, Light light) {
        return FileInsert$$ExternalSyntheticOutline0.m("/lights/", str).equals(((LightImpl) light).getIdV1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getRoomByName$32(String str, Group group) {
        return Objects.equals(group.getName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getRooms$28(Group group) {
        return group.getType() == ResourceType.ROOM;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Group lambda$getRooms$29(Group group) {
        return group;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getZoneByName$33(String str, Group group) {
        return Objects.equals(group.getName(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getZones$30(Group group) {
        return group.getType() == ResourceType.ZONE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Group lambda$getZones$31(Group group) {
        return group;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Resource lambda$refresh$1(Resource resource) {
        return resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Switch lambda$refresh$10(Switch r0) {
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$11(ResourceIdentifier resourceIdentifier) {
        return ResourceType.MOTION == resourceIdentifier.getResourceType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$12(DeviceResource deviceResource) {
        return deviceResource.getServices().stream().anyMatch(new Color$$ExternalSyntheticLambda1(21));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ MotionSensor lambda$refresh$14(MotionSensorImpl motionSensorImpl) {
        return motionSensorImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$15(ResourceIdentifier resourceIdentifier) {
        return ResourceType.TEMPERATURE == resourceIdentifier.getResourceType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$16(DeviceResource deviceResource) {
        return deviceResource.getServices().stream().anyMatch(new Color$$ExternalSyntheticLambda1(20));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TemperatureSensor lambda$refresh$18(TemperatureSensorImpl temperatureSensorImpl) {
        return temperatureSensorImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$19(Resource resource) {
        return (resource instanceof RoomResource) || (resource instanceof ZoneResource);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$2(Resource resource) {
        return resource instanceof LightResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GroupResource lambda$refresh$20(Resource resource) {
        return (GroupResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Group lambda$refresh$21(GroupImpl groupImpl) {
        return groupImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$22(Resource resource) {
        return resource instanceof BridgeResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ BridgeResource lambda$refresh$23(Resource resource) {
        return (BridgeResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ LightResource lambda$refresh$3(Resource resource) {
        return (LightResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Light lambda$refresh$4(LightImpl lightImpl) {
        return lightImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$5(Resource resource) {
        return resource instanceof DeviceResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ DeviceResource lambda$refresh$6(Resource resource) {
        return (DeviceResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$refresh$7(Resource resource) {
        return resource instanceof ButtonResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ButtonResource lambda$refresh$8(Resource resource) {
        return (ButtonResource) resource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Collection lambda$searchForNewLights$34() {
        NewLightsResult newLightsSearchStatus = getNewLightsSearchStatus();
        int i = 50;
        while (newLightsSearchStatus.getStatus() != NewLightsSearchStatus.COMPLETED) {
            try {
                TimeUnit.SECONDS.sleep(1L);
                Logger logger2 = logger;
                StringBuilder sb = new StringBuilder();
                sb.append("Searching for new lights. Approximately ");
                int i2 = i - 1;
                sb.append(i);
                sb.append(" seconds left.");
                logger2.info(sb.toString());
                newLightsSearchStatus = getNewLightsSearchStatus();
                i = i2;
            } catch (InterruptedException unused) {
                throw new HueApiException("Search for new lights was interrupted unexpectedly");
            }
        }
        return newLightsSearchStatus.getNewLights();
    }

    public String getBridgeId() {
        return this.bridgeId;
    }

    public List<DeviceResource> getDevices() {
        return (List) this.allResources.values().stream().filter(new Color$$ExternalSyntheticLambda1(22)).map(new Hue$$ExternalSyntheticLambda4(8)).collect(Collectors.toList());
    }

    public Map<UUID, Light> getLights() {
        return this.lights;
    }

    public Map<UUID, MotionSensor> getMotionSensors() {
        return this.motionSensors;
    }

    public NewLightsResult getNewLightsSearchStatus() {
        NewLightsSearchStatus newLightsSearchStatus;
        try {
            JsonNode tree = this.objectMapper.readTree(new URL("https://" + this.bridgeIp + "/api/" + this.apiKey + "/lights/new"));
            String strTextValue = tree.get("lastscan").textValue();
            ArrayList arrayList = new ArrayList();
            strTextValue.getClass();
            ZonedDateTime zonedDateTimeStringTimestampToZonedDateTime = null;
            if (strTextValue.equals("active")) {
                newLightsSearchStatus = NewLightsSearchStatus.ACTIVE;
            } else if (strTextValue.equals(IntegrityManager.INTEGRITY_TYPE_NONE)) {
                newLightsSearchStatus = NewLightsSearchStatus.NONE;
            } else {
                newLightsSearchStatus = NewLightsSearchStatus.COMPLETED;
                zonedDateTimeStringTimestampToZonedDateTime = TimeUtil.stringTimestampToZonedDateTime(strTextValue);
                refresh();
                Iterator<String> itFieldNames = tree.fieldNames();
                while (itFieldNames.hasNext()) {
                    String next = itFieldNames.next();
                    if (!"lastscan".equals(next)) {
                        Optional<Light> optionalFindFirst = getLights().values().stream().filter(new Hue$$ExternalSyntheticLambda31(next, 4)).findFirst();
                        if (optionalFindFirst.isPresent()) {
                            arrayList.add(optionalFindFirst.get());
                        } else {
                            logger.warn("New light {} not found. Weird.", next);
                        }
                    }
                }
            }
            return new NewLightsResult(arrayList, newLightsSearchStatus, zonedDateTimeStringTimestampToZonedDateTime);
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    public Resource getResource(UUID uuid) {
        return this.allResources.get(uuid);
    }

    public URL getResourceUrl() {
        return this.resourceUrl;
    }

    public Optional<Group> getRoomByName(String str) {
        return getRooms().values().stream().filter(new Hue$$ExternalSyntheticLambda31(str, 0)).findFirst();
    }

    public Map<UUID, Group> getRooms() {
        return (Map) this.groups.values().stream().filter(new Color$$ExternalSyntheticLambda1(18)).collect(Collectors.toMap(new Hue$$ExternalSyntheticLambda4(3), new Hue$$ExternalSyntheticLambda4(7)));
    }

    public Map<UUID, Switch> getSwitches() {
        return this.switches;
    }

    public Map<UUID, TemperatureSensor> getTemperatureSensors() {
        return this.temperatureSensors;
    }

    public HttpsURLConnection getUrlConnection(URL url) {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            SecureJsonFactory secureJsonFactory = (SecureJsonFactory) this.objectMapper.getFactory();
            httpsURLConnection.setSSLSocketFactory(secureJsonFactory.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(secureJsonFactory.getHostnameVerifier());
            httpsURLConnection.setRequestProperty(HUE_APPLICATION_KEY_HEADER, this.apiKey);
            return httpsURLConnection;
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    public Optional<Group> getZoneByName(String str) {
        return getZones().values().stream().filter(new Hue$$ExternalSyntheticLambda31(str, 5)).findFirst();
    }

    public Map<UUID, Group> getZones() {
        return (Map) this.groups.values().stream().filter(new Color$$ExternalSyntheticLambda1(17)).collect(Collectors.toMap(new Hue$$ExternalSyntheticLambda4(3), new Hue$$ExternalSyntheticLambda4(4)));
    }

    public void refresh() {
        try {
            InputStream inputStream = getUrlConnection("").getInputStream();
            try {
                ResourceRoot resourceRoot = (ResourceRoot) this.objectMapper.readValue(inputStream, ResourceRoot.class);
                int i = 19;
                this.allResources = (Map) resourceRoot.getData().stream().collect(Collectors.toMap(new Color$$ExternalSyntheticLambda0(18), new Color$$ExternalSyntheticLambda0(i)));
                logger.trace("Resource root: " + resourceRoot);
                if (inputStream != null) {
                    inputStream.close();
                }
                this.lights = (Map) this.allResources.values().stream().filter(new Color$$ExternalSyntheticLambda1(14)).map(new Color$$ExternalSyntheticLambda0(28)).map(new Hue$$ExternalSyntheticLambda7(this, 5)).collect(Collectors.toMap(new Color$$ExternalSyntheticLambda0(29), new Hue$$ExternalSyntheticLambda4(1)));
                List list = (List) this.allResources.values().stream().filter(new Color$$ExternalSyntheticLambda1(15)).map(new Hue$$ExternalSyntheticLambda4(2)).collect(Collectors.toList());
                int i2 = 0;
                this.switches = (Map) list.stream().map(new Hue$$ExternalSyntheticLambda2(this, (List) this.allResources.values().stream().filter(new Color$$ExternalSyntheticLambda1(16)).map(new Color$$ExternalSyntheticLambda0(25)).collect(Collectors.toList()), i2)).filter(new Color$$ExternalSyntheticLambda1(i)).collect(Collectors.toMap(new Hue$$ExternalSyntheticLambda4(i2), new Hue$$ExternalSyntheticLambda4(9)));
                int i3 = 23;
                int i4 = 11;
                this.motionSensors = (Map) list.stream().filter(new Color$$ExternalSyntheticLambda1(i3)).map(new Hue$$ExternalSyntheticLambda7(this, i2)).collect(Collectors.toMap(new Hue$$ExternalSyntheticLambda4(10), new Hue$$ExternalSyntheticLambda4(i4)));
                this.temperatureSensors = (Map) list.stream().filter(new Color$$ExternalSyntheticLambda1(i4)).map(new Hue$$ExternalSyntheticLambda7(this, 3)).collect(Collectors.toMap(new Color$$ExternalSyntheticLambda0(20), new Color$$ExternalSyntheticLambda0(21)));
                this.groups = (Map) this.allResources.values().stream().filter(new Color$$ExternalSyntheticLambda1(12)).map(new Color$$ExternalSyntheticLambda0(22)).map(new Hue$$ExternalSyntheticLambda7(this, 4)).collect(Collectors.toMap(new Color$$ExternalSyntheticLambda0(i3), new Color$$ExternalSyntheticLambda0(24)));
                this.bridgeId = (String) this.allResources.values().stream().filter(new Color$$ExternalSyntheticLambda1(13)).map(new Color$$ExternalSyntheticLambda0(26)).map(new Color$$ExternalSyntheticLambda0(27)).findFirst().orElse(null);
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    public Future<Collection<Light>> searchForNewLights() {
        try {
            String strPost = HttpUtil.post(new URL("https://" + this.bridgeIp + "/api/" + this.apiKey + "/lights"), "", null);
            Logger logger2 = logger;
            StringBuilder sb = new StringBuilder("Starting to search for new lights: ");
            sb.append(strPost);
            logger2.info(sb.toString());
            return CompletableFuture.supplyAsync(new Hue$$ExternalSyntheticLambda43(this, 0));
        } catch (Exception e) {
            throw new HueApiException("Failed to search for new lights", e);
        }
    }

    public HueEventSource subscribeToEvents(HueEventListener hueEventListener) {
        try {
            SecureJsonFactory secureJsonFactory = (SecureJsonFactory) this.objectMapper.getFactory();
            OkHttpClient okHttpClientBuild = new OkHttpClient.Builder().sslSocketFactory(secureJsonFactory.getSocketFactory(), secureJsonFactory.getTrustManager()).connectTimeout(Duration.ofMinutes(1L)).readTimeout(EVENTS_READ_TIMEOUT).hostnameVerifier(secureJsonFactory.getHostnameVerifier()).build();
            BasicHueEventHandler basicHueEventHandler = new BasicHueEventHandler(this, hueEventListener);
            HttpConnectStrategy httpConnectStrategyHeaders = ConnectStrategy.http(this.eventUrl.toURI()).httpClient(okHttpClientBuild).headers(Headers.of(HUE_APPLICATION_KEY_HEADER, this.apiKey));
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            BackgroundEventSource backgroundEventSourceBuild = new BackgroundEventSource.Builder(basicHueEventHandler, new EventSource.Builder(httpConnectStrategyHeaders.connectTimeout(5000L, timeUnit)).retryDelay(3000L, timeUnit)).build();
            backgroundEventSourceBuild.start();
            return new LaunchDarklyEventSource(backgroundEventSourceBuild);
        } catch (Exception e) {
            throw new HueApiException(e);
        }
    }

    public URLConnection getUrlConnection(String str) {
        try {
            return getUrlConnection(new URL(this.resourceUrl.toString() + str));
        } catch (MalformedURLException e) {
            throw new HueApiException(e);
        }
    }
}
