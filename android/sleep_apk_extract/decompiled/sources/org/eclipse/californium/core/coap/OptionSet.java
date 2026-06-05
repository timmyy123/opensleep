package org.eclipse.californium.core.coap;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.philips.lighting.hue.sdk.upnp.PHIpAddressSearchManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.californium.core.Utils;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class OptionSet {
    private Integer accept;
    private BlockOption block1;
    private BlockOption block2;
    private Integer content_format;
    private List<byte[]> etag_list;
    private boolean explicitUriOptions;
    private List<byte[]> if_match_list;
    private boolean if_none_match;
    private List<String> location_path_list;
    private List<String> location_query_list;
    private Long max_age;
    private Integer observe;
    private byte[] oscore;
    private List<Option> others;
    private String proxy_scheme;
    private String proxy_uri;
    private Integer size1;
    private Integer size2;
    private String uri_host;
    private List<String> uri_path_list;
    private Integer uri_port;
    private List<String> uri_query_list;

    public OptionSet(OptionSet optionSet) {
        if (optionSet == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("option set must not be null!");
            throw null;
        }
        this.if_match_list = copyList(optionSet.if_match_list);
        this.uri_host = optionSet.uri_host;
        this.etag_list = copyList(optionSet.etag_list);
        this.if_none_match = optionSet.if_none_match;
        this.uri_port = optionSet.uri_port;
        this.location_path_list = copyList(optionSet.location_path_list);
        this.uri_path_list = copyList(optionSet.uri_path_list);
        this.content_format = optionSet.content_format;
        this.max_age = optionSet.max_age;
        this.uri_query_list = copyList(optionSet.uri_query_list);
        this.accept = optionSet.accept;
        this.location_query_list = copyList(optionSet.location_query_list);
        this.proxy_uri = optionSet.proxy_uri;
        this.proxy_scheme = optionSet.proxy_scheme;
        BlockOption blockOption = optionSet.block1;
        if (blockOption != null) {
            this.block1 = new BlockOption(blockOption);
        }
        BlockOption blockOption2 = optionSet.block2;
        if (blockOption2 != null) {
            this.block2 = new BlockOption(blockOption2);
        }
        this.size1 = optionSet.size1;
        this.size2 = optionSet.size2;
        this.observe = optionSet.observe;
        byte[] bArr = optionSet.oscore;
        if (bArr != null) {
            this.oscore = (byte[]) bArr.clone();
        }
        this.others = copyList(optionSet.others);
    }

    private void appendMultiOption(StringBuilder sb, List<String> list, char c) {
        if (list.isEmpty()) {
            return;
        }
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(c);
        }
        sb.setLength(sb.length() - 1);
    }

    private static void checkOptionValue(String str, int i, int i2, String str2) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1(FileInsert$$ExternalSyntheticOutline0.m$1(str2, " option must not be null!"));
            return;
        }
        int length = str.getBytes(CoAP.UTF8_CHARSET).length;
        if (length < i || length > i2) {
            Home$$ExternalSyntheticBUOutline0.m("%s option's length %d must be between %d and %d inclusive!", new Object[]{str2, Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    private <T> List<T> copyList(List<T> list) {
        if (list == null) {
            return null;
        }
        return new LinkedList(list);
    }

    private String getMultiOptionString(List<String> list, char c) {
        StringBuilder sb = new StringBuilder();
        appendMultiOption(sb, list, c);
        return sb.toString();
    }

    private List<Option> getOthersInternal() {
        synchronized (this) {
            try {
                if (this.others == null) {
                    this.others = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.others;
    }

    public static boolean isValidObserveOption(int i) {
        return i >= 0 && i <= 16777215;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OptionSet addETag(byte[] bArr) {
        if (bArr == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("ETag option must not be null");
            return null;
        }
        if (!containsETag(bArr)) {
            getETags().add(bArr.clone());
        }
        return this;
    }

    public OptionSet addIfMatch(byte[] bArr) {
        if (bArr == null) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("If-Match option must not be null");
            return null;
        }
        if (bArr.length <= 8) {
            getIfMatch().add(bArr);
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("If-Match option must be smaller or equal to 8 bytes: ", Utils.toHexString(bArr));
        return null;
    }

    public OptionSet addLocationPath(String str) {
        checkOptionValue(str, 0, PHIpAddressSearchManager.END_IP_SCAN, "Location-Path");
        getLocationPath().add(str);
        return this;
    }

    public OptionSet addLocationQuery(String str) {
        checkOptionValue(str, 0, PHIpAddressSearchManager.END_IP_SCAN, "Location-Query");
        getLocationQuery().add(str);
        return this;
    }

    public OptionSet addOption(Option option) {
        int number = option.getNumber();
        if (number == 1) {
            addIfMatch(option.getValue());
            return this;
        }
        if (number == 17) {
            setAccept(option.getIntegerValue());
            return this;
        }
        if (number == 20) {
            addLocationQuery(option.getStringValue());
            return this;
        }
        if (number == 23) {
            setBlock2(option.getValue());
            return this;
        }
        if (number == 35) {
            setProxyUri(option.getStringValue());
            return this;
        }
        if (number == 39) {
            setProxyScheme(option.getStringValue());
            return this;
        }
        if (number == 60) {
            setSize1(option.getIntegerValue());
            return this;
        }
        if (number == 11) {
            addUriPath(option.getStringValue());
            return this;
        }
        if (number == 12) {
            setContentFormat(option.getIntegerValue());
            return this;
        }
        if (number == 14) {
            setMaxAge(option.getLongValue());
            return this;
        }
        if (number == 15) {
            addUriQuery(option.getStringValue());
            return this;
        }
        if (number == 27) {
            setBlock1(option.getValue());
            return this;
        }
        if (number == 28) {
            setSize2(option.getIntegerValue());
            return this;
        }
        switch (number) {
            case 3:
                setUriHost(option.getStringValue());
                break;
            case 4:
                addETag(option.getValue());
                break;
            case 5:
                setIfNoneMatch(true);
                break;
            case 6:
                setObserve(option.getIntegerValue());
                break;
            case 7:
                setUriPort(option.getIntegerValue());
                break;
            case 8:
                addLocationPath(option.getStringValue());
                break;
            case 9:
                setOscore(option.getValue());
                break;
            default:
                getOthersInternal().add(option);
                break;
        }
        return this;
    }

    public OptionSet addUriPath(String str) {
        checkOptionValue(str, 0, PHIpAddressSearchManager.END_IP_SCAN, "Uri-Path");
        getUriPath().add(str);
        this.explicitUriOptions = true;
        return this;
    }

    public OptionSet addUriQuery(String str) {
        checkOptionValue(str, 0, PHIpAddressSearchManager.END_IP_SCAN, "Uri-Query");
        getUriQuery().add(str);
        this.explicitUriOptions = true;
        return this;
    }

    public List<Option> asSortedList() {
        ArrayList arrayList = new ArrayList();
        List<byte[]> list = this.if_match_list;
        if (list != null) {
            Iterator<byte[]> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Option(1, it.next()));
            }
        }
        if (hasUriHost()) {
            arrayList.add(new Option(3, getUriHost()));
        }
        List<byte[]> list2 = this.etag_list;
        if (list2 != null) {
            Iterator<byte[]> it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList.add(new Option(4, it2.next()));
            }
        }
        if (hasIfNoneMatch()) {
            arrayList.add(new Option(5));
        }
        if (hasUriPort()) {
            arrayList.add(new Option(7, getUriPort().intValue()));
        }
        List<String> list3 = this.location_path_list;
        if (list3 != null) {
            Iterator<String> it3 = list3.iterator();
            while (it3.hasNext()) {
                arrayList.add(new Option(8, it3.next()));
            }
        }
        List<String> list4 = this.uri_path_list;
        if (list4 != null) {
            Iterator<String> it4 = list4.iterator();
            while (it4.hasNext()) {
                arrayList.add(new Option(11, it4.next()));
            }
        }
        if (hasContentFormat()) {
            arrayList.add(new Option(12, getContentFormat()));
        }
        if (hasMaxAge()) {
            arrayList.add(new Option(14, getMaxAge().longValue()));
        }
        List<String> list5 = this.uri_query_list;
        if (list5 != null) {
            Iterator<String> it5 = list5.iterator();
            while (it5.hasNext()) {
                arrayList.add(new Option(15, it5.next()));
            }
        }
        if (hasAccept()) {
            arrayList.add(new Option(17, getAccept()));
        }
        List<String> list6 = this.location_query_list;
        if (list6 != null) {
            Iterator<String> it6 = list6.iterator();
            while (it6.hasNext()) {
                arrayList.add(new Option(20, it6.next()));
            }
        }
        if (hasProxyUri()) {
            arrayList.add(new Option(35, getProxyUri()));
        }
        if (hasProxyScheme()) {
            arrayList.add(new Option(39, getProxyScheme()));
        }
        if (hasObserve()) {
            arrayList.add(new Option(6, getObserve().intValue()));
        }
        if (hasBlock1()) {
            arrayList.add(new Option(27, getBlock1().getValue()));
        }
        if (hasBlock2()) {
            arrayList.add(new Option(23, getBlock2().getValue()));
        }
        if (hasSize1()) {
            arrayList.add(new Option(60, getSize1().intValue()));
        }
        if (hasSize2()) {
            arrayList.add(new Option(28, getSize2().intValue()));
        }
        if (hasOscore()) {
            arrayList.add(new Option(9, getOscore()));
        }
        List<Option> list7 = this.others;
        if (list7 != null) {
            arrayList.addAll(list7);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public void clear() {
        List<byte[]> list = this.if_match_list;
        if (list != null) {
            list.clear();
        }
        this.uri_host = null;
        List<byte[]> list2 = this.etag_list;
        if (list2 != null) {
            list2.clear();
        }
        this.if_none_match = false;
        this.uri_port = null;
        List<String> list3 = this.location_path_list;
        if (list3 != null) {
            list3.clear();
        }
        List<String> list4 = this.uri_path_list;
        if (list4 != null) {
            list4.clear();
        }
        this.content_format = null;
        this.max_age = null;
        List<String> list5 = this.uri_query_list;
        if (list5 != null) {
            list5.clear();
        }
        this.accept = null;
        List<String> list6 = this.location_query_list;
        if (list6 != null) {
            list6.clear();
        }
        this.proxy_uri = null;
        this.proxy_scheme = null;
        this.block1 = null;
        this.block2 = null;
        this.size1 = null;
        this.size2 = null;
        this.observe = null;
        this.oscore = null;
        List<Option> list7 = this.others;
        if (list7 != null) {
            list7.clear();
        }
    }

    public OptionSet clearUriPath() {
        getUriPath().clear();
        return this;
    }

    public OptionSet clearUriQuery() {
        getUriQuery().clear();
        return this;
    }

    public boolean containsETag(byte[] bArr) {
        List<byte[]> list = this.etag_list;
        if (list == null) {
            return false;
        }
        Iterator<byte[]> it = list.iterator();
        while (it.hasNext()) {
            if (Arrays.equals(it.next(), bArr)) {
                return true;
            }
        }
        return false;
    }

    public int getAccept() {
        if (hasAccept()) {
            return this.accept.intValue();
        }
        return -1;
    }

    public BlockOption getBlock1() {
        return this.block1;
    }

    public BlockOption getBlock2() {
        return this.block2;
    }

    public int getContentFormat() {
        if (hasContentFormat()) {
            return this.content_format.intValue();
        }
        return -1;
    }

    public int getETagCount() {
        return getETags().size();
    }

    public List<byte[]> getETags() {
        synchronized (this) {
            try {
                if (this.etag_list == null) {
                    this.etag_list = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.etag_list;
    }

    public List<byte[]> getIfMatch() {
        synchronized (this) {
            try {
                if (this.if_match_list == null) {
                    this.if_match_list = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.if_match_list;
    }

    public List<String> getLocationPath() {
        synchronized (this) {
            try {
                if (this.location_path_list == null) {
                    this.location_path_list = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.location_path_list;
    }

    public List<String> getLocationQuery() {
        synchronized (this) {
            try {
                if (this.location_query_list == null) {
                    this.location_query_list = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.location_query_list;
    }

    public Long getMaxAge() {
        Long l = this.max_age;
        return Long.valueOf(l != null ? l.longValue() : 60L);
    }

    public Integer getObserve() {
        return this.observe;
    }

    public byte[] getOscore() {
        return this.oscore;
    }

    public String getProxyScheme() {
        return this.proxy_scheme;
    }

    public String getProxyUri() {
        return this.proxy_uri;
    }

    public Integer getSize1() {
        return this.size1;
    }

    public Integer getSize2() {
        return this.size2;
    }

    public int getURIQueryCount() {
        return getUriQuery().size();
    }

    public String getUriHost() {
        return this.uri_host;
    }

    public List<String> getUriPath() {
        synchronized (this) {
            try {
                if (this.uri_path_list == null) {
                    this.uri_path_list = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.uri_path_list;
    }

    public String getUriPathString() {
        return getMultiOptionString(getUriPath(), '/');
    }

    public Integer getUriPort() {
        return this.uri_port;
    }

    public List<String> getUriQuery() {
        synchronized (this) {
            try {
                if (this.uri_query_list == null) {
                    this.uri_query_list = new LinkedList();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.uri_query_list;
    }

    public String getUriQueryString() {
        return getMultiOptionString(getUriQuery(), '&');
    }

    public String getUriString() {
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        appendMultiOption(sb, getUriPath(), '/');
        if (getURIQueryCount() > 0) {
            sb.append('?');
            appendMultiOption(sb, getUriQuery(), '&');
        }
        return sb.toString();
    }

    public boolean hasAccept() {
        return this.accept != null;
    }

    public boolean hasBlock1() {
        return this.block1 != null;
    }

    public boolean hasBlock2() {
        return this.block2 != null;
    }

    public boolean hasContentFormat() {
        return this.content_format != null;
    }

    public boolean hasExplicitUriOptions() {
        return this.explicitUriOptions;
    }

    public boolean hasIfNoneMatch() {
        return this.if_none_match;
    }

    public boolean hasMaxAge() {
        return this.max_age != null;
    }

    public boolean hasObserve() {
        return this.observe != null;
    }

    public boolean hasOscore() {
        return this.oscore != null;
    }

    public boolean hasProxyScheme() {
        return this.proxy_scheme != null;
    }

    public boolean hasProxyUri() {
        return this.proxy_uri != null;
    }

    public boolean hasSize1() {
        return this.size1 != null;
    }

    public boolean hasSize2() {
        return this.size2 != null;
    }

    public boolean hasUriHost() {
        return this.uri_host != null;
    }

    public boolean hasUriPort() {
        return this.uri_port != null;
    }

    public OptionSet removeBlock1() {
        this.block1 = null;
        return this;
    }

    public OptionSet removeBlock2() {
        this.block2 = null;
        return this;
    }

    public OptionSet removeObserve() {
        this.observe = null;
        return this;
    }

    public OptionSet removeUriHost() {
        this.uri_host = null;
        return this;
    }

    public OptionSet removeUriPort() {
        this.uri_port = null;
        return this;
    }

    public void resetExplicitUriOptions() {
        this.explicitUriOptions = false;
    }

    public OptionSet setAccept(int i) {
        if (i < 0 || i > 65535) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Accept option must be between 0 and 65535 (2 bytes) inclusive");
            return null;
        }
        this.accept = Integer.valueOf(i);
        return this;
    }

    public OptionSet setBlock1(int i, boolean z, int i2) {
        this.block1 = new BlockOption(i, z, i2);
        return this;
    }

    public OptionSet setBlock2(int i, boolean z, int i2) {
        this.block2 = new BlockOption(i, z, i2);
        return this;
    }

    public OptionSet setContentFormat(int i) {
        if (i <= -1 || i > 65535) {
            this.content_format = null;
            return this;
        }
        this.content_format = Integer.valueOf(i);
        return this;
    }

    public OptionSet setIfNoneMatch(boolean z) {
        this.if_none_match = z;
        return this;
    }

    public OptionSet setMaxAge(long j) {
        if (j < 0 || 4294967295L < j) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Max-Age option must be between 0 and 4294967295 (4 bytes) inclusive");
            return null;
        }
        this.max_age = Long.valueOf(j);
        return this;
    }

    public OptionSet setObserve(int i) {
        if (isValidObserveOption(i)) {
            this.observe = Integer.valueOf(i);
            return this;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Observe option must be between 0 and 16777215 (3 bytes) inclusive");
        return null;
    }

    public OptionSet setOscore(byte[] bArr) {
        if (bArr != null) {
            this.oscore = (byte[]) bArr.clone();
            return this;
        }
        Types$$ExternalSyntheticBUOutline0.m$1("Oscore cannot be null.");
        return null;
    }

    public OptionSet setProxyScheme(String str) {
        checkOptionValue(str, 1, PHIpAddressSearchManager.END_IP_SCAN, "Proxy-Scheme");
        this.proxy_scheme = str;
        return this;
    }

    public OptionSet setProxyUri(String str) {
        checkOptionValue(str, 1, 1034, "Proxy-Uri");
        this.proxy_uri = str;
        return this;
    }

    public OptionSet setSize1(int i) {
        this.size1 = Integer.valueOf(i);
        return this;
    }

    public OptionSet setSize2(int i) {
        this.size2 = Integer.valueOf(i);
        return this;
    }

    public OptionSet setUriHost(String str) {
        checkOptionValue(str, 1, PHIpAddressSearchManager.END_IP_SCAN, "URI-Host");
        this.uri_host = str;
        return this;
    }

    public OptionSet setUriPath(String str) {
        if (str.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            str = str.substring(1);
        }
        clearUriPath();
        for (String str2 : str.split(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            addUriPath(str2);
        }
        return this;
    }

    public OptionSet setUriPort(int i) {
        if (i < 0 || 65535 < i) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "URI port option must be between 0 and 65535 (2 bytes) inclusive but was "));
            return null;
        }
        this.uri_port = Integer.valueOf(i);
        return this;
    }

    public OptionSet setUriQuery(String str) {
        while (str.startsWith("?")) {
            str = str.substring(1);
        }
        clearUriQuery();
        for (String str2 : str.split("&")) {
            if (!str2.isEmpty()) {
                addUriQuery(str2);
            }
        }
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        StringBuilder sb2 = new StringBuilder();
        int number = -1;
        boolean z = false;
        for (Option option : asSortedList()) {
            if (option.getNumber() != number) {
                if (number != -1) {
                    if (z) {
                        sb2.append(']');
                    }
                    sb.append(sb2.toString());
                    sb.append(", ");
                    sb2.setLength(0);
                }
                sb.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                sb.append(OptionNumberRegistry.toString(option.getNumber()));
                sb.append("\":");
                z = false;
            } else {
                if (!z) {
                    sb2.insert(0, '[');
                }
                sb2.append(",");
                z = true;
            }
            sb2.append(option.toValueString());
            number = option.getNumber();
        }
        if (z) {
            sb2.append(']');
        }
        sb.append(sb2.toString());
        sb.append('}');
        return sb.toString();
    }

    public OptionSet setBlock1(byte[] bArr) {
        this.block1 = new BlockOption(bArr);
        return this;
    }

    public OptionSet setBlock2(byte[] bArr) {
        this.block2 = new BlockOption(bArr);
        return this;
    }

    public OptionSet setBlock1(BlockOption blockOption) {
        this.block1 = blockOption;
        return this;
    }

    public OptionSet setBlock2(BlockOption blockOption) {
        this.block2 = blockOption;
        return this;
    }

    public OptionSet() {
        this.if_match_list = null;
        this.uri_host = null;
        this.etag_list = null;
        this.if_none_match = false;
        this.uri_port = null;
        this.location_path_list = null;
        this.uri_path_list = null;
        this.content_format = null;
        this.max_age = null;
        this.uri_query_list = null;
        this.accept = null;
        this.location_query_list = null;
        this.proxy_uri = null;
        this.proxy_scheme = null;
        this.block1 = null;
        this.block2 = null;
        this.size1 = null;
        this.size2 = null;
        this.observe = null;
        this.oscore = null;
        this.others = null;
    }
}
