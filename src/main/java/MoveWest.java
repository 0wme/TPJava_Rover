class MoveWest implements MovementStrategy {
    public void move(Rover rover) {
        rover.setX(rover.getX() - 1);
    }
}