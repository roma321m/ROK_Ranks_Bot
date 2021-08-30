package observer;

public interface Observable {

	void setListener(final Observer listener);

	void removeListener();

	void notifyListener();
}
