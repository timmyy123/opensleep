package org.checkerframework.checker.nullness.qual;

import com.facebook.ads.redexgen.core.C0E;
import com.facebook.ads.redexgen.core.C0F;
import com.facebook.ads.redexgen.core.C0L;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.DefaultFor;
import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.QualifierForLiterals;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.UpperBoundFor;

/* JADX INFO: loaded from: assets/audience_network/classes.dex */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
@QualifierForLiterals({C0L.A0C})
@Retention(RetentionPolicy.RUNTIME)
@SubtypeOf({MonotonicNonNull.class})
@DefaultFor({C0E.A04})
@Documented
@UpperBoundFor(typeKinds = {C0F.A0I, C0F.A0C, C0F.A04, C0F.A06, C0F.A08, C0F.A0B, C0F.A0E, C0F.A0J, C0F.A05})
@DefaultQualifierInHierarchy
public @interface NonNull {
}
