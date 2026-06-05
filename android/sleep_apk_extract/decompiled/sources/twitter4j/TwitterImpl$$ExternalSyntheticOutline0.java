package twitter4j;

import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import org.aspectj.lang.JoinPoint;
import org.mp4parser.support.RequiresParseDetailAspect;
import pl.edu.icm.jlargearrays.FloatLargeArray;
import twitter4j.conf.Configuration;

/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class TwitterImpl$$ExternalSyntheticOutline0 {
    public static String m(Configuration configuration, StringBuilder sb, String str, long j) {
        sb.append(configuration.getRestBaseURL());
        sb.append(str);
        sb.append(j);
        return sb.toString();
    }

    public static float m$1(float f, float f2, FloatLargeArray floatLargeArray, long j, float f3, float f4) {
        floatLargeArray.setFloat(j, f + f2);
        return f3 + f4;
    }

    public static float m$2(float f, float f2, FloatLargeArray floatLargeArray, long j, float f3, float f4) {
        floatLargeArray.setFloat(j, f - f2);
        return f3 - f4;
    }

    public static float m$3(float f, float f2, FloatLargeArray floatLargeArray, long j, float f3, float f4) {
        floatLargeArray.setFloat(j, f + f2);
        return f3 - f4;
    }

    public static String m(Configuration configuration, StringBuilder sb, String str) {
        sb.append(configuration.getRestBaseURL());
        sb.append(str);
        return sb.toString();
    }

    public static StringBuilder m(String str, TypeConstructorMarker typeConstructorMarker, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(typeConstructorMarker);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder m(JoinPoint joinPoint, String str) {
        RequiresParseDetailAspect.aspectOf().before(joinPoint);
        return new StringBuilder(str);
    }

    public static FqName m(String str, FqName fqName) {
        Name nameIdentifier = Name.identifier(str);
        nameIdentifier.getClass();
        return fqName.child(nameIdentifier);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static void m2688m(Configuration configuration, StringBuilder sb, String str, long j) {
        sb.append(configuration.getRestBaseURL());
        sb.append(str);
        sb.append(j);
    }

    public static float m(float f, float f2, FloatLargeArray floatLargeArray, long j, float f3, float f4) {
        floatLargeArray.setFloat(j, f - f2);
        return f3 + f4;
    }
}
