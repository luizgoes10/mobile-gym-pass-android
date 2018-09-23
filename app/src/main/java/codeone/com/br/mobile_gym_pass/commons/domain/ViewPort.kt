package codeone.com.br.mobile_gym_pass.commons.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewPort(
        @SerializedName("northeast")
        var northeast: Northeast,
        @SerializedName("southwest")
        var southwest: Southwest
):Parcelable {
}