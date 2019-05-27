
import fileHandling.FileHandler;
import language.Parser;
import language.Tokenizer;
import language.Tuple;

public class Main {
	
	public static void main(String[] args) {
		String data = FileHandler.loadFile("src/hello.txt");
		
		Tuple tokens = Tokenizer.tokenize(data);
		Parser.parse(tokens);
//		Tokenizer.printTokens(tokens);
	}
}
