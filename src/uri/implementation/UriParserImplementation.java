package uri.implementation;

import uri.Uri;
import uri.UriParser;

// TODO implement this class or another implementation of UriParser
public class UriParserImplementation implements UriParser {

	private String uri ;
	public UriParserImplementation(String uri) {
		this.uri = uri ;
	}

	@Override
	public Uri parse() {
		
		String[] uri_split = this.uri.split("://", 2);
		if (uri_split.length != 1) return null ;
		if (uri_split[0].matches("[a-zA-Z]\\w*")==false) return null ;
		
		int q_start_index = 0 ;
		char sym = '?' ;
		for (int i = 0 ; i < uri_split[1].length() ; i++) {
			if(uri_split[1].charAt(i) == sym) {
				q_start_index = i ;
				break ;
				}
			}
		
		int u_end_index = 0 ;
		char sym_u = '@' ;
		for (int i = 0 ; i < uri_split[1].length() ; i++) {
			if(uri_split[1].charAt(i) == sym_u) {
				u_end_index = i ;
				break ;
				}
			}
		
		int h_end_index = 0 ;
		char sym_h = '/' ;
		for (int i = 0 ; i < uri_split[1].length() ; i++) {
			if(uri_split[1].charAt(i) == sym_h) {
				h_end_index = i ;
				break ;
				}
			}
		
		
		if (u_end_index > 0) {
			
			String[] authority_split = uri_split[1].split("@", 2); 
			if (authority_split.length != 1) return null ;
			if (authority_split[0].matches("([\\w.:]|(%[0-9A-Fa-f][0-9A-Fa-f]))*")==false) 
				return null ;
			
			String[] host_split = authority_split[1].split("/", 2); 
			if (host_split.length != 1) return null ;
			if (host_split[0].matches("(((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5]))\\."
					+ "((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5]))\\."
					+ "((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5]))\\."
					+ "((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5])))"
					+ "|(\\w.(%(\\d|[A-F]|[a-f])(\\d|[A-F]|[a-f])))*") == false ) 
				return null ;
			
			if(q_start_index > 0) {
			String[] path_split = host_split[1].split("?", 2); 
			if (path_split.length != 1) return null ;
			if (path_split[0].matches("[\\w.(%[0-9A-Fa-f][0-9A-Fa-f])/]*")==false) 
				return null ;
			if (path_split[0].matches("[\\w.(%[0-9A-Fa-f][0-9A-Fa-f])&=]*")==false)
				return null ;
			}else if (host_split[1].matches("[\\w.(%[0-9A-Fa-f][0-9A-Fa-f])/]*")==false) 
				return null ;
		} else {
			String[] host_split = uri_split[1].split("/", 2); 
			if (host_split.length != 1) return null ;
			if (host_split[0].matches("(((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5]))\\."
					+ "((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5]))\\."
					+ "((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5]))\\."
					+ "((0{0,2}\\d)|(0?[1-9]\\d)|(1\\d\\d)|(2[0-4]\\d)|(25[0-5])))"
					+ "|(\\w.(%[0-9A-Fa-f][0-9A-Fa-f]))*") == false ) 
				return null ;
			
			if(q_start_index > 0) {
			String[] path_split = host_split[1].split("?", 2); 
			if (path_split.length != 1) return null ;
			if (path_split[0].matches("[\\w.(%[0-9A-Fa-f][0-9A-Fa-f])/]*")==false) 
				return null ;
			if (path_split[0].matches("[\\w.(%[0-9A-Fa-f][0-9A-Fa-f])&=]*")==false)
				return null ;
			}else if (host_split[1].matches("[\\w.(%[0-9A-Fa-f][0-9A-Fa-f])/]*")==false) 
				return null ;
			}
		
		return new UriImplementation (this.uri)  ;
		}
	}
