package net.slowvic.springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class UploadController {

	@RequestMapping("/file")
	public String uploadFile(@RequestParam("file") MultipartFile file,
			HttpSession session) {
		// 如果需要存放在服务端，还需增加保存文件的代码
		if (file != null)
			System.out.println(file.getSize());
		return "logon";
	}
}
