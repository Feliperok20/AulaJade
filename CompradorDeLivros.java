import jade.core.Agent;
import jade.core.AID;


public class CompradorDeLivros extends Agent {

    private String livrosComprar;

    protected void setup() {
        System.out.println("Olá!  Eu sou o Agente Comprador " + getLocalName() + " e estou pronto para comprar!");
        Object[] args = getArguments();
        if (args != null && args.length > 0) {
            livrosComprar = (String) args[0];
            System.out.println("Pretendo comprar o Livro: " + livrosComprar);
        }else{
            System.out.println("Não tenho livro para comprar!");
            doDelete();
        }
    }
    protected void takeDown(){
        System.out.println(" Agente Comprador " + getAID().getName() + " Está Finalizado " );
    }
}
