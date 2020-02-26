import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame windowFrame = new JFrame();
		windowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windowFrame.setSize(600, 600);
		windowFrame.add(windowFrame, new ColorSquares(), 0);
		windowFrame.setVisible(true);
}
}