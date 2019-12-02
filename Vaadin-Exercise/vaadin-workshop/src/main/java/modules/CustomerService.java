package modules;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An in memory dummy "database" for the example purposes. In a typical Java app
 * this class would be replaced by e.g. EJB or a Spring based service class.
 * <p>
 * {@link CustomerService#getInstance()}.
 */
public class CustomerService {

    private static CustomerService instance;
    private static final Logger LOGGER = Logger.getLogger(CustomerService.class.getName());

    private static String storageName = "customer.ser";
    private final HashMap<Object, Customer> contacts = new HashMap<>();
    private long nextId = 0;

    private CustomerService(String storageName) {
        CustomerService.storageName = storageName;
        if (Files.exists(Paths.get(CustomerService.storageName))) {
            System.out.println("loaded " + storageName);
            this.load(storageName);
        }else {
            System.out.println("the file is not created");
        }
    }

    private void persistToDisk() {
        try {
            if(Files.exists(Paths.get(CustomerService.storageName))){
                String location = "customer.ser";
                File file = new File(location);
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(contacts);
                out.close();
                fileOut.close();
            }
            FileOutputStream fileOut = new FileOutputStream(storageName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(contacts);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/customer.ser");
        } catch (IOException i) {
            System.out.println(i.getMessage());

        }

    }


    public static String getStorageName() {
        return storageName;
    }

    public Collection<Customer> getAll(){
        return contacts.values();
    }

    private void load(String storageName) {
        HashMap<Object, Customer> e = null;
        try {
            FileInputStream fileIn = new FileInputStream(storageName);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (HashMap<Object, Customer>) in.readObject();
            contacts.putAll(e);
            System.out.println("hellooooooooooooooo" + e);
        } catch (IOException | ClassNotFoundException ex) {
            ex.getMessage();
        }
    }

    /**
     * @return a reference to an example facade for Customer objects.
     */
    public static CustomerService getInstance() {
        if (instance == null) {
            instance = new CustomerService(getStorageName());
            instance.getAll();
            //instance.ensureTestData();
        }
        return instance;
    }

    /**
     * @return the amount of all customers in the system
     */
    public synchronized long count() {
        return contacts.size();
    }

    /**
     * Deletes a customer from a system
     *
     * @param value
     *            the Customer to be deleted
     */
    public synchronized void delete(Customer value) {
        contacts.remove(value.getId());
    }

    /**
     * Persists or updates customer in the system. Also assigns an identifier
     * for new Customer instances.
     *
     * @param entry
     */
    public synchronized void save(Customer entry) {
        if (entry == null) {
            LOGGER.log(Level.SEVERE,
                    "Customer is null. Are you sure you have connected your form to the application ?");
            return;
        }
        if (entry.getId() == null) {
            entry.setId(nextId++);
        }
        try {
            entry = (Customer) entry.clone();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        contacts.put(entry.getId(), entry);
        persistToDisk();
    }

}
