import java.util.Scanner;

public class CS_Project1 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		int n=-1;
		String inLine="";
		do {
			while(n>4||n<1) {
			System.out.println("-------------------------------------");
			System.out.println("-Enter one of the following numbers--");
			System.out.println("-1.Binary to hexadecimal and decimal-");
			System.out.println("-2.Hexadecimal to binary and decimal-");
			System.out.println("-3.Decimal to binary and hexadecimal-");
			System.out.println("-4.Exit                             -");
			System.out.println("-------------------------------------");
			inLine=in.nextLine();
			if(inLine.length()!=1) {
				continue;
			}else {
				n=inLine.charAt(0)-'0';
			}
			}
			String s="";
			boolean b=false;
			
			if(n==1) { //Binary to hex and dec
				while(b==false){
					System.out.println("Enter Binary to be converted.");
					s=sc.nextLine();
					for(int i=0;i<s.length();i++) {
					char x=s.charAt(i);
					if((x=='0'||x=='1')!=true) {
						b=false;
						break;
					 }else {
						 b=true;
					 }
				   }
				}
				   String dec=binToDec(s);		
				   print(s,decToHex(dec),dec);
				   n=-1;
			}
			if(n==2) { //Hex to bin and dec
				while(b==false) {
				System.out.println("Enter Hex");
				s=sc.nextLine();
				for(int i=0;i<s.length();i++) {
					char x=s.charAt(i);
					if(((x>='A'&&x<='F')||(x>='0'&&x<='9'))!=true) {
						b=false;
						break;
					}else {
						b=true;
					}
				}
				}
				String dec=hexToDec(s);
				print(decToBin(dec),s,dec);
				n=-1;
			}	
			if(n==3) {//Dec to bin and hex
				while(b==false) {
				System.out.println("Enter Decimal");
				s=sc.nextLine();
				for(int i=0;i<s.length();i++) {
					char x=s.charAt(i);
					if((x>='0'&&x<='9')!=true) {
						b=false;
						break;
					}else {
						b=true;
					}
			   }
			   }
				print(decToBin(s),decToHex(s),s);
				n=-1;
			}
		}while(n!=4);
		System.out.println("GoodBye! (`o`)/");
		in.close();
		sc.close();
	}
	
	public static String hexToDec(String s) {
		String str="";
		int sum=0;
		for(int i=0;i<s.length();i++) {
			int n=0;
			char ch=s.charAt((s.length()-1)-i);
			if(ch>='A'&&ch<='F') {
				n=(int)(ch-55);
			}else {
				n=(int)(ch-'0');
			}
			sum+=n*Math.pow(16,i);
		 }
		str+=sum;
		return str;
	}
	public static String decToBin(String s) {		
		int num=0;
		int num2=0;
		int k=0;
		String str="";
		int n=s.length()-1;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(n-i);
			k=((int)(ch-'0'));
			num+=k*Math.pow(10, i);
		}
		int cntr=0;
		while(num!=0) {
			num2+=(num%2)*(int)Math.pow(10,cntr);
			num/=2;
			cntr++;
		}
		str+=num2;
		return str;
	}
	
	public static String binToDec(String s){
		int dec=0;
		String str="";
		for(int i=0;i<s.length();i++) {
			char x=s.charAt((s.length()-1)-i);
			if(x=='1') {
				dec+=(int)Math.pow(2, i);
			}
	   }
		str+=dec;
		return str;
	}
	
	public static String decToHex(String s){
		String str="";
		int k=0;
		int dec=0;
		int n=s.length()-1;
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(n-i);
			k=((int)(ch-'0'));
			dec+=k*Math.pow(10, i);
		}
		
		int num2=0;
		int cntr=0;
		int rem=0;
		while(dec>0){
			rem=dec%16;
			if(rem>=10) {
				rem-=10;
				char ch=(char)(rem+'A');
				str=ch+str;
			}else {	
			char ch=(char)(rem+'0');
				str=ch+str;
			}
			dec/=16;
		}
		return str;
	}
	public static void print(String bin,String hex,String dec) {
		   System.out.println("-------------------------");
		   System.out.printf("Binary number: %s \n",bin);
		   System.out.printf("Decimal number: %s \n",dec);
		   System.out.printf("Hexadecimal number: %s \n",hex);
		   System.out.println("-------------------------");
		   System.out.println();
		   }
}
