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

    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>(Customer.class);
    private CustomerForm form = new CustomerForm(this);


    @Override
    protected void init(VaadinRequest request) {

        updateList();
        HorizontalLayout main = new HorizontalLayout(grid, form);
        main.setSizeFull();
        grid.setSizeFull();
        Button addCustomerBtn = new Button("Add New Customer");
        main.addComponent(grid);
        main.addComponent(form);
        main.addComponent(addCustomerBtn);
        addCustomerBtn.addClickListener(e -> {
            grid.asSingleSelect().clear();
            form.setCustomer(new Customer());
        });
        grid.setColumns("firstName","lastName","email");
        updateList();

        setContent(main);

        form.setVisible(false);
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null){
                form.setVisible(false);
            }else {
                form.setCustomer(event.getValue());
            }
        });
    }

    public void updateList() {
        Collection<Customer> customers = service.getAll();
        grid.setItems(customers);
    }
}