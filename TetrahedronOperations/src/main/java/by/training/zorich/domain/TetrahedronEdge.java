package by.training.zorich.domain;

import java.io.Serializable;

public class TetrahedronEdge implements Serializable {
	private static final long serialVersionUID = -1110839590121075169L;
	private Point pointA;
	private Point pointB;

	public TetrahedronEdge() {
	}

	public TetrahedronEdge(double[][] points) {
		pointA = new Point(points[0]);
		pointB = new Point(points[1]);
	}

	public TetrahedronEdge(Point pointA, Point pointB) {
		this.pointA = pointA;
		this.pointB = pointB;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TetrahedronEdge that = (TetrahedronEdge) o;

		if (pointA != null ? !pointA.equals(that.pointA) : that.pointA != null) {
			return false;
		}
		return pointB != null ? pointB.equals(that.pointB) : that.pointB == null;
	}

	@Override
	public int hashCode() {
		int result = pointA != null ? pointA.hashCode() : 0;
		result = 31 * result + (pointB != null ? pointB.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + "{" + "pointA=" + pointA + ", pointB=" + pointB + '}';
	}
}
