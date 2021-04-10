package 小明种苹果;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int n = inScanner.nextInt();
		int m = inScanner.nextInt();
		PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>() {

			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				// TODO Auto-generated method stub
				if(o1[1]!=o2[1]) {
					return o2[1]-o1[1];
				}else {
					return o1[0]-o2[0];
				}
			}
		}) ;
		int total = 0;
		for (int i = 0; i < n; i++) {
			int thisTotal = inScanner.nextInt(); 
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += Math.abs(inScanner.nextInt());
			}
			thisTotal -= sum;
			total += thisTotal;
			Integer[] temp = {i+1,sum};
			queue.add(temp);
		}
		Integer[] res = queue.poll();
		System.out.println(total+" "+res[0]+" "+res[1]);

	}
}
