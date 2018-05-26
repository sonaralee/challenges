package com.print;
// the class will be called Printer
// It will simulate a real Computer Printer

public class Main {

    public static void main(String[] args) {
	// write your code here
        Printer p = new Printer(true);

        p.printPage();
        p.printPage();
        p.printPage();
        p.fillToner();
    }
}
