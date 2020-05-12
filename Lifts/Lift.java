import java.util.LinkedList;
import java.util.Queue;

public class Lift extends Thread {

    private int floor, maxFloor, direction, currentDirection, destonyFloor;
    private boolean exit;
    private int[] floorsUp, floorsDown;

    public Lift (int maxFloor){
        exit = false;
        floor = 1;
        this.maxFloor = maxFloor;
        currentDirection = 0;
        floorsUp = new int[maxFloor];
        floorsDown = new int[maxFloor];
        for (int i = 0; i < maxFloor; i++) {
            floorsUp[i] = 0;
            floorsDown[i] = 0;
        }
        //moving();
    }

    public void exit() {
            exit = true;
    }

    public int getDirection() {
        return direction;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor, int direction){
        destonyFloor = floor;
        if (direction == 1) {
            floorsUp[floor-1] = 1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        else if (direction == -1){
            floorsDown[floor - 1] = -1;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        this.direction = direction;

    }

    private boolean free() {
        for (int i = 0; i<maxFloor; i++) {
            if (floorsUp[i] != 0 || floorsDown[i] != 0)
                return false;
        }
        return true;
    }

    public void moving() throws InterruptedException {

        while (true) {
            if (!free()) {
                Thread.sleep(1500);
                if (destonyFloor < floor) {
                    floor--;
                }
                else if (destonyFloor > floor){
                    floor++;
                }
                else {
                    Thread.sleep(2000);
                    floorsDown[floor - 1] = 0;
                    floorsUp[floor - 1] = 0;
                    System.out.println(floor + "\n");

                    if (direction == 1) {
                        destonyFloor = 1;
                        floorsUp[0] = 1;
                    }

                    if (direction == -1) {
                        destonyFloor = -11;
                        floorsDown[0] = 1;
                    }
                }
                if (floor >= 5) {
                    currentDirection = -1;
                    floor = 5;
                }
                if (floor <= 1) {
                    currentDirection = 1;
                    floor = 1;
                }
            }
            else {
                currentDirection = 0;
            }
            if (exit) {
                break;
            }
        }

    }

    @Override
    public void run() {
        while (true) {
            try {
                this.moving();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


