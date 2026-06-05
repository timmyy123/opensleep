package org.mp4parser.tools;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.mp4parser.Box;
import org.mp4parser.Container;
import org.mp4parser.ParsableBox;
import org.mp4parser.support.AbstractContainerBox;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Path {
    public static Pattern component = Pattern.compile("(....|\\.\\.)(\\[(.*)\\])?");

    public static <T extends Box> T getPath(Container container, String str) {
        List paths = getPaths(container, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return (T) paths.get(0);
    }

    private static <T extends Box> List<T> getPaths(Object obj, String str, boolean z) {
        String strSubstring;
        if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            Types$$ExternalSyntheticBUOutline0.m$2("Cannot start at / - only relative path expression into the structure are allowed");
            return null;
        }
        if (str.length() == 0) {
            if (obj instanceof ParsableBox) {
                return Collections.singletonList((Box) obj);
            }
            Types$$ExternalSyntheticBUOutline0.m$2("Result of path expression seems to be the root container. This is not allowed!");
            return null;
        }
        int i = 0;
        if (str.contains(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            strSubstring = str.substring(str.indexOf(47) + 1);
            str = str.substring(0, str.indexOf(47));
        } else {
            strSubstring = "";
        }
        Matcher matcher = component.matcher(str);
        if (!matcher.matches()) {
            Types$$ExternalSyntheticBUOutline0.m$2(str.concat(" is invalid path."));
            return null;
        }
        String strGroup = matcher.group(1);
        if ("..".equals(strGroup)) {
            Types$$ExternalSyntheticBUOutline0.m$2(".. notation no longer allowed");
            return null;
        }
        if (!(obj instanceof Container)) {
            return Collections.EMPTY_LIST;
        }
        int i2 = matcher.group(2) != null ? Integer.parseInt(matcher.group(3)) : -1;
        LinkedList linkedList = new LinkedList();
        for (Box box : ((Container) obj).getBoxes()) {
            if (box.getType().matches(strGroup)) {
                if (i2 == -1 || i2 == i) {
                    linkedList.addAll(getPaths(box, strSubstring, z));
                }
                i++;
            }
            if (z || i2 >= 0) {
                if (!linkedList.isEmpty()) {
                    break;
                }
            }
        }
        return linkedList;
    }

    public static <T extends Box> T getPath(AbstractContainerBox abstractContainerBox, String str) {
        List paths = getPaths(abstractContainerBox, str, true);
        if (paths.isEmpty()) {
            return null;
        }
        return (T) paths.get(0);
    }

    public static <T extends Box> List<T> getPaths(Container container, String str) {
        return getPaths(container, str, false);
    }

    private static <T extends Box> List<T> getPaths(AbstractContainerBox abstractContainerBox, String str, boolean z) {
        return getPaths((Object) abstractContainerBox, str, z);
    }

    private static <T extends Box> List<T> getPaths(Container container, String str, boolean z) {
        return getPaths((Object) container, str, z);
    }

    public static <T extends Box> List<T> getPaths(Box box, String str) {
        return getPaths((Object) box, str, false);
    }
}
