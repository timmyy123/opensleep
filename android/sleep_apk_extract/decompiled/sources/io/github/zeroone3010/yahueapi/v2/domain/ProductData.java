package io.github.zeroone3010.yahueapi.v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/* JADX INFO: loaded from: classes5.dex */
public class ProductData {

    @JsonProperty("certified")
    private boolean certified;

    @JsonProperty("hardware_platform_type")
    private String hardwarePlatformType;

    @JsonProperty("manufacturer_name")
    private String manufacturerName;

    @JsonProperty("model_id")
    private String modelId;

    @JsonProperty("product_archetype")
    private String productArchetype;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("software_version")
    private String softwareVersion;

    public String getHardwarePlatformType() {
        return this.hardwarePlatformType;
    }

    public String getManufacturerName() {
        return this.manufacturerName;
    }

    public String getModelId() {
        return this.modelId;
    }

    public String getProductArchetype() {
        return this.productArchetype;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public boolean isCertified() {
        return this.certified;
    }

    public String toString() {
        return JsonStringUtil.toJsonString(this);
    }
}
