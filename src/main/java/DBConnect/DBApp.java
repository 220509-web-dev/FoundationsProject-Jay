package DBConnect;

import dev.jay.utils.ConnectionsUtil;

public class DBApp {
    public static void main(String[]args) {
        System.out.println(ConnectionsUtil.getConnection());
    }
}
