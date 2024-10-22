package adaptador;

//import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listadin.Eliminar;
import com.example.listadin.R;
import com.example.listadin.cardview;
import com.example.listadin.ver;

import global.info;

public class adaptadorelim extends RecyclerView.Adapter<adaptadorelim.activity> {
    public Context context;

    @NonNull
    @Override
    public activity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = View.inflate(context,R.layout.viewholder2, null);
        activity obj = new activity(v);

        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull activity miniactivity, int i) {
        final int pos = i;
        miniactivity.nombre.setText(info.lista.get(i).getTeam());
        miniactivity.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent card = new Intent(context, Eliminar.class);
                card.putExtra("posicion", pos);
                context.startActivity(card);
            }
        });
    }

    @Override
    public int getItemCount() {
        return info.lista.size();
    }

    public class activity extends RecyclerView.ViewHolder {

        TextView nombre;

        public activity(@NonNull View itemView) {
            super(itemView);

            nombre = itemView.findViewById(R.id.theviewE);
        }
    }

}