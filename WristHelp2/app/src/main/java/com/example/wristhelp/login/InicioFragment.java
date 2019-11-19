package com.example.wristhelp.login;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wristhelp.R;


public class InicioFragment extends Fragment {

    Button btnRegistrarse;
    Button btnIniciarSe;

    Fragment fragmentRegistro;
    Fragment fragmentIniciarSe;
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
        View view =inflater.inflate(R.layout.fragment_inicio, container, false);


        btnRegistrarse = view.findViewById(R.id.buttonRegistrarse);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                fragmentRegistro = new RegistroFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Contenedor, fragmentRegistro)
                        .commitAllowingStateLoss();
            }
        });


        btnIniciarSe = view.findViewById(R.id.buttonIniciar);

        btnIniciarSe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentIniciarSe = new IniciarSesionFragment();
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.Contenedor,fragmentIniciarSe).
                        commitAllowingStateLoss();

            }
        });

        return view;
    }

}
