package net.slowvic.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slowvic.web.domainmodal.User;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

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
}
