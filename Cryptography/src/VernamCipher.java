import java.util.LinkedList;
import java.util.Scanner;

public class VernamCipher {

	public static void main(String[] args) {
		String alpha = "abcdefghijklmnopqrstuvwxyz";
		Scanner input = new Scanner(System.in);
		System.out.println("Enter plaintext--->");
		String plain = input.nextLine();
		plain = plain.toLowerCase();
		System.out.println("Enter key--->");
		String key = input.nextLine();
		key = key.toLowerCase();
		LinkedList<String>in=new LinkedList<>();
		LinkedList<String>in1=new LinkedList<>();
		String cipher = "";
		for (int i = 0; i < plain.length(); i++) {
			int pos = alpha.indexOf(plain.charAt(i)) ^ alpha.indexOf(key.charAt(i));
                 pos=pos%26;
                 String pos1=String.format("%5s", Integer.toBinaryString(pos)).replace(' ', '0');
                 //pos1.replace(' ','0');
     		    in.add(pos1);
			char chi = alpha.charAt(pos);
			cipher += chi;
		}
		System.out.println(in);
		System.out.println("Encrypted text is--->"+cipher);
	

		String decipher = "";
		for (int i = 0; i < plain.length(); i++) {
			int pos = alpha.indexOf(cipher.charAt(i)) ^ alpha.indexOf(key.charAt(i));
			 pos=pos%26;
			 String pos1=String.format("%5s", Integer.toBinaryString(pos)).replace(' ', '0');
			 //pos1.replace(' ','0');
				in1.add(pos1);
			char chi = alpha.charAt(pos);
			decipher += chi;
		}
		System.out.println(in1);
		System.out.println("decrypted text is---->" + decipher);

	}
	
}	

