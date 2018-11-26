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