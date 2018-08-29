package codeone.com.br.mobile_gym_pass.features.all_objects.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Estado(
        @SerializedName("IdEstado")
        var idEstado:Int,
        @SerializedName("NmEstado")
        var nmEstado:String,
        @SerializedName("IdRegiao")
        var idRegiao:Int,
        @SerializedName("Localizacao")
        var localizacao: MutableList<Localizacao>
): Parcelable {
}