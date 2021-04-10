package 最大的矩形;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();//6
		int[] height = new int[num];
		for(int i=0; i<num; i++) {
			height[i] = in.nextInt();
		}
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			int left = i;
			while(left>0 && height[left-1]>=height[i]) left--;
			int right = i;
			while(right<height.length-1 && height[right+1]>=height[i]) right++;
			int width = (right-left)+1;
			int s = width*height[i];
			max = Math.max(max, s);
		}
		System.out.println(max);
	}
}
