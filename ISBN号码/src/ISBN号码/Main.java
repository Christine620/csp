package ISBNºÅÂë;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		char[] IBSN = str.toCharArray();
		//char[] nums = new char[IBSN.length-3];
		//int[] nums = new int[IBSN.length-3];
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < IBSN.length; i++) {
			if (i==1 || i== 5 || i==11) {
				continue;
			}else {
				list.add(IBSN[i]-'0');

			}
		}

		int res;
		int sum = 0;
		int temp;
		for (int i = 1; i <= 9; i++) {
			 temp = list.get(i-1);
			 int temp1 = temp*i;
			sum += temp1;
		}
		res = sum%11;
		if (res==10) {
			if(IBSN[IBSN.length-1] == 'X') System.out.println("Right");
			else {
				IBSN[IBSN.length-1] = 'X';
				System.out.print(IBSN);
			}
		}else if(res == list.get(list.size()-1)) {
			System.out.println("Right");
		}else {
			//nums[nums.length-1] = res;
			IBSN[IBSN.length-1] = (char) (res +'0');
			System.out.print(IBSN);
			
			//System.out.println(ISBN);
		}
		
		
	}
}
