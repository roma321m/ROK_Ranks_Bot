package observer;

import observer.Observer;

public abstract class NotifyingThread extends Thread implements Observable {

	private Observer listener;

	public final void setListener(final Observer listener) {
		this.listener = listener;
	}
	
	public void removeListener() {
		this.listener = null;
	}

	public final void notifyListener() {
		listener.notifyOfThreadComplete(this);
	}

	@Override
	public final void run() {
		try {
			doRun();
		} finally {
			notifyListener();
		}
	}

	public abstract void doRun();
}
