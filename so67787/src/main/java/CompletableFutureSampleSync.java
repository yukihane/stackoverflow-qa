public class CompletableFutureSampleSync {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

              Integer i1 = 1 * 100 * 35 * 42 * 75;
              Integer i2 = 2 * 100 * 35 * 42 * 75;
        
              System.out.println("cf :" + i1 + ", cf2 : " + i2);
              System.out.println("result : " + (i1 + i2));

        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");

    }
}

