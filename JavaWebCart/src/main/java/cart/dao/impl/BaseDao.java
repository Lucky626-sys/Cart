//共用的資料庫操作基礎類別，抽出通用操作、避免重複寫一樣的程式碼
package cart.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;

import cart.model.entity.User;
// 用來讓不同的 xxxDao 透過 extends BaseDao 可以連接 MySQL
public class BaseDao {
  protected static Connection conn;
	
  static {
    // 連線參數
    String username = "root";
    String password = "abc123";
    String dbUrl = "jdbc:mysql://localhost:3306/cart?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true&useSSL=false";


    // 建立連線
    try {
      Class.forName("com.mysql.cj.jdbc.Driver"); // 註冊 MySQL Driver		//Class.forName動態建立物件
      conn = DriverManager.getConnection(dbUrl, username, password); // 連線建立
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}

