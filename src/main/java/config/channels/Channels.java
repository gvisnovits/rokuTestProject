package config.channels;

public enum Channels {

    HELLO_WORLD("helloWorld/hello-world.zip", "helloWorld");

    private String channelNameDirectory;
    private String appName;

    Channels(String channelName, String appName) {
        this.channelNameDirectory = channelNameDirectory;
        this.appName = appName;
    }

    public String getChannelNameDirectory() {
        return channelNameDirectory;
    }

    public String getAppName() {
        return appName;
    }
}
