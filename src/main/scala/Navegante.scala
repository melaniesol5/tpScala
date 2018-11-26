class Navegante(var inteligencia: Double) extends Pirata {

  override def poderDeMando(): Double = {
    inteligencia * inteligencia
  }

  override def seHirio(unValor: Double): Unit = {
    inteligencia *= unValor
  }

}