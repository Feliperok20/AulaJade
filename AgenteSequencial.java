import jade.core.Agent;
import jade.core.behaviours.*;


public class AgenteSequencial extends Agent {
    protected void setup() {
        System.out.println("Ola! Meu nome e " + getLocalName());
        System.out.println("Vou executar tres comportamentos: ");

        SequentialBehaviour comportamento = new SequentialBehaviour(this){
            public int onEnd(){
                myAgent.doDelete();
                return 0;
            }
        };
        comportamento.addSubBehaviour(new WakerBehaviour(this, 500) {
            long t0 = System.currentTimeMillis();
            protected void onWake(){
                System.out.println((System.currentTimeMillis()-t0) +
                        ": Executei meu primeiro comportamento apos meio segundo!");
            }
        });
        comportamento.addSubBehaviour(new OneShotBehaviour(this) {
            public void action() {
                System.out.println(": Executei meu segundo comportamento!");
            }
        });
        comportamento.addSubBehaviour(new TickerBehaviour(this,700) {
            int execc=0;
            long t1 = System.currentTimeMillis();
            protected void onTick(){
                if(execc==3)stop();
                else {
                    System.out.println((System.currentTimeMillis()-t1) + ": Estou executando meu terceiro comportamento");
                    execc++;
                }
            }
        });
        addBehaviour(comportamento);
    }
    protected void takeDown() {
        System.out.println("Fui finalizado com sucesso!!");
    }
}
