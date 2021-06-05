package minion;

/*
* language = "Banana!" / sentence
* 
* sentence = bWord *(" " lWord) finish
* 
* finish   = "." / "?" / "!"
* 
* bWord  = "Nono" / "Batooag" / "Tokati"
* 
* lWord = "depdep" / "verlo" / "aka" / "ta" / "pak"
* 
*/

public class Parser {

	private String input;

	public Parser(String input) {
		this.input = input;
	}

	public Sentence parse() {
		if(input.length() < 2) {
			return null;
		}

		if(input.equals("Banana!")){
			return new Banana();
		}
		char ending = input.charAt(input.length()-1);
		if(ending != '!' && ending != '?' && ending != '.') {
			return null;
		}
		String[] firstSplit = input.substring(0, input.length()-1).split(" ", 2);
		
		if(firstSplit.length == 1) {
			if(isbWord(firstSplit[0])) {
				return new Sentence(ending, null, firstSplit[0]);
			}
			return null;
		}
		
		String[] words = firstSplit[1].split(" ");
		
		for (int i = 0; i < words.length; i++) {
			if(!islWord(words[i])) {
				return null;
			}
		}
		
		return new Sentence(ending, words, firstSplit[0]);
	}
	
	private boolean isbWord(String input) {
		if(input.equals("Nono")||input.equals("Batooag")||input.equals("Tokati")) {
			return true;
		}
		return false;
	}
	
	private boolean islWord(String input) {
		if(input.equals("depdep")||input.equals("verlo")||input.equals("aka")||input.equals("ta")||input.equals("pak")) {
			return true;
		}
		return false;
	}

}
