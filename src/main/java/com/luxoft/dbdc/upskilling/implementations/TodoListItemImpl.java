package com.luxoft.dbdc.upskilling.implementations;

import com.luxoft.dbdc.upskilling.interfaces.Toggllable;

public class TodoListItemImpl implements Toggllable {

    private String title;
    private boolean toggled;

    public TodoListItemImpl(String title) {
        this.title = title;
        toggled = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isToggled() {
        return toggled;
    }
    @Override
    public void toggle() {
    }
}
