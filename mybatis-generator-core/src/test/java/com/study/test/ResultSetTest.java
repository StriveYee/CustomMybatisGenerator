package com.study.test;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.internal.ObjectFactory;
import org.mybatis.generator.internal.db.ActualTableName;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Administrator on 2016/10/28.
 */
public class ResultSetTest {

    public static void main(String[] args) {

        try {


            Driver driver = (com.mysql.jdbc.Driver)ResultSetTest.class.getClassLoader().loadClass("com.mysql.jdbc.Driver").newInstance();
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "ued");
            Connection con = driver.connect("jdbc:mysql://192.168.192.88:3306/panda_dev", props);
            DatabaseMetaData databaseMetaData = con.getMetaData();


            ResultSet rs = databaseMetaData.getColumns(null, null, "pd_user", null);
            while (rs.next()) {


                IntrospectedColumn introspectedColumn = ObjectFactory
                        .createIntrospectedColumn(new Context(null));

                introspectedColumn.setJdbcType(rs.getInt("DATA_TYPE")); //$NON-NLS-1$
                introspectedColumn.setLength(rs.getInt("COLUMN_SIZE")); //$NON-NLS-1$
                introspectedColumn.setActualColumnName(rs.getString("COLUMN_NAME")); //$NON-NLS-1$
                introspectedColumn
                        .setNullable(rs.getInt("NULLABLE") == DatabaseMetaData.columnNullable); //$NON-NLS-1$
                introspectedColumn.setScale(rs.getInt("DECIMAL_DIGITS")); //$NON-NLS-1$
                introspectedColumn.setRemarks(rs.getString("REMARKS")); //$NON-NLS-1$
                introspectedColumn.setDefaultValue(rs.getString("COLUMN_DEF")); //$NON-NLS-1$

                introspectedColumn.setAutoIncrement("YES".equals(rs.getString("IS_AUTOINCREMENT"))); //$NON-NLS-1$ //$NON-NLS-2$
//            introspectedColumn.setGeneratedColumn("YES".equals(rs.getString("IS_GENERATEDCOLUMN"))); //$NON-NLS-1$ //$NON-NLS-2$

                ActualTableName atn = new ActualTableName(
                        rs.getString("TABLE_CAT"), //$NON-NLS-1$
                        rs.getString("TABLE_SCHEM"), //$NON-NLS-1$
                        rs.getString("TABLE_NAME")); //$NON-NLS-1$
                System.out.println(introspectedColumn.toString());
            }



            //Circulate read RS_META_DATA
            ResultSetMetaData rsMetaData = rs.getMetaData();
//            for (int i = 1;i <= rsMetaData.getColumnCount(); i++) {
//                System.out.println("*****************Field" + i + "******************");
//                System.out.println("getCatalogName:" + rsMetaData.getCatalogName(i));
//                System.out.println("getColumnClassName:" + rsMetaData.getColumnClassName(i));
//                System.out.println("getColumnDisplaySize:" + rsMetaData.getColumnDisplaySize(i));
//                System.out.println("getColumnLabel:" + rsMetaData.getColumnLabel(i));
//                System.out.println("getColumnName:" + rsMetaData.getColumnName(i));
//                System.out.println("getColumnType:" + rsMetaData.getColumnType(i));
//                System.out.println("getColumnTypeName:" + rsMetaData.getColumnTypeName(i));
//                System.out.println("getPrecision:" + rsMetaData.getPrecision(i));
//                System.out.println("getScale:" + rsMetaData.getScale(i));
//                System.out.println("getSchemaName:" + rsMetaData.getSchemaName(i));
//                System.out.println("isAutoIncrement:" + rsMetaData.isAutoIncrement(i));
//                System.out.println("isCaseSensitive:" + rsMetaData.isCaseSensitive(i));
//                System.out.println("isCurrency:" + rsMetaData.isCurrency(i));
//                System.out.println("isDefinitelyWritable:" + rsMetaData.isDefinitelyWritable(i));
//                System.out.println("isNullable:" + rsMetaData.isNullable(i));
//                System.out.println("isReadOnly:" + rsMetaData.isReadOnly(i));
//                System.out.println("isSearchable:" + rsMetaData.isSearchable(i));
//                System.out.println("isSigned:" + rsMetaData.isSigned(i));
//                System.out.println("isWritable:" + rsMetaData.isWritable(i));
//            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }


    }

}
