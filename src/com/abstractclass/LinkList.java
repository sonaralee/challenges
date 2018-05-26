package com.abstractclass;

import java.util.LinkedList;

public class LinkList {
    // The rules for adding an item to the linked list are:
    //  If the head of the list is null, make the head refer to the item to be added.
    //  If the item to be added is less than the current item in the list, add the item before the
    //      current item (i.e., make the previous item's "next" refer to the new item, and the new item's
    //      "next" refer to the current item).
    //  If the item to be added is greater than the current item, move onto the next item and compare
    //      again (if there is no next item then that is where the new item belongs).
    //
    // Care will be needed when inserting before the first item in the list (as it will not have a previous
    // item).
    //
    // You will also need a method to remove an item from the list.
    private ListItem head;

    public LinkList() {
        this.head = null;
    }

    public void addItem(ListItem li) {
        if(this.head == null) {
            this.head = li;
        }
        //if(this.head > li) {
        //    this.head.previous().setNext();
        //}

    }
}
