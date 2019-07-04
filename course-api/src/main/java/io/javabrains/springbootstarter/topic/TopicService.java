package io.javabrains.springbootstarter.topic;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class TopicService {
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "java framework", "description"),
			new Topic("django", "python framework", "description")
			));
	
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		for(int i=0; i<topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}

	public void deleteTopic(String id, Topic topic) {
		topics.removeIf(t -> t.getId().equals(id));		
	}
}
