package observer;

import java.util.ArrayList;
import java.util.Collection;

public class ConcreteSubject<V> implements Moteur<V> {
	private Collection<Observer<V>> observers;
	private V value;
	
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
		notifyObservers();
	}

	public ConcreteSubject() {
		observers = new ArrayList<Observer<V>>();
	}
	
	@Override
	public void attach(Observer<V> o) {
		observers.add(o);
	}

	@Override
	public void detach(Observer<V> o) {
		observers.remove(o);
	}

	private void notifyObservers() {
		// L'opération notify est déjà définie dans Object
		for(Observer<V> o : observers) {
			o.update(this);
		}
	}

	@Override
	public boolean isAttached(Observer<V> o) {
		return observers.contains(o);
	}
}
