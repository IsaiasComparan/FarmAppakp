package com.wamessage.plantapp_plantidentifier.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.wamessage.plantapp_plantidentifier.R;
import com.wamessage.plantapp_plantidentifier.models.Tree;
import java.util.List;


public class MoreTreeAdapter extends RecyclerView.Adapter<MoreTreeAdapter.MorePlantHolder> {
    private List<Tree> trees;

    public MoreTreeAdapter(List<Tree> trees) {
        this.trees = trees;
    }

    @Override 
    public MorePlantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MorePlantHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more_info_plant, parent, false));
    }

    @Override 
    public int getItemCount() {
        return this.trees.size();
    }

    @Override 
    public void onBindViewHolder(MorePlantHolder holder, int position) {
        Tree tree = this.trees.get(position);
        holder.namePlant.setText(tree.getName());
        holder.score.setText("%" + tree.getScore());
    }

    
    public class MorePlantHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView namePlant;
        public TextView score;

        public MorePlantHolder(View itemView) {
            super(itemView);
            this.namePlant = (TextView) itemView.findViewById(R.id.txtInfoPlant_Name);
            this.score = (TextView) itemView.findViewById(R.id.txtInfoPlant_Score);
            this.cardView = (CardView) itemView.findViewById(R.id.plantCard1);
        }
    }
}