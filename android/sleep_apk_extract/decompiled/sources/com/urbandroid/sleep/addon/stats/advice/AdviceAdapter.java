package com.urbandroid.sleep.addon.stats.advice;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.RandUtil;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.goal.GoalDetailActivity;
import com.urbandroid.sleep.addon.stats.model.Advice;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.gui.IFilterListAdapter;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class AdviceAdapter extends ArrayAdapter<Advice> implements IFilterListAdapter {
    private Context context;
    private ArrayList<Advice> filteredItems;
    private ArrayList<Advice> items;
    private boolean showGoals;
    private LayoutInflater vi;

    public AdviceAdapter(Context context, ArrayList<Advice> arrayList) {
        super(context, 0, arrayList);
        this.showGoals = true;
        this.context = context;
        this.items = arrayList;
        this.filteredItems = new ArrayList<>(arrayList);
        this.vi = InflatorUtil.get(context);
        this.showGoals = new Settings(context).getCurrentGoal() == null;
    }

    private void filterItems(String str) {
        this.filteredItems.clear();
        for (Advice advice : this.items) {
            if (str != null && !"".equals(str) && advice.getBody().toLowerCase().contains(str)) {
                this.filteredItems.add(advice);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mapAdviceToView$0(TextView textView, ViewGroup viewGroup, View view) {
        if ("NO ADVICE".equals(textView.getTag())) {
            return;
        }
        if (textView.getTag() == null) {
            textView.setTag("EXPANDED");
            textView.setVisibility(8);
            viewGroup.setVisibility(0);
        } else {
            viewGroup.setVisibility(8);
            textView.setVisibility(0);
            textView.setTag(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$mapAdviceToView$1(Context context, Advice advice, View view) {
        GoalDetailActivity.start(context, advice.getGoalType());
    }

    public static void mapAdviceToView(final Context context, int i, View view, final Advice advice, boolean z) {
        TextView textView;
        boolean z2;
        View viewFindViewById = view.findViewById(R.id.stripe);
        TextView textView2 = (TextView) view.findViewById(R.id.title);
        TextView textView3 = (TextView) view.findViewById(R.id.read_more);
        TextView textView4 = (TextView) view.findViewById(R.id.button_set_goal);
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        Drawable gradientDrawable = new GradientDrawable(orientation, new int[]{ColorUtil.addAlpha(ColorUtil.i(context, R.color.positive), 99), ColorUtil.i(context, R.color.transparent)});
        GradientDrawable gradientDrawable2 = new GradientDrawable(orientation, new int[]{ColorUtil.addAlpha(ColorUtil.i(context, R.color.negative_light), 99), ColorUtil.i(context, R.color.transparent)});
        ColorDrawable colorDrawable = new ColorDrawable(ColorUtil.i(context, R.color.transparent));
        ImageView imageView = (ImageView) view.findViewById(R.id.score);
        if (advice.getType() == Advice.Type.INDIFFERENT) {
            textView2.setText(context.getString(R.string.advice));
            textView2.setVisibility(0);
            imageView.setVisibility(8);
            imageView.setImageDrawable(null);
        } else {
            textView2.setVisibility(0);
            Advice.Type type = advice.getType();
            Advice.Type type2 = Advice.Type.CAUTION;
            textView2.setText(context.getString(type == type2 ? R.string.advice_caution : R.string.advice_congrats));
            if (viewFindViewById != null) {
                if (advice.getType() == type2) {
                    gradientDrawable = gradientDrawable2;
                } else if (advice.getType() != Advice.Type.CONGRATS) {
                    gradientDrawable = colorDrawable;
                }
                viewFindViewById.setBackground(gradientDrawable);
            }
            if (advice.getType() == type2) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_advice_down));
            } else if (advice.getType() == Advice.Type.CONGRATS) {
                imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_advice_up));
            }
        }
        TextView textView5 = (TextView) view.findViewById(R.id.body);
        textView5.setText(Html.fromHtml(advice.getBody()), TextView.BufferType.SPANNABLE);
        TextView textView6 = (TextView) view.findViewById(R.id.advice_text);
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.advice_expanded);
        if (textView6 == null) {
            textView = textView4;
        } else if (advice.getAdvice() != null) {
            textView6.setVisibility(0);
            viewGroup.setVisibility(8);
            viewGroup.removeAllViews();
            String[] advice2 = advice.getAdvice();
            StringBuilder sb = new StringBuilder();
            if (advice2.length > 0) {
                int length = advice2.length;
                int i2 = 0;
                while (i2 < length) {
                    String str = advice2[i2];
                    TextView textView7 = new TextView(context);
                    textView7.setCompoundDrawablePadding(ActivityUtils.getDip(context, 16));
                    int i3 = length;
                    TextView textView8 = textView4;
                    int i4 = i2;
                    textView7.setPadding(ActivityUtils.getDip(context, 28), ActivityUtils.getDip(context, 24), ActivityUtils.getDip(context, 28), ActivityUtils.getDip(context, 0));
                    textView7.setTextColor(ColorUtil.i(context, R.color.secondary));
                    textView7.setText(str);
                    if (advice2.length > 1) {
                        textView7.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_achievement_done, 0, 0, 0);
                    } else {
                        textView7.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    }
                    viewGroup.addView(textView7);
                    i2 = i4 + 1;
                    length = i3;
                    textView4 = textView8;
                }
            }
            textView = textView4;
            if (advice2.length > 0) {
                TextView textView9 = new TextView(context);
                textView9.setCompoundDrawablePadding(ActivityUtils.getDip(context, 8));
                textView9.setText(context.getString(R.string.advice) + ":");
                textView9.setTextColor(ColorUtil.i(context, R.color.secondary));
                textView9.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up_secondary, 0, 0, 0);
                viewGroup.addView(textView9, 0);
                if (advice2.length > 1) {
                    sb.append(context.getResources().getString(R.string.advice));
                    sb.append(": ");
                    sb.append(advice2[Math.max(0, Math.min(RandUtil.range(0, advice2.length - 1), advice2.length - 1))]);
                } else {
                    sb.append(context.getResources().getString(R.string.advice));
                    sb.append(": ");
                    sb.append(advice2[0]);
                }
            }
            boolean z3 = advice2.length > 1;
            if (sb.length() > 70) {
                sb.setLength(70);
                sb.setCharAt(69, (char) 8230);
                z2 = true;
            } else {
                z2 = z3;
            }
            textView6.setText(sb.toString());
            StringBuilder sb2 = new StringBuilder("Advice: ");
            sb2.append(textView5);
            sb2.append(" array ");
            zza$$ExternalSyntheticOutline0.m(sb2, advice2.length);
            if (z2) {
                textView6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down_secondary, 0, 0, 0);
            } else {
                textView6.setTag("NO ADVICE");
                textView6.setVisibility(0);
                viewGroup.setVisibility(8);
                textView6.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            view.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(textView6, viewGroup, 4));
        } else {
            textView = textView4;
            textView6.setVisibility(8);
            viewGroup.setVisibility(8);
            view.setOnClickListener(null);
        }
        if (textView3 != null) {
            if (advice.getReadMoreLink() != null) {
                textView3.setVisibility(0);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.addon.stats.advice.AdviceAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        ViewIntent.url(context, advice.getReadMoreLink());
                    }
                });
            } else {
                textView3.setVisibility(8);
                textView3.setOnClickListener(null);
            }
        }
        if (textView != null) {
            if (advice.getGoalType() == null || !z) {
                TextView textView10 = textView;
                textView10.setVisibility(8);
                textView10.setOnClickListener(null);
            } else {
                TextView textView11 = textView;
                textView11.setVisibility(0);
                textView11.setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(context, advice, 5));
            }
        }
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void filter(IFilterListAdapter.IFilter iFilter) {
        Logger.logInfo("Addon " + iFilter.getFilterString());
        filterItems(iFilter.getFilterString());
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = InflatorUtil.get(this.context).inflate(R.layout.row_advice, viewGroup, false);
        }
        Advice advice = this.items.get(i);
        if (advice != null) {
            mapAdviceToView(this.context, R.id.card, view, advice, this.showGoals);
            if (i == 0) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.findViewById(R.id.card).getLayoutParams();
                layoutParams.topMargin = ActivityUtils.getDip(this.context, 8);
                view.findViewById(R.id.card).setLayoutParams(layoutParams);
                return view;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.findViewById(R.id.card).getLayoutParams();
            layoutParams2.topMargin = ActivityUtils.getDip(this.context, 2);
            view.findViewById(R.id.card).setLayoutParams(layoutParams2);
        }
        return view;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void notifyChanged() {
        notifyDataSetChanged();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    @Override // com.urbandroid.sleep.gui.IFilterListAdapter
    public void pause() {
    }
}
