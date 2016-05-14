
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements KeyListener{
	Canvas canvas = new Canvas();
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}
	public static void main(String[] args) {
		new MyFrame();

	}

	public MyFrame() throws HeadlessException {
		super("This is my frame");
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(canvas);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		addKeyListener(this);
		getContentPane().add(panel, BorderLayout.NORTH);
		new MyThread(canvas).start();
		pack();
	}
	
//	@Override
//	public void keyPerformed(KeyEvent ev) {
//		if (ev.getSource() == combo ) {
//			if (combo.getSelectedItem().equals("yellow"))
//				canvas.circleColor = Color.orange; //gia na fainetai kalytera to ekana portokali
//			else canvas.circleColor = Color.green;
//			canvas.repaint();
//		}
//		else {
//			if (! txtf.getText().equals(""))
//				canvas.radius =  Integer.parseInt(txtf.getText());
//		}
//	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if (arg0.getKeyChar()=='r') {
			canvas.circleColor = Color.red;
			canvas.repaint();
		}
		else if (arg0.getKeyChar()=='y') {
			canvas.circleColor = Color.yellow;
			canvas.repaint();
		}
		else {
			canvas.circleColor = Color.blue;
			canvas.repaint();
		}
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
