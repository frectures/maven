public class Greeter {
    private final String who;

    public Greeter(String who) {
        this.who = who;
    }

    public void say(String what) {
        System.out.println(who + " says: " + what);
    }
}
