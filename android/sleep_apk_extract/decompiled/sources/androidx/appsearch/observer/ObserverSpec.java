package androidx.appsearch.observer;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appsearch.safeparcel.AbstractSafeParcelable;
import androidx.appsearch.safeparcel.stub.AbstractCreator;
import androidx.collection.ArraySet;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ObserverSpec extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ObserverSpec> CREATOR = new AbstractCreator<ObserverSpec>() { // from class: androidx.appsearch.safeparcel.stub.StubCreators$ObserverSpecCreator
        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
            return super.createFromParcel(parcel);
        }

        @Override // androidx.appsearch.safeparcel.stub.AbstractCreator, android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return super.newArray(i);
        }
    };
    final List<String> mFilterSchemas;
    private volatile Set<String> mFilterSchemasCached;

    public static final class Builder {
        private ArrayList<String> mFilterSchemas = new ArrayList<>();
        private boolean mBuilt = false;

        private void resetIfBuilt() {
            if (this.mBuilt) {
                this.mFilterSchemas = new ArrayList<>(this.mFilterSchemas);
                this.mBuilt = false;
            }
        }

        public Builder addFilterSchemas(Collection<String> collection) {
            Preconditions.checkNotNull(collection);
            resetIfBuilt();
            this.mFilterSchemas.addAll(collection);
            return this;
        }

        public ObserverSpec build() {
            this.mBuilt = true;
            return new ObserverSpec(this.mFilterSchemas);
        }
    }

    public ObserverSpec(List<String> list) {
        this.mFilterSchemas = (List) Preconditions.checkNotNull(list);
    }

    public Set<String> getFilterSchemas() {
        if (this.mFilterSchemasCached == null) {
            List<String> list = this.mFilterSchemas;
            if (list == null) {
                this.mFilterSchemasCached = Collections.EMPTY_SET;
            } else {
                this.mFilterSchemasCached = Collections.unmodifiableSet(new ArraySet(list));
            }
        }
        return this.mFilterSchemasCached;
    }
}
