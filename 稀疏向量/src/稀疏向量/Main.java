package œ° ËœÚ¡ø;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) throws IOException {
		Input inScanner = new Input();
		int dim = inScanner.nextInt();
		int u = inScanner.nextInt();
		int v = inScanner.nextInt();
		Map<Integer, Integer> uu = new HashMap<Integer, Integer>();
		while(u-- > 0) {
			uu.put(inScanner.nextInt(), inScanner.nextInt());
		}
		long res = 0;
		while(v-- >0) {
			res += uu.getOrDefault(inScanner.nextInt(), 0)*inScanner.nextInt();
		}
		System.out.println(res);		
	}
}

class Input{
	StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	public int  nextInt() throws IOException {
		streamTokenizer.nextToken();
		return (int)streamTokenizer.nval;
	}
}
