package view;

import general.Config;
import general.Helper;
import model.Patika;

import javax.swing.*;


public class UpdatePatikaGUI extends JFrame{
    private JPanel wrapper;
    private JLabel lbl_patika_name;
    private JTextField fld_patika_name;
    private JButton btn_update;
    private Patika patika;

    public UpdatePatikaGUI(Patika patika){
        this.patika = patika;

        Helper.setDefaultTheme();
        add(wrapper);
        setSize(300,150);
        setLocation(Helper.screenLocationCenter("x", getSize()), Helper.screenLocationCenter("y", getSize()));
        setResizable(true);
        setTitle(Config.appTitle);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        updatePatika(patika);


    }

    private void updatePatika(Patika patika) {
        fld_patika_name.setText(patika.getPatikaName());
        btn_update.addActionListener(e -> {
            if(Helper.isFieldEmpty(fld_patika_name)){
                Helper.showMessage("fill");
            }else{
                if(Patika.update(patika.getPatikaId(), fld_patika_name.getText())){
                    Helper.showMessage("success");
                }
                dispose();
            }
        });
    }

}
