package sust.buildingsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SearchPanel extends JPanel implements ActionListener {
    JLabel noLabel;//住户号
    JTextField noText;
    JTable table;
    DefaultTableModel model;
    JScrollPane scrol;
    JButton button;


    public SearchPanel(){
        this.setSize(500,700);
        this.setBackground(Color.LIGHT_GRAY);
      //  this.setLayout(null);

        String[] columns={"住户号码","现住人数","户主姓名","户主性别"};
        String[][] record={};
        model=new DefaultTableModel(record,columns);
        table=new JTable(model);
        scrol=new JScrollPane(table);
        scrol.setPreferredSize(new Dimension(500,500));
        scrol.setBounds(10,250,455,400);
        this.add(scrol);
        this.init();
        this.setVisible(true);


    }



    //初始化面板
    private void init(){
        noLabel=new JLabel("请输入住户号");
        noLabel.setSize(90,30);
        noLabel.setLocation(30,20);
        noText=new JTextField();
        noText.setSize(180,30);
        noText.setLocation(120,20);
        button=new JButton("查找");
        button.setSize(80,30);
        button.setLocation(120,220);


        this.add(noLabel);
        this.add(noText);
        this.add(button);


      button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              int no=Integer.parseInt(noText.getText());
              DatabaseLoad data=new DatabaseLoad();
              if(data.isExist(no)){
                  People people = data.query(no);
                  Vector<String> row=new Vector<>();
                  row.add(String.valueOf(people.getNo()));
                  row.add(String.valueOf(people.getNumber()));
                  row.add(people.getName());
                  row.add(people.getSex());
                  Vector<String> col=new Vector<>();
                  col.add("住户号码");
                  col.add("现住人数");
                  col.add("户主姓名");
                  col.add("户主性别");
                  Vector <Vector<String>> data1=new Vector<>();
                  data1.add(row);
                  model.setDataVector(data1,col);
                  System.out.println(people.getName());
                  JOptionPane.showMessageDialog(null,"查询成功");
              }else{
                  JOptionPane.showMessageDialog(null,"所查找的住户不存在");
              }
          }
      });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
