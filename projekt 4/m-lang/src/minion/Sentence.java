package minion;

public class Sentence {

	private char ending;
	private String[] words;
	private String start;
	
		
	public Sentence(char ending, String[] words, String start) {
		this.ending = ending;
		this.words = words;
		this.start = start;
	}

	public char getEnding(){
		return ending;
	}
	
	public String getStart() {
		return start;
	}
	
	public String[] getWords() {
		return words;
	}
	
}
