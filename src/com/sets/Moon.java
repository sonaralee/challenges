package com.sets;

public class Moon extends HeavenlyBody{
    public Moon(String name, String bt, double orbitalPeriod) {
        super(name, bt, orbitalPeriod);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        return this.getName().equals(objName);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.getName().hashCode() + 57;
    }
}
