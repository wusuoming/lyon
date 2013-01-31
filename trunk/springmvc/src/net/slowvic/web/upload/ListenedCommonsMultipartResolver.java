package net.slowvic.web.upload;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class ListenedCommonsMultipartResolver extends CommonsMultipartResolver {

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request)
        throws MultipartException {
        String encoding = determineEncoding(request);
        final FileUpload fileUpload = prepareFileUpload(encoding);
        final String uploadToken = request.getParameter("uploadToken");
        // 插入监听
        final HttpSession session = request.getSession();

        fileUpload.setProgressListener(new ProgressListener() {
            public void update(long pBytesRead, long pContentLength,
                int pItems) {
                int percent = (int) (((float) pBytesRead / (float) pContentLength) * 100);
                session.setAttribute(uploadToken, percent + "%");
            }
        });
        try {
            @SuppressWarnings("unchecked")
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload)
                .parseRequest(request);
            return parseFileItems(fileItems, encoding);
        }
        catch (FileUploadBase.SizeLimitExceededException ex) {
            throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(),
                ex);
        }
        catch (FileUploadException ex) {
            throw new MultipartException(
                "Could not parse multipart servlet request", ex);
        }
    }

    public Map<String, String> getParametersMap(List<FileItem> fileItems,
        String encoding) {
        Map<String, String> params = new HashMap<String, String>();
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                try {
                    params.put(fileItem.getFieldName(), fileItem
                        .getString(encoding));
                }
                catch (UnsupportedEncodingException e) {
                    params.put(fileItem.getFieldName(), "");
                }
            }
        }
        return params;
    }
}
