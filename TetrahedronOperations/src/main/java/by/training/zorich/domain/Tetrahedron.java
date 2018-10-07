package by.training.zorich.domain;

import java.io.Serializable;
import java.util.List;

public class Tetrahedron implements Serializable, Polyhedron {
	private static final long serialVersionUID = -2188739546336276763L;

	private Point vertexA;
	private Point vertexB;
	private Point vertexC;
	private Point vertexD;

	public Tetrahedron() {
	}

	public Tetrahedron(double[][] vertexes) {
		vertexA = new Point(vertexes[0]);
		vertexB = new Point(vertexes[1]);
		vertexC = new Point(vertexes[2]);
		vertexD = new Point(vertexes[3]);
	}

	public Tetrahedron(Point vertexA, Point vertexB, Point vertexC, Point vertexD) {
		this.vertexA = vertexA;
		this.vertexB = vertexB;
		this.vertexC = vertexC;
		this.vertexD = vertexD;
	}

	public Point getVertexA() {
		return vertexA;
	}

	public void setVertexA(Point vertexA) {
		this.vertexA = vertexA;
	}

	public Point getVertexB() {
		return vertexB;
	}

	public void setVertexB(Point vertexB) {
		this.vertexB = vertexB;
	}

	public Point getVertexC() {
		return vertexC;
	}

	public void setVertexC(Point vertexC) {
		this.vertexC = vertexC;
	}

	public Point getVertexD() {
		return vertexD;
	}

	public void setVertexD(Point vertexD) {
		this.vertexD = vertexD;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Tetrahedron that = (Tetrahedron) o;

		if (vertexA != null ? !vertexA.equals(that.vertexA) : that.vertexA != null) {
			return false;
		}
		if (vertexB != null ? !vertexB.equals(that.vertexB) : that.vertexB != null) {
			return false;
		}
		if (vertexC != null ? !vertexC.equals(that.vertexC) : that.vertexC != null) {
			return false;
		}
		return vertexD != null ? vertexD.equals(that.vertexD) : that.vertexD == null;
	}

	@Override
	public int hashCode() {
		int result = vertexA != null ? vertexA.hashCode() : 0;
		result = 31 * result + (vertexB != null ? vertexB.hashCode() : 0);
		result = 31 * result + (vertexC != null ? vertexC.hashCode() : 0);
		result = 31 * result + (vertexD != null ? vertexD.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return getClass().getName() + "{" + "vertexA=" + vertexA + ", vertexB=" + vertexB + ", vertexC=" + vertexC + ", vertexD=" + vertexD + '}';
	}
}
