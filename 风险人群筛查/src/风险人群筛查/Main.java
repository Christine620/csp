package 风险人群筛查;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int peopleNum = in.nextInt();
		int stayStand = in.nextInt();
		int numTime = in.nextInt();
		int xLeftDown = in.nextInt();
		int yLeftDown = in.nextInt();
		int xRightUp = in.nextInt();
		int yRightUp = in.nextInt();
		int passbyNum = 0;
		int stayNum = 0;
		
		while(peopleNum-- > 0) {
			int stay = 0;
			int temp = 0;
			int max = 0;
			for (int i = 0; i < numTime ; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				if(ifInThere(x, y, xLeftDown, yLeftDown, xRightUp, yRightUp)) {
					stay++;temp++;
					max = Math.max(max, temp);
				}else {
					temp = 0;
				} 
			}
			if(stay>0) passbyNum++;
			if(max>=stayStand)stayNum++;

		}
		System.out.println(passbyNum);
		System.out.println(stayNum);
		
	}
	
	public static boolean ifInThere(int x,int y,int xLeftDown,int yLeftDown,int xRightUp, int yRightUp) {
		if(x >= xLeftDown && x <= xRightUp && y>= yLeftDown && y <= yRightUp) {
			return true;
		}else {
			return false;
		}
	}
}