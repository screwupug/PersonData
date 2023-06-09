package controller;

import model.DataHandler;
import model.Handler;

public class Controller {
    Handler handler;

    public Controller(DataHandler handler) {
        this.handler = handler;
    }

    public boolean addData(String input) throws Exception {
        return handler.doYourJob(input);
    }
}
