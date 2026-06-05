package io.ktor.http;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b>\u0018\u0000 L2\u00020\u0001:\u0001LBe\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\"\u0010\u0015R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b#\u0010\u0015R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b$\u0010\u0015R\u0017\u0010\u0010\u001a\u00020\u000f8\u0006¢\u0006\f\n\u0004\b\u0010\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u001bR&\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010(\u0012\u0004\b+\u0010,\u001a\u0004\b)\u0010*R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010*R!\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u0010*R\u0019\u00103\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00104\u001a\u0004\b7\u00106R\u001b\u0010:\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00100\u001a\u0004\b9\u0010\u0015R\u001b\u0010=\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u00100\u001a\u0004\b<\u0010\u0015R\u001b\u0010@\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u00100\u001a\u0004\b?\u0010\u0015R\u001d\u0010C\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u00100\u001a\u0004\bB\u0010\u0015R\u001d\u0010F\u001a\u0004\u0018\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u00100\u001a\u0004\bE\u0010\u0015R\u001b\u0010I\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bG\u00100\u001a\u0004\bH\u0010\u0015R\u0011\u0010K\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bJ\u0010\u001a¨\u0006M"}, d2 = {"Lio/ktor/http/Url;", "", "Lio/ktor/http/URLProtocol;", "protocol", "", "host", "", "specifiedPort", "", "pathSegments", "Lio/ktor/http/Parameters;", IntrospectionHelper.AppFunctionInvokerClass.UnsafeInvokeMethod.PARAMETERS_PARAM_NAME, "fragment", "user", "password", "", "trailingQuery", "urlString", "<init>", "(Lio/ktor/http/URLProtocol;Ljava/lang/String;ILjava/util/List;Lio/ktor/http/Parameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Ljava/lang/String;", "getHost", "I", "getSpecifiedPort", "Lio/ktor/http/Parameters;", "getParameters", "()Lio/ktor/http/Parameters;", "getFragment", "getUser", "getPassword", "Z", "getTrailingQuery", "()Z", "Ljava/util/List;", "getPathSegments", "()Ljava/util/List;", "getPathSegments$annotations", "()V", "rawSegments", "getRawSegments", "segments$delegate", "Lkotlin/Lazy;", "getSegments", "segments", "protocolOrNull", "Lio/ktor/http/URLProtocol;", "getProtocolOrNull", "()Lio/ktor/http/URLProtocol;", "getProtocol", "encodedPath$delegate", "getEncodedPath", "encodedPath", "encodedQuery$delegate", "getEncodedQuery", "encodedQuery", "encodedPathAndQuery$delegate", "getEncodedPathAndQuery", "encodedPathAndQuery", "encodedUser$delegate", "getEncodedUser", "encodedUser", "encodedPassword$delegate", "getEncodedPassword", "encodedPassword", "encodedFragment$delegate", "getEncodedFragment", "encodedFragment", "getPort", "port", "Companion", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class Url {

    /* JADX INFO: renamed from: encodedFragment$delegate, reason: from kotlin metadata */
    private final Lazy encodedFragment;

    /* JADX INFO: renamed from: encodedPassword$delegate, reason: from kotlin metadata */
    private final Lazy encodedPassword;

    /* JADX INFO: renamed from: encodedPath$delegate, reason: from kotlin metadata */
    private final Lazy encodedPath;

    /* JADX INFO: renamed from: encodedPathAndQuery$delegate, reason: from kotlin metadata */
    private final Lazy encodedPathAndQuery;

    /* JADX INFO: renamed from: encodedQuery$delegate, reason: from kotlin metadata */
    private final Lazy encodedQuery;

    /* JADX INFO: renamed from: encodedUser$delegate, reason: from kotlin metadata */
    private final Lazy encodedUser;
    private final String fragment;
    private final String host;
    private final Parameters parameters;
    private final String password;
    private final List<String> pathSegments;
    private final URLProtocol protocol;
    private final URLProtocol protocolOrNull;
    private final List<String> rawSegments;

    /* JADX INFO: renamed from: segments$delegate, reason: from kotlin metadata */
    private final Lazy segments;
    private final int specifiedPort;
    private final boolean trailingQuery;
    private final String urlString;
    private final String user;

    public Url(URLProtocol uRLProtocol, String str, int i, List<String> list, Parameters parameters, String str2, String str3, String str4, boolean z, String str5) {
        str.getClass();
        list.getClass();
        parameters.getClass();
        str2.getClass();
        str5.getClass();
        this.host = str;
        this.specifiedPort = i;
        this.parameters = parameters;
        this.fragment = str2;
        this.user = str3;
        this.password = str4;
        this.trailingQuery = z;
        this.urlString = str5;
        if (i < 0 || i >= 65536) {
            Utf8$$ExternalSyntheticBUOutline0.m$2((Object) FileInsert$$ExternalSyntheticOutline0.m(i, "Port must be between 0 and 65535, or 0 if not set. Provided: "));
            throw null;
        }
        this.pathSegments = list;
        this.rawSegments = list;
        final int i2 = 0;
        this.segments = LazyKt.lazy(new Url$$ExternalSyntheticLambda0(list, i2));
        this.protocolOrNull = uRLProtocol;
        this.protocol = uRLProtocol == null ? URLProtocol.INSTANCE.getHTTP() : uRLProtocol;
        this.encodedPath = LazyKt.lazy(new Url$$ExternalSyntheticLambda1(list, this, i2));
        this.encodedQuery = LazyKt.lazy(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i3 = i2;
                Url url = this.f$0;
                switch (i3) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$4(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$5(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$6(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$7(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$8(url);
                }
            }
        });
        final int i3 = 1;
        this.encodedPathAndQuery = LazyKt.lazy(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i32 = i3;
                Url url = this.f$0;
                switch (i32) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$4(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$5(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$6(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$7(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$8(url);
                }
            }
        });
        final int i4 = 2;
        this.encodedUser = LazyKt.lazy(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i32 = i4;
                Url url = this.f$0;
                switch (i32) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$4(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$5(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$6(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$7(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$8(url);
                }
            }
        });
        final int i5 = 3;
        this.encodedPassword = LazyKt.lazy(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i32 = i5;
                Url url = this.f$0;
                switch (i32) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$4(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$5(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$6(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$7(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$8(url);
                }
            }
        });
        final int i6 = 4;
        this.encodedFragment = LazyKt.lazy(new Function0(this) { // from class: io.ktor.http.Url$$ExternalSyntheticLambda2
            public final /* synthetic */ Url f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i32 = i6;
                Url url = this.f$0;
                switch (i32) {
                    case 0:
                        return Url.encodedQuery_delegate$lambda$4(url);
                    case 1:
                        return Url.encodedPathAndQuery_delegate$lambda$5(url);
                    case 2:
                        return Url.encodedUser_delegate$lambda$6(url);
                    case 3:
                        return Url.encodedPassword_delegate$lambda$7(url);
                    default:
                        return Url.encodedFragment_delegate$lambda$8(url);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedFragment_delegate$lambda$8(Url url) {
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '#', 0, false, 6, (Object) null) + 1;
        return iIndexOf$default == 0 ? "" : url.urlString.substring(iIndexOf$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPassword_delegate$lambda$7(Url url) {
        String str = url.password;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        return url.urlString.substring(StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, ':', url.protocol.getName().length() + 3, false, 4, (Object) null) + 1, StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '@', 0, false, 6, (Object) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPathAndQuery_delegate$lambda$5(Url url) {
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '/', url.protocol.getName().length() + 3, false, 4, (Object) null);
        if (iIndexOf$default == -1) {
            return "";
        }
        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '#', iIndexOf$default, false, 4, (Object) null);
        String str = url.urlString;
        return iIndexOf$default2 == -1 ? str.substring(iIndexOf$default) : str.substring(iIndexOf$default, iIndexOf$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedPath_delegate$lambda$3(List list, Url url) {
        int iIndexOf$default;
        if (list.isEmpty() || (iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '/', url.protocol.getName().length() + 3, false, 4, (Object) null)) == -1) {
            return "";
        }
        int iIndexOfAny$default = StringsKt__StringsKt.indexOfAny$default(url.urlString, new char[]{'?', '#'}, iIndexOf$default, false, 4, null);
        String str = url.urlString;
        return iIndexOfAny$default == -1 ? str.substring(iIndexOf$default) : str.substring(iIndexOf$default, iIndexOfAny$default);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedQuery_delegate$lambda$4(Url url) {
        int iIndexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '?', 0, false, 6, (Object) null) + 1;
        if (iIndexOf$default == 0) {
            return "";
        }
        int iIndexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) url.urlString, '#', iIndexOf$default, false, 4, (Object) null);
        String str = url.urlString;
        return iIndexOf$default2 == -1 ? str.substring(iIndexOf$default) : str.substring(iIndexOf$default, iIndexOf$default2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String encodedUser_delegate$lambda$6(Url url) {
        String str = url.user;
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return "";
        }
        int length = url.protocol.getName().length() + 3;
        return url.urlString.substring(length, StringsKt__StringsKt.indexOfAny$default(url.urlString, new char[]{':', '@'}, length, false, 4, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List segments_delegate$lambda$1(List list) {
        if (list.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        return list.subList((((CharSequence) CollectionsKt.first(list)).length() != 0 || list.size() <= 1) ? 0 : 1, ((CharSequence) CollectionsKt.last(list)).length() == 0 ? CollectionsKt.getLastIndex(list) : 1 + CollectionsKt.getLastIndex(list));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || Url.class != other.getClass()) {
            return false;
        }
        return Intrinsics.areEqual(this.urlString, ((Url) other).urlString);
    }

    public final String getEncodedPassword() {
        return (String) this.encodedPassword.getValue();
    }

    public final String getEncodedUser() {
        return (String) this.encodedUser.getValue();
    }

    public final String getHost() {
        return this.host;
    }

    public final int getPort() {
        Integer numValueOf = Integer.valueOf(this.specifiedPort);
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : this.protocol.getDefaultPort();
    }

    public final URLProtocol getProtocol() {
        return this.protocol;
    }

    public final URLProtocol getProtocolOrNull() {
        return this.protocolOrNull;
    }

    public final int getSpecifiedPort() {
        return this.specifiedPort;
    }

    public int hashCode() {
        return this.urlString.hashCode();
    }

    /* JADX INFO: renamed from: toString, reason: from getter */
    public String getUrlString() {
        return this.urlString;
    }
}
