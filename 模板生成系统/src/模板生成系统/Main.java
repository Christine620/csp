package 模板生成系统;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Main {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		ArrayList<String> str = new ArrayList<String>();//字符串
		HashMap<String, String> map = new HashMap<String, String>();
		
		in.nextLine();
		for ( int i = 0; i < n; i++ ) str.add(in.nextLine());//读入字符串
		for ( int i = 0; i < m; i++ ) {//读入规则
			String name = in.next(), val = in.nextLine();
			System.out.println(val);
			System.out.println(val.length());
			System.out.println(val.substring(1, val.length()));
			System.out.println(val.substring(2, val.length()-1));
			System.out.println(val.substring(2, val.length()-1));
			map.put(name, val.substring(2, val.length()-1));
		}
		
		for (String string : str) {//替换
			Pattern p = Pattern.compile("\\{\\{ (.*?) \\}\\}");
			Matcher mat = p.matcher(string);
			while ( mat.find() ) {
				String temp = mat.group(1);
				if ( map.containsKey(temp) ) {
					string = string.replaceAll("\\{\\{ "+temp+" \\}\\}", map.get(temp));
				} else string = string.replaceAll("\\{\\{ "+temp+" \\}\\}", "");
			}
			System.out.println(string);
		}
	}
}
