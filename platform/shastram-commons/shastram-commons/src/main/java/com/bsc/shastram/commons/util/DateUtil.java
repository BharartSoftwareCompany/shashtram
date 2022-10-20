package com.bsc.shastram.commons.util;



import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;



@Component
public class DateUtil {

    private   static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";

    private static String getUTCdatetimeAsString()
    {
        final SimpleDateFormat sdf = new SimpleDateFormat(DATEFORMAT);
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = sdf.format(new Date());

        return utcTime;
    }


    public static Date getCurrentDateTimeUTC()
    {
        return StringDateToDate(getUTCdatetimeAsString());
    }
    public static long getEPOCTime() 
    {
        return Instant.now().toEpochMilli();
    }
    public static Long getCurrentDateTimeUTCMilli()
    {
        return  getCurrentDateTimeUTC().getTime();
    }

    private static Date StringDateToDate(String StrDate)
    {
        Date dateToReturn = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATEFORMAT);

        try
        {
            dateToReturn = (Date)dateFormat.parse(StrDate);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return dateToReturn;
    }


    public static long getDelayedDaysDateInMillis(int days)
    {
        Date currentDate = new Date();
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        localDateTime = localDateTime.plusDays(days);
        Date updatedDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return updatedDate.getTime();

    }

    public static long  getOlderMilliTimeStamp(int days)
    {
        DateTime datetime = new DateTime().minusDays(days);
        return datetime.toDate().getTime();
    }




}
