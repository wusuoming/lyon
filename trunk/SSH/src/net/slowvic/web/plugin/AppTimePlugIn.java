package net.slowvic.web.plugin;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

/**
 * PlugIn，在系统启动和关闭时执行一些一次性的操作。<br>
 * 参数必须提供setter/getter方法才能通过配置注入。
 * @author xus
 * <p>
 */
public class AppTimePlugIn implements PlugIn {

    private String datePattern;

    public String getDatePattern() {
        return datePattern;
    }

    public void setDatePattern(String datePattern) {
        this.datePattern = datePattern;
    }

    @Override
    public void destroy() {
        formatTime();
    }

    @Override
    public void init(ActionServlet servlet, ModuleConfig config)
        throws ServletException {
        formatTime();
    }

    private void formatTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(getDatePattern());
        System.out.println(sdf.format(new Date()));
    }
}
