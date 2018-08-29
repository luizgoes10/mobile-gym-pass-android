package codeone.com.br.mobile_gym_pass.features.regions.domain

import android.os.Parcelable
import codeone.com.br.mobile_gym_pass.features.company.domain.Empresa
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Localizacao(
        @SerializedName("IdLocalizacao")
        var idLocalizacao:Int,
        @SerializedName("NmLocalizacao")
        var nmLocalizacao:String,
        @SerializedName("IdEstado")
        var idEstado:Int,
        @SerializedName("Empresa")
        var empresa:MutableList<Empresa>
) :Parcelable{
}