package ģ������ϵͳ;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Test {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		ArrayList<String> str = new ArrayList<String>();//�ַ���
		ArrayList<Regex> regex = new ArrayList<Regex>();//����
		ArrayList<String> ans = new ArrayList<String>();//���
		
		in.nextLine();
		for ( int i = 0; i < n; i++ ) str.add(in.nextLine());//�����ַ���
		for ( int i = 0; i < m; i++ ) {//�������
			String name = in.next(), val = in.nextLine();
			regex.add(new Regex("\\{\\{ "+name+" \\}\\}", val.substring(2, val.length()-1)) );
		}
		
		for (String string : str) {//�滻
			for (Regex r : regex) {
				string = string.replaceAll(r.name, r.val);
			}
			string = string.replaceAll("\\{\\{ .* \\}\\}", "");
			ans.add(string);
		}
		
		for (String result : ans) {//���
			System.out.println(result);
		}
	}
 
}
class Regex{
	String name, val;//������������ֵ
 
	public Regex(String name, String val) {
		this.name = name;
		this.val = val;
	}
 
	@Override
	public String toString() {
		return "name=" + name + ", val=" + val;
	}
	
}
