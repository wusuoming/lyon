package net.slowvic.web.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slowvic.web.domainmodal.User;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;

/**
 * 继承DispatchAction。注意不要Override掉execute方法。
 * 
 * @author xus
 * <p>
 */
public class RegAction extends DispatchAction {

    public ActionForward success(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
        // BookDao bd = new BookDao();
        // bd.crud();
        request.setAttribute("msg", "欢迎登录");
        return mapping.findForward("success");
    }

    public ActionForward reg(ActionMapping mapping, ActionForm form,
        HttpServletRequest request, HttpServletResponse response)
        throws Exception {
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
