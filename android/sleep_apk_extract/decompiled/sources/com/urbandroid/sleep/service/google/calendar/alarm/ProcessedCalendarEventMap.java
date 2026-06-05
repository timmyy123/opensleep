package com.urbandroid.sleep.service.google.calendar.alarm;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.google.calendar.JavaProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CachedCalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.api.provider.CalendarProviderApi;
import com.urbandroid.sleep.service.google.calendar.domain.GoogleCalendar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ProcessedCalendarEventMap {
    private final GoogleCalendar calendar;
    private final JavaProviderApi calendarProvider;
    private final List<Event> events;
    private final String keyName;
    private final SharedPreferences preferences;
    private final Type type;

    public static class Event {
        private Long alarmTime;
        private GoogleCalendar.Event event;

        public Event(GoogleCalendar.Event event, Long l) {
            this.event = event;
            this.alarmTime = l;
        }

        public static Event deserialize(String str) {
            int iLastIndexOf = str.lastIndexOf(35);
            if (iLastIndexOf != -1) {
                GoogleCalendar.Event eventDeserialize = GoogleCalendar.Event.INSTANCE.deserialize(str.substring(0, iLastIndexOf));
                if (eventDeserialize != null) {
                    return new Event(eventDeserialize, Long.valueOf(Long.parseLong(str.substring(iLastIndexOf + 1))));
                }
                return null;
            }
            GoogleCalendar.Event eventDeserialize2 = GoogleCalendar.Event.INSTANCE.deserialize(str);
            if (eventDeserialize2 != null) {
                return new Event(eventDeserialize2, null);
            }
            return null;
        }

        public static String serialize(Event event) {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(GoogleCalendar.Event.INSTANCE.serialize(event.getEvent()));
            if (event.getAlarmTime() != null) {
                str = "#" + event.getAlarmTime();
            } else {
                str = "";
            }
            sb.append(str);
            return sb.toString();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Event event = (Event) obj;
                if (!this.event.equals(event.event)) {
                    return false;
                }
                Long l = this.alarmTime;
                Long l2 = event.alarmTime;
                if (l != null) {
                    return l.equals(l2);
                }
                if (l2 == null) {
                    return true;
                }
            }
            return false;
        }

        public Long getAlarmTime() {
            return this.alarmTime;
        }

        public GoogleCalendar.Event getEvent() {
            return this.event;
        }

        public int hashCode() {
            int iHashCode = this.event.hashCode() * 31;
            Long l = this.alarmTime;
            return iHashCode + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            return "Event{event=" + this.event + ", alarmTime=" + this.alarmTime + '}';
        }
    }

    public enum Type {
        EVENT("processedCalendarEvents"),
        HOLIDAY("processedCalendarHolidays");

        private final String key;

        Type(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }
    }

    public ProcessedCalendarEventMap(Context context, Type type, String str, GoogleCalendar googleCalendar, long j) {
        this.type = type;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.preferences = defaultSharedPreferences;
        this.calendar = googleCalendar;
        this.calendarProvider = new JavaProviderApi(context, new CachedCalendarProviderApi(context, new CalendarProviderApi(context, str)));
        this.keyName = resolveKeyName(type, googleCalendar);
        this.events = cleanDeleted(removeObsolete(load(defaultSharedPreferences), j));
        store();
    }

    public static List<Event> load(String str) {
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.split("[|]")) {
                String[] strArrSplit = str2.split(",");
                if (strArrSplit.length == 3 || strArrSplit.length == 4) {
                    Event eventDeserialize = Event.deserialize(str2);
                    if (eventDeserialize != null) {
                        arrayList.add(eventDeserialize);
                    }
                } else {
                    Logger.logWarning("Invalid serialized CalendarEvent record: ".concat(str2));
                }
            }
        }
        return arrayList;
    }

    public static void reset(Context context, Type type, GoogleCalendar googleCalendar) {
        String strResolveKeyName = resolveKeyName(type, googleCalendar);
        Logger.logDebug("GC[" + type.name() + "]: resetting processed events: " + (googleCalendar == null ? "-" : googleCalendar.getDisplayName()));
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        editorEdit.remove(strResolveKeyName);
        editorEdit.apply();
    }

    private static String resolveKeyName(Type type, GoogleCalendar googleCalendar) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(type.getKey());
        if (googleCalendar != null) {
            str = "#" + googleCalendar.getId();
        } else {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    private String serialize(Collection<Event> collection) {
        String[] strArr = new String[collection.size()];
        Iterator<Event> it = collection.iterator();
        int i = 0;
        while (it.hasNext()) {
            strArr[i] = Event.serialize(it.next());
            i++;
        }
        return TextUtils.join("|", strArr);
    }

    public boolean add(Event event) {
        for (Event event2 : this.events) {
            if (event.getEvent().getIsAllDay() && !event2.event.getCompositeId().equals(event.getEvent().getCompositeId()) && event2.event.getStart() == event.getEvent().getStart() && event2.event.getEnd() == event.getEvent().getEnd()) {
                Logger.logWarning("Event " + event.getEvent() + " already found as " + event2.getEvent());
                return false;
            }
        }
        if (this.events.contains(event)) {
            Iterator<Event> it = this.events.iterator();
            while (it.hasNext()) {
                Event next = it.next();
                if (next.getEvent().getCompositeId().equals(event.getEvent().getCompositeId()) && (next.getAlarmTime() == null || next.getAlarmTime().equals(event.getAlarmTime()))) {
                    it.remove();
                }
            }
        }
        this.events.add(event);
        store();
        return true;
    }

    public List<Event> cleanDeleted(List<Event> list) {
        if (!list.isEmpty() && this.calendar != null && this.type != Type.HOLIDAY) {
            ArrayList arrayList = new ArrayList();
            long start = -1;
            long end = -1;
            for (Event event : list) {
                start = start == -1 ? event.getEvent().getStart() : Math.min(start, event.getEvent().getStart());
                end = end == -1 ? event.getEvent().getEnd() : Math.max(end, event.getEvent().getEnd());
                arrayList.add(event.getEvent().getEventId());
            }
            try {
                Iterator<GoogleCalendar.Event> it = this.calendarProvider.getEvents(this.calendar, start, end, null).iterator();
                while (it.hasNext()) {
                    arrayList.remove(it.next().getCompositeId());
                }
                Iterator<Event> it2 = list.iterator();
                while (it2.hasNext()) {
                    Event next = it2.next();
                    if (arrayList.contains(next.getEvent().getCompositeId())) {
                        Logger.logDebug("deleted GC event: " + next.getEvent());
                        Logger.logDebug(this.keyName + " " + this.calendar.getDisplayName());
                        it2.remove();
                    }
                }
            } catch (UserRecoverableAuthException e) {
                Logger.logSevere(e);
            }
        }
        return list;
    }

    public boolean contains(GoogleCalendar.Event event, Long l) {
        for (Event event2 : this.events) {
            Long alarmTime = event2.getAlarmTime();
            if (event2.getEvent().getCompositeId().equals(event.getCompositeId()) && (l == null || l.equals(alarmTime))) {
                return true;
            }
            if (event.getIsAllDay() && !event.getCompositeId().equals(event2.getEvent().getCompositeId()) && event.getStart() == event2.getEvent().getStart() && event.getEnd() == event2.getEvent().getEnd()) {
                return true;
            }
        }
        return false;
    }

    public Event get(String str) {
        for (Event event : this.events) {
            if (event.getEvent().getCompositeId().equals(str)) {
                return event;
            }
        }
        return null;
    }

    public List<Event> removeObsolete(List<Event> list, long j) {
        Iterator<Event> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getEvent().getEnd() < j) {
                it.remove();
            }
        }
        return list;
    }

    public String store() {
        String strSerialize = serialize(this.events);
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        editorEdit.putString(this.keyName, strSerialize);
        editorEdit.apply();
        return strSerialize;
    }

    public String toString() {
        return "ProcessedCalendarEventMap[" + this.type + "]: " + this.events;
    }

    public ProcessedCalendarEventMap(Context context, String str, Type type, long j) {
        this(context, type, str, null, j);
    }

    private List<Event> load(SharedPreferences sharedPreferences) {
        return load(sharedPreferences.getString(this.keyName, null));
    }
}
