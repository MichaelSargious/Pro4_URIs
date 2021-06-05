package uri.tests;

import org.junit.Test;

import uri.Host;
import uri.IPv4Address;
import uri.Uri;
import uri.UriParserFactory;

import static org.junit.Assert.*;

/**
 * This class provides a very simple example of how to write tests for this project.
 * You can implement your own tests within this class or any other class within this package.
 * Tests in other packages will not be run and considered for completion of the project.
 */
public class SimpleTests {

	private IPv4Address host;
	/**
	 * Helper function to determine if the given host is an instance of {@link IPv4Address}.
	 *
	 * @param host the host
	 * @return {@code true} if the host is an instance of {@link IPv4Address}
	 */
	public boolean isIPv4Address(Host host) {
		return host instanceof IPv4Address;
	}

	/**
	 * Helper function to retrieve the byte array representation of a given host which must be an instance of {@link IPv4Address}.
	 *
	 * @param host the host
	 * @return the byte array representation of the IPv4 address
	 */
	public byte[] getIPv4Octets(Host host) {
		if (!isIPv4Address(host))
			throw new IllegalArgumentException("host must be an IPv4 address");
		return ((IPv4Address) host).getOctets();
	}
	@Test
	public void testNonNull() {
		assertNotNull(UriParserFactory.create("scheme://").parse());
	}
	@Test
	public void testNegativeSimple() {
		assertNull(UriParserFactory.create("").parse());
	}
	@Test
	public void testIPv4AddressSimple() {
		Host host = UriParserFactory.create("scheme://1.2.3.4").parse().getHost();
		assertTrue("host must be an IPv4 address", isIPv4Address(host));
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*@Test
	public void testScheme_t_0() {
		String uri = UriParserFactory.create("http://").parse().getScheme();
		assertTrue(Character.isLetter(uri.charAt(0)));
		}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_0() {
		String uri = UriParserFactory.create("7ttp://").parse().getScheme();
		if((Character.isLetter(uri.charAt(0))) == false) fail(uri) ; 
		}
	@Test
	public void testScheme_t_1() {
		String uri = UriParserFactory.create("http://").parse().getScheme();
		String sym = " [!#$<@%&*()._+=|<>?{}\\[\\]~'~-]";
		int first_part = uri.length() - 2 ;
		for (int j = 0 ; j < first_part ; j++) {
			for ( int i = 0 ; i < sym.length() ; i++ ) {
				assertTrue( uri.charAt(j) != sym.charAt(i)) ;
				}
			}
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_1() {
		String uri = UriParserFactory.create("ht?tp://").parse().getScheme();
		String sym = " [!#$<@%&*()._+=|<>?{}\\[\\]~'~-]";
		int first_part = uri.length() - 2 ;
		for (int j = 0 ; j < first_part ; j++) {
			for ( int i = 0 ; i < sym.length() ; i++ ) {
				if ( uri.charAt(j) == sym.charAt(i) ) fail(uri) ; 
				}
			}
	}
	@Test
	public void testScheme_t_2() {
		String uri = UriParserFactory.create("http://").parse().getScheme();
		String sym = "://";
		int i = 0 ;
		for (int j = uri.length()-3 ; j < uri.length() ; j++) {
			assertTrue( uri.charAt(j) == sym.charAt(i) ) ; 
			i++ ;	
			}
		}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_2() {
		String uri = UriParserFactory.create("http:/{").parse().getScheme();
		String sym = "://";
		int i = 0 ;
		for (int j = uri.length()-3 ; j < uri.length() ; j++) {
			if ( uri.charAt(j) != sym.charAt(i) ) fail(uri); 
			else i++ ;	
			}
		}*/
	@Test(expected=NullPointerException.class)
	public void testScheme_0() {
		fail(UriParserFactory.create("").parse().getScheme());
		}
	@Test(expected=NullPointerException.class)
	public void testScheme_01() {
		fail(UriParserFactory.create("://").parse().getScheme());
		}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_1() {
		fail(UriParserFactory.create(":\\").parse().getScheme());
	}	
	@Test(expected=NullPointerException.class)
	public void testScheme_f_2() {
		fail(UriParserFactory.create(":/").parse().getScheme());
		}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_3() {
		fail(UriParserFactory.create(":").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_4() {
		fail( UriParserFactory.create("/:").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_5() {
		fail( UriParserFactory.create("//:").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_6() {
		fail( UriParserFactory.create(":\\").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_7() {
		fail( UriParserFactory.create("h:/").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_9() {
		fail( UriParserFactory.create("7://").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_10() {
		fail( UriParserFactory.create("?://").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_11() {
		fail( UriParserFactory.create("h#://").parse().getScheme());
	}
	@Test(expected=NullPointerException.class)
	public void testScheme_f_12() {
		fail( UriParserFactory.create("h7?://").parse().getScheme());
	}
	@Test
	public void testScheme_t_0() {
		String uri = UriParserFactory.create("h7://").parse().getScheme();
		assertEquals("h7", uri);
	}
	@Test
	public void testScheme_t_1() {
		String uri = UriParserFactory.create("hT://").parse().getScheme();
		assertEquals("hT", uri);
	}
	@Test
	public void testScheme_t_2() {
		String uri = UriParserFactory.create("ht://").parse().getScheme();
		assertEquals("ht", uri);
	    }
	
	@Test  
	public void testScheme_t_3() {
		String uri = UriParserFactory.create("H7://").parse().getScheme();
		assertEquals("H7", uri);
	}
	@Test  
	public void testScheme_t_4() {
		String uri = UriParserFactory.create("HH://").parse().getScheme();
		assertEquals("HH", uri);
	}
	@Test  
	public void testScheme_t_5() {
		String uri = UriParserFactory.create("Ht://").parse().getScheme();
		assertEquals("Ht", uri);
	}
	@Test
	public void testScheme_t_6() {
		String uri = UriParserFactory.create("h7T://").parse().getScheme();
		assertEquals("h7T", uri);
	}
	@Test
	public void testScheme_t_7() {
		String uri = UriParserFactory.create("hT8://").parse().getScheme();
		assertEquals("hT8", uri);
	}
	@Test
	public void testScheme_t_8() {
		String uri = UriParserFactory.create("ht7T://").parse().getScheme();
		assertEquals("ht7T", uri);
	    }
	
	@Test  
	public void testScheme_t_9() {
		String uri = UriParserFactory.create("H7t://").parse().getScheme();
		assertEquals("H7t", uri);
	}
	@Test  
	public void testScheme_t_10() {
		String uri = UriParserFactory.create("HH3t://").parse().getScheme();
		assertEquals("HH3t", uri);
	}
	@Test  
	public void testScheme_t_11() {
		String uri = UriParserFactory.create("Ht4://").parse().getScheme();
		assertEquals("Ht4", uri);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(expected=NullPointerException.class)
	public void testUserinfo_f_0() {
		fail(UriParserFactory.create("").parse().getUserInfo());
		}
	


	/*@Test(expected=NullPointerException.class)
	public void getUserInfo_f_0() {
		String uri = UriParserFactory.create("http://?d#8f%@").parse().getUserInfo();
		String sym = " [!#$<&*()_+=|<>?{}\\[\\]~'~-]";
		int first_part = uri.length() - 2 ;
		for (int j = 0 ; j < first_part ; j++) {
			for ( int i = 0 ; i < sym.length() ; i++ ) {
				if ( uri.charAt(j) == sym.charAt(i) ) fail(uri) ; 
				}
			}
	}
	@Test
	public void testuserinfo_t_1() {
		String uri = UriParserFactory.create("http://prog2%f9:@").parse().getUserInfo();
		String after = "ABCDEFabcdef0123456789" ;
		for (int j = 0 ; j < uri.length() ; j++){
			if( uri.charAt(j) == '%' ) {
				for (int i = 0 ; i < after.length() ; i++) {
					assertEquals( uri.charAt(j+1) , after.charAt(i) ) ;
				}
				for (int p = 0 ; p < after.length() ; p++) {
					assertEquals( uri.charAt(j+2) , after.charAt(p) ) ;
				}
			}
		}
	}				
	@Test(expected=NullPointerException.class)
	public void getUserInfo_f_1() {
		String uri = UriParserFactory.create("http://prog2%f98:@").parse().getUserInfo();
		String after = "ABCDEFabcdef0123456789" ;
		int flag_1 = 0 ;
		int flag_2 = 0 ;
		for (int j = 0 ; j < uri.length() ; j++){
			if( uri.charAt(j) == '%' ) {
				for (int i = 0 ; i < after.length() ; i++) {
					if ( uri.charAt(j+1) == after.charAt(i) ) flag_1++;
				}
				for (int p = 0 ; p < after.length() ; p++) {
					if ( uri.charAt(j+2) == after.charAt(p) ) flag_2++;
				}
				if(uri.charAt(j+3) != ':' || uri.charAt(j+3) != '@') fail(uri) ;
			}
		}
		if (flag_1 == 0 || flag_2 == 0) fail(uri) ;
	}*/
	@Test
	public void testUserinfo_2() {
		String user = UriParserFactory.create("http://:@").parse().getUserInfo();
		assertEquals(":" , user);
		}
	@Test
	public void testUserinfo_3() {
		String user = UriParserFactory.create("http://X@").parse().getUserInfo();
		assertEquals("X" , user);
		}
	@Test
	public void testUserinfo_4() {
		String user = UriParserFactory.create("http://x@").parse().getUserInfo();
		assertEquals("x" , user);
		}
	@Test
	public void testUserinfo_5() {
		String user = UriParserFactory.create("http://9@").parse().getUserInfo();
		assertEquals("9" , user);
		}
	@Test
	public void testUserinfo_6() {
		String user = UriParserFactory.create("http://.@").parse().getUserInfo();
		assertEquals("." , user);
		}
	@Test
	public void testUserinfo_7() {
		String user = UriParserFactory.create("http://X@").parse().getUserInfo();
		assertEquals("X" , user);
		}
	@Test
	public void testUserinfo_8() {
		String user = UriParserFactory.create("http://x@").parse().getUserInfo();
		assertEquals("x" , user);
		}
	@Test
	public void testUserinfo_9() {
		String user = UriParserFactory.create("http://9@").parse().getUserInfo();
		assertEquals("9" , user);
		}
	@Test
	public void testUserinfo_10() {
		String user = UriParserFactory.create("http://.@").parse().getUserInfo();
		assertEquals("." , user);
		}@Test
	public void testUserinfo_11() {
			String user = UriParserFactory.create("http://X@").parse().getUserInfo();
			assertEquals("X" , user);
			}
		@Test
		public void testUserinfo_12() {
			String user = UriParserFactory.create("http://x@").parse().getUserInfo();
			assertEquals("x" , user);
			}
		@Test
		public void testUserinfo_13() {
			String user = UriParserFactory.create("http://9@").parse().getUserInfo();
			assertEquals("9" , user);
			}
		@Test
		public void testUserinfo_14() {
			String user = UriParserFactory.create("http://.@").parse().getUserInfo();
			assertEquals("." , user);
			}
		@Test
		public void testUserinfo_15() {
			String user = UriParserFactory.create("http://%9F@").parse().getUserInfo();
			assertEquals("%9F" , user);
			}
		@Test
		public void testUserinfo_16() {
			String user = UriParserFactory.create("http://%9c@").parse().getUserInfo();
			assertEquals("%9c" , user);
			}
		@Test
		public void testUserinfo_17() {
			String user = UriParserFactory.create("http://%98@").parse().getUserInfo();
			assertEquals("%98" , user);
			}
		@Test
		public void testUserinfo_18() {
			String user = UriParserFactory.create("http://%9F@").parse().getUserInfo();
			assertEquals("%9F" , user);
			}
		@Test
		public void testUserinfo_19() {
			String user = UriParserFactory.create("http://%9a@").parse().getUserInfo();
			assertEquals("%9a" , user);
			}
		@Test
		public void testUserinfo_20() {
			String user = UriParserFactory.create("http://%98@").parse().getUserInfo();
			assertEquals("%98" , user);
			}
		@Test
		public void testUserinfo_21() {
			String user = UriParserFactory.create("http://%9F@").parse().getUserInfo();
			assertEquals("%9F" , user);
			}
		@Test
		public void testUserinfo_22() {
			String user = UriParserFactory.create("http://%9a@").parse().getUserInfo();
			assertEquals("%9a" , user);
			}
		@Test
		public void testUserinfo_23() {
			String user = UriParserFactory.create("http://%98@").parse().getUserInfo();
			assertEquals("%98" , user);
			}
		@Test
		public void testUserinfo_24() {
			String user = UriParserFactory.create("http://%FF@").parse().getUserInfo();
			assertEquals("%FF" , user);
			}
		@Test
		public void testUserinfo_25() {
			String user = UriParserFactory.create("http://%Fc@").parse().getUserInfo();
			assertEquals("%Fc" , user);
			}
		@Test
		public void testUserinfo_26() {
			String user = UriParserFactory.create("http://%F9@").parse().getUserInfo();
			assertEquals("%F9" , user);
			}
		@Test
		public void testUserinfo_27() {
			String user = UriParserFactory.create("http://%FF@").parse().getUserInfo();
			assertEquals("%FF" , user);
			}
		@Test
		public void testUserinfo_28() {
			String user = UriParserFactory.create("http://%Fc@").parse().getUserInfo();
			assertEquals("%Fc" , user);
			}
		@Test
		public void testUserinfo_29() {
			String user = UriParserFactory.create("http://%F9@").parse().getUserInfo();
			assertEquals("%F9" , user);
			}
		@Test
		public void testUserinfo_30() {
			String user = UriParserFactory.create("http://%FF@").parse().getUserInfo();
			assertEquals("%FF" , user);
			}
		@Test
		public void testUserinfo_31() {
			String user = UriParserFactory.create("http://%Fc@").parse().getUserInfo();
			assertEquals("%Fc" , user);
			}
		@Test
		public void testUserinfo_32() {
			String user = UriParserFactory.create("http://%F9@").parse().getUserInfo();
			assertEquals("%F9" , user);
			}
		@Test
		public void testUserinfo_33() {
			String user = UriParserFactory.create("http://%cF@").parse().getUserInfo();
			assertEquals("%cF" , user);
			}
		@Test
		public void testUserinfo_34() {
			String user = UriParserFactory.create("http://%cf@").parse().getUserInfo();
			assertEquals("%cf" , user);
			}
		@Test
		public void testUserinfo_35() {
			String user = UriParserFactory.create("http://%c8@").parse().getUserInfo();
			assertEquals("%c8" , user);
			}
		@Test
		public void testUserinfo_36() {
			String user = UriParserFactory.create("http://%cF@").parse().getUserInfo();
			assertEquals("%cF" , user);
			}
		@Test
		public void testUserinfo_37() {
			String user = UriParserFactory.create("http://%cf@").parse().getUserInfo();
			assertEquals("%cf" , user);
			}
		@Test
		public void testUserinfo_38() {
			String user = UriParserFactory.create("http://%c8@").parse().getUserInfo();
			assertEquals("%c8" , user);
			}
		@Test
		public void testUserinfo_39() {
			String user = UriParserFactory.create("http://:%cF@").parse().getUserInfo();
			assertEquals(":%cF" , user);
			}
		@Test
		public void testUserinfo_40() {
			String user = UriParserFactory.create("http://%cf@").parse().getUserInfo();
			assertEquals("%cf" , user);
			}
		@Test
		public void testUserinfo_41() {
			String user = UriParserFactory.create("http://%c8@").parse().getUserInfo();
			assertEquals("%c8" , user);
			}
		@Test(expected=NullPointerException.class)
		public void testUserinfo_42() {
			fail(UriParserFactory.create("http://%5@").parse().getUserInfo());
			}
		@Test(expected=NullPointerException.class)
		public void testUserinfo_43() {
			fail(UriParserFactory.create("http://%f@").parse().getUserInfo());
			}
		@Test(expected=NullPointerException.class)
		public void testUserinfo_44() {
			fail(UriParserFactory.create("http://%%@").parse().getUserInfo());
			}
		@Test(expected=NullPointerException.class)
		public void testUserinfo_45() {
			fail(UriParserFactory.create("http://?@").parse().getUserInfo());
			}
		@Test(expected=NullPointerException.class)
		public void testUserinfo_46() {
			fail(UriParserFactory.create("http://%#@").parse().getUserInfo());
			}
		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		@Test
		public void testreg_t_0() {
			Host host = UriParserFactory.create("scheme://X").parse().getHost();
			assertEquals("X" , host.toString() );
			}
		@Test
		public void testreg_t_1() {
			Host host = UriParserFactory.create("scheme://x").parse().getHost();
			assertEquals("x" , host.toString() );
			}
		@Test
		public void testreg_t_2() {
			Host host = UriParserFactory.create("scheme://9").parse().getHost();
			assertEquals("9" , host.toString() );
			}
		@Test
		public void testreg_t_3() {
			Host host = UriParserFactory.create("scheme://.").parse().getHost();
			assertEquals("." , host.toString() );
			}
		@Test
		public void testreg_t_4() {
			Host host = UriParserFactory.create("scheme://%97").parse().getHost();
			assertEquals("%97" ,host.toString() );
			}
		@Test
		public void testreg_t_5() {
			Host host = UriParserFactory.create("scheme://%9A").parse().getHost();
			assertEquals("%9A" ,host.toString() );
			}
		@Test
		public void testreg_t_6() {
			Host host = UriParserFactory.create("scheme://%9b").parse().getHost();
			assertEquals("%9b" ,host.toString() );
			}
		@Test
		public void testreg_t_7() {
			Host host = UriParserFactory.create("scheme://%B9").parse().getHost();
			assertEquals("%B9" , host.toString() );
			}
		@Test
		public void testreg_t_8() {
			Host host = UriParserFactory.create("scheme://%Bd").parse().getHost();
			assertEquals("%Bd" , host.toString() );
			}
		@Test
		public void testreg_t_9() {
			Host host = UriParserFactory.create("scheme://%BB").parse().getHost();
			assertEquals("%BB" , host.toString() );
			}
		@Test
		public void testreg_t_10() {
			Host host = UriParserFactory.create("scheme://%aB").parse().getHost();
			assertEquals("%aB" , host.toString() );
			}
		@Test
		public void testreg_t_11() {
			Host host = UriParserFactory.create("scheme://%a5").parse().getHost();
			assertEquals("%a5" , host.toString() );
			}
		@Test
		public void testreg_t_12() {
			Host host = UriParserFactory.create("scheme://%ac").parse().getHost();
			assertEquals("%ac" , host.toString() );
			}
		@Test
		public void testreg_t_13() {
			Host host = UriParserFactory.create("scheme://%acX").parse().getHost();
			assertEquals("%acX" , host.toString() );
			}
		@Test
		public void testreg_t_14() {
			Host host = UriParserFactory.create("scheme://5%BB").parse().getHost();
			assertEquals("5%BB" , host.toString() );
			}
		@Test
		public void testreg_t_15() {
			Host host = UriParserFactory.create("scheme://.%98").parse().getHost();
			assertEquals(".%98" , host.toString() );
			}
		@Test
		public void testreg_t_16() {
			Host host = UriParserFactory.create("scheme://%Da.").parse().getHost();
			assertEquals("%Da." , host.toString() );
			}
		@Test
		public void testreg_t_17() {
			Host host = UriParserFactory.create("scheme://X%aB").parse().getHost();
			assertEquals("X%aB" , host.toString() );
			}
		@Test
		public void testreg_t_18() {
			Host host = UriParserFactory.create("scheme://d%8c").parse().getHost();
			assertEquals("d%8c" , host.toString() );
			}
		@Test(expected=NullPointerException.class)
		public void testreg_f_0() {
			fail(UriParserFactory.create("scheme:// ").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_1() {
			fail( UriParserFactory.create("scheme://$").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_2() {
			fail( UriParserFactory.create("scheme://%").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_3() {
			fail( UriParserFactory.create("scheme://%r93x").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_4() {
			fail(UriParserFactory.create("scheme://%9z").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_5() {
			fail(UriParserFactory.create("scheme://%Gz").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_6() {
			fail(UriParserFactory.create("scheme://Gz%").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_7() {
			fail( UriParserFactory.create("scheme://%!").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_8() {
			fail( UriParserFactory.create("scheme://%5!").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_9() {
			fail( UriParserFactory.create("scheme://52%").parse().getHost().toString());
		}
		@Test(expected=NullPointerException.class)
		public void testreg_f_11() {
			fail(UriParserFactory.create("scheme://X .").parse().getHost().toString());
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//-------------------------------------- Host-true
		@Test
		public void testhost1() {
			Host uri = UriParserFactory.create("http://001.060.000.200").parse().getHost();
			assertEquals("1.60.0.200", ((IPv4Address)uri).toString());
			assertNotNull(uri);
		}
		@Test
		public void testhost2() {
			Host uri = UriParserFactory.create("http://255.255.255.255").parse().getHost();
			assertEquals("255.255.255.255", ((IPv4Address)uri).toString());
			assertNotNull(uri);
		}
		@Test
		public void testhost3() {
			Host uri = UriParserFactory.create("http://1.1.1.1").parse().getHost();
			assertEquals("1.1.1.1", ((IPv4Address)uri).toString());
			assertNotNull(uri);
		}
		@Test
		public void testhost4() {
			Host uri = UriParserFactory.create("http://21.21.21.21").parse().getHost();
			assertEquals("21.21.21.21", ((IPv4Address)uri).toString());
			assertNotNull(uri);
		}
		@Test
		public void testhost5() {
			Host uri = UriParserFactory.create("http://101.101.101.101").parse().getHost();
			assertEquals("101.101.101.101",((IPv4Address)uri).toString());
			assertNotNull(uri);
		}
		@Test
		public void testhost6() {
			Host uri = UriParserFactory.create("http://201.201.201.201").parse().getHost();
			assertEquals("201.201.201.201", ((IPv4Address)uri).toString());
			assertNotNull(uri);
		}
		@Test
		public void testhost7() {
			Host uri = UriParserFactory.create("http://250.250.250.250").parse().getHost();
			assertEquals("250.250.250.250", ((IPv4Address)uri).toString());
			assertNotNull(uri);
		}

		
		
		//-------------------------------------------- host_is_not_given
		
		//@Test 
		//public void host_null() {
			//Host ABHost = UriParserFactory.create("").parse().getHost();
			//assertEquals("", ((IPv4Address)ABHost).toString());
			//}
		
		//----------------------------------------------- host_false
	 //	@Test 
		//public void host_neg1() {
			//Host host_negHost = UriParserFactory.create("http://%Gg").parse().getHost();
			//assertFalse(isIPv4Address(host_negHost));
			
			//}
		@Test 
		public void host_neg2() {
			Host host_negHost =UriParserFactory.create("http://288.288.288.288").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		@Test 
		public void host_neg3() {
			Host host_negHost =UriParserFactory.create("http://2525.8741.9741.74256").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		@Test 
		public void host_neg4() {
			Host host_negHost = UriParserFactory.create("http://asd.fref.asd.ewr").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
//		@Test 
		//public void host_neg5() {
			//Host host_negHost = UriParserFactory.create("http://122.dwd.#14.sdw").parse().getHost();
			//assertFalse(isIPv4Address(host_negHost));
			//}
		@Test 
		public void host_neg6() {
			Host host_negHost = UriParserFactory.create("http://ASD.3dd.vff.123").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		//@Test 
		//public void host_neg7() {
			//Host host_negHost = UriParserFactory.create("http://#%&.143.678.wer").parse().getHost();
			//assertFalse(isIPv4Address(host_negHost));
			//}
		@Test
		public void host_neg8() {
			Host host_negHost =UriParserFactory.create("http://111.000.222.").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		@Test 
		public void host_neg9() {
			Host host_negHost =UriParserFactory.create("http://111.000.222").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		@Test 
		public void host_neg10() {
			Host host_negHost =UriParserFactory.create("http://111.000.").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		@Test 
		public void host_neg11() {
			Host host_negHost = UriParserFactory.create("http://111.000").parse().getHost();
			assertFalse(isIPv4Address(host_negHost));
			}
		@Test 
		public void host_neg12() {
			Host host_negHost = UriParserFactory.create("http://111.").parse().getHost() ;
			assertFalse(isIPv4Address(host_negHost));
			}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		@Test
		public void testpath_t_2() {
			String user = UriParserFactory.create("http:///X").parse().getPath();
			assertEquals("/X" , user);
			}
		@Test
		public void testpath_t_3() {
			String user = UriParserFactory.create("http:///x").parse().getPath();
			assertEquals("/x" , user);
			}
		@Test
		public void testpath_t_4() {
			String user = UriParserFactory.create("http:///9").parse().getPath();
			assertEquals("/9" , user);
			}
		@Test
		public void testpath_t_5() {
			String user = UriParserFactory.create("http:///.").parse().getPath();
			assertEquals("/." , user);
			}
		@Test
		public void testpath_t_6() {
			String user = UriParserFactory.create("http:///%9F").parse().getPath();
			assertEquals("/%9F" , user);
			}
		@Test
		public void testpath_t_7() {
			String user = UriParserFactory.create("http:///%9a").parse().getPath();
			assertEquals("/%9a" , user);
			}
		@Test
		public void testpath_t_8() {
			String user = UriParserFactory.create("http:///%98").parse().getPath();
			assertEquals("/%98" , user);
			}
		@Test
		public void testpath_t_9() {
			String user = UriParserFactory.create("http:///%FF").parse().getPath();
			assertEquals("/%FF" , user);
			}
		@Test
		public void testpath_t_10() {
			String user = UriParserFactory.create("http:///%Fc").parse().getPath();
			assertEquals("/%Fc" , user);
			}
		@Test
		public void testpath_t_11() {
			String user = UriParserFactory.create("http:///%F9").parse().getPath();
			assertEquals("/%F9" , user);
			}
		@Test
		public void testpath_t_12() {
			String user = UriParserFactory.create("http:///%cF").parse().getPath();
			assertEquals("/%cF" , user);
			}
		@Test
		public void testpath_t_13() {
			String user = UriParserFactory.create("http:///%cf").parse().getPath();
			assertEquals("/%cf" , user);
			}
		@Test
		public void testpath_t_14() {
			String user = UriParserFactory.create("http:///%c8").parse().getPath();
			assertEquals("/%c8" , user);
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_1() {
			fail(UriParserFactory.create("http:/// ").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_2() {
			fail(UriParserFactory.create("http:///@").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_3() {
			fail(UriParserFactory.create("http:///#").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_4() {
			fail(UriParserFactory.create("http:///#h").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_5() {
			fail(UriParserFactory.create("http:/// H").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_6() {
			fail(UriParserFactory.create("http:/// 9").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_7() {
			fail(UriParserFactory.create("http:///%5").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_8() {
			fail(UriParserFactory.create("http:///%f").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_9() {
			fail(UriParserFactory.create("http:///%%").parse().getPath());
			}
		
		@Test(expected=NullPointerException.class)
		public void testpath_f_11() {
			fail(UriParserFactory.create("http:///%hgc").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_12() {
			fail(UriParserFactory.create("http:///%5RZ").parse().getPath());
			}
		@Test(expected=NullPointerException.class)
		public void testpath_f_13() {
			fail(UriParserFactory.create("http:///%zm").parse().getPath());
			}
//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		@Test
		public void testquery_t_1() {
			String user = UriParserFactory.create("http://?X").parse().getQuery();
			assertEquals("X" , user);
			}
		@Test
		public void testquery_t_2() {
			String user = UriParserFactory.create("http://?x").parse().getQuery();
			assertEquals("x" , user);
			}
		@Test
		public void testquery_t_3() {
			String user = UriParserFactory.create("http://?9").parse().getQuery();
			assertEquals("9" , user);
			}
		@Test
		public void testquery_t_4() {
			String user = UriParserFactory.create("http://?.").parse().getQuery();
			assertEquals("." , user);
			}
		@Test
		public void testquery_t_5() {
			String user = UriParserFactory.create("http://?%9F").parse().getQuery();
			assertEquals("%9F" , user);
			}
		@Test
		public void testquery_t_6() {
			String user = UriParserFactory.create("http://?%9d").parse().getQuery();
			assertEquals("%9d" , user);
			}
		@Test
		public void testquery_t_7() {
			String user = UriParserFactory.create("http://?%98").parse().getQuery();
			assertEquals("%98" , user);
			}
		@Test
		public void testquery_t_8() {
			String user = UriParserFactory.create("http://?%FF").parse().getQuery();
			assertEquals("%FF" , user);
			}
		@Test
		public void testquery_t_9() {
			String user = UriParserFactory.create("http://?%Fd").parse().getQuery();
			assertEquals("%Fd" , user);
			}
		@Test
		public void testquery_t_10() {
			String user = UriParserFactory.create("http://?%F9").parse().getQuery();
			assertEquals("%F9" , user);
			}
		@Test
		public void testquery_t_11() {
			String user = UriParserFactory.create("http:///?%cF").parse().getQuery();
			assertEquals("%cF" , user);
			}
		@Test
		public void testquery_t_12() {
			String user = UriParserFactory.create("http://?%cf").parse().getQuery();
			assertEquals("%cf" , user);
			}
		@Test
		public void testquery_t_13() {
			String user = UriParserFactory.create("http://?%c8").parse().getQuery();
			assertEquals("%c8" , user);
			}
		@Test
		public void testquery_t_14() {
			String user = UriParserFactory.create("http://?&").parse().getQuery();
			assertEquals("&" , user);
			}
		@Test
		public void testquery_t_15() {
			String user = UriParserFactory.create("http://?=").parse().getQuery();
			assertEquals("=" , user);
			}
		@Test
		public void testquery_t_155() {
			String user = UriParserFactory.create("http://?&=").parse().getQuery();
			assertEquals("&=" , user);
			}
		@Test
		public void testquery_t_17() {
			String user = UriParserFactory.create("http://?&X").parse().getQuery();
			assertEquals("&X" , user);
			}
		@Test
		public void testquery_t_177() {
			String user = UriParserFactory.create("http://?&X=").parse().getQuery();
			assertEquals("&X=" , user);
			}
		@Test
		public void testquery_t_18() {
			String user = UriParserFactory.create("http://?x&").parse().getQuery();
			assertEquals("x&" , user);
			}
		@Test
		public void testquery_t_188() {
			String user = UriParserFactory.create("http://?=x&").parse().getQuery();
			assertEquals("=x&" , user);
			}
		@Test
		public void testquery_t_19() {
			String user = UriParserFactory.create("http://?9=").parse().getQuery();
			assertEquals("9=" , user);
			}
		@Test
		public void testquery_t_199() {
			String user = UriParserFactory.create("http://?&9=").parse().getQuery();
			assertEquals("&9=" , user);
			}
		@Test
		public void testquery_t_20() {
			String user = UriParserFactory.create("http://?.&").parse().getQuery();
			assertEquals(".&" , user);
			}
		@Test
		public void testquery_t_21() {
			String user = UriParserFactory.create("http://?%9F=").parse().getQuery();
			assertEquals("%9F=" , user);
			}
		@Test
		public void testquery_t_22() {
			String user = UriParserFactory.create("http://?&%9c").parse().getQuery();
			assertEquals("&%9c" , user);
			}
		@Test
		public void testquery_t_23() {
			String user = UriParserFactory.create("http://?%98=").parse().getQuery();
			assertEquals("%98=" , user);
			}
		@Test
		public void testquery_t_24() {
			String user = UriParserFactory.create("http://?&%FF").parse().getQuery();
			assertEquals("&%FF" , user);
			}
		@Test
		public void testquery_t_25() {
			String user = UriParserFactory.create("http://?%Fa=").parse().getQuery();
			assertEquals("%Fa=" , user);
			}
		@Test
		public void testquery_t_26() {
			String user = UriParserFactory.create("http://?&%F9").parse().getQuery();
			assertEquals("&%F9" , user);
			}
		@Test
		public void testquery_t_27() {
			String user = UriParserFactory.create("http:///?=%aF").parse().getQuery();
			assertEquals("=%aF" , user);
			}
		@Test
		public void testquery_t_28() {
			String user = UriParserFactory.create("http://?%af&").parse().getQuery();
			assertEquals("%af&" , user);
			}
		@Test
		public void testquery_t_29() {
			String user = UriParserFactory.create("http://?&=%b8").parse().getQuery();
			assertEquals("&=%b8" , user);
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_0() {
			fail(UriParserFactory.create("http://?%5").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_1() {
			fail(UriParserFactory.create("http://?%f").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_2() {
			fail(UriParserFactory.create("http://?%%").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_3() {
			fail(UriParserFactory.create("http://?%55 5").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_4() {
			fail(UriParserFactory.create("http://?%hg c").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_5() {
			fail(UriParserFactory.create("http://?%5R").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_6() {
			fail(UriParserFactory.create("http://?%zm").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_7() {
			fail(UriParserFactory.create("http://?& &").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_9() {
			fail(UriParserFactory.create("http://? ").parse().getQuery());
			}
		/*@Test(expected=NullPointerException.class)
		public void testquery_f_10() {
			fail(UriParserFactory.create("http://? %5c").parse().getQuery());
			}*/
		/*@Test(expected=NullPointerException.class)
		public void testquery_f_11() {
			fail(UriParserFactory.create("http://?!X").parse().getQuery());
			}*/
		@Test(expected=NullPointerException.class)
		public void testquery_f_12() {
			fail(UriParserFactory.create("http://? c").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_13() {
			fail(UriParserFactory.create("http://?.&$").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_14() {
			fail(UriParserFactory.create("http://&%#5c").parse().getQuery());
			}
		@Test(expected=NullPointerException.class)
		public void testquery_f_15() {
			fail(UriParserFactory.create("http://4=").parse().getQuery());
			}
}
		
		
