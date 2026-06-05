package org.mp4parser;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.mp4parser.tools.Hex;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class PropertyBoxParserImpl extends AbstractBoxParser {
    public static Properties BOX_MAP_CACHE;
    static String[] EMPTY_STRING_ARRAY = new String[0];
    public Properties mapping;
    Pattern constuctorPattern = Pattern.compile("(.*)\\((.*?)\\)");
    StringBuilder buildLookupStrings = new StringBuilder();
    ThreadLocal<String> clazzName = new ThreadLocal<>();
    ThreadLocal<String[]> param = new ThreadLocal<>();

    /* JADX WARN: Finally extract failed */
    public PropertyBoxParserImpl(String... strArr) {
        if (BOX_MAP_CACHE != null) {
            this.mapping = new Properties(BOX_MAP_CACHE);
            return;
        }
        InputStream systemResourceAsStream = ClassLoader.getSystemResourceAsStream("isoparser2-default.properties");
        try {
            Properties properties = new Properties();
            this.mapping = properties;
            try {
                properties.load(systemResourceAsStream);
                ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                Enumeration<URL> resources = (contextClassLoader == null ? ClassLoader.getSystemClassLoader() : contextClassLoader).getResources("isoparser-custom.properties");
                while (resources.hasMoreElements()) {
                    Throwable th = null;
                    try {
                        InputStream inputStreamOpenStream = resources.nextElement().openStream();
                        try {
                            this.mapping.load(inputStreamOpenStream);
                            if (inputStreamOpenStream != null) {
                                inputStreamOpenStream.close();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (inputStreamOpenStream == null) {
                                throw th;
                            }
                            inputStreamOpenStream.close();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        if (th == null) {
                            throw th3;
                        }
                        if (th != th3) {
                            th.addSuppressed(th3);
                        }
                        throw th;
                    }
                }
                for (String str : strArr) {
                    this.mapping.load(getClass().getResourceAsStream(str));
                }
                BOX_MAP_CACHE = this.mapping;
                if (systemResourceAsStream != null) {
                    try {
                        systemResourceAsStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        } catch (Throwable th4) {
            if (systemResourceAsStream != null) {
                try {
                    systemResourceAsStream.close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th4;
        }
    }

    @Override // org.mp4parser.AbstractBoxParser
    public ParsableBox createBox(String str, byte[] bArr, String str2) {
        invoke(str, bArr, str2);
        String[] strArr = this.param.get();
        try {
            Class<?> cls = Class.forName(this.clazzName.get());
            if (strArr.length <= 0) {
                return (ParsableBox) cls.getDeclaredConstructor(null).newInstance(null);
            }
            Class<?>[] clsArr = new Class[strArr.length];
            Object[] objArr = new Object[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                if ("userType".equals(strArr[i])) {
                    objArr[i] = bArr;
                    clsArr[i] = byte[].class;
                } else if ("type".equals(strArr[i])) {
                    objArr[i] = str;
                    clsArr[i] = String.class;
                } else {
                    if (!"parent".equals(strArr[i])) {
                        throw new InternalError("No such param: " + strArr[i]);
                    }
                    objArr[i] = str2;
                    clsArr[i] = String.class;
                }
            }
            return (ParsableBox) cls.getConstructor(clsArr).newInstance(objArr);
        } catch (ClassNotFoundException e) {
            e = e;
            Utf8$$ExternalSyntheticBUOutline0.m(e);
            return null;
        } catch (IllegalAccessException e2) {
            e = e2;
            Utf8$$ExternalSyntheticBUOutline0.m(e);
            return null;
        } catch (InstantiationException e3) {
            e = e3;
            Utf8$$ExternalSyntheticBUOutline0.m(e);
            return null;
        } catch (NoSuchMethodException e4) {
            e = e4;
            Utf8$$ExternalSyntheticBUOutline0.m(e);
            return null;
        } catch (InvocationTargetException e5) {
            e = e5;
            Utf8$$ExternalSyntheticBUOutline0.m(e);
            return null;
        }
    }

    public void invoke(String str, byte[] bArr, String str2) {
        String property;
        if (bArr == null) {
            property = this.mapping.getProperty(str);
            if (property == null) {
                StringBuilder sb = this.buildLookupStrings;
                sb.append(str2);
                sb.append('-');
                sb.append(str);
                String string = sb.toString();
                this.buildLookupStrings.setLength(0);
                property = this.mapping.getProperty(string);
            }
        } else {
            if (!"uuid".equals(str)) {
                Types$$ExternalSyntheticBUOutline0.m$2("we have a userType but no uuid box type. Something's wrong");
                return;
            }
            property = this.mapping.getProperty("uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
            if (property == null) {
                property = this.mapping.getProperty(String.valueOf(str2) + "-uuid[" + Hex.encodeHex(bArr).toUpperCase() + "]");
            }
            if (property == null) {
                property = this.mapping.getProperty("uuid");
            }
        }
        if (property == null) {
            property = this.mapping.getProperty("default");
        }
        if (property == null) {
            Types$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("No box object found for ", str));
            return;
        }
        if (!property.endsWith(")")) {
            this.param.set(EMPTY_STRING_ARRAY);
            this.clazzName.set(property);
            return;
        }
        Matcher matcher = this.constuctorPattern.matcher(property);
        if (!matcher.matches()) {
            Types$$ExternalSyntheticBUOutline0.m$2("Cannot work with that constructor: ".concat(property));
            return;
        }
        this.clazzName.set(matcher.group(1));
        int length = matcher.group(2).length();
        ThreadLocal<String[]> threadLocal = this.param;
        if (length == 0) {
            threadLocal.set(EMPTY_STRING_ARRAY);
        } else {
            threadLocal.set(matcher.group(2).length() > 0 ? matcher.group(2).split(",") : new String[0]);
        }
    }
}
