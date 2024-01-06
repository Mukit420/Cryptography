import java.util.Scanner;

public class RailFence{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the key length--->");
		int n=sc.nextInt();
		System.out.print("Enter the key--->");
		int[] key = new int[n];
		for(int i=0;i<n;i++) {
			key[i]=sc.nextInt();
		}
		System.out.print("Enter the plain text--->");
		String message=sc.next();
		while(message.length()%key.length!=0) {
			message+='x';
			
		}
		int row=message.length()/key.length;
		int col=key.length;
		char [][] c = new char[row][col];
		String str = "";
		int count1=0;
		for(int i=0;i<row;i++) {
			if(message.length()==count1) {
				break;
			}
			for(int j=0;j<col;j++) {
				c[i][j]=message.charAt(count1);
				System.out.print(" "+c[i][j]);
				count1++;
			}
			System.out.println();
		}
		  int count=0;
			for(int j=count;j<col;j++) {
			     int l=j;
			     j=key[l];
				for(int i=0;i<row;i++) {
					str+=c[i][j];
				//System.out.print(c[i][j]);
					
				}
				j=count++;
				if (count==5) {
					break;
				}
				
			}
			System.out.println("Encrypted Text is---->"+str);
			
			//Decryption process start from here
			
			int count2=0;
			int count3=0;
			int j;
			for(int i=count3;i<col;i++) {
				int l=i;
			     i=key[l];
				if(str.length()==count2) {
					break;
				}
				for(j=0;j<row;j++) {
					c[j][i]=str.charAt(count2);//taking input from encrypted text
					count2++;
				}
				i=count3++;
				if (count==5) {
					break;
				}	
			}
			String str1="";
			
			for(int i=0;i<row;i++) {
				for(j=0;j<col;j++) {
					char S=c[i][j];
					str1+=S;
				}
			}
		
			System.out.println("Decrypted text is------>"+str1);
		
		}
		

	
}