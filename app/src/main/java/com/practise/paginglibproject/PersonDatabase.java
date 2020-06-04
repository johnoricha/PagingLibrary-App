package com.practise.paginglibproject;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


@Database(entities = {Person.class}, version = 1)
public abstract class PersonDatabase extends RoomDatabase {

    private static PersonDatabase mInstance;

    public abstract PersonDao personDao();

    public static synchronized PersonDatabase getInstance(Context context) {
        if (mInstance == null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(), PersonDatabase.class,
                    "person_database")
                    .addCallback(roomCallback)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return mInstance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(mInstance).execute();
        }
    };

    private static class  PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private PersonDao personDao;

        public PopulateDbAsyncTask(PersonDatabase db) {
            this.personDao = db.personDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ArrayList<Person> people = new ArrayList<>();

            personDao.insert(new Person(1, "john"));
            personDao.insert(new Person(2, "john"));
            personDao.insert(new Person(3, "john"));
            personDao.insert(new Person(4, "john"));
            personDao.insert(new Person(5, "john"));
            personDao.insert(new Person(6, "john"));
            personDao.insert(new Person(7, "john"));
            personDao.insert(new Person(8, "john"));
            personDao.insert(new Person(9, "john"));
            personDao.insert(new Person(10, "john"));
            personDao.insert(new Person(11, "john"));
            personDao.insert(new Person(12, "john"));
            personDao.insert(new Person(13, "john"));
            personDao.insert(new Person(14, "john"));
            personDao.insert(new Person(15, "john"));
            personDao.insert(new Person(16, "john"));
            personDao.insert(new Person(17, "john"));
            personDao.insert(new Person(18, "john"));
            personDao.insert(new Person(19, "john"));
            personDao.insert(new Person(20, "john"));
            personDao.insert(new Person(21, "john"));
            personDao.insert(new Person(22, "john"));
            personDao.insert(new Person(23, "john"));
            personDao.insert(new Person(24, "john"));
            personDao.insert(new Person(25, "john"));
            personDao.insert(new Person(26, "john"));
            personDao.insert(new Person(27, "john"));
            personDao.insert(new Person(28, "john"));
            personDao.insert(new Person(29, "john"));
            personDao.insert(new Person(30, "john"));
            personDao.insert(new Person(31, "john"));
            personDao.insert(new Person(32, "john"));
            personDao.insert(new Person(33, "john"));
            personDao.insert(new Person(34, "john"));
            personDao.insert(new Person(35, "john"));
            personDao.insert(new Person(36, "john"));
            personDao.insert(new Person(37, "john"));
            personDao.insert(new Person(38, "john"));
            personDao.insert(new Person(39, "john"));
            personDao.insert(new Person(40, "john"));
            personDao.insert(new Person(41, "john"));
            personDao.insert(new Person(42, "john"));
            personDao.insert(new Person(43, "john"));
            personDao.insert(new Person(44, "john"));
            personDao.insert(new Person(45, "john"));
            personDao.insert(new Person(46, "john"));
            personDao.insert(new Person(47, "john"));
            personDao.insert(new Person(48, "john"));
            personDao.insert(new Person(49, "john"));
            personDao.insert(new Person(50, "john"));
            personDao.insert(new Person(51, "john"));
            personDao.insert(new Person(52, "john"));
            personDao.insert(new Person(53, "john"));
            personDao.insert(new Person(54, "john"));
            personDao.insert(new Person(55, "john"));
            personDao.insert(new Person(56, "john"));
            personDao.insert(new Person(57, "john"));
            personDao.insert(new Person(58, "john"));
            personDao.insert(new Person(59, "john"));
            personDao.insert(new Person(60, "john"));
            personDao.insert(new Person(61, "john"));
            personDao.insert(new Person(62, "john"));


            return null;
        }
    }
}
