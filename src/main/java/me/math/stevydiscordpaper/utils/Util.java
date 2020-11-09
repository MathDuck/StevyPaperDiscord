package me.math.stevydiscordpaper.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Util {
    public static String completeDate(){
        return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.FRANCE).format(new Date());
    }

    public static String shortDateHour(){
        return new SimpleDateFormat("dd/MM/yy à HH:mm", Locale.FRANCE).format(new Date());
    }

    public static String shortDate(){
        return new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).format(new Date());
    }

    public static String justClock() {
        return new SimpleDateFormat("HH:mm:ss", Locale.FRANCE).format(new Date());
    }

    public static String statsDate()
    {
        return new SimpleDateFormat("MM/dd", Locale.FRANCE).format(new Date());
    }

    public static Date ticksToDate(long ticks) {
        ticks = ticks - 18000L + 24000L;
        long days = ticks / 24000L;
        ticks -= days * 24000L;
        long hours = ticks / 1000L;
        ticks -= hours * 1000L;
        long minutes = (long)Math.floor(ticks / 16.666666666666668D);
        double dticks = ticks - minutes * 16.666666666666668D;
        long seconds = (long)Math.floor(dticks / 0.2777777777777778D);
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"), Locale.FRANCE);
        cal.setLenient(true);
        cal.set(0, 0, 1, 0, 0, 0);
        cal.add(6, (int)days);
        cal.add(11, (int)hours);
        cal.add(12, (int)minutes);
        cal.add(13, (int)seconds + 1);
        return cal.getTime();
    }
}