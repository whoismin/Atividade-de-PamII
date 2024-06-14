package com.example.appsqlite.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = ("CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY, " +
                NAME_COL + " TEXT, " +
                END_COL + " TEXT, " +
                BAR_COL + " TEXT, " +
                CEP_COL + " TEXT, " +
                TEL_COL + " TEXT)")
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun addPessoa(name: String, endereco: String, bairro: String, cep: String, telefone: String) {

        val values = ContentValues()

        values.put(NAME_COL, name)
        values.put(END_COL, endereco)
        values.put(BAR_COL, bairro)
        values.put(CEP_COL, cep)
        values.put(TEL_COL, telefone)

        val db = this.writableDatabase
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    companion object {
        private const val DATABASE_NAME = "appSQLite"
        private const val DATABASE_VERSION = 3
        const val TABLE_NAME = "CadastroPessoa"
        const val ID_COL = "id"
        const val NAME_COL = "name"
        const val END_COL = "endereco"
        const val BAR_COL = "bairro"
        const val CEP_COL = "cep"
        const val TEL_COL = "telefone"
    }
}