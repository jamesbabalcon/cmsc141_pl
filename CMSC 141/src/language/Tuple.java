package language;

import java.util.ArrayList;

public class Tuple {
	
	private ArrayList<String> identifiers;
	private ArrayList<String> tokens;
	
	public Tuple() {
		identifiers = new ArrayList<String>();
		tokens = new ArrayList<String>();
	}

	public void add(String identifier, String token) {
		identifiers.add(identifier);
		tokens.add(token);
	}
	
	public String[] get(int i) {
		String[] res = new String[2];
		
		res[0] = identifiers.get(i);
		res[1] = tokens.get(i);
		
		return res;
	}
	
	public int size() {
		return identifiers.size();
	}
}
