package com.facebook.internal.qualityvalidation;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/qualityvalidation/ExcusesForDesignViolations;", "", SDKConstants.PARAM_VALUE, "", "Lcom/facebook/internal/qualityvalidation/Excuse;", "()[Lcom/facebook/internal/qualityvalidation/Excuse;", "facebook-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public @interface ExcusesForDesignViolations {
    Excuse[] value();
}
