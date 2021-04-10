package сно╥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] lineString = bf.readLine().split(" ");
		int n = Integer.parseInt(lineString[0]);
		int m = Integer.parseInt(lineString[1]);
		int q = Integer.parseInt(lineString[2]);
		boolean[][][] inque = new boolean[105][105][305];
		int[][] way = {{0,1},{1,0},{0,-1},{-1,0}};
		
		for (int i = 0; i < q; i++) {
			lineString = bf.readLine().split(" ");
			int r = Integer.parseInt(lineString[0]);
			int c = Integer.parseInt(lineString[1]);
			int a = Integer.parseInt(lineString[2]);
			int b = Integer.parseInt(lineString[3]);
			
			for (int j = a; j <= b; j++) {
				inque[r][c][j] = true;
			}
		}
		
		LinkedList<Node> path = new LinkedList<Node>();
		path.add(new Node(1, 1, 0));
		while(!path.isEmpty()) {
			Node node = path.get(0);
			path.remove(0);
			
			
			if (node.x == n && node.y == m) {
				System.out.println(node.time);
				break;
			}
			
			for (int i = 0; i < way.length; i++) {
				int tempx = node.x + way[i][0];
				int tempy = node.y + way[i][1];
				int time = node.time+1;
				if(tempx >= 1 && tempx<=n && tempy>=1 && tempy<=m && inque[tempx][tempy][time]!= true) {
					path.add(new Node(tempx, tempy, time));
					inque[tempx][tempy][time] = true;
				}
				
			}
		}
		
	}
}

class Node{
	int x,y,time;
	public Node(int x, int y, int time) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.time = time;
		
	}
}
