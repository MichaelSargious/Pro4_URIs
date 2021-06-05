package uri.implementation;
import uri.Host;
import uri.Uri;

// TODO implement this class or another implementation of Uri
public class UriImplementation implements Uri {
	
	private String uri ; 
	
	public UriImplementation ( String uri  ) {
	
		this.uri = uri ;
		
	}
	
	@Override
	public String getScheme() {
		String[] uri_split = this.uri.split("://", 2);
		return uri_split[0] ;
	}

	@Override
	public String getQuery() {
		int q_start_index = 0 ;
		char sym = '?' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym) {
				q_start_index = i ;
				break ;
				}
			}
		if (q_start_index > 0) {
			String Query = this.uri.substring(q_start_index + 1, this.uri.length()) ;
			return Query ;
		}else return null ;
	}

	@Override
	public String getUserInfo() {
		int u_start_index = 0 ;
		char sym_u_s = ':' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym_u_s && this.uri.charAt(i+1) == '/' && this.uri.charAt(i+2) == '/') {
				u_start_index = i + 2;
				break ;
				}
			}
		
		int u_end_index = 0 ;
		char sym_u = '@' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym_u) {
				u_end_index = i ;
				break ;
				}
			}
		if (u_end_index > 0) {
			String user = this.uri.substring(u_start_index + 1, u_end_index) ;
			return user ;
		}else return null ;
		
	}

	@Override
	public Host getHost() {
		int h_end_index = 0 ;
		char sym_h_s = '/' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym_h_s && this.uri.charAt(i+1) != '/') {
				h_end_index = i ;
				break ;
				}
			}
		
		int h_start_index = 0 ;
		char sym_h = '@' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym_h) {
				h_start_index = i ;
				break ;
				}
			}
		if (h_start_index > 0) {
			String host = this.uri.substring(h_start_index + 1, h_end_index) ;
			return new HostImplementation(host) ;
		}else {
			char sym_h_1 = ':' ;
			for (int i = 0 ; i < this.uri.length() ; i++) {
				if(this.uri.charAt(i) == sym_h_1 && this.uri.charAt(i+1) == '/' && this.uri.charAt(i+2) == '/') {
					h_start_index = i + 2;
					break ;
					}
				}
			String host = this.uri.substring( h_start_index + 1 , h_end_index ) ;
			return new HostImplementation(host) ;
			}
	}

	@Override
	public String getPath() {
		int p_start_index = 0 ;
		char sym_p_s = '/' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym_p_s && this.uri.charAt(i+1) != '/') {
				p_start_index = i ;
				break ;
				}
			}
		int p_end_index = 0 ;
		char sym = '?' ;
		for (int i = 0 ; i < this.uri.length() ; i++) {
			if(this.uri.charAt(i) == sym) {
				p_end_index = i ;
				break ;
				}
			}
		if (p_end_index > 0) {
			String path = this.uri.substring( p_start_index + 1 , p_end_index ) ;
			return path ;
		}else {
			String path = this.uri.substring( p_start_index + 1 ,  this.uri.length() ) ;
			return path ;
		}
	}

}
