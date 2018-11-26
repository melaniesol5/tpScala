class Guerrero(var poderDePelea: Double, var vitalidad: Double) extends Pirata{

  override def poderDeMando(): Double = {
    poderDePelea * vitalidad
  }

  override def seHirio(unValor : Double): Unit = {
    poderDePelea *= unValor
  }
}