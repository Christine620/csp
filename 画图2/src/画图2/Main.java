package 画图2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] line = bf.readLine().split(" ");
		int m = Integer.parseInt(line[0]), n = Integer.parseInt(line[1]),q = Integer.parseInt(line[2]);
		char[][] gragh = new char[n][m]; 
		
		int[][] way = {{0,1},{1,0},{-1,0},{0,-1}};
		
		// 先填充成.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				gragh[i][j] = '.';
			}
		}
		
		//开始从第一个操作扫描
		for (int i = 0; i < q; i++) {
			String[] op  = bf.readLine().split(" ");
			// 填充
			if(op[0].equals("1")) {
				int row = n-1-Integer.parseInt(op[2]);
				int col = Integer.parseInt(op[1]);
				char c = op[3].charAt(0);
				//BFS
				LinkedList<Node> array = new LinkedList<>();
				array.add(new Node(row,col));
				boolean[][] flag = new boolean[n+1][m+1];
				while(!array.isEmpty()) {
					int x = array.get(0).x;
					int y = array.get(0).y;
					array.remove(0);
					if(flag[x][y]) continue;
					gragh[x][y] = c;
					flag[x][y] = true;
					for (int j = 0; j < way.length; j++) {
						int tempx = way[j][0]+x;
						int tempy = way[j][1]+y;
						
						if(tempx>=0 && tempx<n && tempy>=0 && tempy<m
								&& gragh[tempx][tempy] != '+' && gragh[tempx][tempy] != '-'
								&& gragh[tempx][tempy] != '|' && gragh[tempx][tempy] != c) {
							array.add(new Node(tempx, tempy));
						}
					}
				}
			}else {//画线
				int x1 = Integer.parseInt(op[1]),y1 = Integer.parseInt(op[2]);
				int x2 = Integer.parseInt(op[3]),y2 = Integer.parseInt(op[4]); 
				
				if(x1 == x2) {//画|
					int top = Math.max(y1, y2);
					int bottle = Math.min(y1, y2);
					for (int j = bottle; j <= top ; j++) {
						if(gragh[n-1-j][x1] == '+' ) continue;
						if(gragh[n-1-j][x1] == '-') gragh[n-1-j][x1] = '+';
						else {
							gragh[n-1-j][x1] = '|';
						}
					}
					
				}else {//画-
					int left = Math.min(x1, x2);
					int Right = Math.max(x1, x2);
					for (int j = left; j <= Right; j++) {
						if(gragh[n-1-y1][j] == '+') continue;
						if(gragh[n-1-y1][j] == '|') gragh[n-1-y1][j] = '+';
						else gragh[n-1-y1][j] = '-';
					}
				}
				
			}
			

			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(gragh[i][j]);
			}
			System.out.println();
		}
	}
}

class Node{
	int x;
	int y;
	public Node(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
}
