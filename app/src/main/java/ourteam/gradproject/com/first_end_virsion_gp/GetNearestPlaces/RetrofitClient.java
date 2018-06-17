package ourteam.gradproject.com.first_end_virsion_gp.GetNearestPlaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yasser ahmed on 6/14/2018.
 */

public class RetrofitClient {
    private static Retrofit retrofit=null;
    public static Retrofit getclient(String baseUrl){
        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
