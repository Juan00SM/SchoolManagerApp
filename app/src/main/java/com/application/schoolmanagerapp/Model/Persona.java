package com.application.schoolmanagerapp.Model;

import com.application.schoolmanagerapp.R;

import java.util.ArrayList;

public class Persona {
        public static ArrayList<Persona> personas = new ArrayList<>();
        String nombre;
        String telefono;
        int imagen;

        public Persona(String nombre, String telefono, int imagen) {
            this.nombre = nombre;
            this.telefono = telefono;
            this.imagen = imagen;
        }
        static{
            personas.add(new Persona("Juan","698517827", R.mipmap.schoolmanager));
            personas.add(new Persona("Rafael","345654677",R.mipmap.schoolmanager));
            personas.add(new Persona("Maria","098786756",R.mipmap.schoolmanager));
            personas.add(new Persona("Samuel","32456784",R.mipmap.schoolmanager));
            personas.add(new Persona("Laura","345678987",R.mipmap.schoolmanager));
            personas.add(new Persona("Alejandro","34658723579",R.mipmap.schoolmanager));
            personas.add(new Persona("Francisco","985647382",R.mipmap.schoolmanager));
        }

        public static ArrayList<Persona> getPersonas() {
            return personas;
        }

        public static void setPersonas(ArrayList<Persona> personas) {
            Persona.personas = personas;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getTelefono() {
            return telefono;
        }

        public void setTelefono(String telefono) {
            this.telefono = telefono;
        }

        public int getImagen() {
            return imagen;
        }

        public void setImagen(int imagen) {
            this.imagen = imagen;
        }
    }


