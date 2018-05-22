
public class complexNumbers {
	
	/*define Complex class*/
	public static class Complex{
		
		private int realPart;
		private int imaginaryPart;
		
		/*
		 * constructor
		 */
		public Complex() {}
		
		public Complex(int realPart, int imaginaryPart) {
			this.realPart = realPart;
			this.imaginaryPart = imaginaryPart;
		}
		
		/*
		 * get and set
		 */
		public int getRealPart() {
			return realPart;
		}

		public void setRealPart(int realPart) {
			this.realPart = realPart;
		}

		public int getImaginaryPart() {
			return imaginaryPart;
		}

		public void setImaginaryPart(int imaginaryPart) {
			this.imaginaryPart = imaginaryPart;
		}
		
		/*
		 * add
		 */
		public Complex add(Complex a) {
			return new Complex(realPart+a.realPart,imaginaryPart+a.imaginaryPart);
		}
		
		public Complex add(int a) {
			return new Complex(realPart+a,imaginaryPart);
		}
		
		/*
		 * subtract
		 */
		public Complex subtract(Complex a) {
			return new Complex(realPart-a.realPart,imaginaryPart-a.imaginaryPart);
		}
		
		public Complex substract(int a) {
			return new Complex(realPart-a,imaginaryPart);
		}
		
		/*
		 * multiply
		 */
		public Complex multifly(Complex a) {
			return new Complex(realPart*a.realPart-imaginaryPart*a.imaginaryPart,realPart*a.imaginaryPart+imaginaryPart*a.realPart);
		}
		
		public Complex multifly(int a) {
			return new Complex(realPart*a,imaginaryPart*a);
		}
		
		/*
		 * absolute value
		 */
		public double calculateAbsolute(Complex a) {
			return Math.sqrt(a.realPart*a.realPart+a.imaginaryPart*a.imaginaryPart);
		}
		
		/*
		 * print
		 */
		public void print(Complex a) {
			
			if(a.getImaginaryPart()==0) {
				System.out.println(a.getRealPart());
			}
			else if(a.getImaginaryPart()<0) {
				System.out.println(a.getRealPart() + " - " + (-a.getImaginaryPart())+"i");
			}
			else {
				if(a.getImaginaryPart()==1) {
					System.out.println(a.getRealPart() + " + i");
				}
				else
				System.out.println(a.getRealPart() + " + " + (a.getImaginaryPart())+"i");
			}
			
		}
		
		
	}
	public static void main(String[] args) {

		Complex a = new Complex(1,2);
		Complex b = new Complex(3,-5);
		int integer = 3;
		
		Complex result = new Complex();
		
		System.out.print("First number is: ");
		a.print(a);
		
		System.out.print("Second number is: ");
		b.print(b);
		
		System.out.print("Absolute value of first number is: ");
		System.out.println(a.calculateAbsolute(a));
		
		System.out.print("Absolute value of Second number is: ");
		System.out.println(b.calculateAbsolute(b));
		
		System.out.print("Result of addition is: ");
		result = a.add(b);
		result.print(result);
		
		System.out.print("Result of subtraction is: ");
		result = a.subtract(b);
		result.print(result);
		
		System.out.print("Result of mutiplication is: ");
		result = a.multifly(b);
		result.print(result);
		
		System.out.print("\nFirst number is: ");
		a.print(a);
		
		System.out.print("Second number is: " + integer +"\n");
		
		System.out.print("Result of addition is: ");
		result = a.add(integer);
		result.print(result);
		
		System.out.print("Result of subtraction is: ");
		result = a.substract(integer);
		result.print(result);

		System.out.print("Result of mutiplication is: ");
		result = a.multifly(integer);
		result.print(result);

	}

}
