import controller.Controller;
import model.DataHandler;
import model.FileOperation;
import model.PersonDataMapper;
import view.View;

public class Main {
    public static void main(String[] args) {
        View view = new View(new Controller(new DataHandler(new PersonDataMapper(), new FileOperation())));
        view.run();
    }
}
