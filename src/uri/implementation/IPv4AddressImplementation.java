package uri.implementation;

import uri.IPv4Address;

// TODO implement this class or another Implementation of IPv4Address
public class IPv4AddressImplementation extends HostImplementation implements IPv4Address {

	
	public IPv4AddressImplementation(String host) {
		super(host);
		// TODO implement this
	}

	@Override
	public byte[] getOctets() {
		String host = super.host ;
		int i = 0 ;
		byte [] bb = new byte[4];
		String[] ss = host.split("\\.") ;
		for ( ; i < 4 ; i++) {
			bb[i] = (byte) Integer.parseUnsignedInt(ss[i]) ;
			i++ ;
		}
		return bb ;
	}

	@Override
	public String toString() {
		// TODO implement this
		return null;
	}
 
}
