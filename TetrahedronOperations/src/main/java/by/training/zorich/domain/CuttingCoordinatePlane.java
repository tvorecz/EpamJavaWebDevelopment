package by.training.zorich.domain;

import java.io.Serializable;

public class CuttingCoordinatePlane implements Serializable {
	private static final long serialVersionUID = -7122451533916867426L;

	private Point intersectionPointA;
	private Point intersectionPointB;
	private Point intersectionPointC;


	public CuttingCoordinatePlane() {
	}

	public CuttingCoordinatePlane(double[][] intersectionPoints) {
		intersectionPointA = new Point(intersectionPoints[0]);
		intersectionPointB = new Point(intersectionPoints[1]);
		intersectionPointC = new Point(intersectionPoints[2]);
	}

	public CuttingCoordinatePlane(Point intersectionPointA, Point intersectionPointB, Point intersectionPointC) {
		this.intersectionPointA = intersectionPointA;
		this.intersectionPointB = intersectionPointB;
		this.intersectionPointC = intersectionPointC;
	}

	public Point getIntersectionPointA() {
		return intersectionPointA;
	}

	public void setIntersectionPointA(Point intersectionPointA) {
		this.intersectionPointA = intersectionPointA;
	}

	public Point getIntersectionPointB() {
		return intersectionPointB;
	}

	public void setIntersectionPointB(Point intersectionPointB) {
		this.intersectionPointB = intersectionPointB;
	}

	public Point getIntersectionPointC() {
		return intersectionPointC;
	}

	public void setIntersectionPointC(Point intersectionPointC) {
		this.intersectionPointC = intersectionPointC;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		CuttingCoordinatePlane that = (CuttingCoordinatePlane) o;

		if (intersectionPointA != null ? !intersectionPointA.equals(that.intersectionPointA) : that.intersectionPointA != null) {
			return false;
		}
		if (intersectionPointB != null ? !intersectionPointB.equals(that.intersectionPointB) : that.intersectionPointB != null) {
			return false;
		}
		return intersectionPointC != null ? intersectionPointC.equals(that.intersectionPointC) : that.intersectionPointC == null;
	}

	@Override
	public int hashCode() {
		int result = intersectionPointA != null ? intersectionPointA.hashCode() : 0;

		result = 31 * result + (intersectionPointB != null ? intersectionPointB.hashCode() : 0);
		result = 31 * result + (intersectionPointC != null ? intersectionPointC.hashCode() : 0);

		return result;
	}
}
