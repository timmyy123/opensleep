package androidx.appsearch.safeparcel;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class PackageIdentifierParcelCreator implements Parcelable.Creator<PackageIdentifierParcel> {
    private static Bundle createBundleFromPackageIdentifier(PackageIdentifierParcel packageIdentifierParcel) {
        Objects.requireNonNull(packageIdentifierParcel);
        Bundle bundle = new Bundle();
        bundle.putString("packageName", packageIdentifierParcel.getPackageName());
        bundle.putByteArray("sha256Certificate", packageIdentifierParcel.getSha256Certificate());
        return bundle;
    }

    private static PackageIdentifierParcel createPackageIdentifierFromBundle(Bundle bundle) {
        Objects.requireNonNull(bundle);
        return new PackageIdentifierParcel((String) Preconditions.checkNotNull(bundle.getString("packageName")), (byte[]) Preconditions.checkNotNull(bundle.getByteArray("sha256Certificate")));
    }

    public static void writeToParcel(PackageIdentifierParcel packageIdentifierParcel, Parcel parcel, int i) {
        parcel.writeBundle(createBundleFromPackageIdentifier(packageIdentifierParcel));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PackageIdentifierParcel createFromParcel(Parcel parcel) {
        return createPackageIdentifierFromBundle((Bundle) Preconditions.checkNotNull(parcel.readBundle(getClass().getClassLoader())));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public PackageIdentifierParcel[] newArray(int i) {
        return new PackageIdentifierParcel[i];
    }
}
