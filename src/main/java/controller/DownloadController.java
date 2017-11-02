package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

/**
 * Test. Online editor of SVG-files. Import/export of files.
 * Class DownloadController.
 * Controller for handling of files downloading.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-10-31
 */


@Controller
public class DownloadController {

    @RequestMapping(value = "download.edi", method = RequestMethod.GET)
    public ModelAndView downloadFile(HttpServletResponse response, HttpSession session) throws IOException {

        if (session.getAttribute("saving") != null && session.getAttribute("editImage") != null) {

            String fileAsString = (String) session.getAttribute("editImage");

            PrintWriter printWriter = new PrintWriter("saveImage.svg");
            printWriter.write(fileAsString);
            printWriter.flush();
            printWriter.close();

            File downloadFile = new File("saveImage.svg");
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(downloadFile);

            response.setContentType("image/svg+xml");
            response.setContentLength((int) downloadFile.length());
            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
            response.setHeader(headerKey, headerValue);

            OutputStream outStream = null;
            outStream = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }

            inputStream.close();
            outStream.close();

            session.setAttribute("saving", true);
        } else {
            session.setAttribute("nofile", "No file to export...");
            session.setAttribute("editing", null);
        }
        return new ModelAndView("editpage");
    }

    @RequestMapping(method = RequestMethod.POST, params = {})
    public String goHome() {
        return "view";
    }

}
