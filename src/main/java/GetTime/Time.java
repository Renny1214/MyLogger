package GetTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Time {

    public final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public String getDate() {
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
