public class ComplexNumber {

	double real;
	double imaginary;
	
  
	public ComplexNumber() {
		
		real = 0;
		imaginary = 0;
		
	}
	
	public ComplexNumber(double r, double i) {
		
		real = r;
		imaginary = i;
		
	}
	
	void addTo (ComplexNumber c) {
		
		real += c.real;
		
		imaginary += c.imaginary;
    
	}
	
	void subFrom (ComplexNumber c) {
		
		real -= c.real;
		
		imaginary -= c.imaginary;
		
	}
	
	void multBy (ComplexNumber c) {
		
		double swap = real;
		
		real = (real * c.real) + (-1 * imaginary * c.imaginary);
		
		imaginary = (swap * c.imaginary) + (c.real * imaginary);
		
	}
	
	void squareThisCN() {
		
		double swap = real;
		
		real = (real * real) + (-1 * imaginary * imaginary);
		
		imaginary = 2 * swap * imaginary;
		
	}
	
	ComplexNumber add (ComplexNumber c) {
		
		ComplexNumber myCN = new ComplexNumber();
		
		myCN.real = real + c.real;
		
		myCN.imaginary = imaginary + c.imaginary;
		
		return myCN;
	
	}
	
	ComplexNumber sub (ComplexNumber c) {
		
		ComplexNumber myCN = new ComplexNumber();
		
		myCN.real = real - c.real;
		
		myCN.imaginary = imaginary - c.imaginary;
		
		return myCN;
		
	}
	
	ComplexNumber mult (ComplexNumber c) {
		
		ComplexNumber myCN = new ComplexNumber();
		
		myCN.real = (real * c.real) + (-1 * imaginary * c.imaginary);
		
		myCN.imaginary = (real * c.imaginary) + (c.real * imaginary);
		
		return myCN;
		
	}
	
	ComplexNumber square() {
		
		ComplexNumber myCN = new ComplexNumber();
		
		myCN.real = (real * real) + (-1 * imaginary * imaginary);
		
		myCN.imaginary = 2 * real * imaginary;
		
		return myCN;
		
	}
	
	boolean equals (ComplexNumber c) {
		
		if (real == c.real && imaginary == c.imaginary) {
			
			return true;
			
		}
    
		else return false;
		
	}
	
	double modulus() {
		
		double x = Math.pow(real, 2) + Math.pow(imaginary, 2);
		
		double modulus = Math.sqrt(x);
		
		return modulus;
		
	}
	
	double modSquare() {

		double x = Math.pow(real, 2) + Math.pow(imaginary, 2);

		return x;

	}
	
	void display() {

		if (imaginary > 0) System.out.println(real + " + " + imaginary + "i");
		
		else System.out.println(real + " - " + Math.abs(imaginary) + "i");
	
	}
	
}
