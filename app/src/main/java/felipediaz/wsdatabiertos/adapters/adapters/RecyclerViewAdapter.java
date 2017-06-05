package felipediaz.wsdatabiertos.adapters.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import felipediaz.wsdatabiertos.R;
import felipediaz.wsdatabiertos.adapters.models.AlcaldiasPOJO;
import felipediaz.wsdatabiertos.adapters.models.CaracteristicasAlcaldia;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PictureViewHolder>{

    /**
     * Arreglo de alcaldias
     */
    private ArrayList<AlcaldiasPOJO> dataset;

    /**
     * Contexto
     */
    private Context context;

    /**
     *
     */
    private Activity activity;

    /**
     *
     * @param context
     */
    public RecyclerViewAdapter(Context context) {
        this.context = context;
        dataset = new ArrayList<>();
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new PictureViewHolder(view);
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        final AlcaldiasPOJO pojo = dataset.get(position);

        holder.txtTipoMuni.setText(pojo.getNombreMunicipio());
        holder.txtCod.setText(pojo.getCodigoDaneMunicipio());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CaracteristicasAlcaldia.class);

                intent.putExtra("CODIGO DANE MUNICIPIO",pojo.getCodigoDaneMunicipio());
                intent.putExtra("CORREOCONTACTENOS",pojo.getCorreocontactenos());
                intent.putExtra("DIRECCIÓN",pojo.getDirecciN());
                intent.putExtra("NIT",pojo.getNit());
                intent.putExtra("NOMBRE ALCALDE",pojo.getNombreAlcalde());
                intent.putExtra("NOMBRE MUNICIPIO",pojo.getNombreMunicipio());
                intent.putExtra("PORTAL WEB",pojo.getPortalweb());
                intent.putExtra("TELEFONO DE CONTACTO",pojo.getTelefonoDeContacto());
                context.startActivity(intent);

            }
        });


        switch (pojo.getNombreMunicipio()){
            case "FUNES":
                holder.imagen.setImageResource(R.drawable.funes);
                break;
            case "MALLAMA":
                holder.imagen.setImageResource(R.drawable.mallama);
                break;
            case "BARBACOAS":
                holder.imagen.setImageResource(R.drawable.barbacoas);
                break;
            case "EL ROSARIO":
                holder.imagen.setImageResource(R.drawable.el_rosario);
                break;
            case "ILES":
                holder.imagen.setImageResource(R.drawable.iles);
                break;
            case  "GUAITARILLA":
                holder.imagen.setImageResource(R.drawable.guaitarilla);
                break;
            case "CUASPUD":
                holder.imagen.setImageResource(R.drawable.cuaspud);
                break;
            case "CUMBAL":
                holder.imagen.setImageResource(R.drawable.cumbal);
                break;
            case "IMUES":
                holder.imagen.setImageResource(R.drawable.la_tola);
                break;
            case  "EL PEÑOL":
                holder.imagen.setImageResource(R.drawable.el_rosario);
                break;
            case  "FRANCISCO PIZARRO":
                holder.imagen.setImageResource(R.drawable.mallama);
                break;
            case  "IPIALES":
                holder.imagen.setImageResource(R.drawable.ipiales);
                break;
            case  "LA TOLA":
                holder.imagen.setImageResource(R.drawable.la_tola);
                break;
            case "ANCUYA":
                holder.imagen.setImageResource(R.drawable.ancuya);
                break;

        }
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarLista(ArrayList<AlcaldiasPOJO> listaAutos) {
        dataset.addAll(listaAutos);
        notifyDataSetChanged();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        ImageView imagen;

        private TextView txtTipoMuni;

        private TextView txtCod;

        private LinearLayout layout;


        public PictureViewHolder(View itemView) {
            super(itemView);

            imagen   = (ImageView) itemView.findViewById(R.id.img_card);
            txtTipoMuni = (TextView) itemView.findViewById(R.id.txt_municipion);
            txtCod = (TextView) itemView.findViewById(R.id.txt_cod_mun);
            layout = (LinearLayout) itemView.findViewById(R.id.layout_text_card);

        }
    }


}
