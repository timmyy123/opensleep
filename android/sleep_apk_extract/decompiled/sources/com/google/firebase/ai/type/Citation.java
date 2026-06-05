package com.google.firebase.ai.type;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.share.internal.ShareConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u0016BK\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/type/Citation;", "", "title", "", "startIndex", "", "endIndex", ShareConstants.MEDIA_URI, "license", "publicationDate", "Ljava/util/Calendar;", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/util/Calendar;)V", "getTitle", "()Ljava/lang/String;", "getStartIndex", "()I", "getEndIndex", "getUri", "getLicense", "getPublicationDate", "()Ljava/util/Calendar;", "Internal", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Citation {
    private final int endIndex;
    private final String license;
    private final Calendar publicationDate;
    private final int startIndex;
    private final String title;
    private final String uri;

    public /* synthetic */ Citation(String str, int i, int i2, String str2, String str3, Calendar calendar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? 0 : i, i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : calendar);
    }

    public final int getEndIndex() {
        return this.endIndex;
    }

    public final String getLicense() {
        return this.license;
    }

    public final Calendar getPublicationDate() {
        return this.publicationDate;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUri() {
        return this.uri;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\b\u0018\u0000 32\u00020\u0001:\u0003123BI\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fBS\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u000b\u0010\u0010J\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003JM\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\u0005HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J%\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0001¢\u0006\u0002\b0R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u00064"}, d2 = {"Lcom/google/firebase/ai/type/Citation$Internal;", "", "title", "", "startIndex", "", "endIndex", ShareConstants.MEDIA_URI, "license", "publicationDate", "Lcom/google/firebase/ai/type/Citation$Internal$Date;", "<init>", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/Citation$Internal$Date;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;Lcom/google/firebase/ai/type/Citation$Internal$Date;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getTitle", "()Ljava/lang/String;", "getStartIndex", "()I", "getEndIndex", "getUri", "getLicense", "getPublicationDate", "()Lcom/google/firebase/ai/type/Citation$Internal$Date;", "toPublic", "Lcom/google/firebase/ai/type/Citation;", "toPublic$com_google_firebase_ai_logic_firebase_ai", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "Date", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Serializable
    public static final /* data */ class Internal {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final int endIndex;
        private final String license;
        private final Date publicationDate;
        private final int startIndex;
        private final String title;
        private final String uri;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Citation$Internal$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Citation$Internal;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Internal> serializer() {
                return Citation$Internal$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ Internal(int i, String str, int i2, int i3, String str2, String str3, Date date, SerializationConstructorMarker serializationConstructorMarker) {
            if (4 != (i & 4)) {
                PluginExceptionsKt.throwMissingFieldException(i, 4, Citation$Internal$$serializer.INSTANCE.getDescriptor());
            }
            if ((i & 1) == 0) {
                this.title = null;
            } else {
                this.title = str;
            }
            if ((i & 2) == 0) {
                this.startIndex = 0;
            } else {
                this.startIndex = i2;
            }
            this.endIndex = i3;
            if ((i & 8) == 0) {
                this.uri = null;
            } else {
                this.uri = str2;
            }
            if ((i & 16) == 0) {
                this.license = null;
            } else {
                this.license = str3;
            }
            if ((i & 32) == 0) {
                this.publicationDate = null;
            } else {
                this.publicationDate = date;
            }
        }

        public static /* synthetic */ Internal copy$default(Internal internal, String str, int i, int i2, String str2, String str3, Date date, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = internal.title;
            }
            if ((i3 & 2) != 0) {
                i = internal.startIndex;
            }
            if ((i3 & 4) != 0) {
                i2 = internal.endIndex;
            }
            if ((i3 & 8) != 0) {
                str2 = internal.uri;
            }
            if ((i3 & 16) != 0) {
                str3 = internal.license;
            }
            if ((i3 & 32) != 0) {
                date = internal.publicationDate;
            }
            String str4 = str3;
            Date date2 = date;
            return internal.copy(str, i, i2, str2, str4, date2);
        }

        public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Internal self, CompositeEncoder output, SerialDescriptor serialDesc) {
            if (output.shouldEncodeElementDefault(serialDesc, 0) || self.title != null) {
                output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.title);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 1) || self.startIndex != 0) {
                output.encodeIntElement(serialDesc, 1, self.startIndex);
            }
            output.encodeIntElement(serialDesc, 2, self.endIndex);
            if (output.shouldEncodeElementDefault(serialDesc, 3) || self.uri != null) {
                output.encodeNullableSerializableElement(serialDesc, 3, StringSerializer.INSTANCE, self.uri);
            }
            if (output.shouldEncodeElementDefault(serialDesc, 4) || self.license != null) {
                output.encodeNullableSerializableElement(serialDesc, 4, StringSerializer.INSTANCE, self.license);
            }
            if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.publicationDate == null) {
                return;
            }
            output.encodeNullableSerializableElement(serialDesc, 5, Citation$Internal$Date$$serializer.INSTANCE, self.publicationDate);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getTitle() {
            return this.title;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getStartIndex() {
            return this.startIndex;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getEndIndex() {
            return this.endIndex;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getUri() {
            return this.uri;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final String getLicense() {
            return this.license;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Date getPublicationDate() {
            return this.publicationDate;
        }

        public final Internal copy(String title, int startIndex, int endIndex, String uri, String license, Date publicationDate) {
            return new Internal(title, startIndex, endIndex, uri, license, publicationDate);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Internal)) {
                return false;
            }
            Internal internal = (Internal) other;
            return Intrinsics.areEqual(this.title, internal.title) && this.startIndex == internal.startIndex && this.endIndex == internal.endIndex && Intrinsics.areEqual(this.uri, internal.uri) && Intrinsics.areEqual(this.license, internal.license) && Intrinsics.areEqual(this.publicationDate, internal.publicationDate);
        }

        public final int getEndIndex() {
            return this.endIndex;
        }

        public final String getLicense() {
            return this.license;
        }

        public final Date getPublicationDate() {
            return this.publicationDate;
        }

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUri() {
            return this.uri;
        }

        public int hashCode() {
            String str = this.title;
            int iM = FileInsert$$ExternalSyntheticOutline0.m(this.endIndex, FileInsert$$ExternalSyntheticOutline0.m(this.startIndex, (str == null ? 0 : str.hashCode()) * 31, 31), 31);
            String str2 = this.uri;
            int iHashCode = (iM + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.license;
            int iHashCode2 = (iHashCode + (str3 == null ? 0 : str3.hashCode())) * 31;
            Date date = this.publicationDate;
            return iHashCode2 + (date != null ? date.hashCode() : 0);
        }

        public final Citation toPublic$com_google_firebase_ai_logic_firebase_ai() {
            Calendar calendar;
            Date date = this.publicationDate;
            if (date != null) {
                calendar = Calendar.getInstance();
                int iIntValue = 1;
                int iIntValue2 = (date.getYear() == null || date.getYear().intValue() < 1) ? 1 : date.getYear().intValue();
                int iIntValue3 = (date.getMonth() == null || date.getMonth().intValue() < 1) ? 0 : date.getMonth().intValue() - 1;
                if (date.getDay() != null && date.getDay().intValue() >= 1) {
                    iIntValue = date.getDay().intValue();
                }
                calendar.set(iIntValue2, iIntValue3, iIntValue);
            } else {
                calendar = null;
            }
            return new Citation(this.title, this.startIndex, this.endIndex, this.uri, this.license, calendar);
        }

        public String toString() {
            return "Internal(title=" + this.title + ", startIndex=" + this.startIndex + ", endIndex=" + this.endIndex + ", uri=" + this.uri + ", license=" + this.license + ", publicationDate=" + this.publicationDate + ')';
        }

        @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 %2\u00020\u0001:\u0002$%B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007B9\b\u0010\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\u000bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\r¨\u0006&"}, d2 = {"Lcom/google/firebase/ai/type/Citation$Internal$Date;", "", "year", "", "month", "day", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getYear", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMonth", "getDay", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/google/firebase/ai/type/Citation$Internal$Date;", "equals", "", "other", "hashCode", InAppPurchaseConstants.METHOD_TO_STRING, "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$com_google_firebase_ai_logic_firebase_ai", "$serializer", "Companion", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
        @Serializable
        public static final /* data */ class Date {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final Integer day;
            private final Integer month;
            private final Integer year;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/google/firebase/ai/type/Citation$Internal$Date$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/google/firebase/ai/type/Citation$Internal$Date;", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Date> serializer() {
                    return Citation$Internal$Date$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Date(int i, Integer num, Integer num2, Integer num3, SerializationConstructorMarker serializationConstructorMarker) {
                if ((i & 1) == 0) {
                    this.year = null;
                } else {
                    this.year = num;
                }
                if ((i & 2) == 0) {
                    this.month = null;
                } else {
                    this.month = num2;
                }
                if ((i & 4) == 0) {
                    this.day = null;
                } else {
                    this.day = num3;
                }
            }

            public static /* synthetic */ Date copy$default(Date date, Integer num, Integer num2, Integer num3, int i, Object obj) {
                if ((i & 1) != 0) {
                    num = date.year;
                }
                if ((i & 2) != 0) {
                    num2 = date.month;
                }
                if ((i & 4) != 0) {
                    num3 = date.day;
                }
                return date.copy(num, num2, num3);
            }

            public static final /* synthetic */ void write$Self$com_google_firebase_ai_logic_firebase_ai(Date self, CompositeEncoder output, SerialDescriptor serialDesc) {
                if (output.shouldEncodeElementDefault(serialDesc, 0) || self.year != null) {
                    output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.year);
                }
                if (output.shouldEncodeElementDefault(serialDesc, 1) || self.month != null) {
                    output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.month);
                }
                if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.day == null) {
                    return;
                }
                output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.day);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Integer getYear() {
                return this.year;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Integer getMonth() {
                return this.month;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Integer getDay() {
                return this.day;
            }

            public final Date copy(Integer year, Integer month, Integer day) {
                return new Date(year, month, day);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Date)) {
                    return false;
                }
                Date date = (Date) other;
                return Intrinsics.areEqual(this.year, date.year) && Intrinsics.areEqual(this.month, date.month) && Intrinsics.areEqual(this.day, date.day);
            }

            public final Integer getDay() {
                return this.day;
            }

            public final Integer getMonth() {
                return this.month;
            }

            public final Integer getYear() {
                return this.year;
            }

            public int hashCode() {
                Integer num = this.year;
                int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
                Integer num2 = this.month;
                int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
                Integer num3 = this.day;
                return iHashCode2 + (num3 != null ? num3.hashCode() : 0);
            }

            public String toString() {
                return "Date(year=" + this.year + ", month=" + this.month + ", day=" + this.day + ')';
            }

            public Date() {
                this((Integer) null, (Integer) null, (Integer) null, 7, (DefaultConstructorMarker) null);
            }

            public Date(Integer num, Integer num2, Integer num3) {
                this.year = num;
                this.month = num2;
                this.day = num3;
            }

            public /* synthetic */ Date(Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3);
            }
        }

        public Internal(String str, int i, int i2, String str2, String str3, Date date) {
            this.title = str;
            this.startIndex = i;
            this.endIndex = i2;
            this.uri = str2;
            this.license = str3;
            this.publicationDate = date;
        }

        public /* synthetic */ Internal(String str, int i, int i2, String str2, String str3, Date date, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? 0 : i, i2, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : date);
        }
    }

    public Citation(String str, int i, int i2, String str2, String str3, Calendar calendar) {
        this.title = str;
        this.startIndex = i;
        this.endIndex = i2;
        this.uri = str2;
        this.license = str3;
        this.publicationDate = calendar;
    }
}
