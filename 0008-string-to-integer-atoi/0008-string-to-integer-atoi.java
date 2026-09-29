class Solution {

    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {

        // "123" -> 123
        // "-23" -> -23
        // "+123" -> 123
        // "-042" -> -42
        // "-0642" -> -642

        int i = 0;
        int num = 0;

        int sign = 1; // default is positive, -1 for negative

        // 1. Ignore leading whitespace
        while (i < s.length() && s.charAt(i) == ' ') {
            i = i + 1;
        }

        // 2. Signedness
        if (i < s.length()) {

            if (s.charAt(i) == '-') {
                sign = -1;
                i = i + 1;

            } else if (s.charAt(i) == '+') {
                i = i + 1;
            }
        }

        // 3. Conversion
        while (i < s.length() && isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // 4. Rounding / Overflow handling

            // Positive overflow
            if (num == Integer.MAX_VALUE / 10) {

                if (sign == 1) {
                    if (digit >= 7) {
                        return Integer.MAX_VALUE;
                    }

                } else if (sign == -1) {

                    if (digit >= 8) {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            // Overflow before multiplication
            if (num > Integer.MAX_VALUE / 10) {

                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            num = num * 10 + digit;
            i = i + 1;
        }

        return sign * num;
    }
}