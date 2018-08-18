package com.xy1m.concurrent.singleton;

/**
 * Created by gzhenpeng on 8/18/18
 */
public class SingletonEnum2 {
    private enum MyEnumSingleton {
        connectionFactory;
        private Object connection;

        private MyEnumSingleton() {
            connection = new Object();
        }

        public Object getConnection() {
            return connection;
        }
    }

    public static Object getConnection() {
        return MyEnumSingleton.connectionFactory.getConnection();
    }
}
