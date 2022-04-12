package com.example.lap07_roomdatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    private static  final  String DATABASE_NAME ="user.db";
    private static  UserDatabase intance;

    public static synchronized UserDatabase getInstance(Context context){

        if(intance == null){
            intance = Room.databaseBuilder(context.getApplicationContext(), UserDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return  intance;
    }
    public abstract UserDao userDao();
}


