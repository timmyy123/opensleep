package com.urbandroid.sleep.gui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.login.LoginFragment$$ExternalSyntheticLambda0;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.Slider;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public class SeekBarPreference extends DialogPreference implements Slider.OnChangeListener {
    private final String TAG;
    private Button actionButton;
    private View boundView;
    private IFormatter formatter;
    private int mCurrentValue;
    private int mInterval;
    private int mMajorInterval;
    private int mMaxValue;
    private int mMinValue;
    private TextView mStatusText;
    private String mUnitsLeft;
    private String mUnitsRight;
    private String maxString;
    private String minString;
    private IOnBindListener onBindListener;
    private Slider slider;
    private ViewGroup valueContainer;
    private String[] valuesArray;

    public interface IFormatter {
        String format(int i);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = getClass().getName();
        this.mMaxValue = 1000;
        this.mMinValue = 0;
        this.mInterval = 1;
        this.mMajorInterval = 10;
        this.mUnitsLeft = "";
        this.mUnitsRight = "";
        this.valuesArray = null;
        this.minString = null;
        this.maxString = null;
        initPreference(context, attributeSet);
    }

    private String getAttributeStringValue(AttributeSet attributeSet, String str, String str2, String str3) {
        String attributeValue = attributeSet.getAttributeValue(str, str2);
        return attributeValue == null ? str3 : attributeValue;
    }

    private String getFormattedValue(int i) {
        IFormatter iFormatter = this.formatter;
        if (iFormatter == null) {
            return String.valueOf(i);
        }
        String[] strArr = this.valuesArray;
        return (strArr == null || strArr.length <= i) ? iFormatter.format(i) : strArr[i];
    }

    private String getFormattedValueForLabel(int i) {
        IFormatter iFormatter = this.formatter;
        if (iFormatter == null) {
            return String.valueOf(i);
        }
        String[] strArr = this.valuesArray;
        return (strArr == null || strArr.length >= 10 || strArr.length <= i) ? iFormatter.format(i) : strArr[i];
    }

    private CharSequence[] getItems() {
        int i = this.mMajorInterval;
        int i2 = i == 0 ? 1 : i;
        int i3 = ((this.mMaxValue - this.mMinValue) / i2) + (i != 0 ? 0 : 1);
        CharSequence[] charSequenceArr = new CharSequence[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            charSequenceArr[i4] = getFormattedValue(i) + " " + this.mUnitsRight;
            i += i2;
        }
        return charSequenceArr;
    }

    private void initPreference(Context context, AttributeSet attributeSet) {
        setValuesFromXml(attributeSet);
        Slider slider = new Slider(context, attributeSet);
        this.slider = slider;
        slider.setValueFrom(this.mMinValue);
        this.slider.setValueTo(this.mMaxValue);
        this.slider.setTrackHeight(ActivityUtils.getDip(context, 24));
        this.slider.setThumbHeight(ActivityUtils.getDip(context, 36));
        if (this.mInterval >= 10) {
            this.slider.setStepSize(10.0f);
        }
        setSliderValueSafe(this.slider, this.mCurrentValue);
        this.slider.addOnChangeListener(this);
        ComponentColorUtilKt.color(this.slider);
        String[] strArr = this.valuesArray;
        if (strArr != null && strArr.length < 10) {
            this.slider.setStepSize(1.0f);
        }
        this.slider.setLabelFormatter(new LoginFragment$$ExternalSyntheticLambda0(this, 26));
        this.formatter = new Events$$ExternalSyntheticBUOutline0(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$initPreference$1(float f) {
        return getFormattedValueForLabel(Math.round(f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showDialog$0(int i, DialogInterface dialogInterface, int i2) {
        setCurrentValue((i2 + (this.mMajorInterval == 0 ? 0 : 1)) * i);
        persistInt(this.mCurrentValue);
        if (getOnPreferenceChangeListener() != null) {
            getOnPreferenceChangeListener().onPreferenceChange(this, Integer.valueOf(this.mCurrentValue));
        }
    }

    private void setSliderValueSafe(Slider slider, float f) {
        slider.setValue(Math.max(Math.min(f, slider.getValueTo()), slider.getValueFrom()));
    }

    private void setValuesFromXml(AttributeSet attributeSet) {
        this.mMaxValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "max", 100);
        this.mMinValue = attributeSet.getAttributeIntValue("http://robobunny.com", "min", 0);
        this.mUnitsLeft = getAttributeStringValue(attributeSet, "http://robobunny.com", "unitsLeft", "");
        this.mUnitsRight = getAttributeStringValue(attributeSet, "http://robobunny.com", "unitsRight", getAttributeStringValue(attributeSet, "http://robobunny.com", "units", ""));
        Context context = getContext();
        int[] iArr = R.styleable.SeekBarPreference;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(7, -1);
        if (resourceId > 0) {
            this.valuesArray = getContext().getResources().getStringArray(resourceId);
        }
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = getContext().obtainStyledAttributes(attributeSet, iArr);
        this.minString = typedArrayObtainStyledAttributes2.getString(5);
        typedArrayObtainStyledAttributes2.recycle();
        TypedArray typedArrayObtainStyledAttributes3 = getContext().obtainStyledAttributes(attributeSet, iArr);
        this.maxString = typedArrayObtainStyledAttributes3.getString(3);
        typedArrayObtainStyledAttributes3.recycle();
        try {
            String attributeValue = attributeSet.getAttributeValue("http://robobunny.com", "interval");
            if (attributeValue != null) {
                this.mInterval = Integer.parseInt(attributeValue);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Invalid interval value", e);
        }
    }

    public int getCurrentValue() {
        return this.mCurrentValue;
    }

    public int getLayout() {
        return R.layout.preference_seek_bar;
    }

    @Override // android.preference.Preference
    public View getView(View view, ViewGroup viewGroup) {
        View view2 = super.getView(view, viewGroup);
        if (view2 != null) {
            ((ViewGroup) view2.findViewById(R.id.seekBarPrefValueContainer)).setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.gui.SeekBarPreference.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view3) {
                    SeekBarPreference.this.showDialog(null);
                }
            });
        }
        return view2;
    }

    @Override // android.preference.Preference
    public void onBindView(View view) {
        super.onBindView(view);
        try {
            ViewParent parent = this.slider.getParent();
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.seekBarPrefBarContainer);
            this.actionButton = (Button) view.findViewById(R.id.seek_bar_pref_action_button);
            if (parent != viewGroup) {
                if (parent != null) {
                    ((ViewGroup) parent).removeView(this.slider);
                }
                viewGroup.removeAllViews();
                viewGroup.addView(this.slider, -1, -2);
            }
            if (this.minString != null) {
                view.findViewById(R.id.minString).setVisibility(0);
                ((TextView) view.findViewById(R.id.minString)).setText(this.minString);
            } else {
                view.findViewById(R.id.minString).setVisibility(8);
            }
            if (this.maxString != null) {
                view.findViewById(R.id.maxString).setVisibility(0);
                ((TextView) view.findViewById(R.id.maxString)).setText(this.maxString);
            } else {
                view.findViewById(R.id.maxString).setVisibility(8);
            }
        } catch (Exception e) {
            Log.e(this.TAG, "Error binding view: " + e.toString());
        }
        updateView(view);
        this.boundView = view;
        IOnBindListener iOnBindListener = this.onBindListener;
        if (iOnBindListener != null) {
            iOnBindListener.onBind();
        }
    }

    @Override // android.preference.Preference
    public View onCreateView(ViewGroup viewGroup) {
        Exception e;
        ViewGroup viewGroup2;
        super.onCreateView(viewGroup);
        try {
            viewGroup2 = (ViewGroup) InflatorUtil.get(getContext()).inflate(getLayout(), viewGroup, false);
            try {
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.findViewById(R.id.seekBarPrefValueContainer);
                this.valueContainer = viewGroup3;
                viewGroup3.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.gui.SeekBarPreference.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        SeekBarPreference.this.showDialog(null);
                    }
                });
                if (getSummary() != null && getSummary().toString().trim().length() != 0) {
                    return viewGroup2;
                }
                viewGroup2.findViewById(android.R.id.summary).setVisibility(8);
                return viewGroup2;
            } catch (Exception e2) {
                e = e2;
                Log.e(this.TAG, "Error creating seek bar preference", e);
                return viewGroup2;
            }
        } catch (Exception e3) {
            e = e3;
            viewGroup2 = null;
        }
    }

    @Override // android.preference.Preference
    public Object onGetDefaultValue(TypedArray typedArray, int i) {
        return Integer.valueOf(typedArray.getInt(i, 50));
    }

    @Override // android.preference.Preference
    public void onSetInitialValue(boolean z, Object obj) {
        int iIntValue;
        if (z) {
            this.mCurrentValue = getPersistedInt(this.mCurrentValue);
            return;
        }
        try {
            iIntValue = ((Integer) obj).intValue();
        } catch (Exception unused) {
            Log.e(this.TAG, "Invalid default value: " + obj.toString());
            iIntValue = 0;
        }
        persistInt(iIntValue);
        this.mCurrentValue = iIntValue;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.slider.Slider.OnChangeListener, com.google.android.material.slider.BaseOnChangeListener
    public void onValueChange(Slider slider, float f, boolean z) {
        if (!z) {
            setSliderValueSafe(slider, this.mCurrentValue);
            return;
        }
        int iRound = Math.round(f);
        int i = this.mMaxValue;
        if (iRound <= i && iRound >= (i = this.mMinValue)) {
            int i2 = this.mInterval;
            if (i2 != 1 && iRound % i2 != 0) {
                iRound = Math.round(iRound / i2) * this.mInterval;
            }
        } else {
            iRound = i;
        }
        if (!callChangeListener(Integer.valueOf(iRound))) {
            setSliderValueSafe(slider, this.mCurrentValue);
            return;
        }
        this.mCurrentValue = iRound;
        this.mStatusText.setText(getFormattedValue(iRound));
        persistInt(iRound);
    }

    public void setCurrentValue(int i) {
        this.mCurrentValue = i;
        if (this.boundView != null) {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = getOnPreferenceChangeListener();
            setOnPreferenceChangeListener(null);
            updateView(this.boundView);
            setOnPreferenceChangeListener(onPreferenceChangeListener);
        }
    }

    @Override // android.preference.Preference
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.slider.setEnabled(z);
        ViewGroup viewGroup = this.valueContainer;
        if (viewGroup != null) {
            viewGroup.setEnabled(z);
            this.valueContainer.setClickable(z);
        }
    }

    public void setFormatter(IFormatter iFormatter) {
        this.formatter = iFormatter;
    }

    public void setMajorInterval(int i) {
        this.mMajorInterval = i;
    }

    @Override // android.preference.DialogPreference
    public void showDialog(Bundle bundle) {
        final int i = this.mMajorInterval;
        if (i == 0) {
            i = 1;
        }
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(getContext());
        materialAlertDialogBuilder.setTitle(getTitle());
        materialAlertDialogBuilder.setIcon(getDialogIcon());
        materialAlertDialogBuilder.setNegativeButton(R.string.button_cancel, (DialogInterface.OnClickListener) null);
        materialAlertDialogBuilder.setItems(getItems(), new DialogInterface.OnClickListener() { // from class: com.urbandroid.sleep.gui.SeekBarPreference$$ExternalSyntheticLambda2
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f$0.lambda$showDialog$0(i, dialogInterface, i2);
            }
        });
        View viewOnCreateDialogView = onCreateDialogView();
        if (viewOnCreateDialogView != null) {
            onBindDialogView(viewOnCreateDialogView);
            materialAlertDialogBuilder.setView(viewOnCreateDialogView);
        } else {
            materialAlertDialogBuilder.setMessage(getDialogMessage());
        }
        materialAlertDialogBuilder.show();
    }

    public void updateView(View view) {
        try {
            Preference.OnPreferenceChangeListener onPreferenceChangeListener = getOnPreferenceChangeListener();
            setOnPreferenceChangeListener(null);
            ViewGroup viewGroup = (ViewGroup) view;
            TextView textView = (TextView) viewGroup.findViewById(R.id.seekBarPrefValue);
            this.mStatusText = textView;
            textView.setText(getFormattedValue(this.mCurrentValue));
            this.mStatusText.setMinimumWidth(30);
            setSliderValueSafe(this.slider, this.mCurrentValue);
            ((TextView) viewGroup.findViewById(R.id.seekBarPrefUnitsRight)).setText(this.mUnitsRight);
            ((TextView) viewGroup.findViewById(R.id.seekBarPrefUnitsLeft)).setText(this.mUnitsLeft);
            setOnPreferenceChangeListener(onPreferenceChangeListener);
        } catch (Exception e) {
            Log.e(this.TAG, "Error updating seek bar preference", e);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getName();
        this.mMaxValue = 1000;
        this.mMinValue = 0;
        this.mInterval = 1;
        this.mMajorInterval = 10;
        this.mUnitsLeft = "";
        this.mUnitsRight = "";
        this.valuesArray = null;
        this.minString = null;
        this.maxString = null;
        initPreference(context, attributeSet);
    }
}
