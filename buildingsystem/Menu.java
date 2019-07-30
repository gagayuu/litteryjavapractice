package sust.buildingsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JMenuBar bar;//菜单栏
    JMenu menu;//菜单
    JMenuItem[] items;//菜单项数组
    JPanel panel;


    public Menu() {
        this.setSize(500, 800);
        this.setLayout(null);
        this.initMenu();

        this.setVisible(true);
    }

    public void initMenu() {//初始化菜单
        bar = new JMenuBar();
        //创建菜单
        menu = new JMenu("请选择");
        //创建菜单项
        String[] itemNames = {"查找住户信息", "增加住户信息", "删除住户信息", "修改住户信息"};
        items = new JMenuItem[itemNames.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new JMenuItem(itemNames[i]);

            items[i].addActionListener(this);
            menu.add(items[i]);
        }
        bar.add(menu);
        this.setJMenuBar(bar);//设置窗体中的菜单栏

    }


    @Override
    public void actionPerformed(ActionEvent e) {//选择菜单项不同事件出现不同面板
        JMenuItem item = (JMenuItem) e.getSource();
        if (panel != null) {
            this.remove(panel);
        }
        if (item.getText().equals("查找住户信息")) {
            panel = new SearchPanel();//创建查找住户信息面板对象
            panel.setLocation(0, 20);
            this.add(panel);
            this.repaint();
        } else {
            if (item.getText().equals("增加住户信息")) {
                panel = new AddPanel();
                panel.setLocation(0, 20);
                this.add(panel);
                this.repaint();
            } else {
                if (item.getText().equals("删除住户信息")) {
                    panel = new DeletePanel();
                    panel.setLocation(0, 20);
                    this.add(panel);
                    this.repaint();
                } else {
                    if (item.getText().equals("修改住户信息")) {
                        panel = new UpdatePanel();
                        panel.setLocation(0, 20);
                        this.add(panel);
                        this.repaint();
                    }
                }
            }


        }


    }
}
