package hw05.inheritance;

public class TestApp {

	public static void main(String[] args) {
		
		//create an object
		Cube cub1 = new Cube("myCube", 0.4);
		Sphere sph1 = new Sphere("mySphere", 0.3);
		Cone con1 = new Cone("myCone", 0.7, 1.2);
		
		// print the object properties
		System.out.println(cub1);
		System.out.printf("side = %.1f,\nsurface area = %.2f,\nvolume = %.3f.\n", 
				cub1.getSide(), cub1.getArea(), cub1.getVolume());
		
		System.out.println();

		System.out.println(sph1);
		System.out.printf("radius = %.1f,\nsurface area = %.3f,\nvolume = %.3f.\n", 
				sph1.getRadius(), sph1.getArea(), sph1.getVolume());
		
		System.out.println();
		
		System.out.println(con1);
		System.out.printf("height = %.1f,\nradius = %.1f,\nsurface area = %.3f,\nvolume = %.3f.\n", 
				con1.getHeight(), con1.getRadius(), con1.getArea(), con1.getVolume());
	}

}
