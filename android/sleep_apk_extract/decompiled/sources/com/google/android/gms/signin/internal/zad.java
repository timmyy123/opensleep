package com.google.android.gms.signin.internal;

import android.os.Parcel;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zad extends com.google.android.gms.internal.base.zab implements zae {
    public zad() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // com.google.android.gms.internal.base.zab
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                com.google.android.gms.internal.base.zac.zad(parcel);
                break;
            case 4:
                com.google.android.gms.internal.base.zac.zad(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                com.google.android.gms.internal.base.zac.zad(parcel);
                break;
            case 7:
                com.google.android.gms.internal.base.zac.zad(parcel);
                break;
            case 8:
                zak zakVar = (zak) com.google.android.gms.internal.base.zac.zaa(parcel, zak.CREATOR);
                com.google.android.gms.internal.base.zac.zad(parcel);
                zab(zakVar);
                break;
            case 9:
                com.google.android.gms.internal.base.zac.zad(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
