package com.samsung.android.sdk.healthdata;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.text.TextUtils;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.samsung.android.sdk.internal.database.BulkCursorDescriptor;
import com.samsung.android.sdk.internal.database.BulkCursorToCursorAdaptor;
import com.samsung.android.sdk.internal.database.IBulkCursor;
import com.samsung.android.sdk.internal.healthdata.AggregateRequestImpl;
import com.samsung.android.sdk.internal.healthdata.DeleteRequestImpl;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.HealthResultHolderImpl;
import com.samsung.android.sdk.internal.healthdata.HealthResultReceiver;
import com.samsung.android.sdk.internal.healthdata.InsertRequestImpl;
import com.samsung.android.sdk.internal.healthdata.IpcUtil;
import com.samsung.android.sdk.internal.healthdata.ReadRequestImpl;
import com.samsung.android.sdk.internal.healthdata.query.AndFilter;
import com.samsung.android.sdk.internal.healthdata.query.ComparisonFilter;
import com.samsung.android.sdk.internal.healthdata.query.NotFilter;
import com.samsung.android.sdk.internal.healthdata.query.NumberArrayFilter;
import com.samsung.android.sdk.internal.healthdata.query.OrFilter;
import com.samsung.android.sdk.internal.healthdata.query.StringArrayFilter;
import com.samsung.android.sdk.internal.healthdata.query.StringFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
public class HealthDataResolver {
    private final HealthDataStore a;
    private final Handler b;

    /* JADX INFO: loaded from: classes5.dex */
    public interface DeleteRequest {

        public static class Builder {
            private String a;
            private Filter b;
            private List<String> c;

            public DeleteRequest build() {
                String str = this.a;
                if (str == null || "".equals(str)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("No data type or invalid data type is specified");
                    return null;
                }
                List<String> list = this.c;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("Null device uuid");
                            return null;
                        }
                    }
                }
                return new DeleteRequestImpl(this.a, this.b, this.c);
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }

            public Builder setFilter(Filter filter) {
                this.b = filter;
                return this;
            }
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface InsertRequest {

        public static class Builder {
            private String a;

            public InsertRequest build() {
                String str = this.a;
                if (str != null && !"".equals(str)) {
                    return new InsertRequestImpl(this.a);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("No data type or invalid data type is specified");
                return null;
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }
        }

        void addHealthData(HealthData healthData);
    }

    public interface ReadRequest {

        public static class Builder {
            private String a;
            private String b;
            private Filter c;
            private String d;
            private SortOrder e;
            private List<String> f;
            private String[] l;
            private long g = -1;
            private long h = -1;
            private int i = 0;
            private int j = -1;
            private int k = 0;
            private final List<ReadRequestImpl.Projection> m = new ArrayList();
            private String n = null;
            private String o = null;
            private long p = -1;
            private boolean q = false;
            private boolean r = false;

            public ReadRequest build() {
                String str;
                if (this.q && this.p < 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Illegal setTimeAfter value is specified");
                    return null;
                }
                if (this.r && this.h < 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("Illegal setTimeBefore value is specified");
                    return null;
                }
                String str2 = this.a;
                if (str2 == null || "".equals(str2)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("No data type or invalid data type is specified");
                    return null;
                }
                String str3 = this.o;
                if (str3 != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(str3);
                    return null;
                }
                String str4 = this.n;
                if (str4 != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(str4);
                    return null;
                }
                for (ReadRequestImpl.Projection projection : this.m) {
                    if (projection.getAlias() == null || projection.getAlias().isEmpty()) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Null or empty alias for read request is not allowed");
                        return null;
                    }
                }
                List<String> list = this.f;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("Null device uuid");
                            return null;
                        }
                    }
                }
                String str5 = this.d;
                if (str5 != null) {
                    if (this.e != null) {
                        str5 = this.d + " " + this.e.toSqlLiteral();
                    }
                    str = str5;
                } else {
                    str = null;
                }
                if (this.k != 1) {
                    this.j = 0;
                } else {
                    if (this.j <= 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Wrong count (zero or negative number)");
                        return null;
                    }
                    if (this.i < 0) {
                        Utf8$$ExternalSyntheticBUOutline0.m$3("Wrong offset (negative number)");
                        return null;
                    }
                }
                int size = this.m.size();
                String[] strArr = this.l;
                if (strArr == null || strArr.length == 0) {
                    return new ReadRequestImpl(this.a, this.b, this.c, size > 0 ? this.m : null, this.f, (byte) 1, str, this.g, this.h, this.i, this.j, this.p);
                }
                ArrayList arrayList = new ArrayList(this.l.length);
                for (String str6 : this.l) {
                    int i = 0;
                    while (i < size) {
                        String property = this.m.get(i).getProperty();
                        if (str6 != null && str6.equalsIgnoreCase(property)) {
                            break;
                        }
                        i++;
                    }
                    if (i < size) {
                        arrayList.add(this.m.remove(i));
                        size--;
                    } else {
                        arrayList.add(new ReadRequestImpl.Projection(str6, null));
                    }
                }
                if (size == 0 || this.m.size() <= 0) {
                    return new ReadRequestImpl(this.a, this.b, this.c, arrayList, this.f, (byte) 0, str, this.g, this.h, this.i, this.j, this.p);
                }
                Utf8$$ExternalSyntheticBUOutline0.m$3("Not matched aliases");
                return null;
            }

            public Builder setDataType(String str) {
                this.a = str;
                return this;
            }

            public Builder setFilter(Filter filter) {
                this.c = filter;
                return this;
            }

            public Builder setPackageName(String str) {
                this.b = str;
                return this;
            }
        }
    }

    public HealthDataResolver(HealthDataStore healthDataStore, Handler handler) {
        this.a = healthDataStore;
        this.b = handler;
    }

    private IDataResolver a() {
        try {
            IDataResolver iDataResolver = HealthDataStore.getInterface(this.a).getIDataResolver();
            if (iDataResolver != null) {
                return iDataResolver;
            }
            throw new IllegalStateException("IDataResolver is null");
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    private Looper b() {
        Handler handler = this.b;
        Looper looper = handler != null ? handler.getLooper() : Looper.myLooper();
        if (looper != null) {
            return looper;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("This thread has no looper");
        return null;
    }

    public HealthResultHolder<AggregateResult> aggregate(AggregateRequest aggregateRequest) {
        if (!(aggregateRequest instanceof AggregateRequestImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid aggregate request");
            return null;
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        AggregateRequestImpl aggregateRequestImpl = (AggregateRequestImpl) aggregateRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<AggregateResult> asyncResultHolder = IpcUtil.getAsyncResultHolder(forwardAsync, looperB);
            iDataResolverA.aggregateData2(this.a.a().getPackageName(), forwardAsync, aggregateRequestImpl);
            return asyncResultHolder;
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> delete(DeleteRequest deleteRequest) {
        if (!(deleteRequest instanceof DeleteRequestImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid request instance");
            return null;
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        DeleteRequestImpl deleteRequestImpl = (DeleteRequestImpl) deleteRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<HealthResultHolder.BaseResult> asyncResultHolder = IpcUtil.getAsyncResultHolder(forwardAsync, looperB);
            iDataResolverA.deleteData2(this.a.a().getPackageName(), forwardAsync, deleteRequestImpl);
            return asyncResultHolder;
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    public HealthResultHolder<HealthResultHolder.BaseResult> insert(InsertRequest insertRequest) throws Throwable {
        if (!(insertRequest instanceof InsertRequestImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid request instance");
            return null;
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        InsertRequestImpl insertRequestImpl = (InsertRequestImpl) insertRequest;
        if (insertRequestImpl.isEmpty()) {
            return HealthResultHolderImpl.createAndSetResult(new HealthResultHolder.BaseResult(1, 0), looperB);
        }
        for (HealthData healthData : insertRequestImpl.getItems()) {
            for (String str : healthData.getBlobKeySet()) {
                byte[] blob = healthData.getBlob(str);
                if (blob != null && blob.length > 1024000) {
                    Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(blob.length, " Bytes", FileInsert$$ExternalSyntheticOutline0.m5m("Blob data size is bigger than 1000KB : ", str, " is ")));
                    return null;
                }
            }
        }
        try {
            for (HealthData healthData2 : insertRequestImpl.getItems()) {
                Iterator<String> it = healthData2.getBlobKeySet().iterator();
                while (it.hasNext()) {
                    IpcUtil.sendBlob(healthData2, it.next());
                }
            }
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<HealthResultHolder.BaseResult> asyncResultHolder = IpcUtil.getAsyncResultHolder(forwardAsync, looperB);
            iDataResolverA.insertData2(this.a.a().getPackageName(), forwardAsync, insertRequestImpl);
            return asyncResultHolder;
        } catch (TransactionTooLargeException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$2(e);
            return null;
        } catch (RemoteException e2) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e2));
            return null;
        }
    }

    public HealthResultHolder<ReadResult> read(ReadRequest readRequest) {
        if (!(readRequest instanceof ReadRequestImpl)) {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid request instance");
            return null;
        }
        IDataResolver iDataResolverA = a();
        Looper looperB = b();
        ReadRequestImpl readRequestImpl = (ReadRequestImpl) readRequest;
        try {
            HealthResultReceiver.ForwardAsync forwardAsync = new HealthResultReceiver.ForwardAsync();
            HealthResultHolder<ReadResult> asyncResultHolder = IpcUtil.getAsyncResultHolder(forwardAsync, looperB);
            iDataResolverA.readData2(this.a.a().getPackageName(), forwardAsync, readRequestImpl);
            return asyncResultHolder;
        } catch (RemoteException e) {
            Utf8$$ExternalSyntheticBUOutline0.m$3(ErrorUtil.getRemoteExceptionMessage(e));
            return null;
        }
    }

    public static abstract class Filter implements Parcelable {
        public static final Parcelable.Creator<Filter> CREATOR = new Parcelable.Creator<Filter>() { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Filter createFromParcel(Parcel parcel) {
                int iDataPosition = parcel.dataPosition();
                ParcelType parcelType = (ParcelType) parcel.readParcelable(ParcelType.class.getClassLoader());
                parcel.setDataPosition(iDataPosition);
                return parcelType.a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Filter[] newArray(int i) {
                return new Filter[i];
            }
        };
        protected List<Filter> mFilters = new ArrayList();
        protected ParcelType mType;

        public static Filter and(Filter filter, Filter... filterArr) {
            if (filter != null && filterArr != null) {
                return new AndFilter(filter, filterArr);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Filter arguments for and method should not be null");
            return null;
        }

        public static void checkFilter(Filter filter) {
            if (filter != null) {
                return;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid filter instance");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<T>> Filter greaterThanEquals(String str, T t) {
            if (str != null && (t instanceof Number)) {
                return new ComparisonFilter(ComparisonFilter.Operator.GREATER_THAN_EQUALS, str, (Number) t);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid property or value");
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> Filter in(String str, T[] tArr) {
            if (TextUtils.isEmpty(str) || tArr == 0 || tArr.length == 0) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid property or values");
                return null;
            }
            if (tArr instanceof Number[]) {
                return new NumberArrayFilter(str, (Number[]) tArr);
            }
            if (tArr instanceof String[]) {
                return new StringArrayFilter(str, (String[]) tArr);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid type of value");
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T extends Comparable<T>> Filter lessThanEquals(String str, T t) {
            if (str != null && (t instanceof Number)) {
                return new ComparisonFilter(ComparisonFilter.Operator.LESS_THAN_EQUALS, str, (Number) t);
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2("Invalid property or value");
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void readFromParcel(Parcel parcel) {
            this.mType = (ParcelType) parcel.readParcelable(ParcelType.class.getClassLoader());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.mType, 0);
        }

        public enum ParcelType implements Parcelable {
            COMPARABLE { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.1
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new ComparisonFilter(parcel);
                }
            },
            STRING { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.2
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new StringFilter(parcel);
                }
            },
            STRING_ARRAY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.3
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new StringArrayFilter(parcel);
                }
            },
            NUMBER_ARRAY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.4
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new NumberArrayFilter(parcel);
                }
            },
            AND { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.5
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new AndFilter(parcel);
                }
            },
            OR { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.6
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new OrFilter(parcel);
                }
            },
            NOT { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.7
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType
                public final Filter a(Parcel parcel) {
                    return new NotFilter(parcel);
                }
            };

            public static final Parcelable.Creator<ParcelType> CREATOR = new Parcelable.Creator<ParcelType>() { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.Filter.ParcelType.8
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ ParcelType createFromParcel(Parcel parcel) {
                    return ParcelType.values()[parcel.readInt()];
                }

                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ ParcelType[] newArray(int i) {
                    return new ParcelType[i];
                }
            };

            public abstract Filter a(Parcel parcel);

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(ordinal());
            }

            /* synthetic */ ParcelType(byte b) {
                this();
            }
        }
    }

    public enum SortOrder {
        ASC { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder.1
            @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder
            public final String toSqlLiteral() {
                return "ASC";
            }
        },
        DESC { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder.2
            @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.SortOrder
            public final String toSqlLiteral() {
                return "DESC";
            }
        };

        public abstract String toSqlLiteral();

        /* synthetic */ SortOrder(byte b) {
            this();
        }
    }

    public interface AggregateRequest {

        public static class Builder {
            private AggregateRequestImpl.TimeGroup e;
            private String g;
            private String h;
            private Filter i;
            private List<String> j;
            private String k;
            private SortOrder l;
            private final List<AggregateRequestImpl.AggregatePair> a = new ArrayList();
            private String b = null;
            private final List<AggregateRequestImpl.Group> c = new ArrayList();
            private String d = null;
            private String f = null;
            private long m = -1;
            private long n = -1;

            public Builder addFunction(AggregateFunction aggregateFunction, String str, String str2) {
                try {
                    this.a.add(new AggregateRequestImpl.AggregatePair(aggregateFunction, str, str2));
                    return this;
                } catch (IllegalArgumentException e) {
                    this.b = e.getMessage();
                    return this;
                }
            }

            public AggregateRequest build() {
                String str;
                String str2 = this.g;
                String str3 = null;
                if (str2 == null || "".equals(str2)) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("No data type or invalid data type is specified");
                    return null;
                }
                if (this.a.size() <= 0) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("No aggregate function is included");
                    return null;
                }
                String str4 = this.b;
                if (str4 != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(str4);
                    return null;
                }
                String str5 = this.f;
                if (str5 != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(str5);
                    return null;
                }
                String str6 = this.d;
                if (str6 != null) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3(str6);
                    return null;
                }
                List<String> list = this.j;
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() == null) {
                            Utf8$$ExternalSyntheticBUOutline0.m$3("Null device uuid");
                            return null;
                        }
                    }
                }
                String str7 = this.k;
                if (str7 == null) {
                    str = str3;
                } else if (this.l != null) {
                    str3 = this.k + " " + this.l.toSqlLiteral();
                    str = str3;
                } else {
                    str = str7;
                }
                return new AggregateRequestImpl(this.g, this.h, this.a, this.c, this.e, this.i, this.j, str, this.m, this.n);
            }

            public Builder setDataType(String str) {
                this.g = str;
                return this;
            }

            public Builder setTimeGroup(TimeGroupUnit timeGroupUnit, int i, String str, String str2, String str3) {
                try {
                    this.e = new AggregateRequestImpl.TimeGroup(timeGroupUnit, i, str, str2, str3);
                    return this;
                } catch (IllegalArgumentException e) {
                    this.f = e.getMessage();
                    return this;
                }
            }
        }

        public enum AggregateFunction {
            SUM { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.1
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                public final String toSqlLiteral() {
                    return "SUM";
                }
            },
            MIN { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.2
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                public final String toSqlLiteral() {
                    return "MIN";
                }
            },
            MAX { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.3
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                public final String toSqlLiteral() {
                    return "MAX";
                }
            },
            AVG { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.4
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                public final String toSqlLiteral() {
                    return "AVG";
                }
            },
            COUNT { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction.5
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.AggregateFunction
                public final String toSqlLiteral() {
                    return "COUNT";
                }
            };

            private final int a;

            AggregateFunction(int i) {
                this.a = i;
            }

            public static AggregateFunction from(int i) {
                if (i >= 0 && i <= 4) {
                    return values()[i];
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid range : "));
                return null;
            }

            public int getValue() {
                return this.a;
            }

            public abstract String toSqlLiteral();

            /* synthetic */ AggregateFunction(int i, byte b2) {
                this(i);
            }
        }

        public enum TimeGroupUnit {
            MINUTELY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.1
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                public final String toSqlLiteral(String str, String str2, int i) {
                    StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("strftime('%Y-%m-%d %H:%M', (strftime('%s', ", str, "/1000", str2 != null ? FileInsert$$ExternalSyntheticOutline0.m(MqttTopic.SINGLE_LEVEL_WILDCARD, str2, "/1000, 'unixepoch'") : ", 'unixepoch', 'localtime'", ")/(");
                    int i2 = i * 60;
                    sbM6m.append(i2);
                    sbM6m.append("))*(");
                    sbM6m.append(i2);
                    sbM6m.append("), 'unixepoch')");
                    return sbM6m.toString();
                }
            },
            HOURLY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.2
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                public final String toSqlLiteral(String str, String str2, int i) {
                    StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("strftime('%Y-%m-%d %H', (strftime('%s', ", str, "/1000", str2 != null ? FileInsert$$ExternalSyntheticOutline0.m(MqttTopic.SINGLE_LEVEL_WILDCARD, str2, "/1000, 'unixepoch'") : ", 'unixepoch', 'localtime'", ")/(");
                    int i2 = i * 3600;
                    sbM6m.append(i2);
                    sbM6m.append("))*(");
                    sbM6m.append(i2);
                    sbM6m.append("), 'unixepoch')");
                    return sbM6m.toString();
                }
            },
            DAILY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.3
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                public final String toSqlLiteral(String str, String str2, int i) {
                    return FileInsert$$ExternalSyntheticOutline0.m("strftime('%Y-%m-%d', strftime('%s', ", str, "/1000", str2 != null ? FileInsert$$ExternalSyntheticOutline0.m(MqttTopic.SINGLE_LEVEL_WILDCARD, str2, "/1000, 'unixepoch'") : ", 'unixepoch', 'localtime'", "), 'unixepoch')");
                }
            },
            WEEKLY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.4
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                public final String toSqlLiteral(String str, String str2, int i) {
                    return FileInsert$$ExternalSyntheticOutline0.m("strftime('%Y-%W', strftime('%s', ", str, "/1000", str2 != null ? FileInsert$$ExternalSyntheticOutline0.m(MqttTopic.SINGLE_LEVEL_WILDCARD, str2, "/1000, 'unixepoch'") : ", 'unixepoch', 'localtime'", "), 'unixepoch')");
                }
            },
            MONTHLY { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit.5
                @Override // com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateRequest.TimeGroupUnit
                public final String toSqlLiteral(String str, String str2, int i) {
                    String strM = str2 != null ? FileInsert$$ExternalSyntheticOutline0.m(MqttTopic.SINGLE_LEVEL_WILDCARD, str2, "/1000, 'unixepoch'") : ", 'unixepoch', 'localtime'";
                    return i != 3 ? i != 6 ? FileInsert$$ExternalSyntheticOutline0.m("strftime('%Y-%m', datetime(strftime('%s', ", str, "/1000", strM, "), 'unixepoch'))") : Fragment$$ExternalSyntheticOutline1.m(FileInsert$$ExternalSyntheticOutline0.m6m("strftime('%Y', strftime('%s', ", str, "/1000", strM, "), 'unixepoch') || '-' || CASE  WHEN strftime('%m', strftime('%s', "), str, "/1000", strM, "), 'unixepoch') <= '06' THEN '01' ELSE '07' END") : Fragment$$ExternalSyntheticOutline1.m(FileInsert$$ExternalSyntheticOutline0.m6m("strftime('%Y', strftime('%s', ", str, "/1000", strM, "), 'unixepoch') || '-' || CASE strftime('%m', strftime('%s', "), str, "/1000", strM, "), 'unixepoch') WHEN '01' THEN '01' WHEN '02' THEN '01' WHEN '03' THEN '01' WHEN '04' THEN '04' WHEN '05' THEN '04' WHEN '06' THEN '04'  WHEN '07' THEN '07' WHEN  '08' THEN '07' WHEN '09' THEN '07'  WHEN '10' THEN '10' WHEN '11' THEN '10' WHEN '12' THEN '10' END");
                }
            };

            private final int a;

            TimeGroupUnit(int i) {
                this.a = i;
            }

            public static TimeGroupUnit from(int i) {
                if (i >= 0 && i <= MONTHLY.getValue()) {
                    return values()[i];
                }
                Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m(i, "Invalid range : "));
                return null;
            }

            public int getValue() {
                return this.a;
            }

            public abstract String toSqlLiteral(String str, String str2, int i);

            /* synthetic */ TimeGroupUnit(int i, byte b2) {
                this(i);
            }
        }
    }

    public static class AggregateResult extends HealthResultHolder.BaseResult {
        public static final Parcelable.Creator<AggregateResult> CREATOR = new Parcelable.Creator<AggregateResult>() { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.AggregateResult.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AggregateResult createFromParcel(Parcel parcel) {
                return new AggregateResult(parcel, (byte) 0);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AggregateResult[] newArray(int i) {
                return new AggregateResult[i];
            }
        };
        private final BulkCursorDescriptor a;
        private final String b;
        private boolean c;

        private AggregateResult(Parcel parcel) {
            super(parcel);
            this.b = parcel.readString();
            this.a = (BulkCursorDescriptor) parcel.readParcelable(BulkCursorDescriptor.class.getClassLoader());
        }

        public void finalize() throws Throwable {
            IBulkCursor iBulkCursor;
            BulkCursorDescriptor bulkCursorDescriptor = this.a;
            if (bulkCursorDescriptor != null && !this.c && (iBulkCursor = bulkCursorDescriptor.cursor) != null) {
                iBulkCursor.close();
            }
            super.finalize();
        }

        public Cursor getResultCursor() {
            if (this.a == null) {
                return null;
            }
            BulkCursorToCursorAdaptor bulkCursorToCursorAdaptor = new BulkCursorToCursorAdaptor();
            bulkCursorToCursorAdaptor.initialize(this.a);
            this.c = true;
            return bulkCursorToCursorAdaptor;
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.b);
            parcel.writeParcelable(this.a, i);
        }

        public /* synthetic */ AggregateResult(Parcel parcel, byte b) {
            this(parcel);
        }
    }

    public static class ReadResult extends HealthResultHolder.BaseResult {
        public static final Parcelable.Creator<ReadResult> CREATOR = new Parcelable.Creator<ReadResult>() { // from class: com.samsung.android.sdk.healthdata.HealthDataResolver.ReadResult.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ReadResult createFromParcel(Parcel parcel) {
                return new ReadResult(parcel, (byte) 0);
            }

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ReadResult[] newArray(int i) {
                return new ReadResult[i];
            }
        };
        private final BulkCursorDescriptor a;
        private final String b;
        private boolean c;

        private ReadResult(Parcel parcel) {
            super(parcel);
            this.b = parcel.readString();
            this.a = (BulkCursorDescriptor) parcel.readParcelable(BulkCursorDescriptor.class.getClassLoader());
        }

        public void finalize() throws Throwable {
            IBulkCursor iBulkCursor;
            BulkCursorDescriptor bulkCursorDescriptor = this.a;
            if (bulkCursorDescriptor != null && !this.c && (iBulkCursor = bulkCursorDescriptor.cursor) != null) {
                iBulkCursor.close();
            }
            super.finalize();
        }

        public Cursor getResultCursor() {
            if (this.a == null) {
                return null;
            }
            BulkCursorToCursorAdaptor bulkCursorToCursorAdaptor = new BulkCursorToCursorAdaptor();
            bulkCursorToCursorAdaptor.initialize(this.a);
            this.c = true;
            return bulkCursorToCursorAdaptor;
        }

        @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.BaseResult, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.b);
            parcel.writeParcelable(this.a, 0);
        }

        public /* synthetic */ ReadResult(Parcel parcel, byte b) {
            this(parcel);
        }
    }
}
