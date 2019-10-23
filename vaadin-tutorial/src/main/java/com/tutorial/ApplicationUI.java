package com.tutorial;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import modules.Person;

@SpringUI
@Theme("MyTheme")
@Title("Vaading + Springboot")
public class ApplicationUI extends UI {

    Person person1 = new Person("ibi", "kouzak", "ibi@gmail.com");
    HorizontalSplitPanel splitPanel = new HorizontalSplitPanel();
    Grid<Person> grid = new Grid<>(Person.class);
    PersonEditorView personEditorView = new PersonEditorView();

    @Override
    protected void init(VaadinRequest request) {

        listPersons();

        grid.asSingleSelect().addValueChangeListener(evt -> personEditorView.setPerson(evt.getValue()));
        splitPanel.setSizeFull();
        grid.setSizeFull();
        personEditorView.setSizeFull();
        splitPanel.setFirstComponent(grid);
        splitPanel.setSecondComponent(personEditorView);

        setContent(splitPanel);
    }

    private void listPersons() {
        grid.setItems(person1);
    }
}