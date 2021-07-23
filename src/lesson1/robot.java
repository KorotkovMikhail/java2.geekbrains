package lesson1;

public class robot implements movement{
    public static int distance;
    public static int height;

    public robot (int distance, int height) {
        this.distance = distance;
        this.height = height;
    }

    @Override
    public boolean movements(int type, int distance) {
        switch (type){
            case (1):if (distance>this.distance){
                System.out.println("Робот не преодолел дистанцию " + distance);
                return false;
            } else {
                System.out.println("робот преодолел дистанцию " + distance);
                return true;
            }
            case (2):if (distance>this.height){
                System.out.println("Робот не осилил стену высотой " + distance);
                return false;
            } else {
                System.out.println("Робот перебрался через стену высотой " + distance);
                return true;
            }
        }
        return false;
    }
}
