package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.api.Scope;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface GoogleSignInOptionsExtension {
    int getExtensionType();

    List<Scope> getImpliedScopes();

    Bundle toBundle();
}
