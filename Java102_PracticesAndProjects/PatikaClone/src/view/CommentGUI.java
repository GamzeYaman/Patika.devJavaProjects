package view;

import general.Config;
import general.Helper;
import model.Comment;
import model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CommentGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JLabel lbl_course_name;
    private JButton btn_close_page;
    private JTextArea txt_comment;
    private JLabel lbl_comment;
    private JLabel lbl_evaluation;
    private JSpinner spn_evaluation;
    private JButton btn_save_comment;
    private JTabbedPane tabbedPane1;
    private JPanel pnl_make_comment;
    private JPanel pnl_comment_list;
    private JTable tbl_comment_list;
    private DefaultTableModel mdl_comment_list;
    private Object[] row_comment_list;

    public CommentGUI(User user, int courseId, String courseName){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(1000,500);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(true);
        setTitle(Config.appTitle);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getCommentList(courseId);
        createCourseName(courseName);
        saveComment(user, courseId);
        closePage();


    }

    private void createCourseName(String courseName){
        lbl_course_name.setText(courseName);
    }

    private void closePage(){
        btn_close_page.addActionListener(e -> {
            dispose();
        });
    }

    private void getCommentList(int courseId){
        mdl_comment_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_comment_list = {"ID", "DERS", "YORUM", "YORUM SAHİBİ"};
        mdl_comment_list.setColumnIdentifiers(column_comment_list);
        row_comment_list = new Object[column_comment_list.length];

        int i;
        for(Comment comment: Comment.getCommentByCourseId(courseId)){
            i = 0;
            row_comment_list[i++] = comment.getCommentId();
            row_comment_list[i++] = comment.getCourse().getCourseName();
            row_comment_list[i++] = comment.getComment();
            row_comment_list[i++] = comment.getUser().getName_surname();
            mdl_comment_list.addRow(row_comment_list);
        }

        tbl_comment_list.setModel(mdl_comment_list);
        tbl_comment_list.getTableHeader().setReorderingAllowed(false);
    }

    private void saveComment(User user, int courseId) {
        btn_save_comment.addActionListener(e -> {
            if(txt_comment.getText() == null){
                Helper.showMessage("fill");
            }else{
                editSpinner();
                int evaluation = Integer.parseInt(spn_evaluation.getValue().toString());
                if(Comment.add(user.getUser_id(), courseId, evaluation, txt_comment.getText())){
                    Helper.showMessage("save");
                    getCommentList(courseId);
                    dispose();
                }else{
                    Helper.showMessage("error");
                }
            }

        });
    }

    private void editSpinner(){
        SpinnerModel value = new SpinnerNumberModel(1, 0, 10, 1);
        spn_evaluation = new JSpinner(value);
    }

}
