package ������ѡ��;
import java.util.HashMap;
import java.util.Scanner;
 
public class Others {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();//�ֵ�
		HashMap<String, String> ans = new HashMap<String, String>();//���
		String temp = in.nextLine();
		
		//�����ֵ�
		for ( int i = 0; i < temp.length(); i++ ) {
			if ( i+1 < temp.length() && temp.charAt(i+1) == ':' ) {
				map.put("-"+temp.charAt(i), true);
				i++;
			} else map.put("-"+temp.charAt(i), false);
		}
		int n = in.nextInt();
		in.nextLine();
		
		//��ʼ�ж�
		for ( int i = 0; i < n; i++ ) {
			String[] arrs = in.nextLine().split(" ");
			for ( int j = 1; j < arrs.length; j++ ) {
				if ( map.containsKey(arrs[j]) ) {//�Ϸ�ѡ��
					//�в����Ҳ����Ϸ�
					if ( map.get(arrs[j]) && j+1 < arrs.length && arrs[j+1].matches("[a-z0-9-]+")) {
						ans.put(arrs[j], arrs[j+1]);
						j++;
					} else if ( !map.get(arrs[j]) ) ans.put(arrs[j], "");//����Ҫ����
					else break;//��Ҫ��������û����������������Ϸ�
				} else break;
			}
			//���
			System.out.print("Case "+(i+1)+": ");
			for ( char c = 'a'; c <= 'z'; c++ ) {//��С�������
				if ( ans.containsKey("-"+c) ) {
					System.out.print("-"+c+" ");
					//����в���
					if ( !ans.get("-"+c).equals("") ) System.out.print(ans.get("-"+c)+" ");
				}
			}
			System.out.println();
			ans.clear();//��������
		}
	}
	
}