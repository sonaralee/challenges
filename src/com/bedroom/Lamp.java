package com.bedroom;

public class Lamp {
    private String bulb;
    private boolean isOn;

    public Lamp(String b, boolean o) {
        this.bulb = b;
        this.isOn = o;
    }

    public boolean getPowerStatus() {
        return isOn;
    }

    public String getBulbType() {
        return bulb;
    }

    public void hitSwitch() {
        if(isOn == true) {isOn = false;}
        if(isOn == false) {isOn = true;}
        String status = (isOn) ? "on" : "off";
        System.out.println("The lamp is now " + status);
    }
}
