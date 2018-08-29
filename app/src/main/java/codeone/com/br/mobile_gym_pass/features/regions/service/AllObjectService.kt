package codeone.com.br.mobile_gym_pass.features.regions.service

import codeone.com.br.mobile_gym_pass.commons.constant.WebService
import codeone.com.br.mobile_gym_pass.commons.util.createRetrofitService
import codeone.com.br.mobile_gym_pass.features.regions.domain.Regiao
import retrofit2.Call
import retrofit2.http.GET

class AllObjectService {

    interface RetrofitService{
        @GET("api/values")
        fun getAllRegions(): Call<MutableList<Regiao>>

    }
    companion object Factory{
        @Throws
        fun getAllRegions():MutableList<Regiao>{
            val service = createRetrofitService<RetrofitService>(WebService.BASE_URL)
            val execute = service.getAllRegions().execute()
            val responseVO = execute.body()

            responseVO?.let {
                return it
            }
            throw Throwable("")
        }
    }
}