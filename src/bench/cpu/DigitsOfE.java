package bench.cpu;

import bench.IBenchmark;

public class DigitsOfE implements IBenchmark {
    private int digits_requested;
    private int[] digits;
    private int quotient;

    public DigitsOfE(int req){
        this.digits_requested = req;
    }

    // Allocate digits[]
    @Override
    public void initialize(Object... params) {
        digits = new int[digits_requested + 1];

        // fill each digit with a 1
        for (int i=0; i < digits.length; i++)
            digits[i] = 1;
        digits[0] = 2;
    }

    @Override
    public void warmUp() {

    }


    // Produce digits
    @Override
    public String run() {
        String toDisplay = "";
        for(int i=0; i< digits.length-1; i++) {
            for(int j=0; j< digits.length; j++)
                digits[j] *= 10;
            for(int j=digits.length-1; j>=1; j--){
                quotient = digits[j] / (j+1);
                digits[j] %= (j+1);
                digits[j-1] += quotient;
            }
            quotient = digits[0];
            digits[0] %= 1;
            if(i==0) {
                toDisplay += String.valueOf(quotient/10);
                toDisplay += ".";
                toDisplay += String.valueOf(quotient%10);
            }
            else
            toDisplay += String.valueOf(quotient);


        }
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