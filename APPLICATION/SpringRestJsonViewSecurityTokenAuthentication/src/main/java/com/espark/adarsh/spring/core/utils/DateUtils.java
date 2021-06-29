package com.espark.adarsh.spring.core.utils;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Adarsh Kumar
 * @author $LastChangedBy: Adarsh Kumar$
 * @version $Revision: 0001 $, $Date:: 1/1/10 0:00 AM#$
 * @Espark @copyright all right reserve
 */
public class DateUtils {

    private static final String dateFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static String formatDate(Date dateObject){

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        return dateFormat.format(dateObject);

    }

    public static Date parseDate(String dateString) throws ParseException{

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatString);
        return dateFormat.parse(dateString);
    }

    public static LocalDate getDate(final String dateString,final String format){
        final DateTimeFormatter dateFormatter = DateTimeFormat.forPattern(format);
        final LocalDate localDate=dateFormatter.parseLocalDate(dateString);
        return localDate;
    }
}

