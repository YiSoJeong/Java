package hw05.inheritance;

public class Cone extends Circle{
	private double height;
	private double side;
	
	public Cone(String name, double r, double h) {
		super(name, r);
		this.height = h;
	}

	public String getClassName() {
		return "Cone";
	}
	
	public void setHeight(double h) {
		this.height = h;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setSide(double s) {
		this.side = s;
	}
	
	public double getSide() {
		return Math.sqrt(getRadius()*getRadius()+getHeight()*getHeight());
	}
	
	@Override
	public double getArea() {
		return (Math.PI * super.getRadius() * super.getRadius()) + (Math.PI * super.getRadius() * getSide());
	}
	
	public double getVolume() {
		return (Math.PI * super.getRadius() * super.getRadius() * getHeight())/3;
	}
	
	@Override
	public String toString() {
		return String.format("%s is a %s inherited from %s class.",
				super.getName(), getClassName(), super.getClassName());
	}
}