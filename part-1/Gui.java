//import javafx.embed.swing.JFXPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;
import java.util.*;

public class Gui {

	private static final Integer WINDOW_WIDTH = 2400;
	private static final Integer WINDOW_HEIGHT = 600;

	private final JFrame frame;
	private final JPanel panel;
	private final JScrollPane scrollPane;
	private final JPanel frameBodyViewer;

	private JButton startButton = new JButton();
	private JButton pauseButton = new JButton();
	private JButton btnNewButton_1;

	public Gui() {
		this.startButton = startButton;
		this.pauseButton = pauseButton;
		this.frame = new JFrame("PCD Assignment 1");
		setUpFrame();
		this.panel = new JPanel();
		setUpPanel();
		this.scrollPane = new JScrollPane(panel);
		setUpScrollPane();
		this.frameBodyViewer = new JPanel();
		frameBodyViewer.setBounds(125, 50, 250, 250);
		frameBodyViewer.setBackground(Color.gray);
		frameBodyViewer.setBorder(new LineBorder(Color.black, 3));

		JButton btnNewButton = new JButton("Stop");
		btnNewButton.setBounds(302, 361, 83, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton);
		panel.add(frameBodyViewer);

		btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setBounds(110, 361, 85, 21);
		panel.add(btnNewButton_1);

		btnNewButton_1 = new JButton("Start");
		btnNewButton_1.setBounds(106, 361, 85, 21);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		setUpButtons();

		this.frame.pack();
		this.frame.setVisible(true);
	}

	private void setUpFrame() {
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private void setUpPanel() {
	}

	private void setUpScrollPane() {
		scrollPane.setPreferredSize(new Dimension(500, 500));
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
	}

	private void setUpButtons() {

	}

	private void compute() {
		// inserire codice per far partire simulaizone;
	}

	private void stop() {
		// inserire codice per fermare simulazione;
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

}
