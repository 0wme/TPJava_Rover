import java.util.HashMap;
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
        // ... ajouter les autres stratégies
    }

    public void move(char command) {
        MovementStrategy strategy = moveStrategies.get(direction);
        if (strategy != null) {
            if (command == 'f') {
                strategy.move(this);
            } else if (command == 'b') {
                reverseMovement(strategy);
            }
        }
        // Wrap et gestion des obstacles peuvent être ajoutés ici
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
    public void setDirection(char direction) { this.direction = direction; }
}