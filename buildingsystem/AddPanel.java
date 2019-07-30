package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel implements ActionListener {
    JLabel noLabel;//住户号
    JLabel numLabel;//现住人数
    JLabel nameLabel;//户主姓名
    JLabel sexLabel;//住户性别
    JComboBox sexCom;//户主性别下拉框
    JTextField noText;
    JTextField numText;
    JTextField nameText;
    JButton button;

    public AddPanel(){
        this.setSize(500,700);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.init();
        this.setVisible(true);


    }

    //初始化面板
    private void init(){
        noLabel=new JLabel("请输入住户号");
        noLabel.setSize(90,30);
        noLabel.setLocation(30,20);
        numLabel=new JLabel("请输入人数");
        numLabel.setSize(90,30);
        numLabel.setLocation(30,70);
        nameLabel=new JLabel("请输入户主名");
        nameLabel.setSize(90,30);
        nameLabel.setLocation(30,120);
        sexLabel =new JLabel("请选择性别");
        sexLabel.setSize(90,30);
        sexLabel.setLocation(30,170);
        noText=new JTextField();
        noText.setSize(180,30);
        noText.setLocation(120,20);
        numText=new JTextField();
        numText.setSize(180,30);
        numText.setLocation(120,70);
        nameText=new JTextField();
        nameText.setSize(180,30);
        nameText.setLocation(120,120);
        sexCom=new JComboBox();
        sexCom.setSize(180,30);
        sexCom.setLocation(120,170);
        sexCom.addItem("男");
        sexCom.addItem("女");
        button=new JButton("添加");
        button.setSize(80,30);
        button.setLocation(120,220);


        this.add(noLabel);
        this.add(numLabel);
        this.add(nameLabel);
        this.add(sexLabel);
        this.add(sexCom);
        this.add(noText);
        this.add(numText);
        this.add(nameText);
        this.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int no=Integer.parseInt(noText.getText());
                int number=Integer.parseInt(numText.getText());
                String name=nameText.getText();
                String sex=sexCom.getSelectedItem().toString();
                DatabaseLoad data=new DatabaseLoad();
                if(!data.isExist(no)){
                    People people=new People();
                    people.setNo(no);
                    people.setNumber(number);
                    people.setName(name);
                    people.setSex(sex);
                    data.add(people);
                    JOptionPane.showMessageDialog(null,"添加成功");
                }else{
                    JOptionPane.showMessageDialog(null,"输入的住户号已存在");
                }

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
