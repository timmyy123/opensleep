package com.urbandroid.sleep.gui.pref;

import android.app.Activity;
import android.content.Context;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.WebDialog$$ExternalSyntheticLambda1;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes4.dex */
public class HelpPreferenceCategory extends PreferenceCategory {
    private String helpLink;

    public HelpPreferenceCategory(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.helpLink = null;
        handleAttributes(attributeSet);
    }

    private void handleAttributes(AttributeSet attributeSet) {
        for (int i = 0; i < attributeSet.getAttributeCount(); i++) {
            String attributeName = attributeSet.getAttributeName(i);
            String attributeValue = attributeSet.getAttributeValue(i);
            if (attributeName.equalsIgnoreCase("help")) {
                this.helpLink = attributeValue;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBindView$0(View view) {
        ViewIntent.urlCustomTab((Activity) getContext(), this.helpLink);
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        View viewFindViewById = ((ViewGroup) view).findViewById(R.id.help);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new WebDialog$$ExternalSyntheticLambda1(this, 23));
        }
    }

    public HelpPreferenceCategory(Context context) {
        super(context);
        this.helpLink = null;
    }

    public HelpPreferenceCategory(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.helpLink = null;
        handleAttributes(attributeSet);
    }

    public HelpPreferenceCategory(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.helpLink = null;
        handleAttributes(attributeSet);
    }
}
