package V1;
import observer.Observer;


/**
 * 
 */
public interface Moteur {

    /**
     * 
     */
    public void attach(Observer o);

    /**
     * 
     */
    public void dettach(Observer o);

}