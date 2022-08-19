package general;

import service.RoomPricingService;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Helper {

    public static int screenLocationCenter(String axis, Dimension size){
        int point = 0;
        switch(axis){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.height) / 2;
                break;
            default :
                point = 0;
        }
        return point;
    }



    public static void setDefaultTheme(){
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if("CDE/Motif".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    public static boolean isFieldEmpty(JTextField jTextField){
        return jTextField.getText().trim().isEmpty();
    }

    public static void showMessage(String action){
        optionPaneTR();
        String message = "";

        switch (action){
            case "fill":
                message = "Tüm alanlar doldurulmalıdır!";
                break;
            case "save":
                message = "Başarıyla eklendi.";
                break;
            case "error":
                message = "İşlem başarısız oldu.";
                break;
            case "success":
                message = "İşlem başarıyla gerçekleşti.";
                break;
            case "duplicate":
                message = "Eposta adresi veya telefon numarası daha önce alınmış!";
                break;
            default:
                message = action;
        }
        JOptionPane.showMessageDialog(null, message, null, JOptionPane.INFORMATION_MESSAGE);
    }

    public static String hasOrNot(String has, String amenity){
        String str = "";
        switch(has){
            case "Var":
                str = amenity + "  ✔️";
                break;
            case "Yok":
                str = amenity + "  ❌ ";
                break;
            default:
                str = amenity;
        }
        return str;
    }

    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }

    public static boolean confirmAction(String action){
        String message = "";

        switch (action){
            case "save":
                message = "Kaydetmek istediğinizden emin misniz?";
                break;
            case "another":
                message = "Başka Oda Eklemek İstiyormusunuz?";
                break;
            case "reservation":
                message = "Rezervasyon yapmak istediğinizden emin misiniz?";
                break;
            default:
                message = action;
        }

        return JOptionPane.showConfirmDialog(null, message, null, JOptionPane.YES_NO_OPTION) == 0;
    }

    public static double adultRoomPriceAccordingToPeriod(String startDate, String endDate, int roomId){
        double adultRoomPrice = 0;
        String firstPeriodStart = "01/05/2022";
        String firstPeriodEnd = "30/09/2022";
        String secondPeriodStart = "01/10/2022";
        String secondPeriodEnd = "30/04/2023";
        Date firstPeriodMin, firstPeriodMax, secondPeriodMin, secondPeriodMax;
        Date startingDate;
        Date endingDate;

        try {
            firstPeriodMin = new SimpleDateFormat("dd/MM/yyyy").parse(firstPeriodStart);
            secondPeriodMin = new SimpleDateFormat("dd/MM/yyyy").parse(secondPeriodStart);
            firstPeriodMax = new SimpleDateFormat("dd/MM/yyyy").parse(firstPeriodEnd);
            secondPeriodMax = new SimpleDateFormat("dd/MM/yyyy").parse(secondPeriodEnd);
            startingDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            endingDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            if(startingDate.after(firstPeriodMin) && startingDate.before(firstPeriodMax) && endingDate.after(firstPeriodMin) && endingDate.before(firstPeriodMax)){
                adultRoomPrice = RoomPricingService.getAdultFirstPeriodRoomPrice(roomId);
            }else if(startingDate.after(secondPeriodMin) && startingDate.before(secondPeriodMax) && endingDate.after(secondPeriodMin) && endingDate.before(secondPeriodMax)){
                adultRoomPrice = RoomPricingService.getAdultSecondPeriodRoomPrice(roomId);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return adultRoomPrice;
    }

    public static double kidRoomPriceAccordingToPeriod(String startDate, String endDate, int roomId){
        double kidRoomPrice = 0;
        String firstPeriodStart = "01/05/2022";
        String firstPeriodEnd = "30/09/2022";
        String secondPeriodStart = "01/10/2022";
        String secondPeriodEnd = "30/04/2023";
        Date firstPeriodMin, firstPeriodMax, secondPeriodMin, secondPeriodMax;
        Date startingDate;
        Date endingDate;

        try {
            firstPeriodMin = new SimpleDateFormat("dd/MM/yyyy").parse(firstPeriodStart);
            secondPeriodMin = new SimpleDateFormat("dd/MM/yyyy").parse(secondPeriodStart);
            firstPeriodMax = new SimpleDateFormat("dd/MM/yyyy").parse(firstPeriodEnd);
            secondPeriodMax = new SimpleDateFormat("dd/MM/yyyy").parse(secondPeriodEnd);
            startingDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            endingDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            if(startingDate.after(firstPeriodMin) && startingDate.before(firstPeriodMax) && endingDate.after(firstPeriodMin) && endingDate.before(firstPeriodMax)){
                kidRoomPrice = RoomPricingService.getKidFirstPeriodRoomPrice(roomId);
            }else if(startingDate.after(secondPeriodMin) && startingDate.before(secondPeriodMax) && endingDate.after(secondPeriodMin) && endingDate.before(secondPeriodMax)){
                kidRoomPrice = RoomPricingService.getKidSecondPeriodRoomPrice(roomId);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return kidRoomPrice;
    }

    public static long getDayNumberBetweenTwoDate(String startDate, String endDate){
        long difDay = 0;

        try {
            Date startingDate = new SimpleDateFormat("dd/MM/yyyy").parse(startDate);
            Date endingDate = new SimpleDateFormat("dd/MM/yyyy").parse(endDate);
            long days = endingDate.getTime() - startingDate.getTime();
            difDay = TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difDay;
    }

}
