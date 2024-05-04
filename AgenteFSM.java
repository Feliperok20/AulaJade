import jade.core.Agent;
import jade.core.behaviours.*;


public class AgenteFSM extends Agent{
    protected void setup(){
        FSMBehaviour compFSM = new FSMBehaviour(this){
            public int onEnd(){
                System.out.println("AComportamento FSM finalizado com sucesso!");
                return 0;
            }
        };

        compFSM.registerFirstState(new OneShotBehaviour(this){

            int c=0;
            public void action() {
                System.out.println("Executando Comportamento X");
                c++;
            }
            public int onEnd() {
                return (c > 4 ? 1 : 0);
            }
        }, "X");

        compFSM.registerState(new OneShotBehaviour(this){

            public void action(){
                System.out.println("Executando Comportamento Z");
            }
            public int onEnd(){
                return 2;
            }
        }, "Z");

        compFSM.registerLastState(new OneShotBehaviour(this){

            public void action(){
                System.out.println("Executando meu ultimo comportamento.");
            }

        }, "Y");

        compFSM.registerTransition("X","Z", 0 );
        compFSM.registerTransition("X","Y", 1 );

        compFSM.registerDefaultTransition("Z","X",new String[] {"X","Z"});

        compFSM.registerTransition("Z","X",2);

        addBehaviour(compFSM);
    }
}
