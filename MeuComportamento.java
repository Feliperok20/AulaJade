import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class MeuComportamento extends Behaviour{
    int i=0;
    public MeuComportamento(Agent a ) {
        super(a);
    }
    public void action() {
        System.out.println("* Olá Mundo! ... Meu Nome é  " + myAgent.getLocalName());
        i=i+1;
    }
    public boolean done() {
        return i>3;
    }
}
