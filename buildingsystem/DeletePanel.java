package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel extends JPanel implements ActionListener {
    JLabel noLabel;//住户号
    JTextField noText;
    JScrollPane scroll;//滚动面板
    // JTable table;
    JButton button;

    public DeletePanel(){
        this.setSize(500,700);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.init();
        //this.refreshTabel();
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
        button=new JButton("删除");
        button.setSize(80,30);
        button.setLocation(120,220);


        this.add(noLabel);
        this.add(noText);
        this.add(button);

     //删除按钮事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int no= Integer.parseInt(noText.getText());
              DatabaseLoad data=new DatabaseLoad();
              if(data.isExist(no)){
                  data.remove(no);
                  JOptionPane.showMessageDialog(null,"删除成功");
              }else{
                  JOptionPane.showMessageDialog(null,"数据库操作异常");
              }

            }
        });





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
