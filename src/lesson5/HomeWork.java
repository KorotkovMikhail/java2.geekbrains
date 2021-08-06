package lesson5;

public class HomeWork {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private static float[] arr = new float[size];

    public static void main(String[] args) {

        for (int i = 0; i < size; i++) arr[i] = 1;

        long oneTime = oneThread(arr);
        long twoTime = twoThread(arr);

        increase(oneTime, twoTime);
    }

    private static long oneThread(float[] arr) {
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long oneTime = System.currentTimeMillis() - start;

        System.out.printf("Время  вычислений при однопоточной  работе: %d%n", oneTime);
        return oneTime;
    }

    private static long twoThread(float[] arr) {
        float[] a = new float[h];
        float[] b = new float[h];

        long start = System.currentTimeMillis();

        System.arraycopy(arr, 0, a, 0, h);
        System.arraycopy(arr, h, b, 0, h);

        Flow f1 = new Flow("a", a);
        Flow f2 = new Flow("b", b);

        f1.start();
        f2.start();

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = f1.getArr();
        b = f2.getArr();

        System.arraycopy(a, 0, arr, 0, h);
        System.arraycopy(b, 0, arr, a.length, b.length);

        long twoTime = System.currentTimeMillis() - start;

        System.out.printf("Время  вычислений при двухпоточной  работе: %d%n", twoTime);

        return twoTime;
    }

       private static void increase(long singleTime, long multiTime) {
        double diff = ((double) singleTime / (double) multiTime) - 1;
        int increase = (int) (diff * 100);

        System.out.println("Прирост скорости в процентах: " + increase + "%");
    }
}
