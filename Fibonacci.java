import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Fibonacci extends JFrame implements ActionListener{
	JTextField textfield;
	JButton button;
	JLabel answer;
	
	public Fibonacci(){
		this.setTitle("Välkommen till Fibonacci-testaren!");
		this.setLayout(new FlowLayout());
		this.setSize(420,100);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		textfield = new JTextField("Skriv in det tal du vill testa...");
		textfield.setPreferredSize(new Dimension(200,20));
		this.add(textfield);
		
		button = new JButton("Testa!");
		button.addActionListener(this);
		this.add(button);
		
		answer = new JLabel();
		this.add(answer);
		
		this.setVisible(true);
	}
	
	private static boolean isFibonacci(int num){
		int testNum1 = 5*num*num + 4;
		int testNum2 = 5*num*num - 4;
		
		if((Math.sqrt(testNum1) % 1) == 0  || (Math.sqrt(testNum2) % 1) == 0){
			return true;
		}
		else return false;
	}
	
	public static void main(String[] args) {
		new Fibonacci();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button){
			String inputString = textfield.getText();
			try{
				int inputInt = Integer.parseInt(inputString);
				if(isFibonacci(inputInt)){
					answer.setText(inputInt + " är ett Fibonacci-tal.");
				}
				else{
					answer.setText(inputInt + " är ej ett Fibonacci-tal.");
				}
				
			}
			catch(NumberFormatException ee){
				answer.setText("Ange ett giltigt heltal!");
			}
		}
	}
}
