// Fig. 18.18 Fractal.java
// Fractal user interface
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;

public class Fractal extends JFrame
{
	private static final int WIDTH = 400;	// define GUI width
	private static final int HEIGHT = 480;	// define GUI height
	private static final int MIN_LEVEL = 0;
	private static final int MAX_LEVEL = 15;
	
	// set up GUI
	public Fractal()
	{
		super("Fractal");
		
		// set up levelJLabel to add to controlJPanel
		final JLabel levelJLabel = new JLabel("Level: 0");
		
		final FractalJPanel drawSpace = new FractalJPanel(0);
		
		// set up control panel
		final JPanel controlJPanel = new JPanel();
		controlJPanel.setLayout(new FlowLayout());
		
		// set up color button and register listener
		final JButton changeColorJButton = new JButton("Color");
		controlJPanel.add(changeColorJButton);
		changeColorJButton.addActionListener(
			new ActionListener()	// anonymous inner class
			{
				// process changeColorJButton event
				@Override
				public void actionPerformed(ActionEvent event)
				{
					Color color = JColorChooser.showDialog(Fractal.this, "Choose a color", Color.BLUE);
					
					// set default color, if no color is returned
					if(color == null)
						color = Color.BLUE;
					
					drawSpace.setColor(color);
				}
			}	// end anonymous inner class
		);	// end addActionListener
		
		// set up decrease level button to add to control panel and register listener
		final JButton decreaseLevelJButton = new JButton("Decrease Level");
		controlJPanel.add(decreaseLevelJButton);
		decreaseLevelJButton.addActionListener(
			new ActionListener()	// anonymous inner class
			{
				// process decreaseJLevelButton event
				@Override
				public void actionPerformed(ActionEvent event)
				{
					int level = drawSpace.getLevel();
					--level;
					
					// modify level if possible
					if((level >= MIN_LEVEL) && (level <= MAX_LEVEL))
					{
						levelJLabel.setText("Level: " + level);
						drawSpace.setLevel(level);
						repaint();
					}
				}
			}	// end anonymous inner class
		);	// end addActionListener
		
		// set up increase level button to add to control panel and register listener
		final JButton increaseLevelJButton = new JButton("Increase Level");
		controlJPanel.add(increaseLevelJButton);
		increaseLevelJButton.addActionListener(
			new ActionListener()	// anonymous inner class
			{
				// process increaseJLevelButton event 
				@Override
				public void actionPerformed(ActionEvent event)
				{
					int level = drawSpace.getLevel();
					++level;
					
					// modfiy level if possible
					if((level >= MIN_LEVEL) && (level <= MAX_LEVEL))
					{
						levelJLabel.setText("Level: " + level);
						drawSpace.setLevel(level);
						repaint();
					}
				}
			}	// end anonymous inner class
		);	// end addActionListener
		
		controlJPanel.add(levelJLabel);
		
		// create mainJPanel to contain controlJPanel and drawSpace
		final JPanel mainJPanel = new JPanel();
		mainJPanel.add(controlJPanel);
		mainJPanel.add(drawSpace);
		
		add(mainJPanel);	// add JPanel to JFrame
		
		setSize(WIDTH, HEIGHT);	// set size of JFrame
		setVisible(true);	// display JFrame
	}	// end Fractal constructor
	
	public static void main(String[] args)
	{
		Fractal demo = new Fractal();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}	// end class Fractal
