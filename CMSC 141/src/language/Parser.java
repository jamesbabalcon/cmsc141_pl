package language;

public class Parser {
	
	public static void parse(Tuple tokens) {
		String check = "";
		boolean init = false;
		
		for(int i = 0; i < tokens.size(); i++) {
			check += tokens.get(i)[0];
			
			if(check.equals("programprogname")) {
				init = true;
				check = "";
			}
			
			if(init == true) {
				if(check.equals("printstring")) {
					System.out.println(tokens.get(i)[1]);
					check = "";
				}
				else if(check.equals("printexpr")) {
					System.out.println(Evaluate.evaluate(tokens.get(i)[1]));;
					check = "";
				}
				else if(check.equals("printnum")) {
					System.out.println(tokens.get(i)[1]);
					check = "";
				}
			}
		}
	}
}
