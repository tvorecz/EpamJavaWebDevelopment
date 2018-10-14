package by.training.zorich.domain;

import java.io.Serializable;

public class TetraheronCharacteristic implements Serializable{
	private double volume;
	private double square;
	private double perimeter;

	public TetraheronCharacteristic() {
	}

	public TetraheronCharacteristic(double volume, double square, double perimeter) {
		this.volume = volume;
		this.square = square;
		this.perimeter = perimeter;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}

	public double getPerimeter() {
		return perimeter;
	}

	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TetraheronCharacteristic that = (TetraheronCharacteristic) o;

		if (Double.compare(that.volume, volume) != 0) {
			return false;
		}
		if (Double.compare(that.square, square) != 0) {
			return false;
		}
		return Double.compare(that.perimeter, perimeter) == 0;
	}

	@Override
	public int hashCode() {
		int result;
		long temp;

		temp = Double.doubleToLongBits(volume);
		result = (int) (temp ^ (temp >>> 32));

		temp = Double.doubleToLongBits(square);
		result = 31 * result + (int) (temp ^ (temp >>> 32));

		temp = Double.doubleToLongBits(perimeter);
		result = 31 * result + (int) (temp ^ (temp >>> 32));

		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + "{" + "volume=" + volume + ", square=" + square + ", perimeter=" + perimeter + '}';
	}
}
