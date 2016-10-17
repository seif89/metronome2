package observercmd;
import java.util.ArrayList;
import java.util.Collection;

public class ConcreteSubjectCmd<V> implements MoteurCmd<V> {
	private Collection<Composant> observers;
	private V value;
	
	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
		notifyObservers();
	}

	public ConcreteSubjectCmd() {
		observers = new ArrayList<Composant>();
	}
	
	@Override
	public void attach(Composant c) {
		observers.add(c);
	}

	@Override
	public void detach(Composant c) {
		observers.remove(c);
	}

	private void notifyObservers() {
		// L'opération notify est déjà définie dans Object
		for(Composant c : observers) {
			Commande cmd = c.getCommande("update");
			if(cmd != null) cmd.executer(this);
		}
	}

	@Override
	public boolean isAttached(Composant c) {
		return observers.contains(c);
	}
}
