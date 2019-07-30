package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame  implements ActionListener {
  private JLabel littleLabel;
   private  JLabel userLabel;
   private  JLabel passwordLabel;// 标签对象
   private JTextField userText;
   private JPasswordField passWordText;//文本框对象
   private JButton lgButton;
   private JButton exButton;//按钮对象

    public LoginForm() {
        this.setSize(500, 400);//大小
        this.setTitle("登录界面");//标题
        this.setLayout(null);//将窗体默认布局方式设置为无布局

        littleLabel = new JLabel("楼宇管理系统");
        littleLabel.setSize(200, 40);
        littleLabel.setLocation(150, 10);
        Font font1 = new Font("宋体", Font.BOLD, 24);
        littleLabel.setFont(font1);


        userLabel = new JLabel("用户名");//标签1，用户名
        userLabel.setSize(100, 40);
        userLabel.setLocation(80, 50);
        Font font = new Font("宋体", Font.BOLD, 20);//设置字体
        userLabel.setFont(font);


        passwordLabel = new JLabel("密 码");//标签2，密码
        passwordLabel.setSize(100, 40);
        passwordLabel.setLocation(80, 100);
        passwordLabel.setFont(font);

        userText = new JTextField();//输入用户名的文本框
        userText.setSize(180, 30);
        userText.setLocation(160, 50);

        passWordText= new JPasswordField();//输入密码的文本框
        passWordText.setSize(180, 30);
        passWordText.setLocation(160, 100);

        JButton lgButton = new JButton("登录");
        lgButton.setSize(80, 30);
        lgButton.setLocation(100, 180);

        JButton exButton = new JButton("退出");
        exButton.setSize(80, 30);
        exButton.setLocation(190, 180);

        this.add(littleLabel);
        this.add(userLabel);
        this.add( passwordLabel);
        this.add(userText);
        this.add(passWordText);
        this.add(lgButton);
        this.add(exButton);

        this.setVisible(true);

        //登录按钮事件
        lgButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//输入正确打开主菜单界面
                if (userText.getText().trim().equals("gaga") && passWordText.getText().trim().equals("123456")) {
                    Menu menu = new Menu();
                    dispose();
                }else{//否则弹出窗口提示
                    JOptionPane.showMessageDialog(null,"输入有误！！！");
                    dispose();
                }


            }
        });

        //退出按钮事件
        exButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
