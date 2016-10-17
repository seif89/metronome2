package observercmd;

public interface Composant {

	public Commande getCommande(String cle);
	
	public void setCommand(String cle, Commande c);
	
}
