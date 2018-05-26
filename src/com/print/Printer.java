package com.print;
// It should have fields for the toner Level, number of pages printed, and
// also whether its a duplex printer (capable of printing on both sides of the paper).

// Add methods to fill up the toner (up to a maximum of 100%), another method to
// simulate printing a page (which should increase the number of pages printed).

// Decide on the scope, whether to use constructors, and anything else you think is needed.

public class Printer {
    private int tonerLevel, numPages;
    private boolean isDuplex;

    public Printer(boolean isDup) {
        this.tonerLevel = 100;
        this.numPages = 0;
        this.isDuplex = isDup;
    }

    public void fillToner() {
        System.out.println("Toner level is " + this.tonerLevel
                                + "%\nFilling toner -> 100%!");
        this.tonerLevel = 100;
    }

    public void printPage() {
        // increase pages printed
        System.out.println("Current pages printed: " + this.numPages
                            + "\nPrinting page -> Done! Pages printed: "
                            + ++this.numPages);

        if(isDuplex) { this.tonerLevel -= 2; }
        else { this.tonerLevel--; }
    }
}
