package view;

import general.Config;
import general.Helper;
import general.Item;
import model.Content;
import model.Quiz;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateContentGUI extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_update_content;
    private JTextField fld_content_title;
    private JTextField fld_content_explanation;
    private JComboBox cmb_course_quiz;
    private JLabel lbl_content_title;
    private JLabel lbl_content_explanation;
    private JLabel lbl_course_quiz;
    private JButton btn_update_content;
    private EducatorGUI educatorGUI;

    public UpdateContentGUI(Content content){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(450,300);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Config.appTitle);


        updateContent(content);
    }

    private void updateContent(Content content) {
        fld_content_title.setText(content.getContentTitle());
        fld_content_explanation.setText(content.getContentExplanation());
        loadCourseQuizCombo();
        btn_update_content.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_content_title) || Helper.isFieldEmpty(fld_content_explanation)){
                Helper.showMessage("fill");
            }else{
                Item quiz = (Item) cmb_course_quiz.getSelectedItem();
                if(Content.update(fld_content_title.getText(), fld_content_explanation.getText(), quiz.getKey(), content.getContentId())){
                    Helper.showMessage("success");
                }
                dispose();
            }
        });
    }

    public void loadCourseQuizCombo(){
        cmb_course_quiz.removeAllItems();
        for(Quiz quiz: Quiz.getList()){
            cmb_course_quiz.addItem(new Item(quiz.getQuizId(), quiz.getQuizName()));
        }
    }


}
