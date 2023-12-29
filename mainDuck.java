abstract class Duck {
    private void swim() {
        System.out.println("Duck is swimming");
    }
    abstract void display();
}

interface Flyable{
    void fly();
}

interface Quackable{
    void quack();
}






class MallardDuck extends Duck implements Flyable,Quackable{
    public void display() {
        System.out.println("MallardDuck is displaying");
    }
    public void fly() {
        System.out.println("MallardDuck is flying");
    }
    public void quack() {
        System.out.println("MallardDuck is quacking");
    }

}

class RubberDuck extends Duck implements Quackable{
    void display() {
        System.out.println("RubberDuck is displaying");
    }
    public void quack() {
        System.out.println("RubberDuck is quacking");
    }
}


class RedHeadDuck extends Duck implements Flyable,Quackable{
    void display() {
        System.out.println("RedHeadDuck is displaying");
    }
    public void fly() {
        System.out.println("RedHeadDuck is flying");
    }
    public void quack() {
        System.out.println("RedHeadDuck is quacking");
    }
}



class DecoyDuck extends Duck{
    void display() {
        System.out.println("DecoyDuck is displaying");
    }
}

public class mainDuck{
    

public static void main(String args[]){
    Duck mallardDuck = new MallardDuck();
    Duck rubberDuck = new RubberDuck();
    Duck redHeadDuck = new RedHeadDuck();
    Duck decoyDuck = new DecoyDuck();

    ((MallardDuck)mallardDuck).display();
    ((MallardDuck)mallardDuck).fly();
    ((MallardDuck)mallardDuck).quack();

    ((RubberDuck)rubberDuck).display();
    ((RubberDuck)rubberDuck).quack();

    ((RedHeadDuck)redHeadDuck).display();
    ((RedHeadDuck)redHeadDuck).fly();
    ((RedHeadDuck)redHeadDuck).quack();

    ((DecoyDuck)decoyDuck).display();
}
}