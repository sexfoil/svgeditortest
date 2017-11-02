package tools;

import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * Test. Online editor of SVG-files. Import/export of files.
 * Class HandlerSVG.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-10-31
 */


public class HandlerSVG {

    private static final String OPENING_TAG = "<svg";
    private static final String CLOSING_TAG = "</svg>";

    /**
     * Makes a string from array of bytes(svg-file) to insert in HTML code.
     *
     * @param   bytesArray the array of bytes from svg-file stream.
     * @return  fileString the string contains svg-tags to shown in HTML.
     */
    public String getFileAsString(byte[] bytesArray) {
        String fileString = "";
        for (byte b : bytesArray) {
            fileString += (char) b;
        }
        return fileString;
    }

    /**
     * Makes a string from array of bytes(svg-file) to insert in HTML code.
     *
     * @param   str the string to checking.
     * @return  does the string contain svg-tags or not.
     */
    public boolean isFileSVG(String str) {
        return str.trim().contains(OPENING_TAG) && str.trim().contains(CLOSING_TAG);
    }
}
