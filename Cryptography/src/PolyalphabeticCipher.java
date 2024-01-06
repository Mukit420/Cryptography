import java.util.Scanner;

public class PolyalphabeticCipher{
	public static void main(String[] args) {
		String alpha="";
		for(char c='a';c<='z';c++) {
			alpha+=c;
		}
          Scanner sc=new Scanner(System.in);
          System.out.println("Enter the key---->");
          String key=sc.next();
          System.out.println("Enter the message--->");
          String plaintext=sc.next();
          String fkey="";
          for(int i=0;i<plaintext.length();i++) {
        	  if(i==key.length()) {
        		  i=0;
        	  }
        	  char c=key.charAt(i);
        	  fkey+=c;
        	  if(fkey.length()==plaintext.length()) {
        		  break;
        	  }
          }
          System.out.println(fkey);
          String enstr="";
          for(int i=0;i<plaintext.length();i++) {
        	  int pos=(alpha.indexOf(plaintext.charAt(i))+alpha.indexOf(fkey.charAt(i)))%26;
        	  char c=alpha.charAt(pos);
        	  enstr+=c;
          }
          System.out.println("Encrypted text is---->"+enstr);
          String destr="";
          for(int i=0;i<enstr.length();i++) {
        	  int pos=(alpha.indexOf(enstr.charAt(i))-alpha.indexOf(fkey.charAt(i)))%26;
        	  if(pos<0) {
        		  pos+=26;
        	  }
        	  char c=alpha.charAt(pos);
        	  destr+=c;
          }
          System.out.println("Decrypted text is-->"+destr);
	}

}