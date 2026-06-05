package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda0;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.v2.domain.DeviceResource;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceIdentifier;
import io.github.zeroone3010.yahueapi.v2.domain.ResourceType;
import io.github.zeroone3010.yahueapi.v2.domain.Temperature;
import io.github.zeroone3010.yahueapi.v2.domain.TemperatureResourceRoot;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class TemperatureSensorFactory {
    private final Hue hue;
    private final ObjectMapper objectMapper;

    public TemperatureSensorFactory(Hue hue, ObjectMapper objectMapper) {
        this.hue = hue;
        this.objectMapper = objectMapper;
    }

    private Supplier<Temperature> createStateProvider(URL url) {
        return new LightFactory$$ExternalSyntheticLambda1(this, url, 5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTemperatureSensor$0(ResourceIdentifier resourceIdentifier) {
        return resourceIdentifier.getResourceType() == ResourceType.TEMPERATURE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Temperature lambda$createStateProvider$1(URL url) {
        try {
            InputStream inputStream = this.hue.getUrlConnection(url).getInputStream();
            try {
                Temperature temperature = ((TemperatureResourceRoot) this.objectMapper.readValue(inputStream, TemperatureResourceRoot.class)).getData().get(0).getTemperature();
                if (inputStream != null) {
                    inputStream.close();
                }
                return temperature;
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    public TemperatureSensorImpl buildTemperatureSensor(DeviceResource deviceResource, URL url) {
        try {
            return new TemperatureSensorImpl(deviceResource.getId(), deviceResource.getMetadata().getName(), createStateProvider(new URL(url, "/clip/v2/resource/temperature/" + ((String) deviceResource.getServices().stream().filter(new Color$$ExternalSyntheticLambda1(27)).findFirst().map(new Color$$ExternalSyntheticLambda0(14)).map(new Hue$$ExternalSyntheticLambda4(13)).orElse(null)))));
        } catch (MalformedURLException e) {
            throw new HueApiException(e);
        }
    }
}
