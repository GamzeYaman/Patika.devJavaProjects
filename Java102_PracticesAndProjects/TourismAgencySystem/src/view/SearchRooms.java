package view;

import general.Config;
import general.Helper;
import model.RoomTypes;
import service.RoomTypesService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchRooms extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_searching_rooms;
    private JPanel pnl_room_list;
    private JTable tbl_room_list;
    private JLabel lbl_select_room;
    private JButton btn_view_room;
    private JTextField fld_select_room;
    private JLabel lbl_hotel_name;
    private JTextField fld_hotel_name;
    private JLabel lbl_city;
    private JLabel lbl_district;
    private JComboBox cmb_city;
    private JTextField fld_district;
    private JButton btn_search;
    private DefaultTableModel mdl_room_list;
    private Object[] row_room_list;

    public SearchRooms(){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(700,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        listRooms();
        selectRoomId();
        viewRoomFeatures();
        searchRooms();
    }

    private void listRooms(){
        mdl_room_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_room_list = {"ID", "ODA TİPİ", "OTEL ADI", "ŞEHİR", "BÖLGE", "YILDIZ"};
        mdl_room_list.setColumnIdentifiers(column_room_list);
        row_room_list = new Object[column_room_list.length];

        int i;
        for(RoomTypes roomTypes: RoomTypesService.listRooms()){
            i = 0;
            row_room_list[i++] = roomTypes.getRoomId();
            row_room_list[i++] = roomTypes.getRoomType();
            row_room_list[i++] = roomTypes.getHotelInfo().getHotelName();
            row_room_list[i++] = roomTypes.getHotelInfo().getCity();
            row_room_list[i++] = roomTypes.getHotelInfo().getDistrict();
            row_room_list[i++] = roomTypes.getHotelInfo().getHotelStar();
            mdl_room_list.addRow(row_room_list);
        }
        tbl_room_list.setModel(mdl_room_list);
        tbl_room_list.getTableHeader().setReorderingAllowed(false);
    }

    private void listRooms(ArrayList<RoomTypes> roomTypeList){
        mdl_room_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_room_list = {"ID", "ODA TİPİ", "OTEL ADI", "YILDIZ"};
        mdl_room_list.setColumnIdentifiers(column_room_list);
        row_room_list = new Object[column_room_list.length];

        int i;
        for(RoomTypes roomTypes: roomTypeList){
            i = 0;
            row_room_list[i++] = roomTypes.getRoomId();
            row_room_list[i++] = roomTypes.getRoomType();
            row_room_list[i++] = roomTypes.getHotelInfo().getHotelName();
            row_room_list[i++] = roomTypes.getHotelInfo().getHotelStar();
            mdl_room_list.addRow(row_room_list);
        }
        tbl_room_list.setModel(mdl_room_list);
        tbl_room_list.getTableHeader().setReorderingAllowed(false);
    }

    private void selectRoomId(){
        tbl_room_list.getSelectionModel().addListSelectionListener(e -> {
            String selectId = tbl_room_list.getValueAt(tbl_room_list.getSelectedRow(), 0).toString();
            fld_select_room.setText(selectId);
        });
    }

    private void viewRoomFeatures(){
        btn_view_room.addActionListener(e -> {
            if (Helper.isFieldEmpty(fld_select_room)) {
                Helper.showMessage("Lütfen Oda Seçiniz!");
            }else{
                ViewRoomFeatures viewRoomFeatures = new ViewRoomFeatures(Integer.parseInt(fld_select_room.getText()));
                fld_select_room.setText(null);
            }
        });
    }

    private void searchRooms(){
        btn_search.addActionListener(e -> {
            String hotelName = fld_hotel_name.getText();
            String city = cmb_city.getSelectedItem().toString();
            String district = fld_district.getText();

            ArrayList<RoomTypes> roomTypeList = RoomTypesService.searchRooms(hotelName, city, district);
            listRooms(roomTypeList);
        });
    }

}
