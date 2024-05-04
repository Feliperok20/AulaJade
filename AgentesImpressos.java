import jade.core.Agent;
import jade.core.behaviours.Behaviour;


public class AgentesImpressos extends Agent {
    protected void setup() {
        System.out.println("Olá! Eu sou um agente impresso!");
        System.out.println("# Vou executar meu comportamento");
        addBehaviour(new ImprimeFrase(this, 5000));
    }
}
