package com.example.myuniservicesapp.data;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myuniservicesapp.data.entity.Booking;
import com.example.myuniservicesapp.data.entity.Room;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomBookingDAO_Impl implements RoomBookingDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Room> __insertionAdapterOfRoom;

  private final EntityInsertionAdapter<Booking> __insertionAdapterOfBooking;

  public RoomBookingDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoom = new EntityInsertionAdapter<Room>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `rooms` (`id`,`roomName`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Room value) {
        stmt.bindLong(1, value.getId());
        if (value.getRoomName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRoomName());
        }
      }
    };
    this.__insertionAdapterOfBooking = new EntityInsertionAdapter<Booking>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `bookings` (`roomId`,`timeSlot`,`date`,`userId`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Booking value) {
        stmt.bindLong(1, value.getRoomId());
        if (value.getTimeSlot() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTimeSlot());
        }
        if (value.getDate() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDate());
        }
        if (value.getUserId() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getUserId());
        }
      }
    };
  }

  @Override
  public Object insertRoom(final Room room, final Continuation<? super Unit> $completion) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public Object insertBooking(final Booking booking, final Continuation<? super Unit> $completion) {
    __db.assertNotSuspendingTransaction();
  }

  @Override
  public LiveData<List<Booking>> getBookingsForRoom(final int roomId, final String date) {
    final String _sql = "SELECT * FROM bookings WHERE roomId = ? AND date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, roomId);
    _argIndex = 2;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return __db.getInvalidationTracker().createLiveData(new String[]{"bookings"}, false, new Callable<List<Booking>>() {
      @Override
      public List<Booking> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "roomId");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final List<Booking> _result = new ArrayList<Booking>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Booking _item;
            final int _tmpRoomId;
            _tmpRoomId = _cursor.getInt(_cursorIndexOfRoomId);
            final String _tmpTimeSlot;
            if (_cursor.isNull(_cursorIndexOfTimeSlot)) {
              _tmpTimeSlot = null;
            } else {
              _tmpTimeSlot = _cursor.getString(_cursorIndexOfTimeSlot);
            }
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final String _tmpUserId;
            if (_cursor.isNull(_cursorIndexOfUserId)) {
              _tmpUserId = null;
            } else {
              _tmpUserId = _cursor.getString(_cursorIndexOfUserId);
            }
            _item = new Booking(_tmpRoomId,_tmpTimeSlot,_tmpDate,_tmpUserId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Object getAllRooms(final Continuation<? super List<Room>> $completion) {
    final String _sql = "SELECT * FROM rooms";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    int _argIndex = 1;
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Object getAllBookingsForDate(final String date,
      final Continuation<? super List<Booking>> $completion) {
    final String _sql = "SELECT * FROM bookings WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Object _result;
      if(_cursor.moveToFirst()) {
        _result = new Object();
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
