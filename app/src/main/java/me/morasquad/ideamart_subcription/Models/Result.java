package me.morasquad.ideamart_subcription.Models;

/**
 * Created by Sandun Isuru Niraj on 23/05/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("requestId")
    @Expose
    private String requestId;
    @SerializedName("statusDetail")
    @Expose
    private String statusDetail;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("statusCode")
    @Expose
    private String statusCode;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getStatusDetail() {
        return statusDetail;
    }

    public void setStatusDetail(String statusDetail) {
        this.statusDetail = statusDetail;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

}