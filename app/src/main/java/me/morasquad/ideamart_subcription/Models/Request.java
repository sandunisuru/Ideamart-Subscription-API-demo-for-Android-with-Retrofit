package me.morasquad.ideamart_subcription.Models;

/**
 * Created by Sandun Isuru Niraj on 23/05/2018.
 */

public class Request {

    private String applicationId;
    private String password;
    private String version;
    private String action;
    private String subscriberId;

    public Request(String applicationId, String password, String version, String action, String subscriberId) {
        this.applicationId = applicationId;
        this.password = password;
        this.version = version;
        this.action = action;
        this.subscriberId = subscriberId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }
}
