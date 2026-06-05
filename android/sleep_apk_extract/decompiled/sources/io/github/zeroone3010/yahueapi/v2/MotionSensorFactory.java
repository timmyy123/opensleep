package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.Motion;
import io.github.zeroone3010.yahueapi.v2.domain.MotionResourceRoot;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class MotionSensorFactory {
    private final Hue hue;
    private final ObjectMapper objectMapper;

    public MotionSensorFactory(Hue hue, ObjectMapper objectMapper) {
        this.hue = hue;
        this.objectMapper = objectMapper;
    }

    private Supplier<Motion> createStateProvider(URL url) {
        return new LightFactory$$ExternalSyntheticLambda1(this, url, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildMotionSensor$0(ResourceIdentifier resourceIdentifier) {
        return resourceIdentifier.getResourceType() == ResourceType.MOTION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Motion lambda$createStateProvider$1(URL url) {
        try {
            InputStream inputStream = this.hue.getUrlConnection(url).getInputStream();
            try {
                Motion motion = ((MotionResourceRoot) this.objectMapper.readValue(inputStream, MotionResourceRoot.class)).getData().get(0).getMotion();
                if (inputStream != null) {
                    inputStream.close();
                }
                return motion;
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    public MotionSensorImpl buildMotionSensor(DeviceResource deviceResource, URL url) {
        try {
            return new MotionSensorImpl(deviceResource.getId(), deviceResource.getMetadata().getName(), createStateProvider(new URL(url, "/clip/v2/resource/motion/" + ((String) deviceResource.getServices().stream().filter(new Color$$ExternalSyntheticLambda1(24)).findFirst().map(new Color$$ExternalSyntheticLambda0(14)).map(new Hue$$ExternalSyntheticLambda4(13)).orElse(null)))));
        } catch (MalformedURLException e) {
            throw new HueApiException(e);
        }
    }
}
