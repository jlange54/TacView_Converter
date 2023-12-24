public class Runtime {

    private static long startTime;
    private static long endTime;

    public static long currentTime () {
        long unixTime = System.currentTimeMillis();
        return unixTime;
    }

    public static void start () {
       startTime = currentTime();
    }

    public static long end (timeUnit timeUnit) {
        endTime = currentTime();
        long duration = endTime - startTime;

        switch (timeUnit) {
            case ms:
                return duration;
            case seconds:
                return duration/1000L;
            case minutes:
                return duration/60000L;
            default:
                return duration;
        }
    }

    enum timeUnit {
        ms, seconds, minutes
    }
}
