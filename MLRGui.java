package examples.MLR;

import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
  @author Alicia Serna
 */

class MLRGui extends JFrame {	
	private MLRAgent agent;
    private JTextField x1;
    private JTextField x2;
    private String [] arreglo;

    MLRGui(MLRAgent a){
        super(a.getLocalName());

        agent = a;
        arreglo = new String[2];

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2,2));
        p.add(new JLabel("valor de x1"));
        x1 = new JTextField(15);
        p.add(x1);
        p.setLayout(new GridLayout(2,2));
        p.add(new JLabel("valor de x2:"));
        x2 = new JTextField(15);
        p.add(x2);
        getContentPane().add(p, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Agregar");
        btnAdd.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
                System.out.println("Entro 1");
				try {
                    String newx1 = x1.getText().trim();
                    String newx2 = x2.getText().trim();
                    arreglo [0] = newx1;
                    System.out.println("Entro 2");
                    arreglo [1] = newx2;
					
					agent.requestX1(arreglo);
                    x1.setText("");
                    x2.setText("");
				}
				catch (Exception e) {
                    System.out.println("El error fue "+e.getMessage());
				}
            }
		} );
		p = new JPanel();
		p.add(btnAdd);
        getContentPane().add(p, BorderLayout.SOUTH);
        
        addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				agent.doDelete();
			}
		} );
		
		setResizable(false);
	}
    public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}
}	