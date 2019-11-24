package com.application.schoolmanagerapp.View;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.schoolmanagerapp.Model.Persona;
import com.application.schoolmanagerapp.R;
import com.bumptech.glide.Glide;

public class AdaptadorPersona extends RecyclerView.Adapter<AdaptadorPersona.ViewHolder> {

    String TAG = "SchoolManagerApp/AdaptadorPersona";

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen;
        TextView name_persona;
        TextView phone_persona;

        public ViewHolder(View v) {
            super(v);

            imagen = (ImageView) v.findViewById(R.id.imagen);
            name_persona = (TextView) v.findViewById(R.id.name_persona);
            phone_persona = (TextView) v.findViewById(R.id.phone_persona);
        }

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        Log.d(TAG, "Ejecutando onCreateViewHolder...");
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_lista, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Log.d(TAG, "Ejecutando onBindViewHolder...");
        Persona itemActual = Persona.personas.get(position);

        viewHolder.name_persona.setText(itemActual.getNombre());
        viewHolder.phone_persona.setText(itemActual.getTelefono());
        viewHolder.imagen.setImageResource(R.mipmap.schoolmanager);

        Glide.with(viewHolder.imagen.getContext())
                .load(itemActual.getImagen())
                .into(viewHolder.imagen);
    }

    @Override
    public int getItemCount() {
        return Persona.personas.size();
    }
}
