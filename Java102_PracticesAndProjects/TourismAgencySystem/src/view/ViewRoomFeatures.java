package view;

import general.Config;
import general.Helper;
import model.Amenity;
import model.HostelType;
import model.Hotel_Info;
import model.RoomTypes;
import service.AmenityService;
import service.HostelTypeService;
import service.Hotel_InfoService;
import service.RoomTypesService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewRoomFeatures extends JFrame{
    private JPanel wrapper;
    private JPanel pnl_hotel_info;
    private JPanel pnl_amenity;
    private JPanel pnl_hostel_type;
    private JPanel pnl_room_types;
    private JLabel lbl_hotel_name;
    private JLabel lbl_hotel_mail;
    private JLabel lbl_hotel_phone_number;
    private JLabel lbl_hotel_star;
    private JTextArea txt_hotel_full_address;
    private JLabel lbl_hotel_city;
    private JTextField fld_hotel_name;
    private JTextField fld_hotel_mail;
    private JTextField fld_hotel_phone_number;
    private JLabel lbl_hotel_Adress;
    private JTextField fld_hotel_address;
    private JTextField fld_hotel_star;
    private JLabel lbl_general_title;
    private JTextField fld_hotel_city;
    private JLabel lbl_amenity;
    private JPanel pnl_amenity_detail;
    private JLabel lbl_free_parking;
    private JLabel lbl_free_wifi;
    private JLabel lbl_swimming_pool;
    private JLabel lbl_fitness_center;
    private JLabel lbl_hotel_concierge;
    private JLabel lbl_spa;
    private JLabel lbl_room_service;
    private JLabel lbl_pension;
    private JLabel lbl_ultra_all_in;
    private JLabel lbl_all_in;
    private JLabel lbl_room_breakfast;
    private JLabel lbl_full_pension;
    private JLabel lbl_half_pension;
    private JLabel lbl_only_bed;
    private JLabel lbl_full_credit_not_alcohol;
    private JLabel lbl_room_type_title;
    private JTextField fld_room_type;
    private JLabel lbl_room_type;
    private JPanel pnl_hostel_type_detail;
    private JPanel pnl_room_type;
    private JPanel pnl_room_type_detail;
    private JTextField fld_bed_number;
    private JLabel lbl_bed_number;
    private JLabel lbl_has_tv;
    private JLabel lbl_has_minibar;
    private JLabel lbl_has_game_console;
    private JTextField fld_size;
    private JLabel lbl_size;
    private JLabel lbl_has_cash_box;
    private JLabel lbl_has_projection;
    private JPanel pnl_general_title;
    private JPanel pnl_actions;
    private JButton btn_price_info;

    public ViewRoomFeatures(int roomId){
        add(wrapper);
        Helper.setDefaultTheme();
        setSize(980,850);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setTitle(Config.APP_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        createHotelInfos(roomId);
        createAmenity(roomId);
        createHostelType(roomId);
        createRoomType(roomId);
        goRoomPricePage(roomId);
    }

    private void createHotelInfos(int roomId){
        for(Hotel_Info hotelInfo: Hotel_InfoService.getHotelInfoByHotelId(RoomTypesService.getHotelIdByRoomId(roomId))){
            fld_hotel_name.setText(hotelInfo.getHotelName());
            fld_hotel_mail.setText(hotelInfo.getHotelMail());
            fld_hotel_phone_number.setText(hotelInfo.getHotelPhoneNumber());
            fld_hotel_star.setText(" " + String.valueOf(hotelInfo.getHotelStar()) + " Yıldız ");
            fld_hotel_city.setText(hotelInfo.getCity() + " / " + hotelInfo.getDistrict());
            fld_hotel_address.setText(hotelInfo.getHotelAddress());
        }
    }

    private void createAmenity(int roomId){
        for(Amenity amenity: AmenityService.getAmenityByHotelId(RoomTypesService.getHotelIdByRoomId(roomId))){
            lbl_free_parking.setText(Helper.hasOrNot(amenity.getFreeParking(), "Ücretsiz Park Yeri"));
            lbl_free_wifi.setText(Helper.hasOrNot(amenity.getFreeWifi(), "Ücretsiz Wifi"));
            lbl_swimming_pool.setText(Helper.hasOrNot(amenity.getSwimmingPool(), "Yüzme Havuzu"));
            lbl_fitness_center.setText(Helper.hasOrNot(amenity.getFitnessCenter(), "Fitness Merkezi"));
            lbl_hotel_concierge.setText(Helper.hasOrNot(amenity.getHotelConcierge(), "Hotel Concierge"));
            lbl_spa.setText(Helper.hasOrNot(amenity.getSpa(), "Spa"));
            lbl_room_service.setText(Helper.hasOrNot(amenity.getRoomService(), "Oda Servis"));
        }
    }

    private void createHostelType(int roomId){
        for(HostelType hostelType: HostelTypeService.getListByHotelId(RoomTypesService.getHotelIdByRoomId(roomId))){
            lbl_ultra_all_in.setText(Helper.hasOrNot(hostelType.getUltraAllIn(), "Ultra Herşey Dahil"));
            lbl_all_in.setText(Helper.hasOrNot(hostelType.getAllIn(), "Herşey Dahil"));
            lbl_room_breakfast.setText(Helper.hasOrNot(hostelType.getRoomBreakfast(), "Oda Kahvaltı"));
            lbl_full_pension.setText(Helper.hasOrNot(hostelType.getFullPension(), "Tam Pansiyon"));
            lbl_half_pension.setText(Helper.hasOrNot(hostelType.getHalfPension(), "Yarım Pansiyon"));
            lbl_only_bed.setText(Helper.hasOrNot(hostelType.getOnlyBed(), "Sadece Yatak"));
            lbl_full_credit_not_alcohol.setText(Helper.hasOrNot(hostelType.getFullCreditNotAlcohol(), "Alkol Hariç Full Credit"));
        }
    }

    private void createRoomType(int roomId){
        for(RoomTypes roomTypes: RoomTypesService.getRoomTypeByRoomId(roomId)){
            fld_room_type.setText(roomTypes.getRoomType());
            fld_bed_number.setText(String.valueOf(roomTypes.getBedNumber()) + " Adet Yatak");
            fld_size.setText(String.valueOf(roomTypes.getSize()) + " Metre");
            lbl_has_tv.setText(Helper.hasOrNot(roomTypes.getHasTv(), "Televizyon"));
            lbl_has_minibar.setText(Helper.hasOrNot(roomTypes.getHasMinibar(), "Minibar"));
            lbl_has_game_console.setText(Helper.hasOrNot(roomTypes.getHasGameConsole(), "Oyun Konsolu"));
            lbl_has_cash_box.setText(Helper.hasOrNot(roomTypes.getHasCashBox(), "Kasa"));
            lbl_has_projection.setText(Helper.hasOrNot(roomTypes.getHasProjection(), "Projeksiyon"));
        }
    }

    private void goRoomPricePage(int roomId) {
        btn_price_info.addActionListener(e -> {
            CalculateRoomPrice calculateRoomPrice = new CalculateRoomPrice(roomId);
        });
    }

}
