package multiplystrings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

class Solution {
    public String multiply(String num1, String num2) {
        if (Objects.equals(num1, "0") || Objects.equals(num2, "0")) {
            return "0";
        }
        return multiplyNumberWithNumber(num1, num2);
    }

    private String multiplyNumberWithNumber(String num1, String num2) {
        if (num2.length() > num1.length()) {
            String t = num2;
            num2 = num1;
            num1 = t;
        }
        int len = num2.length();
        List<String> products = new LinkedList<>();
        int c = 0;
        for (int i = len - 1; i >= 0; i--) {
            char digit = num2.charAt(i);
            String withPostZeros = appendZeros(multipleNumberWithDigit(num1, digit), c);
            c++;
            products.add(withPostZeros);
        }
        return addStringsList(products);
    }

    public String addStringsList(List<String> products) {
        if (products.size() == 1)
            return products.getFirst();

        List<String> reversedProducts = products.stream().map(StringBuilder::new).map(StringBuilder::reverse).map(StringBuilder::toString).filter(p -> !p.equals("0")).toList();
        int offset = 0;
        List<Character> chars = new LinkedList<>();
        StringBuilder result = new StringBuilder();
        boolean hasAnyNum = false;
        List<String> carryList = new ArrayList<>();
        while (true) {
            for (String rp : reversedProducts) {
                if (offset < rp.length()) {
                    hasAnyNum = true;
                    chars.add(rp.charAt(offset));
                }
            }
            if (!hasAnyNum) {
                String sumWoCarry = result.toString();
                if (carryList.isEmpty())
                    return sumWoCarry;
                else {
                    return addStringsList(List.of(sumWoCarry, addStringsList(carryList)));
                }
            }
            offset++;
            String total = addCharsStr(chars.stream().filter(c -> c != '0').toList());
            char last = total.charAt(total.length() - 1);
            String carryOverNumber = total.substring(0, total.length() - 1);
            if (!carryOverNumber.trim().isEmpty()) {
                carryList.add(appendZeros(carryOverNumber, offset));
            }
            result.insert(0, String.valueOf(last));
            hasAnyNum = false;
            chars.clear();
        }
    }

    public String addCharsStr(List<Character> chars) {
        if (chars.isEmpty())
            return "0";
        String total = "0";
        for (char ch : chars) {
            total = add(total, ch);
        }
        return total;
    }

    private String add(char ch1, char ch2) {
        int i1 = ch1 - '0';
        int i2 = ch2 - '0';
        return String.valueOf(i1 + i2);
    }

    public String add(String str, char ch) {
        if (Objects.equals(str, "0"))
            return String.valueOf(ch);
        if (ch == '0')
            return str;
        int idx = str.length() - 1;
        String sum;
        StringBuilder sb = new StringBuilder(str);
        while (idx >= 0) {
            sum = add(str.charAt(idx), ch);
            if (sum.length() > 1) {
                // carry cant be more than 1
                sb.replace(idx, idx + 1, String.valueOf(sum.charAt(1)));
            } else {
                sb.replace(idx, idx + 1, String.valueOf(sum.charAt(0)));
                return sb.toString();
            }
            ch = '1';
            idx--;
        }
        return "1" + sb.toString();
    }

    private String appendZeros(String num, int numZeros) {
        if (Objects.equals(num, "0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        int len = num.length();
        sb.insert(0, num);
        for (int i = 0; i < numZeros; i++) {
            sb.insert(len + i, "0");
        }
        return sb.toString();
    }

    private String multipleNumberWithDigit(String num, char digit) {
        if (digit == '0')
            return "0";
        int len = num.length();
        char carry = '0';
        StringBuilder product = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            char dgt = num.charAt(i);
            String[] res = multiplyDigits(dgt, digit, carry);
            carry = res[1].charAt(0);
            product.insert(0, res[0]);
        }
        if (carry != '0') {
            return String.valueOf(carry) + product.toString();
        } else {
            return product.toString();
        }
    }

    private String[] multiplyDigits(char digit1, char digit2) {
        return multiplyDigits(digit1, digit2, '0');
    }

    private String[] multiplyDigits(char digit1, char digit2, char carry) {
        int d1 = digit1 - '0';
        int d2 = digit2 - '0';
        int c = carry - '0';

        int res = d1 * d2 + c;
        if (res >= 10) {
            return new String[]{String.valueOf(res % 10), String.valueOf(res / 10)};
        } else {
            return new String[]{String.valueOf(res), "0"};
        }
    }
}
