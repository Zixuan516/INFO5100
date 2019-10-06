package assignment4.q2;

public class HappyObject extends MoodyObject {

    @Override
    protected String getMood() {
        return "happy";
    }

    @Override
    public void expressFeelings() {
        System.out.println("hehehe...hahahah...HAHAHAHAHA!!!");
    }

    @Override
    public String toString() {
        return "Subject laughs a lot";
    }
}
