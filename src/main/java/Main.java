public class Main {
    public static void main(String[] args) {
        Rover rover = new Rover(0, 0, 'N');

        String commands = "ffrf";

        for (char command : commands.toCharArray()) {
            rover.move(command);
            System.out.println("Le rover se déplace à la position : x=" + rover.getX() + ", y=" + rover.getY() + " face à " + rover.getDirection());
        }
    }
}
