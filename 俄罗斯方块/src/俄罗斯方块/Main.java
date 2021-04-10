package 俄罗斯方块;

import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[][] graph = new int[16][11];
		int[][] node = new int[5][5];
		int low = 4;
		
		//输入方格图
		for ( int i = 1; i < graph.length; i++ ) {
			for ( int j = 1; j < graph[0].length; j++ ) {
				graph[i][j] = in.nextInt();
			}
		}
		
		//输入板块
		for ( int i = 1; i < node.length; i++ ) {
			for ( int j = 1; j < node[0].length; j++ ) {
				node[i][j] = in.nextInt();
				if ( node[i][j] == 1 ) low = i;//记录最下方的方块第几行，重写时从这行开始
			}
		}
		int n = in.nextInt();//表示从第几列下降
		
		OUT:
		for ( int i = 1; ; i++ ) {//当前在第一行
			//遍历方格图
			for ( int j = 1; j < node.length; j++ ) {
				for ( int k = 1; k < node.length; k++ ) {
					//如果越界或相碰，i+j为下一行，k+n-1为板块在方格图中对应的位置
					if ( (node[j][k] == 1 && i+j >= graph.length) || (node[j][k] == 1 && graph[i+j][k+n-1] == 1) ) {
						for ( j = low; j >= 1; j-- ) {//重写
							for ( k = 1; k < node.length; k++ ) {
								if ( graph[i+j-1][k+n-1] == 0 && node[j][k] == 1 ) {
									graph[i+j-1][k+n-1] = node[j][k];
								}
							}
						}
						break OUT;//跳出循环
					}
				}
			}
		}
		
		//输出
		for ( int i = 1; i < graph.length; i++ ) {
			for ( int j = 1; j < graph[0].length; j++ ) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
 
}
