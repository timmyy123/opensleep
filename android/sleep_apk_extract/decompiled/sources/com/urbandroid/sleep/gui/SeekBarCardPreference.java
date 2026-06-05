package com.urbandroid.sleep.gui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.R;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/gui/SeekBarCardPreference;", "Lcom/urbandroid/sleep/gui/SeekBarPreference;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getLayout", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SeekBarCardPreference extends SeekBarPreference {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekBarCardPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context.getClass();
        attributeSet.getClass();
    }

    @Override // com.urbandroid.sleep.gui.SeekBarPreference
    public int getLayout() {
        return R.layout.preference_card_seek_bar;
    }
}
