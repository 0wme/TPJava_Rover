import java.util.*;

// Classe Rover avec patterns Command et Strategy
public class Rover {
    private int x;
    private int y;
    private char direction;
    private Map<Character, MovementStrategy> moveStrategies;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        moveStrategies = new HashMap<>();
        moveStrategies.put('N', new MoveNorth());
        moveStrategies.put('E', new MoveEast());
        moveStrategies.put('S', new MoveSouth());
        moveStrategies.put('W', new MoveWest());
    }

    public void move(char command) {
        MovementStrategy strategy = moveStrategies.get(direction);
        if (strategy != null) {
            if (command == 'f') {
                strategy.move(this);
            } else if (command == 'b') {
                reverseMovement(strategy);
            }
            if (command == 'l' || command == 'r') {
                turn(command);
            }
        }
        // Wrap et gestion des obstacles peuvent être ajoutés ici
    }
    public void turn(char turnCommand) {
        // On s'assure que l'ordre des directions est N, E, S, W pour un cycle complet
        List<Character> directions = new ArrayList<>(Arrays.asList('N', 'E', 'S', 'W'));

        int currentDirectionIndex = directions.indexOf(direction);
        if (turnCommand == 'l') {
            // Tourner à gauche signifie prendre la direction précédente dans la liste
            currentDirectionIndex = (currentDirectionIndex - 1 + directions.size()) % directions.size();
        } else if (turnCommand == 'r') {
            // Tourner à droite signifie prendre la direction suivante dans la liste
            currentDirectionIndex = (currentDirectionIndex + 1) % directions.size();
        }
        direction = directions.get(currentDirectionIndex);
    }




    private void reverseMovement(MovementStrategy strategy) {
        // Déterminez la direction opposée pour le mouvement inverse
        char reverseDirection;
        switch (this.direction) {
            case 'N':
                reverseDirection = 'S';
                break;
            case 'S':
                reverseDirection = 'N';
                break;
            case 'E':
                reverseDirection = 'W';
                break;
            case 'W':
                reverseDirection = 'E';
                break;
            default:
                throw new IllegalStateException("Direction inconnue: " + this.direction);
        }

        // Mise à jour de la direction avant d'utiliser la stratégie
        direction = reverseDirection;
        this.moveStrategies.get(reverseDirection).move(this);

        // Retour à la direction originale après le mouvement
        direction = this.direction;
    }


    // Getters et setters pour x et y
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public char getDirection() { return direction; }


}