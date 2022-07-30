package view;

import general.Config;
import general.Helper;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentGUI extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JLabel lbl_welcome_message;
    private JButton btn_logout;
    private JPanel pnl_patika_list;
    private JPanel pnl_student_course_list;
    private JTable tbl_patika_list;
    private JTable tbl_student_course_list;
    private JButton btn_comment;
    private JButton btn_comment_list;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;
    private DefaultTableModel mdl_student_course_list;
    private Object[] row_student_course_list;
    private JPopupMenu studentPatikaMenu;


    public StudentGUI(User user){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(750,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(true);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        createWelcomeMessage(user);

        //PATİKA
        getCourseList();
        createStudentPatikaMenu(user);

        //COURSE
        getStudentCourseList();
        createComment(user);

        logOut();

    }

    //GENERAL
    private void createWelcomeMessage(User user) {
        lbl_welcome_message.setText("Merhaba " + user.getName_surname() +  " :)");
    }

    private void logOut() {
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });
    }

    //PATİKA
    private void getCourseList(){
        mdl_course_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] column_patika_list = {"ID", "DERS ADI", "PATİKA ADI"};
        mdl_course_list.setColumnIdentifiers(column_patika_list);
        row_course_list = new Object[column_patika_list.length];

        int i;
        for(Course course: Course.getList()){
            i = 0;
            row_course_list[i++] = course.getCourseId();
            row_course_list[i++] = course.getCourseName();
            row_course_list[i++] = course.getPatika().getPatikaName();
            mdl_course_list.addRow(row_course_list);
        }

        tbl_patika_list.setModel(mdl_course_list);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(100);
    }

    private void createStudentPatikaMenu(User user){
        studentPatikaMenu =  new JPopupMenu();
        JMenuItem addCourse = new JMenuItem("Derse Kayıt Ol");
        studentPatikaMenu.add(addCourse);

        tbl_patika_list.setComponentPopupMenu(studentPatikaMenu);
        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        addCourse.addActionListener(e ->{
            int selectedId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString()); //Course ID
            if(Helper.confirm("add")){
                if(StudentCourse.add(user.getUser_id(), selectedId)){
                    Helper.showMessage("save");
                    getStudentCourseList();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    //COURSE
    private void getStudentCourseList(){
        mdl_student_course_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_student_course_list = {"ID", "ÖĞRENCİ", "DERS", "PATİKA"};
        mdl_student_course_list.setColumnIdentifiers(column_student_course_list);
        row_student_course_list = new Object[column_student_course_list.length];

        int i;
        for(StudentCourse studentCourse : StudentCourse.getList()){
            i = 0;
            row_student_course_list[i++] = studentCourse.getStudentCourseId();
            row_student_course_list[i++] = studentCourse.getUser().getName_surname();
            row_student_course_list[i++] = studentCourse.getCourse().getCourseName();
            row_student_course_list[i++] = studentCourse.getCourse().getPatika().getPatikaName();
            mdl_student_course_list.addRow(row_student_course_list);
        }

        tbl_student_course_list.setModel(mdl_student_course_list);
        tbl_student_course_list.getTableHeader().setReorderingAllowed(false);
    }

    private void createComment(User user){
        tbl_student_course_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent event) {
                Point point = event.getPoint();
                int selectedRw = tbl_student_course_list.rowAtPoint(point);
                tbl_student_course_list.setRowSelectionInterval(selectedRw, selectedRw);

                int selectedId = Integer.parseInt(tbl_student_course_list.getValueAt(tbl_student_course_list.getSelectedRow(), 0).toString()); //Course ID
                String selectedName = tbl_student_course_list.getValueAt(tbl_student_course_list.getSelectedRow(), 2).toString();
                btn_comment.addActionListener(e -> {
                    CommentGUI commentGUI = new CommentGUI(user, selectedId, selectedName);
                });

                btn_comment_list.addActionListener(e -> {
                    CommentGUI commentGUI = new CommentGUI(user, selectedId, selectedName);
                });

            }
        });
    }
}
