    package sust.buildingsystem;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

    public class DatabaseLoad {

        public static void main(String[] args) {
    //        People people = query(6);//查询一条记录并打印
    //        System.out.print("No："+people.getNo()+" ");
    //        System.out.print("Number："+people.getNumber()+" ");
    //        System.out.print("Name："+people.getName()+" ");
    //        System.out.print("Sex："+people.getSex()+" ");

          update(1,6);//更新

    //        List<People> list = new ArrayList<>();//查询所有并打印
    //        list = queryAll();
    //        for (int i = 0; i < list.size(); i++) {
    //            People people = list.get(i);
    //            System.out.print("No："+people.getNo()+" ");
    //            System.out.print("Number："+people.getNumber()+" ");
    //            System.out.print("Name："+people.getName()+" ");
    //            System.out.print("Sex："+people.getSex()+" ");
    //            System.out.println();
    //        }

//        People people = new People();//添加一条记录
//        people.setNo(1);
//        people.setName("张三");
//        people.setNumber(3);
//        people.setSex("男");
//       add(people);


    //    remove(1);//删除一条记录
        }

        public static void remove(int no) {//根据输入号码删除对应信息
            Connection c = null;//创建数据库连接对象
            PreparedStatement s = null;//创建sql语句执行对象
            ResultSet set = null;//结果集
            try {
                String sql = "delete from build_info where no=?;";//sql执行语句
                Class.forName("com.mysql.jdbc.Driver");//加载对应的jdbc驱动
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";//配置连接字符串
                String username = "root";//管理员
                String password = "gagayu123";//密码
                c = DriverManager.getConnection(url, username, password);
                s = c.prepareStatement(sql);
                s.setInt(1, no);
                s.execute();//执行sql语句
                s.close();//关闭数据库执行语句`
                c.close();//关闭数据库连接
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的数据库驱动类");
            } catch (SQLException e) {
                System.out.println("数据库连接失败或数据库操作失败");
            }
        }



        public static void add(People people) {//添加一条记录

            try {
                String sql = "insert into build_info (no,number, name, sex) values (?,?,?,?)";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useUnicode=true&characterEncoding=utf8&useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                s.setInt(1,people.getNo());
                s.setInt(2, people.getNumber());
                s.setString(3, people.getName());
                s.setString(4, people.getSex());
                System.out.println(s);
                s.execute();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的数据库驱动类");
            } catch (SQLException e) {
                System.out.println("数据库连接失败或数据库操作失败");
            }

        }

        public static List<People> queryAll() {//使用动态数组(People类型)返回查询所有信息的结果
            List<People> list = new ArrayList<>();//实例化list对象
            try {
                ResultSet rs = null;//数据库中表示结果集的数据表
                String sql = "select no,number,name,sex from build_info";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                rs = s.executeQuery(sql);
               while(rs.next()){//循环遍历结果集
                    People people = new People();//实例化people对象
                    people.setNo(rs.getInt(1));//set属性为get到的数值
                    people.setNumber(rs.getInt(2));
                    people.setName(rs.getString(3));
                    people.setSex(rs.getString(4));
                    list.add(people);
                }
                rs.close();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的数据库驱动类");
            } catch (SQLException e) {
                System.out.println("数据库连接失败或数据库操作失败");
            }
            return list;
        }


        public static void update(int no,int newNumber){//修改一条数据，只能修改现住人数
            try {
                String sql = "update build_info set number=? where no=?;";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                s.setInt(1,newNumber);
                s.setInt(2,no);
                s.execute();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的数据库驱动类");
            } catch (SQLException e) {
                System.out.println("数据库连接失败或数据库操作失败");
            }
        }



        public static People query(int no){//查询一条记录
            People people = new People();
            try {
                ResultSet rs = null;
                String sql = "select * from build_info where no=?;";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                s.setInt(1,no);
                System.out.println(s);
                rs = s.executeQuery();
                while (rs.next()){
                    people.setNo(rs.getInt("no"));
                    people.setNumber(rs.getInt("number"));
                    people.setName(rs.getString("name"));
                    people.setSex(rs.getString("sex"));
                }
            }catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的数据库驱动类");
            } catch (SQLException e) {
                System.out.println("数据库连接失败或数据库操作失败");
            }
            return people;
        }



        public  boolean isExist(int no) {//判断界面操作数是否在数据库中存在
            List<People> list =new ArrayList<>();
            try {
                ResultSet rs = null;
                String sql = "select * from build_info where no="+String.valueOf(no)+";";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c=DriverManager.getConnection(url,username,password);
                PreparedStatement s=c.prepareStatement(sql);
                rs= s.executeQuery(sql);
                while(rs.next()){
                    People people=new People();
                    people.setNo(rs.getInt(1));
                    people.setNumber(rs.getInt(2));
                    people.setName(rs.getString(3));
                    people.setSex(rs.getString(4));
                    list.add(people);
                }
                rs.close();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("没有找到对应的数据库驱动类");
            } catch (SQLException e) {
                System.out.println("数据库连接失败或数据库操作失败");
            }

            if(list.size()==1){//找到一条相关记录则返回true
                return true;
            }else {//其余情况都为未找到记录或错误
                return false;
            }
        }
    }
