class Solution {
    public int myAtoi(String s) {
        
        int i = 0;
        int n = s.length();
        int sign = 1;
        long result = 0;  // Use long to safely detect overflow

        // 1) Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2) Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3) Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // 4) Check Overflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int) result * sign;
    }
}