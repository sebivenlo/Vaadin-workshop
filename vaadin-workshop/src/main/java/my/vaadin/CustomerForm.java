package my.vaadin;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.*;
import modules.Customer;
import modules.CustomerService;
import modules.CustomerStatus;

public class CustomerForm extends FormLayout {

    private TextField firstName = new TextField("First name");
    private TextField lastName = new TextField("Last name");
    private TextField email = new TextField("Email");
    private NativeSelect<CustomerStatus> status = new NativeSelect<>("Status");
    private DateField birthdate = new DateField("Birthday");
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");

    private CustomerService service = CustomerService.getInstance();
    private Customer customer;
    private ApplicationUI myUI;
    private Binder binder= new Binder<>(Customer.class);

    public CustomerForm(ApplicationUI myUI){
        this.myUI = myUI;

        setSizeUndefined();
        HorizontalLayout buttons = new HorizontalLayout(save, delete);
        addComponents(firstName, lastName, email, status, birthdate, buttons);

        status.setItems(CustomerStatus.values());
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        binder.bindInstanceFields(this);
        save.addClickListener(e -> save());
        delete.addClickListener(e -> delete());
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
        binder.setBean(customer);
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
