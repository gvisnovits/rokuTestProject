package transcript;

public class Transcript {
    private String ip;
    private String sessionId;
    private String button;

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    private String channelId;

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

    public String setButton(String navigation) {
        return this.button;
    }

}
