package org.issoft.automation.page.FinalTask.Objects;

public class DriverAttributes {
    private BrowserType name;
    private String version;
    private Boolean isRemote;
    private String remoteType;
    private String url;
    private String platform;


    public DriverAttributes(BrowserType name, Boolean isRemote) {
        this.name = name;
        this.isRemote = isRemote;
    }

    public BrowserType getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Boolean getRemote() {
        return isRemote;
    }

    public void setRemote(Boolean remote) {
        isRemote = remote;
    }

    public String getRemoteType() {
        return remoteType;
    }

    public void setRemoteType(String remoteType) {
        this.remoteType = remoteType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
