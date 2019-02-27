package org.pursuit.fragmentinterfacereviewexercise.network;

import org.pursuit.fragmentinterfacereviewexercise.model.BaddieList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaddieService {
    @GET("pillmatictm/4b93b0b205ec43f63e1d6d727b8cd318/raw/a19763580227aea325270a8072e87a8628471f87/10%2520Black%2520baddies%2520for%2520Black%2520History%2520Month")
    Call<BaddieList> getBaddies();
}
