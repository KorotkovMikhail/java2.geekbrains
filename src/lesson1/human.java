package lesson1;

public class human implements movement{
    public static int distance;
    public static int height;

    public human (int distance, int height) {
        this.distance = distance;
        this.height = height;
    }

    @Override
    public boolean movements(int type, int distance) {
        switch (type){
            case (1):if (distance>this.distance){
                System.out.println("Человек не справился с дистанцией " + distance);
                return false;
            } else {
                System.out.println("Человек пробежал дистанцию " + distance);
                return true;
            }
            case (2):if (distance>this.height){
                System.out.println("Человек не справился со стеной высотой " + distance);
                return false;
            } else {
                System.out.println("Человек перелез через стену высотой " + distance);
                return true;
            }
        }
        return false;
    }
}
