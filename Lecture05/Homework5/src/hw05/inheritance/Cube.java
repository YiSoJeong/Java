package hw05.inheritance;

public class Cube extends Square{
	public Cube(String name, double side) {
		super(name, side);
	}
	
	public String getClassName(){
		return "Cube"; 
	}
	
	public void setSide(double side) {
		super.setSize(side, side);		
	}
	
	@Override
	public double getArea() {
		return 6*(super.getSide() * super.getSide()) ;
	}
	
	public double getVolume() {
		return super.getSide() * super.getSide() * super.getSide();
	}
	
	@Override
	public String toString() {
		return String.format("%s is a %s inherited from %s class.",
				super.getName(), getClassName(), super.getClassName());
	}
	
	
}
