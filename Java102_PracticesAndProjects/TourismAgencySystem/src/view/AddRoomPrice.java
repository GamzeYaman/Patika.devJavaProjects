package view;

import general.Config;
import general.Helper;
import general.Item;
import model.HostelType;
import service.HostelTypeService;

import javax.swing.*;

public class AddRoomPrice extends JFrame {

    private JPanel wrapper;
    private JPanel pnl_period;
    private JComboBox cmb_first_hostel_types;
    private JButton btn_add_first_period_price;
    private JPanel pnl_select_pension;
    private JComboBox cmb_hostel_types;
    private JButton btn_add_period_price;
    private JTextArea area_note;
    private JPanel pnl_note;

    public AddRoomPrice(int roomId, int hotelId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(300,400);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        loadHostelTypesCombo(hotelId);
        goPensionPricing(roomId, hotelId);
    }

    private void goPensionPricing(int roomId, int hotelId) {
        btn_add_period_price.addActionListener(e -> {
            if(cmb_hostel_types.getSelectedItem() == null){
                Helper.showMessage("fill");
            }else{
                Item pension = (Item) cmb_hostel_types.getSelectedItem();
                AddPensionPricing pricing = new AddPensionPricing(hotelId, roomId, pension.getKey(), pension.getValue());
            }
        });
    }

    public void loadHostelTypesCombo(int hotelId){
        cmb_hostel_types.removeAllItems();
        for(HostelType hostelType: HostelTypeService.getListByHotelId(hotelId)){
            if(hostelType.getUltraAllIn().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Ultra Herşey Dahil"));
            }
            if(hostelType.getAllIn().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Herşey Dahil"));
            }
            if(hostelType.getFullPension().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Tam Pansiyon"));
            }
            if(hostelType.getHalfPension().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Yarım Pansiyon"));
            }
            if(hostelType.getRoomBreakfast().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Oda Kahvaltı"));
            }
            if(hostelType.getOnlyBed().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Sadece Yatak"));
            }
            if(hostelType.getFullCreditNotAlcohol().equals("Var")){
                cmb_hostel_types.addItem(new Item(hostelType.getHostelTypeId(), "Alkol Hariç Full Credit"));
            }
        }
    }

}
