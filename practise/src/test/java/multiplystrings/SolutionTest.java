package multiplystrings;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void testMultiply_singleDigits() {
        String num1 = "2";
        String num2 = "3";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("6", res);
    }

    @Test
    public void testMultiply_doubleDigits() {
        String num1 = "9";
        String num2 = "3";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("27", res);
    }

    @Test
    public void testMultiply_numberDigits() {
        String num1 = "99";
        String num2 = "9";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("891", res);
    }

    @Test
    public void testMultiply_numberNumber() {
        String num1 = "99";
        String num2 = "99";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("9801", res);
    }

    @Test
    public void testMultiply_numberNumber_2() {
        String num1 = "123";
        String num2 = "456";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("56088", res);
    }

    @Test
    public void testMultiply_numberNumber_3() {
        String num1 = "123456789";
        String num2 = "987654321";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("121932631112635269", res);
    }

    @Test
    public void testMultiply_numberNumber_4() {
        String num1 = "1234";
        String num2 = "7890";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("9736260", res);
    }

    @Test
    public void testMultiply_numberNumber_5() {
        String num1 = "401716832807512840963";
        String num2 = "167141802233061013023557397451289113296441069";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("67143675422804947379429215144664313370120390398055713625298709447", res);
    }

    @Test
    public void testAddStringsList() {
        List<String> products = List.of("2", "3");
        Solution s = new Solution();
        String sum = s.addStringsList(products);
        assertEquals("5", sum);
    }

    @Test
    public void testAddStringsList_2() {
        List<String> products = List.of("111", "222");
        Solution s = new Solution();
        String sum = s.addStringsList(products);
        assertEquals("333", sum);
    }

    @Test
    public void testAddStringsList_3() {
        List<String> products = List.of("8701", "1100");
        Solution s = new Solution();
        String sum = s.addStringsList(products);
        assertEquals("9801", sum);
    }

    @Test
    public void testAdd() {
        String s1 = "1223";
        char ch = '2';
        Solution s = new Solution();
        String res = s.add(s1, ch);
        assertEquals("1225", res);
    }

    @Test
    public void testAdd_2() {
        String s1 = "1223";
        char ch = '9';
        Solution s = new Solution();
        String res = s.add(s1, ch);
        assertEquals("1232", res);
    }

    @Test
    public void testAdd_3() {
        String s1 = "999";
        char ch = '1';
        Solution s = new Solution();
        String res = s.add(s1, ch);
        assertEquals("1000", res);
    }

    @Test
    public void testAdd_4() {
        String s1 = "999";
        char ch = '9';
        Solution s = new Solution();
        String res = s.add(s1, ch);
        assertEquals("1008", res);
    }

    @Test
    public void testAdd_5() {
        String s1 = "9999";
        char ch = '1';
        Solution s = new Solution();
        String res = s.add(s1, ch);
        assertEquals("10000", res);
    }

    @Test
    public void testAddCharsStr() {
        List<Character> chars = List.of('4', '6', '8');
        Solution s = new Solution();
        String sum = s.addCharsStr(chars);
        assertEquals("18", sum);
    }

    @Test
    public void testMultiply_numberNumber_6() {
        String num1 = "40963";
        String num2 = "1069";
        Solution s = new Solution();
        String res = s.multiply(num1, num2);
        assertEquals("43789447", res);
    }
}
