import java.util.LinkedList;
import java.util.Scanner;

public class Hill_cipher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the message--->");
		String text = sc.next();
		if (text.length() % 2 != 0) {
			text += "x";
		}
		// System.out.println(text);//if text length is odd number
		System.out.println("Enter the key values---->");
		int[][] key = new int[2][2];
		int i, j, k, l, sum = 0;
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 2; j++) {
				key[i][j] = sc.nextInt();
			}
		}
		// int key[][] = { { 3, 3 }, { 2, 5 } };
		String alpha = "";
		for (char c = 'a'; c <= 'z'; c++) {
			alpha += c;
		}

		LinkedList<Integer> input = new LinkedList<>();

		for (i = 0; i < text.length(); i += 2) { // multiplication text index with key
			l = i;
			for (j = 0; j < 2; j++) {
				for (k = 0; k < 2; k++) {
					sum = key[j][k] * alpha.indexOf(text.charAt(l + k));
					input.add(sum);// multiply value put in a linked list
				}
			}

		}
		// System.out.println(input);
		int[] ara = new int[input.size() / 2];// summation of two after two values of linked list put in a array
		String cipher_text = "";
		for (i = 0; i < input.size(); i += 2) {
			for (j = 0; j < 1; j++) {
				ara[j] = input.get(i) + input.get(i + 1);

				if (ara[j] < 0) {
					ara[j] += 26;
				}
				System.out.print(" " + ara[j]);
				char c = alpha.charAt(ara[j] % 26);// find char from the value of array index value

				cipher_text += c;// char put in a string
			}
		}
		System.out.println();
		System.out.print("cipher text is--->" + cipher_text);

		// inverse process of key

		int det_of_key = ((key[0][0] * key[1][1]) - (key[0][1] * key[1][0]))%26;
		if (det_of_key < 0) {
			det_of_key +=26;
		}
		System.out.println();
		System.out.println(det_of_key);
		int count = 0;

		for (i = 1; i < 26; i++) {
			if ((i * det_of_key) % 26 == 1) {
				count = i;
				break;
			}
		}

		// modules of inverse key

		System.out.println();
		System.out.println(count);

		int a = key[0][0], b = key[1][1], c = key[0][1], d = key[1][0], temp;
		int c2 = -c;
		int d2 = -d;
		temp = a;
		a = b;
		b = temp;
		int inversekey[][] = { { a, c2 }, { d2, b } };
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 2; j++) {
				System.out.print(" " + inversekey[i][j]);// end of inverse process
			}
			System.out.println();
		}

		// print the inverse key
		for (i = 0; i < 2; i++) {
			for (j = 0; j < 2; j++) {
				if (inversekey[i][j] < 0) {
					inversekey[i][j] += 26;
				}
				inversekey[i][j] = inversekey[i][j] * count;
				System.out.print(" " + inversekey[i][j]);
			}
			System.out.println();
		}

		// Start deciphering process

		LinkedList<Integer> input1 = new LinkedList<>();
		int sum1 = 0;
		for (i = 0; i < cipher_text.length(); i += 2) {
			l = i;
			for (j = 0; j < 2; j++) {
				for (k = 0; k < 2; k++) {
					sum1 = inversekey[j][k] * alpha.indexOf(cipher_text.charAt(l + k));
					input1.add(sum1);
				}
			}

		}
		int[] ara1 = new int[input1.size() / 2];
		String decipher_text = "";
		for (i = 0; i < input1.size(); i += 2) {
			for (j = 0; j < 1; j++) {
				ara1[j] = input1.get(i) + input1.get(i + 1);
				System.out.print(" " + ara1[j]);
				char c1 = alpha.charAt(ara1[j] % 26);

				decipher_text += c1;
			}
		}
		System.out.println();
		System.out.print("decipher text is--->" + decipher_text);

	}
}
