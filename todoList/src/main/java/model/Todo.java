package model;

import java.io.Serializable;

public class Todo implements Serializable {
	private int priority ;
	private String text;
	private String kekka;
	
	public Todo() {}

	public Todo(int priority, String text, String kekka) {
		this.priority = priority;
		this.text = text;
		this.kekka = kekka;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getKekka() {
		return kekka;
	}

	public void setKekka(String kekka) {
		this.kekka = kekka;
	}

	@Override
	public String toString() {
		return "Todo [priority=" + priority + ", text=" + text + ", kekka=" + kekka + "]";
	}
	
	




	
}
