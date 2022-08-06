package com.example.demoproject;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    List<ResponseModel> list ;
    Context context ;

    public MyAdapter(List<ResponseModel> list, Context context) {
        this.list = list;
        this.context=context ;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_row_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,  int position) {
        ResponseModel model = list.get(position);
        holder.id.setText(model.getId().toString());
        holder.userId.setText(model.getUserId().toString());
        holder.title.setText(model.getTitle());
        holder.completed.setText(model.getCompleted());

        // click listener for particular view
        holder.llContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // dialog box
                Dialog dialog = new Dialog(context);

                // set the layout for update values
                dialog.setContentView(R.layout.edit_dialog);

                // find id through dialog
                EditText etTitle = dialog.findViewById(R.id.etTitle);
                EditText etCompleted = dialog.findViewById(R.id.etCompleted);
                Button btnSave = dialog.findViewById(R.id.buttonSave);

                etTitle.setText(model.getTitle());
                etCompleted.setText(model.getCompleted());

                // button for saving the new details from user
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, " Update Successful", Toast.LENGTH_SHORT).show();
                       dialog.hide();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id ;
        TextView title ;
        TextView completed ;
        TextView userId ;
        LinearLayout llContainer ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id =itemView.findViewById(R.id.tvId);
            title =itemView.findViewById(R.id.tvTitle);
            completed =itemView.findViewById(R.id.tvCompleted);
            userId= itemView.findViewById(R.id.tvUserId);
            llContainer = itemView.findViewById(R.id.llContainer);


        }
    }
}
