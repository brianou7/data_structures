package algebra;

import util.Polinomial;

public class PolinomialF1 extends Polinomial {
	
	/*
	 * Example: 4x^3 + 5x^2 +2x + 3
	 * 
	 *  =>V[n] = [3, 4, 5, 2, 3, ...]
	 *  
	 *  V[0]: Polinomial grade (Max exponent)
	 *  Util positions: grade (V[0]) + 2
	 *  Exponent: grade (V[0]) + 2 - position (index)
	 *  Position: grade (V[0]) + 2 - exponent 
	 * 
	 * */
	
	private int vectorA[];
	private int vectorB[];

	public PolinomialF1(int vectorA[]) {
		this.vectorA = vectorA;
	}
	
	public PolinomialF1(int vectorA[], int vectorB[]) {
		this.vectorA = vectorA;
		this.vectorB = vectorB;
	}
	
	public PolinomialF1(String vectorA) {
		// Convert string to array <- from Polinomial
	}
	
	public PolinomialF1(String vectorA, String vectorB) {
		// Convert string to array <- from Polinomial
	}
	
	public boolean sum_validation() {
		if (this.vectorA.length == 0 && this.vectorB.length == 0) {
			System.out.println("Need two vectors to sum both!");
			return false;
		}
		
		return true;
	}
	
	private void assign_grade(int[] new_vector, int new_grade) {
		if (vectorA[0] > vectorB[0]) {
			new_vector[0] = vectorA[0] + new_grade;
		} else if (vectorA[0] < vectorB[0]) {
			new_vector[0] = vectorB[0] + new_grade;
		} else {
			new_vector[0] = vectorA[0] + new_grade;
		}
	}
	
	public int[] sum() {
		int vectorC[] = new int[7];
		int exponentC = 0;
		
		if (this.sum_validation()) {
			boolean reduce_exponent = true;
			int i = 1, j = 1, k = 1;
			int exponentA = 0, exponentB = 0;
			
			while ( i <= vectorA[0] + 1 && j <= vectorB[0] + 1) {
				exponentA = vectorA[0] + 2 - i;
				exponentB = vectorB[0] + 2 - j;
				
				if (exponentA > exponentB) {
					vectorC[k] = this.vectorA[i];
					i++; k++;
				} else if (exponentA < exponentB) {
					vectorC[k] = vectorB[j];
					j++; k++;
				} else {
					vectorC[k] = vectorA[i] + vectorB[j];
					i++; j++; k++;
					
					if (vectorC[k] == 0 && reduce_exponent) {
						exponentC--;
					} else {
						reduce_exponent = false;
					}
				}
			}
		}
		
		assign_grade(vectorC, exponentC);
		return vectorC;
		
	}

}
