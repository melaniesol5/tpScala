import scala.util.Random

class Cocinero(var moral: Double, var listaDeIngredientes: List[String]) extends Pirata {

  override def poderDeMando(): Double = {
    moral * listaDeIngredientes.length
  }

  override def tomarRonConJackSparrow(): Unit = {
    this.disminuirEnergia(50)
    this.entregarIngredienteA()
  }

  override def seHirio(unValor: Double): Unit = {
    moral *= unValor
  }

  def entregarIngredienteA(): Unit = {
    val ingrediente = listaDeIngredientes(Random.nextInt(listaDeIngredientes.length))
    jackSparrow.recibirIngrediente(ingrediente)
    listaDeIngredientes = listaDeIngredientes.filter( unIngrediente => unIngrediente != ingrediente)
  }

  def cantidadDeIngredientes(): Int = {
    listaDeIngredientes.length
  }
}