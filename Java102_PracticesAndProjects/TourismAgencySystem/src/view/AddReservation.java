package view;

import general.Config;
import general.Helper;
import service.CustomerService;
import service.RoomTypesService;

import javax.swing.*;

public class AddReservation extends JFrame {
    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JLabel lbl_general_title;
    private JTextField fld_customer_name;
    private JTextField fld_customer_tc;
    private JLabel lbl_customer_name;
    private JLabel lbl_customer_tc;
    private JTextField fld_customer_phone;
    private JTextField fld_customer_mail;
    private JLabel lbl_customer_phone;
    private JLabel lbl_customer_mail;
    private JButton btn_add_reservation;
    private JTextField fld_total_price;
    private JLabel lbl_total_price;

    public AddReservation(int roomId, double roomPrice){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(700,400);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addReservation(roomId, roomPrice);
        priceInfo(roomPrice);
    }

    private void priceInfo(double roomPrice){
        fld_total_price.setText(String.valueOf(roomPrice) + "TL");
    }

    private void addReservation(int roomId, double roomPrice) {
        btn_add_reservation.addActionListener(e -> {
            if(validationOfIsEmpty()){
                if(CustomerService.add(fld_customer_name.getText(), fld_customer_tc.getText(), fld_customer_phone.getText(), fld_customer_mail.getText(), RoomTypesService.getHotelIdByRoomId(roomId), roomId, roomPrice)){
                    if(Helper.confirmAction("reservation")){
                        if(RoomTypesService.decreaseRoomStockNumber(roomId)){
                            Helper.showMessage("save");
                        }else{
                         Helper.showMessage("İşlem gerçekleşirken bir hata oluştu!");
                        }
                    }
                    dispose();
                }
                else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    private boolean validationOfIsEmpty(){
        if(Helper.isFieldEmpty(fld_customer_name) || Helper.isFieldEmpty(fld_customer_tc) || Helper.isFieldEmpty(fld_customer_phone)){
            Helper.showMessage("EPosta alanı hariç diğer alanların doldurulması zorunludur!");
            return false;
        }else{
            return true;
        }
    }


}
