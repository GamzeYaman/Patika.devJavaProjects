package view;

import general.Config;
import general.Helper;
import model.Hotel_Info;
import service.Hotel_InfoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListHotels extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_hotel_list;
    private JTable tbl_list_hotels;
    private JPanel pnl_bottom;
    private JLabel lbl_bottom_title;
    private JButton btn_list_hotel_rooms;
    private JTextField fld_hotel_id;
    private JButton btn_add_new_hotel;
    private DefaultTableModel mdl_hotel_list;
    private Object[] row_hotel_list;

    public ListHotels(){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(600,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        listHotels();
        selectHotelId();
        goRoomListPage();
        addNewHotel();
    }

    private void listHotels() {
        mdl_hotel_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_hotel_list = {"ID", "OTEL ADI", "EPOSTA", "TELEFON", "ŞEHİR", "YILDIZ"};
        mdl_hotel_list.setColumnIdentifiers(column_hotel_list);
        row_hotel_list = new Object[column_hotel_list.length];

        int i;
        for(Hotel_Info hotelInfo: Hotel_InfoService.getList()){
            i = 0;
            row_hotel_list[i++] = hotelInfo.getHotelId();
            row_hotel_list[i++] = hotelInfo.getHotelName();
            row_hotel_list[i++] = hotelInfo.getHotelMail();
            row_hotel_list[i++] = hotelInfo.getHotelPhoneNumber();
            row_hotel_list[i++] = hotelInfo.getCity();
            row_hotel_list[i++] = hotelInfo.getHotelStar();
            mdl_hotel_list.addRow(row_hotel_list);
        }
        tbl_list_hotels.setModel(mdl_hotel_list);
        tbl_list_hotels.getTableHeader().setReorderingAllowed(false);
    }

    private void selectHotelId(){
        tbl_list_hotels.getSelectionModel().addListSelectionListener(e -> {
            String selectId = tbl_list_hotels.getValueAt(tbl_list_hotels.getSelectedRow(), 0).toString();
            fld_hotel_id.setText(selectId);
        });
    }

    private void goRoomListPage() {
        btn_list_hotel_rooms.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_hotel_id)){
                Helper.showMessage("Lütfen Otel Seçiniz!");
            }else{
                ListHotelRooms listHotelRooms = new ListHotelRooms(Integer.parseInt(fld_hotel_id.getText()));
                fld_hotel_id.setText(null);
            }
        });
    }

    private void addNewHotel() {
        btn_add_new_hotel.addActionListener(e -> {
            AddHotelGUI addHotelGUI = new AddHotelGUI();
        });
    }
}
