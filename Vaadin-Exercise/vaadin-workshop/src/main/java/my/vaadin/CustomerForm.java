package my.vaadin;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import modules.Customer;
import modules.CustomerService;
import modules.CustomerStatus;

public class CustomerForm extends FormLayout {

    /**
     * In this file we have to create the field matches with the CustomerFormDesign class field
     */

    private TextField firstName = new TextField("First name");

    /**
     * TODO 8 Create the following TextFields: lastName and email (Hint: Look at the firstname TextField)
     */
    // Your code goes here

    private NativeSelect<CustomerStatus> status = new NativeSelect<>("Status");
    /**
     * TODO 9 Create a DateField for the birthdate and a Button for saving (Hint: Look at the delete button)
     */
    // Your code goes here

    private Button delete = new Button("Delete");

    private CustomerService service = CustomerService.getInstance();
    private Customer customer;
    private ApplicationUI myUI;

    /**
     * TODO 10 Create a binder that binds the customer class with the fields (Hint: new Binder<>('the customer class here'))</>
     */
    // Your code goes here

    public CustomerForm(ApplicationUI myUI){
        this.myUI = myUI;

        setSizeUndefined();
        /**
         * TODO 11 Create the horizontal layout for the buttons and set the buttons inside it (Hint: HorizontalLayout(save, delete))
         */
        // Your code goes here

        /**
         * TODO 12 Add all the fields (Hint: addComponents)
         */
        // Your code goes here

        status.setItems(CustomerStatus.values());

        /**
         * TODO 13 Bind the instance fields with the customer class (Hint: binder.bind...)
         */
        // Your code goes here

        /**
         * TODO 14 Add a click listener to the save button and use a lambda expression to execute the save method (Hint: (e -> save()))
         */
        // Your code goes here
        /**
         * TODO 15 Add a click listener to the delete button and use a lambda expression to execute the delete method (Hint: (e -> delete()))
         */
        // Your code goes here

    }

    public void setCustomer(Customer customer){
        this.customer = customer;
        /**
         * TODO 16 Uncomment the next line (binder.setBean(customer);)
         */
        // binder.setBean(customer);
        delete.setVisible(customer.isPersisted());
        setVisible(true);
        firstName.selectAll();
    }

    public void delete(){
        service.delete(customer);
        myUI.updateList();
        setVisible(false);
    }

    public void save(){
        service.save(customer);
        myUI.updateList();
        setVisible(false);
    }
}


