package ´°¿Ú;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int windowNum = in.nextInt();
		int windowNumCopy = windowNum;
		int opNum = in.nextInt();
		ArrayList<Window> dWindows = new ArrayList<Window>();
		HashMap<Window,Integer> index = new HashMap<>();

		while(windowNum-- > 0) {
			int x1 = in.nextInt();
			int y1 = in.nextInt();
			int x2 = in.nextInt();
			int y2 = in.nextInt();
			dWindows.add(new Window(x1, y1, x2, y2));
			
		}
		
		for (int i = 0; i < windowNumCopy; i++) {
			index.put(dWindows.get(i),i+1);
		}
		
		while(opNum-- >0) {
			int x = in.nextInt();
			int y = in.nextInt();
			boolean find = false;
			for (int i = windowNumCopy-1; i >= 0; i--) {
				if(inThere(dWindows.get(i),x,y)) {
					System.out.println(index.get(dWindows.get(i)));
					Window tempWindow = dWindows.get(i);
					find = true;
					dWindows.set(i, dWindows.get(windowNumCopy-1));
					dWindows.set(windowNumCopy-1, tempWindow);
					break;
				}
			}
			if(find==false) System.out.println("IGNORED");
			
					
		}
	}
	
	public static boolean inThere(Window window,int x,int y) {
		if(x>= window.x1 && x<= window.x2 && y>=window.y1 && y<= window.y2) return true;
		else {
			return false;
		}
	}
	
	
}

class Window{
	int x1,x2,y1,y2;
	boolean isTop = false;
	public Window(int x1,int y1, int x2,int y2) {
		// TODO Auto-generated constructor stub
		this.x1 = x1;		
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	public Window(int x1,int y1, int x2,int y2,boolean isTop) {
		// TODO Auto-generated constructor stub
		this.x1 = x1;		
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.isTop = isTop;
	}
}
