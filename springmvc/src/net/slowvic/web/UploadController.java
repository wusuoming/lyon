package net.slowvic.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.slowvic.db.biz.UserBiz;
import net.slowvic.web.view.PdfView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UploadController {

    @Autowired
    private UserBiz userBiz;

    @RequestMapping("/upload")
    public String upload() {
        userBiz.getUser(1);
        return "upload";
    }

    @RequestMapping("/doUpload")
    @ResponseBody
    public String doUpload(@RequestParam("uploadFile") MultipartFile file,
        DefaultMultipartHttpServletRequest request)
        throws IllegalStateException, IOException {
        String uploadToken = request.getParameter("uploadToken");
        System.out.println(uploadToken);
        String saveDirectory = request.getSession().getServletContext()
            .getRealPath("/WEB-INF/upload");
        File directory = new File(saveDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File saveFile = new File(saveDirectory + "/"
            + file.getOriginalFilename());
        file.transferTo(saveFile);
        return uploadCallBack("100");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "测试下")
    @RequestMapping("/showStatus")
    public String showStatus() {
        return "404";
    }

    @RequestMapping("/showJsonError")
    @ResponseBody
    public String showJsonError() {
        throw new RuntimeException("测试");
    }

    @RequestMapping("/pdf")
    public ModelAndView showPdf() {
        ModelAndView mav = new ModelAndView();
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("test", "测试");
        mav.setView(new PdfView());
        mav.addAllObjects(model);
        return mav;
    }

    @RequestMapping("/checkUploadPercent")
    @ResponseBody
    public String checkUploadPercent(
        @RequestParam("uploadToken") String uploadToken, HttpSession session) {
        int uploadPercent = 0;
        if (session.getAttribute(uploadToken) != null) {
            uploadPercent = (Integer) session.getAttribute(uploadToken);
        }
        if (uploadPercent == 100) {
            session.removeAttribute(uploadToken);
        }
        return uploadPercent + "";
    }

    private String uploadCallBack(String msg) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
        html.append("<title>upload callback</title>\n");
        html.append("<script type=\"text/javascript\">\n");
        html.append("window.parent.uploadCallBack(\"");
        html.append(msg);
        html.append("\")\n");
        html.append("</script>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("</body>\n");
        html.append("</html>\n");
        return html.toString();
    }
}
