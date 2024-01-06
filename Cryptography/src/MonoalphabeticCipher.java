import java.util.Scanner;

public class MonoalphabeticCipher {
	public static void main(String[] args) {

		String alpha =  "abcdefghijklmnopqrstuvwxyz";
		String Malpha = "qrstuvwxyzkmlonpabcdefghij";
		System.out.print("Enter the plain text---->");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		String enstr = "";
		for (int i = 0; i < str.length(); i++) {

			int pos = alpha.indexOf(str.charAt(i));
			char c = Malpha.charAt(pos);
			enstr += c;

		}
		System.out.println("Encrypted text is--->" + enstr);

		// Decryption proces start here

		String destr = "";
		for (int i = 0; i < enstr.length(); i++) {
			int pos = Malpha.indexOf(enstr.charAt(i));
			char c = alpha.charAt(pos);
			destr += c;
		}
		System.out.println("Decrypted String--->" + destr);

	}

}