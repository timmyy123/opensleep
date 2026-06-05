package com.google.home.automation;

/* JADX INFO: loaded from: classes4.dex */
public abstract class zzd {
    public static /* synthetic */ String zza(Expression expression, ExpressionWithId expressionWithId, byte b, String str) {
        String expressionId = expressionWithId.getExpressionId();
        StringBuilder sb = new StringBuilder(String.valueOf(expression).length() + b + String.valueOf(expressionId).length() + 1);
        sb.append(str);
        sb.append(expression);
        sb.append(", expressionId=");
        sb.append(expressionId);
        sb.append(")");
        return sb.toString();
    }
}
