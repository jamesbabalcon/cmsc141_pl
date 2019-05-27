package language;

public abstract class Tokenizer {
	
	public static Tuple tokenize(String data) {
		String tok = "";
		String str = "";
		String expr = "";
		boolean isexpr = false;
		boolean progName = false;
		boolean state = false;
		
		Tuple tokens = new Tuple();
		
		for(int i = 0; i < data.length(); i++) {
			tok += stringify(data.charAt(i));
			
			if(tok.equals(" ")) {
				if(state == false) {
					tok = "";
				}
				else {
					tok = " ";
				}
			}
			else if(tok.equals("\n")) {
				if(!expr.equals("")) {
					if(isexpr == true) {
						tokens.add("expr", expr);
						expr = "";
						isexpr = false;
					}
					else if(isexpr == false) {
						tokens.add("num", expr);
						expr = "";
					}
				}
				if(progName == true) {
					tokens.add("progname", str);
					str = "";
					progName = false;
				}
				tok = "";
			}
			else if(tok.equals("program")) {
				tokens.add("program", tok);
				progName = true;
				tok = "";
			}
			else if(progName == true) {
				str += tok;
				tok = "";
			}
			else if(tok.equals("print:")) {
				tokens.add("print", tok);
				tok = "";
			}
			else if(Character.isDigit(tok.toCharArray()[0])) {
				expr += tok;
				tok = "";
			}
			else if(tok.equals("+")) {
				isexpr = true;
				expr += tok;
				tok = "";
			}
			else if(tok.equals("\"")) {
				if(state == false) {
					state = true;
				}
				else if(state == true) {
					tokens.add("string", str);
					str = "";
					state = false;
					tok = "";
				}
			}
			else if(state == true) {
				str += tok;
				tok = "";
			}
		}
		
		return tokens;
	}
	
	private static String stringify(char c) {
		return Character.toString(c);
	}
	
	public static void printTokens(Tuple tokens) {
		System.out.print("{ ");
		for(int i = 0; i < tokens.size(); i++) {
			String[] tok = tokens.get(i);
			System.out.print("[" + tok[0] + ", " + tok[1] + "] ");
		}
		System.out.println("}");
	}
}
