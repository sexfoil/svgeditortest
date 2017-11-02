package tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static junit.framework.Assert.assertTrue;

/**
 * Test. Online editor of SVG-files. Import/export of files.
 * Class HandlerSVGTest. Tasting some methods.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-11-02
 */


@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(locations = {"classpath:beans-config.xml"})
public class HandlerSVGTest {

    @Autowired()
    HandlerSVG handlerSVG;

    @Test
    public void testIsFileSVG() {
        boolean isSVG = handlerSVG.isFileSVG("<svg></svg>");
        assertTrue("It should be SVG", isSVG);
    }

    @Test
    public void testGetStringFromByteArray() {
        byte[] testArray = {84,69, 83, 84, 32, 80, 65, 83, 83, 69, 68, 33};
        String str = handlerSVG.getFileAsString(testArray);
        assertTrue("It should be String", str.equals("TEST PASSED!"));
    }

}
