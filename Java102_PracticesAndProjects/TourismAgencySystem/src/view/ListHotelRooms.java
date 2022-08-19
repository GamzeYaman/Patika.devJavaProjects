package view;

import general.Config;
import general.Helper;
import model.RoomTypes;
import service.Hotel_InfoService;
import service.RoomTypesService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListHotelRooms extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_room_type_list;
    private JTable tbl_room_type_list;
    private JPanel pnl_top;
    private JLabel lbl_hotel_name;
    private JButton btn_price;
    private JTextField fld_take_room_id;
    private JLabel lbl_take_room_id;
    private DefaultTableModel mdl_room_type_list;
    private Object[] row_room_type_list;

    public ListHotelRooms(int hotelId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(350,350);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        generalTitle(hotelId);
        getList(hotelId);
        selectRoomId();
        goAddingPricePage(hotelId);
    }

    private void generalTitle(int hotelId){
        lbl_hotel_name.setText(Hotel_InfoService.getHotelNameById(hotelId));
    }

    private void getList(int hotelId){
        mdl_room_type_list = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                if(column == 0)
                    return false;
                return super.isCellEditable(row, column);
            }
        };

        Object[] column_room_type_list = {"ID", "ODA TİPİ"};
        mdl_room_type_list.setColumnIdentifiers(column_room_type_list);
        row_room_type_list = new Object[column_room_type_list.length];

        int i;
        for(RoomTypes roomTypes: RoomTypesService.getListByHotelId(hotelId)){
            i = 0;
            row_room_type_list[i++] = roomTypes.getRoomId();
            row_room_type_list[i++] = roomTypes.getRoomType();
            mdl_room_type_list.addRow(row_room_type_list);
        }
        tbl_room_type_list.setModel(mdl_room_type_list);
        tbl_room_type_list.getTableHeader().setReorderingAllowed(false);
    }

    private void goAddingPricePage(int hotelId) {
        btn_price.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_take_room_id)){
                Helper.showMessage("Lütfen Oda Seçiniz!");
            }else{
                AddRoomPrice addRoomPrice = new AddRoomPrice(Integer.parseInt(fld_take_room_id.getText()), hotelId);
                fld_take_room_id.setText(null);
            }
        });
    }

    private void selectRoomId(){
        tbl_room_type_list.getSelectionModel().addListSelectionListener(e ->{
            String selectedId = tbl_room_type_list.getValueAt(tbl_room_type_list.getSelectedRow(), 0).toString();
            fld_take_room_id.setText(selectedId);
        });
    }
}
