package bench.cpu;

import bench.IBenchmark;

public class DigitsOfPi implements IBenchmark {
    private int digits_requested;
    private int[] digits;
    private StringBuilder predigits = new StringBuilder();
    private String toDisplay = "";

    public DigitsOfPi(int req){
        this.digits_requested = req + 1;
    }

    // Allocate digits[]
    @Override
    public void initialize(Object... params) {
        digits = new int[10 * digits_requested / 3 + 1];

        // fill each digit with a 1
        for (int i=0; i < digits.length; i++)
            digits[i] = 2;
    }

    @Override
    public void warmUp() {

    }

    void flushDigits() {
        toDisplay += (predigits);
        predigits.setLength(0);
    }

    // given an integer 0..9, buffer a digit '0' .. '9'
    void addDigit(int digit) {
        predigits.append((char)('0' + digit));
    }


    // add one to each digit, rolling over from from 9 to 0
    void overflowDigits() {
        for (int i=0; i < predigits.length(); i++) {
            char digit = predigits.charAt(i);
            // This could be implemented with a modulo, but compared to the main
            // loop this code is too quick to measure.
            if (digit == '9') {
                predigits.setCharAt(i, '0');
            } else {
                predigits.setCharAt(i, (char)(digit + 1));
            }
        }
    }

    // Produce digits
    @Override
    public String run() {
        for(int i=0; i< digits_requested; i++){

            int carry = 0;
            for (int j=digits.length-1; j > 0; j--) {
                int numerator = j;
                int denomenator = j * 2 + 1;
                int tmp = digits[j] * 10 + carry;
                digits[j] = tmp % denomenator;
                carry = tmp / denomenator * numerator;
            }

            // process the last digit
            int tmp = digits[0] * 10 + carry;
            digits[0] = tmp % 10;
            int quotient = tmp / 10;

            // implement buffering and overflow
            if (quotient < 9) {
                flushDigits();
                // print a decimal after the leading "3"
                if (i == 1) toDisplay += ".";
                addDigit(quotient);
            } else if (quotient == 9) {
                addDigit(quotient);
            } else {
                overflowDigits();
                flushDigits();
                addDigit(0);
            }
            // System.out.flush();
        }
        flushDigits();
        System.out.println();
        return toDisplay;
    }

    @Override
    public void run(Object... options) {

    }


    @Override
    public void cancel() {

    }

    @Override
    public void clean() {

    }

    @Override
    public String getResult() {
        return null;
    }
}