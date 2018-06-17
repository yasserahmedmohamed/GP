package ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by yasser ahmed on 6/14/2018.
 */

public interface IGoogleApiService {
    @GET
    Call<NearestPlaces> getnearestplaces(@Url String url);
}
