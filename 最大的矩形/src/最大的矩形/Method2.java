package 最大的矩形;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;




public class Method2 {
	public static void main(String[] args) {
		
	}
	
	public static int largeRectangleArea(int[] heights ){
		int len = heights.length;
		int area = 0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = 0; i < len; i++) {
			while(!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
				int height = heights[stack.removeLast()];
				
				while(!stack.isEmpty()&&heights[stack.peekLast()]==height) {
					stack.removeLast();
				}
				int width;
				if(stack.isEmpty()) {
					width = i;
				}else {
					width =  i-stack.peekLast()-1;
				}
				//area = height[i]
				
			}
			stack.addLast(i);
		}
		
		return 0;
	}
}
