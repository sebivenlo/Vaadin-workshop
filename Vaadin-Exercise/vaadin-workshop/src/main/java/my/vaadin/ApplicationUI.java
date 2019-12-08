package my.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import modules.Customer;
import modules.CustomerService;

import java.util.Collection;
import java.util.List;

@SpringUI
@Theme("applicationTheme")
@Title("Vaading + Springboot")
public class ApplicationUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Label label = new Label("Welcome to Vaadin + Springboot");
        label.setStyleName(ValoTheme.LABEL_H1);

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(label);
        layout.setComponentAlignment(label, Alignment.MIDDLE_CENTER);

        setContent(layout);
    }
}