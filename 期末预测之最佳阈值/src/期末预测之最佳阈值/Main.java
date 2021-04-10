package 期末预测之最佳阈值;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), max = -1, ans = -1, cnt = -1; // n=6
		PriorityQueue<int[]> p = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		}); 
		
		
		Set<Integer> set = new TreeSet<Integer>(); // theta value [0,1,3,5]
		while(n-- != 0) {
			int[] temp = new int[] {in.nextInt(), in.nextInt()};
			p.add(temp); // p: [0,0] [1,0] [1,1] [3,1] [5,1] [7,1] 
			set.add(temp[0]);
			if (temp[1] == 1) {
				cnt++; // cnt = 4
			}
		}
		
		
		
		for(int next : set) { //[0,1,3,5]
			while(!p.isEmpty() && p.peek()[0] < next) {//0<0
				if(p.peek()[1] == 1) cnt--;
				else cnt++;
				p.poll();
			}
			if (cnt >=  max) {
				ans = next;
				max = cnt;
			}
		}
		
		System.out.println(ans);
	}
}
