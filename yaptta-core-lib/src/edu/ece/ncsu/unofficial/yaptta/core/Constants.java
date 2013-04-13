package edu.ece.ncsu.unofficial.yaptta.core;

public class Constants {
	
	public static class Network
	{
		// Traffic classes from IPv4 standard
		public static final int IPTOS_LOWCOST = 0x02; 
		public static final int IPTOS_RELIABILITY = 0x04; 
		public static final int IPTOS_THROUGHPUT = 0x08; 
		public static final int IPTOS_LOWDELAY = 0x10;
		
		public static final int BROADCAST_PORT = 28000;
		public static final int GROUP_PORT_BASE = 28001;
		public static final int UNICAST_PORT = 27000;
		public static final String MULTICAST_ADDRESS = "224.27.69.5";
		
		public static final int DEFAULT_PACKET_BUFFER_SIZE = 10240; // in bytes
		
		public static final int BLOCKING_TIMEOUT = 100; // in milliseconds
	}

}
