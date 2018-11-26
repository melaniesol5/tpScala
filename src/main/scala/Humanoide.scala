class Humanoide(var poderDePelea: Double) extends Pirata {

  override def poderDeMando(): Double = {
    _energiaInicial * poderDePelea
  }

  override def seHirio(unValor: Double): Unit = {
    poderDePelea *= unValor
  }

}