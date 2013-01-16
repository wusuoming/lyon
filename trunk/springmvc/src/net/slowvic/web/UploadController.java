package net.slowvic.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/doUpload")
    public String doUpload(@RequestParam("uploadFile") MultipartFile file,
        HttpServletRequest request) throws IllegalStateException, IOException {
        String saveDirectory = request.getSession().getServletContext()
            .getRealPath("/WEB-INF/upload");
        File directory = new File(saveDirectory);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File saveFile = new File(saveDirectory + "/"
            + file.getOriginalFilename());
        file.transferTo(saveFile);
        return "upload";
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
}
