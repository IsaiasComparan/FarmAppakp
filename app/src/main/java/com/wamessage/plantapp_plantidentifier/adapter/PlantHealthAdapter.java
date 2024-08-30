package com.wamessage.plantapp_plantidentifier.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.wamessage.plantapp_plantidentifier.R;
import com.wamessage.plantapp_plantidentifier.models.PlantHealth;
import java.util.List;


public class PlantHealthAdapter extends RecyclerView.Adapter<PlantHealthAdapter.PlantViewHolder> {
    private List<PlantHealth> plantHealths;

    public PlantHealthAdapter(List<PlantHealth> plantHealths) {
        this.plantHealths = plantHealths.subList(1, plantHealths.size());
    }

    @Override 
    public PlantViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlantViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plant, parent, false));
    }

    @Override 
    public void onBindViewHolder(PlantViewHolder holder, int position) {
        PlantHealth plantHealth = this.plantHealths.get(position);
        holder.namePlant.setText(plantHealth.getName());
        holder.score.setText("%" + plantHealth.getScore());
    }

    @Override 
    public int getItemCount() {
        return this.plantHealths.size();
    }

    
    public class PlantViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView namePlant;
        public TextView score;

        public PlantViewHolder(View itemView) {
            super(itemView);
            this.namePlant = (TextView) itemView.findViewById(R.id.txtItemPlant_Name);
            this.score = (TextView) itemView.findViewById(R.id.txtItemPlant_Score);
            this.cardView = (CardView) itemView.findViewById(R.id.plantCard);
        }
    }
}