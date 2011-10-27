package net.slowvic.web.actionform;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FileForm extends ActionForm {

	private static final long serialVersionUID = 2932425973290123608L;
	
	private FormFile uploadFile;

	public FormFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(FormFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
