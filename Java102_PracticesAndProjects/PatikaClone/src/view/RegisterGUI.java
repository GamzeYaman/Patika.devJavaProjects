package view;

import general.Config;
import general.Helper;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterGUI extends JFrame{
    private JPanel wrapper;
    private JTextField fld_name_surname;
    private JTextField fld_username;
    private JTextField fld_password;
    private JComboBox cmb_user_type;
    private JButton btn_register;
    private JLabel lbl_name_surname;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JLabel lbl_user_type;
    private JButton btn_cancel;

    public RegisterGUI(){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(400,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(false);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        createStudent();
        cancelProcess();
    }


    private void createStudent() {
        btn_register.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_name_surname) || Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_password)){
                Helper.showMessage("fill");
            }else{
                if(User.add(fld_name_surname.getText(), fld_username.getText(), fld_password.getText(), cmb_user_type.getSelectedItem().toString())){
                    Helper.showMessage("success");
                    dispose();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    private void cancelProcess() {
        btn_cancel.addActionListener(e -> {
            dispose();
        });
    }


}
