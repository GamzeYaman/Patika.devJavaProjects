package view;

import general.Config;
import general.Helper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnterPassword extends JFrame{
    private JPanel wrapper;
    private JTextField fld_password;
    private JButton btn_enter;
    private JLabel lbl_password;

    public EnterPassword(String password){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(400,200);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        controlPassword(password);
    }

    private void controlPassword(String password) {
        btn_enter.addActionListener(e -> {
            if(fld_password.getText().equals(password)){
                ListHotels listHotels = new ListHotels();
                dispose();
            }else{
                Helper.showMessage("Şifre yanlış!");
            }
        });
    }
}
