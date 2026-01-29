import com.example.p4_madrid_marcos_jorge_alejandro.R
import com.example.p4_madrid_marcos_jorge_alejandro.model.Categoria
import com.example.p4_madrid_marcos_jorge_alejandro.model.Sport
import com.example.p4_madrid_marcos_jorge_alejandro.viewModels.deportesUiState

class SportRepository {

    fun onClickCard(deporte: Sport){
        deporte.isExpanded = !deporte.isExpanded
    }
    fun getSports(): List<Sport> {
        return listOf(

            // FÚTBOL
            Sport(
                categoria = Categoria.FUTBOL,
                nameRes = R.string.Titulo_realmadrid,
                descriptionRes = R.string.descripcion_realmadrid,
                imgRes = R.drawable.brenabeu

            ),
            Sport(
                categoria = Categoria.FUTBOL,
                nameRes = R.string.titulo_atletico,
                descriptionRes = R.string.descripcion_atleti,
                imgRes = R.drawable.wanda
            ),

            // BALONCESTO
            Sport(
                categoria = Categoria.BALONCESTO,
                nameRes = R.string.titulo_baloncesto,
                descriptionRes = R.string.descripcion_baloncesto,
                imgRes = R.drawable.wizinkbasket
            ),

            // ATLETISMO / RUNNING
            Sport(
                categoria = Categoria.ATLETISMO,
                nameRes = R.string.maraton,
                descriptionRes = R.string.descripcion_maraton,
                imgRes = R.drawable.maratonmadrid
            ),
            Sport(
                categoria = Categoria.ATLETISMO,
                nameRes = R.string.san_silvestre,
                descriptionRes = R.string.descripcion_sansil,
                imgRes = R.drawable.sansilvestre
            ),

            // TENIS
            Sport(
                categoria = Categoria.TENIS,
                nameRes = R.string.mutua,
                descriptionRes = R.string.descripcion_mutua,
                imgRes = R.drawable.mutuaopenmadrid_pista
            )
        )
    }
}


