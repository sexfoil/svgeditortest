package tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static junit.framework.Assert.assertTrue;

/**
 * Created by SiXFOiL on 01.11.2017.
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
