package my.vaadin;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import modules.Customer;
import modules.CustomerService;

import java.util.Collection;
import java.util.List;

@SpringUI
@Theme("applicationTheme")
@Title("Vaading + Springboot")
public class ApplicationUI extends UI {

    @Override
    protected void init(VaadinRequest request) {}
}