package kotlin.reflect.jvm.internal;

import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.text.StringsKt;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u001a\b\u0010\u0005\u001a\u00020\u0006H\u0002\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"javaParameter", "Lkotlin/reflect/jvm/internal/JavaParameter;", "Lkotlin/reflect/jvm/internal/ReflectKParameter;", "getJavaParameter", "(Lkotlin/reflect/jvm/internal/ReflectKParameter;)Lkotlin/reflect/jvm/internal/JavaParameter;", "isJdk8", "", "kotlin-reflection"}, k = 2, mv = {2, 3, 0}, xi = 48)
public abstract class ReflectKParameterKt {
    public static final JavaParameter getJavaParameter(ReflectKParameter reflectKParameter) {
        reflectKParameter.getClass();
        Member memberMo2469getMember = reflectKParameter.getCallable().getCaller().mo2469getMember();
        if (memberMo2469getMember instanceof Method) {
            if (Modifier.isStatic(((Method) memberMo2469getMember).getModifiers())) {
                return new JavaParameter(memberMo2469getMember, reflectKParameter.getIndex());
            }
            Utf8$$ExternalSyntheticBUOutline0.m$4("Only static methods are supported for now: ", memberMo2469getMember);
            return null;
        }
        if (!(memberMo2469getMember instanceof Constructor)) {
            Events$$ExternalSyntheticBUOutline0.m$1("Unsupported parameter owner: ", memberMo2469getMember);
            return null;
        }
        Constructor constructor = (Constructor) memberMo2469getMember;
        Class declaringClass = constructor.getDeclaringClass();
        declaringClass.getClass();
        return new JavaParameter(memberMo2469getMember, reflectKParameter.getIndex() + ((JvmClassMappingKt.getKotlinClass(declaringClass).isInner() && isJdk8()) ? -1 : constructor.getDeclaringClass().isEnum() ? (constructor.getParameterAnnotations().length - constructor.getParameterTypes().length) + 2 : 0));
    }

    private static final boolean isJdk8() {
        String property = System.getProperty("java.version");
        return property != null && StringsKt.startsWith$default(property, "1.");
    }
}
