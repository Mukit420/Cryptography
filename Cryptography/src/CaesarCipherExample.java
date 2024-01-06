import java.util.Scanner;

public class CaesarCipherExample {
	public static String alpha = "abcdefghijklmnopqrstuvwxyz ";

	public static String encryption(String pltxt, int shift) {
		pltxt = pltxt.toLowerCase();
		String enstr = "";
		for (int i = 0; i < pltxt.length(); i++) {
			int pos = alpha.indexOf(pltxt.charAt(i));
			int shiftpos = (pos + shift) % 27;
			char enchar = alpha.charAt(shiftpos);
			enstr += enchar;
		}
		return enstr;

	}

	public static String decryption(String pltxt, int shift) {

		pltxt = pltxt.toLowerCase();
		String denstr = "";
		for (int i = 0; i < pltxt.length(); i++) {
			int dpos = alpha.indexOf(pltxt.charAt(i));
			int dshiftpos = (dpos - shift) % 27;
			if (dshiftpos < 0) {
				dshiftpos = dshiftpos + 27;
			}
			char denchar = alpha.charAt(dshiftpos);
			denstr += denchar;
		}
		return denstr;
	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Input plain text:");
		String pltxt = input.nextLine();
		System.out.println("Input Shift position:");
		int shift = input.nextInt();
		System.out.println("Encrypted text---->" + encryption(pltxt, shift));
		System.out.println("Dencrypted text---->" + decryption(encryption(pltxt, shift), shift));
	}

}