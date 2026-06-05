package com.google.gson.internal.bind;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.LocalTime;
import j$.time.MonthDay;
import j$.time.OffsetDateTime;
import j$.time.OffsetTime;
import j$.time.Period;
import j$.time.Year;
import j$.time.YearMonth;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import java.io.IOException;
import kaaes.spotify.webapi.android.SpotifyService;

/* JADX INFO: loaded from: classes4.dex */
final class JavaTimeTypeAdapters implements TypeAdapters.FactorySupplier {
    private static final TypeAdapter<Duration> DURATION = new TypeAdapters.IntegerFieldsTypeAdapter<Duration>("seconds", "nanos") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public Duration create(long[] jArr) {
            return Duration.ofSeconds(jArr[0], jArr[1]);
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(Duration duration) {
            return new long[]{duration.getSeconds(), duration.getNano()};
        }
    };
    private static final TypeAdapter<Instant> INSTANT = new TypeAdapters.IntegerFieldsTypeAdapter<Instant>("seconds", "nanos") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public Instant create(long[] jArr) {
            return Instant.ofEpochSecond(jArr[0], jArr[1]);
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(Instant instant) {
            return new long[]{instant.getEpochSecond(), instant.getNano()};
        }
    };
    private static final TypeAdapter<LocalDate> LOCAL_DATE = new TypeAdapters.IntegerFieldsTypeAdapter<LocalDate>("year", "month", "day") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public LocalDate create(long[] jArr) {
            return LocalDate.of(Math.toIntExact(jArr[0]), Math.toIntExact(jArr[1]), Math.toIntExact(jArr[2]));
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(LocalDate localDate) {
            return new long[]{localDate.getYear(), localDate.getMonthValue(), localDate.getDayOfMonth()};
        }
    };
    public static final TypeAdapter<LocalTime> LOCAL_TIME = new TypeAdapters.IntegerFieldsTypeAdapter<LocalTime>("hour", "minute", "second", "nano") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public LocalTime create(long[] jArr) {
            return LocalTime.of(Math.toIntExact(jArr[0]), Math.toIntExact(jArr[1]), Math.toIntExact(jArr[2]), Math.toIntExact(jArr[3]));
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(LocalTime localTime) {
            return new long[]{localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNano()};
        }
    };
    private static final TypeAdapter<MonthDay> MONTH_DAY = new TypeAdapters.IntegerFieldsTypeAdapter<MonthDay>("month", "day") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public MonthDay create(long[] jArr) {
            return MonthDay.of(Math.toIntExact(jArr[0]), Math.toIntExact(jArr[1]));
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(MonthDay monthDay) {
            return new long[]{monthDay.getMonthValue(), monthDay.getDayOfMonth()};
        }
    };
    private static final TypeAdapter<Period> PERIOD = new TypeAdapters.IntegerFieldsTypeAdapter<Period>("years", "months", "days") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.9
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public Period create(long[] jArr) {
            return Period.of(Math.toIntExact(jArr[0]), Math.toIntExact(jArr[1]), Math.toIntExact(jArr[2]));
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(Period period) {
            return new long[]{period.getYears(), period.getMonths(), period.getDays()};
        }
    };
    private static final TypeAdapter<Year> YEAR = new TypeAdapters.IntegerFieldsTypeAdapter<Year>("year") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.10
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public Year create(long[] jArr) {
            return Year.of(Math.toIntExact(jArr[0]));
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(Year year) {
            return new long[]{year.getValue()};
        }
    };
    private static final TypeAdapter<YearMonth> YEAR_MONTH = new TypeAdapters.IntegerFieldsTypeAdapter<YearMonth>("year", "month") { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.11
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public YearMonth create(long[] jArr) {
            return YearMonth.of(Math.toIntExact(jArr[0]), Math.toIntExact(jArr[1]));
        }

        @Override // com.google.gson.internal.bind.TypeAdapters.IntegerFieldsTypeAdapter
        public long[] integerValues(YearMonth yearMonth) {
            return new long[]{yearMonth.getYear(), yearMonth.getMonthValue()};
        }
    };
    private static final TypeAdapter<ZoneId> ZONE_ID = new TypeAdapter<ZoneId>() { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.12
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public ZoneId read(JsonReader jsonReader) throws IOException {
            jsonReader.beginObject();
            String strNextString = null;
            Integer numValueOf = null;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String strNextName = jsonReader.nextName();
                strNextName.getClass();
                if (strNextName.equals("totalSeconds")) {
                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                } else if (strNextName.equals("id")) {
                    strNextString = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
            if (strNextString != null) {
                return ZoneId.of(strNextString);
            }
            if (numValueOf != null) {
                return ZoneOffset.ofTotalSeconds(numValueOf.intValue());
            }
            throw new JsonSyntaxException("Missing id or totalSeconds field; at path " + jsonReader.getPreviousPath());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, ZoneId zoneId) throws IOException {
            if (zoneId instanceof ZoneOffset) {
                jsonWriter.beginObject();
                jsonWriter.name("totalSeconds");
                jsonWriter.value(((ZoneOffset) zoneId).getTotalSeconds());
                jsonWriter.endObject();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("id");
            jsonWriter.value(zoneId.getId());
            jsonWriter.endObject();
        }
    }.nullSafe();
    static final TypeAdapterFactory JAVA_TIME_FACTORY = new TypeAdapterFactory() { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.14
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (!rawType.getName().startsWith("java.time.")) {
                return null;
            }
            if (rawType == Duration.class) {
                return JavaTimeTypeAdapters.DURATION;
            }
            if (rawType == Instant.class) {
                return JavaTimeTypeAdapters.INSTANT;
            }
            if (rawType == LocalDate.class) {
                return JavaTimeTypeAdapters.LOCAL_DATE;
            }
            if (rawType == LocalTime.class) {
                return (TypeAdapter<T>) JavaTimeTypeAdapters.LOCAL_TIME;
            }
            if (rawType == LocalDateTime.class) {
                return JavaTimeTypeAdapters.localDateTime(gson);
            }
            if (rawType == MonthDay.class) {
                return JavaTimeTypeAdapters.MONTH_DAY;
            }
            if (rawType == OffsetDateTime.class) {
                return JavaTimeTypeAdapters.offsetDateTime(gson);
            }
            if (rawType == OffsetTime.class) {
                return JavaTimeTypeAdapters.offsetTime(gson);
            }
            if (rawType == Period.class) {
                return JavaTimeTypeAdapters.PERIOD;
            }
            if (rawType == Year.class) {
                return JavaTimeTypeAdapters.YEAR;
            }
            if (rawType == YearMonth.class) {
                return JavaTimeTypeAdapters.YEAR_MONTH;
            }
            if (rawType == ZoneId.class || rawType == ZoneOffset.class) {
                return JavaTimeTypeAdapters.ZONE_ID;
            }
            if (rawType == ZonedDateTime.class) {
                return JavaTimeTypeAdapters.zonedDateTime(gson);
            }
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeAdapter<LocalDateTime> localDateTime(Gson gson) {
        final TypeAdapter adapter = gson.getAdapter(LocalDate.class);
        final TypeAdapter adapter2 = gson.getAdapter(LocalTime.class);
        return new TypeAdapter<LocalDateTime>() { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public LocalDateTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalDate localDate = null;
                LocalTime localTime = null;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    strNextName.getClass();
                    if (strNextName.equals("date")) {
                        localDate = (LocalDate) adapter.read(jsonReader);
                    } else if (strNextName.equals("time")) {
                        localTime = (LocalTime) adapter2.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return LocalDateTime.of((LocalDate) JavaTimeTypeAdapters.requireNonNullField(localDate, "date", jsonReader), (LocalTime) JavaTimeTypeAdapters.requireNonNullField(localTime, "time", jsonReader));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, LocalDateTime localDateTime) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("date");
                adapter.write(jsonWriter, localDateTime.toLocalDate());
                jsonWriter.name("time");
                adapter2.write(jsonWriter, localDateTime.toLocalTime());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeAdapter<OffsetDateTime> offsetDateTime(Gson gson) {
        final TypeAdapter<LocalDateTime> typeAdapterLocalDateTime = localDateTime(gson);
        final TypeAdapter adapter = gson.getAdapter(ZoneOffset.class);
        return new TypeAdapter<OffsetDateTime>() { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.7
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public OffsetDateTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalDateTime localDateTime = null;
                ZoneOffset zoneOffset = null;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    strNextName.getClass();
                    if (strNextName.equals(SpotifyService.OFFSET)) {
                        zoneOffset = (ZoneOffset) adapter.read(jsonReader);
                    } else if (strNextName.equals("dateTime")) {
                        localDateTime = (LocalDateTime) typeAdapterLocalDateTime.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return OffsetDateTime.of((LocalDateTime) JavaTimeTypeAdapters.requireNonNullField(localDateTime, "dateTime", jsonReader), (ZoneOffset) JavaTimeTypeAdapters.requireNonNullField(zoneOffset, SpotifyService.OFFSET, jsonReader));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, OffsetDateTime offsetDateTime) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("dateTime");
                typeAdapterLocalDateTime.write(jsonWriter, offsetDateTime.toLocalDateTime());
                jsonWriter.name(SpotifyService.OFFSET);
                adapter.write(jsonWriter, offsetDateTime.getOffset());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeAdapter<OffsetTime> offsetTime(Gson gson) {
        final TypeAdapter adapter = gson.getAdapter(LocalTime.class);
        final TypeAdapter adapter2 = gson.getAdapter(ZoneOffset.class);
        return new TypeAdapter<OffsetTime>() { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.8
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public OffsetTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalTime localTime = null;
                ZoneOffset zoneOffset = null;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    strNextName.getClass();
                    if (strNextName.equals(SpotifyService.OFFSET)) {
                        zoneOffset = (ZoneOffset) adapter2.read(jsonReader);
                    } else if (strNextName.equals("time")) {
                        localTime = (LocalTime) adapter.read(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                return OffsetTime.of((LocalTime) JavaTimeTypeAdapters.requireNonNullField(localTime, "time", jsonReader), (ZoneOffset) JavaTimeTypeAdapters.requireNonNullField(zoneOffset, SpotifyService.OFFSET, jsonReader));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, OffsetTime offsetTime) throws IOException {
                jsonWriter.beginObject();
                jsonWriter.name("time");
                adapter.write(jsonWriter, offsetTime.toLocalTime());
                jsonWriter.name(SpotifyService.OFFSET);
                adapter2.write(jsonWriter, offsetTime.getOffset());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T requireNonNullField(T t, String str, JsonReader jsonReader) {
        if (t != null) {
            return t;
        }
        StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Missing ", str, " field; at path ");
        sbM5m.append(jsonReader.getPreviousPath());
        throw new JsonSyntaxException(sbM5m.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static TypeAdapter<ZonedDateTime> zonedDateTime(Gson gson) {
        final TypeAdapter<LocalDateTime> typeAdapterLocalDateTime = localDateTime(gson);
        final TypeAdapter adapter = gson.getAdapter(ZoneOffset.class);
        final TypeAdapter adapter2 = gson.getAdapter(ZoneId.class);
        return new TypeAdapter<ZonedDateTime>() { // from class: com.google.gson.internal.bind.JavaTimeTypeAdapters.13
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public ZonedDateTime read(JsonReader jsonReader) throws IOException {
                jsonReader.beginObject();
                LocalDateTime localDateTime = null;
                ZoneOffset zoneOffset = null;
                ZoneId zoneId = null;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String strNextName = jsonReader.nextName();
                    strNextName.getClass();
                    switch (strNextName) {
                        case "offset":
                            zoneOffset = (ZoneOffset) adapter.read(jsonReader);
                            break;
                        case "zone":
                            zoneId = (ZoneId) adapter2.read(jsonReader);
                            break;
                        case "dateTime":
                            localDateTime = (LocalDateTime) typeAdapterLocalDateTime.read(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
                jsonReader.endObject();
                return ZonedDateTime.ofInstant((LocalDateTime) JavaTimeTypeAdapters.requireNonNullField(localDateTime, "dateTime", jsonReader), (ZoneOffset) JavaTimeTypeAdapters.requireNonNullField(zoneOffset, SpotifyService.OFFSET, jsonReader), (ZoneId) JavaTimeTypeAdapters.requireNonNullField(zoneId, "zone", jsonReader));
            }

            @Override // com.google.gson.TypeAdapter
            public void write(JsonWriter jsonWriter, ZonedDateTime zonedDateTime) throws IOException {
                if (zonedDateTime == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name("dateTime");
                typeAdapterLocalDateTime.write(jsonWriter, zonedDateTime.toLocalDateTime());
                jsonWriter.name(SpotifyService.OFFSET);
                adapter.write(jsonWriter, zonedDateTime.getOffset());
                jsonWriter.name("zone");
                adapter2.write(jsonWriter, zonedDateTime.getZone());
                jsonWriter.endObject();
            }
        }.nullSafe();
    }

    @Override // com.google.gson.internal.bind.TypeAdapters.FactorySupplier
    public TypeAdapterFactory get() {
        return JAVA_TIME_FACTORY;
    }
}
