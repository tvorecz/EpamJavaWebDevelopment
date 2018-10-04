package by.training.zorich.domain;

import java.io.Serializable;

public class CoordinatePlane implements Serializable {
	private static final long serialVersionUID = -7122451533916867426L;

	private Point pointA;
	private Point pointB;
	private Point pointC;

	public CoordinatePlane() {
	}

	public CoordinatePlane(Point pointA, Point pointB, Point pointC) {
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CoordinatePlane that = (CoordinatePlane) o;

		if (pointA != null ? !pointA.equals(that.pointA) : that.pointA != null) {
			return false;
		}
		if (pointB != null ? !pointB.equals(that.pointB) : that.pointB != null) {
			return false;
		}
		return pointC != null ? pointC.equals(that.pointC) : that.pointC == null;
	}

	@Override
	public int hashCode() {
		int result = pointA != null ? pointA.hashCode() : 0;

		result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
		result = 31 * result + (pointC != null ? pointC.hashCode() : 0);

		return result;
	}
}
