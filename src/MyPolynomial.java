import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyPolynomial {
	private double[] coeffs;
	private String s = "";

	public MyPolynomial(double... coeffs) {
		this.coeffs = coeffs;
	}

	public MyPolynomial(String filename) {
		Scanner in = null;
		try {
			in = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int degree = in.nextInt();
		coeffs = new double[degree + 1];
		for (int i = 0; i < coeffs.length; ++i) {
			coeffs[i] = in.nextDouble();
		}
	}

	public int getDegree() {
		return coeffs.length - 1;
	}

	@Override

	public String toString() {
		
		for (int i = coeffs.length - 1; i >= 1; i--) {
			if (coeffs[0] != 0.0) {
				if (i == 1) {
					s = s + coeffs[i] + "x" + "+";
				}else {
					s = s + coeffs[i] + "x^" + i + "+";
				}
		
			}

		}
		if (coeffs[0] != 0.0) {
			s += coeffs[0];

		}
		return s;
	}
	
	public double evaluate(double x) {
		double result = 0d;
		for(int i = 0; i< coeffs.length; i++) {
			result += coeffs[i]*Math.pow(x, i);
		}
		return result;
			
		
		
	}
	
	public MyPolynomial add(MyPolynomial p2) {
		
		int newDegree =Math.max(getDegree(),  p2.getDegree());
		double[] coeffsResult = new double[newDegree +1];
		double[] coeffsBiggest;
		double[] coeffsSmallest;
		if(getDegree() < p2.getDegree()) {
			coeffsBiggest = coeffs;
			coeffsSmallest = p2.getCoeffs();
		}

}
