package transcript;

public class Transcript {
    private String ip;
    private String sessionId;
    private String button;
    private String channelId;

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }

}
