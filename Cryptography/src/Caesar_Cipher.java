import java.util.Scanner;

public class Caesar_Cipher {
	public static void main(String[] args) {

		String alpha = "";
		for (char c = 'a'; c <= 'z'; c++) {
			alpha += c;
		}

		System.out.print("Enter the plain text---->");
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println("Enter the shift key--->");
		int pos = sc.nextInt();
		String encrypted = "";
		for (int i = 0; i < str.length(); i++) {
			int pos1 = alpha.indexOf(str.charAt(i));
			char shift_char = alpha.charAt((pos1 + pos) % 26);
			encrypted += shift_char;
		}
		System.out.println("Encrypted message is---->" + encrypted);
		
		//Decryption process start here
		
		String Decrypted = "";
		for (int i = 0; i < encrypted.length(); i++) {
			int pos1 = alpha.indexOf(encrypted.charAt(i));
			if((pos1-pos)<0) {
				pos1=pos1+26;
			}
			char shift_char = alpha.charAt((pos1 - pos) % 26);
			
			Decrypted+= shift_char;
		}
		System.out.println("Decrypted message is---->" + Decrypted);

	}

}