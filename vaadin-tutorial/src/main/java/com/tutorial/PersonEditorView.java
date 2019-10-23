package com.tutorial;

import com.vaadin.data.Binder;
import modules.Person;

import java.util.function.Consumer;

public class PersonEditorView extends PersonEditorDesign {


    Binder<Person> binder = new Binder<>(Person.class);

    public PersonEditorView() {
        this.binder.bindInstanceFields(this);
        save.addClickListener(evt -> binder.getBean());
    }

    public void setPerson(Person value) {
        binder.setBean(value);
    }
}
