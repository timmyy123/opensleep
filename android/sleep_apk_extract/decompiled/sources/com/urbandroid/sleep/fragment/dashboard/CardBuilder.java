package com.urbandroid.sleep.fragment.dashboard;

import android.app.Activity;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J%\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\t2\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/CardBuilder;", "", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "card", "", "findPosition", "(Landroid/app/Activity;Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;)Ljava/lang/Integer;", "", "buildCards", "(Landroid/app/Activity;)Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface CardBuilder {
    List<DashboardCard<?>> buildCards(Activity context);

    Integer findPosition(Activity context, DashboardCard<?> card);
}
