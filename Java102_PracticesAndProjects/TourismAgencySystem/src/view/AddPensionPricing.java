package view;

import general.Config;
import general.Helper;
import service.RoomPricingService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPensionPricing extends JFrame {

    private JPanel wrapper;
    private JPanel wtop;
    private JPanel wbottom;
    private JLabel lbl_pension_name;
    private JPanel pnl_first_period;
    private JPanel pnl_second_period;
    private JPanel pnl_first_period_dates;
    private JLabel lbl_first_period_start;
    private JLabel lbl_first_period_end;
    private JPanel pnl_first_period_price_details;
    private JTextField fld_first_period_adult_price;
    private JTextField fld_first_period_kid_price;
    private JLabel lbl_first_period_adult_price;
    private JLabel lbl_first_period_kid_price;
    private JPanel pnl_second_period_dates;
    private JPanel pnl_second_period_price_details;
    private JLabel lbl_second_period_start;
    private JLabel lbl_second_period_end;
    private JTextField fld_second_period_adult_price;
    private JTextField fld_second_period_kid_price;
    private JLabel lbl_second_period_adult_price;
    private JLabel lbl_second_period_kid_price;
    private JButton btn_save_price;

    public AddPensionPricing(int hotelId, int roomId, int pensionId, String pensionName){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(400,350);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        generalPensionTitle(pensionName);
        addPrice(hotelId, roomId, pensionId);
    }

    private void generalPensionTitle(String pensionName){
        lbl_pension_name.setText(pensionName);
    }

    private void addPrice(int hotelId, int roomId, int pensionId) {
        btn_save_price.addActionListener(e -> {
            if(validationOfIsEmpty()){
                double firstPeriodAdultPrice = Double.parseDouble(fld_first_period_adult_price.getText());
                double firstPeriodKidPrice = Double.parseDouble(fld_first_period_kid_price.getText());
                double secondPeriodAdultPrice = Double.parseDouble(fld_second_period_adult_price.getText());
                double secondPeriodKidPrice = Double.parseDouble(fld_second_period_kid_price.getText());
                if(RoomPricingService.add(hotelId, roomId, pensionId, firstPeriodAdultPrice, firstPeriodKidPrice, secondPeriodAdultPrice, secondPeriodKidPrice)){
                    Helper.showMessage("save");
                    dispose();
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    private boolean validationOfIsEmpty() {
        if(Helper.isFieldEmpty(fld_first_period_adult_price) || Helper.isFieldEmpty(fld_first_period_kid_price) || Helper.isFieldEmpty(fld_second_period_adult_price) || Helper.isFieldEmpty(fld_second_period_kid_price)){
            Helper.showMessage("fill");
            return false;
        }else{
            return true;
        }
    }
}
