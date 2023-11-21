public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    public void move(char command) {
        if (command == 'f') {
            if (direction == 'N') y++;
            else if (direction == 'S') y--;
            else if (direction == 'E') x++;
            else if (direction == 'W') x--;
        } else if (command == 'b') {
            if (direction == 'N') y--;
            else if (direction == 'S') y++;
            else if (direction == 'E') x--;
            else if (direction == 'W') x++;
        } else if (command == 'l') {
            if (direction == 'N') direction = 'W';
            else if (direction == 'S') direction = 'E';
            else if (direction == 'E') direction = 'N';
            else if (direction == 'W') direction = 'S';
        } else if (command == 'r') {
            if (direction == 'N') direction = 'E';
            else if (direction == 'S') direction = 'W';
            else if (direction == 'E') direction = 'S';
            else if (direction == 'W') direction = 'N';
        }
    }

    public void turn(char command) {
        if (command == 'l') {
            // ... (changer la direction vers la gauche)
        } else if (command == 'r') {
            // ... (changer la direction vers la droite)
        }
    }


}
