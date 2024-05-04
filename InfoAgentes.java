import jade.core.Agent;
import jade.core.AID;
import jade.util.leap.Iterator;

public class InfoAgentes extends Agent {

    protected void setup(){

        System.out.println("Hello World. Eu SOU UM AGENTE!");
        System.out.println("Todas as minhas informações : \n" + getAID());
        System.out.println("Meu nome local é " + getAID().getLocalName());
        System.out.println("Meu nome global (GUID) é " + getAID().getName());
        System.out.println("Meus endereços são:");
        Iterator it = getAID().getAllAddresses();
        while(it.hasNext()){
            System.out.println("- "+it.next());
        }
    }
}