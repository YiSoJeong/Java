package hw05.inheritance;

public class Sphere extends Circle{
	public Sphere(String name, double r) {
		super(name, r);
	}
	
	public String getClassName() {
		return "Sphere";
	}
	
	@Override
	public double getArea() {
		return 4 * Math.PI * super.getRadius() * super.getRadius();
	}
	
	public double getVolume() {
		return (4 * Math.PI * super.getRadius() * super.getRadius() * super.getRadius())/3;
	}
	
	@Override
	public String toString() {
		return String.format("%s is a %s inherited from %s class.",
				super.getName(), getClassName(), super.getClassName());
	}
}