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

    private CustomerService service = CustomerService.getInstance();
    /**
     * In this class we create and set the layout and the components.
     * (NOTE: per assignment there is one line of code to be added)
    */


    /**
     * TODO 1: Create a grid to show the customer data (So, type: <customer>)
    */
    // Your code goes here
    private CustomerForm form = new CustomerForm(this);

    @Override
    protected void init(VaadinRequest request) {
        /**
         * TODO 0: delete the following 3 lines
         */
        Label label = new Label("Hello from Ibi and Thijs");
        setContent(label);
        updateList();
        /**
         * TODO 2: Create a horizontal layout
         */
        // Your code goes here

        /**
         * TODO 3: Set the horizontal layout and the grid to full size
         */
        // Your code goes here


        Button addCustomerBtn = new Button("Add New Customer");
        /**
         * TODO 4: Add the the grid to the horizontal layout
         */
        // Your code goes here

//        main.addComponent(form);
//        main.addComponent(addCustomerBtn);
//        addCustomerBtn.addClickListener(e -> {
//            grid.asSingleSelect().clear();
//            form.setCustomer(new Customer());
//        });
        /**
         * TODO 5: Set 3 columns and give them the following names: firstname, lastname, email (Hint: "firstName","lastName","email")
         */
        // Your code goes here

        updateList();

        /**
         * TODO 6: Set the horizontal layout as the content of the application (hint: setContent())
         */
        // Your code goes here
/*
        form.setVisible(false);
        grid.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() == null){
                form.setVisible(false);
            }else {
                form.setCustomer(event.getValue());
            }
        });
*/

    }

    public void updateList() {
        Collection<Customer> customers = service.getAll();

        /**
         * TODO 7: Add the customers collection to the grid (Hint: setItems())
         */
        // Your code goes here
    }
}
