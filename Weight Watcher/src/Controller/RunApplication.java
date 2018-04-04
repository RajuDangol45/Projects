package Controller;

import Model.DatabaseConnect;
import Model.User;
import Model.UserDb;
import Model.WaistSizeDb;
import Model.WeightDb;
import View.UserDetailsView;
import java.sql.Connection;

public class RunApplication {
    
    private Connection dbConnection;
    private UserDb userDb = new UserDb();
    private Controller controller;
    private User user;
    private WeightDb weightDb;
    private WaistSizeDb waistSizeDb;
    
    public void start() throws InterruptedException{
        dbConnection = DatabaseConnect.getConnection();
        if(!userDb.userExists(dbConnection)){
            UserDetailsView userDetailsView = new UserDetailsView(true);
            userDetailsView.showUserDetailsView();
            user = new User(userDetailsView.getUserName().getText(), userDetailsView.getUserGender().getSelectedItem().toString(), Integer.parseInt(userDetailsView.getUserAge().getText()));
            controller = new Controller(user,userDb.userExists(dbConnection));
        }
        else{
            user = new User(userDb.getUserName(dbConnection),userDb.getUserGender(dbConnection),userDb.getUserAge(dbConnection));
            controller = new Controller(user,userDb.userExists(dbConnection));
        }
        weightDb = new WeightDb();
        waistSizeDb = new WaistSizeDb();
        user.setCurrentWeight(weightDb.getLastWeight(dbConnection));
        user.setCurrentWaistSize(waistSizeDb.getLastWaistSize(dbConnection));
        controller.run();
    }
    
}
