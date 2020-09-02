package sbnz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vitamin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double A;
	private double B;
	private double C;
	private double D;
	private double E;
	
	public Vitamin(double a, double b, double c, double d, double e) {
		A = a;
		B = b;
		C = c;
		D = d;
		E = e;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getA() {
		return A;
	}
	public void setA(double a) {
		A = a;
	}
	public double getB() {
		return B;
	}
	public void setB(double b) {
		B = b;
	}
	public double getC() {
		return C;
	}
	public void setC(double c) {
		C = c;
	}
	public double getD() {
		return D;
	}
	public void setD(double d) {
		D = d;
	}
	public double getE() {
		return E;
	}
	public void setE(double e) {
		E = e;
	}
}
