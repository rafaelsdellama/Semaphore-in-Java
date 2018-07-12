
/**
 *
 * @author marianabm
 */
public class Semaphore {
    
    private int permits;
    
    public Semaphore(int permits) {
        this.permits = permits;
    }
    
    synchronized public void down() {        
        while (permits == 0) {
            try {
                wait(); // Blocking call.
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
        permits--;
    }
    
    synchronized public void up() {  
        permits++;
        notify();

    }
}
