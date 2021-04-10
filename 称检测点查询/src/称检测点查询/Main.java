package ≥∆ºÏ≤‚µ„≤È—Ø;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numDetect = in.nextInt();

		int[] home = new int[] {in.nextInt(),in.nextInt()};
		PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] != o2[1]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
				
			}

		});
		int index = 1;

		while(numDetect-- > 0 ) {
			int x2 = in.nextInt();
			int y2 = in.nextInt();

			int distance = computeDistance(home[0], home[1], x2, y2);
			int[] temp = new int[] {index,distance};
			p.add(temp);
			index++;
		}
		System.out.println(p.poll()[0]);
		System.out.println(p.poll()[0]);
		System.out.println(p.poll()[0]);
	}
	
	public static int computeDistance(int x1,int y1, int x2, int y2){
		return (int) (Math.pow((x1-x2), 2)+ Math.pow((y1-y2), 2));
	}
}
