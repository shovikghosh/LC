package shovik;


import multiplystrings.SolutionTest;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test.
     */
    @Test
    public void testApp() {
        assertTrue(true);
    }

    @Suite
    @SuiteDisplayName("Leetcode Java Solutions Test Suite")
    @SelectClasses({SolutionTest.class})
    public static class JUnitTestSuite {
    }

    @Test
    public void generatePackageName() throws MalformedURLException {

        String urlStr = "https://leetcode.com/problems/multiply-strings/description/";

        URL url = new URL(urlStr);
        String[] paths = url.getPath().split("/");
        Arrays.stream(paths).forEach(System.out::println);
        System.out.println(paths[2].replace("-", ""));
    }
}
