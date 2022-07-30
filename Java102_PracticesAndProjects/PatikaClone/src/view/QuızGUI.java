package view;

import general.Config;
import general.Helper;
import model.Quiz;
import model.User;

import javax.swing.*;

public class QuızGUI extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_add_course_quiz;
    private JTextField fld_quiz_name;
    private JLabel lbl_quiz_name;
    private JButton btn_save_quiz;


    public QuızGUI(User user){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(300,130);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setVisible(true);
        setResizable(false);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        saveQuiz(user);
    }


    private void saveQuiz(User user) {
        btn_save_quiz.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_quiz_name)){
                Helper.showMessage("fill");
            }else{
                if(Quiz.add(fld_quiz_name.getText(), user.getName_surname())){
                    Helper.showMessage("save");
                }else{
                    Helper.showMessage("error");
                }
                dispose();
            }
        });
    }
}
