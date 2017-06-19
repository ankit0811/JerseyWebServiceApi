package org.ank.messenger.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.ank.messenger.database.DatabaseClass;
import org.ank.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages=DatabaseClass.getMessages();
	
	public MessageService(){
		messages.put(1L, new Message(1L, "Hello World", "user1"));
		messages.put(2L, new Message(2L, "Hello Jersey", "user2"));
	}
	
	public List<Message> getAllMessages(){
		/*Message m1=new Message(1L, "Hellow World", "user1");
		Message m2=new Message(2L, "Hellow Jersey", "user2");
		
		List<Message> returnList=new ArrayList<>();
		returnList.add(m1);
		returnList.add(m2);
		
		return returnList;*/
		return new ArrayList<Message>(messages.values());
		
		
		
	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message m){
		m.setId(messages.size() + 1);
		messages.put(m.getId(), m);
		return m;
	}
	
	public Message updateMessage(Message m){
		if (m.getId() <= 0)
			return null;
		messages.put(m.getId(), m);
		return m;
	}
	
	public Message deleteMessage(long id){
		return messages.remove(id);
	}
}
