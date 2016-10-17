package observercmd;

public class AfficheurCmd extends ComposantSimple {
	private String texte;
	
	public AfficheurCmd() {
		setCommand("update", new Commande() {
			public void executer(Object p) {
				setTexte((String) p);
			}
		});
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

}
