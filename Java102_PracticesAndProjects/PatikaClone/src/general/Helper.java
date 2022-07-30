package general;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static int screenLocationCenter(String axis, Dimension wrapperSize){
        int point = 0;

        switch(axis){
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - wrapperSize.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - wrapperSize.height) / 2;
                break;
            default:
                point = 0;
        }

        return point;
    }

    public static void setDefaultTheme(){
        for(UIManager.LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
            if("Mimbus".equals(info.getName())){
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
            }
            break;
        }
    }

    public static boolean isFieldEmpty(JTextField textField){
        return textField.getText().trim().isEmpty();
    }

    public static void showMessage(String str){
        optionPaneTR();
        String message;
        String title = null;

        switch (str){
            case "fill":
                message = "Tüm alanlar doldurulmalıdır!";
                title = "Hata";
                break;
            case "save" :
                message = "Başarıyla eklendi.";
                title = "Sonuç";
                break;
            case "error" :
                message = "İşlem başarısız oldu!";
                title = "Sonuç";
                break;
            case "duplicate" :
                message = "Lütfen farklı bir kullanıcı adı giriniz.";
                title = "Hata";
                break;
            case "delete" :
                message = "Bu numaraya ait kullanıcı bulunamadı!";
                title = "Hata";
                break;
            case "success" :
                message = "İşlem başarıyla gerçekleşti!";
                title = "Sonuç";
                break;
            case "register":
                message = "Sisteme kayıtlı kullanıcı bulunamadı. Kayıt olmalısınız!";
                break;
            default:
                message = str;
        }

        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void optionPaneTR(){
        UIManager.put("OptionPane.okButtonText", "Tamam");
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");
    }

    public static boolean confirm(String str){
        String message;

        switch(str){
            case "sure":
                message = "Bağlantılı bilgilerde silinecek! Bu işlemi gerçekleştirmek istediğinize emin misiniz?";
                break;
            case "add":
                message = "Bu derse kayıt olmak mı istiyorsunuz?";
                break;
            default:
                message = str;
        }
        return JOptionPane.showConfirmDialog(null, message, "Son kararın mı?", JOptionPane.YES_NO_OPTION) == 0;
    }
}
