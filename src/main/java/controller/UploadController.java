package controller;

import tools.HandlerSVG;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;

/**
 * Test. Online editor of SVG-files. Import/export of files.
 * Class UploadController.
 * Controller for handling of files uploading.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-10-31
 */


@Controller
public class UploadController {

    private HandlerSVG handlerSVG = new HandlerSVG();

    @RequestMapping(value = "upload.edi", method = RequestMethod.GET)
    public ModelAndView goHome(HttpSession session) {

        session.setAttribute("editing", null);
        session.setAttribute("saving", false);
        session.setAttribute("nofile", null);
        session.setAttribute("editImage", null);

        return new ModelAndView("../../index");
    }


    @RequestMapping(value = "upload.edi", method = RequestMethod.POST)
    public ModelAndView uploadFile(@RequestParam CommonsMultipartFile image, HttpSession session) {

        session.setAttribute("saving", false);
        String filename = image.getOriginalFilename();
        boolean isUpload;

        if (filename.toLowerCase().endsWith(".svg")) {
            byte[] bytesArray = image.getBytes();
            String xmlImageSVG = handlerSVG.getFileAsString(bytesArray);
            session.setAttribute("editImage", handlerSVG.isFileSVG(xmlImageSVG) ? xmlImageSVG : null);
            isUpload = true;
        } else {
            session.setAttribute("editImage", null);
            isUpload = false;
        }

        session.setAttribute("editing", isUpload);
        session.setAttribute("nofile", null);

        return new ModelAndView("editpage");
    }


    @RequestMapping(method = RequestMethod.POST, params = {})
    public String goToView() {
        return "view";
    }

}
