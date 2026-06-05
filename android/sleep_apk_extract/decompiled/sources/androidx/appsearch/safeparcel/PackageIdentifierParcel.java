package androidx.appsearch.safeparcel;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class PackageIdentifierParcel extends AbstractSafeParcelable implements Parcelable {
    public static final Parcelable.Creator<PackageIdentifierParcel> CREATOR = new PackageIdentifierParcelCreator();
    private final String mPackageName;
    private final byte[] mSha256Certificate;

    public PackageIdentifierParcel(String str, byte[] bArr) {
        this.mPackageName = (String) Preconditions.checkNotNull(str);
        this.mSha256Certificate = (byte[]) Preconditions.checkNotNull(bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PackageIdentifierParcel)) {
            return false;
        }
        PackageIdentifierParcel packageIdentifierParcel = (PackageIdentifierParcel) obj;
        return this.mPackageName.equals(packageIdentifierParcel.mPackageName) && Arrays.equals(this.mSha256Certificate, packageIdentifierParcel.mSha256Certificate);
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public byte[] getSha256Certificate() {
        return this.mSha256Certificate;
    }

    public int hashCode() {
        return Objects.hash(this.mPackageName, Integer.valueOf(Arrays.hashCode(this.mSha256Certificate)));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        PackageIdentifierParcelCreator.writeToParcel(this, parcel, i);
    }
}
