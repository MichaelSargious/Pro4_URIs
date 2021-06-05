package uri;
import java.util.regex.Pattern;

import uri.implementation.UriParserImplementation;

import java.net.InetAddress;
import java.util.regex.Matcher;

import uri.implementation.*;

/**
 * A factory class for creating {@link UriParser} instances.
 *
 * Do not change the name or pre-defined publicly visible method signatures of
 * this class
 */
public final class UriParserFactory {

	/**
	 * @param uri
	 *            The URI that will be parsed
	 * @return A parser object for the given uri or {@code null} if {@code uri}
	 *         is {@code null}
	 */
	public static UriParser create(String uri) {
		
		if(uri==null) {
			return null;
		}
		else return new UriParserImplementation(uri) ;
	}
		
	

}


