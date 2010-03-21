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
public class WithdrawnItemMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "winnu.dao.map.WithdrawnItemMapBuilder";


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

        dbMap.addTable("WithdrawnItem");
        TableMap tMap = dbMap.getTable("WithdrawnItem");

        tMap.setPrimaryKeyMethod(TableMap.NATIVE);


              tMap.addPrimaryKey("WithdrawnItem.WITHDRAWNITEMID", new Integer(0));
                    tMap.addColumn("WithdrawnItem.SELLINGPRICE", new Double(0));
                    tMap.addColumn("WithdrawnItem.DATEWITHDRAWN", new String());
                    tMap.addColumn("WithdrawnItem.REASON", new String());
                    tMap.addColumn("WithdrawnItem.QUANTITY", new Integer(0));
                    tMap.addForeignKey(
                "WithdrawnItem.DOCTORID", new Integer(0) , "Doctor" ,
                "doctorId");
                    tMap.addForeignKey(
                "WithdrawnItem.SALEID", new Integer(0) , "Sale" ,
                "saleId");
                    tMap.addForeignKey(
                "WithdrawnItem.ITEMBATCHID", new Integer(0) , "ItemBatch" ,
                "itemBatchId");
                    tMap.addForeignKey(
                "WithdrawnItem.USERID", new Integer(0) , "User" ,
                "userId");
          }
}
