package com.example.wristhelp.login;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.example.wristhelp.MainActivity;
import com.example.wristhelp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class RegistroFragment extends Fragment {

    ImageButton btnRegresar;
    Fragment fragmentInicio;
    Button btnEntrar;
    ProgressDialog progressDialog;



    EditText  campoUsuario, campoContrasena, campoCorreo,campoConfirmar;

    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        mAuth = FirebaseAuth.getInstance();





        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro, container, false);

        btnRegresar = view.findViewById(R.id.button_regresar);

        campoConfirmar = (EditText) view.findViewById(R.id.campo_confirmar);
        campoContrasena = (EditText) view.findViewById(R.id.campo_contrasena);
        campoCorreo = (EditText) view.findViewById(R.id.campo_correo);

         progressDialog = new ProgressDialog(getContext());





        btnEntrar = view.findViewById(R.id.button_registrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                crearUsuario();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                crearUsuario();
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

    private void crearUsuario() {
        String email = campoCorreo.getText().toString().trim();
        String contra = campoContrasena.getText().toString().trim();
        String confirm = campoConfirmar.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(getContext(), "Se debe ingresar un correo", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(contra)){
            Toast.makeText(getContext(), "Falta ingresar una contraseña", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(confirm)){
            Toast.makeText(getContext(), "Falta ingresar la confirmacion de contraseña", Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email,contra)
                .addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //Si se logro
                        if(task.isSuccessful()){
                            Toast.makeText(getContext(), "Se ha registrado el correo.", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getContext(), "No se pudo registrar el usuario.", Toast.LENGTH_SHORT).show();
                        }

                        progressDialog.dismiss();

                    }
                });
        mAuth.addAuthStateListener(listener);



    }


    @Override
    public void onStart() {
        super.onStart();
       // mAuth.addAuthStateListener(listener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(listener != null){
            mAuth.removeAuthStateListener(listener);
        }
    }





}
