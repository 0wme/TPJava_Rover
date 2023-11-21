import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        moveStrategies.put('S', new MoveSouth());
        moveStrategies.put('E', new MoveEast());
        moveStrategies.put('W', new MoveWest());
    }

    public void move(char command) {
        MovementStrategy strategy = moveStrategies.get(direction);
        if (strategy != null) {
            if (command == 'f') {
                strategy.move(this);
            } else if (command == 'b') {
                reverseMovement(strategy);
            } else if (command == 'l') {
                turn(command);
            } else if (command == 'r') {
                turn(command);
            }

        }
        // Wrap et gestion des obstacles peuvent être ajoutés ici
    }
    public void turn(char turnCommand) {
        int directionsCount = moveStrategies.size();
        List<Character> directions = new ArrayList<>(moveStrategies.keySet());

        int currentDirectionIndex = directions.indexOf(direction);
        if (turnCommand == 'l') {
            // Tourner à gauche signifie prendre la direction précédente dans la liste
            currentDirectionIndex = (currentDirectionIndex - 1 + directionsCount) % directionsCount;
        } else if (turnCommand == 'r') {
            // Tourner à droite signifie prendre la direction suivante dans la liste
            currentDirectionIndex = (currentDirectionIndex + 1) % directionsCount;
        }
        direction = directions.get(currentDirectionIndex);
    }



    private void reverseMovement(MovementStrategy strategy) {
        // Inverser le mouvement en ajustant la stratégie de mouvement
        // Cela pourrait être implémenté en inversant les coordonnées ou en utilisant une autre stratégie
    }

    // Getters et setters pour x et y
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
    public char getDirection() { return direction; }


}