package net.slowvic.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 必须是无状态、线程安全的
 * @author xus
 * <p>
 */
public class StringToDateConverter implements Converter<String, Date> {

    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    public Date convert(String source) {
        DateFormat df = new SimpleDateFormat(format);
        try {
            Date date = df.parse(source);
            return date;
        }
        catch (ParseException e) {
            return null;
        }
    }
}
