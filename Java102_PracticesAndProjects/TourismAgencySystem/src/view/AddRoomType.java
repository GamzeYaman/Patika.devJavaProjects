package view;

import general.Config;
import general.Helper;
import service.RoomTypesService;

import javax.swing.*;

public class AddRoomType extends JFrame {
    private JPanel wrapper;
    private JPanel pnl_top;
    private JPanel pnl_bottom;
    private JLabel lbl_general_type;
    private JComboBox cmb_room_type;
    private JSpinner spn_room_amount;
    private JLabel lbl_room_type;
    private JLabel lbl_room_amount;
    private JTextField txt_size;
    private JSpinner spn_bed_number;
    private JLabel lbl_size;
    private JLabel lbl_bed_number;
    private JComboBox cmb_has_tv;
    private JComboBox cmb_has_minibar;
    private JLabel lbl_has_tv;
    private JLabel lbl_has_minibar;
    private JComboBox cmb_has_game_console;
    private JComboBox cmb_has_cash_box;
    private JLabel lbl_has_game_console;
    private JLabel lbl_has_cash_box;
    private JComboBox cmb_has_projection;
    private JLabel lbl_has_projection;
    private JButton btn_save_room_types;
    private JPanel pnl_button;

    public AddRoomType(int hotelId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(600,450);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        saveRoomType(hotelId);
    }

    private void saveRoomType(int hotelId) {
        btn_save_room_types.addActionListener(e -> {
            if(validationOfIsEmpty()){
                if(RoomTypesService.add(hotelId, cmb_room_type.getSelectedItem().toString(), Integer.parseInt(spn_room_amount.getValue().toString()), Integer.parseInt(spn_bed_number.getValue().toString()),
                        cmb_has_tv.getSelectedItem().toString(), cmb_has_minibar.getSelectedItem().toString(), cmb_has_game_console.getSelectedItem().toString(),
                        Integer.parseInt(txt_size.getText()), cmb_has_cash_box.getSelectedItem().toString(), cmb_has_projection.getSelectedItem().toString(), Integer.parseInt(spn_room_amount.getValue().toString()))){
                    if(Helper.confirmAction("another")){
                        AddRoomType addRoomType = new AddRoomType(hotelId);
                        dispose();
                    }else{
                        Helper.showMessage("save");
                        dispose();
                    }
                }else{
                    Helper.showMessage("error");
                }
            }
        });
    }

    private boolean validationOfIsEmpty() {
        if(Helper.isFieldEmpty(txt_size) || cmb_room_type.getSelectedItem() == null || spn_room_amount.getValue().equals(0) || spn_bed_number.getValue().equals(0)
        || cmb_has_tv.getSelectedItem() == null || cmb_has_minibar.getSelectedItem() == null || cmb_has_game_console.getSelectedItem() == null
        || cmb_has_cash_box.getSelectedItem() == null || cmb_has_projection.getSelectedItem() == null){
            Helper.showMessage("fill");
            return false;
        }else{
            return true;
        }
    }
}
