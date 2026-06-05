package com.urbandroid.smartlight.common.controller;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.smartlight.common.model.AuthenticatedGateway;
import com.urbandroid.smartlight.hue.HueController;
import com.urbandroid.smartlight.hue.yahue.YaHueController;
import com.urbandroid.smartlight.ikea.dirigera.DirigeraController;
import com.urbandroid.smartlight.ikea.tradfri.TradfriController;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/urbandroid/smartlight/common/controller/ControllerFactory;", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "create", "Lcom/urbandroid/smartlight/common/controller/Controller;", "gateway", "Lcom/urbandroid/smartlight/common/model/AuthenticatedGateway;", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ControllerFactory {
    private final Context context;

    public ControllerFactory(Context context) {
        context.getClass();
        this.context = context;
    }

    public final Controller create(AuthenticatedGateway gateway) {
        gateway.getClass();
        if (gateway instanceof AuthenticatedGateway.Hue) {
            return new HueController(this.context, (AuthenticatedGateway.Hue) gateway);
        }
        if (gateway instanceof AuthenticatedGateway.YaHue) {
            return new YaHueController(this.context, (AuthenticatedGateway.YaHue) gateway);
        }
        if (gateway instanceof AuthenticatedGateway.Tradfri) {
            return new TradfriController(this.context, (AuthenticatedGateway.Tradfri) gateway);
        }
        if (gateway instanceof AuthenticatedGateway.Dirigera) {
            return new DirigeraController(this.context, (AuthenticatedGateway.Dirigera) gateway);
        }
        Home$$ExternalSyntheticBUOutline0.m();
        return null;
    }

    public final Context getContext() {
        return this.context;
    }
}
