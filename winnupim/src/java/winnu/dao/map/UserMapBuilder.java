package winnu.dao.map;

import java.util.Date;
import java.math.BigDecimal;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.map.MapBuilder;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;

/**
  *  This class was autogenerated by Torque on:
  *
  * [Sun Mar 21 12:38:31 CST 2010]
  *
  */
public class UserMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "winnu.dao.map.UserMapBuilder";


    /**
     * The database map.
     */
    private DatabaseMap dbMap = null;

    /**
     * Tells us if this DatabaseMapBuilder is built so that we
     * don't have to re-build it every time.
     *
     * @return true if this DatabaseMapBuilder is built
     */
    public boolean isBuilt()
    {
        return (dbMap != null);
    }

    /**
     * Gets the databasemap this map builder built.
     *
     * @return the databasemap
     */
    public DatabaseMap getDatabaseMap()
    {
        return this.dbMap;
    }

    /**
     * The doBuild() method builds the DatabaseMap
     *
     * @throws TorqueException
     */
    public void doBuild() throws TorqueException
    {
        dbMap = Torque.getDatabaseMap("winnudb");

        dbMap.addTable("User");
        TableMap tMap = dbMap.getTable("User");

        tMap.setPrimaryKeyMethod(TableMap.NATIVE);


              tMap.addPrimaryKey("User.USERID", new Integer(0));
                    tMap.addColumn("User.USERNAME", new String());
                    tMap.addColumn("User.PASSWORD", new String());
                    tMap.addColumn("User.FIRSTNAME", new String());
                    tMap.addColumn("User.MIDDLENAME", new String());
                    tMap.addColumn("User.LASTNAME", new String());
                    tMap.addColumn("User.POSITION", new String());
                    tMap.addColumn("User.ADDRESS", new String());
                    tMap.addColumn("User.CONTACTNO", new String());
                    tMap.addColumn("User.TYPE", new String());
                    tMap.addColumn("User.DELETED", new Integer(0));
          }
}