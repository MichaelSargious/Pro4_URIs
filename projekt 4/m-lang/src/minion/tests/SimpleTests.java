package minion.tests;

import org.junit.Test;

import minion.Banana;
import minion.Parser;
import minion.Sentence;

import static org.junit.Assert.*;

/**
 * This class provides a very simple example of how to write tests for this project.
 * You can implement your own tests within this class or any other class within this package.
 * Tests in other packages will not be run and considered for completion of the project.
 */
public class SimpleTests {

	/**
	 * Helper function to determine if the given sentence is an instance of {@link Banana}.
	 *
	 * @param sentence the sentence
	 * @return {@code true} if the sentence is an instance of {@link Banana}
	 */
	public Parser makeParser(String input) {
		return new Parser(input);
	}
	
	
	public boolean isBanana(Sentence sentence) {
		return sentence instanceof Banana;
	}

	@Test
	public void testNonNull() {
		assertNotNull(makeParser("Banana!").parse());
	}

	@Test
	public void testNegativeSimple() {
		assertNull(makeParser("").parse());
	}


	public Sentence makeSentence(String input){
		return new Parser(input).parse();
	}


	public void testBroken(String input) {
		assertNull(makeSentence(input));
	}
	
	public void checkEnding(char expected, Sentence instance) {
		char actual = instance.getEnding();
		assertEquals("Ending did not match:", expected, actual);
	}
	
	public void checkBWord(String expected, Sentence instance) {
		String actual = instance.getStart();
		assertEquals("Start did not match:", expected, actual);
	}
	
	public void checkWords(String[] expected, Sentence instance) {
		String[] actual = instance.getWords();
		assertEquals("Array lengths did not match:", actual.length, expected.length);
		for(int i = 0; i < actual.length; i++) {
			assertEquals(String.format("Word at index %d did not match", i), expected[i], actual[i]);
		}
	}
	
	
	@Test
	public void testBanana () {
		Sentence ban = makeSentence("Banana!");
		assertTrue(isBanana(ban));
		checkEnding('!', ban);
		checkBWord("Banana", ban);
		assertNull(ban.getWords());
	}
	
	@Test
	public void testSentence1 () {
		Sentence sen = makeSentence("Nono verlo depdep pak.");
		checkEnding('.', sen);
		checkBWord("Nono", sen);
		String[] testData = {"verlo", "depdep", "pak"};
		checkWords(testData, sen);
		assertFalse(isBanana(sen));
	}

	@Test
	public void testSentence2 () {
		Sentence sen = makeSentence("Tokati aka ta depdep?");
		checkEnding('?', sen);
		checkBWord("Tokati", sen);
		String[] testData = {"aka", "ta", "depdep"};
		checkWords(testData, sen);
		assertFalse(isBanana(sen));
	}
	
	@Test
	public void testSentence3 () {
		Sentence sen = makeSentence("Batooag!");
		checkEnding('!', sen);
		checkBWord("Batooag", sen);
		assertNull(sen.getWords());
		assertFalse(isBanana(sen));
	}
	
	@Test
	public void brokenTests() {
		testBroken("Banana!Banana!");
		testBroken("Dies ist kein gültiger Satz.");
	}
	

	
}