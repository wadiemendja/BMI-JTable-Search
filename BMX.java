import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
public class BMI {
    public static void main(String[] args) {
        JFrame window = new JFrame("IHM Project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000,600); 
        window.setResizable(false);
        JPanel pan = new JPanel();
        JPanel pan1 = new JPanel();
        pan.setLayout(null);
        pan1.setLayout(null);
        window.setContentPane(pan);
        pan.add(pan1);
        TitledBorder panTitle = new TitledBorder(" Insert info ") ;
        TitledBorder winTitle = new TitledBorder(" Body Mass Index ") ;
        panTitle.setTitleJustification(TitledBorder.CENTER);
        winTitle.setTitleJustification(TitledBorder.CENTER);
        pan.setBorder(winTitle);
        pan1.setBackground(Color.LIGHT_GRAY);
        pan1.setBounds(50,50,200,400);
        pan1.setBorder(panTitle);
        JButton addBtn = new JButton ("Add");
        addBtn.setBounds(30,370,150,20);
        JButton delete = new JButton ("Delete");
        pan.add(delete);
        delete.setBounds(670,470,150,20);
        JTextField name = new JTextField() ;
        name.setBounds(40,40,120,20);
        JTextField Lname = new JTextField();
        Lname.setBounds(name.getLocation().x,name.getLocation().x+40,120,20);
        pan1.add(addBtn);
        pan1.add(name);
        pan1.add(Lname);
        JTextField search = new JTextField();
        pan.add(search);
        JLabel txt = new JLabel ("Insert :");
        JLabel FName = new JLabel ("First Name :");
        JLabel LName = new JLabel ("Last Name :");
        JLabel sexe = new JLabel ("Gander :");
        JLabel bd = new JLabel ("Age :");
        JLabel field = new JLabel ("Height : (m)");
        JLabel field2 = new JLabel ("Weight :(Kg)");
        JLabel searchLab = new JLabel ("Search :");
        pan.add(searchLab);
        searchLab.setBounds(delete.getLocation().x-320,delete.getLocation().y , delete.getSize().width,delete.getSize().height);
        search.setBounds(searchLab.getLocation().x+80,searchLab.getLocation().y , name.getSize().width,name.getSize().height);
        JSpinner aut = new JSpinner(new SpinnerNumberModel(1.50,null,null,0.01));
        pan1.add(aut);
        JSpinner poid = new JSpinner(new SpinnerNumberModel(55,40,null,1));
        pan1.add(poid);
        pan1.add(bd);
        pan1.add(field);
        pan1.add(field2);
        pan1.add(sexe);
        JRadioButton male = new JRadioButton("male");
        JRadioButton female = new JRadioButton("female");
        ButtonGroup gander = new ButtonGroup();
        JSpinner age = new JSpinner(new SpinnerNumberModel(19,18,65,1));
        pan1.add(age);
        age.setBounds(40,240,Lname.getSize().width,Lname.getSize().height+10);
        field.setBounds(age.getLocation().x,age.getLocation().y+40,Lname.getSize().width,Lname.getSize().height+10);
        field2.setBounds(age.getLocation().x+70,age.getLocation().y+40,(Lname.getSize().width)+10/2,Lname.getSize().height+10);
        aut.setBounds(field.getLocation().x,field.getLocation().y+30,(Lname.getSize().width)/2,Lname.getSize().height+10);
        poid.setBounds(field.getLocation().x+70,field.getLocation().y+30,(Lname.getSize().width)/2,Lname.getSize().height+10);
        bd.setBounds(age.getLocation().x,age.getLocation().y-30,Lname.getSize().width,Lname.getSize().height+10);
        gander.add(male);
        gander.add(female);
        pan1.add(male);
        pan1.add(female);
        male.setBounds(Lname.getLocation().x , Lname.getLocation().y+60,Lname.getSize().width,Lname.getSize().height+10);
        female.setBounds(Lname.getLocation().x , Lname.getLocation().y+85,Lname.getSize().width,Lname.getSize().height+10);
        FName.setBounds(name.getLocation().x , name.getLocation().y-20,name.getSize().width,name.getSize().height);
        LName.setBounds(Lname.getLocation().x , Lname.getLocation().y-20,Lname.getSize().width,Lname.getSize().height);
        sexe.setBounds(male.getLocation().x , male.getLocation().y-30,Lname.getSize().width,Lname.getSize().height+10);
        pan1.add(FName);
        pan1.add(LName);
        JLabel copyright = new JLabel("-----   All Rights Reserved © TP de IHM  -----");
        copyright.setBounds(350,545,300,20);
        pan.add(copyright,BorderLayout.PAGE_END);
        JPanel pan2 = new JPanel () ;
        pan2.setBounds(50,50,300,400);
        pan2.setBounds(pan1.getLocation().x+300,pan1.getLocation().x,500,pan1.getSize().height);
        pan2.setBorder(BorderFactory.createLineBorder(Color.black));
        pan.add(pan2);
        String[] columns = {"First Name","Last Name","Age","Gander","BMI","Note"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVisible(true);
        pan2.add(scrollPane);
        TableColumn column= null ;
        for (int i = 0; i < 6; i++) {
        column = table.getColumnModel().getColumn(i);
        if (i == 2) {
            column.setPreferredWidth(100); //third column is bigger
        } else {
            column.setPreferredWidth(75);
             }
        }
        Object data1 [] =  { 
                      "mendja",
                      "wadie",
                      "20",
                      "male",
                      "25.0",
                      "Overweight",
                  } ;
        model.addRow(data1);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        table.setFillsViewportHeight(true);
        pan2.add(table.getTableHeader(),BorderLayout.NORTH);
        pan2.add(table,BorderLayout.CENTER);
        pan2.setBackground(Color.GRAY);
        addBtn.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                double bmi = Double.parseDouble(poid.getValue().toString())/Math.pow(Double.parseDouble(aut.getValue().toString()),2);
                String BMI = String.format("%1$,.2f", bmi);
                if (name.getText()!="" && Lname.getText()!="" &&( male.isSelected() || female.isSelected())) {
                    String gander ;
                    if (male.isSelected()) gander = male.getText();else gander = female.getText();
                    String remarque ;
                    if (bmi >= 25.0) remarque = "Overweight" ; else if(bmi>=18.50 && bmi<=24.9) remarque = "Healthy";
                    else remarque = "Underweight" ;
                  Object data [] =  { 
                      name.getText(),
                      Lname.getText(),
                      age.getValue(),
                      gander,
                      BMI,
                      remarque
                  };
                  model.addRow(data);
                }else JOptionPane.showMessageDialog(null, "You must complete the formula !!");
            }
        });
        search.getDocument().addDocumentListener(new DocumentListener () {
                @Override
                public void insertUpdate(DocumentEvent e) {        
                        for (int i =0 ; i<model.getRowCount();i++) {
                          if (Pattern.matches((String)search.getText(),(String) model.getValueAt(i,0))) {
                              //System.out.println(model.getValueAt(i,j));
                              table.setRowSelectionInterval(i,i);
                              break;
                            }else if (Pattern.matches((String)search.getText(),(String) model.getValueAt(i,1))) {
                              //System.out.println(model.getValueAt(i,j));
                              table.setRowSelectionInterval(i,i);
                              break;  
                          }
                        }  
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                   table.clearSelection();  
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                 table.clearSelection();
                }
            });
        
        delete.addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                int count =0 ;
                    for (int i =0 ; i<model.getRowCount();i++) {    
                        if (table.isRowSelected(i)) {
                          count++ ;
                        }
                    } 
                if (count ==0) {
                    JOptionPane.showMessageDialog(null, "Select to delete");
                }else    
                 ((DefaultTableModel)table.getModel()).removeRow(table.getSelectedRow());  
            }
            
        });
        window.setVisible(true);
    }
}