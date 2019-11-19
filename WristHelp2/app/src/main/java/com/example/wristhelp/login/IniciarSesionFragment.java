package com.example.wristhelp.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.wristhelp.MainActivity;
import com.example.wristhelp.R;


public class IniciarSesionFragment extends Fragment {

    ImageButton btnRegresar;
    Fragment fragmentInicio;
    Button btnEntrar;
    Intent intentMain;
    Fragment fragmentHome;




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

        btnRegresar = view.findViewById(R.id.button_regresar);

        btnEntrar = view.findViewById(R.id.button_entrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
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





}
