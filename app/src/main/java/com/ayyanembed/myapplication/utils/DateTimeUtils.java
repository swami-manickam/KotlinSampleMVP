package com.ayyanembed.myapplication.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

public class DateTimeUtils {

  public static Date getDisplayDateToDate(String input) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
    final Date date;
    try {
      date = simpleDateFormat.parse(input);
      return date;
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static String getDisplayDate(Date input) {
    if (input == null) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yy", Locale.getDefault());
    return simpleDateFormat.format(input);
  }

  public static String getDisplayTime(Date input) {
    if (input == null) {
      return "";
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
    return simpleDateFormat.format(input);
  }

  public static Date combineDateAndTime(Date date, Date time) {
    if (date == null && time == null) {
      return null;
    } else if (date == null) {
      return time;
    } else if (time == null) {
      return date;
    } else {
      Calendar dateTime = Calendar.getInstance();
      Calendar date1 = Calendar.getInstance();
      date1.setTime(date);
      Calendar time1 = Calendar.getInstance();
      time1.setTime(time);
      dateTime.set(date1.get(Calendar.YEAR), date1.get(Calendar.MONTH), date1.get(Calendar.DATE),
          time1.get(Calendar.HOUR_OF_DAY), time1.get(Calendar.MINUTE), time1.get(Calendar.SECOND));
      dateTime.set(Calendar.MILLISECOND, time1.get(Calendar.MILLISECOND));
      return dateTime.getTime();
    }
  }

  public static Date getTomorrowsDate() {
    Calendar calendar = Calendar.getInstance();
    calendar.roll(Calendar.DATE, true);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DATE), 0, 0, 0);
    return calendar.getTime();
  }

  public static Date getDayStartDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DATE), 0, 0, 0);
    return calendar.getTime();
  }

  public static Date getDayEndDate(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DATE), 23, 59, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }

  public static Date getDurationAddedDate(Date dateTime, int hour, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    calendar.add(Calendar.HOUR, hour);
    calendar.add(Calendar.MINUTE, minute);

    return calendar.getTime();
  }

  public static String getStringTimeDiffInHoursAndMin(Date startDateTime, Date finishDateTime) {
    long different = finishDateTime.getTime() - startDateTime.getTime();
    long secondsInMilli = 1000;
    long minutesInMilli = secondsInMilli * 60;
    long hoursInMilli = minutesInMilli * 60;
    long hours = different / hoursInMilli;
    different = different % hoursInMilli;
    long remainingMinutes = different / minutesInMilli;
    return formatHoursAndMinutes((int) hours, (int) remainingMinutes);
  }

  public static double getTimeDiffBetweenDate(Date startDateTime, Date finishDateTime) {
    long diffInMilliseconds = finishDateTime.getTime() - startDateTime.getTime();
    return TimeUnit.MILLISECONDS.toMinutes(diffInMilliseconds) / 60.0;
  }

  private static String formatHoursAndMinutes(int hours, int minutes) {
    return String.format(Locale.getDefault(), "%d:%02d", hours, minutes);
  }

  public static Date createDateObject(int year, int monthOfYear, int dayOfMonth) {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, monthOfYear);
    calendar.set(Calendar.DATE, dayOfMonth);
    return calendar.getTime();
  }

  public static Date createDateObject(int hourOfDay, int minute) {
    Calendar calendar = Calendar.getInstance();
    calendar.clear();
    calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, 0);
    return calendar.getTime();
  }

  public static String getServerData(@NotNull Date time) {
    SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("yyyy-MM-dd hh:mm", Locale.getDefault());
    return simpleDateFormat.format(time);
  }
}
