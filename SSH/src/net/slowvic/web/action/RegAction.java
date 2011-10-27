package net.slowvic.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slowvic.biz.dao.BookDao;
import net.slowvic.modal.domain.Artist;
import net.slowvic.modal.domain.User;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 继承DispatchAction。注意不要Override掉execute方法。
 * 
 * @author xus
 * <p>
 */
public class RegAction extends DispatchAction {
    
    private static Log log = LogFactory.getLog(RegAction.class);

    public ActionForward success(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        BookDao bd = new BookDao();
        log.debug("开始crud操作.");
        bd.crud();
        log.debug("crud操作完成.");
        Artist artist = getApplicationContext(request).getBean(Artist.class);
        log.debug(artist.getAge());
        request.setAttribute("msg", "欢迎登录");
        return mapping.findForward("success");
    }

    public WebApplicationContext getApplicationContext(
        HttpServletRequest request) {
        return WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
    }

    public ActionForward reg(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        form.validate(mapping, request);
        User user = new User();
        //将表单数据copy到模型类User中
        BeanUtils.copyProperties(user, request.getParameterMap());
        request.setAttribute("user", user);
        return mapping.findForward("success");
    }
    
    //创建xml页面
    public ActionForward createXmlPage(ActionMapping mapping, ActionForm form,
    		HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    	response.setContentType("text/xml");
    	
    	//创建根节点
    	Document doc = new Document();
    	Element root = new Element("users");
    	doc.setRootElement(root);
    	
    	//节点
    	Element e = new Element("user");
    	e.setAttribute("name", "mike");
    	e.setAttribute("age", "30");
    	root.addContent(e);
    	
    	e = new Element("user");
    	e.setAttribute("name", "david");
    	e.setAttribute("age", "45");
    	root.addContent(e);
    	
    	XMLOutputter outputter = new XMLOutputter();
    	PrintWriter pw = response.getWriter();
    	outputter.output(doc, pw);
    	pw.close();
    	
    	return null;
    }
}
