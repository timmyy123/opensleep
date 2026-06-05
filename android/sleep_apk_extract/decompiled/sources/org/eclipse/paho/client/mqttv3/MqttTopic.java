package org.eclipse.paho.client.mqttv3;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.io.UnsupportedEncodingException;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.internal.ClientComms;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttPublish;
import org.eclipse.paho.client.mqttv3.util.Strings;

/* JADX INFO: loaded from: classes5.dex */
public class MqttTopic {
    private static final int MAX_TOPIC_LEN = 65535;
    private static final int MIN_TOPIC_LEN = 1;
    public static final String MULTI_LEVEL_WILDCARD = "#";
    public static final String MULTI_LEVEL_WILDCARD_PATTERN = "/#";
    private static final char NUL = 0;
    public static final String SINGLE_LEVEL_WILDCARD = "+";
    public static final String TOPIC_LEVEL_SEPARATOR = "/";
    public static final String TOPIC_WILDCARDS = "#+";
    private ClientComms comms;
    private String name;

    public MqttTopic(String str, ClientComms clientComms) {
        this.comms = clientComms;
        this.name = str;
    }

    private MqttPublish createPublish(MqttMessage mqttMessage) {
        return new MqttPublish(getName(), mqttMessage);
    }

    public static boolean isMatched(String str, String str2) {
        int length = str2.length();
        int length2 = str.length();
        validate(str, true);
        validate(str2, false);
        if (str.equals(str2)) {
            return true;
        }
        int i = 0;
        int i2 = 0;
        while (i < length2 && i2 < length && ((str2.charAt(i2) != '/' || str.charAt(i) == '/') && (str.charAt(i) == '+' || str.charAt(i) == '#' || str.charAt(i) == str2.charAt(i2)))) {
            if (str.charAt(i) == '+') {
                int i3 = i2 + 1;
                while (i3 < length && str2.charAt(i3) != '/') {
                    i3 = i2 + 2;
                    i2++;
                }
            } else if (str.charAt(i) == '#') {
                i2 = length - 1;
            }
            i++;
            i2++;
        }
        return i2 == length && i == length2;
    }

    public static void validate(String str, boolean z) {
        try {
            int length = str.getBytes(OAuth.ENCODING).length;
            if (length < 1 || length > MAX_TOPIC_LEN) {
                Home$$ExternalSyntheticBUOutline0.m("Invalid topic length, should be in range[%d, %d]!", new Object[]{new Integer(1), new Integer(MAX_TOPIC_LEN)});
                return;
            }
            if (!z) {
                if (Strings.containsAny(str, TOPIC_WILDCARDS)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("The topic name MUST NOT contain any wildcard characters (#+)");
                }
            } else {
                if (Strings.equalsAny(str, new String[]{"#", SINGLE_LEVEL_WILDCARD})) {
                    return;
                }
                if (Strings.countMatches(str, "#") > 1 || (str.contains("#") && !str.endsWith(MULTI_LEVEL_WILDCARD_PATTERN))) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid usage of multi-level wildcard in topic string: ".concat(str));
                } else {
                    validateSingleLevelWildcard(str);
                }
            }
        } catch (UnsupportedEncodingException e) {
            Events$$ExternalSyntheticBUOutline0.m(e);
        }
    }

    private static void validateSingleLevelWildcard(String str) {
        char cCharAt = SINGLE_LEVEL_WILDCARD.charAt(0);
        char cCharAt2 = TOPIC_LEVEL_SEPARATOR.charAt(0);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        while (i < length) {
            int i2 = i - 1;
            char c = i2 >= 0 ? charArray[i2] : (char) 0;
            int i3 = i + 1;
            char c2 = i3 < length ? charArray[i3] : (char) 0;
            if (charArray[i] == cCharAt && ((c != cCharAt2 && c != 0) || (c2 != cCharAt2 && c2 != 0))) {
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Invalid usage of single-level wildcard in topic string '", str, "'!"));
                return;
            }
            i = i3;
        }
    }

    public String getName() {
        return this.name;
    }

    public MqttDeliveryToken publish(MqttMessage mqttMessage) throws MqttException {
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(this.comms.getClient().getClientId());
        mqttDeliveryToken.setMessage(mqttMessage);
        this.comms.sendNoWait(createPublish(mqttMessage), mqttDeliveryToken);
        mqttDeliveryToken.internalTok.waitUntilSent();
        return mqttDeliveryToken;
    }

    public String toString() {
        return getName();
    }

    public MqttDeliveryToken publish(byte[] bArr, int i, boolean z) {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i);
        mqttMessage.setRetained(z);
        return publish(mqttMessage);
    }
}
