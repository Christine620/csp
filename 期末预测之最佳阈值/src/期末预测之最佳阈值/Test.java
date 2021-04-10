package 期末预测之最佳阈值;

import java.util.Comparator;
import java.util.PriorityQueue;


public class Test {
	public static void main(String[] args) {
		PriorityQueue<Integer> p = new PriorityQueue<>();
		p.add(5);
		p.add(3);
		p.add(36);
		p.add(8);
		p.add(12);
//		while(!p.isEmpty()) {
//			System.out.println(p.poll());
//		}
		
		PriorityQueue<Integer> p2 = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		p2.add(5);
		p2.add(3);
		p2.add(36);
		p2.add(8);
		p2.add(12);
		System.out.println(p.peek());
		System.out.println("------------------------");
		while(!p2.isEmpty()) {
			System.out.println(p2.poll());
			
		}
		
				
				
	}
	
	
}
