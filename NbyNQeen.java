import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.Buffer;
class NbyNQueen {
	static int[] NbyNMatrix;
	public static void main(String args[]) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine().trim());
		if (n >= 4 && n <= 25) {
			NbyNMatrix=new int[n];
			placeNqueens(0, NbyNMatrix.length);
		} else
			pw.println("INVALID INPUT");
		pw.flush();
		pw.close();
	}
	public static boolean checkQueen(int r, int c) {
		for (int i = 0; i < r; i++) {
			if (NbyNMatrix[i] == c || (i - r) == (NbyNMatrix[i] - c)
					|| (i - r) == (c - NbyNMatrix[i])) {
				return false;
			}
		}
		return true;
	}
	public static void placeNqueens(int r, int n) {
		for (int c = 0; c < n; c++) {
			if (checkQueen(r, c)) {
				NbyNMatrix[r] = c;
				if (r == n - 1) {
					int N = NbyNMatrix.length;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < N; j++) {
							if (NbyNMatrix[j] == i) {
								System.out.print("("+(j+1)+","+(i+1)+")");
							} 
						}
					}
					System.exit(0);
				} else {
					placeNqueens(r + 1, n);
				}
			}
		}
	}
}
