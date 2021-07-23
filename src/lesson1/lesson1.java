package lesson1;

import java.util.Random;
import java.util.Scanner;

public class lesson1 {
    public static int rnd(int max, int min) {
        Random random = new Random();
        ++max;
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        Scanner scan;
        System.out.print("Сколько участников сегодня соревнуются? ");
        scan = new Scanner(System.in);
        int participants = scan.nextInt();
        System.out.print("Сколько препятствий сегодня проходим? ");
        scan = new Scanner(System.in);
        int obstacle = scan.nextInt();
        movement[] participant = new movement[participants];
        obstacle[] obstacles = new obstacle[obstacle];

        for (int i = 0; i < participants; i++) {
            int powerRun;
            int powerJump;
            int type = (int) (Math.random() * 3 + 1);
            switch (type) {
                case (1) -> {
                    powerRun = rnd(2000, 500);
                    powerJump = rnd(300, 50);
                    participant[i] = new human(powerRun, powerJump);
                }
                case (2) -> {
                    powerRun = rnd(500, 100);
                    powerJump = rnd(200, 100);
                    participant[i] = new cat(powerRun, powerJump);
                }
                case (3) -> {
                    powerRun = rnd(10000, 1000);
                    powerJump = rnd(500, 100);
                    participant[i] = new robot(powerRun, powerJump);
                }
            }
        }
        for (int i = 0; i < obstacle; i++) {
                int difficult;
                int type = rnd(2, 1);
            switch (type) {
                case (1) -> {
                    difficult = rnd(3000, 100);
                    obstacles[i] = new road(difficult);
                }
                case (2) -> {
                    difficult = rnd(600, 10);
                    obstacles[i] = new wall(difficult);
                }
            }
        }
        boolean result;
        for (int i = 0; i < participants; i++) {
            for (int j = 0; j < obstacle; j++) {
                if (obstacles[j] instanceof road) {
                    result = participant[i].movements(1, obstacles[j].getLength());
                } else {
                    result = participant[i].movements(2, obstacles[j].getLength());
                }
                if(!result) {break;}
            }
            System.out.println();
        }


    }



    }