package br.unicamp.ic.mc322.teste1;

public class Position {
	private int x;
	private int y;
	
	public Position(int theX, int theY) {
		x = theX;
		y = theY;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public double getDistance(Position position) {
		int positionX = position.getX();
		int positionY = position.getY();
		double euclideanDistance = Math.sqrt( (Math.pow(this.x - positionX, 2)) + (Math.pow(this.y - positionY, 2)));
		return euclideanDistance;
	}
	
}
