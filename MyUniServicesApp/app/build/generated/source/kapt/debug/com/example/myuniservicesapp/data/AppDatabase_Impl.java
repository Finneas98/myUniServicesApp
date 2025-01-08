package com.example.myuniservicesapp.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile RoomBookingDAO _roomBookingDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Room` ()");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bookings` (`roomId` INTEGER NOT NULL, `timeSlot` TEXT NOT NULL, `date` TEXT NOT NULL, `userId` TEXT NOT NULL, PRIMARY KEY(`roomId`), FOREIGN KEY(`roomId`) REFERENCES `rooms`(`id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '709c05ff459a361296fdd8961080c9f1')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `Room`");
        _db.execSQL("DROP TABLE IF EXISTS `bookings`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      public void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      public RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsRoom = new HashMap<String, TableInfo.Column>(0);
        final HashSet<TableInfo.ForeignKey> _foreignKeysRoom = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRoom = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRoom = new TableInfo("Room", _columnsRoom, _foreignKeysRoom, _indicesRoom);
        final TableInfo _existingRoom = TableInfo.read(_db, "Room");
        if (! _infoRoom.equals(_existingRoom)) {
          return new RoomOpenHelper.ValidationResult(false, "Room(androidx.room.Room).\n"
                  + " Expected:\n" + _infoRoom + "\n"
                  + " Found:\n" + _existingRoom);
        }
        final HashMap<String, TableInfo.Column> _columnsBookings = new HashMap<String, TableInfo.Column>(4);
        _columnsBookings.put("roomId", new TableInfo.Column("roomId", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookings.put("timeSlot", new TableInfo.Column("timeSlot", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookings.put("date", new TableInfo.Column("date", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsBookings.put("userId", new TableInfo.Column("userId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookings = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysBookings.add(new TableInfo.ForeignKey("rooms", "NO ACTION", "NO ACTION",Arrays.asList("roomId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesBookings = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookings = new TableInfo("bookings", _columnsBookings, _foreignKeysBookings, _indicesBookings);
        final TableInfo _existingBookings = TableInfo.read(_db, "bookings");
        if (! _infoBookings.equals(_existingBookings)) {
          return new RoomOpenHelper.ValidationResult(false, "bookings(com.example.myuniservicesapp.data.entity.Booking).\n"
                  + " Expected:\n" + _infoBookings + "\n"
                  + " Found:\n" + _existingBookings);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "709c05ff459a361296fdd8961080c9f1", "5117fe2a3c2604bb88d5b06f8b45308e");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "Room","bookings");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `Room`");
      _db.execSQL("DELETE FROM `bookings`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(RoomBookingDAO.class, RoomBookingDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public RoomBookingDAO roomBookingDao() {
    if (_roomBookingDAO != null) {
      return _roomBookingDAO;
    } else {
      synchronized(this) {
        if(_roomBookingDAO == null) {
          _roomBookingDAO = new RoomBookingDAO_Impl(this);
        }
        return _roomBookingDAO;
      }
    }
  }
}
