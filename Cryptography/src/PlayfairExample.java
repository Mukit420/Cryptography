import java.util.LinkedList;
import java.util.Scanner;

public class PlayfairExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Character> in = new LinkedList<>();
		LinkedList<Character> in1 = new LinkedList<>();
		LinkedList<Character> in2 = new LinkedList<>();
		System.out.println("Enter the key for playfair---->");
		String Keytext = sc.next();
		for (int i = 0; i < Keytext.length(); i++) { // (1)--->Start removing duplicate character from key
			char c = Keytext.charAt(i);
			in.add(c);
		}

		for (int i = 0; i < in.size(); i++) {
			char c = in.get(i);
			for (int j = i + 1; j < in.size(); j++) {
				if (c == in.get(j)) {
					in.remove(j);
					i = -1;
				}
			}

		}
		String fKeytext = "";
		for (int i = 0; i < in.size(); i++) {
			char c = in.get(i);
			fKeytext += c;
		}
		System.out.println(fKeytext);// (2)------>End of the process for removing duplicate character from key

		System.out.println("Enter the plaintext for cipher---->");
		String plaintext = sc.next();
		
		
		
		for (int i = 0; i < plaintext.length(); i++) { 
			char c = plaintext.charAt(i);
			in1.add(c);
		}
		
		// --------->Start processing for digraph creation<-------------\\
		
		
		for (int i = 0; i < in1.size() - 2; i += 2) {
			char c = in1.get(i);
			char c1 = in1.get(i + 1);
			if (c == c1) {
				in1.add(i + 1, 'x');
				i = 0;
			}
		}
		if (in1.size() % 2 != 0) {
			in1.add(in1.size(), 'x');
		}
		String fplaintext = "";
		for (int i = 0; i < in1.size(); i++) {
			char c = in1.get(i);
			fplaintext += c;
		}
		System.out.println("Digraph plain text---->"+fplaintext);// End of processing of digraph creation

		// ---------->Start creating matrix key<-----------

		String alpha = fKeytext + "abcdefghijklmnopqrstuvwxy";

		for (int i = 0; i < alpha.length(); i++) { // (1)--->Start removing duplicate character from keyMatrix
			char c = alpha.charAt(i);
			in2.add(c);
		}

		for (int i = 0; i < in2.size(); i++) {
			char c = in2.get(i);
			for (int j = i + 1; j < in2.size(); j++) {
				if (c == in2.get(j)) {
					in2.remove(j);
					i = -1;
				}
			}

		}
		String f1Keytext = "";
		for (int i = 0; i < in2.size(); i++) {
			char c = in2.get(i);
			f1Keytext += c;
		}
		System.out.println("keytext for matrix------>"+f1Keytext);// (2)------>End of the process for removing duplicate character from keyMatrix

		int count = 0;
		char[][] c = new char[5][5];
		for (int i = 0; i < 5; i++) {
			int l = i + count;
			for (int j = 0; j < 5; j++) {
				c[i][j] = f1Keytext.charAt(j + l);// 5*5 key matrix
				System.out.print(" " + c[i][j]);
				count++;
			}
			count = count - 1;
			System.out.println();
		}

		// ---------------->Start encryption process<-----------------\\

		String encryptedText = "";
		for (int i = 0; i < fplaintext.length() - 1; i += 2) {
			int first = f1Keytext.indexOf(fplaintext.charAt(i));
			int second = f1Keytext.indexOf(fplaintext.charAt(i + 1));
			int r1 = first / 5;
			int r2 = second / 5;
			int col1 = first % 5;
			int col2 = second % 5;
			if (r1 == r2) {
				encryptedText += c[r1][(col1 + 1) % 5];
				encryptedText += c[r2][(col2 + 1) % 5];
			} else if (col1 == col2) {
				encryptedText += c[(r1 + 1) % 5][col1];
				encryptedText += c[(r2 + 1) % 5][col2];
			} else {

				encryptedText += c[r1][col2];
				encryptedText += c[r2][col1];
			}
		}
		System.out.println("Encrypted text is---->" + encryptedText.toUpperCase());

		// ------->Start decryption process<-------\\

		String decryptedText = "";
		for (int i = 0; i < fplaintext.length() - 1; i += 2) {
			int first = f1Keytext.indexOf(encryptedText.charAt(i));
			int second = f1Keytext.indexOf(encryptedText.charAt(i + 1));
			int r1 = first / 5;
			int r2 = second / 5;
			int col1 = first % 5;
			int col2 = second % 5;
			if (r1 == r2) {
				if ((col1 - 1) < 0) {
					col1 = 5;
				}
				if ((col2 - 1) < 0) {
					col2 = 5;
				}
				decryptedText += c[r1][(col1 - 1) % 5];
				decryptedText += c[r2][(col2 - 1) % 5];
			} else if (col1 == col2) {

				if ((r1 - 1) < 0) {
					r1 = 5;
				}
				if ((r2 - 1) < 0) {
					r2 = 5;
				}
				decryptedText += c[(r1 - 1) % 5][col1];
				decryptedText += c[(r2 - 1) % 5][col2];
			} else {

				decryptedText += c[r1][col2];
				decryptedText += c[r2][col1];
			}
		}
		System.out.println("Decrypted text is---->" + decryptedText.toUpperCase());

	}

}
