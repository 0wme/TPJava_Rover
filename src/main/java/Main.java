public class Main {
    public static void main(String[] args) {
        // Initialisation du rover à la position (0,0) orienté vers le Nord ('N')
        Rover rover = new Rover(0, 0, 'N');

        // Ajouter des stratégies pour chaque direction
        rover.addStrategy('N', new MoveNorth());
        rover.addStrategy('S', new MoveSouth());
        rover.addStrategy('E', new MoveEast());
        rover.addStrategy('W', new MoveWest());

        // Supposons que c'est la commande envoyée pour le déplacement du rover
        String commands = "ffrfflbb";

        // Exécuter chaque commande
        for (char command : commands.toCharArray()) {
            rover.move(command);
            System.out.println("Le rover se déplace à la position : x=" + rover.getX() + ", y=" + rover.getY() + " face à " + rover.getDirection());
        }
    }
}
