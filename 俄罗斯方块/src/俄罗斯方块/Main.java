package ����˹����;

import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[][] graph = new int[16][11];
		int[][] node = new int[5][5];
		int low = 4;
		
		//���뷽��ͼ
		for ( int i = 1; i < graph.length; i++ ) {
			for ( int j = 1; j < graph[0].length; j++ ) {
				graph[i][j] = in.nextInt();
			}
		}
		
		//������
		for ( int i = 1; i < node.length; i++ ) {
			for ( int j = 1; j < node[0].length; j++ ) {
				node[i][j] = in.nextInt();
				if ( node[i][j] == 1 ) low = i;//��¼���·��ķ���ڼ��У���дʱ�����п�ʼ
			}
		}
		int n = in.nextInt();//��ʾ�ӵڼ����½�
		
		OUT:
		for ( int i = 1; ; i++ ) {//��ǰ�ڵ�һ��
			//��������ͼ
			for ( int j = 1; j < node.length; j++ ) {
				for ( int k = 1; k < node.length; k++ ) {
					//���Խ���������i+jΪ��һ�У�k+n-1Ϊ����ڷ���ͼ�ж�Ӧ��λ��
					if ( (node[j][k] == 1 && i+j >= graph.length) || (node[j][k] == 1 && graph[i+j][k+n-1] == 1) ) {
						for ( j = low; j >= 1; j-- ) {//��д
							for ( k = 1; k < node.length; k++ ) {
								if ( graph[i+j-1][k+n-1] == 0 && node[j][k] == 1 ) {
									graph[i+j-1][k+n-1] = node[j][k];
								}
							}
						}
						break OUT;//����ѭ��
					}
				}
			}
		}
		
		//���
		for ( int i = 1; i < graph.length; i++ ) {
			for ( int j = 1; j < graph[0].length; j++ ) {
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
 
}
