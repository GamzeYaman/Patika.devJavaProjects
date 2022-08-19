package view;

import general.Config;
import general.Helper;
import service.AmenityService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAmenityGUI extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_general_title;
    private JComboBox cmb_free_parking;
    private JComboBox cmb_free_wifi;
    private JLabel lbl_free_parking;
    private JLabel lbl_free_wifi;
    private JComboBox cmb_swimming_pool;
    private JComboBox cmb_fitness_center;
    private JLabel lbl_swimming_pool;
    private JLabel lbl_fitness_center;
    private JComboBox cmb_hotel_concierge;
    private JComboBox cmb_spa;
    private JLabel lbl_hotel_concierge;
    private JLabel lbl_spa;
    private JComboBox cmb_room_service;
    private JLabel lbl_room_service;
    private JButton btn_save_amenity;

    public AddAmenityGUI(int hotelId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(600,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btn_save_amenity.addActionListener(e -> {
            if(validationOfIsEmpty()){
                if(AmenityService.add(hotelId, cmb_free_parking.getSelectedItem().toString(), cmb_free_wifi.getSelectedItem().toString(), cmb_swimming_pool.getSelectedItem().toString(),
                        cmb_fitness_center.getSelectedItem().toString(), cmb_hotel_concierge.getSelectedItem().toString(), cmb_spa.getSelectedItem().toString(), cmb_room_service.getSelectedItem().toString())){
                    AddRoomType addRoomType = new AddRoomType(hotelId);
                    dispose();
                }else{
                    Helper.showMessage("error");
                }
            }


        });
    }

    private boolean validationOfIsEmpty(){
        if(cmb_free_parking.getSelectedItem() == null || cmb_free_wifi.getSelectedItem() == null || cmb_swimming_pool.getSelectedItem() == null
                || cmb_fitness_center.getSelectedItem() == null || cmb_hotel_concierge.getSelectedItem() == null || cmb_spa.getSelectedItem() == null
                || cmb_room_service.getSelectedItem() == null){
            Helper.showMessage("fill");
            return false;
        }else{
            return true;
        }
    }
}
