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
  * [Thu Mar 25 06:20:49 CST 2010]
  *
  */
@SuppressWarnings("unused")
public class ItemMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "winnu.dao.map.ItemMapBuilder";


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

        dbMap.addTable("Item");
        TableMap tMap = dbMap.getTable("Item");

        tMap.setPrimaryKeyMethod(TableMap.NATIVE);


              tMap.addPrimaryKey("Item.ITEMID", new Integer(0));
                    tMap.addColumn("Item.GENERICNAME", new String());
                    tMap.addColumn("Item.BRANDNAME", new String());
                    tMap.addColumn("Item.CLASSIFICATION", new String());
                    tMap.addColumn("Item.TYPE", new String());
                    tMap.addColumn("Item.MINIMUMSUPPYLIMIT", new Integer(0));
                    tMap.addForeignKey(
                "Item.USERID", new Integer(0) , "User" ,
                "userId");
                    tMap.addColumn("Item.NEXTBATCH", new Integer(0));
          }
}
