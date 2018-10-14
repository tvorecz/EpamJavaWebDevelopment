package by.training.zorich.storage.event;

import by.training.zorich.storage.event.arg.EventArg;

public interface EventPublisher {
	void subscribe(EventListener eventListener, EventType eventType);

	void unsubscribe(EventListener eventListener, EventType eventType);

	void notifySubscribers(EventArg eventArg);
}
