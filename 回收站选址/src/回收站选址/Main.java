package ªÿ ’’æ—°÷∑;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inScanner = new Scanner(System.in);
		int num = inScanner.nextInt();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
		int[][] way1 = {{0,1},{1,0},{-1,0},{0,-1}};
		int[][] way2 = {{1,1},{1,-1},{-1,1},{-1,-1}};
		int[] count = new int[5];
		
		for (int i = 0; i < num; i++) {
			int row = inScanner.nextInt();
			int col = inScanner.nextInt();
			if (!map.containsKey(row)) {
				map.put(row, new HashSet<>());
			}
			map.get(row).add(col);
		}
		
		for(int row: map.keySet()) {
			for(int col:map.get(row)) {
				boolean flag = true;
				for(int[] way: way1) {
					int tempx = row+way[0];
					int tempy = col+way[1];
					if (!((map.containsKey(tempx)&&(map.get(tempx).contains(tempy))))) {
						flag = false;
						break;
					}
					
				}
				if(flag) {
					int score = 0;
					for(int[] way:way2) {
						
						int tempx = row+way[0];
						int tempy = col+way[1];
						if(map.containsKey(tempx)&& map.get(tempx).contains(tempy)) {
							score++;
						}
					}
					count[score]++;
				}
			}
		}
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
		
		

	}
}
