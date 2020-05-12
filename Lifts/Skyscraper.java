
public class Skyscraper{

    private int[] floors;
    private Lift[] lifts;
    private int numberLifts, maxFloor;
    private char[][] map;

    public Skyscraper (int maxFloor, int numberLifts) {
        floors = new int[maxFloor];
        lifts = new Lift[numberLifts];
        for (int i = 0; i<numberLifts; i++) {
            lifts[i] = new Lift(maxFloor);
            lifts[i].start();
        }
        map = new char[(maxFloor+1)][(numberLifts*3+2)];
        this.numberLifts = numberLifts;
        this.maxFloor = maxFloor;
        for (int i = 0; i < maxFloor; i++){
            map[i][0] = (char) (maxFloor - i+48);
            for (int j = 1; j < numberLifts*3+1; j++) {
                map[i][j] = '[';
                map[i][++j] = ' ';
                map[i][++j] = ']';
            }
            map[i][numberLifts*3+1] = '\n';
        }
        map[maxFloor][0] = ' ';
        for (int j = 1, k = 0; j < numberLifts+1; j++) {
            map[maxFloor][++k] = 'L';
            map[maxFloor][++k] = (char) (j+48);
            map[maxFloor][++k] = ' ';
        }
    }

    public void callLift (int floor, int direction){
        int n = choiseLift(floor, direction);
        lifts[n].setFloor(floor, direction);
    }

    private int choiseLift(int floor, int direction) {
        int n = -1, dist, shortestDist = -1, nextFloor;
        boolean flag = true;
        for (int i = 0; i<numberLifts; i++) {
            if (lifts[i].getDirection() == direction || lifts[i].getDirection() == 0) {
                nextFloor = lifts[i].getFloor();
                if (lifts[i].getDirection() == 0) {
                    dist = Math.abs(floor - nextFloor);
                }
                else {
                    dist = nextFloor - floor;
                }

                if (lifts[i].getDirection() == 0) {
                    n = i;
                    break;
                }

                if (dist == 0) {
                    n = i;
                    break;
                }
                else if (dist < 0 && direction == 1) {
                    if (shortestDist == -1 || shortestDist > dist ) {
                        shortestDist = dist;
                        n = i;
                        flag = false;
                    }
                }
                else if (flag && direction == -1) {
                    if (shortestDist == -1 || shortestDist > maxFloor*2 + floor - nextFloor - 2 ) {
                        shortestDist = maxFloor*2 + floor - nextFloor -2 ;
                        n = i;
                    }
                }
                else if (flag) {
                    if (shortestDist == -1 || shortestDist > maxFloor*2 - floor + nextFloor - 2 ) {
                        shortestDist = maxFloor*2 - floor + nextFloor - 2 ;
                        n = i;
                    }
                }
            }
            else {
                nextFloor = lifts[i].getFloor();
                if (direction == 1) {
                    dist = nextFloor + floor - 2;
                }
                else {
                    dist = maxFloor - nextFloor + floor - 1;
                }

                if (shortestDist == -1 || dist < shortestDist) {
                    shortestDist = dist;
                    n = i;
                }
            }
        }
        return n;
    }



    public String toString() {
        StringBuilder S = new StringBuilder();

        for (int i = 0; i < maxFloor+1; i++) {
            for (int j = 0; j < numberLifts*3+2; j++) {
                if (map[i][j] == '*') {
                    map[i][j] = ' ';
                }
            }
        }

        for (int j = 0, oldJ = 0; j < numberLifts; j++) {
            int currentFloor = lifts[j].getFloor();
            if (j == 0){
                map[maxFloor - currentFloor][j+2] = '*';
                oldJ = j + 2;
            }
            else {
                oldJ = oldJ+3;
                map[maxFloor - currentFloor][oldJ] = '*';
            }

        }

        for (int i = 0; i < maxFloor+1; i++) {
            for (int j = 0; j < numberLifts*3+2; j++) {
                S.append(map[i][j]);
            }
        }
        return S.toString();
    }


}
