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
  * [Wed Mar 10 00:59:38 CST 2010]
  *
  */
public class SupplierMapBuilder implements MapBuilder
{
    /**
     * The name of this class
     */
    public static final String CLASS_NAME =
        "winnu.dao.map.SupplierMapBuilder";


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

        dbMap.addTable("Supplier");
        TableMap tMap = dbMap.getTable("Supplier");

        tMap.setPrimaryKeyMethod(TableMap.NATIVE);


              tMap.addPrimaryKey("Supplier.SUPPLIERID", new Integer(0));
                    tMap.addColumn("Supplier.SUPPLIERNAME", new String());
                    tMap.addColumn("Supplier.ADDRESS", new String());
                    tMap.addColumn("Supplier.CONTACTNO", new String());
          }
}
