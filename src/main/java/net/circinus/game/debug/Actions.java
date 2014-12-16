package net.circinus.game.debug;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.circinus.game.command.Command;

public class Actions implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Command.checkandRunCommand(Debug.input_Field.getText());
		Debug.input_Field.setText("");
	}
	

}
