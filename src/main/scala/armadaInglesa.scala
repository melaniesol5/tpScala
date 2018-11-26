object armadaInglesa extends  Bando {

  override def bonus(unBarco: Barco): Unit = {
    unBarco.aumentarMuniciones(unBarco.municiones * 0.3)
  }
}