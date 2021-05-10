package examples.MLR;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


import jade.core.Agent;
import jade.core.behaviours.*;
import jade.core.AID;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

/**
  @author Alicia Serna
 */

 public class MLRAgent extends Agent{

    public static double[][] dataSet;
    public static double beta0;
    private static double beta1;
    private static double beta2; 

    private MLRGui myGui;
    protected void setup(){

        dataSet = null;
        beta0 = 0.0;
        beta1 = 0.0;
        beta2 = 0.0;

        myGui = new MLRGui(this);
        myGui.showGui();
    
        DFAgentDescription dfd = new DFAgentDescription();
            dfd.setName(getAID());
            ServiceDescription sd = new ServiceDescription();
            sd.setType("Multiple Linear Regression");
            sd.setName("JADE-MLR");
            dfd.addServices(sd);
    
        try {
                DFService.register(this, dfd);
            }
            catch (FIPAException fe) {
                fe.printStackTrace();
            }
        }

        protected void takeDown() {
            // Deregister from the yellow pages
            try {
                DFService.deregister(this);
            }
            catch (FIPAException fe) {
                fe.printStackTrace();
            }
            // Close the GUI
            myGui.dispose();
            // Printout a dismissal message
            System.out.println("MLR-agent "+getAID().getName()+" terminating.");
        }
        
        public void requestX1(String[] x){
            addBehaviour(new OneShotBehaviour() {
                public void action() {
                    MLRClass objMLR = new MLRClass(); 
                    objMLR.print(x);

                    System.out.println("(" + x[0] + ", " + x[1] + "): " + (beta0 + Double.parseDouble(x[0]) * beta1 + Double.parseDouble(x[1]) * beta2));
                    /*SPM example = new SPM("Scatter Chart Example | BORAJI.COM");
                    example.setSize(800, 400);
                    example.setLocationRelativeTo(null);
                    example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                    example.setVisible(true);*/
                }
    
            } );
            myGui.dispose();
            this.doDelete();
        }

        
     }