import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class HDFrame extends JFrame
{
	private static final int one = 1;
	private static final int two = 2;
	private static final int four = 4;
	Font font = new Font("Serif", Font.BOLD, 15);
	
	
	JSlider hdSlider = new JSlider(JSlider.HORIZONTAL, one, four, two);
	JLabel enterHD = new JLabel("Enter Hamming Dist:");
	JTextField selectedHD = new JTextField("");
	
	public HDFrame() {
		this.setLayout(new GridLayout(7,1));
		JPanel topPan = new JPanel(new GridLayout(1, 1));
		hdSlider.setFont(font);
		hdSlider.setMajorTickSpacing(1);
		hdSlider.setPaintLabels(true);
		hdSlider.setPaintTicks(true);
		selectedHD.setEditable(false);
		selectedHD.setText("" + hdSlider.getValue());
		
		hdSlider.addChangeListener((l) -> {
			selectedHD.setText("" + hdSlider.getValue());
		});
		
		topPan.add(enterHD);
		topPan.add(selectedHD);
		this.add(topPan);
		this.add(hdSlider);
		
		//start ham distance computation code here
		
		this.setTitle("Hamming Distance Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 700);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new HDFrame();
	}

}
