package com.example.wristhelp.login;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.wristhelp.BD.BaseData;
import com.example.wristhelp.MainActivity;
import com.example.wristhelp.R;




public class RegistroFragment extends Fragment {

    ImageButton btnRegresar;
    Fragment fragmentInicio;
    Button btnEntrar;
    Object ContentValues;
    BaseData basedata;

    EditText  campoUsuario, campoContrasena, campoCorreo;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        btnRegresar = view.findViewById(R.id.button_regresar);

        campoUsuario = (EditText) view.findViewById(R.id.campo_usuario);
        campoContrasena = (EditText) view.findViewById(R.id.campo_contrasena);
        campoCorreo = (EditText) view.findViewById(R.id.campo_correo);

         basedata = new BaseData(getContext());



        btnEntrar = view.findViewById(R.id.button_registrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db = basedata.getWritableDatabase();
                ContentValues valores = new ContentValues();

                valores.put(BaseData.Datostabla.COLUMN_NOMBRES, campoUsuario.getText().toString());
                valores.put(BaseData.Datostabla.COLUMN_PASSWORD, campoContrasena.getText().toString());
                valores.put(BaseData.Datostabla.COLUMN_EMAIL, campoCorreo.getText().toString());

                Long NombreGuardado = db.insert(BaseData.Datostabla.TABLE_NAME, BaseData.Datostabla.COLUMN_NOMBRES, valores);

                Toast.makeText(getContext(),"Usuario creado:" + NombreGuardado, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInicio = new InicioFragment();
                getActivity().
                        getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Contenedor, fragmentInicio)
                        .commitAllowingStateLoss();


            }
        });







        return view;
    }








}
