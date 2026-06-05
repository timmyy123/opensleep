package com.urbandroid.sleep.addon.stats.chart.group;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.addon.stats.ChartFragment$1$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.addon.stats.chart.IChartBuilder;
import com.urbandroid.sleep.ai.AiActivity$$ExternalSyntheticLambda6;
import com.urbandroid.sleep.gui.inflator.InflatorUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ChartBuilderGroup {
    private Context context;
    private SelectedListener listener;
    private Animation showAnim;
    private List<IChartBuilder> builders = new ArrayList();
    private int selected = 0;

    public interface SelectedListener {
    }

    public ChartBuilderGroup(Context context) {
        this.context = context;
        this.showAnim = AnimationUtils.loadAnimation(context, R.anim.slide_up_slow);
    }

    private String[] buildArray() {
        int size = this.builders.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = this.builders.get(i).getGraphTitle();
        }
        return strArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buildChart(int i, ViewGroup viewGroup) {
        viewGroup.removeAllViews();
        IChartBuilder iChartBuilder = this.builders.get(i);
        View viewCreateView = iChartBuilder.createView(this.context);
        viewCreateView.startAnimation(this.showAnim);
        viewGroup.addView(viewCreateView);
        if (iChartBuilder.getHelpUrl() != null) {
            InflatorUtil.get(this.context).inflate(R.layout.button_chart_help, viewGroup);
            viewGroup.findViewById(R.id.help).setOnClickListener(new AiActivity$$ExternalSyntheticLambda6(this, iChartBuilder, 6));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$buildChart$0(IChartBuilder iChartBuilder, View view) {
        ViewIntent.urlCustomTab((Activity) this.context, iChartBuilder.getHelpUrl());
    }

    public ChartBuilderGroup addBuilder(IChartBuilder iChartBuilder) {
        this.builders.add(iChartBuilder);
        return this;
    }

    public void build(Spinner spinner, final ViewGroup viewGroup) {
        String[] strArrBuildArray = buildArray();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.context, R.layout.spinner_chart, strArrBuildArray);
        arrayAdapter.setDropDownViewResource(R.layout.charts_spinner_dropdown_item);
        spinner.setAdapter((SpinnerAdapter) arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.urbandroid.sleep.addon.stats.chart.group.ChartBuilderGroup.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (ChartBuilderGroup.this.listener != null) {
                    ((ChartFragment$1$$ExternalSyntheticLambda0) ChartBuilderGroup.this.listener).selected(i);
                }
                ChartBuilderGroup.this.buildChart(i, viewGroup);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        if (strArrBuildArray.length > 0) {
            spinner.setSelection(Math.min(this.selected, strArrBuildArray.length - 1));
        }
    }

    public String getBuilderTitle(int i) {
        return this.builders.get(i).getGraphTitle();
    }

    public void setListener(SelectedListener selectedListener) {
        this.listener = selectedListener;
    }

    public ChartBuilderGroup setSelected(String str) {
        for (int i = 0; i < this.builders.size(); i++) {
            if (this.builders.get(i).getGraphTitle().equals(str)) {
                this.selected = i;
            }
        }
        return this;
    }
}
