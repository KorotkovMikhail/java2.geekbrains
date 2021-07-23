package lesson1;

public class cat implements movement{
    public static int distance;
    public static int height;

    public cat (int distance, int height) {
        this.distance = distance;
        this.height = height;
    }

    @Override
    public boolean movements(int type, int distance) {
        switch (type){
            case (1):if (distance>this.distance){
                System.out.println("Кот не смог пробежать дистанцию " + distance);
                return false;
            } else {
                System.out.println("Кот пробежал дистанцию " + distance);
                return true;
            }
            case (2):if (distance>this.height){
                System.out.println("Кот не осилил стену высотой " + distance);
                return false;
            } else {
                System.out.println("Кот перебрался через стену высотой " + distance);
                return true;
            }
        }
        return false;
    }
}
