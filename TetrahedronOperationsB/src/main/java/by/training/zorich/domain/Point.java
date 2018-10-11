package by.training.zorich.domain;

import java.io.Serializable;

public class Point implements Serializable {
	private static final long serialVersionUID = -2843316508374402270L;

	private double coordinateX;
	private double coordinateY;
	private double coordinateZ;

	public Point() {
	}

	public Point(double[] coordinates) {
		coordinateX = coordinates[0];
		coordinateY = coordinates[1];
		coordinateZ = coordinates[2];
	}

	public Point(double coordinateX, double coordinateY, double coordinateZ) {
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.coordinateZ = coordinateZ;
	}

	public double getCoordinateX() {
		return coordinateX;
	}

	public void setCoordinateX(double coordinateX) {
		this.coordinateX = coordinateX;
	}

	public double getCoordinateY() {
		return coordinateY;
	}

	public void setCoordinateY(double coordinateY) {
		this.coordinateY = coordinateY;
	}

	public double getCoordinateZ() {
		return coordinateZ;
	}

	public void setCoordinateZ(double coordinateZ) {
		this.coordinateZ = coordinateZ;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Point point = (Point) o;

		if (Double.compare(point.coordinateX, coordinateX) != 0) {
			return false;
		}
		if (Double.compare(point.coordinateY, coordinateY) != 0) {
			return false;
		}

		return Double.compare(point.coordinateZ, coordinateZ) == 0;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;

		temp = Double.doubleToLongBits(coordinateX);
		result = (int) (temp ^ (temp >>> 32));

		temp = Double.doubleToLongBits(coordinateY);
		result = 31 * result + (int) (temp ^ (temp >>> 32));

		temp = Double.doubleToLongBits(coordinateZ);
		result = 31 * result + (int) (temp ^ (temp >>> 32));

		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + "{" + "coordinateX=" + coordinateX + ", coordinateY=" + coordinateY + ", coordinateZ=" + coordinateZ + '}';
	}
}
