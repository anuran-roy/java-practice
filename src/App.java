public class App {
    public static void main(String[] args) throws Exception {
        Controller c1 = new Controller();
        c1.start();
        Controller c2 = new Controller();
        c2.start();
        Controller c3 = new Controller();
        c3.start();

        AltController ac1 = new AltController();
        Thread t1 = new Thread(ac1);

        AltController ac2 = new AltController();
        Thread t2 = new Thread(ac2);

        AltController ac3 = new AltController();
        Thread t3 = new Thread(ac3);

        t1.start();
        t2.start();
        t3.start();
    }
}
