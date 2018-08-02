package alex.com.br.desafioinfoprice.rest;

import alex.com.br.desafioinfoprice.model.BannerList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetBannerDataService {
    @GET("banner")
    Call<BannerList> getBannerData();
}
