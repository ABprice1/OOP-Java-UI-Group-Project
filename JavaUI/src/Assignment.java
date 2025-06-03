import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assignment extends JFrame {
    //Declaring All Elements & Arrays
    JTextField NameField, MobileField;
    JRadioButton MaleButton, FemaleButton;
    JComboBox<String> DayBox, MonthBox, YearBox;
    JTextArea AddressArea, OutputArea;
    JCheckBox TermsCheckBox;
    JButton SubmitButton, ResetButton;
    ButtonGroup GenderGroup;
    JLabel BottomOutputLabel,TitleLabel,NameLabel,MobileLabel,GenderLabel,DobLabel,AddressLabel;

    String[] Days = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    String[] Months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    String[] Years = {"1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025"};

    //Set Dimensions And Add To Window
    void SetComponent(JComponent component, int x,int y,int width,int height)
    {
        component.setBounds(x,y,width,height);
        add(component);
    }

    //Submit Logic
    void Submit()
    {
        if (TermsCheckBox.isSelected()) {
            String Gender = MaleButton.isSelected() ? "Male" : "Female";
            String Result = "Name : " + NameField.getText() + "\n";
            Result += "Mobile : " + MobileField.getText() + "\n";
            Result += "Gender : " + Gender + "\n";
            Result += "DOB : " + DayBox.getSelectedItem() + "/" + MonthBox.getSelectedItem() + "/" + YearBox.getSelectedItem() + "\n";
            Result += "Address : " + AddressArea.getText();
            OutputArea.setText(Result);
            BottomOutputLabel.setText("Registration Successfully..");
            return;
        }
        BottomOutputLabel.setText("Please accept the terms and conditions.");
    }

    //Reset Logic
    void Reset()
    {
        NameField.setText("");
        MobileField.setText("");
        GenderGroup.clearSelection();
        DayBox.setSelectedIndex(0);
        MonthBox.setSelectedIndex(0);
        YearBox.setSelectedIndex(0);
        AddressArea.setText("");
        TermsCheckBox.setSelected(false);
        OutputArea.setText("");
        BottomOutputLabel.setText("");
    }


    //Constructor Setting Basic Window Config
    public Assignment()
    {
        setTitle("Registration Form");
        setSize(700, 430);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
    }

    //Initializing Elements And Config Them
    void initComponents()
    {
        TitleLabel = new JLabel("Registration Form");
        TitleLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        SetComponent(TitleLabel,250, 10, 500, 25);


        NameLabel = new JLabel("Name");
        SetComponent(NameLabel,30, 50, 100, 20);

        NameField = new JTextField();
        SetComponent(NameField,150, 50, 150, 20);

        MobileLabel = new JLabel("Mobile");
        SetComponent(MobileLabel,30, 90, 100, 20);

        MobileField = new JTextField();
        SetComponent(MobileField,150, 90, 150, 20);

        GenderLabel = new JLabel("Gender");
        SetComponent(GenderLabel,30, 130, 100, 20);

        MaleButton = new JRadioButton("Male");
        FemaleButton = new JRadioButton("Female");
        GenderGroup = new ButtonGroup();
        GenderGroup.add(MaleButton);
        GenderGroup.add(FemaleButton);

        SetComponent(MaleButton,150, 130, 60, 20);
        SetComponent(FemaleButton,220, 130, 70, 20);

        DobLabel = new JLabel("DOB");
        SetComponent(DobLabel,30, 170, 100, 20);

        DayBox = new JComboBox<>(Days);
        MonthBox = new JComboBox<>(Months);
        YearBox = new JComboBox<>(Years);

        SetComponent(DayBox,150, 170, 50, 20);
        SetComponent(MonthBox,210, 170, 60, 20);
        SetComponent(YearBox,280, 170, 60, 20);

        AddressLabel = new JLabel("Address");
        SetComponent(AddressLabel,30, 210, 100, 20);

        AddressArea = new JTextArea();
        SetComponent(AddressArea,150, 210, 200, 60);

        TermsCheckBox = new JCheckBox("Accept Terms And Conditions.");
        SetComponent(TermsCheckBox,150, 280, 250, 20);

        SubmitButton = new JButton("Submit");
        SetComponent(SubmitButton,150, 310, 80, 25);
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Submit();
            }
        });

        ResetButton = new JButton("Reset");
        SetComponent(ResetButton,250, 310, 80, 25);
        ResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reset();
            }
        });

        BottomOutputLabel = new JLabel("");
        BottomOutputLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        SetComponent(BottomOutputLabel,30, 350, 300, 20);

        OutputArea = new JTextArea();
        OutputArea.setEditable(false);
        SetComponent(OutputArea,400, 50, 250, 300);
    }
    public static void main(String[] Args) {
        new Assignment().setVisible(true);
    }
}
