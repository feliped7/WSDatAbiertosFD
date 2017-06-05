package felipediaz.wsdatabiertos.adapters.models;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import felipediaz.wsdatabiertos.R;
import felipediaz.wsdatabiertos.adapters.adapters.RecyclerViewAdapter;
import felipediaz.wsdatabiertos.adapters.datosAPI.AlcaldiaApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public final static String TAG = "Datos abiertos Colombia";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    private RecyclerViewAdapter adapterRecycler;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //conexion del objeto retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co/resource/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        recyclerView = (RecyclerView) findViewById(R.id.miRecycler);
        adapterRecycler = new RecyclerViewAdapter(this);
        recyclerView.setAdapter(adapterRecycler);
        recyclerView.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        obtenerDatosAlcaldias();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_grid:
                // use this in case of gridlayoutmanager
                mLayoutManager = new GridLayoutManager(this, 1);
                recyclerView.setLayoutManager(mLayoutManager);
                obtenerDatosAlcaldias();
                break;
            case R.id.item_horizontal:
                //horizontal linear layout
                mLayoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                recyclerView.setLayoutManager(mLayoutManager);
                obtenerDatosAlcaldias();
                break;

        }
        return super.onOptionsItemSelected(item);
    }



    private void obtenerDatosAlcaldias() {

        AlcaldiaApiService service = retrofit.create(AlcaldiaApiService.class);
        Call<List<AlcaldiasPOJO>> respuestaCall = service.obtenerListaAlcaldias();

        respuestaCall.enqueue(new Callback<List<AlcaldiasPOJO>>() {
            @Override
            public void onResponse(Call<List<AlcaldiasPOJO>> call, Response<List<AlcaldiasPOJO>> response) {
                if(response.isSuccessful()){

                    ArrayList<AlcaldiasPOJO> lista = (ArrayList<AlcaldiasPOJO>) response.body();
                    adapterRecycler.adicionarLista(lista);



                }else
                {
                    Log.e(TAG, "onResponse: "+response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<AlcaldiasPOJO>> call, Throwable t) {
                Log.e(TAG," onFailure: "+t.getMessage());
            }
        });
    }



}
