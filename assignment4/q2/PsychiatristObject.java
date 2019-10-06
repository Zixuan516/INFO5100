package assignment4.q2;

public class PsychiatristObject {

    public void examine(MoodyObject moodyObject) {
        System.out.println("How are you feeling today?");
        System.out.println("I feel " + moodyObject.getMood() + " today!");
        System.out.println("");
    }

    public void observe(MoodyObject moodyObject) {
        moodyObject.expressFeelings();
        System.out.println("Observation: " + moodyObject.toString());
        System.out.println("");
    }

    public static void main(String[] args){
        PsychiatristObject p = new PsychiatristObject();
        MoodyObject sad = new SadObject();
        MoodyObject happy = new HappyObject();
        p.examine(happy);
        p.observe(happy);
        p.examine(sad);
        p.observe(sad);
    }
}
