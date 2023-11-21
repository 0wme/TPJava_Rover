class MoveNorth implements MovementStrategy {
    public void move(Rover rover) {
        rover.setY(rover.getY() + 1);
    }
}