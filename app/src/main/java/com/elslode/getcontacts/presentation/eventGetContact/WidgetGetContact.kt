package com.elslode.getcontacts.presentation.eventGetContact

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.elslode.getcontacts.R
import com.elslode.getcontacts.domain.Contact

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class WidgetGetContact @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val nameOfUser: TextView
    private val numberOfUser: TextView
    private val uriOfUser: ImageView

    init {
        inflate(context, R.layout.view_get_contact, this)
        numberOfUser = findViewById(R.id.number_of_user)
        nameOfUser = findViewById(R.id.name_of_user)
        uriOfUser = findViewById(R.id.photo_of_user)
    }

    @ModelProp
    fun acceptData(data: Contact) {
        numberOfUser.text = data.number
        nameOfUser.text = data.name
        uriOfUser.setImageURI(Uri.parse(data.photoUri))
    }
}