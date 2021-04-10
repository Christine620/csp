package 模板生成系统;

import java.util.ArrayList;
import java.util.Scanner;
 
public class Test {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		ArrayList<String> str = new ArrayList<String>();//字符串
		ArrayList<Regex> regex = new ArrayList<Regex>();//规则
		ArrayList<String> ans = new ArrayList<String>();//结果
		
		in.nextLine();
		for ( int i = 0; i < n; i++ ) str.add(in.nextLine());//读入字符串
		for ( int i = 0; i < m; i++ ) {//读入规则
			String name = in.next(), val = in.nextLine();
			regex.add(new Regex("\\{\\{ "+name+" \\}\\}", val.substring(2, val.length()-1)) );
		}
		
		for (String string : str) {//替换
			for (Regex r : regex) {
				string = string.replaceAll(r.name, r.val);
			}
			string = string.replaceAll("\\{\\{ .* \\}\\}", "");
			ans.add(string);
		}
		
		for (String result : ans) {//输出
			System.out.println(result);
		}
	}
 
}
class Regex{
	String name, val;//变量名、变量值
 
	public Regex(String name, String val) {
		this.name = name;
		this.val = val;
	}
 
	@Override
	public String toString() {
		return "name=" + name + ", val=" + val;
	}
	
}
