package alex.com.br.desafioinfoprice.rest;

import alex.com.br.desafioinfoprice.model.ProductList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetProductDataService {
    @GET("produto/maisvendidos")
    Call<ProductList> getProductData();
}
