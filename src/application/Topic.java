package application;
public class Topic {
	private String TopicName;

	public Topic(String topicName) {
		super();

		TopicName = topicName;
	}

	@Override
	public String toString() {
		return "Topic{" +
				"TopicName='" + TopicName + '\'' +
				'}';
	}

	public String getTopicName() {
		return TopicName;
	}
	
}
