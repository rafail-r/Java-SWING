

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

public class Canvas extends JLabel implements MouseListener{
	public int radius=10;
	public Color circleColor = Color.orange;
	public List<Circle> allMyCircles;

	public Canvas() {
		setPreferredSize(new Dimension(500,500));
		addMouseListener(this);
		setOpaque(true);
		this.setBackground(Color.black);
		allMyCircles = new ArrayList<Circle>();
	}

	public void paint(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, 500, 500);
		for ( Circle circ :allMyCircles) {
			g.setColor(circleColor);
			g.drawOval(circ.x-circ.rad, circ.y-circ.rad, 2*circ.rad, 2*circ.rad);
		}
	}
	@Override
	public void mouseClicked(MouseEvent ev) {
		Circle temp = new Circle(ev.getX(), ev.getY(),this.radius);
		allMyCircles.add(temp);
		repaint();
		new MyOtherThread(allMyCircles, allMyCircles.size()-1, this).start();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
