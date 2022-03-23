import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

public class Gui {

	private static final Integer WINDOW_WIDTH = 2400;
	private static final Integer WINDOW_HEIGHT = 600;

	private final JFrame frame;
	private final JPanel panel;
	private final JScrollPane scrollPane;


	private final JButton startButton;
	private final JButton pauseButton;


	public Gui() {
		this.frame = new JFrame("PCD Assignment 1");
		setUpFrame();
		this.panel = new JPanel();
		setUpPanel();
		this.scrollPane = new JScrollPane(panel);
		setUpScrollPane();

		this.startButton = addButton("Start");
		this.pauseButton = addButton("Pause");

		setUpButtons();

		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void setUpFrame() {
		frame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setUpPanel() {
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	}

	private void setUpScrollPane() {
		scrollPane.setPreferredSize(new Dimension(500, 500));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}


	private void setUpButtons() {
		startButton.addActionListener(event -> {

			try {
				startButton.setEnabled(false);
				compute();
			} catch (Exception e) {
			}

		});

		pauseButton.addActionListener(event -> {
			try {
				stop();
			} catch (Exception e) {
			}
		});

	}

	private void compute() {
	//inserire codice per far partire simulaizone;
	}

	private void stop() {
		//inserire codice per fermare simulazione;
	}


	private JTextArea addTextAreaWithLabel(String labelText) {
		JTextArea textArea = new JTextArea(5, 20);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setBorder(new LineBorder(Color.GRAY, 1));
		textArea.setBackground(Color.BLACK);
		textArea.setForeground(Color.WHITE);
		addComponentWithLabel(textArea, labelText);
		return textArea;
	}

	private JTextField addFieldWithLabel(String labelText) {
		JTextField field = new JTextField();
		addComponentWithLabel(field, labelText);
		return field;
	}

	private JFileChooser addChooserWithLabel(String labelText) {
		JFileChooser chooser = new JFileChooser();
		addComponentWithLabel(chooser, labelText);
		return chooser;
	}

	private void addComponentWithLabel(JComponent component, String labelText) {
		JLabel label = new JLabel(labelText);
		label.setLabelFor(component);

		panel.add(label);
		panel.add(component);
	}

	private JButton addButton(String buttonText) {
		JButton button = new JButton(buttonText);
		panel.add(button);
		return button;
	}

}
