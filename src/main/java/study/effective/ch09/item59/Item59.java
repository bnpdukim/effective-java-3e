package study.effective.ch09.item59;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class Item59 {
    public static void main(String[] args)  {

        int n = 2*(Integer.MAX_VALUE / 3);
        int low = 0;
        for(int i=0;i<100000;i++)
            if(random(n) < n/2)
                low++;
        log.info("{}",low);
    }

    static Random rnd = new Random();
    private static int random(int n) {
        return Math.abs(rnd.nextInt()) % n;
//        return rnd.nextInt(n);
    }
}
