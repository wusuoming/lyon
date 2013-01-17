package net.slowvic.web.view;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

public class PdfView extends AbstractPdfView {

    public PdfView() {
        // 下载文件的contentType
        setContentType("application/x-msdownload;charset=UTF-8");
    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model,
        Document document,
        PdfWriter writer, HttpServletRequest request,
        HttpServletResponse response)
        throws Exception {
        BaseFont bfChinese = BaseFont.createFont("STSong-Light",
            "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);
        document.add(new Paragraph((String) model.get("test"), fontChinese));
        document.add(new Paragraph("damn shit"));
        // 文件名必须encode下，否则中文出不来
        String fileName = URLEncoder.encode("示例", "UTF-8") + ".pdf";
        String disposition = "attachment;filename=" + fileName;
        response.setHeader("Content-disposition", disposition);
    }

}
