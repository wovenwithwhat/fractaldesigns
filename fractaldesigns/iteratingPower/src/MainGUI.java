import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI extends JComponent{

	private static class Line{
	    final int x1; 
	    final int y1;
	    final int x2;
	    final int y2;   
	    final Color color;

	    public Line(int x1, int y1, int x2, int y2, Color color) {
	        this.x1 = x1;
	        this.y1 = y1;
	        this.x2 = x2;
	        this.y2 = y2;
	        this.color = color;
	    }               
	}

	private final LinkedList<Line> lines = new LinkedList<Line>();

	public void addLine(int x1, int x2, int x3, int x4) {
	    addLine(x1, x2, x3, x4, Color.black);
	}

	public void addLine(int x1, int x2, int x3, int x4, Color color) {
	    lines.add(new Line(x1,x2,x3,x4, color));        
	    repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    for (Line line : lines) {
	        g.setColor(line.color);
	        g.drawLine(line.x1, line.y1, line.x2, line.y2);
	    }
	}
	
	//255*i/h on all is black and white, 255-... is opposite
	//(255*h/(i+1))%255 ? something idk
	//rings is i%255
	
	/*
	 * i: number line
	 * h: how many lines
	 * */ 
	private static int red(int i, int h){
		return 255-255*i/h;
	}
	private static int green(int i, int h){
		return 255-255*i/h;
	}
	private static int blue(int i, int h){
		return 255-255*i/h;
	}

	public static void main(String[] args) {
	    JFrame testFrame = new JFrame();
	    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    final MainGUI comp = new MainGUI();
	    
	    double xWidth = 600;
	    double yWidth = 600;
	   
	    comp.setPreferredSize(new Dimension((int)xWidth, (int)yWidth));
	    testFrame.getContentPane().add(comp, BorderLayout.CENTER);
	    
	    //2^fact, any number should work according to python script
	    int fact = 11;
	    int h = (int)Math.pow(2, fact);
	    
	    iteratingPower itpo = new iteratingPower();
	    
	    itpo.setNodes(h);
	    int placeholder[] = itpo.getSpiralList();
	    
	    for(int i = 0; i < placeholder.length -1; i++){
	    	comp.addLine((int)(itpo.nodeToX(placeholder[i]) * xWidth), (int)(itpo.nodeToY(placeholder[i]) * yWidth), 
	    			(int)(itpo.nodeToX(placeholder[i + 1]) * xWidth), (int)(itpo.nodeToY(placeholder[i + 1]) * yWidth),
	    			new Color(red(i,h), green(i,h), blue(i,h)));
	    }
	    
	    testFrame.pack();
	    testFrame.setVisible(true);
	}
}
