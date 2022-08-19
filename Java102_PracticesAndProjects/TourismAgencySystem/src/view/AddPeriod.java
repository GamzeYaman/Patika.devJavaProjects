package view;

import com.toedter.calendar.JDateChooser;
import general.Config;
import general.Helper;
import service.HotelPeriodService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class AddPeriod extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_general_title;
    private JLabel lbl_first_period_start;
    private JLabel lbl_first_period_end;
    private JPanel pnl_set_first_period_start;
    private JPanel pnl_set_first_period_end;
    private JLabel lbl_first_period_name;
    private JLabel lbl_second_period_title;
    private JPanel pnl_second_period;
    private JLabel lbl_second_period_start;
    private JLabel lbl_second_period_end;
    private JPanel pnl_set_second_period_start;
    private JPanel pnl_set_second_period_end;
    private JButton btn_save_periods;
    private JDateChooser jDateChooserFirstStart = new JDateChooser();
    private JDateChooser jDateChooserFirstEnd = new JDateChooser();
    private JDateChooser jDateChooserSecondStart = new JDateChooser();
    private JDateChooser jDateChooserSecondEnd = new JDateChooser();

    public AddPeriod(){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(400,200);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addingDateParts();
        addPeriod();
    }

    private void addingDateParts() {
        jDateChooserFirstStart.setDateFormatString("dd/MM/yyyy");
        pnl_set_first_period_start.add(jDateChooserFirstStart);
        jDateChooserFirstEnd.setDateFormatString("dd/MM/yyyy");
        pnl_set_first_period_end.add(jDateChooserFirstEnd);
        jDateChooserSecondStart.setDateFormatString("dd/MM/yyyy");
        pnl_set_second_period_start.add(jDateChooserSecondStart);
        jDateChooserSecondEnd.setDateFormatString("dd/MM/yyyy");
        pnl_set_second_period_end.add(jDateChooserSecondEnd);
    }

    private void addPeriod(){
        btn_save_periods.addActionListener(e -> {

        });
    }
}
