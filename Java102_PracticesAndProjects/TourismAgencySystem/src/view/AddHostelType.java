package view;

import general.Config;
import general.Helper;
import model.HostelType;
import service.HostelTypeService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHostelType extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_general_title;
    private JComboBox cmb_ultra_all_in;
    private JComboBox cmb_all_in;
    private JComboBox cmb_room_breakfast;
    private JComboBox cmb_full_pension;
    private JComboBox cmb_half_pension;
    private JComboBox cmb_only_bed;
    private JComboBox cmb_full_credit;
    private JButton btn_save_hostel_type;
    private JLabel lbl_ultra_all_in;
    private JLabel lbl_all_in;
    private JLabel lbl_room_breakfast;
    private JLabel lbl_full_pension;
    private JLabel lbl_half_pension;
    private JLabel lbl_only_bed;
    private JLabel lbl_full_credit;

    public AddHostelType(int hotelId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(600,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        saveHostelType(hotelId);
    }

    private void saveHostelType(int hotelId) {
        btn_save_hostel_type.addActionListener(e -> {
            if(validationOfIsEmpty()){
                if(HostelTypeService.add(hotelId, cmb_ultra_all_in.getSelectedItem().toString(), cmb_all_in.getSelectedItem().toString(),
                        cmb_room_breakfast.getSelectedItem().toString(), cmb_full_pension.getSelectedItem().toString(), cmb_half_pension.getSelectedItem().toString(),
                        cmb_only_bed.getSelectedItem().toString(), cmb_full_credit.getSelectedItem().toString())){
                    AddAmenityGUI addAmenityGUI = new AddAmenityGUI(hotelId);
                    dispose();
                }else{
                    Helper.showMessage("error");
                }
            }

        });
    }

    private boolean validationOfIsEmpty(){
        if(cmb_ultra_all_in.getSelectedItem() == null || cmb_all_in.getSelectedItem() == null || cmb_room_breakfast.getSelectedItem() == null
                || cmb_full_pension.getSelectedItem() == null || cmb_half_pension.getSelectedItem() == null || cmb_only_bed.getSelectedItem() == null
                || cmb_full_credit.getSelectedItem() == null){
            Helper.showMessage("fill");
            return false;
        }else{
            return true;
        }
    }
}
