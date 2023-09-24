package com.example.dmaid

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context):SQLiteOpenHelper(context, dbname,factory, version) {
    companion object {
        internal val dbname = "dmaidDB"
        internal val factory = null
        internal val version = 1
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(
            "create table user(id integer primary key autoincrement," +
                    "firstname varchar(50),lastname varchar(50),apartment varchar(100),address varchar(200)," +
                    "pin varchar(20),username varchar(20),email varchar(100),password varchar(20))"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertUser(
        firstname: String, lastname: String, apartment: String, address: String, pin: String,
        username: String, email: String, password: String
    ) {
        val db: SQLiteDatabase = writableDatabase
        val values: ContentValues = ContentValues()
        values.put("firstname", firstname)
        values.put("lastname", lastname)
        values.put("apartment", apartment)
        values.put("address", address)
        values.put("pin", pin)
        values.put("username", username)
        values.put("email", email)
        values.put("password", password)

        db.insert("user", null, values)

        db.close()
    }

        fun login(username: String,password: String): Boolean {
            val db = writableDatabase
            val query = "select * from user where username = '$username' and password = '$password'"
            val cursor = db.rawQuery(query, null)
            if (cursor.count <= 0) {
                cursor.close()
                return false
            }
            cursor.close()
            return true

        }
    }

