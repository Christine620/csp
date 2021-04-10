package 出现次数最多的数;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int nums = in.nextInt();
		int[] count = new int[10001];
		while(nums-- > 0) {
			count[in.nextInt()]+=1;
		}
		int max = 0;
		for(int i=0; i < count.length; i++) {
			if (count[i]>count[max]) {
				max = i;
			}
		}
		
		System.out.println(max);
	}
}
