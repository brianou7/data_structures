package algebra;

public class Main {

	public static void main(String[] args) {
		int vectorA[] = new int[] {4, 4, 0, -3, 0, -20};
		int vectorB[] = new int[] {3, 2, 3, 0, -10};
		
		PolinomialF1 example = new PolinomialF1(vectorA, vectorB);
		printVector(vectorA);
		printVector(vectorB);
		
		System.out.println("\nSum: ");
		printVector(example.sum());
	}
	
	public static void printVector(int[] vector) {
		System.out.print("\n[");
		
		for (int i = 0; i < vector.length; i++) {
			if (i != vector.length - 1) {
				System.out.print(vector[i] + ", ");
			} else {
				System.out.print(vector[i]);
			}
		}
		
		System.out.print("]");
	}

}
