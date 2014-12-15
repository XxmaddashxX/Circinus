package net.circinus.game.debug;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Out {
	private static int messages = 0;
	private static int errors = 0;
	
	public static void print(String level, String text){
		System.out.println("[" + date() + "] <" + level.toUpperCase()  + "> " + text);
		messages = messages + 1;
	}
	private static String date(){
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public static void printError(String level, String text){
		System.err.println("[" + date() + "] <" + level.toUpperCase()  + "> " + text);
		errors = errors + 1;
	}
	public static void continousPrint(String text){
		System.out.print(text);
	}
	public static void printinfo(String level){
		System.out.println("[" + date() + "] <" + level.toUpperCase()  + "> ");
	}
	public static void line(){
		System.out.println();
	}
	public static int getErrors() {
		return errors;
	}
	public static void setErrors(int errors) {
		Out.errors = errors;
	}
	public static int getMessages() {
		return messages;
	}
	public static void setMessages(int messages) {
		Out.messages = messages;
	}

}
