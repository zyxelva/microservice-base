package com.taeyeon.zyx.utils;

import com.fasterxml.jackson.core.io.NumberInput;

import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Pattern;

/**
 * DateFormat
 */
public class DateFormat extends SimpleDateFormat {

    public final static String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    private SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT_STR);
    private static Pattern digitPattern = Pattern.compile("^\\d+$");

    private TimeZone timeZone;

    public DateFormat() {
    }

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        toAppendTo.append(date.getTime());
        return toAppendTo;
    }

    @Override
    public Date parse(String source) throws ParseException {
        source = source.trim();
        ParsePosition pos = new ParsePosition(0);
        Date dt = _parseDate(source, pos);
        if (dt != null) {
            return dt;
        }

        throw new ParseException
                (String.format("Cannot parse date \"%s\": not compatible with any of standard forms (%s)",
                        source, DATE_FORMAT_STR), pos.getErrorIndex());
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        try {
            return _parseDate(source, pos);
        } catch (ParseException e) {
            // may look weird but this is what `DateFormat` suggest to do...
        }
        return null;
    }

    /**
     * 这里装饰clone方法的原因是因为clone方法在jackson中也有用到
     */
    @Override
    public DateFormat clone() {
        DateFormat eduDateFormat = new DateFormat();
        eduDateFormat.timeZone = this.timeZone;
        return eduDateFormat;
    }

    /**
     * fix 用继承的抛空指针异常，jackson中也有用到
     *
     * @param zone
     */
    @Override
    public void setTimeZone(TimeZone zone) {
        this.timeZone = zone;
    }

    private Date _parseDate(String dateStr, ParsePosition pos) throws ParseException {
        if (digitPattern.matcher(dateStr).matches()) {
            return _parseDateFromLong(dateStr, pos);
        } else {
            return format.parse(dateStr, pos);
        }
    }

    private Date _parseDateFromLong(String longStr, ParsePosition pos) throws ParseException {
        long ts;
        try {
            ts = NumberInput.parseLong(longStr);
        } catch (NumberFormatException e) {
            throw new ParseException(String.format(
                    "Timestamp value %s out of 64-bit value range", longStr),
                    pos.getErrorIndex());
        }
        return new Date(ts);
    }

}
