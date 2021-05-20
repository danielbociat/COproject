package bench.cpu;

import bench.IBenchmark;
import java.lang.Math;
public class DigitsOfPhi implements IBenchmark{
    private int a=1000, b, c, d, n, k;
    private int[] digits;
    private int digits_requested;

    public DigitsOfPhi(int req){
        this.digits_requested = req;
    }

    @Override
    public void initialize(Object... params) {
        if(digits_requested % 3 == 0)
            n = digits_requested/3 + 1;
        else
            n = digits_requested/3 + 2;
        digits = new int[n*5];
        c = n*5;

        //initialize with 1 the array
        for(b = 0; b < c; b++) {
            digits[b] = 1;
        }
        digits[1]=6;
    }

    @Override
    public void warmUp() {

    }

    @Override
    public void run() {

        for(int i = 0; i != n; digits[0]=d%a,i++){
            for(d=0, k=c; --k != 0; d/=b, d *= 2 * k - 1){
                d+= a * digits[k];
                b=10*k;
                digits[k]=d%b;
            }
            d+=digits[0]*a;

            if(i == n-1 && digits_requested%3 != 0){
                int num = 1000;
                num = num / (int)Math.pow(10,(digits_requested%3));

                Integer digits = new Integer(digits_requested%3);

                String format = new String("%0" + String.valueOf(digits) + "d");

                System.out.format(format, d/a/num);

            }
            else{
                if(i == 0){
                    System.out.format("%d.", d/a);
                }
                else{
                    System.out.format("%03d", d/a);
                }
            }



            //printf("%.3d",d/a);
        }
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