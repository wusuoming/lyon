package net.slowvic.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.slowvic.web.form.UserForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class RegAction extends DispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
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
		UserForm userForm = (UserForm) form;
		userForm.getPassword();
		return mapping.findForward("success");
	}
}
