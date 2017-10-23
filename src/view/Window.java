package view;

import model.MM1;
import model.MM1K;
import model.MMS;
import model.kendal;

import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by JuAmo_000 on 17/10/2017.
 */
public class Window extends JFrame{
    private JPanel mainPane;
    private JPanel inputPane;
    private JPanel serveurPanel;
    private JPanel clientsPanel;
    private JPanel arrivePanel;
    private JPanel departPanel;
    private JTextField lambda_field;
    private JTextField mu_field;
    private JTextField serveur_field;
    private JRadioButton serverRadioBtn;
    private JTextField clients_max_field;
    private JRadioButton clientsRadioBtn;
    private JPanel resultPane;
    private JTextField jInput;
    private JLabel qResult;
    private JPanel qResultPanel;
    private JPanel lResultPanel;
    private JPanel lqResultPanel;
    private JPanel wResultPanel;
    private JPanel wqResultPanel;
    private JPanel tauResultPanel;
    private JLabel lValue;
    private JLabel lqvalue;
    private JLabel wValue;
    private JLabel wqValue;
    private JTextField tInput;
    private JLabel tauValue;
    private JRadioButton classicRadioButton;
    private ButtonGroup btnGrp;

    private Class selected_mode;
    private kendal file;

    public Window(){
        setContentPane(mainPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        btnGrp = new ButtonGroup();
        btnGrp.add(serverRadioBtn);
        btnGrp.add(clientsRadioBtn);
        btnGrp.add(classicRadioButton);

        classicRadioButton.setSelected(true);

        mu_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateGeneralValues();
            }
        });
        lambda_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateGeneralValues();
            }
        });
        serveur_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateServerValue();
            }
        });
        clients_max_field.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateKlientValue();
            }
        });
        jInput.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateJValue();
            }
        });
        tInput.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                updateTauValue();
            }
        });
        classicRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMM1();
            }
        });
        clientsRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMM1K();
            }
        });
        serverRadioBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setMMS();
            }
        });
    }

    private void updateGeneralValues(){
        if(lambdaMuValid()){
            if(classicRadioButton.isSelected()) setMM1();
            if(clientsRadioBtn.isSelected()) setMM1K();
            if(serverRadioBtn.isSelected()) setMMS();
            printResults();
        }
    }

    private void updateServerValue(){
        if(serverRadioBtn.isSelected() && lambdaMuValid()){
            setMMS();
            printResults();
        }
    }

    private void updateKlientValue(){
        if(clientsRadioBtn.isSelected() && lambdaMuValid()){
            setMM1K();
            printResults();
        }
    }

    private void updateJValue(){
        try{
            int j = Integer.parseInt(jInput.getText());
            qResult.setText("" + file.getQi(j));
        }
        catch(NumberFormatException exc){qResult.setText("undefined");}
    }

    private void updateTauValue(){
        try{
            float t = Float.parseFloat(tInput.getText());
            tauValue.setText("" + file.getTau(t));
        }
        catch(NumberFormatException exc){ tauValue.setText("undefined");}
    }

    private void setMM1(){
        try{
            float lambda = Float.parseFloat(lambda_field.getText());
            float mu = Float.parseFloat(mu_field.getText());
            file = new MM1(lambda, mu);
            printResults();
        }
        catch (NumberFormatException exc){
            System.out.println("One of the values is not valid!");
        }
    }

    private void setMM1K(){
        try{
            float lambda = Float.parseFloat(lambda_field.getText());
            float mu = Float.parseFloat(mu_field.getText());
            int k = Integer.parseInt(clients_max_field.getText());
            file = new MM1K(lambda, mu, k);
        }
        catch (NumberFormatException exc)
        {
            System.out.println("Invalid number format");
        }
    }

    private void setMMS(){
        try{
            float lambda = Float.parseFloat(lambda_field.getText());
            float mu = Float.parseFloat(mu_field.getText());
            int s;
            if(serveur_field.getText().equals("")){
                s = 2;
                serveur_field.setText("2");
            }
            else s = Integer.parseInt(serveur_field.getText());
            file = new MMS(lambda, mu, s);
        }
        catch (Exception exc)
        {
            System.out.println("Invalid number format");
        }
    }

    private void printResults(){
        updateJValue();
        lValue.setText("" + file.getL());
        lqvalue.setText("" + file.getLq());
        wValue.setText("" + file.getW());
        wqValue.setText("" + file.getWq());
        updateTauValue();
        lambdaMuValid();
    }

    private boolean lambdaMuValid(){
        try{
            float lambda = Float.parseFloat(lambda_field.getText());
            float mu = Float.parseFloat(mu_field.getText());
            if(!file.isValid()) return true;
        }
        catch (Exception exc){}
        finally
        {
            qResult.setText("undefined");
            lValue.setText("undefined");
            lqvalue.setText("undefined");
            wValue.setText("undefined");
            wqValue.setText("undefined");
            tauValue.setText("undefined");
            return false;
        }
    }
}
