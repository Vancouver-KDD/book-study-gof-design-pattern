package leetcode.chainOfResponsibility;


// chain or responsibility pattern connect multiple object 
// at the end of chain, the goal object is created
public class ChanOfResponsibility {
    public class Main {
        public static void main(String[] args) {
    
            Support alice = new NoSupport("Alice");
            Support bob = new LimitSupport("Bob", 100);
            Support charlie = new SpecialSupport("Charlie", 429);
            Support diana = new LimitSupport("Diana", 200);
            Support elmo = new OddSupport("Elmo");
    
            alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo);
    
            // 다양한 문제 발생
            for (int i = 0; i < 500; i += 33) {
                alice.support(new Trouble(i));
            }
        }
    }
}
