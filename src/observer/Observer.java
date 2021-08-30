package observer;

public interface Observer {
	void notifyOfThreadComplete(final NotifyingThread thread);
}
