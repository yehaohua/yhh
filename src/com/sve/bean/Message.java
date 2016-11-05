package com.sve.bean;

public class Message {
	public static final String ADD_REQUEST = "+";
    public static final String MINU_REQUEST = "-";
    public static final String MULTI_REQUEST = "*";
    public static final String DIV_REQUEST = "/";
    
    private double num1;
    private String symbol;
    private double num2;
    
	public double getNum1() {
		return num1;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getNum2() {
		return num2;
	}

	public Message(double num1, String symbol, double num2) {
		this.num1 = num1;
		this.symbol = symbol;
		this.num2 = num2;
	}
    
	
}
