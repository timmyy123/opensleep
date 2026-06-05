package io.github.zeroone3010.yahueapi.v2.domain;

import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
@JsonTypeName(DeviceRequestsHelper.DEVICE_INFO_DEVICE)
public class DeviceResource extends Resource {

    @JsonProperty("metadata")
    private Metadata metadata;

    @JsonProperty("product_data")
    private ProductData productData;

    @JsonProperty("services")
    private List<ResourceIdentifier> services;

    public Metadata getMetadata() {
        return this.metadata;
    }

    public ProductData getProductData() {
        return this.productData;
    }

    public List<ResourceIdentifier> getServices() {
        return this.services;
    }
}
