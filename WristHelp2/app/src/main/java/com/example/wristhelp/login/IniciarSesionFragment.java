package com.example.wristhelp.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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


public class IniciarSesionFragment extends Fragment {

    ImageButton btnRegresar;
    Fragment fragmentInicio;
    Button btnEntrar;
    Intent intentMain;
    Fragment fragmentHome;
    EditText nombreusuario;
    EditText contrasena;



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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_iniciar_sesion, container, false);

        nombreusuario = view.findViewById(R.id.campo_usuario);
        contrasena = view.findViewById(R.id.campo_contrasena);

        btnRegresar = view.findViewById(R.id.button_regresar);

        btnEntrar = view.findViewById(R.id.button_entrar);


       mAuth = FirebaseAuth.getInstance();
        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = mAuth.getCurrentUser();
                if(user == null){
                    //Usuario no logeado
                }else{
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                }
            }
        };


        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo = nombreusuario.getText().toString();
                String contrasen = contrasena.getText().toString();

                if (!correo.equals("") && !contrasen.equals("")) {
                    correo = correo.replace(" ","");

                    final Task<AuthResult> authResultTask = mAuth.signInWithEmailAndPassword(correo,contrasen )
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getContext(), "Sesion Iniciada", Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Intent intent = new Intent(getActivity(), MainActivity.class);
                                        startActivity(intent);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Toast.makeText(getContext(), "Error al Iniciar, favor de verificar.", Toast.LENGTH_SHORT).show();

                                    }

                                    // ...
                                }
                            });
                }else {
                    Toast.makeText(getContext(), "Favor de llenar los campos", Toast.LENGTH_SHORT).show();
                }


            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragmentInicio = new InicioFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Contenedor, fragmentInicio)
                        .commitAllowingStateLoss();
            }
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(listener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(listener != null){
            mAuth.removeAuthStateListener(listener);
        }
    }





}
