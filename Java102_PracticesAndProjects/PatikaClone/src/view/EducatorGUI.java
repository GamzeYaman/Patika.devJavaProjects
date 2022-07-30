package view;

import general.Config;
import general.Helper;
import general.Item;
import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class EducatorGUI extends JFrame{
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JLabel lbl_welcome_message;
    private JButton btn_logout;
    private JTabbedPane tab_educator;
    private JPanel pnl_educator_course_list;
    private JScrollPane scr_educator_course_list;
    private JTable tbl_educator_course_list;
    private JTextField fld_course_content_title;
    private JTextField fld_course_content_explanation;
    private JTextField fld_course_content_video_link;
    private JComboBox cmb_course_content_quiz;
    private JComboBox cmb_content_of_course;
    private JButton btn_save_content;
    private JPanel pnl_add_course_content;
    private JLabel lbl_course_content_title;
    private JLabel lbl_course_content_explanation;
    private JLabel lbl_course_content_video_link;
    private JLabel lbl_course_content_quiz;
    private JLabel lbl_content_of_course;
    private JPanel pnl_course_content_list;
    private JScrollPane scr_course_content_list;
    private JTable tbl_course_content_list;
    private JPanel pnl_course_quiz_list;
    private JTable tbl_course_quiz_list;
    private JButton btn_add_quiz;
    private JLabel lbl_title;
    private JTextField fld_search_content_title;
    private JComboBox cmb_search_course;
    private JButton btn_search;
    private JLabel lbl_search_content_title;
    private JLabel lbl_search_course;
    private JPanel pnl_search_content_list;
    private DefaultTableModel mdl_educator_course_list;
    private Object[] row_educator_course_list;
    private DefaultTableModel mdl_quiz_list;
    private Object[] row_quiz_list;
    private DefaultTableModel mdl_content_list;
    private Object[] row_content_list;
    private JPopupMenu contentMenu;

    public EducatorGUI(User user){
        Helper.setDefaultTheme();
        add(wrapper);
        setSize(600,500);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(false);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        createWelcomeMessage(user);

        //COURSE
        getEducatorCourseList(user);

        //QUIZ
        getQuizList();
        saveQuiz(user);

        //CONTENT
        getContentList();
        createContentMenu();
        saveContent();
        loadCourseQuizCombo();
        loadCourseNameCombo(user);
        searchContent();


        logOut();


    }

    //GENERAL
    private void createWelcomeMessage(User educator) {
        lbl_welcome_message.setText("Hoşgeldin " + educator.getName_surname() + "!");
    }

    private void logOut() {
        btn_logout.addActionListener(e -> {
            dispose();
            LoginGUI loginGUI = new LoginGUI();
        });
    }

    //COURSE
    private void getEducatorCourseList(User user) {
        mdl_educator_course_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                    return super.isCellEditable(row, column);
            }
        };

        Object[] column_educator_course_list = {"ID", "DERS ADI", "EĞİTMEN", "PATİKA", "PROGRAMLAMA DİLİ"};
        mdl_educator_course_list.setColumnIdentifiers(column_educator_course_list);
        row_educator_course_list = new Object[column_educator_course_list.length];

        int i;
        for(Course course: Course.getListByUserId(user.getUser_id())){
            i = 0;
            row_educator_course_list[i++] = course.getCourseId();
            row_educator_course_list[i++] = course.getCourseName();
            row_educator_course_list[i++] = course.getEducator().getName_surname();
            row_educator_course_list[i++] = course.getPatika().getPatikaName();
            row_educator_course_list[i++] = course.getLanguage();
            mdl_educator_course_list.addRow(row_educator_course_list);
        }

        tbl_educator_course_list.setModel(mdl_educator_course_list);
        tbl_educator_course_list.getTableHeader().setReorderingAllowed(false);
    }


    //QUIZ
    private void getQuizList(){
        mdl_quiz_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_quiz_list = {"ID", "QUİZ ADI", "QUİZ HAZIRLAYAN"};
        mdl_quiz_list.setColumnIdentifiers(column_quiz_list);
        row_quiz_list = new Object[column_quiz_list.length];

        int i;
        for(Quiz quiz: Quiz.getList()){
            i = 0;
            row_quiz_list[i++] = quiz.getQuizId();
            row_quiz_list[i++] = quiz.getQuizName();
            row_quiz_list[i++] = quiz.getUserNameSurname();
            mdl_quiz_list.addRow(row_quiz_list);
        }

        tbl_course_quiz_list.setModel(mdl_quiz_list);
        tbl_course_quiz_list.getTableHeader().setReorderingAllowed(false);
    }

    private void saveQuiz(User user) {
        btn_add_quiz.addActionListener(e -> {
            QuızGUI quızGUI = new QuızGUI(user);
            quızGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    getQuizList();
                    loadCourseQuizCombo();
                }
            });
        });
    }

    //CONTENT

    private void getContentList(){
        mdl_content_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_content_list = {"ID", "BAŞLIK", "AÇIKLAMA", "LİNK", "QUİZ", "DERS"};
        mdl_content_list.setColumnIdentifiers(column_content_list);
        row_content_list = new Object[column_content_list.length];

        int i;
        for(Content content: Content.getList()){
            i = 0;
            row_content_list[i++] = content.getContentId();
            row_content_list[i++] = content.getContentTitle();
            row_content_list[i++] = content.getContentExplanation();
            row_content_list[i++] = content.getContentLink();
            row_content_list[i++] = content.getQuiz().getQuizName();
            row_content_list[i++] = content.getCourse().getCourseName();
            mdl_content_list.addRow(row_content_list);
        }

        tbl_course_content_list.setModel(mdl_content_list);
        tbl_course_content_list.getTableHeader().setReorderingAllowed(false);
    }

    private void getContentList(ArrayList<Content> contentList){
        mdl_content_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_content_list = {"ID", "BAŞLIK", "AÇIKLAMA", "LİNK", "QUİZ", "DERS"};
        mdl_content_list.setColumnIdentifiers(column_content_list);
        row_content_list = new Object[column_content_list.length];

        int i;
        for(Content content: contentList){
            i = 0;
            row_content_list[i++] = content.getContentId();
            row_content_list[i++] = content.getContentTitle();
            row_content_list[i++] = content.getContentExplanation();
            row_content_list[i++] = content.getContentLink();
            row_content_list[i++] = content.getQuiz().getQuizName();
            row_content_list[i++] = content.getCourse().getCourseName();
            mdl_content_list.addRow(row_content_list);
        }

        tbl_course_content_list.setModel(mdl_content_list);
        tbl_course_content_list.getTableHeader().setReorderingAllowed(false);
    }

    private void saveContent(){
        btn_save_content.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_course_content_title) || Helper.isFieldEmpty(fld_course_content_explanation) || Helper.isFieldEmpty(fld_course_content_video_link)){
                Helper.showMessage("fill");
            }else{
                Item quiz = (Item) cmb_course_content_quiz.getSelectedItem();
                Item course = (Item) cmb_content_of_course.getSelectedItem();

                if(Content.add(fld_course_content_title.getText(), fld_course_content_explanation.getText(), fld_course_content_video_link.getText(),quiz.getKey(),course.getKey())){
                    Helper.showMessage("save");
                }else{
                    Helper.showMessage("error");
                }
                getContentList();
            }
        });
    }

    private void createContentMenu(){
        contentMenu = new JPopupMenu();
        JMenuItem updateContent = new JMenuItem("Güncelle");
        JMenuItem deleteContent = new JMenuItem("Kaldır");
        contentMenu.add(updateContent);
        contentMenu.add(deleteContent);

        tbl_course_content_list.setComponentPopupMenu(contentMenu);
        tbl_course_content_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tbl_course_content_list.rowAtPoint(point);
                tbl_course_content_list.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });

        updateContent.addActionListener(e ->{
            int selectedId = Integer.parseInt(tbl_course_content_list.getValueAt(tbl_course_content_list.getSelectedRow(), 0).toString());
            UpdateContentGUI updateContentGUI = new UpdateContentGUI(Content.getContentById(selectedId));
            updateContentGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    getContentList();
                }
            });
        });

        deleteContent.addActionListener(e ->{
            int selectedId = Integer.parseInt(tbl_course_content_list.getValueAt(tbl_course_content_list.getSelectedRow(), 0).toString());
            if(Helper.confirm("sure")){
                if(Content.delete(selectedId)){
                    Helper.showMessage("success");
                    getContentList();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    private void searchContent() {
        btn_search.addActionListener(e -> {
            String contentTitle = fld_search_content_title.getText();
            Item course = (Item) cmb_search_course.getSelectedItem();
           // String sqlSearch = Content.searchQuery(contentTitle, course.getKey());


            ArrayList<Content> contentList = Content.searchList(course.getKey(), contentTitle);
            getContentList(contentList);
        });
    }

    public void loadCourseQuizCombo(){
        cmb_course_content_quiz.removeAllItems();
        for(Quiz quiz: Quiz.getList()){
            cmb_course_content_quiz.addItem(new Item(quiz.getQuizId(), quiz.getQuizName()));
        }
    }

    public void loadCourseNameCombo(User user){
        cmb_content_of_course.removeAllItems();
        for(Course course: Course.getList()){
            if(course.getEducator().getUser_id() == user.getUser_id()){
                cmb_content_of_course.addItem(new Item(course.getCourseId(), course.getCourseName()));
                cmb_search_course.addItem(new Item(course.getCourseId(), course.getCourseName()));
            }
        }
    }

}
