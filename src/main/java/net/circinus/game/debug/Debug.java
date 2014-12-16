package net.circinus.game.debug;

import java.awt.Container;
import java.awt.Dimension;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

public class Debug {
	private SpringLayout layout;
	private JFrame frame;
	private JPanel messages, errors;
	private JTextArea messarea, errarea;
	public static JTextArea runtime_Field, memory_Field, memory_used,
	process_area, input_Field;
	public Debug(){
		//createGui();
	}
	public void createGui(){
		JFrame frame = new JFrame("Debug Screen");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		Container contentPane = frame.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);
		JButton input_button = new JButton("Enter");
		JLabel messageLabel = new JLabel("Messages");
		JLabel errorLabel = new JLabel("Errors");
		JLabel runtimeLabel = new JLabel("Runtime");
		JLabel memorylabel = new JLabel("Memory Free");
		JLabel memoryused = new JLabel("Memory Used");
		JLabel processlabel = new JLabel("Processors");
		JLabel oslabel = new JLabel("OS");
		contentPane.add(input_button);
		contentPane.add(memoryused);
		contentPane.add(errorLabel);
		contentPane.add(messageLabel);
		contentPane.add(runtimeLabel);
		contentPane.add(memorylabel);
		contentPane.add(processlabel);
		contentPane.add(oslabel);
		//Create and add the components.
		runtime_Field  = new JTextArea(1, 10);
		memory_Field = new JTextArea(1, 10);
		memory_used = new JTextArea(1, 10);
		process_area = new JTextArea(1, 10);
		JTextArea os_Field = new JTextArea(1, 10);
		JTextArea error_Field = new JTextArea(20, 50);
		JTextArea message_Field = new JTextArea(20, 50);
		 input_Field = new JTextArea(1 , 25);
		contentPane.add(input_Field);
		JScrollPane message_scrollPane = new JScrollPane(message_Field);
		contentPane.add(message_scrollPane);
		contentPane.add(runtime_Field);
		contentPane.add(memory_Field);
		contentPane.add(memory_used);
		contentPane.add(process_area);
		contentPane.add(os_Field);
		message_scrollPane.setPreferredSize(new Dimension(450, 450));
		//Adjust constraints for the label so it's at (5,5).
		JScrollPane error_scrollPane = new JScrollPane(error_Field);
		contentPane.add(error_scrollPane);
		error_scrollPane.setPreferredSize(new Dimension(450, 450));
		input_button.addActionListener(new Actions());


		layout.putConstraint(SpringLayout.NORTH, message_scrollPane,
				50,
				SpringLayout.NORTH, contentPane);

		layout.putConstraint(SpringLayout.WEST, message_scrollPane,
				50,
				SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, error_scrollPane,
				0,
				SpringLayout.NORTH, message_scrollPane);

		layout.putConstraint(SpringLayout.WEST, error_scrollPane,
				460,
				SpringLayout.WEST, message_scrollPane);
		layout.putConstraint(SpringLayout.NORTH, messageLabel,
				35,
				SpringLayout.NORTH, contentPane);

		layout.putConstraint(SpringLayout.WEST, messageLabel,
				50,
				SpringLayout.WEST, contentPane);
		layout.putConstraint(SpringLayout.NORTH, errorLabel,
				0,
				SpringLayout.NORTH, messageLabel);

		layout.putConstraint(SpringLayout.WEST, errorLabel,
				460,
				SpringLayout.WEST, messageLabel);
		layout.putConstraint(SpringLayout.NORTH, runtime_Field,
				480,
				SpringLayout.NORTH, message_scrollPane);

		layout.putConstraint(SpringLayout.WEST, runtime_Field,
				0,
				SpringLayout.WEST, message_scrollPane);
		
		layout.putConstraint(SpringLayout.NORTH, runtimeLabel,
				460,
				SpringLayout.NORTH, message_scrollPane);

		layout.putConstraint(SpringLayout.WEST, runtimeLabel,
				0,
				SpringLayout.WEST, message_scrollPane);
		layout.putConstraint(SpringLayout.NORTH, memory_Field,
				40,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, memory_Field,
				0,
				SpringLayout.WEST, runtime_Field);
		
		layout.putConstraint(SpringLayout.NORTH, memorylabel,
				20,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, memorylabel,
				0,
				SpringLayout.WEST, runtime_Field);
		layout.putConstraint(SpringLayout.NORTH, memory_used,
				80,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, memory_used,
				0,
				SpringLayout.WEST, runtime_Field);
		
		layout.putConstraint(SpringLayout.NORTH, memoryused,
				60,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, memoryused,
				0,
				SpringLayout.WEST, runtime_Field);
		layout.putConstraint(SpringLayout.NORTH, process_area,
				0,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, process_area,
				125,
				SpringLayout.WEST, runtime_Field);
		layout.putConstraint(SpringLayout.NORTH, processlabel,
				0,
				SpringLayout.NORTH, runtimeLabel);

		layout.putConstraint(SpringLayout.WEST, processlabel,
				125,
				SpringLayout.WEST, runtimeLabel);
		layout.putConstraint(SpringLayout.NORTH, os_Field,
				40,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, os_Field,
				125,
				SpringLayout.WEST, runtime_Field);
		layout.putConstraint(SpringLayout.NORTH, oslabel,
				20,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, oslabel,
				125,
				SpringLayout.WEST, runtime_Field);
		layout.putConstraint(SpringLayout.NORTH, input_Field,
				80,
				SpringLayout.NORTH, runtime_Field);

		layout.putConstraint(SpringLayout.WEST, input_Field,
				300,
				SpringLayout.WEST, runtime_Field);
		layout.putConstraint(SpringLayout.NORTH, input_button,
				-5,
				SpringLayout.NORTH, input_Field);

		layout.putConstraint(SpringLayout.WEST, input_button,
				300,
				SpringLayout.WEST, input_Field);
	
	
		input_Field.setEditable(true);
		input_Field.setLineWrap(false);
		input_Field.setWrapStyleWord(false);
		
		
		message_Field.setEditable(false);
		message_Field.setLineWrap(true);
		message_Field.setWrapStyleWord(true);
		error_Field.setEditable(false);
		error_Field.setLineWrap(true);
		error_Field.setWrapStyleWord(true);
		memory_Field.setEditable(false);
		memory_Field.setLineWrap(true);
		memory_Field.setWrapStyleWord(true);
		memory_used.setEditable(false);
		memory_used.setLineWrap(true);
		memory_used.setWrapStyleWord(true);
		frame.setSize(1000, 700);
		frame.setResizable(false);
		runtime_Field.setEditable(false);
		runtime_Field.setLineWrap(true);
		runtime_Field.setWrapStyleWord(true);
		process_area.setEditable(false);
		process_area.setLineWrap(true);
		process_area.setWrapStyleWord(true);
		os_Field.setEditable(false);
		os_Field.setLineWrap(true);
		os_Field.setWrapStyleWord(true);
		
		frame.setVisible(true);

		PrintStream con=new PrintStream(new TextAreaOutputStream(message_Field));
		PrintStream pon=new PrintStream(new TextAreaOutputStream(error_Field));
		System.setOut(con);
		System.setErr(pon);
		os_Field.setText(System.getProperty("os.name"));
		System.out.println("Debug Message Screen Created");
		System.err.println("Debug Error Screen Created");
	}

}
