package edu.ece.ncsu.unofficial.yaptta.core.callbacks;

import edu.ece.ncsu.unofficial.yaptta.core.YapttaState;
import edu.ece.ncsu.unofficial.yaptta.core.conduits.ConduitException;
import edu.ece.ncsu.unofficial.yaptta.core.conduits.MulticastConduit;
import edu.ece.ncsu.unofficial.yaptta.core.messages.AbstractMessage;
import edu.ece.ncsu.unofficial.yaptta.core.messages.requests.GroupListRequest;
import edu.ece.ncsu.unofficial.yaptta.core.messages.requests.PeersRequest;
import edu.ece.ncsu.unofficial.yaptta.core.messages.requests.PingRequest;
import edu.ece.ncsu.unofficial.yaptta.core.messages.requests.RequestGroupsRequest;
import edu.ece.ncsu.unofficial.yaptta.core.messages.requests.UpdatePeerRequest;
import edu.ece.ncsu.unofficial.yaptta.core.messages.responses.RequestGroupsResponse;

public class CoreServiceCallback implements edu.ece.ncsu.unofficial.yaptta.core.callbacks.IMessageReceivedCallback {

	private MulticastConduit coreConduitRef = null;
	
	public CoreServiceCallback(MulticastConduit ref) {
		this.coreConduitRef = ref;
	}
	
	@Override
	public void messageReceived(AbstractMessage message) {
		
		// Filter the message through the following sieve to act on it appropriately
		if(false) {}
		
		// Generic requests
		else if(PingRequest.class.isInstance(message)) processPingRequest(message);
		
		// Group and peer handling
		else if(PeersRequest.class.isInstance(message)) processPeersRequest(message);
		else if(UpdatePeerRequest.class.isInstance(message)) processUpdatePeerRequest(message);
		else if(RequestGroupsRequest.class.isInstance(message)) processRequestGroupsRequest(message);
		else if(RequestGroupsResponse.class.isInstance(message)) processRequestGroupsResponse((RequestGroupsResponse)message);
		
//		
//		String filler;
//		if(PingRequest.class.isInstance(response)) {
//			filler = ((PingRequest)response).getText();
//		} else {
//			filler = response.getClass().getCanonicalName();
//		}
//		
//		final String msg = "Received: " + filler;
//		toastHandler.post(new Runnable(){public void run(){Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();}});
	}

	private void processRequestGroupsRequest(AbstractMessage response) {
		// If this device is hosting a group, respond back with the necessary info
		if(YapttaState.isGroupMaster() && YapttaState.isInGroup()) {
			RequestGroupsResponse rgr = new RequestGroupsResponse();
			rgr.setGroupName(YapttaState.getGroupName());
			rgr.setPort(YapttaState.getGroupConduit().getPort());
			rgr.setPrivate(YapttaState.isGroupPrivate());
			try {
				this.coreConduitRef.sendMessage(rgr);
			} catch (ConduitException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void processRequestGroupsResponse(RequestGroupsResponse response) {
		YapttaState.addKnownGroup(response.getGroupName(), response.getPort(), response.isPrivate());
	}

	private void processUpdatePeerRequest(AbstractMessage response) {
		// TODO Auto-generated method stub
		
	}

	private void processPeersRequest(AbstractMessage response) {
		// TODO Auto-generated method stub
		
	}

	private void processPingRequest(AbstractMessage m) {
		
	}

}