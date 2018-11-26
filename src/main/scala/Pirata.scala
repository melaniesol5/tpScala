import scala.util.Random

abstract class Pirata() {
  var _energiaInicial = 0

  def poderDeMando(): Double

  def seHirio(unValor : Double): Unit

  def disminuirEnergia(unValor : Int): Unit = {
    _energiaInicial -= unValor
  }

  def tomarRonConJackSparrow(): Unit = {
    this.disminuirEnergia(50)
  }

  def energiaInicial_(unValor: Int):Unit = {
    _energiaInicial = unValor
  }

  def energiaInicial: Int = _energiaInicial

}

class Guerrero(var poderDePelea: Double, var vitalidad: Double) extends Pirata{

  override def poderDeMando(): Double = {
    poderDePelea * vitalidad
  }

  override def seHirio(unValor : Double): Unit = {
    poderDePelea *= unValor
  }
}

class Navegante(var inteligencia: Double) extends Pirata {

  override def poderDeMando(): Double = {
    inteligencia * inteligencia
  }

  override def seHirio(unValor: Double): Unit = {
    inteligencia *= unValor
  }

}

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

class Humanoide(var poderDePelea: Double) extends Pirata {

  override def poderDeMando(): Double = {
    _energiaInicial * poderDePelea
  }

  override def seHirio(unValor: Double): Unit = {
    poderDePelea *= unValor
  }

}