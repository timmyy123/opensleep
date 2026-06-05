package com.urbandroid.sleep.gui;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.urbandroid.sleep.domain.timezone.ZoneInfoMapper;
import j$.util.DesugarTimeZone;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
class TimezoneList {
    private List<String> entries;
    private List<String> values;

    public static class Builder {
        private List<String> entries = new ArrayList();
        private List<String> values = new ArrayList();

        private String getTimezoneName(String str) {
            return str.replaceAll("\\/", " / ").replaceAll("_", " ");
        }

        public Builder addTimezonesWithCityNames() {
            String[] availableIDs = TimeZone.getAvailableIDs();
            ZoneInfoMapper zoneInfoMapper = new ZoneInfoMapper();
            for (String str : availableIDs) {
                if (zoneInfoMapper.getLocation(str) != null) {
                    this.entries.add(getTimezoneName(DesugarTimeZone.getTimeZone(str).getID()));
                    this.values.add(str);
                }
            }
            return this;
        }

        public Builder addTimezonesWithoutNames() {
            int i = -12;
            while (i < 15) {
                String strM = zzba$$ExternalSyntheticOutline0.m(i, i >= 0 ? MqttTopic.SINGLE_LEVEL_WILDCARD : "", new StringBuilder("GMT"));
                this.entries.add(strM);
                this.values.add(strM);
                i++;
            }
            return this;
        }

        public TimezoneList build() {
            return new TimezoneList(this.entries, this.values, 0);
        }
    }

    private TimezoneList(List<String> list, List<String> list2) {
        this.entries = list;
        this.values = list2;
    }

    public String[] getEntries() {
        return (String[]) this.entries.toArray(new String[0]);
    }

    public String[] getValues() {
        return (String[]) this.values.toArray(new String[0]);
    }

    public /* synthetic */ TimezoneList(List list, List list2, int i) {
        this(list, list2);
    }
}
