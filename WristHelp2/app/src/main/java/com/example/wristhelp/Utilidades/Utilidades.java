package com.example.wristhelp.Utilidades;

public class Utilidades {

    //Constants table users fields
    public static final String TABLA_USUARIO = "usuario";
    public static final String CAMPO_NOMBREUSUARIO = "nombre";
    public static final String CAMPO_CONTRASENA = "contrasena";
    public static final String CAMPO_CORREO = "correo";


    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE" + TABLA_USUARIO +
            " ("+CAMPO_NOMBREUSUARIO+" TEXT, "+CAMPO_CONTRASENA+
            " TEXT, "+CAMPO_CORREO+" TEXT)";



}
