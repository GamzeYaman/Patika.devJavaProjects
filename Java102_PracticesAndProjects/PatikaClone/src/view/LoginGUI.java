package view;

import general.Config;
import general.Helper;
import model.Operator;
import model.User;

import javax.swing.*;

public class LoginGUI extends  JFrame{
    private JPanel wrapper;
    private JPanel wbottom;
    private JPanel wtop;
    private JLabel lbl_login;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JButton btn_login;
    private JButton btn_register;

    public LoginGUI(){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(400,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(false);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        loginProcess();
    }

    private void loginProcess() {
        btn_login.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_password)){
                Helper.showMessage("fill");
            }else{
                User user = User.login(fld_username.getText(), fld_password.getText());
                if(user == null){
                    Helper.showMessage("register");
                    RegisterGUI registerGUI = new RegisterGUI();
                }else{
                    switch (user.getType()){
                        case "Student":
                            StudentGUI studentGUI = new StudentGUI(user);
                            break;
                        case "Operator":
                            OperatorGUI operatorGUI = new OperatorGUI((Operator) user);
                            break;
                        case "Educator":
                            EducatorGUI educatorGUI = new EducatorGUI(user);
                            break;
                    }
                }
                dispose();
            }
        });

    }

}
