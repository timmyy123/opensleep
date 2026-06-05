package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import io.github.zeroone3010.yahueapi.Color$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.v2.domain.HueEvent;
import io.github.zeroone3010.yahueapi.v2.domain.HueEventData;
import io.github.zeroone3010.yahueapi.v2.domain.event.ButtonEvent;
import io.github.zeroone3010.yahueapi.v2.domain.event.MotionEvent;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class BasicHueEventHandler implements BackgroundEventHandler {
    private final HueEventListener eventListener;
    private final Hue hue;
    private final ObjectMapper objectMapper;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) BasicHueEventHandler.class);
    public static final TypeReference<List<HueEvent>> EVENT_LIST_TYPE_REF = new TypeReference<List<HueEvent>>() { // from class: io.github.zeroone3010.yahueapi.v2.BasicHueEventHandler.1
    };

    public BasicHueEventHandler(Hue hue, HueEventListener hueEventListener) {
        this.objectMapper = hue.objectMapper;
        this.hue = hue;
        this.eventListener = hueEventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseAndAnnounceButtonEvents$0(HueEventData hueEventData) {
        return hueEventData.getButton().isPresent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ButtonEvent lambda$parseAndAnnounceButtonEvents$1(HueEvent hueEvent, HueEventData hueEventData) {
        Switch r2 = this.hue.getSwitches().get(hueEventData.getOwner().getResourceId());
        return new ButtonEvent(hueEvent.getCreationTime(), r2, r2.getButtons().get(hueEventData.getResourceId()), ButtonEventType.parseFromButtonEventType(hueEventData.getButton().get().getLastEvent()), hueEvent.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Stream lambda$parseAndAnnounceButtonEvents$2(HueEvent hueEvent) {
        return hueEvent.getData().stream().filter(new Color$$ExternalSyntheticLambda1(4)).map(new BasicHueEventHandler$$ExternalSyntheticLambda1(this, hueEvent, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$parseAndAnnounceButtonEvents$3(HueEventData hueEventData) {
        return hueEventData.getMotion().isPresent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MotionEvent lambda$parseAndAnnounceButtonEvents$4(HueEvent hueEvent, HueEventData hueEventData) {
        return new MotionEvent(hueEvent.getCreationTime(), hueEvent.getId(), this.hue.getMotionSensors().get(hueEventData.getOwner().getResourceId()), hueEventData.getMotion().get().isMotion(), hueEventData.getMotion().get().isMotionValid());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Stream lambda$parseAndAnnounceButtonEvents$5(HueEvent hueEvent) {
        return hueEvent.getData().stream().filter(new Color$$ExternalSyntheticLambda1(5)).map(new BasicHueEventHandler$$ExternalSyntheticLambda1(this, hueEvent, 1));
    }

    private void parseAndAnnounceButtonEvents(List<HueEvent> list) {
        final int i = 0;
        Stream<R> streamFlatMap = list.stream().flatMap(new Function(this) { // from class: io.github.zeroone3010.yahueapi.v2.BasicHueEventHandler$$ExternalSyntheticLambda2
            public final /* synthetic */ BasicHueEventHandler f$0;

            {
                this.f$0 = this;
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i2 = i;
                BasicHueEventHandler basicHueEventHandler = this.f$0;
                HueEvent hueEvent = (HueEvent) obj;
                switch (i2) {
                    case 0:
                        return basicHueEventHandler.lambda$parseAndAnnounceButtonEvents$2(hueEvent);
                    default:
                        return basicHueEventHandler.lambda$parseAndAnnounceButtonEvents$5(hueEvent);
                }
            }
        });
        final HueEventListener hueEventListener = this.eventListener;
        Objects.requireNonNull(hueEventListener);
        streamFlatMap.forEach(new Consumer() { // from class: io.github.zeroone3010.yahueapi.v2.BasicHueEventHandler$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i2 = i;
                HueEventListener hueEventListener2 = hueEventListener;
                switch (i2) {
                    case 0:
                        hueEventListener2.receiveButtonEvent((ButtonEvent) obj);
                        break;
                    default:
                        hueEventListener2.receiveMotionEvent((MotionEvent) obj);
                        break;
                }
            }
        });
        final int i2 = 1;
        Stream<R> streamFlatMap2 = list.stream().flatMap(new Function(this) { // from class: io.github.zeroone3010.yahueapi.v2.BasicHueEventHandler$$ExternalSyntheticLambda2
            public final /* synthetic */ BasicHueEventHandler f$0;

            {
                this.f$0 = this;
            }

            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                int i22 = i2;
                BasicHueEventHandler basicHueEventHandler = this.f$0;
                HueEvent hueEvent = (HueEvent) obj;
                switch (i22) {
                    case 0:
                        return basicHueEventHandler.lambda$parseAndAnnounceButtonEvents$2(hueEvent);
                    default:
                        return basicHueEventHandler.lambda$parseAndAnnounceButtonEvents$5(hueEvent);
                }
            }
        });
        final HueEventListener hueEventListener2 = this.eventListener;
        Objects.requireNonNull(hueEventListener2);
        streamFlatMap2.forEach(new Consumer() { // from class: io.github.zeroone3010.yahueapi.v2.BasicHueEventHandler$$ExternalSyntheticLambda3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i22 = i2;
                HueEventListener hueEventListener22 = hueEventListener2;
                switch (i22) {
                    case 0:
                        hueEventListener22.receiveButtonEvent((ButtonEvent) obj);
                        break;
                    default:
                        hueEventListener22.receiveMotionEvent((MotionEvent) obj);
                        break;
                }
            }
        });
    }

    @Override // com.launchdarkly.eventsource.background.BackgroundEventHandler
    public void onClosed() {
        logger.trace("Connection closed.");
        this.eventListener.connectionClosed();
    }

    @Override // com.launchdarkly.eventsource.background.BackgroundEventHandler
    public void onComment(String str) {
        logger.trace("Comment received: " + str);
    }

    @Override // com.launchdarkly.eventsource.background.BackgroundEventHandler
    public void onError(Throwable th) {
        logger.info("onError: " + th);
    }

    @Override // com.launchdarkly.eventsource.background.BackgroundEventHandler
    public void onMessage(String str, MessageEvent messageEvent) {
        logger.debug("Message: " + messageEvent.getData());
        List<HueEvent> list = (List) this.objectMapper.readValue(messageEvent.getData(), EVENT_LIST_TYPE_REF);
        this.eventListener.receive(list);
        parseAndAnnounceButtonEvents(list);
    }

    @Override // com.launchdarkly.eventsource.background.BackgroundEventHandler
    public void onOpen() {
        logger.trace("Connection opened.");
        this.eventListener.connectionOpened();
    }
}
