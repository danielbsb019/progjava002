package model;

public class Pais {
	private int id;
	private String nome;
	private long pop;
	private double area;

	public Pais() {
	}

	public Pais(int id, String nome, long pop, double area) {
		this.id = id;
		this.nome = nome;
		this.pop = pop;
		this.area = area;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getPop() {
		return pop;
	}

	public void setPop(long pop) {
		this.pop = pop;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

}