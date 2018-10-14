package by.training.zorich.storage.event;

public interface EventPublisher {
	void subscribe(EventListener eventListener);

	void unsubscribe(EventListener eventListener);

	void notifySubscribers(EventArg eventArg);
}
