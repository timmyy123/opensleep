package com.facebook.appevents.ml;

import android.text.TextUtils;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.facebook.share.internal.ShareInternalUtility;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import oauth.signpost.OAuth;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\u0006H\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/facebook/appevents/ml/Utils;", "", "()V", "DIR_NAME", "", "getMlDir", "Ljava/io/File;", "normalizeString", "str", "parseModelWeights", "", "Lcom/facebook/appevents/ml/MTensor;", ShareInternalUtility.STAGING_PARAM, "vectorize", "", "texts", "maxLen", "", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Utils {
    private static final String DIR_NAME = "facebook_ml/";
    public static final Utils INSTANCE = new Utils();

    private Utils() {
    }

    public static final File getMlDir() {
        if (CrashShieldHandler.isObjectCrashing(Utils.class)) {
            return null;
        }
        try {
            File file = new File(FacebookSdk.getApplicationContext().getFilesDir(), DIR_NAME);
            if (!file.exists()) {
                if (!file.mkdirs()) {
                    return null;
                }
            }
            return file;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, Utils.class);
            return null;
        }
    }

    public static final Map<String, MTensor> parseModelWeights(File file) {
        Map<String, MTensor> map;
        if (!CrashShieldHandler.isObjectCrashing(Utils.class)) {
            try {
                file.getClass();
                try {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    int iAvailable = fileInputStream.available();
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    byte[] bArr = new byte[iAvailable];
                    dataInputStream.readFully(bArr);
                    dataInputStream.close();
                    if (iAvailable >= 4) {
                        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, 0, 4);
                        byteBufferWrap.order(ByteOrder.LITTLE_ENDIAN);
                        int i = byteBufferWrap.getInt();
                        int i2 = i + 4;
                        if (iAvailable >= i2) {
                            JSONObject jSONObject = new JSONObject(new String(bArr, 4, i, Charsets.UTF_8));
                            JSONArray jSONArrayNames = jSONObject.names();
                            int length = jSONArrayNames.length();
                            String[] strArr = new String[length];
                            for (int i3 = 0; i3 < length; i3++) {
                                strArr[i3] = jSONArrayNames.getString(i3);
                            }
                            ArraysKt.sort(strArr);
                            HashMap map2 = new HashMap();
                            for (int i4 = 0; i4 < length; i4++) {
                                String str = strArr[i4];
                                if (str != null) {
                                    JSONArray jSONArray = jSONObject.getJSONArray(str);
                                    int length2 = jSONArray.length();
                                    int[] iArr = new int[length2];
                                    int i5 = 1;
                                    map = null;
                                    for (int i6 = 0; i6 < length2; i6++) {
                                        try {
                                            int i7 = jSONArray.getInt(i6);
                                            iArr[i6] = i7;
                                            i5 *= i7;
                                        } catch (Exception unused) {
                                            return null;
                                        } catch (Throwable th) {
                                            th = th;
                                            CrashShieldHandler.handleThrowable(th, Utils.class);
                                            return map;
                                        }
                                    }
                                    int i8 = i5 * 4;
                                    int i9 = i2 + i8;
                                    if (i9 > iAvailable) {
                                        return null;
                                    }
                                    ByteBuffer byteBufferWrap2 = ByteBuffer.wrap(bArr, i2, i8);
                                    byteBufferWrap2.order(ByteOrder.LITTLE_ENDIAN);
                                    MTensor mTensor = new MTensor(iArr);
                                    byteBufferWrap2.asFloatBuffer().get(mTensor.getData(), 0, i5);
                                    map2.put(str, mTensor);
                                    i2 = i9;
                                }
                            }
                            return map2;
                        }
                    }
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
                map = null;
            }
        }
        return null;
    }

    public final String normalizeString(String str) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            str.getClass();
            int length = str.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    }
                    length--;
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            String strJoin = TextUtils.join(" ", (String[]) new Regex("\\s+").split(str.subSequence(i, length + 1).toString(), 0).toArray(new String[0]));
            strJoin.getClass();
            return strJoin;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final int[] vectorize(String texts, int maxLen) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            texts.getClass();
            int[] iArr = new int[maxLen];
            String strNormalizeString = normalizeString(texts);
            Charset charsetForName = Charset.forName(OAuth.ENCODING);
            charsetForName.getClass();
            byte[] bytes = strNormalizeString.getBytes(charsetForName);
            bytes.getClass();
            for (int i = 0; i < maxLen; i++) {
                if (i < bytes.length) {
                    iArr[i] = bytes[i] & 255;
                } else {
                    iArr[i] = 0;
                }
            }
            return iArr;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
