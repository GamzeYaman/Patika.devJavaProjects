package view;

import general.*;
import model.Course;
import model.Operator;
import model.Patika;
import model.User;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class OperatorGUI extends JFrame {

    private JPanel wrapper;
    private JTabbedPane tab_operator;
    private JLabel lbl_welcome;
    private JPanel pnl_top;
    private JButton btn_logout;
    private JPanel pnl_user_list;
    private JScrollPane scl_user_list;
    private JTable tbl_user_list;
    private JPanel pnl_user_form;
    private JTextField fld_user_name_surname;
    private JLabel lbl_username;
    private JLabel lbl_name_surname;
    private JTextField fld_username;
    private JLabel lbl_password;
    private JTextField fld_password;
    private JLabel lbl_user_type;
    private JButton btn_user_save;
    private JComboBox cmb_user_type;
    private JLabel lbl_user_id;
    private JTextField fld_user_id;
    private JButton btn_user_delete;
    private JPanel pnl_search;
    private JTextField fld_sch_name;
    private JTextField fld_sch_username;
    private JButton btn_search;
    private JLabel lbl_sch_name;
    private JLabel lbl_sch_username;
    private JLabel lbl_sch_user_type;
    private JComboBox cmb_sch_user_type;
    private JPanel pnl_patika_list;
    private JScrollPane scl_patika_list;
    private JTable tbl_patika_list;
    private JPanel pnl_patika_form;
    private JLabel lbl_patika_name;
    private JTextField fld_patika_name;
    private JButton btn_patika_save;
    private JPanel pnl_course_list;
    private JScrollPane srl_course;
    private JTable tbl_course_list;
    private JPanel pnl_save_course;
    private JTextField fld_course_name;
    private JLabel lbl_course_name;
    private JTextField fld_course_language;
    private JLabel lbl_course_language;
    private JLabel lbl_course_patika;
    private JComboBox cmb_course_patika;
    private JComboBox cmb_course_educator;
    private JLabel lbl_course_educator;
    private JButton btn_save_course;
    private DefaultTableModel mdl_user_list;
    private Object[] row_user_list;
    private DefaultTableModel mdl_patika_list;
    private Object[] row_patika_list;
    private JPopupMenu patikaMenu;
    private DefaultTableModel mdl_course_list;
    private Object[] row_course_list;


    private final Operator operator;

    public OperatorGUI(Operator operator){
        this.operator = operator;

        Helper.setDefaultTheme();
        add(wrapper);
        setSize(1000,750);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(true);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        createWelcomeMessage(operator);

        //USER
        getUserList();
        saveUser();
        deleteUser();
        selectUserId();
        updateUser();
        searchUser();


        //PATIKA
        getPatikaList();
        createPatikaMenu();
        savePatika();

        //COURSE
        getCourseList();
        loadCoursePatikaCombo();
        loadCourseEducatorCombo();
        saveCourse();

        logOut();

    }

    private void createWelcomeMessage(Operator operator) {
        lbl_welcome.setText("Hoşgeldin " + operator.getName_surname() + "!");
    }

    private void logOut() {
        btn_logout.addActionListener(e -> {
            dispose();
           LoginGUI loginGUI = new LoginGUI();
        });
    }

    //USER
    private void getUserList() {
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] column_user_list = {"ID", "AD-SOYAD", "KULLANICI ADI", "ŞİFRE", "KULLANICI TİPİ"};
        mdl_user_list.setColumnIdentifiers(column_user_list);
        row_user_list = new Object[column_user_list.length];

        int i;
        for(User obj: User.getList()){
            i = 0;
            row_user_list[i++] = obj.getUser_id();
            row_user_list[i++] = obj.getName_surname();
            row_user_list[i++] = obj.getUsername();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    private void getUserList(ArrayList<User> userList) {
        mdl_user_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] column_user_list = {"ID", "AD-SOYAD", "KULLANICI ADI", "ŞİFRE", "KULLANICI TİPİ"};
        mdl_user_list.setColumnIdentifiers(column_user_list);
        row_user_list = new Object[column_user_list.length];

        int i;
        for(User obj: userList){
            i = 0;
            row_user_list[i++] = obj.getUser_id();
            row_user_list[i++] = obj.getName_surname();
            row_user_list[i++] = obj.getUsername();
            row_user_list[i++] = obj.getPassword();
            row_user_list[i++] = obj.getType();
            mdl_user_list.addRow(row_user_list);
        }

        tbl_user_list.setModel(mdl_user_list);
        tbl_user_list.getTableHeader().setReorderingAllowed(false);
    }

    private void saveUser() {
        btn_user_save.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_user_name_surname) || Helper.isFieldEmpty(fld_username) || Helper.isFieldEmpty(fld_password) ){
                Helper.showMessage("fill");
            }else{
               if(User.add(fld_user_name_surname.getText(), fld_username.getText(),
                        fld_password.getText(), cmb_user_type.getSelectedItem().toString())) {
                   Helper.showMessage("save");
                   loadCourseEducatorCombo();
                   fld_user_name_surname.setText(null);
                   fld_username.setText(null);
                   fld_password.setText(null);
               }else{
                   Helper.showMessage("error");
               }
            }
            getUserList();
        });
    }

    private void deleteUser() {
        btn_user_delete.addActionListener(e -> {
            if(fld_user_id.getText().isEmpty()){
                Helper.showMessage("Lütfen kullanıcı id alanını boş bırakmayınız!");
            }else{
                if(Helper.confirm("sure")){
                    if(User.delete(Integer.parseInt(fld_user_id.getText()))){

                        Helper.showMessage("success");
                        fld_user_id.setText(null);
                        getUserList();
                        loadCourseEducatorCombo();
                        getCourseList();
                    }else{
                        Helper.showMessage("error");
                    }
                }

            }
        });
    }

    public void selectUserId() {
        tbl_user_list.getSelectionModel().addListSelectionListener(e -> {
            try{
                String select_user_id = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString();
                fld_user_id.setText(select_user_id);
            }catch(Exception exception){
                exception.getMessage();
            }

        });
    }

    private void updateUser() {
        tbl_user_list.getModel().addTableModelListener(e -> {
            if(e.getType() == TableModelEvent.UPDATE){
                int userId = Integer.parseInt(tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 0).toString());
                String nameSurname = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 1).toString();
                String username = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 2).toString();
                String password = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 3).toString();
                String userType = tbl_user_list.getValueAt(tbl_user_list.getSelectedRow(), 4).toString();

                if(User.update(userId, nameSurname, username, password, userType)){
                    Helper.showMessage("success");
                    getCourseList();
                    loadCourseEducatorCombo();
                }else{
                    Helper.showMessage("error");
                }

                getUserList();
            }
        });
    }

    private void searchUser() {
        btn_search.addActionListener(e -> {
            String name = fld_sch_name.getText();
            String username = fld_sch_username.getText();
            String userType = cmb_sch_user_type.getSelectedItem().toString();
            String sqlSearch = User.searchQuery(name, username, userType);

            ArrayList<User> searchList = User.searchList(sqlSearch);
            getUserList(searchList);
        });
    }


    //PATIKA
    private void getPatikaList(){
        mdl_patika_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };
        Object[] column_patika_list = {"ID", "PATİKA ADI"};
        mdl_patika_list.setColumnIdentifiers(column_patika_list);
        row_patika_list = new Object[column_patika_list.length];

        int i;
        for(Patika patika: Patika.getList()){
            i = 0;
            row_patika_list[i++] = patika.getPatikaId();
            row_patika_list[i++] = patika.getPatikaName();
            mdl_patika_list.addRow(row_patika_list);
        }

        tbl_patika_list.setModel(mdl_patika_list);
        tbl_patika_list.getTableHeader().setReorderingAllowed(false);
        tbl_patika_list.getColumnModel().getColumn(0).setMaxWidth(100);
    }

    private void savePatika() {
        btn_patika_save.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_patika_name)){
                Helper.showMessage("fill");
            }else{
                if(Patika.add(fld_patika_name.getText())){
                    Helper.showMessage("save");
                    loadCoursePatikaCombo();
                    fld_patika_name.setText(null);
                }else{
                    Helper.showMessage("error");
                }
            }
            getPatikaList();
        });
    }

    private void createPatikaMenu(){
        patikaMenu = new JPopupMenu();
        JMenuItem updateMenu = new JMenuItem("Güncelle");
        JMenuItem deleteMenu = new JMenuItem("Kaldır");
        patikaMenu.add(updateMenu);
        patikaMenu.add(deleteMenu);

        tbl_patika_list.setComponentPopupMenu(patikaMenu);

        tbl_patika_list.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int selectedRow = tbl_patika_list.rowAtPoint(point);
                tbl_patika_list.setRowSelectionInterval(selectedRow, selectedRow);
            }
        });


        updateMenu.addActionListener(e -> {
            int selectedId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            UpdatePatikaGUI updatePatikaGUI = new UpdatePatikaGUI(Patika.getPatikaById(selectedId));
            updatePatikaGUI.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    getPatikaList();
                    loadCoursePatikaCombo();
                    getCourseList();
                }
            });
        });

        deleteMenu.addActionListener(e -> {
            int selectedId = Integer.parseInt(tbl_patika_list.getValueAt(tbl_patika_list.getSelectedRow(), 0).toString());
            if(Helper.confirm("sure")){
                if(Patika.delete(selectedId)){
                    Helper.showMessage("success");
                    getPatikaList();
                    loadCoursePatikaCombo();
                    getCourseList();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }


    //COURSE
    private void getCourseList(){
        mdl_course_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_course_list = {"ID", "DERS ADI", "EĞİTMEN", "PATİKA", "PROGRAMLAMA DİLİ"};
        mdl_course_list.setColumnIdentifiers(column_course_list);
        row_course_list = new Object[column_course_list.length];

        int i ;
        for(Course obj: Course.getList()){
            i = 0;
            row_course_list[i++] = obj.getCourseId();
            row_course_list[i++] = obj.getCourseName();
            row_course_list[i++] = obj.getEducator().getName_surname();
            row_course_list[i++] = obj.getPatika().getPatikaName();
            row_course_list[i++] = obj.getLanguage();
            mdl_course_list.addRow(row_course_list);
        }

        tbl_course_list.setModel(mdl_course_list);
        tbl_course_list.getTableHeader().setReorderingAllowed(false);
        tbl_course_list.getColumnModel().getColumn(0).setMaxWidth(20);
        tbl_course_list.getColumnModel().getColumn(1).setMaxWidth(100);

    }

    private void saveCourse() {
        btn_save_course.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_course_name) || Helper.isFieldEmpty(fld_course_language)){
                Helper.showMessage("fill");
            }else{
                Item educator = (Item) cmb_course_educator.getSelectedItem();
                Item patika = (Item) cmb_course_patika.getSelectedItem();

                if(Course.add(fld_course_name.getText(), educator.getKey(), patika.getKey(), fld_course_language.getText())){
                    Helper.showMessage("success");
                    fld_course_name.setText(null);
                    fld_course_language.setText(null);
                }else{
                    Helper.showMessage("error");
                }
                getCourseList();
            }
        });
    }

    public void loadCoursePatikaCombo(){
        cmb_course_patika.removeAllItems();
        for(Patika obj : Patika.getList()){
             cmb_course_patika.addItem(new Item(obj.getPatikaId(), obj.getPatikaName()));
        }
    }

    public void loadCourseEducatorCombo(){
        cmb_course_educator.removeAllItems();
        for(User obj : User.getList()){
            if(obj.getType().equals("Educator")){
                cmb_course_educator.addItem(new Item(obj.getUser_id(), obj.getName_surname()));
            }
        }
    }

}
