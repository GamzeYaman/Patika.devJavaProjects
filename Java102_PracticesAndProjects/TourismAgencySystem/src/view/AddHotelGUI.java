package view;

import general.Config;
import general.Helper;
import general.Item;
import model.Hotel_Info;
import service.Hotel_InfoService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddHotelGUI  extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_add_hotel;
    private JTextField fld_hotel_name;
    private JLabel lbl_hotel_name;
    private JTextField fld_hotel_mail;
    private JLabel lbl_hotel_mail;
    private JTextField fld_hotel_phone_number;
    private JLabel lbl_hotel_phone_number;
    private JSpinner spn_hotel_star;
    private JLabel lbl_hotel_start;
    private JPanel pnl_top;
    private JLabel lbl_general_title;
    private JComboBox cmb_city;
    private JLabel lbl_city;
    private JTextField fld_district;
    private JLabel lbl_district;
    private JTextArea txt_full_address;
    private JPanel pnl_full_address;
    private JLabel fld_full_address;
    private JButton btn_save_hotel;

    public AddHotelGUI(){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(600,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        saveHotel();
    }

    private void saveHotel() {
        btn_save_hotel.addActionListener(e -> {
            if(validationOfIsEmpty()){
                int hotelStar = Integer.parseInt(spn_hotel_star.getValue().toString());
                if(Hotel_InfoService.add(fld_hotel_name.getText(), fld_hotel_mail.getText(), fld_hotel_phone_number.getText(),
                        cmb_city.getSelectedItem().toString(), fld_district.getText(), txt_full_address.getText(), hotelStar)){
                    int hotelId = Hotel_InfoService.getHotelIdByMail(fld_hotel_mail.getText());
                    AddHostelType addHostelType = new AddHostelType(hotelId);
                    dispose();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    private boolean validationOfIsEmpty(){
        if(Helper.isFieldEmpty(fld_hotel_name) || Helper.isFieldEmpty(fld_hotel_mail) || Helper.isFieldEmpty(fld_hotel_phone_number)
                || Helper.isFieldEmpty(fld_district) || txt_full_address.getText() == null || cmb_city.getSelectedItem() == null){
            Helper.showMessage("fill");
            return false;
        }else{
            return true;
        }
    }


}
