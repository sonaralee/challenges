package com.abstractclass;
// The class should contain 2 references to items which will represent the next and previous
// items (in the case of a linked list).
// I.e., if you call your abstract class ListItem, then it would have 2 member variables of
// type ListItem that will hold references to the next/right and previous/left ListItems.
//
// The abstract class will also need to hold a value - try to be as flexible as possible
// when defining the type of this value.
//
// The class will also need methods to move to the next item and back to the previous item,
// and methods to set the next and previous items.
//
// You should also specify a compareTo() method that takes a parameter of the same type as the
// class and returns 0 if the values are equal, greater than zero if the value sorts greater than
// the parameter and less than zero if it sorts less than the parameter.

public abstract class ListItem {
    private ListItem previous, next;
    private int value;

    public ListItem(int v, ListItem p, ListItem n) {
        this.value = v;
        this.previous = p;
        this.next = n;
    }

    public abstract void next();
    public abstract void previous();
    public abstract void setNext();
    public abstract void setPrevious();

    public int compareTo(ListItem li) {
        if(this.value == li.value) {
            return 0;
        } else if(this.value > li.value) {
            return 1;
        } else return -1;
    }
}
