package museumassault;

/**
 *
 * @author Andr�
 */
public class MuseumAssault
{
    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SharedSite exterior = new SharedSite(4);

        Chief chief = new Chief(exterior);
        chief.start();

        Thief[] thiefs = new Thief[10];

        for (int x = 0; x < 10; x++) {
            Thief thief = new Thief(x + 1, exterior);
            thiefs[x] = thief;
            thief.start();
        }

        try {
            chief.join();
        } catch (InterruptedException e) {}

        for (int x = 0; x < 10; x++) {
            thiefs[x].interrupt();
        }

        System.out.println("End");
    }
}
