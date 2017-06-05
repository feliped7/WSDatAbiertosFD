package felipediaz.wsdatabiertos.adapters.datosAPI;

import java.util.List;

import felipediaz.wsdatabiertos.adapters.models.AlcaldiasPOJO;
import retrofit2.Call;
import retrofit2.http.GET;


public interface AlcaldiaApiService {
    @GET("pfet-63uw.json")
    Call<List<AlcaldiasPOJO>> obtenerListaAlcaldias();


}
