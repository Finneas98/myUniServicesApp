package com.example.myuniservicesapp.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.myuniservicesapp.data.entity.Booking;
import com.example.myuniservicesapp.data.entity.StudyRoom;
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
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomBookingDAO_Impl implements RoomBookingDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StudyRoom> __insertionAdapterOfStudyRoom;

  private final EntityInsertionAdapter<Booking> __insertionAdapterOfBooking;

  private final EntityDeletionOrUpdateAdapter<Booking> __deletionAdapterOfBooking;

  private final EntityDeletionOrUpdateAdapter<Booking> __updateAdapterOfBooking;

  public RoomBookingDAO_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStudyRoom = new EntityInsertionAdapter<StudyRoom>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `studyrooms` (`roomId`,`roomName`) VALUES (?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StudyRoom entity) {
        statement.bindLong(1, entity.getRoomId());
        if (entity.getRoomName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getRoomName());
        }
      }
    };
    this.__insertionAdapterOfBooking = new EntityInsertionAdapter<Booking>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `bookings` (`bookingId`,`roomId`,`timeSlot`,`date`,`userId`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Booking entity) {
        statement.bindLong(1, entity.getBookingId());
        statement.bindLong(2, entity.getRoomId());
        if (entity.getTimeSlot() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTimeSlot());
        }
        if (entity.getDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDate());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUserId());
        }
      }
    };
    this.__deletionAdapterOfBooking = new EntityDeletionOrUpdateAdapter<Booking>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `bookings` WHERE `bookingId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Booking entity) {
        statement.bindLong(1, entity.getBookingId());
      }
    };
    this.__updateAdapterOfBooking = new EntityDeletionOrUpdateAdapter<Booking>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `bookings` SET `bookingId` = ?,`roomId` = ?,`timeSlot` = ?,`date` = ?,`userId` = ? WHERE `bookingId` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Booking entity) {
        statement.bindLong(1, entity.getBookingId());
        statement.bindLong(2, entity.getRoomId());
        if (entity.getTimeSlot() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTimeSlot());
        }
        if (entity.getDate() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getDate());
        }
        if (entity.getUserId() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getUserId());
        }
        statement.bindLong(6, entity.getBookingId());
      }
    };
  }

  @Override
  public Object insertRoom(final StudyRoom studyRoom,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStudyRoom.insert(studyRoom);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insert(final Booking booking, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfBooking.insert(booking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertRooms(final List<StudyRoom> listOf,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfStudyRoom.insert(listOf);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object delete(final Booking booking, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfBooking.handle(booking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object update(final Booking booking, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfBooking.handle(booking);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Booking>> getBookingsForRoom(final int roomId, final String date) {
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
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<Booking>>() {
      @Override
      @NonNull
      public List<Booking> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBookingId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingId");
          final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "roomId");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final List<Booking> _result = new ArrayList<Booking>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Booking _item;
            final int _tmpBookingId;
            _tmpBookingId = _cursor.getInt(_cursorIndexOfBookingId);
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
            _item = new Booking(_tmpBookingId,_tmpRoomId,_tmpTimeSlot,_tmpDate,_tmpUserId);
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
  public Flow<List<StudyRoom>> getAllRooms() {
    final String _sql = "SELECT * FROM studyrooms";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"studyrooms"}, new Callable<List<StudyRoom>>() {
      @Override
      @NonNull
      public List<StudyRoom> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "roomId");
          final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(_cursor, "roomName");
          final List<StudyRoom> _result = new ArrayList<StudyRoom>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StudyRoom _item;
            final int _tmpRoomId;
            _tmpRoomId = _cursor.getInt(_cursorIndexOfRoomId);
            final String _tmpRoomName;
            if (_cursor.isNull(_cursorIndexOfRoomName)) {
              _tmpRoomName = null;
            } else {
              _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
            }
            _item = new StudyRoom(_tmpRoomId,_tmpRoomName);
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
  public Flow<StudyRoom> getRoom(final int roomId) {
    final String _sql = "SELECT * FROM studyrooms WHERE roomId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, roomId);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"studyrooms"}, new Callable<StudyRoom>() {
      @Override
      @NonNull
      public StudyRoom call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "roomId");
          final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(_cursor, "roomName");
          final StudyRoom _result;
          if (_cursor.moveToFirst()) {
            final int _tmpRoomId;
            _tmpRoomId = _cursor.getInt(_cursorIndexOfRoomId);
            final String _tmpRoomName;
            if (_cursor.isNull(_cursorIndexOfRoomName)) {
              _tmpRoomName = null;
            } else {
              _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
            }
            _result = new StudyRoom(_tmpRoomId,_tmpRoomName);
          } else {
            _result = null;
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
  public Flow<List<Booking>> getAllBookingsForDate(final String date) {
    final String _sql = "SELECT * FROM bookings WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<Booking>>() {
      @Override
      @NonNull
      public List<Booking> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBookingId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingId");
          final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "roomId");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final List<Booking> _result = new ArrayList<Booking>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Booking _item;
            final int _tmpBookingId;
            _tmpBookingId = _cursor.getInt(_cursorIndexOfBookingId);
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
            _item = new Booking(_tmpBookingId,_tmpRoomId,_tmpTimeSlot,_tmpDate,_tmpUserId);
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
  public Flow<List<Booking>> getAllBookings() {
    final String _sql = "SELECT * FROM bookings";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"bookings"}, new Callable<List<Booking>>() {
      @Override
      @NonNull
      public List<Booking> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBookingId = CursorUtil.getColumnIndexOrThrow(_cursor, "bookingId");
          final int _cursorIndexOfRoomId = CursorUtil.getColumnIndexOrThrow(_cursor, "roomId");
          final int _cursorIndexOfTimeSlot = CursorUtil.getColumnIndexOrThrow(_cursor, "timeSlot");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "userId");
          final List<Booking> _result = new ArrayList<Booking>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Booking _item;
            final int _tmpBookingId;
            _tmpBookingId = _cursor.getInt(_cursorIndexOfBookingId);
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
            _item = new Booking(_tmpBookingId,_tmpRoomId,_tmpTimeSlot,_tmpDate,_tmpUserId);
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

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
