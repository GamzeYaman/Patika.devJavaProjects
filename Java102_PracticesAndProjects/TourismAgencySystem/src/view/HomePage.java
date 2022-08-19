package view;

import general.Config;
import general.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_general_title;
    private JLabel lbl_process;
    private JCheckBox chk_customer;
    private JCheckBox chk_worker;
    private JButton btn_enter;

    public HomePage(){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(400,400);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        entering();
    }

    private void entering() {
        btn_enter.addActionListener(e -> {
            if(chk_customer.isSelected()){
                SearchRooms listHotels = new SearchRooms();
            }else if(chk_worker.isSelected()){
                String workerPassword = "hotelWorker";
                EnterPassword enterPassword = new EnterPassword(workerPassword);
                dispose();
            }
        });
    }
}
