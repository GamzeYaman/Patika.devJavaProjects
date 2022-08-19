package view;

import general.Config;
import general.Helper;
import general.Item;
import model.HostelType;
import service.HostelTypeService;
import service.RoomTypesService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculateRoomPrice extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_general_title;
    private JLabel lbl_general_title;
    private JPanel pnl_calculating_price;
    private JComboBox cmb_hostel_type;
    private JLabel lbl_hostel_type;
    private JTextField fld_room_type;
    private JLabel lbl_room_type;
    private JPanel pnl_calculate_price_detail;
    private JTextField fld_adult_number;
    private JTextField fld_kid_number;
    private JButton btn_calculate;
    private JTextField fld_total_price;
    private JLabel lbl_adult_number;
    private JLabel lbl_kid_number;
    private JLabel lbl_total_price;
    private JPanel pnl_total_price;
    private JButton btn_reservation;
    private JPanel pnl_holiday_date;
    private JLabel lbl_holiday_start_date;
    private JLabel lbl_holiday_end_date;
    private JTextField fld_holiday_start_date;
    private JTextField fld_holiday_end_date;
    private JTextField fld_adult_price;
    private JLabel lbl_adult_price;
    private JButton btn_show_price;
    private JLabel lbl_kid_price;
    private JTextField fld_kid_price;


    public CalculateRoomPrice(int roomId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(700,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        createGeneralInfo(roomId);
        getPrice(roomId);
        calculateRoomTotalPrice();

        goReservationPage(roomId);
    }

    public void createGeneralInfo(int roomId){
        fld_room_type.setText(RoomTypesService.getTypeByRoomId(roomId));
        loadHostelTypesCombo(RoomTypesService.getHotelIdByRoomId(roomId));
    }

    public void loadHostelTypesCombo(int hotelId){
        cmb_hostel_type.removeAllItems();
        for(HostelType hostelType: HostelTypeService.getListByHotelId(hotelId)){
            if(hostelType.getUltraAllIn().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Ultra Herşey Dahil"));
            }
            if(hostelType.getAllIn().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Herşey Dahil"));
            }
            if(hostelType.getFullPension().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Tam Pansiyon"));
            }
            if(hostelType.getHalfPension().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Yarım Pansiyon"));
            }
            if(hostelType.getRoomBreakfast().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Oda Kahvaltı"));
            }
            if(hostelType.getOnlyBed().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Sadece Yatak"));
            }
            if(hostelType.getFullCreditNotAlcohol().equals("Var")){
                cmb_hostel_type.addItem(new Item(hostelType.getHostelTypeId(), "Alkol Hariç Full Credit"));
            }
        }
    }

    public void getPrice(int roomId){
        btn_show_price.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_holiday_start_date) || Helper.isFieldEmpty(fld_holiday_end_date)){
                Helper.showMessage("Lütfen otelde bulunmak istediğiniz tarihleri gün/ay/yıl olacak şekilde yazını!");
            }else{
                fld_adult_price.setText(String.valueOf(Helper.adultRoomPriceAccordingToPeriod(fld_holiday_start_date.getText(), fld_holiday_end_date.getText(), roomId)));
                fld_kid_price.setText(String.valueOf(Helper.kidRoomPriceAccordingToPeriod(fld_holiday_start_date.getText(), fld_holiday_end_date.getText(), roomId)));
            }
        });
    }

    private void calculateRoomTotalPrice(){
        btn_calculate.addActionListener(e -> {
            long numberOfDays =  Helper.getDayNumberBetweenTwoDate(fld_holiday_start_date.getText(), fld_holiday_end_date.getText());
            if(Helper.isFieldEmpty(fld_adult_price) || Helper.isFieldEmpty(fld_kid_price)){
                Helper.showMessage("Lütfen tarihi gün/ay/yıl formatı ile girdikten sonra fiyat görüntüleye basınız!");
            }else if(Helper.isFieldEmpty(fld_adult_number) || Helper.isFieldEmpty(fld_kid_number)){
                Helper.showMessage("Lütfen kişi sayılarını yazınız!");
            }else{
                double adultPriceResult = (Double.parseDouble(fld_adult_price.getText()) * Integer.parseInt(fld_adult_number.getText())) * numberOfDays;
                double kidPriceResult = (Double.parseDouble(fld_kid_price.getText()) * Integer.parseInt(fld_kid_number.getText())) * numberOfDays;
                double totalPrice = adultPriceResult + kidPriceResult;
                fld_total_price.setText(String.valueOf(totalPrice));
            }
        });
    }

    private void goReservationPage(int roomId) {
        btn_reservation.addActionListener(e -> {
            AddReservation addReservation = new AddReservation(roomId, Double.parseDouble(fld_total_price.getText()));
        });
    }

}
